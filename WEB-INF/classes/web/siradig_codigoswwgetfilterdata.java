package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class siradig_codigoswwgetfilterdata extends GXProcedure
{
   public siradig_codigoswwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( siradig_codigoswwgetfilterdata.class ), "" );
   }

   public siradig_codigoswwgetfilterdata( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 )
   {
      siradig_codigoswwgetfilterdata.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String[] aP3 ,
                        String[] aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 )
   {
      siradig_codigoswwgetfilterdata.this.AV33DDOName = aP0;
      siradig_codigoswwgetfilterdata.this.AV34SearchTxt = aP1;
      siradig_codigoswwgetfilterdata.this.AV35SearchTxtTo = aP2;
      siradig_codigoswwgetfilterdata.this.aP3 = aP3;
      siradig_codigoswwgetfilterdata.this.aP4 = aP4;
      siradig_codigoswwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV40EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      siradig_codigoswwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV40EmpCod = GXt_int1 ;
      GXt_int3 = AV41CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      siradig_codigoswwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV41CliCod = GXt_int3 ;
      AV23Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV25OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV26OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWsiradig_codigos", GXv_boolean6) ;
      siradig_codigoswwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
      AV8IsAuthorized = GXt_boolean5 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext7[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext7) ;
         AV9WWPContext = GXv_SdtWWPContext7[0] ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(GXutil.upper( AV33DDOName), "DDO_SIRACODIGO") == 0 )
         {
            /* Execute user subroutine: 'LOADSIRACODIGOOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV33DDOName), "DDO_SIRACONCODIGO") == 0 )
         {
            /* Execute user subroutine: 'LOADSIRACONCODIGOOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV33DDOName), "DDO_SIRARELREF") == 0 )
         {
            /* Execute user subroutine: 'LOADSIRARELREFOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV36OptionsJson = AV23Options.toJSonString(false) ;
      AV37OptionsDescJson = AV25OptionsDesc.toJSonString(false) ;
      AV38OptionIndexesJson = AV26OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV28Session.getValue("siradig_codigosWWGridState"), "") == 0 )
      {
         AV30GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "siradig_codigosWWGridState"), null, null);
      }
      else
      {
         AV30GridState.fromxml(AV28Session.getValue("siradig_codigosWWGridState"), null, null);
      }
      AV48GXV1 = 1 ;
      while ( AV48GXV1 <= AV30GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV31GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV30GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV48GXV1));
         if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSIRATIPO_SEL") == 0 )
         {
            AV11TFSiraTipo_SelsJson = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV12TFSiraTipo_Sels.fromJSonString(AV11TFSiraTipo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSIRACODIGO") == 0 )
         {
            AV14TFSiraCodigo = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSIRACODIGO_SEL") == 0 )
         {
            AV13TFSiraCodigo_SelsJson = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV15TFSiraCodigo_Sels.fromJSonString(AV13TFSiraCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSIRACONCODIGO") == 0 )
         {
            AV17TFSiraConCodigo = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSIRACONCODIGO_SEL") == 0 )
         {
            AV16TFSiraConCodigo_SelsJson = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV18TFSiraConCodigo_Sels.fromJSonString(AV16TFSiraConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSIRAPROPOR") == 0 )
         {
            AV19TFSiraPropor = CommonUtil.decimalVal( AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV20TFSiraPropor_To = CommonUtil.decimalVal( AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSIRARELREF") == 0 )
         {
            AV44TFSiraRelRef = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSIRARELREF_SEL") == 0 )
         {
            AV43TFSiraRelRef_SelsJson = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV45TFSiraRelRef_Sels.fromJSonString(AV43TFSiraRelRef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV42MenuOpcCod = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV48GXV1 = (int)(AV48GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADSIRACODIGOOPTIONS' Routine */
      returnInSub = false ;
      AV14TFSiraCodigo = AV34SearchTxt ;
      AV15TFSiraCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV50Siradig_codigoswwds_1_tfsiratipo_sels = AV12TFSiraTipo_Sels ;
      AV51Siradig_codigoswwds_2_tfsiracodigo = AV14TFSiraCodigo ;
      AV52Siradig_codigoswwds_3_tfsiracodigo_sels = AV15TFSiraCodigo_Sels ;
      AV53Siradig_codigoswwds_4_tfsiraconcodigo = AV17TFSiraConCodigo ;
      AV54Siradig_codigoswwds_5_tfsiraconcodigo_sels = AV18TFSiraConCodigo_Sels ;
      AV55Siradig_codigoswwds_6_tfsirapropor = AV19TFSiraPropor ;
      AV56Siradig_codigoswwds_7_tfsirapropor_to = AV20TFSiraPropor_To ;
      AV57Siradig_codigoswwds_8_tfsirarelref = AV44TFSiraRelRef ;
      AV58Siradig_codigoswwds_9_tfsirarelref_sels = AV45TFSiraRelRef_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1101SiraTipo ,
                                           AV50Siradig_codigoswwds_1_tfsiratipo_sels ,
                                           A1102SiraCodigo ,
                                           AV52Siradig_codigoswwds_3_tfsiracodigo_sels ,
                                           A1100SiraConCodigo ,
                                           AV54Siradig_codigoswwds_5_tfsiraconcodigo_sels ,
                                           A2022SiraRelRef ,
                                           AV58Siradig_codigoswwds_9_tfsirarelref_sels ,
                                           Integer.valueOf(AV50Siradig_codigoswwds_1_tfsiratipo_sels.size()) ,
                                           Integer.valueOf(AV52Siradig_codigoswwds_3_tfsiracodigo_sels.size()) ,
                                           AV51Siradig_codigoswwds_2_tfsiracodigo ,
                                           Integer.valueOf(AV54Siradig_codigoswwds_5_tfsiraconcodigo_sels.size()) ,
                                           AV53Siradig_codigoswwds_4_tfsiraconcodigo ,
                                           AV55Siradig_codigoswwds_6_tfsirapropor ,
                                           AV56Siradig_codigoswwds_7_tfsirapropor_to ,
                                           Integer.valueOf(AV58Siradig_codigoswwds_9_tfsirarelref_sels.size()) ,
                                           AV57Siradig_codigoswwds_8_tfsirarelref ,
                                           A1103SiraPropor ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV41CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV51Siradig_codigoswwds_2_tfsiracodigo = GXutil.padr( GXutil.rtrim( AV51Siradig_codigoswwds_2_tfsiracodigo), 20, "%") ;
      lV53Siradig_codigoswwds_4_tfsiraconcodigo = GXutil.padr( GXutil.rtrim( AV53Siradig_codigoswwds_4_tfsiraconcodigo), 10, "%") ;
      lV57Siradig_codigoswwds_8_tfsirarelref = GXutil.concat( GXutil.rtrim( AV57Siradig_codigoswwds_8_tfsirarelref), "%", "") ;
      /* Using cursor P018B2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV41CliCod), lV51Siradig_codigoswwds_2_tfsiracodigo, lV53Siradig_codigoswwds_4_tfsiraconcodigo, AV55Siradig_codigoswwds_6_tfsirapropor, AV56Siradig_codigoswwds_7_tfsirapropor_to, lV57Siradig_codigoswwds_8_tfsirarelref});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk18B2 = false ;
         A3CliCod = P018B2_A3CliCod[0] ;
         A1102SiraCodigo = P018B2_A1102SiraCodigo[0] ;
         A2022SiraRelRef = P018B2_A2022SiraRelRef[0] ;
         n2022SiraRelRef = P018B2_n2022SiraRelRef[0] ;
         A1103SiraPropor = P018B2_A1103SiraPropor[0] ;
         A1100SiraConCodigo = P018B2_A1100SiraConCodigo[0] ;
         A1101SiraTipo = P018B2_A1101SiraTipo[0] ;
         AV27count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P018B2_A1102SiraCodigo[0], A1102SiraCodigo) == 0 ) )
         {
            brk18B2 = false ;
            A3CliCod = P018B2_A3CliCod[0] ;
            A1101SiraTipo = P018B2_A1101SiraTipo[0] ;
            AV27count = (long)(AV27count+1) ;
            brk18B2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A1102SiraCodigo)==0) )
         {
            AV22Option = A1102SiraCodigo ;
            AV23Options.add(AV22Option, 0);
            AV26OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV27count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV23Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk18B2 )
         {
            brk18B2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADSIRACONCODIGOOPTIONS' Routine */
      returnInSub = false ;
      AV17TFSiraConCodigo = AV34SearchTxt ;
      AV18TFSiraConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV50Siradig_codigoswwds_1_tfsiratipo_sels = AV12TFSiraTipo_Sels ;
      AV51Siradig_codigoswwds_2_tfsiracodigo = AV14TFSiraCodigo ;
      AV52Siradig_codigoswwds_3_tfsiracodigo_sels = AV15TFSiraCodigo_Sels ;
      AV53Siradig_codigoswwds_4_tfsiraconcodigo = AV17TFSiraConCodigo ;
      AV54Siradig_codigoswwds_5_tfsiraconcodigo_sels = AV18TFSiraConCodigo_Sels ;
      AV55Siradig_codigoswwds_6_tfsirapropor = AV19TFSiraPropor ;
      AV56Siradig_codigoswwds_7_tfsirapropor_to = AV20TFSiraPropor_To ;
      AV57Siradig_codigoswwds_8_tfsirarelref = AV44TFSiraRelRef ;
      AV58Siradig_codigoswwds_9_tfsirarelref_sels = AV45TFSiraRelRef_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A1101SiraTipo ,
                                           AV50Siradig_codigoswwds_1_tfsiratipo_sels ,
                                           A1102SiraCodigo ,
                                           AV52Siradig_codigoswwds_3_tfsiracodigo_sels ,
                                           A1100SiraConCodigo ,
                                           AV54Siradig_codigoswwds_5_tfsiraconcodigo_sels ,
                                           A2022SiraRelRef ,
                                           AV58Siradig_codigoswwds_9_tfsirarelref_sels ,
                                           Integer.valueOf(AV50Siradig_codigoswwds_1_tfsiratipo_sels.size()) ,
                                           Integer.valueOf(AV52Siradig_codigoswwds_3_tfsiracodigo_sels.size()) ,
                                           AV51Siradig_codigoswwds_2_tfsiracodigo ,
                                           Integer.valueOf(AV54Siradig_codigoswwds_5_tfsiraconcodigo_sels.size()) ,
                                           AV53Siradig_codigoswwds_4_tfsiraconcodigo ,
                                           AV55Siradig_codigoswwds_6_tfsirapropor ,
                                           AV56Siradig_codigoswwds_7_tfsirapropor_to ,
                                           Integer.valueOf(AV58Siradig_codigoswwds_9_tfsirarelref_sels.size()) ,
                                           AV57Siradig_codigoswwds_8_tfsirarelref ,
                                           A1103SiraPropor ,
                                           Integer.valueOf(AV41CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV51Siradig_codigoswwds_2_tfsiracodigo = GXutil.padr( GXutil.rtrim( AV51Siradig_codigoswwds_2_tfsiracodigo), 20, "%") ;
      lV53Siradig_codigoswwds_4_tfsiraconcodigo = GXutil.padr( GXutil.rtrim( AV53Siradig_codigoswwds_4_tfsiraconcodigo), 10, "%") ;
      lV57Siradig_codigoswwds_8_tfsirarelref = GXutil.concat( GXutil.rtrim( AV57Siradig_codigoswwds_8_tfsirarelref), "%", "") ;
      /* Using cursor P018B3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV41CliCod), lV51Siradig_codigoswwds_2_tfsiracodigo, lV53Siradig_codigoswwds_4_tfsiraconcodigo, AV55Siradig_codigoswwds_6_tfsirapropor, AV56Siradig_codigoswwds_7_tfsirapropor_to, lV57Siradig_codigoswwds_8_tfsirarelref});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk18B4 = false ;
         A3CliCod = P018B3_A3CliCod[0] ;
         A1100SiraConCodigo = P018B3_A1100SiraConCodigo[0] ;
         A2022SiraRelRef = P018B3_A2022SiraRelRef[0] ;
         n2022SiraRelRef = P018B3_n2022SiraRelRef[0] ;
         A1103SiraPropor = P018B3_A1103SiraPropor[0] ;
         A1102SiraCodigo = P018B3_A1102SiraCodigo[0] ;
         A1101SiraTipo = P018B3_A1101SiraTipo[0] ;
         AV27count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( P018B3_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P018B3_A1100SiraConCodigo[0], A1100SiraConCodigo) == 0 ) )
         {
            brk18B4 = false ;
            A1102SiraCodigo = P018B3_A1102SiraCodigo[0] ;
            A1101SiraTipo = P018B3_A1101SiraTipo[0] ;
            AV27count = (long)(AV27count+1) ;
            brk18B4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A1100SiraConCodigo)==0) )
         {
            AV22Option = A1100SiraConCodigo ;
            AV23Options.add(AV22Option, 0);
            AV26OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV27count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV23Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk18B4 )
         {
            brk18B4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADSIRARELREFOPTIONS' Routine */
      returnInSub = false ;
      AV44TFSiraRelRef = AV34SearchTxt ;
      AV45TFSiraRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV50Siradig_codigoswwds_1_tfsiratipo_sels = AV12TFSiraTipo_Sels ;
      AV51Siradig_codigoswwds_2_tfsiracodigo = AV14TFSiraCodigo ;
      AV52Siradig_codigoswwds_3_tfsiracodigo_sels = AV15TFSiraCodigo_Sels ;
      AV53Siradig_codigoswwds_4_tfsiraconcodigo = AV17TFSiraConCodigo ;
      AV54Siradig_codigoswwds_5_tfsiraconcodigo_sels = AV18TFSiraConCodigo_Sels ;
      AV55Siradig_codigoswwds_6_tfsirapropor = AV19TFSiraPropor ;
      AV56Siradig_codigoswwds_7_tfsirapropor_to = AV20TFSiraPropor_To ;
      AV57Siradig_codigoswwds_8_tfsirarelref = AV44TFSiraRelRef ;
      AV58Siradig_codigoswwds_9_tfsirarelref_sels = AV45TFSiraRelRef_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A1101SiraTipo ,
                                           AV50Siradig_codigoswwds_1_tfsiratipo_sels ,
                                           A1102SiraCodigo ,
                                           AV52Siradig_codigoswwds_3_tfsiracodigo_sels ,
                                           A1100SiraConCodigo ,
                                           AV54Siradig_codigoswwds_5_tfsiraconcodigo_sels ,
                                           A2022SiraRelRef ,
                                           AV58Siradig_codigoswwds_9_tfsirarelref_sels ,
                                           Integer.valueOf(AV50Siradig_codigoswwds_1_tfsiratipo_sels.size()) ,
                                           Integer.valueOf(AV52Siradig_codigoswwds_3_tfsiracodigo_sels.size()) ,
                                           AV51Siradig_codigoswwds_2_tfsiracodigo ,
                                           Integer.valueOf(AV54Siradig_codigoswwds_5_tfsiraconcodigo_sels.size()) ,
                                           AV53Siradig_codigoswwds_4_tfsiraconcodigo ,
                                           AV55Siradig_codigoswwds_6_tfsirapropor ,
                                           AV56Siradig_codigoswwds_7_tfsirapropor_to ,
                                           Integer.valueOf(AV58Siradig_codigoswwds_9_tfsirarelref_sels.size()) ,
                                           AV57Siradig_codigoswwds_8_tfsirarelref ,
                                           A1103SiraPropor ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV41CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV51Siradig_codigoswwds_2_tfsiracodigo = GXutil.padr( GXutil.rtrim( AV51Siradig_codigoswwds_2_tfsiracodigo), 20, "%") ;
      lV53Siradig_codigoswwds_4_tfsiraconcodigo = GXutil.padr( GXutil.rtrim( AV53Siradig_codigoswwds_4_tfsiraconcodigo), 10, "%") ;
      lV57Siradig_codigoswwds_8_tfsirarelref = GXutil.concat( GXutil.rtrim( AV57Siradig_codigoswwds_8_tfsirarelref), "%", "") ;
      /* Using cursor P018B4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV41CliCod), lV51Siradig_codigoswwds_2_tfsiracodigo, lV53Siradig_codigoswwds_4_tfsiraconcodigo, AV55Siradig_codigoswwds_6_tfsirapropor, AV56Siradig_codigoswwds_7_tfsirapropor_to, lV57Siradig_codigoswwds_8_tfsirarelref});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk18B6 = false ;
         A3CliCod = P018B4_A3CliCod[0] ;
         A2022SiraRelRef = P018B4_A2022SiraRelRef[0] ;
         n2022SiraRelRef = P018B4_n2022SiraRelRef[0] ;
         A1103SiraPropor = P018B4_A1103SiraPropor[0] ;
         A1100SiraConCodigo = P018B4_A1100SiraConCodigo[0] ;
         A1102SiraCodigo = P018B4_A1102SiraCodigo[0] ;
         A1101SiraTipo = P018B4_A1101SiraTipo[0] ;
         AV27count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P018B4_A2022SiraRelRef[0], A2022SiraRelRef) == 0 ) )
         {
            brk18B6 = false ;
            A3CliCod = P018B4_A3CliCod[0] ;
            A1102SiraCodigo = P018B4_A1102SiraCodigo[0] ;
            A1101SiraTipo = P018B4_A1101SiraTipo[0] ;
            AV27count = (long)(AV27count+1) ;
            brk18B6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A2022SiraRelRef)==0) )
         {
            AV22Option = A2022SiraRelRef ;
            AV23Options.add(AV22Option, 0);
            AV26OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV27count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV23Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk18B6 )
         {
            brk18B6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = siradig_codigoswwgetfilterdata.this.AV36OptionsJson;
      this.aP4[0] = siradig_codigoswwgetfilterdata.this.AV37OptionsDescJson;
      this.aP5[0] = siradig_codigoswwgetfilterdata.this.AV38OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV36OptionsJson = "" ;
      AV37OptionsDescJson = "" ;
      AV38OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV23Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV25OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV26OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV28Session = httpContext.getWebSession();
      AV30GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV31GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV11TFSiraTipo_SelsJson = "" ;
      AV12TFSiraTipo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV14TFSiraCodigo = "" ;
      AV13TFSiraCodigo_SelsJson = "" ;
      AV15TFSiraCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV17TFSiraConCodigo = "" ;
      AV16TFSiraConCodigo_SelsJson = "" ;
      AV18TFSiraConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV19TFSiraPropor = DecimalUtil.ZERO ;
      AV20TFSiraPropor_To = DecimalUtil.ZERO ;
      AV44TFSiraRelRef = "" ;
      AV43TFSiraRelRef_SelsJson = "" ;
      AV45TFSiraRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42MenuOpcCod = "" ;
      A1102SiraCodigo = "" ;
      AV50Siradig_codigoswwds_1_tfsiratipo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV51Siradig_codigoswwds_2_tfsiracodigo = "" ;
      AV52Siradig_codigoswwds_3_tfsiracodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV53Siradig_codigoswwds_4_tfsiraconcodigo = "" ;
      AV54Siradig_codigoswwds_5_tfsiraconcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV55Siradig_codigoswwds_6_tfsirapropor = DecimalUtil.ZERO ;
      AV56Siradig_codigoswwds_7_tfsirapropor_to = DecimalUtil.ZERO ;
      AV57Siradig_codigoswwds_8_tfsirarelref = "" ;
      AV58Siradig_codigoswwds_9_tfsirarelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV51Siradig_codigoswwds_2_tfsiracodigo = "" ;
      lV53Siradig_codigoswwds_4_tfsiraconcodigo = "" ;
      lV57Siradig_codigoswwds_8_tfsirarelref = "" ;
      A1101SiraTipo = "" ;
      A1100SiraConCodigo = "" ;
      A2022SiraRelRef = "" ;
      A1103SiraPropor = DecimalUtil.ZERO ;
      P018B2_A3CliCod = new int[1] ;
      P018B2_A1102SiraCodigo = new String[] {""} ;
      P018B2_A2022SiraRelRef = new String[] {""} ;
      P018B2_n2022SiraRelRef = new boolean[] {false} ;
      P018B2_A1103SiraPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P018B2_A1100SiraConCodigo = new String[] {""} ;
      P018B2_A1101SiraTipo = new String[] {""} ;
      AV22Option = "" ;
      P018B3_A3CliCod = new int[1] ;
      P018B3_A1100SiraConCodigo = new String[] {""} ;
      P018B3_A2022SiraRelRef = new String[] {""} ;
      P018B3_n2022SiraRelRef = new boolean[] {false} ;
      P018B3_A1103SiraPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P018B3_A1102SiraCodigo = new String[] {""} ;
      P018B3_A1101SiraTipo = new String[] {""} ;
      P018B4_A3CliCod = new int[1] ;
      P018B4_A2022SiraRelRef = new String[] {""} ;
      P018B4_n2022SiraRelRef = new boolean[] {false} ;
      P018B4_A1103SiraPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P018B4_A1100SiraConCodigo = new String[] {""} ;
      P018B4_A1102SiraCodigo = new String[] {""} ;
      P018B4_A1101SiraTipo = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.siradig_codigoswwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P018B2_A3CliCod, P018B2_A1102SiraCodigo, P018B2_A2022SiraRelRef, P018B2_n2022SiraRelRef, P018B2_A1103SiraPropor, P018B2_A1100SiraConCodigo, P018B2_A1101SiraTipo
            }
            , new Object[] {
            P018B3_A3CliCod, P018B3_A1100SiraConCodigo, P018B3_A2022SiraRelRef, P018B3_n2022SiraRelRef, P018B3_A1103SiraPropor, P018B3_A1102SiraCodigo, P018B3_A1101SiraTipo
            }
            , new Object[] {
            P018B4_A3CliCod, P018B4_A2022SiraRelRef, P018B4_n2022SiraRelRef, P018B4_A1103SiraPropor, P018B4_A1100SiraConCodigo, P018B4_A1102SiraCodigo, P018B4_A1101SiraTipo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV40EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV41CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV48GXV1 ;
   private int AV50Siradig_codigoswwds_1_tfsiratipo_sels_size ;
   private int AV52Siradig_codigoswwds_3_tfsiracodigo_sels_size ;
   private int AV54Siradig_codigoswwds_5_tfsiraconcodigo_sels_size ;
   private int AV58Siradig_codigoswwds_9_tfsirarelref_sels_size ;
   private int A3CliCod ;
   private long AV27count ;
   private java.math.BigDecimal AV19TFSiraPropor ;
   private java.math.BigDecimal AV20TFSiraPropor_To ;
   private java.math.BigDecimal AV55Siradig_codigoswwds_6_tfsirapropor ;
   private java.math.BigDecimal AV56Siradig_codigoswwds_7_tfsirapropor_to ;
   private java.math.BigDecimal A1103SiraPropor ;
   private String AV14TFSiraCodigo ;
   private String AV17TFSiraConCodigo ;
   private String A1102SiraCodigo ;
   private String AV51Siradig_codigoswwds_2_tfsiracodigo ;
   private String AV53Siradig_codigoswwds_4_tfsiraconcodigo ;
   private String scmdbuf ;
   private String lV51Siradig_codigoswwds_2_tfsiracodigo ;
   private String lV53Siradig_codigoswwds_4_tfsiraconcodigo ;
   private String A1101SiraTipo ;
   private String A1100SiraConCodigo ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk18B2 ;
   private boolean n2022SiraRelRef ;
   private boolean brk18B4 ;
   private boolean brk18B6 ;
   private String AV36OptionsJson ;
   private String AV37OptionsDescJson ;
   private String AV38OptionIndexesJson ;
   private String AV11TFSiraTipo_SelsJson ;
   private String AV13TFSiraCodigo_SelsJson ;
   private String AV16TFSiraConCodigo_SelsJson ;
   private String AV43TFSiraRelRef_SelsJson ;
   private String AV33DDOName ;
   private String AV34SearchTxt ;
   private String AV35SearchTxtTo ;
   private String AV44TFSiraRelRef ;
   private String AV42MenuOpcCod ;
   private String AV57Siradig_codigoswwds_8_tfsirarelref ;
   private String lV57Siradig_codigoswwds_8_tfsirarelref ;
   private String A2022SiraRelRef ;
   private String AV22Option ;
   private com.genexus.webpanels.WebSession AV28Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P018B2_A3CliCod ;
   private String[] P018B2_A1102SiraCodigo ;
   private String[] P018B2_A2022SiraRelRef ;
   private boolean[] P018B2_n2022SiraRelRef ;
   private java.math.BigDecimal[] P018B2_A1103SiraPropor ;
   private String[] P018B2_A1100SiraConCodigo ;
   private String[] P018B2_A1101SiraTipo ;
   private int[] P018B3_A3CliCod ;
   private String[] P018B3_A1100SiraConCodigo ;
   private String[] P018B3_A2022SiraRelRef ;
   private boolean[] P018B3_n2022SiraRelRef ;
   private java.math.BigDecimal[] P018B3_A1103SiraPropor ;
   private String[] P018B3_A1102SiraCodigo ;
   private String[] P018B3_A1101SiraTipo ;
   private int[] P018B4_A3CliCod ;
   private String[] P018B4_A2022SiraRelRef ;
   private boolean[] P018B4_n2022SiraRelRef ;
   private java.math.BigDecimal[] P018B4_A1103SiraPropor ;
   private String[] P018B4_A1100SiraConCodigo ;
   private String[] P018B4_A1102SiraCodigo ;
   private String[] P018B4_A1101SiraTipo ;
   private GXSimpleCollection<String> AV12TFSiraTipo_Sels ;
   private GXSimpleCollection<String> AV15TFSiraCodigo_Sels ;
   private GXSimpleCollection<String> AV18TFSiraConCodigo_Sels ;
   private GXSimpleCollection<String> AV50Siradig_codigoswwds_1_tfsiratipo_sels ;
   private GXSimpleCollection<String> AV52Siradig_codigoswwds_3_tfsiracodigo_sels ;
   private GXSimpleCollection<String> AV54Siradig_codigoswwds_5_tfsiraconcodigo_sels ;
   private GXSimpleCollection<String> AV23Options ;
   private GXSimpleCollection<String> AV25OptionsDesc ;
   private GXSimpleCollection<String> AV26OptionIndexes ;
   private GXSimpleCollection<String> AV45TFSiraRelRef_Sels ;
   private GXSimpleCollection<String> AV58Siradig_codigoswwds_9_tfsirarelref_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV30GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV31GridStateFilterValue ;
}

final  class siradig_codigoswwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P018B2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1101SiraTipo ,
                                          GXSimpleCollection<String> AV50Siradig_codigoswwds_1_tfsiratipo_sels ,
                                          String A1102SiraCodigo ,
                                          GXSimpleCollection<String> AV52Siradig_codigoswwds_3_tfsiracodigo_sels ,
                                          String A1100SiraConCodigo ,
                                          GXSimpleCollection<String> AV54Siradig_codigoswwds_5_tfsiraconcodigo_sels ,
                                          String A2022SiraRelRef ,
                                          GXSimpleCollection<String> AV58Siradig_codigoswwds_9_tfsirarelref_sels ,
                                          int AV50Siradig_codigoswwds_1_tfsiratipo_sels_size ,
                                          int AV52Siradig_codigoswwds_3_tfsiracodigo_sels_size ,
                                          String AV51Siradig_codigoswwds_2_tfsiracodigo ,
                                          int AV54Siradig_codigoswwds_5_tfsiraconcodigo_sels_size ,
                                          String AV53Siradig_codigoswwds_4_tfsiraconcodigo ,
                                          java.math.BigDecimal AV55Siradig_codigoswwds_6_tfsirapropor ,
                                          java.math.BigDecimal AV56Siradig_codigoswwds_7_tfsirapropor_to ,
                                          int AV58Siradig_codigoswwds_9_tfsirarelref_sels_size ,
                                          String AV57Siradig_codigoswwds_8_tfsirarelref ,
                                          java.math.BigDecimal A1103SiraPropor ,
                                          int A3CliCod ,
                                          int AV41CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[6];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliCod, SiraCodigo, SiraRelRef, SiraPropor, SiraConCodigo, SiraTipo FROM siradig_codigos" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( AV50Siradig_codigoswwds_1_tfsiratipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV50Siradig_codigoswwds_1_tfsiratipo_sels, "SiraTipo IN (", ")")+")");
      }
      if ( ( AV52Siradig_codigoswwds_3_tfsiracodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV51Siradig_codigoswwds_2_tfsiracodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SiraCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV52Siradig_codigoswwds_3_tfsiracodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV52Siradig_codigoswwds_3_tfsiracodigo_sels, "SiraCodigo IN (", ")")+")");
      }
      if ( ( AV54Siradig_codigoswwds_5_tfsiraconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV53Siradig_codigoswwds_4_tfsiraconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SiraConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV54Siradig_codigoswwds_5_tfsiraconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV54Siradig_codigoswwds_5_tfsiraconcodigo_sels, "SiraConCodigo IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV55Siradig_codigoswwds_6_tfsirapropor)==0) )
      {
         addWhere(sWhereString, "(SiraPropor >= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV56Siradig_codigoswwds_7_tfsirapropor_to)==0) )
      {
         addWhere(sWhereString, "(SiraPropor <= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( ( AV58Siradig_codigoswwds_9_tfsirarelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV57Siradig_codigoswwds_8_tfsirarelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SiraRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( AV58Siradig_codigoswwds_9_tfsirarelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58Siradig_codigoswwds_9_tfsirarelref_sels, "SiraRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY SiraCodigo" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P018B3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1101SiraTipo ,
                                          GXSimpleCollection<String> AV50Siradig_codigoswwds_1_tfsiratipo_sels ,
                                          String A1102SiraCodigo ,
                                          GXSimpleCollection<String> AV52Siradig_codigoswwds_3_tfsiracodigo_sels ,
                                          String A1100SiraConCodigo ,
                                          GXSimpleCollection<String> AV54Siradig_codigoswwds_5_tfsiraconcodigo_sels ,
                                          String A2022SiraRelRef ,
                                          GXSimpleCollection<String> AV58Siradig_codigoswwds_9_tfsirarelref_sels ,
                                          int AV50Siradig_codigoswwds_1_tfsiratipo_sels_size ,
                                          int AV52Siradig_codigoswwds_3_tfsiracodigo_sels_size ,
                                          String AV51Siradig_codigoswwds_2_tfsiracodigo ,
                                          int AV54Siradig_codigoswwds_5_tfsiraconcodigo_sels_size ,
                                          String AV53Siradig_codigoswwds_4_tfsiraconcodigo ,
                                          java.math.BigDecimal AV55Siradig_codigoswwds_6_tfsirapropor ,
                                          java.math.BigDecimal AV56Siradig_codigoswwds_7_tfsirapropor_to ,
                                          int AV58Siradig_codigoswwds_9_tfsirarelref_sels_size ,
                                          String AV57Siradig_codigoswwds_8_tfsirarelref ,
                                          java.math.BigDecimal A1103SiraPropor ,
                                          int AV41CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[6];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT CliCod, SiraConCodigo, SiraRelRef, SiraPropor, SiraCodigo, SiraTipo FROM siradig_codigos" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( AV50Siradig_codigoswwds_1_tfsiratipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV50Siradig_codigoswwds_1_tfsiratipo_sels, "SiraTipo IN (", ")")+")");
      }
      if ( ( AV52Siradig_codigoswwds_3_tfsiracodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV51Siradig_codigoswwds_2_tfsiracodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SiraCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV52Siradig_codigoswwds_3_tfsiracodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV52Siradig_codigoswwds_3_tfsiracodigo_sels, "SiraCodigo IN (", ")")+")");
      }
      if ( ( AV54Siradig_codigoswwds_5_tfsiraconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV53Siradig_codigoswwds_4_tfsiraconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SiraConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV54Siradig_codigoswwds_5_tfsiraconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV54Siradig_codigoswwds_5_tfsiraconcodigo_sels, "SiraConCodigo IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV55Siradig_codigoswwds_6_tfsirapropor)==0) )
      {
         addWhere(sWhereString, "(SiraPropor >= ?)");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV56Siradig_codigoswwds_7_tfsirapropor_to)==0) )
      {
         addWhere(sWhereString, "(SiraPropor <= ?)");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( ( AV58Siradig_codigoswwds_9_tfsirarelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV57Siradig_codigoswwds_8_tfsirarelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SiraRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( AV58Siradig_codigoswwds_9_tfsirarelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58Siradig_codigoswwds_9_tfsirarelref_sels, "SiraRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, SiraConCodigo" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P018B4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1101SiraTipo ,
                                          GXSimpleCollection<String> AV50Siradig_codigoswwds_1_tfsiratipo_sels ,
                                          String A1102SiraCodigo ,
                                          GXSimpleCollection<String> AV52Siradig_codigoswwds_3_tfsiracodigo_sels ,
                                          String A1100SiraConCodigo ,
                                          GXSimpleCollection<String> AV54Siradig_codigoswwds_5_tfsiraconcodigo_sels ,
                                          String A2022SiraRelRef ,
                                          GXSimpleCollection<String> AV58Siradig_codigoswwds_9_tfsirarelref_sels ,
                                          int AV50Siradig_codigoswwds_1_tfsiratipo_sels_size ,
                                          int AV52Siradig_codigoswwds_3_tfsiracodigo_sels_size ,
                                          String AV51Siradig_codigoswwds_2_tfsiracodigo ,
                                          int AV54Siradig_codigoswwds_5_tfsiraconcodigo_sels_size ,
                                          String AV53Siradig_codigoswwds_4_tfsiraconcodigo ,
                                          java.math.BigDecimal AV55Siradig_codigoswwds_6_tfsirapropor ,
                                          java.math.BigDecimal AV56Siradig_codigoswwds_7_tfsirapropor_to ,
                                          int AV58Siradig_codigoswwds_9_tfsirarelref_sels_size ,
                                          String AV57Siradig_codigoswwds_8_tfsirarelref ,
                                          java.math.BigDecimal A1103SiraPropor ,
                                          int A3CliCod ,
                                          int AV41CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[6];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT CliCod, SiraRelRef, SiraPropor, SiraConCodigo, SiraCodigo, SiraTipo FROM siradig_codigos" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( AV50Siradig_codigoswwds_1_tfsiratipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV50Siradig_codigoswwds_1_tfsiratipo_sels, "SiraTipo IN (", ")")+")");
      }
      if ( ( AV52Siradig_codigoswwds_3_tfsiracodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV51Siradig_codigoswwds_2_tfsiracodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SiraCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int14[1] = (byte)(1) ;
      }
      if ( AV52Siradig_codigoswwds_3_tfsiracodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV52Siradig_codigoswwds_3_tfsiracodigo_sels, "SiraCodigo IN (", ")")+")");
      }
      if ( ( AV54Siradig_codigoswwds_5_tfsiraconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV53Siradig_codigoswwds_4_tfsiraconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SiraConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( AV54Siradig_codigoswwds_5_tfsiraconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV54Siradig_codigoswwds_5_tfsiraconcodigo_sels, "SiraConCodigo IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV55Siradig_codigoswwds_6_tfsirapropor)==0) )
      {
         addWhere(sWhereString, "(SiraPropor >= ?)");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV56Siradig_codigoswwds_7_tfsirapropor_to)==0) )
      {
         addWhere(sWhereString, "(SiraPropor <= ?)");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( ( AV58Siradig_codigoswwds_9_tfsirarelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV57Siradig_codigoswwds_8_tfsirarelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SiraRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int14[5] = (byte)(1) ;
      }
      if ( AV58Siradig_codigoswwds_9_tfsirarelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58Siradig_codigoswwds_9_tfsirarelref_sels, "SiraRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY SiraRelRef" ;
      GXv_Object15[0] = scmdbuf ;
      GXv_Object15[1] = GXv_int14 ;
      return GXv_Object15 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P018B2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).intValue() );
            case 1 :
                  return conditional_P018B3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).intValue() );
            case 2 :
                  return conditional_P018B4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P018B2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P018B3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P018B4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(4,4);
               ((String[]) buf[5])[0] = rslt.getString(5, 10);
               ((String[]) buf[6])[0] = rslt.getString(6, 3);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(4,4);
               ((String[]) buf[5])[0] = rslt.getString(5, 20);
               ((String[]) buf[6])[0] = rslt.getString(6, 3);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(3,4);
               ((String[]) buf[4])[0] = rslt.getString(4, 10);
               ((String[]) buf[5])[0] = rslt.getString(5, 20);
               ((String[]) buf[6])[0] = rslt.getString(6, 3);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[7], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[8], 10);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[9], 4);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[10], 4);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[7], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[8], 10);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[9], 4);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[10], 4);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[7], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[8], 10);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[9], 4);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[10], 4);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               return;
      }
   }

}

