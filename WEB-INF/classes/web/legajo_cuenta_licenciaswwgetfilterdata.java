package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class legajo_cuenta_licenciaswwgetfilterdata extends GXProcedure
{
   public legajo_cuenta_licenciaswwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajo_cuenta_licenciaswwgetfilterdata.class ), "" );
   }

   public legajo_cuenta_licenciaswwgetfilterdata( int remoteHandle ,
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
      legajo_cuenta_licenciaswwgetfilterdata.this.aP5 = new String[] {""};
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
      legajo_cuenta_licenciaswwgetfilterdata.this.AV48DDOName = aP0;
      legajo_cuenta_licenciaswwgetfilterdata.this.AV49SearchTxt = aP1;
      legajo_cuenta_licenciaswwgetfilterdata.this.AV50SearchTxtTo = aP2;
      legajo_cuenta_licenciaswwgetfilterdata.this.aP3 = aP3;
      legajo_cuenta_licenciaswwgetfilterdata.this.aP4 = aP4;
      legajo_cuenta_licenciaswwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV55EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      legajo_cuenta_licenciaswwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV55EmpCod = GXt_int1 ;
      GXt_int3 = AV56CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      legajo_cuenta_licenciaswwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV56CliCod = GXt_int3 ;
      AV38Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV40OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV41OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWlegajo_cuenta_licencias", GXv_boolean6) ;
      legajo_cuenta_licenciaswwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV48DDOName), "DDO_LEGIDNOMAPE") == 0 )
         {
            /* Execute user subroutine: 'LOADLEGIDNOMAPEOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV48DDOName), "DDO_LEGCUEANTABR") == 0 )
         {
            /* Execute user subroutine: 'LOADLEGCUEANTABROPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV51OptionsJson = AV38Options.toJSonString(false) ;
      AV52OptionsDescJson = AV40OptionsDesc.toJSonString(false) ;
      AV53OptionIndexesJson = AV41OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV43Session.getValue("legajo_cuenta_licenciasWWGridState"), "") == 0 )
      {
         AV45GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "legajo_cuenta_licenciasWWGridState"), null, null);
      }
      else
      {
         AV45GridState.fromxml(AV43Session.getValue("legajo_cuenta_licenciasWWGridState"), null, null);
      }
      AV71GXV1 = 1 ;
      while ( AV71GXV1 <= AV45GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV46GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV45GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV71GXV1));
         if ( GXutil.strcmp(AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCUENANIO") == 0 )
         {
            AV15TFLegCuenAnio = (short)(GXutil.lval( AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV16TFLegCuenAnio_To = (short)(GXutil.lval( AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGIDNOMAPE") == 0 )
         {
            AV60TFLegIdNomApe = AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGIDNOMAPE_SEL") == 0 )
         {
            AV59TFLegIdNomApe_SelsJson = AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV61TFLegIdNomApe_Sels.fromJSonString(AV59TFLegIdNomApe_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCUENLICTPO_SEL") == 0 )
         {
            AV13TFLegCuenLicTpo_SelsJson = AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV14TFLegCuenLicTpo_Sels.fromJSonString(AV13TFLegCuenLicTpo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCUEANTABR") == 0 )
         {
            AV67TFLegCueAntAbr = AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCUEANTABR_SEL") == 0 )
         {
            AV66TFLegCueAntAbr_SelsJson = AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV68TFLegCueAntAbr_Sels.fromJSonString(AV66TFLegCueAntAbr_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCUENDIASCORRES") == 0 )
         {
            AV24TFLegCuenDiasCorres = (short)(GXutil.lval( AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV25TFLegCuenDiasCorres_To = (short)(GXutil.lval( AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCULIPANT") == 0 )
         {
            AV26TFLegCuLiPAnt = (short)(GXutil.lval( AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV27TFLegCuLiPAnt_To = (short)(GXutil.lval( AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCULACTVEN") == 0 )
         {
            AV62TFLegCuLActVen = (short)(GXutil.lval( AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV63TFLegCuLActVen_To = (short)(GXutil.lval( AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCULIPVEN") == 0 )
         {
            AV28TFLegCuLiPVen = (short)(GXutil.lval( AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV29TFLegCuLiPVen_To = (short)(GXutil.lval( AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCULIPCUR") == 0 )
         {
            AV30TFLegCuLiPCur = (short)(GXutil.lval( AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV31TFLegCuLiPCur_To = (short)(GXutil.lval( AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCULIPAPR") == 0 )
         {
            AV57TFLegCuLiPApr = (short)(GXutil.lval( AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV58TFLegCuLiPApr_To = (short)(GXutil.lval( AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCUENDIASGOZ") == 0 )
         {
            AV34TFLegCuenDiasGoz = (short)(GXutil.lval( AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV35TFLegCuenDiasGoz_To = (short)(GXutil.lval( AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCULIPSALDO") == 0 )
         {
            AV32TFLegCuLiPSaldo = (short)(GXutil.lval( AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV33TFLegCuLiPSaldo_To = (short)(GXutil.lval( AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV54MenuOpcCod = AV46GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV71GXV1 = (int)(AV71GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADLEGIDNOMAPEOPTIONS' Routine */
      returnInSub = false ;
      AV60TFLegIdNomApe = AV49SearchTxt ;
      AV61TFLegIdNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV73Legajo_cuenta_licenciaswwds_1_tflegcuenanio = AV15TFLegCuenAnio ;
      AV74Legajo_cuenta_licenciaswwds_2_tflegcuenanio_to = AV16TFLegCuenAnio_To ;
      AV75Legajo_cuenta_licenciaswwds_3_tflegidnomape = AV60TFLegIdNomApe ;
      AV76Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels = AV61TFLegIdNomApe_Sels ;
      AV77Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels = AV14TFLegCuenLicTpo_Sels ;
      AV78Legajo_cuenta_licenciaswwds_6_tflegcueantabr = AV67TFLegCueAntAbr ;
      AV79Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels = AV68TFLegCueAntAbr_Sels ;
      AV80Legajo_cuenta_licenciaswwds_8_tflegcuendiascorres = AV24TFLegCuenDiasCorres ;
      AV81Legajo_cuenta_licenciaswwds_9_tflegcuendiascorres_to = AV25TFLegCuenDiasCorres_To ;
      AV82Legajo_cuenta_licenciaswwds_10_tflegculipant = AV26TFLegCuLiPAnt ;
      AV83Legajo_cuenta_licenciaswwds_11_tflegculipant_to = AV27TFLegCuLiPAnt_To ;
      AV84Legajo_cuenta_licenciaswwds_12_tflegculactven = AV62TFLegCuLActVen ;
      AV85Legajo_cuenta_licenciaswwds_13_tflegculactven_to = AV63TFLegCuLActVen_To ;
      AV86Legajo_cuenta_licenciaswwds_14_tflegculipven = AV28TFLegCuLiPVen ;
      AV87Legajo_cuenta_licenciaswwds_15_tflegculipven_to = AV29TFLegCuLiPVen_To ;
      AV88Legajo_cuenta_licenciaswwds_16_tflegculipcur = AV30TFLegCuLiPCur ;
      AV89Legajo_cuenta_licenciaswwds_17_tflegculipcur_to = AV31TFLegCuLiPCur_To ;
      AV90Legajo_cuenta_licenciaswwds_18_tflegculipapr = AV57TFLegCuLiPApr ;
      AV91Legajo_cuenta_licenciaswwds_19_tflegculipapr_to = AV58TFLegCuLiPApr_To ;
      AV92Legajo_cuenta_licenciaswwds_20_tflegcuendiasgoz = AV34TFLegCuenDiasGoz ;
      AV93Legajo_cuenta_licenciaswwds_21_tflegcuendiasgoz_to = AV35TFLegCuenDiasGoz_To ;
      AV94Legajo_cuenta_licenciaswwds_22_tflegculipsaldo = AV32TFLegCuLiPSaldo ;
      AV95Legajo_cuenta_licenciaswwds_23_tflegculipsaldo_to = AV33TFLegCuLiPSaldo_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A250LegIdNomApe ,
                                           AV76Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels ,
                                           A2243LegCuenLicTpo ,
                                           AV77Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels ,
                                           A2328LegCueAntAbr ,
                                           AV79Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels ,
                                           Short.valueOf(AV73Legajo_cuenta_licenciaswwds_1_tflegcuenanio) ,
                                           Short.valueOf(AV74Legajo_cuenta_licenciaswwds_2_tflegcuenanio_to) ,
                                           Integer.valueOf(AV76Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels.size()) ,
                                           AV75Legajo_cuenta_licenciaswwds_3_tflegidnomape ,
                                           Integer.valueOf(AV77Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels.size()) ,
                                           Integer.valueOf(AV79Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels.size()) ,
                                           AV78Legajo_cuenta_licenciaswwds_6_tflegcueantabr ,
                                           Short.valueOf(AV80Legajo_cuenta_licenciaswwds_8_tflegcuendiascorres) ,
                                           Short.valueOf(AV81Legajo_cuenta_licenciaswwds_9_tflegcuendiascorres_to) ,
                                           Short.valueOf(AV82Legajo_cuenta_licenciaswwds_10_tflegculipant) ,
                                           Short.valueOf(AV83Legajo_cuenta_licenciaswwds_11_tflegculipant_to) ,
                                           Short.valueOf(AV84Legajo_cuenta_licenciaswwds_12_tflegculactven) ,
                                           Short.valueOf(AV85Legajo_cuenta_licenciaswwds_13_tflegculactven_to) ,
                                           Short.valueOf(AV86Legajo_cuenta_licenciaswwds_14_tflegculipven) ,
                                           Short.valueOf(AV87Legajo_cuenta_licenciaswwds_15_tflegculipven_to) ,
                                           Short.valueOf(AV88Legajo_cuenta_licenciaswwds_16_tflegculipcur) ,
                                           Short.valueOf(AV89Legajo_cuenta_licenciaswwds_17_tflegculipcur_to) ,
                                           Short.valueOf(AV90Legajo_cuenta_licenciaswwds_18_tflegculipapr) ,
                                           Short.valueOf(AV91Legajo_cuenta_licenciaswwds_19_tflegculipapr_to) ,
                                           Short.valueOf(AV92Legajo_cuenta_licenciaswwds_20_tflegcuendiasgoz) ,
                                           Short.valueOf(AV93Legajo_cuenta_licenciaswwds_21_tflegcuendiasgoz_to) ,
                                           Short.valueOf(AV94Legajo_cuenta_licenciaswwds_22_tflegculipsaldo) ,
                                           Short.valueOf(AV95Legajo_cuenta_licenciaswwds_23_tflegculipsaldo_to) ,
                                           Short.valueOf(A2266LegCuenAnio) ,
                                           Short.valueOf(A2247LegCuenDiasCorres) ,
                                           Short.valueOf(A2303LegCuLiPAnt) ,
                                           Short.valueOf(A2315LegCuLActVen) ,
                                           Short.valueOf(A2304LegCuLiPVen) ,
                                           Short.valueOf(A2302LegCuLiPCur) ,
                                           Short.valueOf(A2306LegCuLiPApr) ,
                                           Short.valueOf(A2248LegCuenDiasGoz) ,
                                           Short.valueOf(A2305LegCuLiPSaldo) ,
                                           Integer.valueOf(AV56CliCod) ,
                                           Short.valueOf(AV55EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV75Legajo_cuenta_licenciaswwds_3_tflegidnomape = GXutil.concat( GXutil.rtrim( AV75Legajo_cuenta_licenciaswwds_3_tflegidnomape), "%", "") ;
      lV78Legajo_cuenta_licenciaswwds_6_tflegcueantabr = GXutil.concat( GXutil.rtrim( AV78Legajo_cuenta_licenciaswwds_6_tflegcueantabr), "%", "") ;
      /* Using cursor P02AB2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV56CliCod), Short.valueOf(AV55EmpCod), Short.valueOf(AV73Legajo_cuenta_licenciaswwds_1_tflegcuenanio), Short.valueOf(AV74Legajo_cuenta_licenciaswwds_2_tflegcuenanio_to), lV75Legajo_cuenta_licenciaswwds_3_tflegidnomape, lV78Legajo_cuenta_licenciaswwds_6_tflegcueantabr, Short.valueOf(AV80Legajo_cuenta_licenciaswwds_8_tflegcuendiascorres), Short.valueOf(AV81Legajo_cuenta_licenciaswwds_9_tflegcuendiascorres_to), Short.valueOf(AV82Legajo_cuenta_licenciaswwds_10_tflegculipant), Short.valueOf(AV83Legajo_cuenta_licenciaswwds_11_tflegculipant_to), Short.valueOf(AV84Legajo_cuenta_licenciaswwds_12_tflegculactven), Short.valueOf(AV85Legajo_cuenta_licenciaswwds_13_tflegculactven_to), Short.valueOf(AV86Legajo_cuenta_licenciaswwds_14_tflegculipven), Short.valueOf(AV87Legajo_cuenta_licenciaswwds_15_tflegculipven_to), Short.valueOf(AV88Legajo_cuenta_licenciaswwds_16_tflegculipcur), Short.valueOf(AV89Legajo_cuenta_licenciaswwds_17_tflegculipcur_to), Short.valueOf(AV90Legajo_cuenta_licenciaswwds_18_tflegculipapr), Short.valueOf(AV91Legajo_cuenta_licenciaswwds_19_tflegculipapr_to), Short.valueOf(AV92Legajo_cuenta_licenciaswwds_20_tflegcuendiasgoz), Short.valueOf(AV93Legajo_cuenta_licenciaswwds_21_tflegcuendiasgoz_to), Short.valueOf(AV94Legajo_cuenta_licenciaswwds_22_tflegculipsaldo), Short.valueOf(AV95Legajo_cuenta_licenciaswwds_23_tflegculipsaldo_to)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk2AB2 = false ;
         A6LegNumero = P02AB2_A6LegNumero[0] ;
         A1EmpCod = P02AB2_A1EmpCod[0] ;
         A3CliCod = P02AB2_A3CliCod[0] ;
         A2305LegCuLiPSaldo = P02AB2_A2305LegCuLiPSaldo[0] ;
         A2248LegCuenDiasGoz = P02AB2_A2248LegCuenDiasGoz[0] ;
         A2306LegCuLiPApr = P02AB2_A2306LegCuLiPApr[0] ;
         A2302LegCuLiPCur = P02AB2_A2302LegCuLiPCur[0] ;
         A2304LegCuLiPVen = P02AB2_A2304LegCuLiPVen[0] ;
         A2315LegCuLActVen = P02AB2_A2315LegCuLActVen[0] ;
         A2303LegCuLiPAnt = P02AB2_A2303LegCuLiPAnt[0] ;
         A2247LegCuenDiasCorres = P02AB2_A2247LegCuenDiasCorres[0] ;
         A2328LegCueAntAbr = P02AB2_A2328LegCueAntAbr[0] ;
         A2243LegCuenLicTpo = P02AB2_A2243LegCuenLicTpo[0] ;
         A250LegIdNomApe = P02AB2_A250LegIdNomApe[0] ;
         A2266LegCuenAnio = P02AB2_A2266LegCuenAnio[0] ;
         A250LegIdNomApe = P02AB2_A250LegIdNomApe[0] ;
         AV42count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P02AB2_A3CliCod[0] == A3CliCod ) && ( P02AB2_A1EmpCod[0] == A1EmpCod ) && ( P02AB2_A6LegNumero[0] == A6LegNumero ) )
         {
            brk2AB2 = false ;
            A2243LegCuenLicTpo = P02AB2_A2243LegCuenLicTpo[0] ;
            A2266LegCuenAnio = P02AB2_A2266LegCuenAnio[0] ;
            AV42count = (long)(AV42count+1) ;
            brk2AB2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A250LegIdNomApe)==0) )
         {
            AV37Option = A250LegIdNomApe ;
            AV36InsertIndex = 1 ;
            while ( ( AV36InsertIndex <= AV38Options.size() ) && ( GXutil.strcmp((String)AV38Options.elementAt(-1+AV36InsertIndex), AV37Option) < 0 ) )
            {
               AV36InsertIndex = (int)(AV36InsertIndex+1) ;
            }
            AV38Options.add(AV37Option, AV36InsertIndex);
            AV41OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV42count), "Z,ZZZ,ZZZ,ZZ9")), AV36InsertIndex);
         }
         if ( AV38Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2AB2 )
         {
            brk2AB2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADLEGCUEANTABROPTIONS' Routine */
      returnInSub = false ;
      AV67TFLegCueAntAbr = AV49SearchTxt ;
      AV68TFLegCueAntAbr_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV73Legajo_cuenta_licenciaswwds_1_tflegcuenanio = AV15TFLegCuenAnio ;
      AV74Legajo_cuenta_licenciaswwds_2_tflegcuenanio_to = AV16TFLegCuenAnio_To ;
      AV75Legajo_cuenta_licenciaswwds_3_tflegidnomape = AV60TFLegIdNomApe ;
      AV76Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels = AV61TFLegIdNomApe_Sels ;
      AV77Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels = AV14TFLegCuenLicTpo_Sels ;
      AV78Legajo_cuenta_licenciaswwds_6_tflegcueantabr = AV67TFLegCueAntAbr ;
      AV79Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels = AV68TFLegCueAntAbr_Sels ;
      AV80Legajo_cuenta_licenciaswwds_8_tflegcuendiascorres = AV24TFLegCuenDiasCorres ;
      AV81Legajo_cuenta_licenciaswwds_9_tflegcuendiascorres_to = AV25TFLegCuenDiasCorres_To ;
      AV82Legajo_cuenta_licenciaswwds_10_tflegculipant = AV26TFLegCuLiPAnt ;
      AV83Legajo_cuenta_licenciaswwds_11_tflegculipant_to = AV27TFLegCuLiPAnt_To ;
      AV84Legajo_cuenta_licenciaswwds_12_tflegculactven = AV62TFLegCuLActVen ;
      AV85Legajo_cuenta_licenciaswwds_13_tflegculactven_to = AV63TFLegCuLActVen_To ;
      AV86Legajo_cuenta_licenciaswwds_14_tflegculipven = AV28TFLegCuLiPVen ;
      AV87Legajo_cuenta_licenciaswwds_15_tflegculipven_to = AV29TFLegCuLiPVen_To ;
      AV88Legajo_cuenta_licenciaswwds_16_tflegculipcur = AV30TFLegCuLiPCur ;
      AV89Legajo_cuenta_licenciaswwds_17_tflegculipcur_to = AV31TFLegCuLiPCur_To ;
      AV90Legajo_cuenta_licenciaswwds_18_tflegculipapr = AV57TFLegCuLiPApr ;
      AV91Legajo_cuenta_licenciaswwds_19_tflegculipapr_to = AV58TFLegCuLiPApr_To ;
      AV92Legajo_cuenta_licenciaswwds_20_tflegcuendiasgoz = AV34TFLegCuenDiasGoz ;
      AV93Legajo_cuenta_licenciaswwds_21_tflegcuendiasgoz_to = AV35TFLegCuenDiasGoz_To ;
      AV94Legajo_cuenta_licenciaswwds_22_tflegculipsaldo = AV32TFLegCuLiPSaldo ;
      AV95Legajo_cuenta_licenciaswwds_23_tflegculipsaldo_to = AV33TFLegCuLiPSaldo_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A250LegIdNomApe ,
                                           AV76Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels ,
                                           A2243LegCuenLicTpo ,
                                           AV77Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels ,
                                           A2328LegCueAntAbr ,
                                           AV79Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels ,
                                           Short.valueOf(AV73Legajo_cuenta_licenciaswwds_1_tflegcuenanio) ,
                                           Short.valueOf(AV74Legajo_cuenta_licenciaswwds_2_tflegcuenanio_to) ,
                                           Integer.valueOf(AV76Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels.size()) ,
                                           AV75Legajo_cuenta_licenciaswwds_3_tflegidnomape ,
                                           Integer.valueOf(AV77Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels.size()) ,
                                           Integer.valueOf(AV79Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels.size()) ,
                                           AV78Legajo_cuenta_licenciaswwds_6_tflegcueantabr ,
                                           Short.valueOf(AV80Legajo_cuenta_licenciaswwds_8_tflegcuendiascorres) ,
                                           Short.valueOf(AV81Legajo_cuenta_licenciaswwds_9_tflegcuendiascorres_to) ,
                                           Short.valueOf(AV82Legajo_cuenta_licenciaswwds_10_tflegculipant) ,
                                           Short.valueOf(AV83Legajo_cuenta_licenciaswwds_11_tflegculipant_to) ,
                                           Short.valueOf(AV84Legajo_cuenta_licenciaswwds_12_tflegculactven) ,
                                           Short.valueOf(AV85Legajo_cuenta_licenciaswwds_13_tflegculactven_to) ,
                                           Short.valueOf(AV86Legajo_cuenta_licenciaswwds_14_tflegculipven) ,
                                           Short.valueOf(AV87Legajo_cuenta_licenciaswwds_15_tflegculipven_to) ,
                                           Short.valueOf(AV88Legajo_cuenta_licenciaswwds_16_tflegculipcur) ,
                                           Short.valueOf(AV89Legajo_cuenta_licenciaswwds_17_tflegculipcur_to) ,
                                           Short.valueOf(AV90Legajo_cuenta_licenciaswwds_18_tflegculipapr) ,
                                           Short.valueOf(AV91Legajo_cuenta_licenciaswwds_19_tflegculipapr_to) ,
                                           Short.valueOf(AV92Legajo_cuenta_licenciaswwds_20_tflegcuendiasgoz) ,
                                           Short.valueOf(AV93Legajo_cuenta_licenciaswwds_21_tflegcuendiasgoz_to) ,
                                           Short.valueOf(AV94Legajo_cuenta_licenciaswwds_22_tflegculipsaldo) ,
                                           Short.valueOf(AV95Legajo_cuenta_licenciaswwds_23_tflegculipsaldo_to) ,
                                           Short.valueOf(A2266LegCuenAnio) ,
                                           Short.valueOf(A2247LegCuenDiasCorres) ,
                                           Short.valueOf(A2303LegCuLiPAnt) ,
                                           Short.valueOf(A2315LegCuLActVen) ,
                                           Short.valueOf(A2304LegCuLiPVen) ,
                                           Short.valueOf(A2302LegCuLiPCur) ,
                                           Short.valueOf(A2306LegCuLiPApr) ,
                                           Short.valueOf(A2248LegCuenDiasGoz) ,
                                           Short.valueOf(A2305LegCuLiPSaldo) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV56CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV55EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV75Legajo_cuenta_licenciaswwds_3_tflegidnomape = GXutil.concat( GXutil.rtrim( AV75Legajo_cuenta_licenciaswwds_3_tflegidnomape), "%", "") ;
      lV78Legajo_cuenta_licenciaswwds_6_tflegcueantabr = GXutil.concat( GXutil.rtrim( AV78Legajo_cuenta_licenciaswwds_6_tflegcueantabr), "%", "") ;
      /* Using cursor P02AB3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV56CliCod), Short.valueOf(AV55EmpCod), Short.valueOf(AV73Legajo_cuenta_licenciaswwds_1_tflegcuenanio), Short.valueOf(AV74Legajo_cuenta_licenciaswwds_2_tflegcuenanio_to), lV75Legajo_cuenta_licenciaswwds_3_tflegidnomape, lV78Legajo_cuenta_licenciaswwds_6_tflegcueantabr, Short.valueOf(AV80Legajo_cuenta_licenciaswwds_8_tflegcuendiascorres), Short.valueOf(AV81Legajo_cuenta_licenciaswwds_9_tflegcuendiascorres_to), Short.valueOf(AV82Legajo_cuenta_licenciaswwds_10_tflegculipant), Short.valueOf(AV83Legajo_cuenta_licenciaswwds_11_tflegculipant_to), Short.valueOf(AV84Legajo_cuenta_licenciaswwds_12_tflegculactven), Short.valueOf(AV85Legajo_cuenta_licenciaswwds_13_tflegculactven_to), Short.valueOf(AV86Legajo_cuenta_licenciaswwds_14_tflegculipven), Short.valueOf(AV87Legajo_cuenta_licenciaswwds_15_tflegculipven_to), Short.valueOf(AV88Legajo_cuenta_licenciaswwds_16_tflegculipcur), Short.valueOf(AV89Legajo_cuenta_licenciaswwds_17_tflegculipcur_to), Short.valueOf(AV90Legajo_cuenta_licenciaswwds_18_tflegculipapr), Short.valueOf(AV91Legajo_cuenta_licenciaswwds_19_tflegculipapr_to), Short.valueOf(AV92Legajo_cuenta_licenciaswwds_20_tflegcuendiasgoz), Short.valueOf(AV93Legajo_cuenta_licenciaswwds_21_tflegcuendiasgoz_to), Short.valueOf(AV94Legajo_cuenta_licenciaswwds_22_tflegculipsaldo), Short.valueOf(AV95Legajo_cuenta_licenciaswwds_23_tflegculipsaldo_to)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk2AB4 = false ;
         A6LegNumero = P02AB3_A6LegNumero[0] ;
         A3CliCod = P02AB3_A3CliCod[0] ;
         A1EmpCod = P02AB3_A1EmpCod[0] ;
         A2328LegCueAntAbr = P02AB3_A2328LegCueAntAbr[0] ;
         A2305LegCuLiPSaldo = P02AB3_A2305LegCuLiPSaldo[0] ;
         A2248LegCuenDiasGoz = P02AB3_A2248LegCuenDiasGoz[0] ;
         A2306LegCuLiPApr = P02AB3_A2306LegCuLiPApr[0] ;
         A2302LegCuLiPCur = P02AB3_A2302LegCuLiPCur[0] ;
         A2304LegCuLiPVen = P02AB3_A2304LegCuLiPVen[0] ;
         A2315LegCuLActVen = P02AB3_A2315LegCuLActVen[0] ;
         A2303LegCuLiPAnt = P02AB3_A2303LegCuLiPAnt[0] ;
         A2247LegCuenDiasCorres = P02AB3_A2247LegCuenDiasCorres[0] ;
         A2243LegCuenLicTpo = P02AB3_A2243LegCuenLicTpo[0] ;
         A250LegIdNomApe = P02AB3_A250LegIdNomApe[0] ;
         A2266LegCuenAnio = P02AB3_A2266LegCuenAnio[0] ;
         A250LegIdNomApe = P02AB3_A250LegIdNomApe[0] ;
         AV42count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P02AB3_A2328LegCueAntAbr[0], A2328LegCueAntAbr) == 0 ) )
         {
            brk2AB4 = false ;
            A6LegNumero = P02AB3_A6LegNumero[0] ;
            A3CliCod = P02AB3_A3CliCod[0] ;
            A1EmpCod = P02AB3_A1EmpCod[0] ;
            A2243LegCuenLicTpo = P02AB3_A2243LegCuenLicTpo[0] ;
            A2266LegCuenAnio = P02AB3_A2266LegCuenAnio[0] ;
            AV42count = (long)(AV42count+1) ;
            brk2AB4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A2328LegCueAntAbr)==0) )
         {
            AV37Option = A2328LegCueAntAbr ;
            AV38Options.add(AV37Option, 0);
            AV41OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV42count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV38Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2AB4 )
         {
            brk2AB4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = legajo_cuenta_licenciaswwgetfilterdata.this.AV51OptionsJson;
      this.aP4[0] = legajo_cuenta_licenciaswwgetfilterdata.this.AV52OptionsDescJson;
      this.aP5[0] = legajo_cuenta_licenciaswwgetfilterdata.this.AV53OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV51OptionsJson = "" ;
      AV52OptionsDescJson = "" ;
      AV53OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV38Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV40OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV41OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV43Session = httpContext.getWebSession();
      AV45GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV46GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV60TFLegIdNomApe = "" ;
      AV59TFLegIdNomApe_SelsJson = "" ;
      AV61TFLegIdNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV13TFLegCuenLicTpo_SelsJson = "" ;
      AV14TFLegCuenLicTpo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV67TFLegCueAntAbr = "" ;
      AV66TFLegCueAntAbr_SelsJson = "" ;
      AV68TFLegCueAntAbr_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV54MenuOpcCod = "" ;
      A250LegIdNomApe = "" ;
      AV75Legajo_cuenta_licenciaswwds_3_tflegidnomape = "" ;
      AV76Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV77Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV78Legajo_cuenta_licenciaswwds_6_tflegcueantabr = "" ;
      AV79Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV75Legajo_cuenta_licenciaswwds_3_tflegidnomape = "" ;
      lV78Legajo_cuenta_licenciaswwds_6_tflegcueantabr = "" ;
      A2243LegCuenLicTpo = "" ;
      A2328LegCueAntAbr = "" ;
      P02AB2_A6LegNumero = new int[1] ;
      P02AB2_A1EmpCod = new short[1] ;
      P02AB2_A3CliCod = new int[1] ;
      P02AB2_A2305LegCuLiPSaldo = new short[1] ;
      P02AB2_A2248LegCuenDiasGoz = new short[1] ;
      P02AB2_A2306LegCuLiPApr = new short[1] ;
      P02AB2_A2302LegCuLiPCur = new short[1] ;
      P02AB2_A2304LegCuLiPVen = new short[1] ;
      P02AB2_A2315LegCuLActVen = new short[1] ;
      P02AB2_A2303LegCuLiPAnt = new short[1] ;
      P02AB2_A2247LegCuenDiasCorres = new short[1] ;
      P02AB2_A2328LegCueAntAbr = new String[] {""} ;
      P02AB2_A2243LegCuenLicTpo = new String[] {""} ;
      P02AB2_A250LegIdNomApe = new String[] {""} ;
      P02AB2_A2266LegCuenAnio = new short[1] ;
      AV37Option = "" ;
      P02AB3_A6LegNumero = new int[1] ;
      P02AB3_A3CliCod = new int[1] ;
      P02AB3_A1EmpCod = new short[1] ;
      P02AB3_A2328LegCueAntAbr = new String[] {""} ;
      P02AB3_A2305LegCuLiPSaldo = new short[1] ;
      P02AB3_A2248LegCuenDiasGoz = new short[1] ;
      P02AB3_A2306LegCuLiPApr = new short[1] ;
      P02AB3_A2302LegCuLiPCur = new short[1] ;
      P02AB3_A2304LegCuLiPVen = new short[1] ;
      P02AB3_A2315LegCuLActVen = new short[1] ;
      P02AB3_A2303LegCuLiPAnt = new short[1] ;
      P02AB3_A2247LegCuenDiasCorres = new short[1] ;
      P02AB3_A2243LegCuenLicTpo = new String[] {""} ;
      P02AB3_A250LegIdNomApe = new String[] {""} ;
      P02AB3_A2266LegCuenAnio = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajo_cuenta_licenciaswwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P02AB2_A6LegNumero, P02AB2_A1EmpCod, P02AB2_A3CliCod, P02AB2_A2305LegCuLiPSaldo, P02AB2_A2248LegCuenDiasGoz, P02AB2_A2306LegCuLiPApr, P02AB2_A2302LegCuLiPCur, P02AB2_A2304LegCuLiPVen, P02AB2_A2315LegCuLActVen, P02AB2_A2303LegCuLiPAnt,
            P02AB2_A2247LegCuenDiasCorres, P02AB2_A2328LegCueAntAbr, P02AB2_A2243LegCuenLicTpo, P02AB2_A250LegIdNomApe, P02AB2_A2266LegCuenAnio
            }
            , new Object[] {
            P02AB3_A6LegNumero, P02AB3_A3CliCod, P02AB3_A1EmpCod, P02AB3_A2328LegCueAntAbr, P02AB3_A2305LegCuLiPSaldo, P02AB3_A2248LegCuenDiasGoz, P02AB3_A2306LegCuLiPApr, P02AB3_A2302LegCuLiPCur, P02AB3_A2304LegCuLiPVen, P02AB3_A2315LegCuLActVen,
            P02AB3_A2303LegCuLiPAnt, P02AB3_A2247LegCuenDiasCorres, P02AB3_A2243LegCuenLicTpo, P02AB3_A250LegIdNomApe, P02AB3_A2266LegCuenAnio
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV55EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV15TFLegCuenAnio ;
   private short AV16TFLegCuenAnio_To ;
   private short AV24TFLegCuenDiasCorres ;
   private short AV25TFLegCuenDiasCorres_To ;
   private short AV26TFLegCuLiPAnt ;
   private short AV27TFLegCuLiPAnt_To ;
   private short AV62TFLegCuLActVen ;
   private short AV63TFLegCuLActVen_To ;
   private short AV28TFLegCuLiPVen ;
   private short AV29TFLegCuLiPVen_To ;
   private short AV30TFLegCuLiPCur ;
   private short AV31TFLegCuLiPCur_To ;
   private short AV57TFLegCuLiPApr ;
   private short AV58TFLegCuLiPApr_To ;
   private short AV34TFLegCuenDiasGoz ;
   private short AV35TFLegCuenDiasGoz_To ;
   private short AV32TFLegCuLiPSaldo ;
   private short AV33TFLegCuLiPSaldo_To ;
   private short AV73Legajo_cuenta_licenciaswwds_1_tflegcuenanio ;
   private short AV74Legajo_cuenta_licenciaswwds_2_tflegcuenanio_to ;
   private short AV80Legajo_cuenta_licenciaswwds_8_tflegcuendiascorres ;
   private short AV81Legajo_cuenta_licenciaswwds_9_tflegcuendiascorres_to ;
   private short AV82Legajo_cuenta_licenciaswwds_10_tflegculipant ;
   private short AV83Legajo_cuenta_licenciaswwds_11_tflegculipant_to ;
   private short AV84Legajo_cuenta_licenciaswwds_12_tflegculactven ;
   private short AV85Legajo_cuenta_licenciaswwds_13_tflegculactven_to ;
   private short AV86Legajo_cuenta_licenciaswwds_14_tflegculipven ;
   private short AV87Legajo_cuenta_licenciaswwds_15_tflegculipven_to ;
   private short AV88Legajo_cuenta_licenciaswwds_16_tflegculipcur ;
   private short AV89Legajo_cuenta_licenciaswwds_17_tflegculipcur_to ;
   private short AV90Legajo_cuenta_licenciaswwds_18_tflegculipapr ;
   private short AV91Legajo_cuenta_licenciaswwds_19_tflegculipapr_to ;
   private short AV92Legajo_cuenta_licenciaswwds_20_tflegcuendiasgoz ;
   private short AV93Legajo_cuenta_licenciaswwds_21_tflegcuendiasgoz_to ;
   private short AV94Legajo_cuenta_licenciaswwds_22_tflegculipsaldo ;
   private short AV95Legajo_cuenta_licenciaswwds_23_tflegculipsaldo_to ;
   private short A2266LegCuenAnio ;
   private short A2247LegCuenDiasCorres ;
   private short A2303LegCuLiPAnt ;
   private short A2315LegCuLActVen ;
   private short A2304LegCuLiPVen ;
   private short A2302LegCuLiPCur ;
   private short A2306LegCuLiPApr ;
   private short A2248LegCuenDiasGoz ;
   private short A2305LegCuLiPSaldo ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV56CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV71GXV1 ;
   private int AV76Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels_size ;
   private int AV77Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels_size ;
   private int AV79Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels_size ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int AV36InsertIndex ;
   private long AV42count ;
   private String scmdbuf ;
   private String A2243LegCuenLicTpo ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk2AB2 ;
   private boolean brk2AB4 ;
   private String AV51OptionsJson ;
   private String AV52OptionsDescJson ;
   private String AV53OptionIndexesJson ;
   private String AV59TFLegIdNomApe_SelsJson ;
   private String AV13TFLegCuenLicTpo_SelsJson ;
   private String AV66TFLegCueAntAbr_SelsJson ;
   private String AV48DDOName ;
   private String AV49SearchTxt ;
   private String AV50SearchTxtTo ;
   private String AV60TFLegIdNomApe ;
   private String AV67TFLegCueAntAbr ;
   private String AV54MenuOpcCod ;
   private String A250LegIdNomApe ;
   private String AV75Legajo_cuenta_licenciaswwds_3_tflegidnomape ;
   private String AV78Legajo_cuenta_licenciaswwds_6_tflegcueantabr ;
   private String lV75Legajo_cuenta_licenciaswwds_3_tflegidnomape ;
   private String lV78Legajo_cuenta_licenciaswwds_6_tflegcueantabr ;
   private String A2328LegCueAntAbr ;
   private String AV37Option ;
   private com.genexus.webpanels.WebSession AV43Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P02AB2_A6LegNumero ;
   private short[] P02AB2_A1EmpCod ;
   private int[] P02AB2_A3CliCod ;
   private short[] P02AB2_A2305LegCuLiPSaldo ;
   private short[] P02AB2_A2248LegCuenDiasGoz ;
   private short[] P02AB2_A2306LegCuLiPApr ;
   private short[] P02AB2_A2302LegCuLiPCur ;
   private short[] P02AB2_A2304LegCuLiPVen ;
   private short[] P02AB2_A2315LegCuLActVen ;
   private short[] P02AB2_A2303LegCuLiPAnt ;
   private short[] P02AB2_A2247LegCuenDiasCorres ;
   private String[] P02AB2_A2328LegCueAntAbr ;
   private String[] P02AB2_A2243LegCuenLicTpo ;
   private String[] P02AB2_A250LegIdNomApe ;
   private short[] P02AB2_A2266LegCuenAnio ;
   private int[] P02AB3_A6LegNumero ;
   private int[] P02AB3_A3CliCod ;
   private short[] P02AB3_A1EmpCod ;
   private String[] P02AB3_A2328LegCueAntAbr ;
   private short[] P02AB3_A2305LegCuLiPSaldo ;
   private short[] P02AB3_A2248LegCuenDiasGoz ;
   private short[] P02AB3_A2306LegCuLiPApr ;
   private short[] P02AB3_A2302LegCuLiPCur ;
   private short[] P02AB3_A2304LegCuLiPVen ;
   private short[] P02AB3_A2315LegCuLActVen ;
   private short[] P02AB3_A2303LegCuLiPAnt ;
   private short[] P02AB3_A2247LegCuenDiasCorres ;
   private String[] P02AB3_A2243LegCuenLicTpo ;
   private String[] P02AB3_A250LegIdNomApe ;
   private short[] P02AB3_A2266LegCuenAnio ;
   private GXSimpleCollection<String> AV14TFLegCuenLicTpo_Sels ;
   private GXSimpleCollection<String> AV77Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels ;
   private GXSimpleCollection<String> AV38Options ;
   private GXSimpleCollection<String> AV40OptionsDesc ;
   private GXSimpleCollection<String> AV41OptionIndexes ;
   private GXSimpleCollection<String> AV61TFLegIdNomApe_Sels ;
   private GXSimpleCollection<String> AV68TFLegCueAntAbr_Sels ;
   private GXSimpleCollection<String> AV76Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels ;
   private GXSimpleCollection<String> AV79Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV45GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV46GridStateFilterValue ;
}

final  class legajo_cuenta_licenciaswwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02AB2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A250LegIdNomApe ,
                                          GXSimpleCollection<String> AV76Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels ,
                                          String A2243LegCuenLicTpo ,
                                          GXSimpleCollection<String> AV77Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels ,
                                          String A2328LegCueAntAbr ,
                                          GXSimpleCollection<String> AV79Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels ,
                                          short AV73Legajo_cuenta_licenciaswwds_1_tflegcuenanio ,
                                          short AV74Legajo_cuenta_licenciaswwds_2_tflegcuenanio_to ,
                                          int AV76Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels_size ,
                                          String AV75Legajo_cuenta_licenciaswwds_3_tflegidnomape ,
                                          int AV77Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels_size ,
                                          int AV79Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels_size ,
                                          String AV78Legajo_cuenta_licenciaswwds_6_tflegcueantabr ,
                                          short AV80Legajo_cuenta_licenciaswwds_8_tflegcuendiascorres ,
                                          short AV81Legajo_cuenta_licenciaswwds_9_tflegcuendiascorres_to ,
                                          short AV82Legajo_cuenta_licenciaswwds_10_tflegculipant ,
                                          short AV83Legajo_cuenta_licenciaswwds_11_tflegculipant_to ,
                                          short AV84Legajo_cuenta_licenciaswwds_12_tflegculactven ,
                                          short AV85Legajo_cuenta_licenciaswwds_13_tflegculactven_to ,
                                          short AV86Legajo_cuenta_licenciaswwds_14_tflegculipven ,
                                          short AV87Legajo_cuenta_licenciaswwds_15_tflegculipven_to ,
                                          short AV88Legajo_cuenta_licenciaswwds_16_tflegculipcur ,
                                          short AV89Legajo_cuenta_licenciaswwds_17_tflegculipcur_to ,
                                          short AV90Legajo_cuenta_licenciaswwds_18_tflegculipapr ,
                                          short AV91Legajo_cuenta_licenciaswwds_19_tflegculipapr_to ,
                                          short AV92Legajo_cuenta_licenciaswwds_20_tflegcuendiasgoz ,
                                          short AV93Legajo_cuenta_licenciaswwds_21_tflegcuendiasgoz_to ,
                                          short AV94Legajo_cuenta_licenciaswwds_22_tflegculipsaldo ,
                                          short AV95Legajo_cuenta_licenciaswwds_23_tflegculipsaldo_to ,
                                          short A2266LegCuenAnio ,
                                          short A2247LegCuenDiasCorres ,
                                          short A2303LegCuLiPAnt ,
                                          short A2315LegCuLActVen ,
                                          short A2304LegCuLiPVen ,
                                          short A2302LegCuLiPCur ,
                                          short A2306LegCuLiPApr ,
                                          short A2248LegCuenDiasGoz ,
                                          short A2305LegCuLiPSaldo ,
                                          int AV56CliCod ,
                                          short AV55EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[22];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T1.EmpCod, T1.CliCod, T1.LegCuLiPSaldo, T1.LegCuenDiasGoz, T1.LegCuLiPApr, T1.LegCuLiPCur, T1.LegCuLiPVen, T1.LegCuLActVen, T1.LegCuLiPAnt," ;
      scmdbuf += " T1.LegCuenDiasCorres, T1.LegCueAntAbr, T1.LegCuenLicTpo, T2.LegIdNomApe, T1.LegCuenAnio FROM (legajo_cuenta_licencias T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod" ;
      scmdbuf += " AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      if ( ! (0==AV73Legajo_cuenta_licenciaswwds_1_tflegcuenanio) )
      {
         addWhere(sWhereString, "(T1.LegCuenAnio >= ?)");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( ! (0==AV74Legajo_cuenta_licenciaswwds_2_tflegcuenanio_to) )
      {
         addWhere(sWhereString, "(T1.LegCuenAnio <= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ( AV76Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV75Legajo_cuenta_licenciaswwds_3_tflegidnomape)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegIdNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( AV76Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV76Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels, "T2.LegIdNomApe IN (", ")")+")");
      }
      if ( AV77Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV77Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels, "T1.LegCuenLicTpo IN (", ")")+")");
      }
      if ( ( AV79Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV78Legajo_cuenta_licenciaswwds_6_tflegcueantabr)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LegCueAntAbr) like LOWER(?))");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( AV79Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV79Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels, "T1.LegCueAntAbr IN (", ")")+")");
      }
      if ( ! (0==AV80Legajo_cuenta_licenciaswwds_8_tflegcuendiascorres) )
      {
         addWhere(sWhereString, "(T1.LegCuenDiasCorres >= ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( ! (0==AV81Legajo_cuenta_licenciaswwds_9_tflegcuendiascorres_to) )
      {
         addWhere(sWhereString, "(T1.LegCuenDiasCorres <= ?)");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( ! (0==AV82Legajo_cuenta_licenciaswwds_10_tflegculipant) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPAnt >= ?)");
      }
      else
      {
         GXv_int8[8] = (byte)(1) ;
      }
      if ( ! (0==AV83Legajo_cuenta_licenciaswwds_11_tflegculipant_to) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPAnt <= ?)");
      }
      else
      {
         GXv_int8[9] = (byte)(1) ;
      }
      if ( ! (0==AV84Legajo_cuenta_licenciaswwds_12_tflegculactven) )
      {
         addWhere(sWhereString, "(T1.LegCuLActVen >= ?)");
      }
      else
      {
         GXv_int8[10] = (byte)(1) ;
      }
      if ( ! (0==AV85Legajo_cuenta_licenciaswwds_13_tflegculactven_to) )
      {
         addWhere(sWhereString, "(T1.LegCuLActVen <= ?)");
      }
      else
      {
         GXv_int8[11] = (byte)(1) ;
      }
      if ( ! (0==AV86Legajo_cuenta_licenciaswwds_14_tflegculipven) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPVen >= ?)");
      }
      else
      {
         GXv_int8[12] = (byte)(1) ;
      }
      if ( ! (0==AV87Legajo_cuenta_licenciaswwds_15_tflegculipven_to) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPVen <= ?)");
      }
      else
      {
         GXv_int8[13] = (byte)(1) ;
      }
      if ( ! (0==AV88Legajo_cuenta_licenciaswwds_16_tflegculipcur) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPCur >= ?)");
      }
      else
      {
         GXv_int8[14] = (byte)(1) ;
      }
      if ( ! (0==AV89Legajo_cuenta_licenciaswwds_17_tflegculipcur_to) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPCur <= ?)");
      }
      else
      {
         GXv_int8[15] = (byte)(1) ;
      }
      if ( ! (0==AV90Legajo_cuenta_licenciaswwds_18_tflegculipapr) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPApr >= ?)");
      }
      else
      {
         GXv_int8[16] = (byte)(1) ;
      }
      if ( ! (0==AV91Legajo_cuenta_licenciaswwds_19_tflegculipapr_to) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPApr <= ?)");
      }
      else
      {
         GXv_int8[17] = (byte)(1) ;
      }
      if ( ! (0==AV92Legajo_cuenta_licenciaswwds_20_tflegcuendiasgoz) )
      {
         addWhere(sWhereString, "(T1.LegCuenDiasGoz >= ?)");
      }
      else
      {
         GXv_int8[18] = (byte)(1) ;
      }
      if ( ! (0==AV93Legajo_cuenta_licenciaswwds_21_tflegcuendiasgoz_to) )
      {
         addWhere(sWhereString, "(T1.LegCuenDiasGoz <= ?)");
      }
      else
      {
         GXv_int8[19] = (byte)(1) ;
      }
      if ( ! (0==AV94Legajo_cuenta_licenciaswwds_22_tflegculipsaldo) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPSaldo >= ?)");
      }
      else
      {
         GXv_int8[20] = (byte)(1) ;
      }
      if ( ! (0==AV95Legajo_cuenta_licenciaswwds_23_tflegculipsaldo_to) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPSaldo <= ?)");
      }
      else
      {
         GXv_int8[21] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P02AB3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A250LegIdNomApe ,
                                          GXSimpleCollection<String> AV76Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels ,
                                          String A2243LegCuenLicTpo ,
                                          GXSimpleCollection<String> AV77Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels ,
                                          String A2328LegCueAntAbr ,
                                          GXSimpleCollection<String> AV79Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels ,
                                          short AV73Legajo_cuenta_licenciaswwds_1_tflegcuenanio ,
                                          short AV74Legajo_cuenta_licenciaswwds_2_tflegcuenanio_to ,
                                          int AV76Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels_size ,
                                          String AV75Legajo_cuenta_licenciaswwds_3_tflegidnomape ,
                                          int AV77Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels_size ,
                                          int AV79Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels_size ,
                                          String AV78Legajo_cuenta_licenciaswwds_6_tflegcueantabr ,
                                          short AV80Legajo_cuenta_licenciaswwds_8_tflegcuendiascorres ,
                                          short AV81Legajo_cuenta_licenciaswwds_9_tflegcuendiascorres_to ,
                                          short AV82Legajo_cuenta_licenciaswwds_10_tflegculipant ,
                                          short AV83Legajo_cuenta_licenciaswwds_11_tflegculipant_to ,
                                          short AV84Legajo_cuenta_licenciaswwds_12_tflegculactven ,
                                          short AV85Legajo_cuenta_licenciaswwds_13_tflegculactven_to ,
                                          short AV86Legajo_cuenta_licenciaswwds_14_tflegculipven ,
                                          short AV87Legajo_cuenta_licenciaswwds_15_tflegculipven_to ,
                                          short AV88Legajo_cuenta_licenciaswwds_16_tflegculipcur ,
                                          short AV89Legajo_cuenta_licenciaswwds_17_tflegculipcur_to ,
                                          short AV90Legajo_cuenta_licenciaswwds_18_tflegculipapr ,
                                          short AV91Legajo_cuenta_licenciaswwds_19_tflegculipapr_to ,
                                          short AV92Legajo_cuenta_licenciaswwds_20_tflegcuendiasgoz ,
                                          short AV93Legajo_cuenta_licenciaswwds_21_tflegcuendiasgoz_to ,
                                          short AV94Legajo_cuenta_licenciaswwds_22_tflegculipsaldo ,
                                          short AV95Legajo_cuenta_licenciaswwds_23_tflegculipsaldo_to ,
                                          short A2266LegCuenAnio ,
                                          short A2247LegCuenDiasCorres ,
                                          short A2303LegCuLiPAnt ,
                                          short A2315LegCuLActVen ,
                                          short A2304LegCuLiPVen ,
                                          short A2302LegCuLiPCur ,
                                          short A2306LegCuLiPApr ,
                                          short A2248LegCuenDiasGoz ,
                                          short A2305LegCuLiPSaldo ,
                                          int A3CliCod ,
                                          int AV56CliCod ,
                                          short A1EmpCod ,
                                          short AV55EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[22];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T1.CliCod, T1.EmpCod, T1.LegCueAntAbr, T1.LegCuLiPSaldo, T1.LegCuenDiasGoz, T1.LegCuLiPApr, T1.LegCuLiPCur, T1.LegCuLiPVen, T1.LegCuLActVen," ;
      scmdbuf += " T1.LegCuLiPAnt, T1.LegCuenDiasCorres, T1.LegCuenLicTpo, T2.LegIdNomApe, T1.LegCuenAnio FROM (legajo_cuenta_licencias T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod" ;
      scmdbuf += " AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      addWhere(sWhereString, "(T1.EmpCod = ?)");
      if ( ! (0==AV73Legajo_cuenta_licenciaswwds_1_tflegcuenanio) )
      {
         addWhere(sWhereString, "(T1.LegCuenAnio >= ?)");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( ! (0==AV74Legajo_cuenta_licenciaswwds_2_tflegcuenanio_to) )
      {
         addWhere(sWhereString, "(T1.LegCuenAnio <= ?)");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( ( AV76Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV75Legajo_cuenta_licenciaswwds_3_tflegidnomape)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegIdNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( AV76Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV76Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels, "T2.LegIdNomApe IN (", ")")+")");
      }
      if ( AV77Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV77Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels, "T1.LegCuenLicTpo IN (", ")")+")");
      }
      if ( ( AV79Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV78Legajo_cuenta_licenciaswwds_6_tflegcueantabr)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LegCueAntAbr) like LOWER(?))");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( AV79Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV79Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels, "T1.LegCueAntAbr IN (", ")")+")");
      }
      if ( ! (0==AV80Legajo_cuenta_licenciaswwds_8_tflegcuendiascorres) )
      {
         addWhere(sWhereString, "(T1.LegCuenDiasCorres >= ?)");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( ! (0==AV81Legajo_cuenta_licenciaswwds_9_tflegcuendiascorres_to) )
      {
         addWhere(sWhereString, "(T1.LegCuenDiasCorres <= ?)");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( ! (0==AV82Legajo_cuenta_licenciaswwds_10_tflegculipant) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPAnt >= ?)");
      }
      else
      {
         GXv_int11[8] = (byte)(1) ;
      }
      if ( ! (0==AV83Legajo_cuenta_licenciaswwds_11_tflegculipant_to) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPAnt <= ?)");
      }
      else
      {
         GXv_int11[9] = (byte)(1) ;
      }
      if ( ! (0==AV84Legajo_cuenta_licenciaswwds_12_tflegculactven) )
      {
         addWhere(sWhereString, "(T1.LegCuLActVen >= ?)");
      }
      else
      {
         GXv_int11[10] = (byte)(1) ;
      }
      if ( ! (0==AV85Legajo_cuenta_licenciaswwds_13_tflegculactven_to) )
      {
         addWhere(sWhereString, "(T1.LegCuLActVen <= ?)");
      }
      else
      {
         GXv_int11[11] = (byte)(1) ;
      }
      if ( ! (0==AV86Legajo_cuenta_licenciaswwds_14_tflegculipven) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPVen >= ?)");
      }
      else
      {
         GXv_int11[12] = (byte)(1) ;
      }
      if ( ! (0==AV87Legajo_cuenta_licenciaswwds_15_tflegculipven_to) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPVen <= ?)");
      }
      else
      {
         GXv_int11[13] = (byte)(1) ;
      }
      if ( ! (0==AV88Legajo_cuenta_licenciaswwds_16_tflegculipcur) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPCur >= ?)");
      }
      else
      {
         GXv_int11[14] = (byte)(1) ;
      }
      if ( ! (0==AV89Legajo_cuenta_licenciaswwds_17_tflegculipcur_to) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPCur <= ?)");
      }
      else
      {
         GXv_int11[15] = (byte)(1) ;
      }
      if ( ! (0==AV90Legajo_cuenta_licenciaswwds_18_tflegculipapr) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPApr >= ?)");
      }
      else
      {
         GXv_int11[16] = (byte)(1) ;
      }
      if ( ! (0==AV91Legajo_cuenta_licenciaswwds_19_tflegculipapr_to) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPApr <= ?)");
      }
      else
      {
         GXv_int11[17] = (byte)(1) ;
      }
      if ( ! (0==AV92Legajo_cuenta_licenciaswwds_20_tflegcuendiasgoz) )
      {
         addWhere(sWhereString, "(T1.LegCuenDiasGoz >= ?)");
      }
      else
      {
         GXv_int11[18] = (byte)(1) ;
      }
      if ( ! (0==AV93Legajo_cuenta_licenciaswwds_21_tflegcuendiasgoz_to) )
      {
         addWhere(sWhereString, "(T1.LegCuenDiasGoz <= ?)");
      }
      else
      {
         GXv_int11[19] = (byte)(1) ;
      }
      if ( ! (0==AV94Legajo_cuenta_licenciaswwds_22_tflegculipsaldo) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPSaldo >= ?)");
      }
      else
      {
         GXv_int11[20] = (byte)(1) ;
      }
      if ( ! (0==AV95Legajo_cuenta_licenciaswwds_23_tflegculipsaldo_to) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPSaldo <= ?)");
      }
      else
      {
         GXv_int11[21] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.LegCueAntAbr" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
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
                  return conditional_P02AB2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).shortValue() , ((Number) dynConstraints[19]).shortValue() , ((Number) dynConstraints[20]).shortValue() , ((Number) dynConstraints[21]).shortValue() , ((Number) dynConstraints[22]).shortValue() , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).shortValue() , ((Number) dynConstraints[27]).shortValue() , ((Number) dynConstraints[28]).shortValue() , ((Number) dynConstraints[29]).shortValue() , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).shortValue() , ((Number) dynConstraints[32]).shortValue() , ((Number) dynConstraints[33]).shortValue() , ((Number) dynConstraints[34]).shortValue() , ((Number) dynConstraints[35]).shortValue() , ((Number) dynConstraints[36]).shortValue() , ((Number) dynConstraints[37]).shortValue() , ((Number) dynConstraints[38]).intValue() , ((Number) dynConstraints[39]).shortValue() , ((Number) dynConstraints[40]).intValue() , ((Number) dynConstraints[41]).shortValue() );
            case 1 :
                  return conditional_P02AB3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).shortValue() , ((Number) dynConstraints[19]).shortValue() , ((Number) dynConstraints[20]).shortValue() , ((Number) dynConstraints[21]).shortValue() , ((Number) dynConstraints[22]).shortValue() , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).shortValue() , ((Number) dynConstraints[27]).shortValue() , ((Number) dynConstraints[28]).shortValue() , ((Number) dynConstraints[29]).shortValue() , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).shortValue() , ((Number) dynConstraints[32]).shortValue() , ((Number) dynConstraints[33]).shortValue() , ((Number) dynConstraints[34]).shortValue() , ((Number) dynConstraints[35]).shortValue() , ((Number) dynConstraints[36]).shortValue() , ((Number) dynConstraints[37]).shortValue() , ((Number) dynConstraints[38]).intValue() , ((Number) dynConstraints[39]).intValue() , ((Number) dynConstraints[40]).shortValue() , ((Number) dynConstraints[41]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02AB2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02AB3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getString(13, 20);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((short[]) buf[14])[0] = rslt.getShort(15);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((String[]) buf[12])[0] = rslt.getString(13, 20);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((short[]) buf[14])[0] = rslt.getShort(15);
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
                  stmt.setInt(sIdx, ((Number) parms[22]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[23]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[24]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[25]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 40);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[28]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[29]).shortValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[30]).shortValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[31]).shortValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[32]).shortValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[33]).shortValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[34]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[35]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[36]).shortValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[37]).shortValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[38]).shortValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[39]).shortValue());
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[40]).shortValue());
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[41]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[42]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[43]).shortValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[22]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[23]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[24]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[25]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 40);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[28]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[29]).shortValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[30]).shortValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[31]).shortValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[32]).shortValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[33]).shortValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[34]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[35]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[36]).shortValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[37]).shortValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[38]).shortValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[39]).shortValue());
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[40]).shortValue());
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[41]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[42]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[43]).shortValue());
               }
               return;
      }
   }

}

