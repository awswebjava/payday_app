package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class puestowwgetfilterdata extends GXProcedure
{
   public puestowwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( puestowwgetfilterdata.class ), "" );
   }

   public puestowwgetfilterdata( int remoteHandle ,
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
      puestowwgetfilterdata.this.aP5 = new String[] {""};
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
      puestowwgetfilterdata.this.AV28DDOName = aP0;
      puestowwgetfilterdata.this.AV29SearchTxt = aP1;
      puestowwgetfilterdata.this.AV30SearchTxtTo = aP2;
      puestowwgetfilterdata.this.aP3 = aP3;
      puestowwgetfilterdata.this.aP4 = aP4;
      puestowwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV35EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      puestowwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV35EmpCod = GXt_int1 ;
      GXt_int3 = AV36CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      puestowwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV36CliCod = GXt_int3 ;
      AV18Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV20OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV21OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPuesto", GXv_boolean6) ;
      puestowwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV28DDOName), "DDO_SECDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADSECDESCRIPOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV28DDOName), "DDO_PUESTOCODIGO") == 0 )
         {
            /* Execute user subroutine: 'LOADPUESTOCODIGOOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV28DDOName), "DDO_PUESTODESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADPUESTODESCRIPOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV31OptionsJson = AV18Options.toJSonString(false) ;
      AV32OptionsDescJson = AV20OptionsDesc.toJSonString(false) ;
      AV33OptionIndexesJson = AV21OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV23Session.getValue("PuestoWWGridState"), "") == 0 )
      {
         AV25GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "PuestoWWGridState"), null, null);
      }
      else
      {
         AV25GridState.fromxml(AV23Session.getValue("PuestoWWGridState"), null, null);
      }
      AV46GXV1 = 1 ;
      while ( AV46GXV1 <= AV25GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV26GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV25GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV46GXV1));
         if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECDESCRIP") == 0 )
         {
            AV40TFSecDescrip = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECDESCRIP_SEL") == 0 )
         {
            AV39TFSecDescrip_SelsJson = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV41TFSecDescrip_Sels.fromJSonString(AV39TFSecDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPUESTOCODIGO") == 0 )
         {
            AV11TFPuestoCodigo = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPUESTOCODIGO_SEL") == 0 )
         {
            AV37TFPuestoCodigo_SelsJson = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV38TFPuestoCodigo_Sels.fromJSonString(AV37TFPuestoCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPUESTODESCRIP") == 0 )
         {
            AV14TFPuestoDescrip = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPUESTODESCRIP_SEL") == 0 )
         {
            AV13TFPuestoDescrip_SelsJson = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV15TFPuestoDescrip_Sels.fromJSonString(AV13TFPuestoDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPUESTOHORASEXT_SEL") == 0 )
         {
            AV42TFPuestoHorasExt_Sel = (byte)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV43MenuOpcCod = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV46GXV1 = (int)(AV46GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADSECDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV40TFSecDescrip = AV29SearchTxt ;
      AV41TFSecDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV48Puestowwds_1_tfsecdescrip = AV40TFSecDescrip ;
      AV49Puestowwds_2_tfsecdescrip_sels = AV41TFSecDescrip_Sels ;
      AV50Puestowwds_3_tfpuestocodigo = AV11TFPuestoCodigo ;
      AV51Puestowwds_4_tfpuestocodigo_sels = AV38TFPuestoCodigo_Sels ;
      AV52Puestowwds_5_tfpuestodescrip = AV14TFPuestoDescrip ;
      AV53Puestowwds_6_tfpuestodescrip_sels = AV15TFPuestoDescrip_Sels ;
      AV54Puestowwds_7_tfpuestohorasext_sel = AV42TFPuestoHorasExt_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A329SecDescrip ,
                                           AV49Puestowwds_2_tfsecdescrip_sels ,
                                           A1240PuestoCodigo ,
                                           AV51Puestowwds_4_tfpuestocodigo_sels ,
                                           A1241PuestoDescrip ,
                                           AV53Puestowwds_6_tfpuestodescrip_sels ,
                                           Integer.valueOf(AV49Puestowwds_2_tfsecdescrip_sels.size()) ,
                                           AV48Puestowwds_1_tfsecdescrip ,
                                           Integer.valueOf(AV51Puestowwds_4_tfpuestocodigo_sels.size()) ,
                                           AV50Puestowwds_3_tfpuestocodigo ,
                                           Integer.valueOf(AV53Puestowwds_6_tfpuestodescrip_sels.size()) ,
                                           AV52Puestowwds_5_tfpuestodescrip ,
                                           Byte.valueOf(AV54Puestowwds_7_tfpuestohorasext_sel) ,
                                           Boolean.valueOf(A1255PuestoHorasExt) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV36CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV48Puestowwds_1_tfsecdescrip = GXutil.concat( GXutil.rtrim( AV48Puestowwds_1_tfsecdescrip), "%", "") ;
      lV50Puestowwds_3_tfpuestocodigo = GXutil.padr( GXutil.rtrim( AV50Puestowwds_3_tfpuestocodigo), 20, "%") ;
      lV52Puestowwds_5_tfpuestodescrip = GXutil.concat( GXutil.rtrim( AV52Puestowwds_5_tfpuestodescrip), "%", "") ;
      /* Using cursor P01BK2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV36CliCod), lV48Puestowwds_1_tfsecdescrip, lV50Puestowwds_3_tfpuestocodigo, lV52Puestowwds_5_tfpuestodescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1BK2 = false ;
         A13SecCodigo = P01BK2_A13SecCodigo[0] ;
         A3CliCod = P01BK2_A3CliCod[0] ;
         A329SecDescrip = P01BK2_A329SecDescrip[0] ;
         A1255PuestoHorasExt = P01BK2_A1255PuestoHorasExt[0] ;
         A1241PuestoDescrip = P01BK2_A1241PuestoDescrip[0] ;
         A1240PuestoCodigo = P01BK2_A1240PuestoCodigo[0] ;
         A329SecDescrip = P01BK2_A329SecDescrip[0] ;
         AV22count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P01BK2_A329SecDescrip[0], A329SecDescrip) == 0 ) )
         {
            brk1BK2 = false ;
            A13SecCodigo = P01BK2_A13SecCodigo[0] ;
            A3CliCod = P01BK2_A3CliCod[0] ;
            A1240PuestoCodigo = P01BK2_A1240PuestoCodigo[0] ;
            AV22count = (long)(AV22count+1) ;
            brk1BK2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A329SecDescrip)==0) )
         {
            AV17Option = A329SecDescrip ;
            AV18Options.add(AV17Option, 0);
            AV21OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV22count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV18Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1BK2 )
         {
            brk1BK2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADPUESTOCODIGOOPTIONS' Routine */
      returnInSub = false ;
      AV11TFPuestoCodigo = AV29SearchTxt ;
      AV38TFPuestoCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV48Puestowwds_1_tfsecdescrip = AV40TFSecDescrip ;
      AV49Puestowwds_2_tfsecdescrip_sels = AV41TFSecDescrip_Sels ;
      AV50Puestowwds_3_tfpuestocodigo = AV11TFPuestoCodigo ;
      AV51Puestowwds_4_tfpuestocodigo_sels = AV38TFPuestoCodigo_Sels ;
      AV52Puestowwds_5_tfpuestodescrip = AV14TFPuestoDescrip ;
      AV53Puestowwds_6_tfpuestodescrip_sels = AV15TFPuestoDescrip_Sels ;
      AV54Puestowwds_7_tfpuestohorasext_sel = AV42TFPuestoHorasExt_Sel ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A329SecDescrip ,
                                           AV49Puestowwds_2_tfsecdescrip_sels ,
                                           A1240PuestoCodigo ,
                                           AV51Puestowwds_4_tfpuestocodigo_sels ,
                                           A1241PuestoDescrip ,
                                           AV53Puestowwds_6_tfpuestodescrip_sels ,
                                           Integer.valueOf(AV49Puestowwds_2_tfsecdescrip_sels.size()) ,
                                           AV48Puestowwds_1_tfsecdescrip ,
                                           Integer.valueOf(AV51Puestowwds_4_tfpuestocodigo_sels.size()) ,
                                           AV50Puestowwds_3_tfpuestocodigo ,
                                           Integer.valueOf(AV53Puestowwds_6_tfpuestodescrip_sels.size()) ,
                                           AV52Puestowwds_5_tfpuestodescrip ,
                                           Byte.valueOf(AV54Puestowwds_7_tfpuestohorasext_sel) ,
                                           Boolean.valueOf(A1255PuestoHorasExt) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV36CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV48Puestowwds_1_tfsecdescrip = GXutil.concat( GXutil.rtrim( AV48Puestowwds_1_tfsecdescrip), "%", "") ;
      lV50Puestowwds_3_tfpuestocodigo = GXutil.padr( GXutil.rtrim( AV50Puestowwds_3_tfpuestocodigo), 20, "%") ;
      lV52Puestowwds_5_tfpuestodescrip = GXutil.concat( GXutil.rtrim( AV52Puestowwds_5_tfpuestodescrip), "%", "") ;
      /* Using cursor P01BK3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV36CliCod), lV48Puestowwds_1_tfsecdescrip, lV50Puestowwds_3_tfpuestocodigo, lV52Puestowwds_5_tfpuestodescrip});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1BK4 = false ;
         A13SecCodigo = P01BK3_A13SecCodigo[0] ;
         A3CliCod = P01BK3_A3CliCod[0] ;
         A1240PuestoCodigo = P01BK3_A1240PuestoCodigo[0] ;
         A1255PuestoHorasExt = P01BK3_A1255PuestoHorasExt[0] ;
         A1241PuestoDescrip = P01BK3_A1241PuestoDescrip[0] ;
         A329SecDescrip = P01BK3_A329SecDescrip[0] ;
         A329SecDescrip = P01BK3_A329SecDescrip[0] ;
         AV22count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P01BK3_A1240PuestoCodigo[0], A1240PuestoCodigo) == 0 ) )
         {
            brk1BK4 = false ;
            A13SecCodigo = P01BK3_A13SecCodigo[0] ;
            A3CliCod = P01BK3_A3CliCod[0] ;
            AV22count = (long)(AV22count+1) ;
            brk1BK4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A1240PuestoCodigo)==0) )
         {
            AV17Option = A1240PuestoCodigo ;
            AV18Options.add(AV17Option, 0);
            AV21OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV22count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV18Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1BK4 )
         {
            brk1BK4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADPUESTODESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV14TFPuestoDescrip = AV29SearchTxt ;
      AV15TFPuestoDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV48Puestowwds_1_tfsecdescrip = AV40TFSecDescrip ;
      AV49Puestowwds_2_tfsecdescrip_sels = AV41TFSecDescrip_Sels ;
      AV50Puestowwds_3_tfpuestocodigo = AV11TFPuestoCodigo ;
      AV51Puestowwds_4_tfpuestocodigo_sels = AV38TFPuestoCodigo_Sels ;
      AV52Puestowwds_5_tfpuestodescrip = AV14TFPuestoDescrip ;
      AV53Puestowwds_6_tfpuestodescrip_sels = AV15TFPuestoDescrip_Sels ;
      AV54Puestowwds_7_tfpuestohorasext_sel = AV42TFPuestoHorasExt_Sel ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A329SecDescrip ,
                                           AV49Puestowwds_2_tfsecdescrip_sels ,
                                           A1240PuestoCodigo ,
                                           AV51Puestowwds_4_tfpuestocodigo_sels ,
                                           A1241PuestoDescrip ,
                                           AV53Puestowwds_6_tfpuestodescrip_sels ,
                                           Integer.valueOf(AV49Puestowwds_2_tfsecdescrip_sels.size()) ,
                                           AV48Puestowwds_1_tfsecdescrip ,
                                           Integer.valueOf(AV51Puestowwds_4_tfpuestocodigo_sels.size()) ,
                                           AV50Puestowwds_3_tfpuestocodigo ,
                                           Integer.valueOf(AV53Puestowwds_6_tfpuestodescrip_sels.size()) ,
                                           AV52Puestowwds_5_tfpuestodescrip ,
                                           Byte.valueOf(AV54Puestowwds_7_tfpuestohorasext_sel) ,
                                           Boolean.valueOf(A1255PuestoHorasExt) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV36CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV48Puestowwds_1_tfsecdescrip = GXutil.concat( GXutil.rtrim( AV48Puestowwds_1_tfsecdescrip), "%", "") ;
      lV50Puestowwds_3_tfpuestocodigo = GXutil.padr( GXutil.rtrim( AV50Puestowwds_3_tfpuestocodigo), 20, "%") ;
      lV52Puestowwds_5_tfpuestodescrip = GXutil.concat( GXutil.rtrim( AV52Puestowwds_5_tfpuestodescrip), "%", "") ;
      /* Using cursor P01BK4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV36CliCod), lV48Puestowwds_1_tfsecdescrip, lV50Puestowwds_3_tfpuestocodigo, lV52Puestowwds_5_tfpuestodescrip});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk1BK6 = false ;
         A13SecCodigo = P01BK4_A13SecCodigo[0] ;
         A3CliCod = P01BK4_A3CliCod[0] ;
         A1241PuestoDescrip = P01BK4_A1241PuestoDescrip[0] ;
         A1255PuestoHorasExt = P01BK4_A1255PuestoHorasExt[0] ;
         A1240PuestoCodigo = P01BK4_A1240PuestoCodigo[0] ;
         A329SecDescrip = P01BK4_A329SecDescrip[0] ;
         A329SecDescrip = P01BK4_A329SecDescrip[0] ;
         AV22count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P01BK4_A1241PuestoDescrip[0], A1241PuestoDescrip) == 0 ) )
         {
            brk1BK6 = false ;
            A13SecCodigo = P01BK4_A13SecCodigo[0] ;
            A3CliCod = P01BK4_A3CliCod[0] ;
            A1240PuestoCodigo = P01BK4_A1240PuestoCodigo[0] ;
            AV22count = (long)(AV22count+1) ;
            brk1BK6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A1241PuestoDescrip)==0) )
         {
            AV17Option = A1241PuestoDescrip ;
            AV18Options.add(AV17Option, 0);
            AV21OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV22count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV18Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1BK6 )
         {
            brk1BK6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = puestowwgetfilterdata.this.AV31OptionsJson;
      this.aP4[0] = puestowwgetfilterdata.this.AV32OptionsDescJson;
      this.aP5[0] = puestowwgetfilterdata.this.AV33OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV31OptionsJson = "" ;
      AV32OptionsDescJson = "" ;
      AV33OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV18Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV20OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV21OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV23Session = httpContext.getWebSession();
      AV25GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV26GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV40TFSecDescrip = "" ;
      AV39TFSecDescrip_SelsJson = "" ;
      AV41TFSecDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV11TFPuestoCodigo = "" ;
      AV37TFPuestoCodigo_SelsJson = "" ;
      AV38TFPuestoCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV14TFPuestoDescrip = "" ;
      AV13TFPuestoDescrip_SelsJson = "" ;
      AV15TFPuestoDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43MenuOpcCod = "" ;
      A329SecDescrip = "" ;
      AV48Puestowwds_1_tfsecdescrip = "" ;
      AV49Puestowwds_2_tfsecdescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV50Puestowwds_3_tfpuestocodigo = "" ;
      AV51Puestowwds_4_tfpuestocodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV52Puestowwds_5_tfpuestodescrip = "" ;
      AV53Puestowwds_6_tfpuestodescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV48Puestowwds_1_tfsecdescrip = "" ;
      lV50Puestowwds_3_tfpuestocodigo = "" ;
      lV52Puestowwds_5_tfpuestodescrip = "" ;
      A1240PuestoCodigo = "" ;
      A1241PuestoDescrip = "" ;
      P01BK2_A13SecCodigo = new String[] {""} ;
      P01BK2_A3CliCod = new int[1] ;
      P01BK2_A329SecDescrip = new String[] {""} ;
      P01BK2_A1255PuestoHorasExt = new boolean[] {false} ;
      P01BK2_A1241PuestoDescrip = new String[] {""} ;
      P01BK2_A1240PuestoCodigo = new String[] {""} ;
      A13SecCodigo = "" ;
      AV17Option = "" ;
      P01BK3_A13SecCodigo = new String[] {""} ;
      P01BK3_A3CliCod = new int[1] ;
      P01BK3_A1240PuestoCodigo = new String[] {""} ;
      P01BK3_A1255PuestoHorasExt = new boolean[] {false} ;
      P01BK3_A1241PuestoDescrip = new String[] {""} ;
      P01BK3_A329SecDescrip = new String[] {""} ;
      P01BK4_A13SecCodigo = new String[] {""} ;
      P01BK4_A3CliCod = new int[1] ;
      P01BK4_A1241PuestoDescrip = new String[] {""} ;
      P01BK4_A1255PuestoHorasExt = new boolean[] {false} ;
      P01BK4_A1240PuestoCodigo = new String[] {""} ;
      P01BK4_A329SecDescrip = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.puestowwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01BK2_A13SecCodigo, P01BK2_A3CliCod, P01BK2_A329SecDescrip, P01BK2_A1255PuestoHorasExt, P01BK2_A1241PuestoDescrip, P01BK2_A1240PuestoCodigo
            }
            , new Object[] {
            P01BK3_A13SecCodigo, P01BK3_A3CliCod, P01BK3_A1240PuestoCodigo, P01BK3_A1255PuestoHorasExt, P01BK3_A1241PuestoDescrip, P01BK3_A329SecDescrip
            }
            , new Object[] {
            P01BK4_A13SecCodigo, P01BK4_A3CliCod, P01BK4_A1241PuestoDescrip, P01BK4_A1255PuestoHorasExt, P01BK4_A1240PuestoCodigo, P01BK4_A329SecDescrip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV42TFPuestoHorasExt_Sel ;
   private byte AV54Puestowwds_7_tfpuestohorasext_sel ;
   private short AV35EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV36CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV46GXV1 ;
   private int AV49Puestowwds_2_tfsecdescrip_sels_size ;
   private int AV51Puestowwds_4_tfpuestocodigo_sels_size ;
   private int AV53Puestowwds_6_tfpuestodescrip_sels_size ;
   private int A3CliCod ;
   private long AV22count ;
   private String AV11TFPuestoCodigo ;
   private String AV50Puestowwds_3_tfpuestocodigo ;
   private String scmdbuf ;
   private String lV50Puestowwds_3_tfpuestocodigo ;
   private String A1240PuestoCodigo ;
   private String A13SecCodigo ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean A1255PuestoHorasExt ;
   private boolean brk1BK2 ;
   private boolean brk1BK4 ;
   private boolean brk1BK6 ;
   private String AV31OptionsJson ;
   private String AV32OptionsDescJson ;
   private String AV33OptionIndexesJson ;
   private String AV39TFSecDescrip_SelsJson ;
   private String AV37TFPuestoCodigo_SelsJson ;
   private String AV13TFPuestoDescrip_SelsJson ;
   private String AV28DDOName ;
   private String AV29SearchTxt ;
   private String AV30SearchTxtTo ;
   private String AV40TFSecDescrip ;
   private String AV14TFPuestoDescrip ;
   private String AV43MenuOpcCod ;
   private String A329SecDescrip ;
   private String AV48Puestowwds_1_tfsecdescrip ;
   private String AV52Puestowwds_5_tfpuestodescrip ;
   private String lV48Puestowwds_1_tfsecdescrip ;
   private String lV52Puestowwds_5_tfpuestodescrip ;
   private String A1241PuestoDescrip ;
   private String AV17Option ;
   private com.genexus.webpanels.WebSession AV23Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01BK2_A13SecCodigo ;
   private int[] P01BK2_A3CliCod ;
   private String[] P01BK2_A329SecDescrip ;
   private boolean[] P01BK2_A1255PuestoHorasExt ;
   private String[] P01BK2_A1241PuestoDescrip ;
   private String[] P01BK2_A1240PuestoCodigo ;
   private String[] P01BK3_A13SecCodigo ;
   private int[] P01BK3_A3CliCod ;
   private String[] P01BK3_A1240PuestoCodigo ;
   private boolean[] P01BK3_A1255PuestoHorasExt ;
   private String[] P01BK3_A1241PuestoDescrip ;
   private String[] P01BK3_A329SecDescrip ;
   private String[] P01BK4_A13SecCodigo ;
   private int[] P01BK4_A3CliCod ;
   private String[] P01BK4_A1241PuestoDescrip ;
   private boolean[] P01BK4_A1255PuestoHorasExt ;
   private String[] P01BK4_A1240PuestoCodigo ;
   private String[] P01BK4_A329SecDescrip ;
   private GXSimpleCollection<String> AV38TFPuestoCodigo_Sels ;
   private GXSimpleCollection<String> AV51Puestowwds_4_tfpuestocodigo_sels ;
   private GXSimpleCollection<String> AV18Options ;
   private GXSimpleCollection<String> AV20OptionsDesc ;
   private GXSimpleCollection<String> AV21OptionIndexes ;
   private GXSimpleCollection<String> AV41TFSecDescrip_Sels ;
   private GXSimpleCollection<String> AV15TFPuestoDescrip_Sels ;
   private GXSimpleCollection<String> AV49Puestowwds_2_tfsecdescrip_sels ;
   private GXSimpleCollection<String> AV53Puestowwds_6_tfpuestodescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV25GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV26GridStateFilterValue ;
}

final  class puestowwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01BK2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A329SecDescrip ,
                                          GXSimpleCollection<String> AV49Puestowwds_2_tfsecdescrip_sels ,
                                          String A1240PuestoCodigo ,
                                          GXSimpleCollection<String> AV51Puestowwds_4_tfpuestocodigo_sels ,
                                          String A1241PuestoDescrip ,
                                          GXSimpleCollection<String> AV53Puestowwds_6_tfpuestodescrip_sels ,
                                          int AV49Puestowwds_2_tfsecdescrip_sels_size ,
                                          String AV48Puestowwds_1_tfsecdescrip ,
                                          int AV51Puestowwds_4_tfpuestocodigo_sels_size ,
                                          String AV50Puestowwds_3_tfpuestocodigo ,
                                          int AV53Puestowwds_6_tfpuestodescrip_sels_size ,
                                          String AV52Puestowwds_5_tfpuestodescrip ,
                                          byte AV54Puestowwds_7_tfpuestohorasext_sel ,
                                          boolean A1255PuestoHorasExt ,
                                          int A3CliCod ,
                                          int AV36CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[4];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT T1.SecCodigo, T1.CliCod, T2.SecDescrip, T1.PuestoHorasExt, T1.PuestoDescrip, T1.PuestoCodigo FROM (Puesto T1 INNER JOIN Seccion T2 ON T2.CliCod = T1.CliCod" ;
      scmdbuf += " AND T2.SecCodigo = T1.SecCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      if ( ( AV49Puestowwds_2_tfsecdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV48Puestowwds_1_tfsecdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.SecDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV49Puestowwds_2_tfsecdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV49Puestowwds_2_tfsecdescrip_sels, "T2.SecDescrip IN (", ")")+")");
      }
      if ( ( AV51Puestowwds_4_tfpuestocodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV50Puestowwds_3_tfpuestocodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.PuestoCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV51Puestowwds_4_tfpuestocodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV51Puestowwds_4_tfpuestocodigo_sels, "T1.PuestoCodigo IN (", ")")+")");
      }
      if ( ( AV53Puestowwds_6_tfpuestodescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52Puestowwds_5_tfpuestodescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.PuestoDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV53Puestowwds_6_tfpuestodescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Puestowwds_6_tfpuestodescrip_sels, "T1.PuestoDescrip IN (", ")")+")");
      }
      if ( AV54Puestowwds_7_tfpuestohorasext_sel == 1 )
      {
         addWhere(sWhereString, "(T1.PuestoHorasExt = TRUE)");
      }
      if ( AV54Puestowwds_7_tfpuestohorasext_sel == 2 )
      {
         addWhere(sWhereString, "(T1.PuestoHorasExt = FALSE)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T2.SecDescrip" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P01BK3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A329SecDescrip ,
                                          GXSimpleCollection<String> AV49Puestowwds_2_tfsecdescrip_sels ,
                                          String A1240PuestoCodigo ,
                                          GXSimpleCollection<String> AV51Puestowwds_4_tfpuestocodigo_sels ,
                                          String A1241PuestoDescrip ,
                                          GXSimpleCollection<String> AV53Puestowwds_6_tfpuestodescrip_sels ,
                                          int AV49Puestowwds_2_tfsecdescrip_sels_size ,
                                          String AV48Puestowwds_1_tfsecdescrip ,
                                          int AV51Puestowwds_4_tfpuestocodigo_sels_size ,
                                          String AV50Puestowwds_3_tfpuestocodigo ,
                                          int AV53Puestowwds_6_tfpuestodescrip_sels_size ,
                                          String AV52Puestowwds_5_tfpuestodescrip ,
                                          byte AV54Puestowwds_7_tfpuestohorasext_sel ,
                                          boolean A1255PuestoHorasExt ,
                                          int A3CliCod ,
                                          int AV36CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[4];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT T1.SecCodigo, T1.CliCod, T1.PuestoCodigo, T1.PuestoHorasExt, T1.PuestoDescrip, T2.SecDescrip FROM (Puesto T1 INNER JOIN Seccion T2 ON T2.CliCod = T1.CliCod" ;
      scmdbuf += " AND T2.SecCodigo = T1.SecCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      if ( ( AV49Puestowwds_2_tfsecdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV48Puestowwds_1_tfsecdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.SecDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV49Puestowwds_2_tfsecdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV49Puestowwds_2_tfsecdescrip_sels, "T2.SecDescrip IN (", ")")+")");
      }
      if ( ( AV51Puestowwds_4_tfpuestocodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV50Puestowwds_3_tfpuestocodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.PuestoCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV51Puestowwds_4_tfpuestocodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV51Puestowwds_4_tfpuestocodigo_sels, "T1.PuestoCodigo IN (", ")")+")");
      }
      if ( ( AV53Puestowwds_6_tfpuestodescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52Puestowwds_5_tfpuestodescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.PuestoDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV53Puestowwds_6_tfpuestodescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Puestowwds_6_tfpuestodescrip_sels, "T1.PuestoDescrip IN (", ")")+")");
      }
      if ( AV54Puestowwds_7_tfpuestohorasext_sel == 1 )
      {
         addWhere(sWhereString, "(T1.PuestoHorasExt = TRUE)");
      }
      if ( AV54Puestowwds_7_tfpuestohorasext_sel == 2 )
      {
         addWhere(sWhereString, "(T1.PuestoHorasExt = FALSE)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.PuestoCodigo" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P01BK4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A329SecDescrip ,
                                          GXSimpleCollection<String> AV49Puestowwds_2_tfsecdescrip_sels ,
                                          String A1240PuestoCodigo ,
                                          GXSimpleCollection<String> AV51Puestowwds_4_tfpuestocodigo_sels ,
                                          String A1241PuestoDescrip ,
                                          GXSimpleCollection<String> AV53Puestowwds_6_tfpuestodescrip_sels ,
                                          int AV49Puestowwds_2_tfsecdescrip_sels_size ,
                                          String AV48Puestowwds_1_tfsecdescrip ,
                                          int AV51Puestowwds_4_tfpuestocodigo_sels_size ,
                                          String AV50Puestowwds_3_tfpuestocodigo ,
                                          int AV53Puestowwds_6_tfpuestodescrip_sels_size ,
                                          String AV52Puestowwds_5_tfpuestodescrip ,
                                          byte AV54Puestowwds_7_tfpuestohorasext_sel ,
                                          boolean A1255PuestoHorasExt ,
                                          int A3CliCod ,
                                          int AV36CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[4];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT T1.SecCodigo, T1.CliCod, T1.PuestoDescrip, T1.PuestoHorasExt, T1.PuestoCodigo, T2.SecDescrip FROM (Puesto T1 INNER JOIN Seccion T2 ON T2.CliCod = T1.CliCod" ;
      scmdbuf += " AND T2.SecCodigo = T1.SecCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      if ( ( AV49Puestowwds_2_tfsecdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV48Puestowwds_1_tfsecdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.SecDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int14[1] = (byte)(1) ;
      }
      if ( AV49Puestowwds_2_tfsecdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV49Puestowwds_2_tfsecdescrip_sels, "T2.SecDescrip IN (", ")")+")");
      }
      if ( ( AV51Puestowwds_4_tfpuestocodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV50Puestowwds_3_tfpuestocodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.PuestoCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( AV51Puestowwds_4_tfpuestocodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV51Puestowwds_4_tfpuestocodigo_sels, "T1.PuestoCodigo IN (", ")")+")");
      }
      if ( ( AV53Puestowwds_6_tfpuestodescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52Puestowwds_5_tfpuestodescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.PuestoDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( AV53Puestowwds_6_tfpuestodescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Puestowwds_6_tfpuestodescrip_sels, "T1.PuestoDescrip IN (", ")")+")");
      }
      if ( AV54Puestowwds_7_tfpuestohorasext_sel == 1 )
      {
         addWhere(sWhereString, "(T1.PuestoHorasExt = TRUE)");
      }
      if ( AV54Puestowwds_7_tfpuestohorasext_sel == 2 )
      {
         addWhere(sWhereString, "(T1.PuestoHorasExt = FALSE)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.PuestoDescrip" ;
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
                  return conditional_P01BK2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).byteValue() , ((Boolean) dynConstraints[13]).booleanValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).intValue() );
            case 1 :
                  return conditional_P01BK3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).byteValue() , ((Boolean) dynConstraints[13]).booleanValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).intValue() );
            case 2 :
                  return conditional_P01BK4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).byteValue() , ((Boolean) dynConstraints[13]).booleanValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01BK2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01BK3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01BK4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
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
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 400);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[6], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 400);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[6], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 400);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[6], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               return;
      }
   }

}

