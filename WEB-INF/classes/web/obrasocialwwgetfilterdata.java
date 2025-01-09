package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obrasocialwwgetfilterdata extends GXProcedure
{
   public obrasocialwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obrasocialwwgetfilterdata.class ), "" );
   }

   public obrasocialwwgetfilterdata( int remoteHandle ,
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
      obrasocialwwgetfilterdata.this.aP5 = new String[] {""};
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
      obrasocialwwgetfilterdata.this.AV19DDOName = aP0;
      obrasocialwwgetfilterdata.this.AV17SearchTxt = aP1;
      obrasocialwwgetfilterdata.this.AV18SearchTxtTo = aP2;
      obrasocialwwgetfilterdata.this.aP3 = aP3;
      obrasocialwwgetfilterdata.this.aP4 = aP4;
      obrasocialwwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV43EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      obrasocialwwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV43EmpCod = GXt_int1 ;
      GXt_int3 = AV42CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      obrasocialwwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV42CliCod = GXt_int3 ;
      AV22Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV25OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV27OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWObraSocial", GXv_boolean6) ;
      obrasocialwwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV19DDOName), "DDO_OSOCOD") == 0 )
         {
            /* Execute user subroutine: 'LOADOSOCODOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV19DDOName), "DDO_OSODESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADOSODESCRIPOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV19DDOName), "DDO_OSOSIGLA") == 0 )
         {
            /* Execute user subroutine: 'LOADOSOSIGLAOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV19DDOName), "DDO_OSOC3992") == 0 )
         {
            /* Execute user subroutine: 'LOADOSOC3992OPTIONS' */
            S151 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV19DDOName), "DDO_OSORELREF") == 0 )
         {
            /* Execute user subroutine: 'LOADOSORELREFOPTIONS' */
            S161 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV23OptionsJson = AV22Options.toJSonString(false) ;
      AV26OptionsDescJson = AV25OptionsDesc.toJSonString(false) ;
      AV28OptionIndexesJson = AV27OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV30Session.getValue("ObraSocialWWGridState"), "") == 0 )
      {
         AV32GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ObraSocialWWGridState"), null, null);
      }
      else
      {
         AV32GridState.fromxml(AV30Session.getValue("ObraSocialWWGridState"), null, null);
      }
      AV56GXV1 = 1 ;
      while ( AV56GXV1 <= AV32GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV33GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV32GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV56GXV1));
         if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOSOCOD") == 0 )
         {
            AV10TFOsoCod = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOSOCOD_SEL") == 0 )
         {
            AV36TFOsoCod_SelsJson = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV37TFOsoCod_Sels.fromJSonString(AV36TFOsoCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOSODESCRIP") == 0 )
         {
            AV12TFOsoDescrip = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOSODESCRIP_SEL") == 0 )
         {
            AV38TFOsoDescrip_SelsJson = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV39TFOsoDescrip_Sels.fromJSonString(AV38TFOsoDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOSOSIGLA") == 0 )
         {
            AV48TFOsoSigla = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOSOSIGLA_SEL") == 0 )
         {
            AV47TFOsoSigla_SelsJson = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV49TFOsoSigla_Sels.fromJSonString(AV47TFOsoSigla_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOSOC3992") == 0 )
         {
            AV15TFOsoC3992 = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOSOC3992_SEL") == 0 )
         {
            AV40TFOsoC3992_SelsJson = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV41TFOsoC3992_Sels.fromJSonString(AV40TFOsoC3992_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOSOAPORTEADIC") == 0 )
         {
            AV45TFOsoAporteAdic = CommonUtil.decimalVal( AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV46TFOsoAporteAdic_To = CommonUtil.decimalVal( AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOSORELREF") == 0 )
         {
            AV52TFOsoRelRef = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOSORELREF_SEL") == 0 )
         {
            AV51TFOsoRelRef_SelsJson = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV53TFOsoRelRef_Sels.fromJSonString(AV51TFOsoRelRef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV50MenuOpcCod = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV56GXV1 = (int)(AV56GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADOSOCODOPTIONS' Routine */
      returnInSub = false ;
      AV10TFOsoCod = AV17SearchTxt ;
      AV37TFOsoCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV58Obrasocialwwds_1_tfosocod = AV10TFOsoCod ;
      AV59Obrasocialwwds_2_tfosocod_sels = AV37TFOsoCod_Sels ;
      AV60Obrasocialwwds_3_tfosodescrip = AV12TFOsoDescrip ;
      AV61Obrasocialwwds_4_tfosodescrip_sels = AV39TFOsoDescrip_Sels ;
      AV62Obrasocialwwds_5_tfososigla = AV48TFOsoSigla ;
      AV63Obrasocialwwds_6_tfososigla_sels = AV49TFOsoSigla_Sels ;
      AV64Obrasocialwwds_7_tfosoc3992 = AV15TFOsoC3992 ;
      AV65Obrasocialwwds_8_tfosoc3992_sels = AV41TFOsoC3992_Sels ;
      AV66Obrasocialwwds_9_tfosoaporteadic = AV45TFOsoAporteAdic ;
      AV67Obrasocialwwds_10_tfosoaporteadic_to = AV46TFOsoAporteAdic_To ;
      AV68Obrasocialwwds_11_tfosorelref = AV52TFOsoRelRef ;
      AV69Obrasocialwwds_12_tfosorelref_sels = AV53TFOsoRelRef_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A5OsoCod ,
                                           AV59Obrasocialwwds_2_tfosocod_sels ,
                                           A307OsoDescrip ,
                                           AV61Obrasocialwwds_4_tfosodescrip_sels ,
                                           A392OsoSigla ,
                                           AV63Obrasocialwwds_6_tfososigla_sels ,
                                           A306OsoC3992 ,
                                           AV65Obrasocialwwds_8_tfosoc3992_sels ,
                                           A2014OsoRelRef ,
                                           AV69Obrasocialwwds_12_tfosorelref_sels ,
                                           Integer.valueOf(AV59Obrasocialwwds_2_tfosocod_sels.size()) ,
                                           AV58Obrasocialwwds_1_tfosocod ,
                                           Integer.valueOf(AV61Obrasocialwwds_4_tfosodescrip_sels.size()) ,
                                           AV60Obrasocialwwds_3_tfosodescrip ,
                                           Integer.valueOf(AV63Obrasocialwwds_6_tfososigla_sels.size()) ,
                                           AV62Obrasocialwwds_5_tfososigla ,
                                           Integer.valueOf(AV65Obrasocialwwds_8_tfosoc3992_sels.size()) ,
                                           AV64Obrasocialwwds_7_tfosoc3992 ,
                                           AV66Obrasocialwwds_9_tfosoaporteadic ,
                                           AV67Obrasocialwwds_10_tfosoaporteadic_to ,
                                           Integer.valueOf(AV69Obrasocialwwds_12_tfosorelref_sels.size()) ,
                                           AV68Obrasocialwwds_11_tfosorelref ,
                                           A893OsoAporteAdic ,
                                           Integer.valueOf(AV42CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.INT,
                                           TypeConstants.INT
                                           }
      });
      lV58Obrasocialwwds_1_tfosocod = GXutil.padr( GXutil.rtrim( AV58Obrasocialwwds_1_tfosocod), 20, "%") ;
      lV60Obrasocialwwds_3_tfosodescrip = GXutil.concat( GXutil.rtrim( AV60Obrasocialwwds_3_tfosodescrip), "%", "") ;
      lV62Obrasocialwwds_5_tfososigla = GXutil.padr( GXutil.rtrim( AV62Obrasocialwwds_5_tfososigla), 20, "%") ;
      lV64Obrasocialwwds_7_tfosoc3992 = GXutil.padr( GXutil.rtrim( AV64Obrasocialwwds_7_tfosoc3992), 20, "%") ;
      lV68Obrasocialwwds_11_tfosorelref = GXutil.concat( GXutil.rtrim( AV68Obrasocialwwds_11_tfosorelref), "%", "") ;
      /* Using cursor P006G2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV42CliCod), lV58Obrasocialwwds_1_tfosocod, lV60Obrasocialwwds_3_tfosodescrip, lV62Obrasocialwwds_5_tfososigla, lV64Obrasocialwwds_7_tfosoc3992, AV66Obrasocialwwds_9_tfosoaporteadic, AV67Obrasocialwwds_10_tfosoaporteadic_to, lV68Obrasocialwwds_11_tfosorelref});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk6G2 = false ;
         A3CliCod = P006G2_A3CliCod[0] ;
         A5OsoCod = P006G2_A5OsoCod[0] ;
         A2014OsoRelRef = P006G2_A2014OsoRelRef[0] ;
         A893OsoAporteAdic = P006G2_A893OsoAporteAdic[0] ;
         A306OsoC3992 = P006G2_A306OsoC3992[0] ;
         n306OsoC3992 = P006G2_n306OsoC3992[0] ;
         A392OsoSigla = P006G2_A392OsoSigla[0] ;
         A307OsoDescrip = P006G2_A307OsoDescrip[0] ;
         AV29count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P006G2_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P006G2_A5OsoCod[0], A5OsoCod) == 0 ) )
         {
            brk6G2 = false ;
            AV29count = (long)(AV29count+1) ;
            brk6G2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A5OsoCod)==0) )
         {
            AV21Option = A5OsoCod ;
            AV22Options.add(AV21Option, 0);
            AV27OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV29count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV22Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6G2 )
         {
            brk6G2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADOSODESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV12TFOsoDescrip = AV17SearchTxt ;
      AV39TFOsoDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV58Obrasocialwwds_1_tfosocod = AV10TFOsoCod ;
      AV59Obrasocialwwds_2_tfosocod_sels = AV37TFOsoCod_Sels ;
      AV60Obrasocialwwds_3_tfosodescrip = AV12TFOsoDescrip ;
      AV61Obrasocialwwds_4_tfosodescrip_sels = AV39TFOsoDescrip_Sels ;
      AV62Obrasocialwwds_5_tfososigla = AV48TFOsoSigla ;
      AV63Obrasocialwwds_6_tfososigla_sels = AV49TFOsoSigla_Sels ;
      AV64Obrasocialwwds_7_tfosoc3992 = AV15TFOsoC3992 ;
      AV65Obrasocialwwds_8_tfosoc3992_sels = AV41TFOsoC3992_Sels ;
      AV66Obrasocialwwds_9_tfosoaporteadic = AV45TFOsoAporteAdic ;
      AV67Obrasocialwwds_10_tfosoaporteadic_to = AV46TFOsoAporteAdic_To ;
      AV68Obrasocialwwds_11_tfosorelref = AV52TFOsoRelRef ;
      AV69Obrasocialwwds_12_tfosorelref_sels = AV53TFOsoRelRef_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A5OsoCod ,
                                           AV59Obrasocialwwds_2_tfosocod_sels ,
                                           A307OsoDescrip ,
                                           AV61Obrasocialwwds_4_tfosodescrip_sels ,
                                           A392OsoSigla ,
                                           AV63Obrasocialwwds_6_tfososigla_sels ,
                                           A306OsoC3992 ,
                                           AV65Obrasocialwwds_8_tfosoc3992_sels ,
                                           A2014OsoRelRef ,
                                           AV69Obrasocialwwds_12_tfosorelref_sels ,
                                           Integer.valueOf(AV59Obrasocialwwds_2_tfosocod_sels.size()) ,
                                           AV58Obrasocialwwds_1_tfosocod ,
                                           Integer.valueOf(AV61Obrasocialwwds_4_tfosodescrip_sels.size()) ,
                                           AV60Obrasocialwwds_3_tfosodescrip ,
                                           Integer.valueOf(AV63Obrasocialwwds_6_tfososigla_sels.size()) ,
                                           AV62Obrasocialwwds_5_tfososigla ,
                                           Integer.valueOf(AV65Obrasocialwwds_8_tfosoc3992_sels.size()) ,
                                           AV64Obrasocialwwds_7_tfosoc3992 ,
                                           AV66Obrasocialwwds_9_tfosoaporteadic ,
                                           AV67Obrasocialwwds_10_tfosoaporteadic_to ,
                                           Integer.valueOf(AV69Obrasocialwwds_12_tfosorelref_sels.size()) ,
                                           AV68Obrasocialwwds_11_tfosorelref ,
                                           A893OsoAporteAdic ,
                                           Integer.valueOf(AV42CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.INT,
                                           TypeConstants.INT
                                           }
      });
      lV58Obrasocialwwds_1_tfosocod = GXutil.padr( GXutil.rtrim( AV58Obrasocialwwds_1_tfosocod), 20, "%") ;
      lV60Obrasocialwwds_3_tfosodescrip = GXutil.concat( GXutil.rtrim( AV60Obrasocialwwds_3_tfosodescrip), "%", "") ;
      lV62Obrasocialwwds_5_tfososigla = GXutil.padr( GXutil.rtrim( AV62Obrasocialwwds_5_tfososigla), 20, "%") ;
      lV64Obrasocialwwds_7_tfosoc3992 = GXutil.padr( GXutil.rtrim( AV64Obrasocialwwds_7_tfosoc3992), 20, "%") ;
      lV68Obrasocialwwds_11_tfosorelref = GXutil.concat( GXutil.rtrim( AV68Obrasocialwwds_11_tfosorelref), "%", "") ;
      /* Using cursor P006G3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV42CliCod), lV58Obrasocialwwds_1_tfosocod, lV60Obrasocialwwds_3_tfosodescrip, lV62Obrasocialwwds_5_tfososigla, lV64Obrasocialwwds_7_tfosoc3992, AV66Obrasocialwwds_9_tfosoaporteadic, AV67Obrasocialwwds_10_tfosoaporteadic_to, lV68Obrasocialwwds_11_tfosorelref});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk6G4 = false ;
         A3CliCod = P006G3_A3CliCod[0] ;
         A307OsoDescrip = P006G3_A307OsoDescrip[0] ;
         A2014OsoRelRef = P006G3_A2014OsoRelRef[0] ;
         A893OsoAporteAdic = P006G3_A893OsoAporteAdic[0] ;
         A306OsoC3992 = P006G3_A306OsoC3992[0] ;
         n306OsoC3992 = P006G3_n306OsoC3992[0] ;
         A392OsoSigla = P006G3_A392OsoSigla[0] ;
         A5OsoCod = P006G3_A5OsoCod[0] ;
         AV29count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( P006G3_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P006G3_A307OsoDescrip[0], A307OsoDescrip) == 0 ) )
         {
            brk6G4 = false ;
            A5OsoCod = P006G3_A5OsoCod[0] ;
            AV29count = (long)(AV29count+1) ;
            brk6G4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A307OsoDescrip)==0) )
         {
            AV21Option = A307OsoDescrip ;
            AV22Options.add(AV21Option, 0);
            AV27OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV29count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV22Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6G4 )
         {
            brk6G4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADOSOSIGLAOPTIONS' Routine */
      returnInSub = false ;
      AV48TFOsoSigla = AV17SearchTxt ;
      AV49TFOsoSigla_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV58Obrasocialwwds_1_tfosocod = AV10TFOsoCod ;
      AV59Obrasocialwwds_2_tfosocod_sels = AV37TFOsoCod_Sels ;
      AV60Obrasocialwwds_3_tfosodescrip = AV12TFOsoDescrip ;
      AV61Obrasocialwwds_4_tfosodescrip_sels = AV39TFOsoDescrip_Sels ;
      AV62Obrasocialwwds_5_tfososigla = AV48TFOsoSigla ;
      AV63Obrasocialwwds_6_tfososigla_sels = AV49TFOsoSigla_Sels ;
      AV64Obrasocialwwds_7_tfosoc3992 = AV15TFOsoC3992 ;
      AV65Obrasocialwwds_8_tfosoc3992_sels = AV41TFOsoC3992_Sels ;
      AV66Obrasocialwwds_9_tfosoaporteadic = AV45TFOsoAporteAdic ;
      AV67Obrasocialwwds_10_tfosoaporteadic_to = AV46TFOsoAporteAdic_To ;
      AV68Obrasocialwwds_11_tfosorelref = AV52TFOsoRelRef ;
      AV69Obrasocialwwds_12_tfosorelref_sels = AV53TFOsoRelRef_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A5OsoCod ,
                                           AV59Obrasocialwwds_2_tfosocod_sels ,
                                           A307OsoDescrip ,
                                           AV61Obrasocialwwds_4_tfosodescrip_sels ,
                                           A392OsoSigla ,
                                           AV63Obrasocialwwds_6_tfososigla_sels ,
                                           A306OsoC3992 ,
                                           AV65Obrasocialwwds_8_tfosoc3992_sels ,
                                           A2014OsoRelRef ,
                                           AV69Obrasocialwwds_12_tfosorelref_sels ,
                                           Integer.valueOf(AV59Obrasocialwwds_2_tfosocod_sels.size()) ,
                                           AV58Obrasocialwwds_1_tfosocod ,
                                           Integer.valueOf(AV61Obrasocialwwds_4_tfosodescrip_sels.size()) ,
                                           AV60Obrasocialwwds_3_tfosodescrip ,
                                           Integer.valueOf(AV63Obrasocialwwds_6_tfososigla_sels.size()) ,
                                           AV62Obrasocialwwds_5_tfososigla ,
                                           Integer.valueOf(AV65Obrasocialwwds_8_tfosoc3992_sels.size()) ,
                                           AV64Obrasocialwwds_7_tfosoc3992 ,
                                           AV66Obrasocialwwds_9_tfosoaporteadic ,
                                           AV67Obrasocialwwds_10_tfosoaporteadic_to ,
                                           Integer.valueOf(AV69Obrasocialwwds_12_tfosorelref_sels.size()) ,
                                           AV68Obrasocialwwds_11_tfosorelref ,
                                           A893OsoAporteAdic ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV42CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.INT,
                                           TypeConstants.INT
                                           }
      });
      lV58Obrasocialwwds_1_tfosocod = GXutil.padr( GXutil.rtrim( AV58Obrasocialwwds_1_tfosocod), 20, "%") ;
      lV60Obrasocialwwds_3_tfosodescrip = GXutil.concat( GXutil.rtrim( AV60Obrasocialwwds_3_tfosodescrip), "%", "") ;
      lV62Obrasocialwwds_5_tfososigla = GXutil.padr( GXutil.rtrim( AV62Obrasocialwwds_5_tfososigla), 20, "%") ;
      lV64Obrasocialwwds_7_tfosoc3992 = GXutil.padr( GXutil.rtrim( AV64Obrasocialwwds_7_tfosoc3992), 20, "%") ;
      lV68Obrasocialwwds_11_tfosorelref = GXutil.concat( GXutil.rtrim( AV68Obrasocialwwds_11_tfosorelref), "%", "") ;
      /* Using cursor P006G4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV42CliCod), lV58Obrasocialwwds_1_tfosocod, lV60Obrasocialwwds_3_tfosodescrip, lV62Obrasocialwwds_5_tfososigla, lV64Obrasocialwwds_7_tfosoc3992, AV66Obrasocialwwds_9_tfosoaporteadic, AV67Obrasocialwwds_10_tfosoaporteadic_to, lV68Obrasocialwwds_11_tfosorelref});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk6G6 = false ;
         A3CliCod = P006G4_A3CliCod[0] ;
         A392OsoSigla = P006G4_A392OsoSigla[0] ;
         A2014OsoRelRef = P006G4_A2014OsoRelRef[0] ;
         A893OsoAporteAdic = P006G4_A893OsoAporteAdic[0] ;
         A306OsoC3992 = P006G4_A306OsoC3992[0] ;
         n306OsoC3992 = P006G4_n306OsoC3992[0] ;
         A307OsoDescrip = P006G4_A307OsoDescrip[0] ;
         A5OsoCod = P006G4_A5OsoCod[0] ;
         AV29count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P006G4_A392OsoSigla[0], A392OsoSigla) == 0 ) )
         {
            brk6G6 = false ;
            A3CliCod = P006G4_A3CliCod[0] ;
            A5OsoCod = P006G4_A5OsoCod[0] ;
            AV29count = (long)(AV29count+1) ;
            brk6G6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A392OsoSigla)==0) )
         {
            AV21Option = A392OsoSigla ;
            AV22Options.add(AV21Option, 0);
            AV27OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV29count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV22Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6G6 )
         {
            brk6G6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   public void S151( )
   {
      /* 'LOADOSOC3992OPTIONS' Routine */
      returnInSub = false ;
      AV15TFOsoC3992 = AV17SearchTxt ;
      AV41TFOsoC3992_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV58Obrasocialwwds_1_tfosocod = AV10TFOsoCod ;
      AV59Obrasocialwwds_2_tfosocod_sels = AV37TFOsoCod_Sels ;
      AV60Obrasocialwwds_3_tfosodescrip = AV12TFOsoDescrip ;
      AV61Obrasocialwwds_4_tfosodescrip_sels = AV39TFOsoDescrip_Sels ;
      AV62Obrasocialwwds_5_tfososigla = AV48TFOsoSigla ;
      AV63Obrasocialwwds_6_tfososigla_sels = AV49TFOsoSigla_Sels ;
      AV64Obrasocialwwds_7_tfosoc3992 = AV15TFOsoC3992 ;
      AV65Obrasocialwwds_8_tfosoc3992_sels = AV41TFOsoC3992_Sels ;
      AV66Obrasocialwwds_9_tfosoaporteadic = AV45TFOsoAporteAdic ;
      AV67Obrasocialwwds_10_tfosoaporteadic_to = AV46TFOsoAporteAdic_To ;
      AV68Obrasocialwwds_11_tfosorelref = AV52TFOsoRelRef ;
      AV69Obrasocialwwds_12_tfosorelref_sels = AV53TFOsoRelRef_Sels ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           A5OsoCod ,
                                           AV59Obrasocialwwds_2_tfosocod_sels ,
                                           A307OsoDescrip ,
                                           AV61Obrasocialwwds_4_tfosodescrip_sels ,
                                           A392OsoSigla ,
                                           AV63Obrasocialwwds_6_tfososigla_sels ,
                                           A306OsoC3992 ,
                                           AV65Obrasocialwwds_8_tfosoc3992_sels ,
                                           A2014OsoRelRef ,
                                           AV69Obrasocialwwds_12_tfosorelref_sels ,
                                           Integer.valueOf(AV59Obrasocialwwds_2_tfosocod_sels.size()) ,
                                           AV58Obrasocialwwds_1_tfosocod ,
                                           Integer.valueOf(AV61Obrasocialwwds_4_tfosodescrip_sels.size()) ,
                                           AV60Obrasocialwwds_3_tfosodescrip ,
                                           Integer.valueOf(AV63Obrasocialwwds_6_tfososigla_sels.size()) ,
                                           AV62Obrasocialwwds_5_tfososigla ,
                                           Integer.valueOf(AV65Obrasocialwwds_8_tfosoc3992_sels.size()) ,
                                           AV64Obrasocialwwds_7_tfosoc3992 ,
                                           AV66Obrasocialwwds_9_tfosoaporteadic ,
                                           AV67Obrasocialwwds_10_tfosoaporteadic_to ,
                                           Integer.valueOf(AV69Obrasocialwwds_12_tfosorelref_sels.size()) ,
                                           AV68Obrasocialwwds_11_tfosorelref ,
                                           A893OsoAporteAdic ,
                                           Integer.valueOf(AV42CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.INT,
                                           TypeConstants.INT
                                           }
      });
      lV58Obrasocialwwds_1_tfosocod = GXutil.padr( GXutil.rtrim( AV58Obrasocialwwds_1_tfosocod), 20, "%") ;
      lV60Obrasocialwwds_3_tfosodescrip = GXutil.concat( GXutil.rtrim( AV60Obrasocialwwds_3_tfosodescrip), "%", "") ;
      lV62Obrasocialwwds_5_tfososigla = GXutil.padr( GXutil.rtrim( AV62Obrasocialwwds_5_tfososigla), 20, "%") ;
      lV64Obrasocialwwds_7_tfosoc3992 = GXutil.padr( GXutil.rtrim( AV64Obrasocialwwds_7_tfosoc3992), 20, "%") ;
      lV68Obrasocialwwds_11_tfosorelref = GXutil.concat( GXutil.rtrim( AV68Obrasocialwwds_11_tfosorelref), "%", "") ;
      /* Using cursor P006G5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV42CliCod), lV58Obrasocialwwds_1_tfosocod, lV60Obrasocialwwds_3_tfosodescrip, lV62Obrasocialwwds_5_tfososigla, lV64Obrasocialwwds_7_tfosoc3992, AV66Obrasocialwwds_9_tfosoaporteadic, AV67Obrasocialwwds_10_tfosoaporteadic_to, lV68Obrasocialwwds_11_tfosorelref});
      while ( (pr_default.getStatus(3) != 101) )
      {
         brk6G8 = false ;
         A3CliCod = P006G5_A3CliCod[0] ;
         A306OsoC3992 = P006G5_A306OsoC3992[0] ;
         n306OsoC3992 = P006G5_n306OsoC3992[0] ;
         A2014OsoRelRef = P006G5_A2014OsoRelRef[0] ;
         A893OsoAporteAdic = P006G5_A893OsoAporteAdic[0] ;
         A392OsoSigla = P006G5_A392OsoSigla[0] ;
         A307OsoDescrip = P006G5_A307OsoDescrip[0] ;
         A5OsoCod = P006G5_A5OsoCod[0] ;
         AV29count = 0 ;
         while ( (pr_default.getStatus(3) != 101) && ( P006G5_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P006G5_A306OsoC3992[0], A306OsoC3992) == 0 ) )
         {
            brk6G8 = false ;
            A5OsoCod = P006G5_A5OsoCod[0] ;
            AV29count = (long)(AV29count+1) ;
            brk6G8 = true ;
            pr_default.readNext(3);
         }
         if ( ! (GXutil.strcmp("", A306OsoC3992)==0) )
         {
            AV21Option = A306OsoC3992 ;
            AV22Options.add(AV21Option, 0);
            AV27OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV29count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV22Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6G8 )
         {
            brk6G8 = true ;
            pr_default.readNext(3);
         }
      }
      pr_default.close(3);
   }

   public void S161( )
   {
      /* 'LOADOSORELREFOPTIONS' Routine */
      returnInSub = false ;
      AV52TFOsoRelRef = AV17SearchTxt ;
      AV53TFOsoRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV58Obrasocialwwds_1_tfosocod = AV10TFOsoCod ;
      AV59Obrasocialwwds_2_tfosocod_sels = AV37TFOsoCod_Sels ;
      AV60Obrasocialwwds_3_tfosodescrip = AV12TFOsoDescrip ;
      AV61Obrasocialwwds_4_tfosodescrip_sels = AV39TFOsoDescrip_Sels ;
      AV62Obrasocialwwds_5_tfososigla = AV48TFOsoSigla ;
      AV63Obrasocialwwds_6_tfososigla_sels = AV49TFOsoSigla_Sels ;
      AV64Obrasocialwwds_7_tfosoc3992 = AV15TFOsoC3992 ;
      AV65Obrasocialwwds_8_tfosoc3992_sels = AV41TFOsoC3992_Sels ;
      AV66Obrasocialwwds_9_tfosoaporteadic = AV45TFOsoAporteAdic ;
      AV67Obrasocialwwds_10_tfosoaporteadic_to = AV46TFOsoAporteAdic_To ;
      AV68Obrasocialwwds_11_tfosorelref = AV52TFOsoRelRef ;
      AV69Obrasocialwwds_12_tfosorelref_sels = AV53TFOsoRelRef_Sels ;
      pr_default.dynParam(4, new Object[]{ new Object[]{
                                           A5OsoCod ,
                                           AV59Obrasocialwwds_2_tfosocod_sels ,
                                           A307OsoDescrip ,
                                           AV61Obrasocialwwds_4_tfosodescrip_sels ,
                                           A392OsoSigla ,
                                           AV63Obrasocialwwds_6_tfososigla_sels ,
                                           A306OsoC3992 ,
                                           AV65Obrasocialwwds_8_tfosoc3992_sels ,
                                           A2014OsoRelRef ,
                                           AV69Obrasocialwwds_12_tfosorelref_sels ,
                                           Integer.valueOf(AV59Obrasocialwwds_2_tfosocod_sels.size()) ,
                                           AV58Obrasocialwwds_1_tfosocod ,
                                           Integer.valueOf(AV61Obrasocialwwds_4_tfosodescrip_sels.size()) ,
                                           AV60Obrasocialwwds_3_tfosodescrip ,
                                           Integer.valueOf(AV63Obrasocialwwds_6_tfososigla_sels.size()) ,
                                           AV62Obrasocialwwds_5_tfososigla ,
                                           Integer.valueOf(AV65Obrasocialwwds_8_tfosoc3992_sels.size()) ,
                                           AV64Obrasocialwwds_7_tfosoc3992 ,
                                           AV66Obrasocialwwds_9_tfosoaporteadic ,
                                           AV67Obrasocialwwds_10_tfosoaporteadic_to ,
                                           Integer.valueOf(AV69Obrasocialwwds_12_tfosorelref_sels.size()) ,
                                           AV68Obrasocialwwds_11_tfosorelref ,
                                           A893OsoAporteAdic ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV42CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.INT,
                                           TypeConstants.INT
                                           }
      });
      lV58Obrasocialwwds_1_tfosocod = GXutil.padr( GXutil.rtrim( AV58Obrasocialwwds_1_tfosocod), 20, "%") ;
      lV60Obrasocialwwds_3_tfosodescrip = GXutil.concat( GXutil.rtrim( AV60Obrasocialwwds_3_tfosodescrip), "%", "") ;
      lV62Obrasocialwwds_5_tfososigla = GXutil.padr( GXutil.rtrim( AV62Obrasocialwwds_5_tfososigla), 20, "%") ;
      lV64Obrasocialwwds_7_tfosoc3992 = GXutil.padr( GXutil.rtrim( AV64Obrasocialwwds_7_tfosoc3992), 20, "%") ;
      lV68Obrasocialwwds_11_tfosorelref = GXutil.concat( GXutil.rtrim( AV68Obrasocialwwds_11_tfosorelref), "%", "") ;
      /* Using cursor P006G6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(AV42CliCod), lV58Obrasocialwwds_1_tfosocod, lV60Obrasocialwwds_3_tfosodescrip, lV62Obrasocialwwds_5_tfososigla, lV64Obrasocialwwds_7_tfosoc3992, AV66Obrasocialwwds_9_tfosoaporteadic, AV67Obrasocialwwds_10_tfosoaporteadic_to, lV68Obrasocialwwds_11_tfosorelref});
      while ( (pr_default.getStatus(4) != 101) )
      {
         brk6G10 = false ;
         A3CliCod = P006G6_A3CliCod[0] ;
         A2014OsoRelRef = P006G6_A2014OsoRelRef[0] ;
         A893OsoAporteAdic = P006G6_A893OsoAporteAdic[0] ;
         A306OsoC3992 = P006G6_A306OsoC3992[0] ;
         n306OsoC3992 = P006G6_n306OsoC3992[0] ;
         A392OsoSigla = P006G6_A392OsoSigla[0] ;
         A307OsoDescrip = P006G6_A307OsoDescrip[0] ;
         A5OsoCod = P006G6_A5OsoCod[0] ;
         AV29count = 0 ;
         while ( (pr_default.getStatus(4) != 101) && ( GXutil.strcmp(P006G6_A2014OsoRelRef[0], A2014OsoRelRef) == 0 ) )
         {
            brk6G10 = false ;
            A3CliCod = P006G6_A3CliCod[0] ;
            A5OsoCod = P006G6_A5OsoCod[0] ;
            AV29count = (long)(AV29count+1) ;
            brk6G10 = true ;
            pr_default.readNext(4);
         }
         if ( ! (GXutil.strcmp("", A2014OsoRelRef)==0) )
         {
            AV21Option = A2014OsoRelRef ;
            AV22Options.add(AV21Option, 0);
            AV27OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV29count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV22Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6G10 )
         {
            brk6G10 = true ;
            pr_default.readNext(4);
         }
      }
      pr_default.close(4);
   }

   protected void cleanup( )
   {
      this.aP3[0] = obrasocialwwgetfilterdata.this.AV23OptionsJson;
      this.aP4[0] = obrasocialwwgetfilterdata.this.AV26OptionsDescJson;
      this.aP5[0] = obrasocialwwgetfilterdata.this.AV28OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV23OptionsJson = "" ;
      AV26OptionsDescJson = "" ;
      AV28OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV22Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV25OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV27OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV30Session = httpContext.getWebSession();
      AV32GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV33GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV10TFOsoCod = "" ;
      AV36TFOsoCod_SelsJson = "" ;
      AV37TFOsoCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV12TFOsoDescrip = "" ;
      AV38TFOsoDescrip_SelsJson = "" ;
      AV39TFOsoDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV48TFOsoSigla = "" ;
      AV47TFOsoSigla_SelsJson = "" ;
      AV49TFOsoSigla_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV15TFOsoC3992 = "" ;
      AV40TFOsoC3992_SelsJson = "" ;
      AV41TFOsoC3992_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV45TFOsoAporteAdic = DecimalUtil.ZERO ;
      AV46TFOsoAporteAdic_To = DecimalUtil.ZERO ;
      AV52TFOsoRelRef = "" ;
      AV51TFOsoRelRef_SelsJson = "" ;
      AV53TFOsoRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV50MenuOpcCod = "" ;
      A5OsoCod = "" ;
      AV58Obrasocialwwds_1_tfosocod = "" ;
      AV59Obrasocialwwds_2_tfosocod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV60Obrasocialwwds_3_tfosodescrip = "" ;
      AV61Obrasocialwwds_4_tfosodescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV62Obrasocialwwds_5_tfososigla = "" ;
      AV63Obrasocialwwds_6_tfososigla_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV64Obrasocialwwds_7_tfosoc3992 = "" ;
      AV65Obrasocialwwds_8_tfosoc3992_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV66Obrasocialwwds_9_tfosoaporteadic = DecimalUtil.ZERO ;
      AV67Obrasocialwwds_10_tfosoaporteadic_to = DecimalUtil.ZERO ;
      AV68Obrasocialwwds_11_tfosorelref = "" ;
      AV69Obrasocialwwds_12_tfosorelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV58Obrasocialwwds_1_tfosocod = "" ;
      lV60Obrasocialwwds_3_tfosodescrip = "" ;
      lV62Obrasocialwwds_5_tfososigla = "" ;
      lV64Obrasocialwwds_7_tfosoc3992 = "" ;
      lV68Obrasocialwwds_11_tfosorelref = "" ;
      A307OsoDescrip = "" ;
      A392OsoSigla = "" ;
      A306OsoC3992 = "" ;
      A2014OsoRelRef = "" ;
      A893OsoAporteAdic = DecimalUtil.ZERO ;
      P006G2_A3CliCod = new int[1] ;
      P006G2_A5OsoCod = new String[] {""} ;
      P006G2_A2014OsoRelRef = new String[] {""} ;
      P006G2_A893OsoAporteAdic = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P006G2_A306OsoC3992 = new String[] {""} ;
      P006G2_n306OsoC3992 = new boolean[] {false} ;
      P006G2_A392OsoSigla = new String[] {""} ;
      P006G2_A307OsoDescrip = new String[] {""} ;
      AV21Option = "" ;
      P006G3_A3CliCod = new int[1] ;
      P006G3_A307OsoDescrip = new String[] {""} ;
      P006G3_A2014OsoRelRef = new String[] {""} ;
      P006G3_A893OsoAporteAdic = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P006G3_A306OsoC3992 = new String[] {""} ;
      P006G3_n306OsoC3992 = new boolean[] {false} ;
      P006G3_A392OsoSigla = new String[] {""} ;
      P006G3_A5OsoCod = new String[] {""} ;
      P006G4_A3CliCod = new int[1] ;
      P006G4_A392OsoSigla = new String[] {""} ;
      P006G4_A2014OsoRelRef = new String[] {""} ;
      P006G4_A893OsoAporteAdic = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P006G4_A306OsoC3992 = new String[] {""} ;
      P006G4_n306OsoC3992 = new boolean[] {false} ;
      P006G4_A307OsoDescrip = new String[] {""} ;
      P006G4_A5OsoCod = new String[] {""} ;
      P006G5_A3CliCod = new int[1] ;
      P006G5_A306OsoC3992 = new String[] {""} ;
      P006G5_n306OsoC3992 = new boolean[] {false} ;
      P006G5_A2014OsoRelRef = new String[] {""} ;
      P006G5_A893OsoAporteAdic = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P006G5_A392OsoSigla = new String[] {""} ;
      P006G5_A307OsoDescrip = new String[] {""} ;
      P006G5_A5OsoCod = new String[] {""} ;
      P006G6_A3CliCod = new int[1] ;
      P006G6_A2014OsoRelRef = new String[] {""} ;
      P006G6_A893OsoAporteAdic = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P006G6_A306OsoC3992 = new String[] {""} ;
      P006G6_n306OsoC3992 = new boolean[] {false} ;
      P006G6_A392OsoSigla = new String[] {""} ;
      P006G6_A307OsoDescrip = new String[] {""} ;
      P006G6_A5OsoCod = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obrasocialwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P006G2_A3CliCod, P006G2_A5OsoCod, P006G2_A2014OsoRelRef, P006G2_A893OsoAporteAdic, P006G2_A306OsoC3992, P006G2_n306OsoC3992, P006G2_A392OsoSigla, P006G2_A307OsoDescrip
            }
            , new Object[] {
            P006G3_A3CliCod, P006G3_A307OsoDescrip, P006G3_A2014OsoRelRef, P006G3_A893OsoAporteAdic, P006G3_A306OsoC3992, P006G3_n306OsoC3992, P006G3_A392OsoSigla, P006G3_A5OsoCod
            }
            , new Object[] {
            P006G4_A3CliCod, P006G4_A392OsoSigla, P006G4_A2014OsoRelRef, P006G4_A893OsoAporteAdic, P006G4_A306OsoC3992, P006G4_n306OsoC3992, P006G4_A307OsoDescrip, P006G4_A5OsoCod
            }
            , new Object[] {
            P006G5_A3CliCod, P006G5_A306OsoC3992, P006G5_n306OsoC3992, P006G5_A2014OsoRelRef, P006G5_A893OsoAporteAdic, P006G5_A392OsoSigla, P006G5_A307OsoDescrip, P006G5_A5OsoCod
            }
            , new Object[] {
            P006G6_A3CliCod, P006G6_A2014OsoRelRef, P006G6_A893OsoAporteAdic, P006G6_A306OsoC3992, P006G6_n306OsoC3992, P006G6_A392OsoSigla, P006G6_A307OsoDescrip, P006G6_A5OsoCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV43EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV42CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV56GXV1 ;
   private int AV59Obrasocialwwds_2_tfosocod_sels_size ;
   private int AV61Obrasocialwwds_4_tfosodescrip_sels_size ;
   private int AV63Obrasocialwwds_6_tfososigla_sels_size ;
   private int AV65Obrasocialwwds_8_tfosoc3992_sels_size ;
   private int AV69Obrasocialwwds_12_tfosorelref_sels_size ;
   private int A3CliCod ;
   private long AV29count ;
   private java.math.BigDecimal AV45TFOsoAporteAdic ;
   private java.math.BigDecimal AV46TFOsoAporteAdic_To ;
   private java.math.BigDecimal AV66Obrasocialwwds_9_tfosoaporteadic ;
   private java.math.BigDecimal AV67Obrasocialwwds_10_tfosoaporteadic_to ;
   private java.math.BigDecimal A893OsoAporteAdic ;
   private String AV10TFOsoCod ;
   private String AV48TFOsoSigla ;
   private String AV15TFOsoC3992 ;
   private String A5OsoCod ;
   private String AV58Obrasocialwwds_1_tfosocod ;
   private String AV62Obrasocialwwds_5_tfososigla ;
   private String AV64Obrasocialwwds_7_tfosoc3992 ;
   private String scmdbuf ;
   private String lV58Obrasocialwwds_1_tfosocod ;
   private String lV62Obrasocialwwds_5_tfososigla ;
   private String lV64Obrasocialwwds_7_tfosoc3992 ;
   private String A392OsoSigla ;
   private String A306OsoC3992 ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk6G2 ;
   private boolean n306OsoC3992 ;
   private boolean brk6G4 ;
   private boolean brk6G6 ;
   private boolean brk6G8 ;
   private boolean brk6G10 ;
   private String AV23OptionsJson ;
   private String AV26OptionsDescJson ;
   private String AV28OptionIndexesJson ;
   private String AV36TFOsoCod_SelsJson ;
   private String AV38TFOsoDescrip_SelsJson ;
   private String AV47TFOsoSigla_SelsJson ;
   private String AV40TFOsoC3992_SelsJson ;
   private String AV51TFOsoRelRef_SelsJson ;
   private String AV19DDOName ;
   private String AV17SearchTxt ;
   private String AV18SearchTxtTo ;
   private String AV12TFOsoDescrip ;
   private String AV52TFOsoRelRef ;
   private String AV50MenuOpcCod ;
   private String AV60Obrasocialwwds_3_tfosodescrip ;
   private String AV68Obrasocialwwds_11_tfosorelref ;
   private String lV60Obrasocialwwds_3_tfosodescrip ;
   private String lV68Obrasocialwwds_11_tfosorelref ;
   private String A307OsoDescrip ;
   private String A2014OsoRelRef ;
   private String AV21Option ;
   private com.genexus.webpanels.WebSession AV30Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P006G2_A3CliCod ;
   private String[] P006G2_A5OsoCod ;
   private String[] P006G2_A2014OsoRelRef ;
   private java.math.BigDecimal[] P006G2_A893OsoAporteAdic ;
   private String[] P006G2_A306OsoC3992 ;
   private boolean[] P006G2_n306OsoC3992 ;
   private String[] P006G2_A392OsoSigla ;
   private String[] P006G2_A307OsoDescrip ;
   private int[] P006G3_A3CliCod ;
   private String[] P006G3_A307OsoDescrip ;
   private String[] P006G3_A2014OsoRelRef ;
   private java.math.BigDecimal[] P006G3_A893OsoAporteAdic ;
   private String[] P006G3_A306OsoC3992 ;
   private boolean[] P006G3_n306OsoC3992 ;
   private String[] P006G3_A392OsoSigla ;
   private String[] P006G3_A5OsoCod ;
   private int[] P006G4_A3CliCod ;
   private String[] P006G4_A392OsoSigla ;
   private String[] P006G4_A2014OsoRelRef ;
   private java.math.BigDecimal[] P006G4_A893OsoAporteAdic ;
   private String[] P006G4_A306OsoC3992 ;
   private boolean[] P006G4_n306OsoC3992 ;
   private String[] P006G4_A307OsoDescrip ;
   private String[] P006G4_A5OsoCod ;
   private int[] P006G5_A3CliCod ;
   private String[] P006G5_A306OsoC3992 ;
   private boolean[] P006G5_n306OsoC3992 ;
   private String[] P006G5_A2014OsoRelRef ;
   private java.math.BigDecimal[] P006G5_A893OsoAporteAdic ;
   private String[] P006G5_A392OsoSigla ;
   private String[] P006G5_A307OsoDescrip ;
   private String[] P006G5_A5OsoCod ;
   private int[] P006G6_A3CliCod ;
   private String[] P006G6_A2014OsoRelRef ;
   private java.math.BigDecimal[] P006G6_A893OsoAporteAdic ;
   private String[] P006G6_A306OsoC3992 ;
   private boolean[] P006G6_n306OsoC3992 ;
   private String[] P006G6_A392OsoSigla ;
   private String[] P006G6_A307OsoDescrip ;
   private String[] P006G6_A5OsoCod ;
   private GXSimpleCollection<String> AV37TFOsoCod_Sels ;
   private GXSimpleCollection<String> AV49TFOsoSigla_Sels ;
   private GXSimpleCollection<String> AV41TFOsoC3992_Sels ;
   private GXSimpleCollection<String> AV59Obrasocialwwds_2_tfosocod_sels ;
   private GXSimpleCollection<String> AV63Obrasocialwwds_6_tfososigla_sels ;
   private GXSimpleCollection<String> AV65Obrasocialwwds_8_tfosoc3992_sels ;
   private GXSimpleCollection<String> AV22Options ;
   private GXSimpleCollection<String> AV25OptionsDesc ;
   private GXSimpleCollection<String> AV27OptionIndexes ;
   private GXSimpleCollection<String> AV39TFOsoDescrip_Sels ;
   private GXSimpleCollection<String> AV53TFOsoRelRef_Sels ;
   private GXSimpleCollection<String> AV61Obrasocialwwds_4_tfosodescrip_sels ;
   private GXSimpleCollection<String> AV69Obrasocialwwds_12_tfosorelref_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV32GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV33GridStateFilterValue ;
}

final  class obrasocialwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P006G2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A5OsoCod ,
                                          GXSimpleCollection<String> AV59Obrasocialwwds_2_tfosocod_sels ,
                                          String A307OsoDescrip ,
                                          GXSimpleCollection<String> AV61Obrasocialwwds_4_tfosodescrip_sels ,
                                          String A392OsoSigla ,
                                          GXSimpleCollection<String> AV63Obrasocialwwds_6_tfososigla_sels ,
                                          String A306OsoC3992 ,
                                          GXSimpleCollection<String> AV65Obrasocialwwds_8_tfosoc3992_sels ,
                                          String A2014OsoRelRef ,
                                          GXSimpleCollection<String> AV69Obrasocialwwds_12_tfosorelref_sels ,
                                          int AV59Obrasocialwwds_2_tfosocod_sels_size ,
                                          String AV58Obrasocialwwds_1_tfosocod ,
                                          int AV61Obrasocialwwds_4_tfosodescrip_sels_size ,
                                          String AV60Obrasocialwwds_3_tfosodescrip ,
                                          int AV63Obrasocialwwds_6_tfososigla_sels_size ,
                                          String AV62Obrasocialwwds_5_tfososigla ,
                                          int AV65Obrasocialwwds_8_tfosoc3992_sels_size ,
                                          String AV64Obrasocialwwds_7_tfosoc3992 ,
                                          java.math.BigDecimal AV66Obrasocialwwds_9_tfosoaporteadic ,
                                          java.math.BigDecimal AV67Obrasocialwwds_10_tfosoaporteadic_to ,
                                          int AV69Obrasocialwwds_12_tfosorelref_sels_size ,
                                          String AV68Obrasocialwwds_11_tfosorelref ,
                                          java.math.BigDecimal A893OsoAporteAdic ,
                                          int AV42CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[8];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliCod, OsoCod, OsoRelRef, OsoAporteAdic, OsoC3992, OsoSigla, OsoDescrip FROM ObraSocial" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV59Obrasocialwwds_2_tfosocod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV58Obrasocialwwds_1_tfosocod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OsoCod) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV59Obrasocialwwds_2_tfosocod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV59Obrasocialwwds_2_tfosocod_sels, "OsoCod IN (", ")")+")");
      }
      if ( ( AV61Obrasocialwwds_4_tfosodescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV60Obrasocialwwds_3_tfosodescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OsoDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV61Obrasocialwwds_4_tfosodescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Obrasocialwwds_4_tfosodescrip_sels, "OsoDescrip IN (", ")")+")");
      }
      if ( ( AV63Obrasocialwwds_6_tfososigla_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV62Obrasocialwwds_5_tfososigla)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OsoSigla) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV63Obrasocialwwds_6_tfososigla_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63Obrasocialwwds_6_tfososigla_sels, "OsoSigla IN (", ")")+")");
      }
      if ( ( AV65Obrasocialwwds_8_tfosoc3992_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV64Obrasocialwwds_7_tfosoc3992)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OsoC3992) like LOWER(?))");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( AV65Obrasocialwwds_8_tfosoc3992_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Obrasocialwwds_8_tfosoc3992_sels, "OsoC3992 IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66Obrasocialwwds_9_tfosoaporteadic)==0) )
      {
         addWhere(sWhereString, "(OsoAporteAdic >= ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67Obrasocialwwds_10_tfosoaporteadic_to)==0) )
      {
         addWhere(sWhereString, "(OsoAporteAdic <= ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( ( AV69Obrasocialwwds_12_tfosorelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV68Obrasocialwwds_11_tfosorelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OsoRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( AV69Obrasocialwwds_12_tfosorelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69Obrasocialwwds_12_tfosorelref_sels, "OsoRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, OsoCod" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P006G3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A5OsoCod ,
                                          GXSimpleCollection<String> AV59Obrasocialwwds_2_tfosocod_sels ,
                                          String A307OsoDescrip ,
                                          GXSimpleCollection<String> AV61Obrasocialwwds_4_tfosodescrip_sels ,
                                          String A392OsoSigla ,
                                          GXSimpleCollection<String> AV63Obrasocialwwds_6_tfososigla_sels ,
                                          String A306OsoC3992 ,
                                          GXSimpleCollection<String> AV65Obrasocialwwds_8_tfosoc3992_sels ,
                                          String A2014OsoRelRef ,
                                          GXSimpleCollection<String> AV69Obrasocialwwds_12_tfosorelref_sels ,
                                          int AV59Obrasocialwwds_2_tfosocod_sels_size ,
                                          String AV58Obrasocialwwds_1_tfosocod ,
                                          int AV61Obrasocialwwds_4_tfosodescrip_sels_size ,
                                          String AV60Obrasocialwwds_3_tfosodescrip ,
                                          int AV63Obrasocialwwds_6_tfososigla_sels_size ,
                                          String AV62Obrasocialwwds_5_tfososigla ,
                                          int AV65Obrasocialwwds_8_tfosoc3992_sels_size ,
                                          String AV64Obrasocialwwds_7_tfosoc3992 ,
                                          java.math.BigDecimal AV66Obrasocialwwds_9_tfosoaporteadic ,
                                          java.math.BigDecimal AV67Obrasocialwwds_10_tfosoaporteadic_to ,
                                          int AV69Obrasocialwwds_12_tfosorelref_sels_size ,
                                          String AV68Obrasocialwwds_11_tfosorelref ,
                                          java.math.BigDecimal A893OsoAporteAdic ,
                                          int AV42CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[8];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT CliCod, OsoDescrip, OsoRelRef, OsoAporteAdic, OsoC3992, OsoSigla, OsoCod FROM ObraSocial" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV59Obrasocialwwds_2_tfosocod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV58Obrasocialwwds_1_tfosocod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OsoCod) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV59Obrasocialwwds_2_tfosocod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV59Obrasocialwwds_2_tfosocod_sels, "OsoCod IN (", ")")+")");
      }
      if ( ( AV61Obrasocialwwds_4_tfosodescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV60Obrasocialwwds_3_tfosodescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OsoDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV61Obrasocialwwds_4_tfosodescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Obrasocialwwds_4_tfosodescrip_sels, "OsoDescrip IN (", ")")+")");
      }
      if ( ( AV63Obrasocialwwds_6_tfososigla_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV62Obrasocialwwds_5_tfososigla)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OsoSigla) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV63Obrasocialwwds_6_tfososigla_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63Obrasocialwwds_6_tfososigla_sels, "OsoSigla IN (", ")")+")");
      }
      if ( ( AV65Obrasocialwwds_8_tfosoc3992_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV64Obrasocialwwds_7_tfosoc3992)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OsoC3992) like LOWER(?))");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( AV65Obrasocialwwds_8_tfosoc3992_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Obrasocialwwds_8_tfosoc3992_sels, "OsoC3992 IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66Obrasocialwwds_9_tfosoaporteadic)==0) )
      {
         addWhere(sWhereString, "(OsoAporteAdic >= ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67Obrasocialwwds_10_tfosoaporteadic_to)==0) )
      {
         addWhere(sWhereString, "(OsoAporteAdic <= ?)");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( ( AV69Obrasocialwwds_12_tfosorelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV68Obrasocialwwds_11_tfosorelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OsoRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( AV69Obrasocialwwds_12_tfosorelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69Obrasocialwwds_12_tfosorelref_sels, "OsoRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, OsoDescrip" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P006G4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A5OsoCod ,
                                          GXSimpleCollection<String> AV59Obrasocialwwds_2_tfosocod_sels ,
                                          String A307OsoDescrip ,
                                          GXSimpleCollection<String> AV61Obrasocialwwds_4_tfosodescrip_sels ,
                                          String A392OsoSigla ,
                                          GXSimpleCollection<String> AV63Obrasocialwwds_6_tfososigla_sels ,
                                          String A306OsoC3992 ,
                                          GXSimpleCollection<String> AV65Obrasocialwwds_8_tfosoc3992_sels ,
                                          String A2014OsoRelRef ,
                                          GXSimpleCollection<String> AV69Obrasocialwwds_12_tfosorelref_sels ,
                                          int AV59Obrasocialwwds_2_tfosocod_sels_size ,
                                          String AV58Obrasocialwwds_1_tfosocod ,
                                          int AV61Obrasocialwwds_4_tfosodescrip_sels_size ,
                                          String AV60Obrasocialwwds_3_tfosodescrip ,
                                          int AV63Obrasocialwwds_6_tfososigla_sels_size ,
                                          String AV62Obrasocialwwds_5_tfososigla ,
                                          int AV65Obrasocialwwds_8_tfosoc3992_sels_size ,
                                          String AV64Obrasocialwwds_7_tfosoc3992 ,
                                          java.math.BigDecimal AV66Obrasocialwwds_9_tfosoaporteadic ,
                                          java.math.BigDecimal AV67Obrasocialwwds_10_tfosoaporteadic_to ,
                                          int AV69Obrasocialwwds_12_tfosorelref_sels_size ,
                                          String AV68Obrasocialwwds_11_tfosorelref ,
                                          java.math.BigDecimal A893OsoAporteAdic ,
                                          int A3CliCod ,
                                          int AV42CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[8];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT CliCod, OsoSigla, OsoRelRef, OsoAporteAdic, OsoC3992, OsoDescrip, OsoCod FROM ObraSocial" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV59Obrasocialwwds_2_tfosocod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV58Obrasocialwwds_1_tfosocod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OsoCod) like LOWER(?))");
      }
      else
      {
         GXv_int14[1] = (byte)(1) ;
      }
      if ( AV59Obrasocialwwds_2_tfosocod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV59Obrasocialwwds_2_tfosocod_sels, "OsoCod IN (", ")")+")");
      }
      if ( ( AV61Obrasocialwwds_4_tfosodescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV60Obrasocialwwds_3_tfosodescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OsoDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( AV61Obrasocialwwds_4_tfosodescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Obrasocialwwds_4_tfosodescrip_sels, "OsoDescrip IN (", ")")+")");
      }
      if ( ( AV63Obrasocialwwds_6_tfososigla_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV62Obrasocialwwds_5_tfososigla)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OsoSigla) like LOWER(?))");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( AV63Obrasocialwwds_6_tfososigla_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63Obrasocialwwds_6_tfososigla_sels, "OsoSigla IN (", ")")+")");
      }
      if ( ( AV65Obrasocialwwds_8_tfosoc3992_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV64Obrasocialwwds_7_tfosoc3992)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OsoC3992) like LOWER(?))");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( AV65Obrasocialwwds_8_tfosoc3992_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Obrasocialwwds_8_tfosoc3992_sels, "OsoC3992 IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66Obrasocialwwds_9_tfosoaporteadic)==0) )
      {
         addWhere(sWhereString, "(OsoAporteAdic >= ?)");
      }
      else
      {
         GXv_int14[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67Obrasocialwwds_10_tfosoaporteadic_to)==0) )
      {
         addWhere(sWhereString, "(OsoAporteAdic <= ?)");
      }
      else
      {
         GXv_int14[6] = (byte)(1) ;
      }
      if ( ( AV69Obrasocialwwds_12_tfosorelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV68Obrasocialwwds_11_tfosorelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OsoRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int14[7] = (byte)(1) ;
      }
      if ( AV69Obrasocialwwds_12_tfosorelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69Obrasocialwwds_12_tfosorelref_sels, "OsoRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY OsoSigla" ;
      GXv_Object15[0] = scmdbuf ;
      GXv_Object15[1] = GXv_int14 ;
      return GXv_Object15 ;
   }

   protected Object[] conditional_P006G5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A5OsoCod ,
                                          GXSimpleCollection<String> AV59Obrasocialwwds_2_tfosocod_sels ,
                                          String A307OsoDescrip ,
                                          GXSimpleCollection<String> AV61Obrasocialwwds_4_tfosodescrip_sels ,
                                          String A392OsoSigla ,
                                          GXSimpleCollection<String> AV63Obrasocialwwds_6_tfososigla_sels ,
                                          String A306OsoC3992 ,
                                          GXSimpleCollection<String> AV65Obrasocialwwds_8_tfosoc3992_sels ,
                                          String A2014OsoRelRef ,
                                          GXSimpleCollection<String> AV69Obrasocialwwds_12_tfosorelref_sels ,
                                          int AV59Obrasocialwwds_2_tfosocod_sels_size ,
                                          String AV58Obrasocialwwds_1_tfosocod ,
                                          int AV61Obrasocialwwds_4_tfosodescrip_sels_size ,
                                          String AV60Obrasocialwwds_3_tfosodescrip ,
                                          int AV63Obrasocialwwds_6_tfososigla_sels_size ,
                                          String AV62Obrasocialwwds_5_tfososigla ,
                                          int AV65Obrasocialwwds_8_tfosoc3992_sels_size ,
                                          String AV64Obrasocialwwds_7_tfosoc3992 ,
                                          java.math.BigDecimal AV66Obrasocialwwds_9_tfosoaporteadic ,
                                          java.math.BigDecimal AV67Obrasocialwwds_10_tfosoaporteadic_to ,
                                          int AV69Obrasocialwwds_12_tfosorelref_sels_size ,
                                          String AV68Obrasocialwwds_11_tfosorelref ,
                                          java.math.BigDecimal A893OsoAporteAdic ,
                                          int AV42CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int17 = new byte[8];
      Object[] GXv_Object18 = new Object[2];
      scmdbuf = "SELECT CliCod, OsoC3992, OsoRelRef, OsoAporteAdic, OsoSigla, OsoDescrip, OsoCod FROM ObraSocial" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV59Obrasocialwwds_2_tfosocod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV58Obrasocialwwds_1_tfosocod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OsoCod) like LOWER(?))");
      }
      else
      {
         GXv_int17[1] = (byte)(1) ;
      }
      if ( AV59Obrasocialwwds_2_tfosocod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV59Obrasocialwwds_2_tfosocod_sels, "OsoCod IN (", ")")+")");
      }
      if ( ( AV61Obrasocialwwds_4_tfosodescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV60Obrasocialwwds_3_tfosodescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OsoDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int17[2] = (byte)(1) ;
      }
      if ( AV61Obrasocialwwds_4_tfosodescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Obrasocialwwds_4_tfosodescrip_sels, "OsoDescrip IN (", ")")+")");
      }
      if ( ( AV63Obrasocialwwds_6_tfososigla_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV62Obrasocialwwds_5_tfososigla)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OsoSigla) like LOWER(?))");
      }
      else
      {
         GXv_int17[3] = (byte)(1) ;
      }
      if ( AV63Obrasocialwwds_6_tfososigla_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63Obrasocialwwds_6_tfososigla_sels, "OsoSigla IN (", ")")+")");
      }
      if ( ( AV65Obrasocialwwds_8_tfosoc3992_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV64Obrasocialwwds_7_tfosoc3992)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OsoC3992) like LOWER(?))");
      }
      else
      {
         GXv_int17[4] = (byte)(1) ;
      }
      if ( AV65Obrasocialwwds_8_tfosoc3992_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Obrasocialwwds_8_tfosoc3992_sels, "OsoC3992 IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66Obrasocialwwds_9_tfosoaporteadic)==0) )
      {
         addWhere(sWhereString, "(OsoAporteAdic >= ?)");
      }
      else
      {
         GXv_int17[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67Obrasocialwwds_10_tfosoaporteadic_to)==0) )
      {
         addWhere(sWhereString, "(OsoAporteAdic <= ?)");
      }
      else
      {
         GXv_int17[6] = (byte)(1) ;
      }
      if ( ( AV69Obrasocialwwds_12_tfosorelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV68Obrasocialwwds_11_tfosorelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OsoRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int17[7] = (byte)(1) ;
      }
      if ( AV69Obrasocialwwds_12_tfosorelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69Obrasocialwwds_12_tfosorelref_sels, "OsoRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, OsoC3992" ;
      GXv_Object18[0] = scmdbuf ;
      GXv_Object18[1] = GXv_int17 ;
      return GXv_Object18 ;
   }

   protected Object[] conditional_P006G6( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A5OsoCod ,
                                          GXSimpleCollection<String> AV59Obrasocialwwds_2_tfosocod_sels ,
                                          String A307OsoDescrip ,
                                          GXSimpleCollection<String> AV61Obrasocialwwds_4_tfosodescrip_sels ,
                                          String A392OsoSigla ,
                                          GXSimpleCollection<String> AV63Obrasocialwwds_6_tfososigla_sels ,
                                          String A306OsoC3992 ,
                                          GXSimpleCollection<String> AV65Obrasocialwwds_8_tfosoc3992_sels ,
                                          String A2014OsoRelRef ,
                                          GXSimpleCollection<String> AV69Obrasocialwwds_12_tfosorelref_sels ,
                                          int AV59Obrasocialwwds_2_tfosocod_sels_size ,
                                          String AV58Obrasocialwwds_1_tfosocod ,
                                          int AV61Obrasocialwwds_4_tfosodescrip_sels_size ,
                                          String AV60Obrasocialwwds_3_tfosodescrip ,
                                          int AV63Obrasocialwwds_6_tfososigla_sels_size ,
                                          String AV62Obrasocialwwds_5_tfososigla ,
                                          int AV65Obrasocialwwds_8_tfosoc3992_sels_size ,
                                          String AV64Obrasocialwwds_7_tfosoc3992 ,
                                          java.math.BigDecimal AV66Obrasocialwwds_9_tfosoaporteadic ,
                                          java.math.BigDecimal AV67Obrasocialwwds_10_tfosoaporteadic_to ,
                                          int AV69Obrasocialwwds_12_tfosorelref_sels_size ,
                                          String AV68Obrasocialwwds_11_tfosorelref ,
                                          java.math.BigDecimal A893OsoAporteAdic ,
                                          int A3CliCod ,
                                          int AV42CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int20 = new byte[8];
      Object[] GXv_Object21 = new Object[2];
      scmdbuf = "SELECT CliCod, OsoRelRef, OsoAporteAdic, OsoC3992, OsoSigla, OsoDescrip, OsoCod FROM ObraSocial" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV59Obrasocialwwds_2_tfosocod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV58Obrasocialwwds_1_tfosocod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OsoCod) like LOWER(?))");
      }
      else
      {
         GXv_int20[1] = (byte)(1) ;
      }
      if ( AV59Obrasocialwwds_2_tfosocod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV59Obrasocialwwds_2_tfosocod_sels, "OsoCod IN (", ")")+")");
      }
      if ( ( AV61Obrasocialwwds_4_tfosodescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV60Obrasocialwwds_3_tfosodescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OsoDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int20[2] = (byte)(1) ;
      }
      if ( AV61Obrasocialwwds_4_tfosodescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Obrasocialwwds_4_tfosodescrip_sels, "OsoDescrip IN (", ")")+")");
      }
      if ( ( AV63Obrasocialwwds_6_tfososigla_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV62Obrasocialwwds_5_tfososigla)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OsoSigla) like LOWER(?))");
      }
      else
      {
         GXv_int20[3] = (byte)(1) ;
      }
      if ( AV63Obrasocialwwds_6_tfososigla_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63Obrasocialwwds_6_tfososigla_sels, "OsoSigla IN (", ")")+")");
      }
      if ( ( AV65Obrasocialwwds_8_tfosoc3992_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV64Obrasocialwwds_7_tfosoc3992)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OsoC3992) like LOWER(?))");
      }
      else
      {
         GXv_int20[4] = (byte)(1) ;
      }
      if ( AV65Obrasocialwwds_8_tfosoc3992_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Obrasocialwwds_8_tfosoc3992_sels, "OsoC3992 IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66Obrasocialwwds_9_tfosoaporteadic)==0) )
      {
         addWhere(sWhereString, "(OsoAporteAdic >= ?)");
      }
      else
      {
         GXv_int20[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67Obrasocialwwds_10_tfosoaporteadic_to)==0) )
      {
         addWhere(sWhereString, "(OsoAporteAdic <= ?)");
      }
      else
      {
         GXv_int20[6] = (byte)(1) ;
      }
      if ( ( AV69Obrasocialwwds_12_tfosorelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV68Obrasocialwwds_11_tfosorelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OsoRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int20[7] = (byte)(1) ;
      }
      if ( AV69Obrasocialwwds_12_tfosorelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69Obrasocialwwds_12_tfosorelref_sels, "OsoRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY OsoRelRef" ;
      GXv_Object21[0] = scmdbuf ;
      GXv_Object21[1] = GXv_int20 ;
      return GXv_Object21 ;
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
                  return conditional_P006G2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (String)dynConstraints[21] , (java.math.BigDecimal)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).intValue() );
            case 1 :
                  return conditional_P006G3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (String)dynConstraints[21] , (java.math.BigDecimal)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).intValue() );
            case 2 :
                  return conditional_P006G4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (String)dynConstraints[21] , (java.math.BigDecimal)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).intValue() );
            case 3 :
                  return conditional_P006G5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (String)dynConstraints[21] , (java.math.BigDecimal)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).intValue() );
            case 4 :
                  return conditional_P006G6(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (String)dynConstraints[21] , (java.math.BigDecimal)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006G2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006G3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006G4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006G5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006G6", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(6, 20);
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(6, 20);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(4,2);
               ((String[]) buf[5])[0] = rslt.getString(5, 20);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(5, 20);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
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
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[12], 20);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[13], 2);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[14], 2);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 40);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[12], 20);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[13], 2);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[14], 2);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 40);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[12], 20);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[13], 2);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[14], 2);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 40);
               }
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[12], 20);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[13], 2);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[14], 2);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 40);
               }
               return;
            case 4 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[12], 20);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[13], 2);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[14], 2);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 40);
               }
               return;
      }
   }

}

