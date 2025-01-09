package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conceptomotivosegresowwgetfilterdata extends GXProcedure
{
   public conceptomotivosegresowwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptomotivosegresowwgetfilterdata.class ), "" );
   }

   public conceptomotivosegresowwgetfilterdata( int remoteHandle ,
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
      conceptomotivosegresowwgetfilterdata.this.aP5 = new String[] {""};
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
      conceptomotivosegresowwgetfilterdata.this.AV38DDOName = aP0;
      conceptomotivosegresowwgetfilterdata.this.AV39SearchTxt = aP1;
      conceptomotivosegresowwgetfilterdata.this.AV40SearchTxtTo = aP2;
      conceptomotivosegresowwgetfilterdata.this.aP3 = aP3;
      conceptomotivosegresowwgetfilterdata.this.aP4 = aP4;
      conceptomotivosegresowwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV45EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      conceptomotivosegresowwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV45EmpCod = GXt_int1 ;
      GXt_int3 = AV46CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      conceptomotivosegresowwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV46CliCod = GXt_int3 ;
      AV28Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV30OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV31OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConceptoMotivosEgreso", GXv_boolean6) ;
      conceptomotivosegresowwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV38DDOName), "DDO_CONCODIGO") == 0 )
         {
            /* Execute user subroutine: 'LOADCONCODIGOOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV38DDOName), "DDO_MEGCODIGO") == 0 )
         {
            /* Execute user subroutine: 'LOADMEGCODIGOOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV38DDOName), "DDO_MEGPREATIPO") == 0 )
         {
            /* Execute user subroutine: 'LOADMEGPREATIPOOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV41OptionsJson = AV28Options.toJSonString(false) ;
      AV42OptionsDescJson = AV30OptionsDesc.toJSonString(false) ;
      AV43OptionIndexesJson = AV31OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV33Session.getValue("ConceptoMotivosEgresoWWGridState"), "") == 0 )
      {
         AV35GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ConceptoMotivosEgresoWWGridState"), null, null);
      }
      else
      {
         AV35GridState.fromxml(AV33Session.getValue("ConceptoMotivosEgresoWWGridState"), null, null);
      }
      AV53GXV1 = 1 ;
      while ( AV53GXV1 <= AV35GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV36GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV35GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV53GXV1));
         if ( GXutil.strcmp(AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICOD") == 0 )
         {
            AV11TFCliCod = (int)(GXutil.lval( AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFCliCod_To = (int)(GXutil.lval( AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODIGO") == 0 )
         {
            AV48TFConCodigo = AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODIGO_SEL") == 0 )
         {
            AV47TFConCodigo_SelsJson = AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV49TFConCodigo_Sels.fromJSonString(AV47TFConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEGCODIGO") == 0 )
         {
            AV16TFMegCodigo = AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEGCODIGO_SEL") == 0 )
         {
            AV15TFMegCodigo_SelsJson = AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV17TFMegCodigo_Sels.fromJSonString(AV15TFMegCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEGPREATIPO_SEL") == 0 )
         {
            AV18TFMegPreaTipo_SelsJson = AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV19TFMegPreaTipo_Sels.fromJSonString(AV18TFMegPreaTipo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONMEGMESES") == 0 )
         {
            AV20TFConMegMeses = (byte)(GXutil.lval( AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV21TFConMegMeses_To = (byte)(GXutil.lval( AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONMEGDURA_SEL") == 0 )
         {
            AV22TFConMegDura_SelsJson = AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV23TFConMegDura_Sels.fromJSonString(AV22TFConMegDura_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONMEGPROPOR") == 0 )
         {
            AV24TFConMegPropor = CommonUtil.decimalVal( AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV25TFConMegPropor_To = CommonUtil.decimalVal( AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV50MenuOpcCod = AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV53GXV1 = (int)(AV53GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADCONCODIGOOPTIONS' Routine */
      returnInSub = false ;
      AV48TFConCodigo = AV39SearchTxt ;
      AV49TFConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV55Conceptomotivosegresowwds_1_tfclicod = AV11TFCliCod ;
      AV56Conceptomotivosegresowwds_2_tfclicod_to = AV12TFCliCod_To ;
      AV57Conceptomotivosegresowwds_3_tfconcodigo = AV48TFConCodigo ;
      AV58Conceptomotivosegresowwds_4_tfconcodigo_sels = AV49TFConCodigo_Sels ;
      AV59Conceptomotivosegresowwds_5_tfmegcodigo = AV16TFMegCodigo ;
      AV60Conceptomotivosegresowwds_6_tfmegcodigo_sels = AV17TFMegCodigo_Sels ;
      AV61Conceptomotivosegresowwds_7_tfmegpreatipo_sels = AV19TFMegPreaTipo_Sels ;
      AV62Conceptomotivosegresowwds_8_tfconmegmeses = AV20TFConMegMeses ;
      AV63Conceptomotivosegresowwds_9_tfconmegmeses_to = AV21TFConMegMeses_To ;
      AV64Conceptomotivosegresowwds_10_tfconmegdura_sels = AV23TFConMegDura_Sels ;
      AV65Conceptomotivosegresowwds_11_tfconmegpropor = AV24TFConMegPropor ;
      AV66Conceptomotivosegresowwds_12_tfconmegpropor_to = AV25TFConMegPropor_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A26ConCodigo ,
                                           AV58Conceptomotivosegresowwds_4_tfconcodigo_sels ,
                                           A11MegCodigo ,
                                           AV60Conceptomotivosegresowwds_6_tfmegcodigo_sels ,
                                           A1532MegPreaTipo ,
                                           AV61Conceptomotivosegresowwds_7_tfmegpreatipo_sels ,
                                           A1534ConMegDura ,
                                           AV64Conceptomotivosegresowwds_10_tfconmegdura_sels ,
                                           Integer.valueOf(AV55Conceptomotivosegresowwds_1_tfclicod) ,
                                           Integer.valueOf(AV56Conceptomotivosegresowwds_2_tfclicod_to) ,
                                           Integer.valueOf(AV58Conceptomotivosegresowwds_4_tfconcodigo_sels.size()) ,
                                           AV57Conceptomotivosegresowwds_3_tfconcodigo ,
                                           Integer.valueOf(AV60Conceptomotivosegresowwds_6_tfmegcodigo_sels.size()) ,
                                           AV59Conceptomotivosegresowwds_5_tfmegcodigo ,
                                           Integer.valueOf(AV61Conceptomotivosegresowwds_7_tfmegpreatipo_sels.size()) ,
                                           Byte.valueOf(AV62Conceptomotivosegresowwds_8_tfconmegmeses) ,
                                           Byte.valueOf(AV63Conceptomotivosegresowwds_9_tfconmegmeses_to) ,
                                           Integer.valueOf(AV64Conceptomotivosegresowwds_10_tfconmegdura_sels.size()) ,
                                           AV65Conceptomotivosegresowwds_11_tfconmegpropor ,
                                           AV66Conceptomotivosegresowwds_12_tfconmegpropor_to ,
                                           Integer.valueOf(A3CliCod) ,
                                           Byte.valueOf(A1530ConMegMeses) ,
                                           A1529ConMegPropor ,
                                           Integer.valueOf(AV46CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.INT
                                           }
      });
      lV57Conceptomotivosegresowwds_3_tfconcodigo = GXutil.padr( GXutil.rtrim( AV57Conceptomotivosegresowwds_3_tfconcodigo), 10, "%") ;
      lV59Conceptomotivosegresowwds_5_tfmegcodigo = GXutil.padr( GXutil.rtrim( AV59Conceptomotivosegresowwds_5_tfmegcodigo), 20, "%") ;
      /* Using cursor P01KM2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV46CliCod), Integer.valueOf(AV55Conceptomotivosegresowwds_1_tfclicod), Integer.valueOf(AV56Conceptomotivosegresowwds_2_tfclicod_to), lV57Conceptomotivosegresowwds_3_tfconcodigo, lV59Conceptomotivosegresowwds_5_tfmegcodigo, Byte.valueOf(AV62Conceptomotivosegresowwds_8_tfconmegmeses), Byte.valueOf(AV63Conceptomotivosegresowwds_9_tfconmegmeses_to), AV65Conceptomotivosegresowwds_11_tfconmegpropor, AV66Conceptomotivosegresowwds_12_tfconmegpropor_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1KM2 = false ;
         A3CliCod = P01KM2_A3CliCod[0] ;
         A26ConCodigo = P01KM2_A26ConCodigo[0] ;
         A1529ConMegPropor = P01KM2_A1529ConMegPropor[0] ;
         A1534ConMegDura = P01KM2_A1534ConMegDura[0] ;
         A1530ConMegMeses = P01KM2_A1530ConMegMeses[0] ;
         A1532MegPreaTipo = P01KM2_A1532MegPreaTipo[0] ;
         A11MegCodigo = P01KM2_A11MegCodigo[0] ;
         A2077ConMegSec = P01KM2_A2077ConMegSec[0] ;
         AV32count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P01KM2_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P01KM2_A26ConCodigo[0], A26ConCodigo) == 0 ) )
         {
            brk1KM2 = false ;
            A11MegCodigo = P01KM2_A11MegCodigo[0] ;
            A2077ConMegSec = P01KM2_A2077ConMegSec[0] ;
            AV32count = (long)(AV32count+1) ;
            brk1KM2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A26ConCodigo)==0) )
         {
            AV27Option = A26ConCodigo ;
            AV29OptionDesc = GXutil.trim( GXutil.rtrim( localUtil.format( A26ConCodigo, ""))) ;
            AV28Options.add(AV27Option, 0);
            AV30OptionsDesc.add(AV29OptionDesc, 0);
            AV31OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV32count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV28Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1KM2 )
         {
            brk1KM2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADMEGCODIGOOPTIONS' Routine */
      returnInSub = false ;
      AV16TFMegCodigo = AV39SearchTxt ;
      AV17TFMegCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV55Conceptomotivosegresowwds_1_tfclicod = AV11TFCliCod ;
      AV56Conceptomotivosegresowwds_2_tfclicod_to = AV12TFCliCod_To ;
      AV57Conceptomotivosegresowwds_3_tfconcodigo = AV48TFConCodigo ;
      AV58Conceptomotivosegresowwds_4_tfconcodigo_sels = AV49TFConCodigo_Sels ;
      AV59Conceptomotivosegresowwds_5_tfmegcodigo = AV16TFMegCodigo ;
      AV60Conceptomotivosegresowwds_6_tfmegcodigo_sels = AV17TFMegCodigo_Sels ;
      AV61Conceptomotivosegresowwds_7_tfmegpreatipo_sels = AV19TFMegPreaTipo_Sels ;
      AV62Conceptomotivosegresowwds_8_tfconmegmeses = AV20TFConMegMeses ;
      AV63Conceptomotivosegresowwds_9_tfconmegmeses_to = AV21TFConMegMeses_To ;
      AV64Conceptomotivosegresowwds_10_tfconmegdura_sels = AV23TFConMegDura_Sels ;
      AV65Conceptomotivosegresowwds_11_tfconmegpropor = AV24TFConMegPropor ;
      AV66Conceptomotivosegresowwds_12_tfconmegpropor_to = AV25TFConMegPropor_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A26ConCodigo ,
                                           AV58Conceptomotivosegresowwds_4_tfconcodigo_sels ,
                                           A11MegCodigo ,
                                           AV60Conceptomotivosegresowwds_6_tfmegcodigo_sels ,
                                           A1532MegPreaTipo ,
                                           AV61Conceptomotivosegresowwds_7_tfmegpreatipo_sels ,
                                           A1534ConMegDura ,
                                           AV64Conceptomotivosegresowwds_10_tfconmegdura_sels ,
                                           Integer.valueOf(AV55Conceptomotivosegresowwds_1_tfclicod) ,
                                           Integer.valueOf(AV56Conceptomotivosegresowwds_2_tfclicod_to) ,
                                           Integer.valueOf(AV58Conceptomotivosegresowwds_4_tfconcodigo_sels.size()) ,
                                           AV57Conceptomotivosegresowwds_3_tfconcodigo ,
                                           Integer.valueOf(AV60Conceptomotivosegresowwds_6_tfmegcodigo_sels.size()) ,
                                           AV59Conceptomotivosegresowwds_5_tfmegcodigo ,
                                           Integer.valueOf(AV61Conceptomotivosegresowwds_7_tfmegpreatipo_sels.size()) ,
                                           Byte.valueOf(AV62Conceptomotivosegresowwds_8_tfconmegmeses) ,
                                           Byte.valueOf(AV63Conceptomotivosegresowwds_9_tfconmegmeses_to) ,
                                           Integer.valueOf(AV64Conceptomotivosegresowwds_10_tfconmegdura_sels.size()) ,
                                           AV65Conceptomotivosegresowwds_11_tfconmegpropor ,
                                           AV66Conceptomotivosegresowwds_12_tfconmegpropor_to ,
                                           Integer.valueOf(A3CliCod) ,
                                           Byte.valueOf(A1530ConMegMeses) ,
                                           A1529ConMegPropor ,
                                           Integer.valueOf(AV46CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.INT
                                           }
      });
      lV57Conceptomotivosegresowwds_3_tfconcodigo = GXutil.padr( GXutil.rtrim( AV57Conceptomotivosegresowwds_3_tfconcodigo), 10, "%") ;
      lV59Conceptomotivosegresowwds_5_tfmegcodigo = GXutil.padr( GXutil.rtrim( AV59Conceptomotivosegresowwds_5_tfmegcodigo), 20, "%") ;
      /* Using cursor P01KM3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV46CliCod), Integer.valueOf(AV55Conceptomotivosegresowwds_1_tfclicod), Integer.valueOf(AV56Conceptomotivosegresowwds_2_tfclicod_to), lV57Conceptomotivosegresowwds_3_tfconcodigo, lV59Conceptomotivosegresowwds_5_tfmegcodigo, Byte.valueOf(AV62Conceptomotivosegresowwds_8_tfconmegmeses), Byte.valueOf(AV63Conceptomotivosegresowwds_9_tfconmegmeses_to), AV65Conceptomotivosegresowwds_11_tfconmegpropor, AV66Conceptomotivosegresowwds_12_tfconmegpropor_to});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1KM4 = false ;
         A3CliCod = P01KM3_A3CliCod[0] ;
         A11MegCodigo = P01KM3_A11MegCodigo[0] ;
         A1529ConMegPropor = P01KM3_A1529ConMegPropor[0] ;
         A1534ConMegDura = P01KM3_A1534ConMegDura[0] ;
         A1530ConMegMeses = P01KM3_A1530ConMegMeses[0] ;
         A1532MegPreaTipo = P01KM3_A1532MegPreaTipo[0] ;
         A26ConCodigo = P01KM3_A26ConCodigo[0] ;
         A2077ConMegSec = P01KM3_A2077ConMegSec[0] ;
         AV32count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( P01KM3_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P01KM3_A11MegCodigo[0], A11MegCodigo) == 0 ) )
         {
            brk1KM4 = false ;
            A26ConCodigo = P01KM3_A26ConCodigo[0] ;
            A2077ConMegSec = P01KM3_A2077ConMegSec[0] ;
            AV32count = (long)(AV32count+1) ;
            brk1KM4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A11MegCodigo)==0) )
         {
            AV27Option = A11MegCodigo ;
            AV28Options.add(AV27Option, 0);
            AV31OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV32count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV28Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1KM4 )
         {
            brk1KM4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADMEGPREATIPOOPTIONS' Routine */
      returnInSub = false ;
      AV19TFMegPreaTipo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV55Conceptomotivosegresowwds_1_tfclicod = AV11TFCliCod ;
      AV56Conceptomotivosegresowwds_2_tfclicod_to = AV12TFCliCod_To ;
      AV57Conceptomotivosegresowwds_3_tfconcodigo = AV48TFConCodigo ;
      AV58Conceptomotivosegresowwds_4_tfconcodigo_sels = AV49TFConCodigo_Sels ;
      AV59Conceptomotivosegresowwds_5_tfmegcodigo = AV16TFMegCodigo ;
      AV60Conceptomotivosegresowwds_6_tfmegcodigo_sels = AV17TFMegCodigo_Sels ;
      AV61Conceptomotivosegresowwds_7_tfmegpreatipo_sels = AV19TFMegPreaTipo_Sels ;
      AV62Conceptomotivosegresowwds_8_tfconmegmeses = AV20TFConMegMeses ;
      AV63Conceptomotivosegresowwds_9_tfconmegmeses_to = AV21TFConMegMeses_To ;
      AV64Conceptomotivosegresowwds_10_tfconmegdura_sels = AV23TFConMegDura_Sels ;
      AV65Conceptomotivosegresowwds_11_tfconmegpropor = AV24TFConMegPropor ;
      AV66Conceptomotivosegresowwds_12_tfconmegpropor_to = AV25TFConMegPropor_To ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A26ConCodigo ,
                                           AV58Conceptomotivosegresowwds_4_tfconcodigo_sels ,
                                           A11MegCodigo ,
                                           AV60Conceptomotivosegresowwds_6_tfmegcodigo_sels ,
                                           A1532MegPreaTipo ,
                                           AV61Conceptomotivosegresowwds_7_tfmegpreatipo_sels ,
                                           A1534ConMegDura ,
                                           AV64Conceptomotivosegresowwds_10_tfconmegdura_sels ,
                                           Integer.valueOf(AV55Conceptomotivosegresowwds_1_tfclicod) ,
                                           Integer.valueOf(AV56Conceptomotivosegresowwds_2_tfclicod_to) ,
                                           Integer.valueOf(AV58Conceptomotivosegresowwds_4_tfconcodigo_sels.size()) ,
                                           AV57Conceptomotivosegresowwds_3_tfconcodigo ,
                                           Integer.valueOf(AV60Conceptomotivosegresowwds_6_tfmegcodigo_sels.size()) ,
                                           AV59Conceptomotivosegresowwds_5_tfmegcodigo ,
                                           Integer.valueOf(AV61Conceptomotivosegresowwds_7_tfmegpreatipo_sels.size()) ,
                                           Byte.valueOf(AV62Conceptomotivosegresowwds_8_tfconmegmeses) ,
                                           Byte.valueOf(AV63Conceptomotivosegresowwds_9_tfconmegmeses_to) ,
                                           Integer.valueOf(AV64Conceptomotivosegresowwds_10_tfconmegdura_sels.size()) ,
                                           AV65Conceptomotivosegresowwds_11_tfconmegpropor ,
                                           AV66Conceptomotivosegresowwds_12_tfconmegpropor_to ,
                                           Integer.valueOf(A3CliCod) ,
                                           Byte.valueOf(A1530ConMegMeses) ,
                                           A1529ConMegPropor ,
                                           Integer.valueOf(AV46CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.INT
                                           }
      });
      lV57Conceptomotivosegresowwds_3_tfconcodigo = GXutil.padr( GXutil.rtrim( AV57Conceptomotivosegresowwds_3_tfconcodigo), 10, "%") ;
      lV59Conceptomotivosegresowwds_5_tfmegcodigo = GXutil.padr( GXutil.rtrim( AV59Conceptomotivosegresowwds_5_tfmegcodigo), 20, "%") ;
      /* Using cursor P01KM4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV46CliCod), Integer.valueOf(AV55Conceptomotivosegresowwds_1_tfclicod), Integer.valueOf(AV56Conceptomotivosegresowwds_2_tfclicod_to), lV57Conceptomotivosegresowwds_3_tfconcodigo, lV59Conceptomotivosegresowwds_5_tfmegcodigo, Byte.valueOf(AV62Conceptomotivosegresowwds_8_tfconmegmeses), Byte.valueOf(AV63Conceptomotivosegresowwds_9_tfconmegmeses_to), AV65Conceptomotivosegresowwds_11_tfconmegpropor, AV66Conceptomotivosegresowwds_12_tfconmegpropor_to});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk1KM6 = false ;
         A3CliCod = P01KM4_A3CliCod[0] ;
         A1532MegPreaTipo = P01KM4_A1532MegPreaTipo[0] ;
         A1529ConMegPropor = P01KM4_A1529ConMegPropor[0] ;
         A1534ConMegDura = P01KM4_A1534ConMegDura[0] ;
         A1530ConMegMeses = P01KM4_A1530ConMegMeses[0] ;
         A11MegCodigo = P01KM4_A11MegCodigo[0] ;
         A26ConCodigo = P01KM4_A26ConCodigo[0] ;
         A2077ConMegSec = P01KM4_A2077ConMegSec[0] ;
         AV32count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P01KM4_A1532MegPreaTipo[0], A1532MegPreaTipo) == 0 ) )
         {
            brk1KM6 = false ;
            A3CliCod = P01KM4_A3CliCod[0] ;
            A11MegCodigo = P01KM4_A11MegCodigo[0] ;
            A26ConCodigo = P01KM4_A26ConCodigo[0] ;
            A2077ConMegSec = P01KM4_A2077ConMegSec[0] ;
            AV32count = (long)(AV32count+1) ;
            brk1KM6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A1532MegPreaTipo)==0) )
         {
            AV27Option = A1532MegPreaTipo ;
            AV28Options.add(AV27Option, 0);
            AV31OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV32count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV28Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1KM6 )
         {
            brk1KM6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = conceptomotivosegresowwgetfilterdata.this.AV41OptionsJson;
      this.aP4[0] = conceptomotivosegresowwgetfilterdata.this.AV42OptionsDescJson;
      this.aP5[0] = conceptomotivosegresowwgetfilterdata.this.AV43OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV41OptionsJson = "" ;
      AV42OptionsDescJson = "" ;
      AV43OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV28Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV30OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV31OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV33Session = httpContext.getWebSession();
      AV35GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV36GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV48TFConCodigo = "" ;
      AV47TFConCodigo_SelsJson = "" ;
      AV49TFConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV16TFMegCodigo = "" ;
      AV15TFMegCodigo_SelsJson = "" ;
      AV17TFMegCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV18TFMegPreaTipo_SelsJson = "" ;
      AV19TFMegPreaTipo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV22TFConMegDura_SelsJson = "" ;
      AV23TFConMegDura_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV24TFConMegPropor = DecimalUtil.ZERO ;
      AV25TFConMegPropor_To = DecimalUtil.ZERO ;
      AV50MenuOpcCod = "" ;
      A26ConCodigo = "" ;
      AV57Conceptomotivosegresowwds_3_tfconcodigo = "" ;
      AV58Conceptomotivosegresowwds_4_tfconcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV59Conceptomotivosegresowwds_5_tfmegcodigo = "" ;
      AV60Conceptomotivosegresowwds_6_tfmegcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV61Conceptomotivosegresowwds_7_tfmegpreatipo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV64Conceptomotivosegresowwds_10_tfconmegdura_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV65Conceptomotivosegresowwds_11_tfconmegpropor = DecimalUtil.ZERO ;
      AV66Conceptomotivosegresowwds_12_tfconmegpropor_to = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      lV57Conceptomotivosegresowwds_3_tfconcodigo = "" ;
      lV59Conceptomotivosegresowwds_5_tfmegcodigo = "" ;
      A11MegCodigo = "" ;
      A1532MegPreaTipo = "" ;
      A1534ConMegDura = "" ;
      A1529ConMegPropor = DecimalUtil.ZERO ;
      P01KM2_A3CliCod = new int[1] ;
      P01KM2_A26ConCodigo = new String[] {""} ;
      P01KM2_A1529ConMegPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01KM2_A1534ConMegDura = new String[] {""} ;
      P01KM2_A1530ConMegMeses = new byte[1] ;
      P01KM2_A1532MegPreaTipo = new String[] {""} ;
      P01KM2_A11MegCodigo = new String[] {""} ;
      P01KM2_A2077ConMegSec = new short[1] ;
      AV27Option = "" ;
      AV29OptionDesc = "" ;
      P01KM3_A3CliCod = new int[1] ;
      P01KM3_A11MegCodigo = new String[] {""} ;
      P01KM3_A1529ConMegPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01KM3_A1534ConMegDura = new String[] {""} ;
      P01KM3_A1530ConMegMeses = new byte[1] ;
      P01KM3_A1532MegPreaTipo = new String[] {""} ;
      P01KM3_A26ConCodigo = new String[] {""} ;
      P01KM3_A2077ConMegSec = new short[1] ;
      P01KM4_A3CliCod = new int[1] ;
      P01KM4_A1532MegPreaTipo = new String[] {""} ;
      P01KM4_A1529ConMegPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01KM4_A1534ConMegDura = new String[] {""} ;
      P01KM4_A1530ConMegMeses = new byte[1] ;
      P01KM4_A11MegCodigo = new String[] {""} ;
      P01KM4_A26ConCodigo = new String[] {""} ;
      P01KM4_A2077ConMegSec = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptomotivosegresowwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01KM2_A3CliCod, P01KM2_A26ConCodigo, P01KM2_A1529ConMegPropor, P01KM2_A1534ConMegDura, P01KM2_A1530ConMegMeses, P01KM2_A1532MegPreaTipo, P01KM2_A11MegCodigo, P01KM2_A2077ConMegSec
            }
            , new Object[] {
            P01KM3_A3CliCod, P01KM3_A11MegCodigo, P01KM3_A1529ConMegPropor, P01KM3_A1534ConMegDura, P01KM3_A1530ConMegMeses, P01KM3_A1532MegPreaTipo, P01KM3_A26ConCodigo, P01KM3_A2077ConMegSec
            }
            , new Object[] {
            P01KM4_A3CliCod, P01KM4_A1532MegPreaTipo, P01KM4_A1529ConMegPropor, P01KM4_A1534ConMegDura, P01KM4_A1530ConMegMeses, P01KM4_A11MegCodigo, P01KM4_A26ConCodigo, P01KM4_A2077ConMegSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV20TFConMegMeses ;
   private byte AV21TFConMegMeses_To ;
   private byte AV62Conceptomotivosegresowwds_8_tfconmegmeses ;
   private byte AV63Conceptomotivosegresowwds_9_tfconmegmeses_to ;
   private byte A1530ConMegMeses ;
   private short AV45EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A2077ConMegSec ;
   private short Gx_err ;
   private int AV46CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV53GXV1 ;
   private int AV11TFCliCod ;
   private int AV12TFCliCod_To ;
   private int AV55Conceptomotivosegresowwds_1_tfclicod ;
   private int AV56Conceptomotivosegresowwds_2_tfclicod_to ;
   private int AV58Conceptomotivosegresowwds_4_tfconcodigo_sels_size ;
   private int AV60Conceptomotivosegresowwds_6_tfmegcodigo_sels_size ;
   private int AV61Conceptomotivosegresowwds_7_tfmegpreatipo_sels_size ;
   private int AV64Conceptomotivosegresowwds_10_tfconmegdura_sels_size ;
   private int A3CliCod ;
   private long AV32count ;
   private java.math.BigDecimal AV24TFConMegPropor ;
   private java.math.BigDecimal AV25TFConMegPropor_To ;
   private java.math.BigDecimal AV65Conceptomotivosegresowwds_11_tfconmegpropor ;
   private java.math.BigDecimal AV66Conceptomotivosegresowwds_12_tfconmegpropor_to ;
   private java.math.BigDecimal A1529ConMegPropor ;
   private String AV48TFConCodigo ;
   private String AV16TFMegCodigo ;
   private String A26ConCodigo ;
   private String AV57Conceptomotivosegresowwds_3_tfconcodigo ;
   private String AV59Conceptomotivosegresowwds_5_tfmegcodigo ;
   private String scmdbuf ;
   private String lV57Conceptomotivosegresowwds_3_tfconcodigo ;
   private String lV59Conceptomotivosegresowwds_5_tfmegcodigo ;
   private String A11MegCodigo ;
   private String A1532MegPreaTipo ;
   private String A1534ConMegDura ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk1KM2 ;
   private boolean brk1KM4 ;
   private boolean brk1KM6 ;
   private String AV41OptionsJson ;
   private String AV42OptionsDescJson ;
   private String AV43OptionIndexesJson ;
   private String AV47TFConCodigo_SelsJson ;
   private String AV15TFMegCodigo_SelsJson ;
   private String AV18TFMegPreaTipo_SelsJson ;
   private String AV22TFConMegDura_SelsJson ;
   private String AV38DDOName ;
   private String AV39SearchTxt ;
   private String AV40SearchTxtTo ;
   private String AV50MenuOpcCod ;
   private String AV27Option ;
   private String AV29OptionDesc ;
   private com.genexus.webpanels.WebSession AV33Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P01KM2_A3CliCod ;
   private String[] P01KM2_A26ConCodigo ;
   private java.math.BigDecimal[] P01KM2_A1529ConMegPropor ;
   private String[] P01KM2_A1534ConMegDura ;
   private byte[] P01KM2_A1530ConMegMeses ;
   private String[] P01KM2_A1532MegPreaTipo ;
   private String[] P01KM2_A11MegCodigo ;
   private short[] P01KM2_A2077ConMegSec ;
   private int[] P01KM3_A3CliCod ;
   private String[] P01KM3_A11MegCodigo ;
   private java.math.BigDecimal[] P01KM3_A1529ConMegPropor ;
   private String[] P01KM3_A1534ConMegDura ;
   private byte[] P01KM3_A1530ConMegMeses ;
   private String[] P01KM3_A1532MegPreaTipo ;
   private String[] P01KM3_A26ConCodigo ;
   private short[] P01KM3_A2077ConMegSec ;
   private int[] P01KM4_A3CliCod ;
   private String[] P01KM4_A1532MegPreaTipo ;
   private java.math.BigDecimal[] P01KM4_A1529ConMegPropor ;
   private String[] P01KM4_A1534ConMegDura ;
   private byte[] P01KM4_A1530ConMegMeses ;
   private String[] P01KM4_A11MegCodigo ;
   private String[] P01KM4_A26ConCodigo ;
   private short[] P01KM4_A2077ConMegSec ;
   private GXSimpleCollection<String> AV49TFConCodigo_Sels ;
   private GXSimpleCollection<String> AV17TFMegCodigo_Sels ;
   private GXSimpleCollection<String> AV19TFMegPreaTipo_Sels ;
   private GXSimpleCollection<String> AV23TFConMegDura_Sels ;
   private GXSimpleCollection<String> AV58Conceptomotivosegresowwds_4_tfconcodigo_sels ;
   private GXSimpleCollection<String> AV60Conceptomotivosegresowwds_6_tfmegcodigo_sels ;
   private GXSimpleCollection<String> AV61Conceptomotivosegresowwds_7_tfmegpreatipo_sels ;
   private GXSimpleCollection<String> AV64Conceptomotivosegresowwds_10_tfconmegdura_sels ;
   private GXSimpleCollection<String> AV28Options ;
   private GXSimpleCollection<String> AV30OptionsDesc ;
   private GXSimpleCollection<String> AV31OptionIndexes ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV35GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV36GridStateFilterValue ;
}

final  class conceptomotivosegresowwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01KM2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV58Conceptomotivosegresowwds_4_tfconcodigo_sels ,
                                          String A11MegCodigo ,
                                          GXSimpleCollection<String> AV60Conceptomotivosegresowwds_6_tfmegcodigo_sels ,
                                          String A1532MegPreaTipo ,
                                          GXSimpleCollection<String> AV61Conceptomotivosegresowwds_7_tfmegpreatipo_sels ,
                                          String A1534ConMegDura ,
                                          GXSimpleCollection<String> AV64Conceptomotivosegresowwds_10_tfconmegdura_sels ,
                                          int AV55Conceptomotivosegresowwds_1_tfclicod ,
                                          int AV56Conceptomotivosegresowwds_2_tfclicod_to ,
                                          int AV58Conceptomotivosegresowwds_4_tfconcodigo_sels_size ,
                                          String AV57Conceptomotivosegresowwds_3_tfconcodigo ,
                                          int AV60Conceptomotivosegresowwds_6_tfmegcodigo_sels_size ,
                                          String AV59Conceptomotivosegresowwds_5_tfmegcodigo ,
                                          int AV61Conceptomotivosegresowwds_7_tfmegpreatipo_sels_size ,
                                          byte AV62Conceptomotivosegresowwds_8_tfconmegmeses ,
                                          byte AV63Conceptomotivosegresowwds_9_tfconmegmeses_to ,
                                          int AV64Conceptomotivosegresowwds_10_tfconmegdura_sels_size ,
                                          java.math.BigDecimal AV65Conceptomotivosegresowwds_11_tfconmegpropor ,
                                          java.math.BigDecimal AV66Conceptomotivosegresowwds_12_tfconmegpropor_to ,
                                          int A3CliCod ,
                                          byte A1530ConMegMeses ,
                                          java.math.BigDecimal A1529ConMegPropor ,
                                          int AV46CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[9];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliCod, ConCodigo, ConMegPropor, ConMegDura, ConMegMeses, MegPreaTipo, MegCodigo, ConMegSec FROM ConceptoMotivosEgreso" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV55Conceptomotivosegresowwds_1_tfclicod) )
      {
         addWhere(sWhereString, "(CliCod >= ?)");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( ! (0==AV56Conceptomotivosegresowwds_2_tfclicod_to) )
      {
         addWhere(sWhereString, "(CliCod <= ?)");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( ( AV58Conceptomotivosegresowwds_4_tfconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV57Conceptomotivosegresowwds_3_tfconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV58Conceptomotivosegresowwds_4_tfconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58Conceptomotivosegresowwds_4_tfconcodigo_sels, "ConCodigo IN (", ")")+")");
      }
      if ( ( AV60Conceptomotivosegresowwds_6_tfmegcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV59Conceptomotivosegresowwds_5_tfmegcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MegCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( AV60Conceptomotivosegresowwds_6_tfmegcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV60Conceptomotivosegresowwds_6_tfmegcodigo_sels, "MegCodigo IN (", ")")+")");
      }
      if ( AV61Conceptomotivosegresowwds_7_tfmegpreatipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Conceptomotivosegresowwds_7_tfmegpreatipo_sels, "MegPreaTipo IN (", ")")+")");
      }
      if ( ! (0==AV62Conceptomotivosegresowwds_8_tfconmegmeses) )
      {
         addWhere(sWhereString, "(ConMegMeses >= ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( ! (0==AV63Conceptomotivosegresowwds_9_tfconmegmeses_to) )
      {
         addWhere(sWhereString, "(ConMegMeses <= ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( AV64Conceptomotivosegresowwds_10_tfconmegdura_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV64Conceptomotivosegresowwds_10_tfconmegdura_sels, "ConMegDura IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65Conceptomotivosegresowwds_11_tfconmegpropor)==0) )
      {
         addWhere(sWhereString, "(ConMegPropor >= ?)");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66Conceptomotivosegresowwds_12_tfconmegpropor_to)==0) )
      {
         addWhere(sWhereString, "(ConMegPropor <= ?)");
      }
      else
      {
         GXv_int8[8] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, ConCodigo" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P01KM3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV58Conceptomotivosegresowwds_4_tfconcodigo_sels ,
                                          String A11MegCodigo ,
                                          GXSimpleCollection<String> AV60Conceptomotivosegresowwds_6_tfmegcodigo_sels ,
                                          String A1532MegPreaTipo ,
                                          GXSimpleCollection<String> AV61Conceptomotivosegresowwds_7_tfmegpreatipo_sels ,
                                          String A1534ConMegDura ,
                                          GXSimpleCollection<String> AV64Conceptomotivosegresowwds_10_tfconmegdura_sels ,
                                          int AV55Conceptomotivosegresowwds_1_tfclicod ,
                                          int AV56Conceptomotivosegresowwds_2_tfclicod_to ,
                                          int AV58Conceptomotivosegresowwds_4_tfconcodigo_sels_size ,
                                          String AV57Conceptomotivosegresowwds_3_tfconcodigo ,
                                          int AV60Conceptomotivosegresowwds_6_tfmegcodigo_sels_size ,
                                          String AV59Conceptomotivosegresowwds_5_tfmegcodigo ,
                                          int AV61Conceptomotivosegresowwds_7_tfmegpreatipo_sels_size ,
                                          byte AV62Conceptomotivosegresowwds_8_tfconmegmeses ,
                                          byte AV63Conceptomotivosegresowwds_9_tfconmegmeses_to ,
                                          int AV64Conceptomotivosegresowwds_10_tfconmegdura_sels_size ,
                                          java.math.BigDecimal AV65Conceptomotivosegresowwds_11_tfconmegpropor ,
                                          java.math.BigDecimal AV66Conceptomotivosegresowwds_12_tfconmegpropor_to ,
                                          int A3CliCod ,
                                          byte A1530ConMegMeses ,
                                          java.math.BigDecimal A1529ConMegPropor ,
                                          int AV46CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[9];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT CliCod, MegCodigo, ConMegPropor, ConMegDura, ConMegMeses, MegPreaTipo, ConCodigo, ConMegSec FROM ConceptoMotivosEgreso" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV55Conceptomotivosegresowwds_1_tfclicod) )
      {
         addWhere(sWhereString, "(CliCod >= ?)");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( ! (0==AV56Conceptomotivosegresowwds_2_tfclicod_to) )
      {
         addWhere(sWhereString, "(CliCod <= ?)");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( ( AV58Conceptomotivosegresowwds_4_tfconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV57Conceptomotivosegresowwds_3_tfconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV58Conceptomotivosegresowwds_4_tfconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58Conceptomotivosegresowwds_4_tfconcodigo_sels, "ConCodigo IN (", ")")+")");
      }
      if ( ( AV60Conceptomotivosegresowwds_6_tfmegcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV59Conceptomotivosegresowwds_5_tfmegcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MegCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( AV60Conceptomotivosegresowwds_6_tfmegcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV60Conceptomotivosegresowwds_6_tfmegcodigo_sels, "MegCodigo IN (", ")")+")");
      }
      if ( AV61Conceptomotivosegresowwds_7_tfmegpreatipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Conceptomotivosegresowwds_7_tfmegpreatipo_sels, "MegPreaTipo IN (", ")")+")");
      }
      if ( ! (0==AV62Conceptomotivosegresowwds_8_tfconmegmeses) )
      {
         addWhere(sWhereString, "(ConMegMeses >= ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( ! (0==AV63Conceptomotivosegresowwds_9_tfconmegmeses_to) )
      {
         addWhere(sWhereString, "(ConMegMeses <= ?)");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( AV64Conceptomotivosegresowwds_10_tfconmegdura_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV64Conceptomotivosegresowwds_10_tfconmegdura_sels, "ConMegDura IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65Conceptomotivosegresowwds_11_tfconmegpropor)==0) )
      {
         addWhere(sWhereString, "(ConMegPropor >= ?)");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66Conceptomotivosegresowwds_12_tfconmegpropor_to)==0) )
      {
         addWhere(sWhereString, "(ConMegPropor <= ?)");
      }
      else
      {
         GXv_int11[8] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, MegCodigo" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P01KM4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV58Conceptomotivosegresowwds_4_tfconcodigo_sels ,
                                          String A11MegCodigo ,
                                          GXSimpleCollection<String> AV60Conceptomotivosegresowwds_6_tfmegcodigo_sels ,
                                          String A1532MegPreaTipo ,
                                          GXSimpleCollection<String> AV61Conceptomotivosegresowwds_7_tfmegpreatipo_sels ,
                                          String A1534ConMegDura ,
                                          GXSimpleCollection<String> AV64Conceptomotivosegresowwds_10_tfconmegdura_sels ,
                                          int AV55Conceptomotivosegresowwds_1_tfclicod ,
                                          int AV56Conceptomotivosegresowwds_2_tfclicod_to ,
                                          int AV58Conceptomotivosegresowwds_4_tfconcodigo_sels_size ,
                                          String AV57Conceptomotivosegresowwds_3_tfconcodigo ,
                                          int AV60Conceptomotivosegresowwds_6_tfmegcodigo_sels_size ,
                                          String AV59Conceptomotivosegresowwds_5_tfmegcodigo ,
                                          int AV61Conceptomotivosegresowwds_7_tfmegpreatipo_sels_size ,
                                          byte AV62Conceptomotivosegresowwds_8_tfconmegmeses ,
                                          byte AV63Conceptomotivosegresowwds_9_tfconmegmeses_to ,
                                          int AV64Conceptomotivosegresowwds_10_tfconmegdura_sels_size ,
                                          java.math.BigDecimal AV65Conceptomotivosegresowwds_11_tfconmegpropor ,
                                          java.math.BigDecimal AV66Conceptomotivosegresowwds_12_tfconmegpropor_to ,
                                          int A3CliCod ,
                                          byte A1530ConMegMeses ,
                                          java.math.BigDecimal A1529ConMegPropor ,
                                          int AV46CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[9];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT CliCod, MegPreaTipo, ConMegPropor, ConMegDura, ConMegMeses, MegCodigo, ConCodigo, ConMegSec FROM ConceptoMotivosEgreso" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV55Conceptomotivosegresowwds_1_tfclicod) )
      {
         addWhere(sWhereString, "(CliCod >= ?)");
      }
      else
      {
         GXv_int14[1] = (byte)(1) ;
      }
      if ( ! (0==AV56Conceptomotivosegresowwds_2_tfclicod_to) )
      {
         addWhere(sWhereString, "(CliCod <= ?)");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( ( AV58Conceptomotivosegresowwds_4_tfconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV57Conceptomotivosegresowwds_3_tfconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( AV58Conceptomotivosegresowwds_4_tfconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58Conceptomotivosegresowwds_4_tfconcodigo_sels, "ConCodigo IN (", ")")+")");
      }
      if ( ( AV60Conceptomotivosegresowwds_6_tfmegcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV59Conceptomotivosegresowwds_5_tfmegcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MegCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( AV60Conceptomotivosegresowwds_6_tfmegcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV60Conceptomotivosegresowwds_6_tfmegcodigo_sels, "MegCodigo IN (", ")")+")");
      }
      if ( AV61Conceptomotivosegresowwds_7_tfmegpreatipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Conceptomotivosegresowwds_7_tfmegpreatipo_sels, "MegPreaTipo IN (", ")")+")");
      }
      if ( ! (0==AV62Conceptomotivosegresowwds_8_tfconmegmeses) )
      {
         addWhere(sWhereString, "(ConMegMeses >= ?)");
      }
      else
      {
         GXv_int14[5] = (byte)(1) ;
      }
      if ( ! (0==AV63Conceptomotivosegresowwds_9_tfconmegmeses_to) )
      {
         addWhere(sWhereString, "(ConMegMeses <= ?)");
      }
      else
      {
         GXv_int14[6] = (byte)(1) ;
      }
      if ( AV64Conceptomotivosegresowwds_10_tfconmegdura_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV64Conceptomotivosegresowwds_10_tfconmegdura_sels, "ConMegDura IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65Conceptomotivosegresowwds_11_tfconmegpropor)==0) )
      {
         addWhere(sWhereString, "(ConMegPropor >= ?)");
      }
      else
      {
         GXv_int14[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66Conceptomotivosegresowwds_12_tfconmegpropor_to)==0) )
      {
         addWhere(sWhereString, "(ConMegPropor <= ?)");
      }
      else
      {
         GXv_int14[8] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY MegPreaTipo" ;
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
                  return conditional_P01KM2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).byteValue() , ((Number) dynConstraints[17]).intValue() , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).byteValue() , (java.math.BigDecimal)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() );
            case 1 :
                  return conditional_P01KM3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).byteValue() , ((Number) dynConstraints[17]).intValue() , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).byteValue() , (java.math.BigDecimal)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() );
            case 2 :
                  return conditional_P01KM4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).byteValue() , ((Number) dynConstraints[17]).intValue() , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).byteValue() , (java.math.BigDecimal)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01KM2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01KM3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01KM4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               ((short[]) buf[7])[0] = rslt.getShort(8);
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
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[12], 10);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 20);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[14]).byteValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[15]).byteValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[16], 4);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[17], 4);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[12], 10);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 20);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[14]).byteValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[15]).byteValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[16], 4);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[17], 4);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[12], 10);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 20);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[14]).byteValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[15]).byteValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[16], 4);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[17], 4);
               }
               return;
      }
   }

}

