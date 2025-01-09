package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conceptowwgetfilterdata extends GXProcedure
{
   public conceptowwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptowwgetfilterdata.class ), "" );
   }

   public conceptowwgetfilterdata( int remoteHandle ,
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
      conceptowwgetfilterdata.this.aP5 = new String[] {""};
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
      conceptowwgetfilterdata.this.AV37DDOName = aP0;
      conceptowwgetfilterdata.this.AV35SearchTxt = aP1;
      conceptowwgetfilterdata.this.AV36SearchTxtTo = aP2;
      conceptowwgetfilterdata.this.aP3 = aP3;
      conceptowwgetfilterdata.this.aP4 = aP4;
      conceptowwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug(remoteHandle, context).execute( AV146Pgmname, "1!") ;
      GXt_int1 = AV65EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      conceptowwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV65EmpCod = GXt_int1 ;
      GXt_int3 = AV64CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      conceptowwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV64CliCod = GXt_int3 ;
      AV40Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV43OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV45OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConcepto", GXv_boolean6) ;
      conceptowwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV37DDOName), "DDO_CONCODIGO") == 0 )
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
         else if ( GXutil.strcmp(GXutil.upper( AV37DDOName), "DDO_CONDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADCONDESCRIPOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV37DDOName), "DDO_CONCLASIFAUX") == 0 )
         {
            /* Execute user subroutine: 'LOADCONCLASIFAUXOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV37DDOName), "DDO_CONTIPOLIQAUX") == 0 )
         {
            /* Execute user subroutine: 'LOADCONTIPOLIQAUXOPTIONS' */
            S151 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV37DDOName), "DDO_CONCEPTOCONVECODIGO") == 0 )
         {
            /* Execute user subroutine: 'LOADCONCEPTOCONVECODIGOOPTIONS' */
            S161 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV37DDOName), "DDO_CONOBSERVACION") == 0 )
         {
            /* Execute user subroutine: 'LOADCONOBSERVACIONOPTIONS' */
            S171 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV37DDOName), "DDO_CONCODAFIP") == 0 )
         {
            /* Execute user subroutine: 'LOADCONCODAFIPOPTIONS' */
            S181 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV37DDOName), "DDO_CONRELREF") == 0 )
         {
            /* Execute user subroutine: 'LOADCONRELREFOPTIONS' */
            S191 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV41OptionsJson = AV40Options.toJSonString(false) ;
      AV44OptionsDescJson = AV43OptionsDesc.toJSonString(false) ;
      AV46OptionIndexesJson = AV45OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      new web.msgdebug(remoteHandle, context).execute( AV146Pgmname, "2!") ;
      if ( GXutil.strcmp(AV48Session.getValue("ConceptoWWGridState"), "") == 0 )
      {
         AV50GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ConceptoWWGridState"), null, null);
      }
      else
      {
         AV50GridState.fromxml(AV48Session.getValue("ConceptoWWGridState"), null, null);
      }
      AV147GXV1 = 1 ;
      while ( AV147GXV1 <= AV50GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV51GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV50GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV147GXV1));
         if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODIGO") == 0 )
         {
            AV10TFConCodigo = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODIGO_SEL") == 0 )
         {
            AV54TFConCodigo_SelsJson = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV55TFConCodigo_Sels.fromJSonString(AV54TFConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDESCRIP") == 0 )
         {
            AV12TFConDescrip = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDESCRIP_SEL") == 0 )
         {
            AV56TFConDescrip_SelsJson = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV57TFConDescrip_Sels.fromJSonString(AV56TFConDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOCONCOD_SEL") == 0 )
         {
            AV69TFTipoConCod_SelsJson = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV70TFTipoConCod_Sels.fromJSonString(AV69TFTipoConCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCLASIFAUX") == 0 )
         {
            AV93TFConClasifAux = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCLASIFAUX_SEL") == 0 )
         {
            AV92TFConClasifAux_SelsJson = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV94TFConClasifAux_Sels.fromJSonString(AV92TFConClasifAux_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONTIPOLIQAUX") == 0 )
         {
            AV84TFConTipoLiqAux = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONTIPOLIQAUX_SEL") == 0 )
         {
            AV83TFConTipoLiqAux_SelsJson = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV85TFConTipoLiqAux_Sels.fromJSonString(AV83TFConTipoLiqAux_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCEPTOCONVECODIGO") == 0 )
         {
            AV107TFConceptoConveCodigo = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCEPTOCONVECODIGO_SEL") == 0 )
         {
            AV106TFConceptoConveCodigo_SelsJson = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV108TFConceptoConveCodigo_Sels.fromJSonString(AV106TFConceptoConveCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVIGENCIA_SEL") == 0 )
         {
            AV21TFConVigencia_SelsJson = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV22TFConVigencia_Sels.fromJSonString(AV21TFConVigencia_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVARIABLE_SEL") == 0 )
         {
            AV23TFConVariable_Sel = (byte)(GXutil.lval( AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFORMULA") == 0 )
         {
            AV25TFConFormula = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONHABILITADO_SEL") == 0 )
         {
            AV14TFConHabilitado_Sel = (byte)(GXutil.lval( AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONOBSERVACION") == 0 )
         {
            AV27TFConObservacion = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONOBSERVACION_SEL") == 0 )
         {
            AV60TFConObservacion_SelsJson = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV61TFConObservacion_Sels.fromJSonString(AV60TFConObservacion_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGG_SEL") == 0 )
         {
            AV100TFAplIIGG_SelsJson = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV101TFAplIIGG_Sels.fromJSonString(AV100TFAplIIGG_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFCHMODFOR") == 0 )
         {
            AV33TFConFchModFor = localUtil.ctot( AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV34TFConFchModFor_To = localUtil.ctot( AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONRECALCULAR_SEL") == 0 )
         {
            AV89TFConRecalcular_Sel = (byte)(GXutil.lval( AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCONDICION_SEL") == 0 )
         {
            AV98TFConCondicion_SelsJson = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV99TFConCondicion_Sels.fromJSonString(AV98TFConCondicion_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONSACDEVEN_SEL") == 0 )
         {
            AV104TFConSacDeven_SelsJson = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV105TFConSacDeven_Sels.fromJSonString(AV104TFConSacDeven_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODAFIP") == 0 )
         {
            AV110TFConCodAfip = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODAFIP_SEL") == 0 )
         {
            AV109TFConCodAfip_SelsJson = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV111TFConCodAfip_Sels.fromJSonString(AV109TFConCodAfip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASEPRES_SEL") == 0 )
         {
            AV114TFConBasePres_SelsJson = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV115TFConBasePres_Sels.fromJSonString(AV114TFConBasePres_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASEANT_SEL") == 0 )
         {
            AV116TFConBaseAnt_SelsJson = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV117TFConBaseAnt_Sels.fromJSonString(AV116TFConBaseAnt_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASEFER_SEL") == 0 )
         {
            AV118TFConBaseFer_SelsJson = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV119TFConBaseFer_Sels.fromJSonString(AV118TFConBaseFer_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASEFERPROM_SEL") == 0 )
         {
            AV120TFConBaseFerProm_SelsJson = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV121TFConBaseFerProm_Sels.fromJSonString(AV120TFConBaseFerProm_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASEHOREXT_SEL") == 0 )
         {
            AV122TFConBaseHorExt_SelsJson = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV123TFConBaseHorExt_Sels.fromJSonString(AV122TFConBaseHorExt_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASEHOREXTPROM_SEL") == 0 )
         {
            AV124TFConBaseHorExtProm_SelsJson = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV125TFConBaseHorExtProm_Sels.fromJSonString(AV124TFConBaseHorExtProm_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASELIC_SEL") == 0 )
         {
            AV126TFConBaseLic_SelsJson = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV127TFConBaseLic_Sels.fromJSonString(AV126TFConBaseLic_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASELICPROM_SEL") == 0 )
         {
            AV128TFConBaseLicProm_SelsJson = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV129TFConBaseLicProm_Sels.fromJSonString(AV128TFConBaseLicProm_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONBASEOSDIF_SEL") == 0 )
         {
            AV130TFConBaseOSDif_SelsJson = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV131TFConBaseOSDif_Sels.fromJSonString(AV130TFConBaseOSDif_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONRELREF") == 0 )
         {
            AV142TFConRelRef = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONRELREF_SEL") == 0 )
         {
            AV141TFConRelRef_SelsJson = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV143TFConRelRef_Sels.fromJSonString(AV141TFConRelRef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV140MenuOpcCod = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV147GXV1 = (int)(AV147GXV1+1) ;
      }
      new web.msgdebug6(remoteHandle, context).execute( AV146Pgmname, httpContext.getMessage( "&TFConFormula ", "")+AV25TFConFormula) ;
      new web.msgdebug6(remoteHandle, context).execute( AV146Pgmname, httpContext.getMessage( "gridstate ", "")+AV50GridState.toJSonString(false, true)) ;
   }

   public void S121( )
   {
      /* 'LOADCONCODIGOOPTIONS' Routine */
      returnInSub = false ;
      new web.msgdebug(remoteHandle, context).execute( AV146Pgmname, "4") ;
      AV10TFConCodigo = AV35SearchTxt ;
      AV55TFConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV149Conceptowwds_1_tfconcodigo = AV10TFConCodigo ;
      AV150Conceptowwds_2_tfconcodigo_sels = AV55TFConCodigo_Sels ;
      AV151Conceptowwds_3_tfcondescrip = AV12TFConDescrip ;
      AV152Conceptowwds_4_tfcondescrip_sels = AV57TFConDescrip_Sels ;
      AV153Conceptowwds_5_tftipoconcod_sels = AV70TFTipoConCod_Sels ;
      AV154Conceptowwds_6_tfconclasifaux = AV93TFConClasifAux ;
      AV155Conceptowwds_7_tfconclasifaux_sels = AV94TFConClasifAux_Sels ;
      AV156Conceptowwds_8_tfcontipoliqaux = AV84TFConTipoLiqAux ;
      AV157Conceptowwds_9_tfcontipoliqaux_sels = AV85TFConTipoLiqAux_Sels ;
      AV158Conceptowwds_10_tfconceptoconvecodigo = AV107TFConceptoConveCodigo ;
      AV159Conceptowwds_11_tfconceptoconvecodigo_sels = AV108TFConceptoConveCodigo_Sels ;
      AV160Conceptowwds_12_tfconvigencia_sels = AV22TFConVigencia_Sels ;
      AV161Conceptowwds_13_tfconvariable_sel = AV23TFConVariable_Sel ;
      AV162Conceptowwds_14_tfconformula = AV25TFConFormula ;
      AV163Conceptowwds_15_tfconhabilitado_sel = AV14TFConHabilitado_Sel ;
      AV164Conceptowwds_16_tfconobservacion = AV27TFConObservacion ;
      AV165Conceptowwds_17_tfconobservacion_sels = AV61TFConObservacion_Sels ;
      AV166Conceptowwds_18_tfapliigg_sels = AV101TFAplIIGG_Sels ;
      AV167Conceptowwds_19_tfconfchmodfor = AV33TFConFchModFor ;
      AV168Conceptowwds_20_tfconfchmodfor_to = AV34TFConFchModFor_To ;
      AV169Conceptowwds_21_tfconrecalcular_sel = AV89TFConRecalcular_Sel ;
      AV170Conceptowwds_22_tfconcondicion_sels = AV99TFConCondicion_Sels ;
      AV171Conceptowwds_23_tfconsacdeven_sels = AV105TFConSacDeven_Sels ;
      AV172Conceptowwds_24_tfconcodafip = AV110TFConCodAfip ;
      AV173Conceptowwds_25_tfconcodafip_sels = AV111TFConCodAfip_Sels ;
      AV174Conceptowwds_26_tfconbasepres_sels = AV115TFConBasePres_Sels ;
      AV175Conceptowwds_27_tfconbaseant_sels = AV117TFConBaseAnt_Sels ;
      AV176Conceptowwds_28_tfconbasefer_sels = AV119TFConBaseFer_Sels ;
      AV177Conceptowwds_29_tfconbaseferprom_sels = AV121TFConBaseFerProm_Sels ;
      AV178Conceptowwds_30_tfconbasehorext_sels = AV123TFConBaseHorExt_Sels ;
      AV179Conceptowwds_31_tfconbasehorextprom_sels = AV125TFConBaseHorExtProm_Sels ;
      AV180Conceptowwds_32_tfconbaselic_sels = AV127TFConBaseLic_Sels ;
      AV181Conceptowwds_33_tfconbaselicprom_sels = AV129TFConBaseLicProm_Sels ;
      AV182Conceptowwds_34_tfconbaseosdif_sels = AV131TFConBaseOSDif_Sels ;
      AV183Conceptowwds_35_tfconrelref = AV142TFConRelRef ;
      AV184Conceptowwds_36_tfconrelref_sels = AV143TFConRelRef_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A26ConCodigo ,
                                           AV150Conceptowwds_2_tfconcodigo_sels ,
                                           A41ConDescrip ,
                                           AV152Conceptowwds_4_tfcondescrip_sels ,
                                           A37TipoConCod ,
                                           AV153Conceptowwds_5_tftipoconcod_sels ,
                                           A970ConClasifAux ,
                                           AV155Conceptowwds_7_tfconclasifaux_sels ,
                                           A503ConTipoLiqAux ,
                                           AV157Conceptowwds_9_tfcontipoliqaux_sels ,
                                           A1645ConceptoConveCodigo ,
                                           AV159Conceptowwds_11_tfconceptoconvecodigo_sels ,
                                           Byte.valueOf(A162ConVigencia) ,
                                           AV160Conceptowwds_12_tfconvigencia_sels ,
                                           A153ConObservacion ,
                                           AV165Conceptowwds_17_tfconobservacion_sels ,
                                           Short.valueOf(A1112AplIIGG) ,
                                           AV166Conceptowwds_18_tfapliigg_sels ,
                                           A953ConCondicion ,
                                           AV170Conceptowwds_22_tfconcondicion_sels ,
                                           Byte.valueOf(A1539ConSacDeven) ,
                                           AV171Conceptowwds_23_tfconsacdeven_sels ,
                                           A1648ConCodAfip ,
                                           AV173Conceptowwds_25_tfconcodafip_sels ,
                                           Byte.valueOf(A1800ConBasePres) ,
                                           AV174Conceptowwds_26_tfconbasepres_sels ,
                                           Byte.valueOf(A1801ConBaseAnt) ,
                                           AV175Conceptowwds_27_tfconbaseant_sels ,
                                           Byte.valueOf(A1621ConBaseFer) ,
                                           AV176Conceptowwds_28_tfconbasefer_sels ,
                                           Byte.valueOf(A1798ConBaseFerProm) ,
                                           AV177Conceptowwds_29_tfconbaseferprom_sels ,
                                           Byte.valueOf(A1622ConBaseHorExt) ,
                                           AV178Conceptowwds_30_tfconbasehorext_sels ,
                                           Byte.valueOf(A1799ConBaseHorExtProm) ,
                                           AV179Conceptowwds_31_tfconbasehorextprom_sels ,
                                           Byte.valueOf(A1620ConBaseLic) ,
                                           AV180Conceptowwds_32_tfconbaselic_sels ,
                                           Byte.valueOf(A1797ConBaseLicProm) ,
                                           AV181Conceptowwds_33_tfconbaselicprom_sels ,
                                           Byte.valueOf(A1827ConBaseOSDif) ,
                                           AV182Conceptowwds_34_tfconbaseosdif_sels ,
                                           A2013ConRelRef ,
                                           AV184Conceptowwds_36_tfconrelref_sels ,
                                           Integer.valueOf(AV150Conceptowwds_2_tfconcodigo_sels.size()) ,
                                           AV149Conceptowwds_1_tfconcodigo ,
                                           Integer.valueOf(AV152Conceptowwds_4_tfcondescrip_sels.size()) ,
                                           AV151Conceptowwds_3_tfcondescrip ,
                                           Integer.valueOf(AV153Conceptowwds_5_tftipoconcod_sels.size()) ,
                                           Integer.valueOf(AV155Conceptowwds_7_tfconclasifaux_sels.size()) ,
                                           AV154Conceptowwds_6_tfconclasifaux ,
                                           Integer.valueOf(AV157Conceptowwds_9_tfcontipoliqaux_sels.size()) ,
                                           AV156Conceptowwds_8_tfcontipoliqaux ,
                                           Integer.valueOf(AV159Conceptowwds_11_tfconceptoconvecodigo_sels.size()) ,
                                           AV158Conceptowwds_10_tfconceptoconvecodigo ,
                                           Integer.valueOf(AV160Conceptowwds_12_tfconvigencia_sels.size()) ,
                                           Byte.valueOf(AV161Conceptowwds_13_tfconvariable_sel) ,
                                           Byte.valueOf(AV163Conceptowwds_15_tfconhabilitado_sel) ,
                                           Integer.valueOf(AV165Conceptowwds_17_tfconobservacion_sels.size()) ,
                                           AV164Conceptowwds_16_tfconobservacion ,
                                           Integer.valueOf(AV166Conceptowwds_18_tfapliigg_sels.size()) ,
                                           AV167Conceptowwds_19_tfconfchmodfor ,
                                           AV168Conceptowwds_20_tfconfchmodfor_to ,
                                           Byte.valueOf(AV169Conceptowwds_21_tfconrecalcular_sel) ,
                                           Integer.valueOf(AV170Conceptowwds_22_tfconcondicion_sels.size()) ,
                                           Integer.valueOf(AV171Conceptowwds_23_tfconsacdeven_sels.size()) ,
                                           Integer.valueOf(AV173Conceptowwds_25_tfconcodafip_sels.size()) ,
                                           AV172Conceptowwds_24_tfconcodafip ,
                                           Integer.valueOf(AV174Conceptowwds_26_tfconbasepres_sels.size()) ,
                                           Integer.valueOf(AV175Conceptowwds_27_tfconbaseant_sels.size()) ,
                                           Integer.valueOf(AV176Conceptowwds_28_tfconbasefer_sels.size()) ,
                                           Integer.valueOf(AV177Conceptowwds_29_tfconbaseferprom_sels.size()) ,
                                           Integer.valueOf(AV178Conceptowwds_30_tfconbasehorext_sels.size()) ,
                                           Integer.valueOf(AV179Conceptowwds_31_tfconbasehorextprom_sels.size()) ,
                                           Integer.valueOf(AV180Conceptowwds_32_tfconbaselic_sels.size()) ,
                                           Integer.valueOf(AV181Conceptowwds_33_tfconbaselicprom_sels.size()) ,
                                           Integer.valueOf(AV182Conceptowwds_34_tfconbaseosdif_sels.size()) ,
                                           Integer.valueOf(AV184Conceptowwds_36_tfconrelref_sels.size()) ,
                                           AV183Conceptowwds_35_tfconrelref ,
                                           AV25TFConFormula ,
                                           A160ConveDescri ,
                                           Boolean.valueOf(A159ConVariable) ,
                                           Boolean.valueOf(A150ConHabilitado) ,
                                           A145ConFchModFor ,
                                           Boolean.valueOf(A762ConRecalcular) ,
                                           A148ConFormula ,
                                           Integer.valueOf(AV64CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV149Conceptowwds_1_tfconcodigo = GXutil.padr( GXutil.rtrim( AV149Conceptowwds_1_tfconcodigo), 10, "%") ;
      lV151Conceptowwds_3_tfcondescrip = GXutil.concat( GXutil.rtrim( AV151Conceptowwds_3_tfcondescrip), "%", "") ;
      lV154Conceptowwds_6_tfconclasifaux = GXutil.concat( GXutil.rtrim( AV154Conceptowwds_6_tfconclasifaux), "%", "") ;
      lV156Conceptowwds_8_tfcontipoliqaux = GXutil.concat( GXutil.rtrim( AV156Conceptowwds_8_tfcontipoliqaux), "%", "") ;
      lV158Conceptowwds_10_tfconceptoconvecodigo = GXutil.concat( GXutil.rtrim( AV158Conceptowwds_10_tfconceptoconvecodigo), "%", "") ;
      lV164Conceptowwds_16_tfconobservacion = GXutil.concat( GXutil.rtrim( AV164Conceptowwds_16_tfconobservacion), "%", "") ;
      lV172Conceptowwds_24_tfconcodafip = GXutil.padr( GXutil.rtrim( AV172Conceptowwds_24_tfconcodafip), 6, "%") ;
      lV183Conceptowwds_35_tfconrelref = GXutil.concat( GXutil.rtrim( AV183Conceptowwds_35_tfconrelref), "%", "") ;
      lV25TFConFormula = GXutil.concat( GXutil.rtrim( AV25TFConFormula), "%", "") ;
      /* Using cursor P003V2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV64CliCod), lV149Conceptowwds_1_tfconcodigo, lV151Conceptowwds_3_tfcondescrip, lV154Conceptowwds_6_tfconclasifaux, lV156Conceptowwds_8_tfcontipoliqaux, lV158Conceptowwds_10_tfconceptoconvecodigo, lV164Conceptowwds_16_tfconobservacion, AV167Conceptowwds_19_tfconfchmodfor, AV168Conceptowwds_20_tfconfchmodfor_to, lV172Conceptowwds_24_tfconcodafip, lV183Conceptowwds_35_tfconrelref, lV25TFConFormula});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk3V2 = false ;
         A1644ConceptoPais = P003V2_A1644ConceptoPais[0] ;
         n1644ConceptoPais = P003V2_n1644ConceptoPais[0] ;
         A3CliCod = P003V2_A3CliCod[0] ;
         A26ConCodigo = P003V2_A26ConCodigo[0] ;
         A148ConFormula = P003V2_A148ConFormula[0] ;
         n148ConFormula = P003V2_n148ConFormula[0] ;
         A160ConveDescri = P003V2_A160ConveDescri[0] ;
         n160ConveDescri = P003V2_n160ConveDescri[0] ;
         A2013ConRelRef = P003V2_A2013ConRelRef[0] ;
         A1827ConBaseOSDif = P003V2_A1827ConBaseOSDif[0] ;
         A1797ConBaseLicProm = P003V2_A1797ConBaseLicProm[0] ;
         A1620ConBaseLic = P003V2_A1620ConBaseLic[0] ;
         A1799ConBaseHorExtProm = P003V2_A1799ConBaseHorExtProm[0] ;
         A1622ConBaseHorExt = P003V2_A1622ConBaseHorExt[0] ;
         A1798ConBaseFerProm = P003V2_A1798ConBaseFerProm[0] ;
         A1621ConBaseFer = P003V2_A1621ConBaseFer[0] ;
         A1801ConBaseAnt = P003V2_A1801ConBaseAnt[0] ;
         A1800ConBasePres = P003V2_A1800ConBasePres[0] ;
         A1648ConCodAfip = P003V2_A1648ConCodAfip[0] ;
         A1539ConSacDeven = P003V2_A1539ConSacDeven[0] ;
         A953ConCondicion = P003V2_A953ConCondicion[0] ;
         n953ConCondicion = P003V2_n953ConCondicion[0] ;
         A762ConRecalcular = P003V2_A762ConRecalcular[0] ;
         A145ConFchModFor = P003V2_A145ConFchModFor[0] ;
         n145ConFchModFor = P003V2_n145ConFchModFor[0] ;
         A1112AplIIGG = P003V2_A1112AplIIGG[0] ;
         n1112AplIIGG = P003V2_n1112AplIIGG[0] ;
         A153ConObservacion = P003V2_A153ConObservacion[0] ;
         A150ConHabilitado = P003V2_A150ConHabilitado[0] ;
         A159ConVariable = P003V2_A159ConVariable[0] ;
         A162ConVigencia = P003V2_A162ConVigencia[0] ;
         A1645ConceptoConveCodigo = P003V2_A1645ConceptoConveCodigo[0] ;
         n1645ConceptoConveCodigo = P003V2_n1645ConceptoConveCodigo[0] ;
         A503ConTipoLiqAux = P003V2_A503ConTipoLiqAux[0] ;
         n503ConTipoLiqAux = P003V2_n503ConTipoLiqAux[0] ;
         A970ConClasifAux = P003V2_A970ConClasifAux[0] ;
         n970ConClasifAux = P003V2_n970ConClasifAux[0] ;
         A37TipoConCod = P003V2_A37TipoConCod[0] ;
         A41ConDescrip = P003V2_A41ConDescrip[0] ;
         A160ConveDescri = P003V2_A160ConveDescri[0] ;
         n160ConveDescri = P003V2_n160ConveDescri[0] ;
         AV47count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P003V2_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P003V2_A26ConCodigo[0], A26ConCodigo) == 0 ) )
         {
            brk3V2 = false ;
            AV47count = (long)(AV47count+1) ;
            brk3V2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A26ConCodigo)==0) )
         {
            AV39Option = A26ConCodigo ;
            AV42OptionDesc = GXutil.trim( GXutil.rtrim( localUtil.format( A26ConCodigo, ""))) ;
            AV40Options.add(AV39Option, 0);
            AV43OptionsDesc.add(AV42OptionDesc, 0);
            AV45OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV47count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV40Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3V2 )
         {
            brk3V2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
      AV45OptionIndexes.clear();
      new web.msgdebug(remoteHandle, context).execute( AV146Pgmname, "5") ;
   }

   public void S131( )
   {
      /* 'LOADCONDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      new web.msgdebug(remoteHandle, context).execute( AV146Pgmname, "6") ;
      AV12TFConDescrip = AV35SearchTxt ;
      AV57TFConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV149Conceptowwds_1_tfconcodigo = AV10TFConCodigo ;
      AV150Conceptowwds_2_tfconcodigo_sels = AV55TFConCodigo_Sels ;
      AV151Conceptowwds_3_tfcondescrip = AV12TFConDescrip ;
      AV152Conceptowwds_4_tfcondescrip_sels = AV57TFConDescrip_Sels ;
      AV153Conceptowwds_5_tftipoconcod_sels = AV70TFTipoConCod_Sels ;
      AV154Conceptowwds_6_tfconclasifaux = AV93TFConClasifAux ;
      AV155Conceptowwds_7_tfconclasifaux_sels = AV94TFConClasifAux_Sels ;
      AV156Conceptowwds_8_tfcontipoliqaux = AV84TFConTipoLiqAux ;
      AV157Conceptowwds_9_tfcontipoliqaux_sels = AV85TFConTipoLiqAux_Sels ;
      AV158Conceptowwds_10_tfconceptoconvecodigo = AV107TFConceptoConveCodigo ;
      AV159Conceptowwds_11_tfconceptoconvecodigo_sels = AV108TFConceptoConveCodigo_Sels ;
      AV160Conceptowwds_12_tfconvigencia_sels = AV22TFConVigencia_Sels ;
      AV161Conceptowwds_13_tfconvariable_sel = AV23TFConVariable_Sel ;
      AV162Conceptowwds_14_tfconformula = AV25TFConFormula ;
      AV163Conceptowwds_15_tfconhabilitado_sel = AV14TFConHabilitado_Sel ;
      AV164Conceptowwds_16_tfconobservacion = AV27TFConObservacion ;
      AV165Conceptowwds_17_tfconobservacion_sels = AV61TFConObservacion_Sels ;
      AV166Conceptowwds_18_tfapliigg_sels = AV101TFAplIIGG_Sels ;
      AV167Conceptowwds_19_tfconfchmodfor = AV33TFConFchModFor ;
      AV168Conceptowwds_20_tfconfchmodfor_to = AV34TFConFchModFor_To ;
      AV169Conceptowwds_21_tfconrecalcular_sel = AV89TFConRecalcular_Sel ;
      AV170Conceptowwds_22_tfconcondicion_sels = AV99TFConCondicion_Sels ;
      AV171Conceptowwds_23_tfconsacdeven_sels = AV105TFConSacDeven_Sels ;
      AV172Conceptowwds_24_tfconcodafip = AV110TFConCodAfip ;
      AV173Conceptowwds_25_tfconcodafip_sels = AV111TFConCodAfip_Sels ;
      AV174Conceptowwds_26_tfconbasepres_sels = AV115TFConBasePres_Sels ;
      AV175Conceptowwds_27_tfconbaseant_sels = AV117TFConBaseAnt_Sels ;
      AV176Conceptowwds_28_tfconbasefer_sels = AV119TFConBaseFer_Sels ;
      AV177Conceptowwds_29_tfconbaseferprom_sels = AV121TFConBaseFerProm_Sels ;
      AV178Conceptowwds_30_tfconbasehorext_sels = AV123TFConBaseHorExt_Sels ;
      AV179Conceptowwds_31_tfconbasehorextprom_sels = AV125TFConBaseHorExtProm_Sels ;
      AV180Conceptowwds_32_tfconbaselic_sels = AV127TFConBaseLic_Sels ;
      AV181Conceptowwds_33_tfconbaselicprom_sels = AV129TFConBaseLicProm_Sels ;
      AV182Conceptowwds_34_tfconbaseosdif_sels = AV131TFConBaseOSDif_Sels ;
      AV183Conceptowwds_35_tfconrelref = AV142TFConRelRef ;
      AV184Conceptowwds_36_tfconrelref_sels = AV143TFConRelRef_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A26ConCodigo ,
                                           AV150Conceptowwds_2_tfconcodigo_sels ,
                                           A41ConDescrip ,
                                           AV152Conceptowwds_4_tfcondescrip_sels ,
                                           A37TipoConCod ,
                                           AV153Conceptowwds_5_tftipoconcod_sels ,
                                           A970ConClasifAux ,
                                           AV155Conceptowwds_7_tfconclasifaux_sels ,
                                           A503ConTipoLiqAux ,
                                           AV157Conceptowwds_9_tfcontipoliqaux_sels ,
                                           A1645ConceptoConveCodigo ,
                                           AV159Conceptowwds_11_tfconceptoconvecodigo_sels ,
                                           Byte.valueOf(A162ConVigencia) ,
                                           AV160Conceptowwds_12_tfconvigencia_sels ,
                                           A153ConObservacion ,
                                           AV165Conceptowwds_17_tfconobservacion_sels ,
                                           Short.valueOf(A1112AplIIGG) ,
                                           AV166Conceptowwds_18_tfapliigg_sels ,
                                           A953ConCondicion ,
                                           AV170Conceptowwds_22_tfconcondicion_sels ,
                                           Byte.valueOf(A1539ConSacDeven) ,
                                           AV171Conceptowwds_23_tfconsacdeven_sels ,
                                           A1648ConCodAfip ,
                                           AV173Conceptowwds_25_tfconcodafip_sels ,
                                           Byte.valueOf(A1800ConBasePres) ,
                                           AV174Conceptowwds_26_tfconbasepres_sels ,
                                           Byte.valueOf(A1801ConBaseAnt) ,
                                           AV175Conceptowwds_27_tfconbaseant_sels ,
                                           Byte.valueOf(A1621ConBaseFer) ,
                                           AV176Conceptowwds_28_tfconbasefer_sels ,
                                           Byte.valueOf(A1798ConBaseFerProm) ,
                                           AV177Conceptowwds_29_tfconbaseferprom_sels ,
                                           Byte.valueOf(A1622ConBaseHorExt) ,
                                           AV178Conceptowwds_30_tfconbasehorext_sels ,
                                           Byte.valueOf(A1799ConBaseHorExtProm) ,
                                           AV179Conceptowwds_31_tfconbasehorextprom_sels ,
                                           Byte.valueOf(A1620ConBaseLic) ,
                                           AV180Conceptowwds_32_tfconbaselic_sels ,
                                           Byte.valueOf(A1797ConBaseLicProm) ,
                                           AV181Conceptowwds_33_tfconbaselicprom_sels ,
                                           Byte.valueOf(A1827ConBaseOSDif) ,
                                           AV182Conceptowwds_34_tfconbaseosdif_sels ,
                                           A2013ConRelRef ,
                                           AV184Conceptowwds_36_tfconrelref_sels ,
                                           Integer.valueOf(AV150Conceptowwds_2_tfconcodigo_sels.size()) ,
                                           AV149Conceptowwds_1_tfconcodigo ,
                                           Integer.valueOf(AV152Conceptowwds_4_tfcondescrip_sels.size()) ,
                                           AV151Conceptowwds_3_tfcondescrip ,
                                           Integer.valueOf(AV153Conceptowwds_5_tftipoconcod_sels.size()) ,
                                           Integer.valueOf(AV155Conceptowwds_7_tfconclasifaux_sels.size()) ,
                                           AV154Conceptowwds_6_tfconclasifaux ,
                                           Integer.valueOf(AV157Conceptowwds_9_tfcontipoliqaux_sels.size()) ,
                                           AV156Conceptowwds_8_tfcontipoliqaux ,
                                           Integer.valueOf(AV159Conceptowwds_11_tfconceptoconvecodigo_sels.size()) ,
                                           AV158Conceptowwds_10_tfconceptoconvecodigo ,
                                           Integer.valueOf(AV160Conceptowwds_12_tfconvigencia_sels.size()) ,
                                           Byte.valueOf(AV161Conceptowwds_13_tfconvariable_sel) ,
                                           Byte.valueOf(AV163Conceptowwds_15_tfconhabilitado_sel) ,
                                           Integer.valueOf(AV165Conceptowwds_17_tfconobservacion_sels.size()) ,
                                           AV164Conceptowwds_16_tfconobservacion ,
                                           Integer.valueOf(AV166Conceptowwds_18_tfapliigg_sels.size()) ,
                                           AV167Conceptowwds_19_tfconfchmodfor ,
                                           AV168Conceptowwds_20_tfconfchmodfor_to ,
                                           Byte.valueOf(AV169Conceptowwds_21_tfconrecalcular_sel) ,
                                           Integer.valueOf(AV170Conceptowwds_22_tfconcondicion_sels.size()) ,
                                           Integer.valueOf(AV171Conceptowwds_23_tfconsacdeven_sels.size()) ,
                                           Integer.valueOf(AV173Conceptowwds_25_tfconcodafip_sels.size()) ,
                                           AV172Conceptowwds_24_tfconcodafip ,
                                           Integer.valueOf(AV174Conceptowwds_26_tfconbasepres_sels.size()) ,
                                           Integer.valueOf(AV175Conceptowwds_27_tfconbaseant_sels.size()) ,
                                           Integer.valueOf(AV176Conceptowwds_28_tfconbasefer_sels.size()) ,
                                           Integer.valueOf(AV177Conceptowwds_29_tfconbaseferprom_sels.size()) ,
                                           Integer.valueOf(AV178Conceptowwds_30_tfconbasehorext_sels.size()) ,
                                           Integer.valueOf(AV179Conceptowwds_31_tfconbasehorextprom_sels.size()) ,
                                           Integer.valueOf(AV180Conceptowwds_32_tfconbaselic_sels.size()) ,
                                           Integer.valueOf(AV181Conceptowwds_33_tfconbaselicprom_sels.size()) ,
                                           Integer.valueOf(AV182Conceptowwds_34_tfconbaseosdif_sels.size()) ,
                                           Integer.valueOf(AV184Conceptowwds_36_tfconrelref_sels.size()) ,
                                           AV183Conceptowwds_35_tfconrelref ,
                                           AV25TFConFormula ,
                                           A160ConveDescri ,
                                           Boolean.valueOf(A159ConVariable) ,
                                           Boolean.valueOf(A150ConHabilitado) ,
                                           A145ConFchModFor ,
                                           Boolean.valueOf(A762ConRecalcular) ,
                                           A148ConFormula ,
                                           Integer.valueOf(AV64CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV149Conceptowwds_1_tfconcodigo = GXutil.padr( GXutil.rtrim( AV149Conceptowwds_1_tfconcodigo), 10, "%") ;
      lV151Conceptowwds_3_tfcondescrip = GXutil.concat( GXutil.rtrim( AV151Conceptowwds_3_tfcondescrip), "%", "") ;
      lV154Conceptowwds_6_tfconclasifaux = GXutil.concat( GXutil.rtrim( AV154Conceptowwds_6_tfconclasifaux), "%", "") ;
      lV156Conceptowwds_8_tfcontipoliqaux = GXutil.concat( GXutil.rtrim( AV156Conceptowwds_8_tfcontipoliqaux), "%", "") ;
      lV158Conceptowwds_10_tfconceptoconvecodigo = GXutil.concat( GXutil.rtrim( AV158Conceptowwds_10_tfconceptoconvecodigo), "%", "") ;
      lV164Conceptowwds_16_tfconobservacion = GXutil.concat( GXutil.rtrim( AV164Conceptowwds_16_tfconobservacion), "%", "") ;
      lV172Conceptowwds_24_tfconcodafip = GXutil.padr( GXutil.rtrim( AV172Conceptowwds_24_tfconcodafip), 6, "%") ;
      lV183Conceptowwds_35_tfconrelref = GXutil.concat( GXutil.rtrim( AV183Conceptowwds_35_tfconrelref), "%", "") ;
      lV25TFConFormula = GXutil.concat( GXutil.rtrim( AV25TFConFormula), "%", "") ;
      /* Using cursor P003V3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV64CliCod), lV149Conceptowwds_1_tfconcodigo, lV151Conceptowwds_3_tfcondescrip, lV154Conceptowwds_6_tfconclasifaux, lV156Conceptowwds_8_tfcontipoliqaux, lV158Conceptowwds_10_tfconceptoconvecodigo, lV164Conceptowwds_16_tfconobservacion, AV167Conceptowwds_19_tfconfchmodfor, AV168Conceptowwds_20_tfconfchmodfor_to, lV172Conceptowwds_24_tfconcodafip, lV183Conceptowwds_35_tfconrelref, lV25TFConFormula});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk3V4 = false ;
         A1644ConceptoPais = P003V3_A1644ConceptoPais[0] ;
         n1644ConceptoPais = P003V3_n1644ConceptoPais[0] ;
         A3CliCod = P003V3_A3CliCod[0] ;
         A41ConDescrip = P003V3_A41ConDescrip[0] ;
         A148ConFormula = P003V3_A148ConFormula[0] ;
         n148ConFormula = P003V3_n148ConFormula[0] ;
         A160ConveDescri = P003V3_A160ConveDescri[0] ;
         n160ConveDescri = P003V3_n160ConveDescri[0] ;
         A2013ConRelRef = P003V3_A2013ConRelRef[0] ;
         A1827ConBaseOSDif = P003V3_A1827ConBaseOSDif[0] ;
         A1797ConBaseLicProm = P003V3_A1797ConBaseLicProm[0] ;
         A1620ConBaseLic = P003V3_A1620ConBaseLic[0] ;
         A1799ConBaseHorExtProm = P003V3_A1799ConBaseHorExtProm[0] ;
         A1622ConBaseHorExt = P003V3_A1622ConBaseHorExt[0] ;
         A1798ConBaseFerProm = P003V3_A1798ConBaseFerProm[0] ;
         A1621ConBaseFer = P003V3_A1621ConBaseFer[0] ;
         A1801ConBaseAnt = P003V3_A1801ConBaseAnt[0] ;
         A1800ConBasePres = P003V3_A1800ConBasePres[0] ;
         A1648ConCodAfip = P003V3_A1648ConCodAfip[0] ;
         A1539ConSacDeven = P003V3_A1539ConSacDeven[0] ;
         A953ConCondicion = P003V3_A953ConCondicion[0] ;
         n953ConCondicion = P003V3_n953ConCondicion[0] ;
         A762ConRecalcular = P003V3_A762ConRecalcular[0] ;
         A145ConFchModFor = P003V3_A145ConFchModFor[0] ;
         n145ConFchModFor = P003V3_n145ConFchModFor[0] ;
         A1112AplIIGG = P003V3_A1112AplIIGG[0] ;
         n1112AplIIGG = P003V3_n1112AplIIGG[0] ;
         A153ConObservacion = P003V3_A153ConObservacion[0] ;
         A150ConHabilitado = P003V3_A150ConHabilitado[0] ;
         A159ConVariable = P003V3_A159ConVariable[0] ;
         A162ConVigencia = P003V3_A162ConVigencia[0] ;
         A1645ConceptoConveCodigo = P003V3_A1645ConceptoConveCodigo[0] ;
         n1645ConceptoConveCodigo = P003V3_n1645ConceptoConveCodigo[0] ;
         A503ConTipoLiqAux = P003V3_A503ConTipoLiqAux[0] ;
         n503ConTipoLiqAux = P003V3_n503ConTipoLiqAux[0] ;
         A970ConClasifAux = P003V3_A970ConClasifAux[0] ;
         n970ConClasifAux = P003V3_n970ConClasifAux[0] ;
         A37TipoConCod = P003V3_A37TipoConCod[0] ;
         A26ConCodigo = P003V3_A26ConCodigo[0] ;
         A160ConveDescri = P003V3_A160ConveDescri[0] ;
         n160ConveDescri = P003V3_n160ConveDescri[0] ;
         AV47count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( P003V3_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P003V3_A41ConDescrip[0], A41ConDescrip) == 0 ) )
         {
            brk3V4 = false ;
            A26ConCodigo = P003V3_A26ConCodigo[0] ;
            AV47count = (long)(AV47count+1) ;
            brk3V4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A41ConDescrip)==0) )
         {
            AV39Option = A41ConDescrip ;
            AV40Options.add(AV39Option, 0);
            AV45OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV47count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV40Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3V4 )
         {
            brk3V4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
      new web.msgdebug(remoteHandle, context).execute( AV146Pgmname, "7") ;
   }

   public void S141( )
   {
      /* 'LOADCONCLASIFAUXOPTIONS' Routine */
      returnInSub = false ;
      AV93TFConClasifAux = AV35SearchTxt ;
      AV94TFConClasifAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV149Conceptowwds_1_tfconcodigo = AV10TFConCodigo ;
      AV150Conceptowwds_2_tfconcodigo_sels = AV55TFConCodigo_Sels ;
      AV151Conceptowwds_3_tfcondescrip = AV12TFConDescrip ;
      AV152Conceptowwds_4_tfcondescrip_sels = AV57TFConDescrip_Sels ;
      AV153Conceptowwds_5_tftipoconcod_sels = AV70TFTipoConCod_Sels ;
      AV154Conceptowwds_6_tfconclasifaux = AV93TFConClasifAux ;
      AV155Conceptowwds_7_tfconclasifaux_sels = AV94TFConClasifAux_Sels ;
      AV156Conceptowwds_8_tfcontipoliqaux = AV84TFConTipoLiqAux ;
      AV157Conceptowwds_9_tfcontipoliqaux_sels = AV85TFConTipoLiqAux_Sels ;
      AV158Conceptowwds_10_tfconceptoconvecodigo = AV107TFConceptoConveCodigo ;
      AV159Conceptowwds_11_tfconceptoconvecodigo_sels = AV108TFConceptoConveCodigo_Sels ;
      AV160Conceptowwds_12_tfconvigencia_sels = AV22TFConVigencia_Sels ;
      AV161Conceptowwds_13_tfconvariable_sel = AV23TFConVariable_Sel ;
      AV162Conceptowwds_14_tfconformula = AV25TFConFormula ;
      AV163Conceptowwds_15_tfconhabilitado_sel = AV14TFConHabilitado_Sel ;
      AV164Conceptowwds_16_tfconobservacion = AV27TFConObservacion ;
      AV165Conceptowwds_17_tfconobservacion_sels = AV61TFConObservacion_Sels ;
      AV166Conceptowwds_18_tfapliigg_sels = AV101TFAplIIGG_Sels ;
      AV167Conceptowwds_19_tfconfchmodfor = AV33TFConFchModFor ;
      AV168Conceptowwds_20_tfconfchmodfor_to = AV34TFConFchModFor_To ;
      AV169Conceptowwds_21_tfconrecalcular_sel = AV89TFConRecalcular_Sel ;
      AV170Conceptowwds_22_tfconcondicion_sels = AV99TFConCondicion_Sels ;
      AV171Conceptowwds_23_tfconsacdeven_sels = AV105TFConSacDeven_Sels ;
      AV172Conceptowwds_24_tfconcodafip = AV110TFConCodAfip ;
      AV173Conceptowwds_25_tfconcodafip_sels = AV111TFConCodAfip_Sels ;
      AV174Conceptowwds_26_tfconbasepres_sels = AV115TFConBasePres_Sels ;
      AV175Conceptowwds_27_tfconbaseant_sels = AV117TFConBaseAnt_Sels ;
      AV176Conceptowwds_28_tfconbasefer_sels = AV119TFConBaseFer_Sels ;
      AV177Conceptowwds_29_tfconbaseferprom_sels = AV121TFConBaseFerProm_Sels ;
      AV178Conceptowwds_30_tfconbasehorext_sels = AV123TFConBaseHorExt_Sels ;
      AV179Conceptowwds_31_tfconbasehorextprom_sels = AV125TFConBaseHorExtProm_Sels ;
      AV180Conceptowwds_32_tfconbaselic_sels = AV127TFConBaseLic_Sels ;
      AV181Conceptowwds_33_tfconbaselicprom_sels = AV129TFConBaseLicProm_Sels ;
      AV182Conceptowwds_34_tfconbaseosdif_sels = AV131TFConBaseOSDif_Sels ;
      AV183Conceptowwds_35_tfconrelref = AV142TFConRelRef ;
      AV184Conceptowwds_36_tfconrelref_sels = AV143TFConRelRef_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A26ConCodigo ,
                                           AV150Conceptowwds_2_tfconcodigo_sels ,
                                           A41ConDescrip ,
                                           AV152Conceptowwds_4_tfcondescrip_sels ,
                                           A37TipoConCod ,
                                           AV153Conceptowwds_5_tftipoconcod_sels ,
                                           A970ConClasifAux ,
                                           AV155Conceptowwds_7_tfconclasifaux_sels ,
                                           A503ConTipoLiqAux ,
                                           AV157Conceptowwds_9_tfcontipoliqaux_sels ,
                                           A1645ConceptoConveCodigo ,
                                           AV159Conceptowwds_11_tfconceptoconvecodigo_sels ,
                                           Byte.valueOf(A162ConVigencia) ,
                                           AV160Conceptowwds_12_tfconvigencia_sels ,
                                           A153ConObservacion ,
                                           AV165Conceptowwds_17_tfconobservacion_sels ,
                                           Short.valueOf(A1112AplIIGG) ,
                                           AV166Conceptowwds_18_tfapliigg_sels ,
                                           A953ConCondicion ,
                                           AV170Conceptowwds_22_tfconcondicion_sels ,
                                           Byte.valueOf(A1539ConSacDeven) ,
                                           AV171Conceptowwds_23_tfconsacdeven_sels ,
                                           A1648ConCodAfip ,
                                           AV173Conceptowwds_25_tfconcodafip_sels ,
                                           Byte.valueOf(A1800ConBasePres) ,
                                           AV174Conceptowwds_26_tfconbasepres_sels ,
                                           Byte.valueOf(A1801ConBaseAnt) ,
                                           AV175Conceptowwds_27_tfconbaseant_sels ,
                                           Byte.valueOf(A1621ConBaseFer) ,
                                           AV176Conceptowwds_28_tfconbasefer_sels ,
                                           Byte.valueOf(A1798ConBaseFerProm) ,
                                           AV177Conceptowwds_29_tfconbaseferprom_sels ,
                                           Byte.valueOf(A1622ConBaseHorExt) ,
                                           AV178Conceptowwds_30_tfconbasehorext_sels ,
                                           Byte.valueOf(A1799ConBaseHorExtProm) ,
                                           AV179Conceptowwds_31_tfconbasehorextprom_sels ,
                                           Byte.valueOf(A1620ConBaseLic) ,
                                           AV180Conceptowwds_32_tfconbaselic_sels ,
                                           Byte.valueOf(A1797ConBaseLicProm) ,
                                           AV181Conceptowwds_33_tfconbaselicprom_sels ,
                                           Byte.valueOf(A1827ConBaseOSDif) ,
                                           AV182Conceptowwds_34_tfconbaseosdif_sels ,
                                           A2013ConRelRef ,
                                           AV184Conceptowwds_36_tfconrelref_sels ,
                                           Integer.valueOf(AV150Conceptowwds_2_tfconcodigo_sels.size()) ,
                                           AV149Conceptowwds_1_tfconcodigo ,
                                           Integer.valueOf(AV152Conceptowwds_4_tfcondescrip_sels.size()) ,
                                           AV151Conceptowwds_3_tfcondescrip ,
                                           Integer.valueOf(AV153Conceptowwds_5_tftipoconcod_sels.size()) ,
                                           Integer.valueOf(AV155Conceptowwds_7_tfconclasifaux_sels.size()) ,
                                           AV154Conceptowwds_6_tfconclasifaux ,
                                           Integer.valueOf(AV157Conceptowwds_9_tfcontipoliqaux_sels.size()) ,
                                           AV156Conceptowwds_8_tfcontipoliqaux ,
                                           Integer.valueOf(AV159Conceptowwds_11_tfconceptoconvecodigo_sels.size()) ,
                                           AV158Conceptowwds_10_tfconceptoconvecodigo ,
                                           Integer.valueOf(AV160Conceptowwds_12_tfconvigencia_sels.size()) ,
                                           Byte.valueOf(AV161Conceptowwds_13_tfconvariable_sel) ,
                                           Byte.valueOf(AV163Conceptowwds_15_tfconhabilitado_sel) ,
                                           Integer.valueOf(AV165Conceptowwds_17_tfconobservacion_sels.size()) ,
                                           AV164Conceptowwds_16_tfconobservacion ,
                                           Integer.valueOf(AV166Conceptowwds_18_tfapliigg_sels.size()) ,
                                           AV167Conceptowwds_19_tfconfchmodfor ,
                                           AV168Conceptowwds_20_tfconfchmodfor_to ,
                                           Byte.valueOf(AV169Conceptowwds_21_tfconrecalcular_sel) ,
                                           Integer.valueOf(AV170Conceptowwds_22_tfconcondicion_sels.size()) ,
                                           Integer.valueOf(AV171Conceptowwds_23_tfconsacdeven_sels.size()) ,
                                           Integer.valueOf(AV173Conceptowwds_25_tfconcodafip_sels.size()) ,
                                           AV172Conceptowwds_24_tfconcodafip ,
                                           Integer.valueOf(AV174Conceptowwds_26_tfconbasepres_sels.size()) ,
                                           Integer.valueOf(AV175Conceptowwds_27_tfconbaseant_sels.size()) ,
                                           Integer.valueOf(AV176Conceptowwds_28_tfconbasefer_sels.size()) ,
                                           Integer.valueOf(AV177Conceptowwds_29_tfconbaseferprom_sels.size()) ,
                                           Integer.valueOf(AV178Conceptowwds_30_tfconbasehorext_sels.size()) ,
                                           Integer.valueOf(AV179Conceptowwds_31_tfconbasehorextprom_sels.size()) ,
                                           Integer.valueOf(AV180Conceptowwds_32_tfconbaselic_sels.size()) ,
                                           Integer.valueOf(AV181Conceptowwds_33_tfconbaselicprom_sels.size()) ,
                                           Integer.valueOf(AV182Conceptowwds_34_tfconbaseosdif_sels.size()) ,
                                           Integer.valueOf(AV184Conceptowwds_36_tfconrelref_sels.size()) ,
                                           AV183Conceptowwds_35_tfconrelref ,
                                           AV25TFConFormula ,
                                           A160ConveDescri ,
                                           Boolean.valueOf(A159ConVariable) ,
                                           Boolean.valueOf(A150ConHabilitado) ,
                                           A145ConFchModFor ,
                                           Boolean.valueOf(A762ConRecalcular) ,
                                           A148ConFormula ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV64CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV149Conceptowwds_1_tfconcodigo = GXutil.padr( GXutil.rtrim( AV149Conceptowwds_1_tfconcodigo), 10, "%") ;
      lV151Conceptowwds_3_tfcondescrip = GXutil.concat( GXutil.rtrim( AV151Conceptowwds_3_tfcondescrip), "%", "") ;
      lV154Conceptowwds_6_tfconclasifaux = GXutil.concat( GXutil.rtrim( AV154Conceptowwds_6_tfconclasifaux), "%", "") ;
      lV156Conceptowwds_8_tfcontipoliqaux = GXutil.concat( GXutil.rtrim( AV156Conceptowwds_8_tfcontipoliqaux), "%", "") ;
      lV158Conceptowwds_10_tfconceptoconvecodigo = GXutil.concat( GXutil.rtrim( AV158Conceptowwds_10_tfconceptoconvecodigo), "%", "") ;
      lV164Conceptowwds_16_tfconobservacion = GXutil.concat( GXutil.rtrim( AV164Conceptowwds_16_tfconobservacion), "%", "") ;
      lV172Conceptowwds_24_tfconcodafip = GXutil.padr( GXutil.rtrim( AV172Conceptowwds_24_tfconcodafip), 6, "%") ;
      lV183Conceptowwds_35_tfconrelref = GXutil.concat( GXutil.rtrim( AV183Conceptowwds_35_tfconrelref), "%", "") ;
      lV25TFConFormula = GXutil.concat( GXutil.rtrim( AV25TFConFormula), "%", "") ;
      /* Using cursor P003V4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV64CliCod), lV149Conceptowwds_1_tfconcodigo, lV151Conceptowwds_3_tfcondescrip, lV154Conceptowwds_6_tfconclasifaux, lV156Conceptowwds_8_tfcontipoliqaux, lV158Conceptowwds_10_tfconceptoconvecodigo, lV164Conceptowwds_16_tfconobservacion, AV167Conceptowwds_19_tfconfchmodfor, AV168Conceptowwds_20_tfconfchmodfor_to, lV172Conceptowwds_24_tfconcodafip, lV183Conceptowwds_35_tfconrelref, lV25TFConFormula});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk3V6 = false ;
         A1644ConceptoPais = P003V4_A1644ConceptoPais[0] ;
         n1644ConceptoPais = P003V4_n1644ConceptoPais[0] ;
         A3CliCod = P003V4_A3CliCod[0] ;
         A970ConClasifAux = P003V4_A970ConClasifAux[0] ;
         n970ConClasifAux = P003V4_n970ConClasifAux[0] ;
         A148ConFormula = P003V4_A148ConFormula[0] ;
         n148ConFormula = P003V4_n148ConFormula[0] ;
         A160ConveDescri = P003V4_A160ConveDescri[0] ;
         n160ConveDescri = P003V4_n160ConveDescri[0] ;
         A2013ConRelRef = P003V4_A2013ConRelRef[0] ;
         A1827ConBaseOSDif = P003V4_A1827ConBaseOSDif[0] ;
         A1797ConBaseLicProm = P003V4_A1797ConBaseLicProm[0] ;
         A1620ConBaseLic = P003V4_A1620ConBaseLic[0] ;
         A1799ConBaseHorExtProm = P003V4_A1799ConBaseHorExtProm[0] ;
         A1622ConBaseHorExt = P003V4_A1622ConBaseHorExt[0] ;
         A1798ConBaseFerProm = P003V4_A1798ConBaseFerProm[0] ;
         A1621ConBaseFer = P003V4_A1621ConBaseFer[0] ;
         A1801ConBaseAnt = P003V4_A1801ConBaseAnt[0] ;
         A1800ConBasePres = P003V4_A1800ConBasePres[0] ;
         A1648ConCodAfip = P003V4_A1648ConCodAfip[0] ;
         A1539ConSacDeven = P003V4_A1539ConSacDeven[0] ;
         A953ConCondicion = P003V4_A953ConCondicion[0] ;
         n953ConCondicion = P003V4_n953ConCondicion[0] ;
         A762ConRecalcular = P003V4_A762ConRecalcular[0] ;
         A145ConFchModFor = P003V4_A145ConFchModFor[0] ;
         n145ConFchModFor = P003V4_n145ConFchModFor[0] ;
         A1112AplIIGG = P003V4_A1112AplIIGG[0] ;
         n1112AplIIGG = P003V4_n1112AplIIGG[0] ;
         A153ConObservacion = P003V4_A153ConObservacion[0] ;
         A150ConHabilitado = P003V4_A150ConHabilitado[0] ;
         A159ConVariable = P003V4_A159ConVariable[0] ;
         A162ConVigencia = P003V4_A162ConVigencia[0] ;
         A1645ConceptoConveCodigo = P003V4_A1645ConceptoConveCodigo[0] ;
         n1645ConceptoConveCodigo = P003V4_n1645ConceptoConveCodigo[0] ;
         A503ConTipoLiqAux = P003V4_A503ConTipoLiqAux[0] ;
         n503ConTipoLiqAux = P003V4_n503ConTipoLiqAux[0] ;
         A37TipoConCod = P003V4_A37TipoConCod[0] ;
         A41ConDescrip = P003V4_A41ConDescrip[0] ;
         A26ConCodigo = P003V4_A26ConCodigo[0] ;
         A160ConveDescri = P003V4_A160ConveDescri[0] ;
         n160ConveDescri = P003V4_n160ConveDescri[0] ;
         AV47count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P003V4_A970ConClasifAux[0], A970ConClasifAux) == 0 ) )
         {
            brk3V6 = false ;
            A3CliCod = P003V4_A3CliCod[0] ;
            A26ConCodigo = P003V4_A26ConCodigo[0] ;
            AV47count = (long)(AV47count+1) ;
            brk3V6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A970ConClasifAux)==0) )
         {
            AV39Option = A970ConClasifAux ;
            AV40Options.add(AV39Option, 0);
            AV45OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV47count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV40Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3V6 )
         {
            brk3V6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   public void S151( )
   {
      /* 'LOADCONTIPOLIQAUXOPTIONS' Routine */
      returnInSub = false ;
      AV84TFConTipoLiqAux = AV35SearchTxt ;
      AV85TFConTipoLiqAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV149Conceptowwds_1_tfconcodigo = AV10TFConCodigo ;
      AV150Conceptowwds_2_tfconcodigo_sels = AV55TFConCodigo_Sels ;
      AV151Conceptowwds_3_tfcondescrip = AV12TFConDescrip ;
      AV152Conceptowwds_4_tfcondescrip_sels = AV57TFConDescrip_Sels ;
      AV153Conceptowwds_5_tftipoconcod_sels = AV70TFTipoConCod_Sels ;
      AV154Conceptowwds_6_tfconclasifaux = AV93TFConClasifAux ;
      AV155Conceptowwds_7_tfconclasifaux_sels = AV94TFConClasifAux_Sels ;
      AV156Conceptowwds_8_tfcontipoliqaux = AV84TFConTipoLiqAux ;
      AV157Conceptowwds_9_tfcontipoliqaux_sels = AV85TFConTipoLiqAux_Sels ;
      AV158Conceptowwds_10_tfconceptoconvecodigo = AV107TFConceptoConveCodigo ;
      AV159Conceptowwds_11_tfconceptoconvecodigo_sels = AV108TFConceptoConveCodigo_Sels ;
      AV160Conceptowwds_12_tfconvigencia_sels = AV22TFConVigencia_Sels ;
      AV161Conceptowwds_13_tfconvariable_sel = AV23TFConVariable_Sel ;
      AV162Conceptowwds_14_tfconformula = AV25TFConFormula ;
      AV163Conceptowwds_15_tfconhabilitado_sel = AV14TFConHabilitado_Sel ;
      AV164Conceptowwds_16_tfconobservacion = AV27TFConObservacion ;
      AV165Conceptowwds_17_tfconobservacion_sels = AV61TFConObservacion_Sels ;
      AV166Conceptowwds_18_tfapliigg_sels = AV101TFAplIIGG_Sels ;
      AV167Conceptowwds_19_tfconfchmodfor = AV33TFConFchModFor ;
      AV168Conceptowwds_20_tfconfchmodfor_to = AV34TFConFchModFor_To ;
      AV169Conceptowwds_21_tfconrecalcular_sel = AV89TFConRecalcular_Sel ;
      AV170Conceptowwds_22_tfconcondicion_sels = AV99TFConCondicion_Sels ;
      AV171Conceptowwds_23_tfconsacdeven_sels = AV105TFConSacDeven_Sels ;
      AV172Conceptowwds_24_tfconcodafip = AV110TFConCodAfip ;
      AV173Conceptowwds_25_tfconcodafip_sels = AV111TFConCodAfip_Sels ;
      AV174Conceptowwds_26_tfconbasepres_sels = AV115TFConBasePres_Sels ;
      AV175Conceptowwds_27_tfconbaseant_sels = AV117TFConBaseAnt_Sels ;
      AV176Conceptowwds_28_tfconbasefer_sels = AV119TFConBaseFer_Sels ;
      AV177Conceptowwds_29_tfconbaseferprom_sels = AV121TFConBaseFerProm_Sels ;
      AV178Conceptowwds_30_tfconbasehorext_sels = AV123TFConBaseHorExt_Sels ;
      AV179Conceptowwds_31_tfconbasehorextprom_sels = AV125TFConBaseHorExtProm_Sels ;
      AV180Conceptowwds_32_tfconbaselic_sels = AV127TFConBaseLic_Sels ;
      AV181Conceptowwds_33_tfconbaselicprom_sels = AV129TFConBaseLicProm_Sels ;
      AV182Conceptowwds_34_tfconbaseosdif_sels = AV131TFConBaseOSDif_Sels ;
      AV183Conceptowwds_35_tfconrelref = AV142TFConRelRef ;
      AV184Conceptowwds_36_tfconrelref_sels = AV143TFConRelRef_Sels ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           A26ConCodigo ,
                                           AV150Conceptowwds_2_tfconcodigo_sels ,
                                           A41ConDescrip ,
                                           AV152Conceptowwds_4_tfcondescrip_sels ,
                                           A37TipoConCod ,
                                           AV153Conceptowwds_5_tftipoconcod_sels ,
                                           A970ConClasifAux ,
                                           AV155Conceptowwds_7_tfconclasifaux_sels ,
                                           A503ConTipoLiqAux ,
                                           AV157Conceptowwds_9_tfcontipoliqaux_sels ,
                                           A1645ConceptoConveCodigo ,
                                           AV159Conceptowwds_11_tfconceptoconvecodigo_sels ,
                                           Byte.valueOf(A162ConVigencia) ,
                                           AV160Conceptowwds_12_tfconvigencia_sels ,
                                           A153ConObservacion ,
                                           AV165Conceptowwds_17_tfconobservacion_sels ,
                                           Short.valueOf(A1112AplIIGG) ,
                                           AV166Conceptowwds_18_tfapliigg_sels ,
                                           A953ConCondicion ,
                                           AV170Conceptowwds_22_tfconcondicion_sels ,
                                           Byte.valueOf(A1539ConSacDeven) ,
                                           AV171Conceptowwds_23_tfconsacdeven_sels ,
                                           A1648ConCodAfip ,
                                           AV173Conceptowwds_25_tfconcodafip_sels ,
                                           Byte.valueOf(A1800ConBasePres) ,
                                           AV174Conceptowwds_26_tfconbasepres_sels ,
                                           Byte.valueOf(A1801ConBaseAnt) ,
                                           AV175Conceptowwds_27_tfconbaseant_sels ,
                                           Byte.valueOf(A1621ConBaseFer) ,
                                           AV176Conceptowwds_28_tfconbasefer_sels ,
                                           Byte.valueOf(A1798ConBaseFerProm) ,
                                           AV177Conceptowwds_29_tfconbaseferprom_sels ,
                                           Byte.valueOf(A1622ConBaseHorExt) ,
                                           AV178Conceptowwds_30_tfconbasehorext_sels ,
                                           Byte.valueOf(A1799ConBaseHorExtProm) ,
                                           AV179Conceptowwds_31_tfconbasehorextprom_sels ,
                                           Byte.valueOf(A1620ConBaseLic) ,
                                           AV180Conceptowwds_32_tfconbaselic_sels ,
                                           Byte.valueOf(A1797ConBaseLicProm) ,
                                           AV181Conceptowwds_33_tfconbaselicprom_sels ,
                                           Byte.valueOf(A1827ConBaseOSDif) ,
                                           AV182Conceptowwds_34_tfconbaseosdif_sels ,
                                           A2013ConRelRef ,
                                           AV184Conceptowwds_36_tfconrelref_sels ,
                                           Integer.valueOf(AV150Conceptowwds_2_tfconcodigo_sels.size()) ,
                                           AV149Conceptowwds_1_tfconcodigo ,
                                           Integer.valueOf(AV152Conceptowwds_4_tfcondescrip_sels.size()) ,
                                           AV151Conceptowwds_3_tfcondescrip ,
                                           Integer.valueOf(AV153Conceptowwds_5_tftipoconcod_sels.size()) ,
                                           Integer.valueOf(AV155Conceptowwds_7_tfconclasifaux_sels.size()) ,
                                           AV154Conceptowwds_6_tfconclasifaux ,
                                           Integer.valueOf(AV157Conceptowwds_9_tfcontipoliqaux_sels.size()) ,
                                           AV156Conceptowwds_8_tfcontipoliqaux ,
                                           Integer.valueOf(AV159Conceptowwds_11_tfconceptoconvecodigo_sels.size()) ,
                                           AV158Conceptowwds_10_tfconceptoconvecodigo ,
                                           Integer.valueOf(AV160Conceptowwds_12_tfconvigencia_sels.size()) ,
                                           Byte.valueOf(AV161Conceptowwds_13_tfconvariable_sel) ,
                                           Byte.valueOf(AV163Conceptowwds_15_tfconhabilitado_sel) ,
                                           Integer.valueOf(AV165Conceptowwds_17_tfconobservacion_sels.size()) ,
                                           AV164Conceptowwds_16_tfconobservacion ,
                                           Integer.valueOf(AV166Conceptowwds_18_tfapliigg_sels.size()) ,
                                           AV167Conceptowwds_19_tfconfchmodfor ,
                                           AV168Conceptowwds_20_tfconfchmodfor_to ,
                                           Byte.valueOf(AV169Conceptowwds_21_tfconrecalcular_sel) ,
                                           Integer.valueOf(AV170Conceptowwds_22_tfconcondicion_sels.size()) ,
                                           Integer.valueOf(AV171Conceptowwds_23_tfconsacdeven_sels.size()) ,
                                           Integer.valueOf(AV173Conceptowwds_25_tfconcodafip_sels.size()) ,
                                           AV172Conceptowwds_24_tfconcodafip ,
                                           Integer.valueOf(AV174Conceptowwds_26_tfconbasepres_sels.size()) ,
                                           Integer.valueOf(AV175Conceptowwds_27_tfconbaseant_sels.size()) ,
                                           Integer.valueOf(AV176Conceptowwds_28_tfconbasefer_sels.size()) ,
                                           Integer.valueOf(AV177Conceptowwds_29_tfconbaseferprom_sels.size()) ,
                                           Integer.valueOf(AV178Conceptowwds_30_tfconbasehorext_sels.size()) ,
                                           Integer.valueOf(AV179Conceptowwds_31_tfconbasehorextprom_sels.size()) ,
                                           Integer.valueOf(AV180Conceptowwds_32_tfconbaselic_sels.size()) ,
                                           Integer.valueOf(AV181Conceptowwds_33_tfconbaselicprom_sels.size()) ,
                                           Integer.valueOf(AV182Conceptowwds_34_tfconbaseosdif_sels.size()) ,
                                           Integer.valueOf(AV184Conceptowwds_36_tfconrelref_sels.size()) ,
                                           AV183Conceptowwds_35_tfconrelref ,
                                           AV25TFConFormula ,
                                           A160ConveDescri ,
                                           Boolean.valueOf(A159ConVariable) ,
                                           Boolean.valueOf(A150ConHabilitado) ,
                                           A145ConFchModFor ,
                                           Boolean.valueOf(A762ConRecalcular) ,
                                           A148ConFormula ,
                                           Integer.valueOf(AV64CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV149Conceptowwds_1_tfconcodigo = GXutil.padr( GXutil.rtrim( AV149Conceptowwds_1_tfconcodigo), 10, "%") ;
      lV151Conceptowwds_3_tfcondescrip = GXutil.concat( GXutil.rtrim( AV151Conceptowwds_3_tfcondescrip), "%", "") ;
      lV154Conceptowwds_6_tfconclasifaux = GXutil.concat( GXutil.rtrim( AV154Conceptowwds_6_tfconclasifaux), "%", "") ;
      lV156Conceptowwds_8_tfcontipoliqaux = GXutil.concat( GXutil.rtrim( AV156Conceptowwds_8_tfcontipoliqaux), "%", "") ;
      lV158Conceptowwds_10_tfconceptoconvecodigo = GXutil.concat( GXutil.rtrim( AV158Conceptowwds_10_tfconceptoconvecodigo), "%", "") ;
      lV164Conceptowwds_16_tfconobservacion = GXutil.concat( GXutil.rtrim( AV164Conceptowwds_16_tfconobservacion), "%", "") ;
      lV172Conceptowwds_24_tfconcodafip = GXutil.padr( GXutil.rtrim( AV172Conceptowwds_24_tfconcodafip), 6, "%") ;
      lV183Conceptowwds_35_tfconrelref = GXutil.concat( GXutil.rtrim( AV183Conceptowwds_35_tfconrelref), "%", "") ;
      lV25TFConFormula = GXutil.concat( GXutil.rtrim( AV25TFConFormula), "%", "") ;
      /* Using cursor P003V5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV64CliCod), lV149Conceptowwds_1_tfconcodigo, lV151Conceptowwds_3_tfcondescrip, lV154Conceptowwds_6_tfconclasifaux, lV156Conceptowwds_8_tfcontipoliqaux, lV158Conceptowwds_10_tfconceptoconvecodigo, lV164Conceptowwds_16_tfconobservacion, AV167Conceptowwds_19_tfconfchmodfor, AV168Conceptowwds_20_tfconfchmodfor_to, lV172Conceptowwds_24_tfconcodafip, lV183Conceptowwds_35_tfconrelref, lV25TFConFormula});
      while ( (pr_default.getStatus(3) != 101) )
      {
         brk3V8 = false ;
         A1644ConceptoPais = P003V5_A1644ConceptoPais[0] ;
         n1644ConceptoPais = P003V5_n1644ConceptoPais[0] ;
         A3CliCod = P003V5_A3CliCod[0] ;
         A503ConTipoLiqAux = P003V5_A503ConTipoLiqAux[0] ;
         n503ConTipoLiqAux = P003V5_n503ConTipoLiqAux[0] ;
         A148ConFormula = P003V5_A148ConFormula[0] ;
         n148ConFormula = P003V5_n148ConFormula[0] ;
         A160ConveDescri = P003V5_A160ConveDescri[0] ;
         n160ConveDescri = P003V5_n160ConveDescri[0] ;
         A2013ConRelRef = P003V5_A2013ConRelRef[0] ;
         A1827ConBaseOSDif = P003V5_A1827ConBaseOSDif[0] ;
         A1797ConBaseLicProm = P003V5_A1797ConBaseLicProm[0] ;
         A1620ConBaseLic = P003V5_A1620ConBaseLic[0] ;
         A1799ConBaseHorExtProm = P003V5_A1799ConBaseHorExtProm[0] ;
         A1622ConBaseHorExt = P003V5_A1622ConBaseHorExt[0] ;
         A1798ConBaseFerProm = P003V5_A1798ConBaseFerProm[0] ;
         A1621ConBaseFer = P003V5_A1621ConBaseFer[0] ;
         A1801ConBaseAnt = P003V5_A1801ConBaseAnt[0] ;
         A1800ConBasePres = P003V5_A1800ConBasePres[0] ;
         A1648ConCodAfip = P003V5_A1648ConCodAfip[0] ;
         A1539ConSacDeven = P003V5_A1539ConSacDeven[0] ;
         A953ConCondicion = P003V5_A953ConCondicion[0] ;
         n953ConCondicion = P003V5_n953ConCondicion[0] ;
         A762ConRecalcular = P003V5_A762ConRecalcular[0] ;
         A145ConFchModFor = P003V5_A145ConFchModFor[0] ;
         n145ConFchModFor = P003V5_n145ConFchModFor[0] ;
         A1112AplIIGG = P003V5_A1112AplIIGG[0] ;
         n1112AplIIGG = P003V5_n1112AplIIGG[0] ;
         A153ConObservacion = P003V5_A153ConObservacion[0] ;
         A150ConHabilitado = P003V5_A150ConHabilitado[0] ;
         A159ConVariable = P003V5_A159ConVariable[0] ;
         A162ConVigencia = P003V5_A162ConVigencia[0] ;
         A1645ConceptoConveCodigo = P003V5_A1645ConceptoConveCodigo[0] ;
         n1645ConceptoConveCodigo = P003V5_n1645ConceptoConveCodigo[0] ;
         A970ConClasifAux = P003V5_A970ConClasifAux[0] ;
         n970ConClasifAux = P003V5_n970ConClasifAux[0] ;
         A37TipoConCod = P003V5_A37TipoConCod[0] ;
         A41ConDescrip = P003V5_A41ConDescrip[0] ;
         A26ConCodigo = P003V5_A26ConCodigo[0] ;
         A160ConveDescri = P003V5_A160ConveDescri[0] ;
         n160ConveDescri = P003V5_n160ConveDescri[0] ;
         AV47count = 0 ;
         while ( (pr_default.getStatus(3) != 101) && ( P003V5_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P003V5_A503ConTipoLiqAux[0], A503ConTipoLiqAux) == 0 ) )
         {
            brk3V8 = false ;
            A26ConCodigo = P003V5_A26ConCodigo[0] ;
            AV47count = (long)(AV47count+1) ;
            brk3V8 = true ;
            pr_default.readNext(3);
         }
         if ( ! (GXutil.strcmp("", A503ConTipoLiqAux)==0) )
         {
            AV39Option = A503ConTipoLiqAux ;
            AV40Options.add(AV39Option, 0);
            AV45OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV47count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV40Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3V8 )
         {
            brk3V8 = true ;
            pr_default.readNext(3);
         }
      }
      pr_default.close(3);
   }

   public void S161( )
   {
      /* 'LOADCONCEPTOCONVECODIGOOPTIONS' Routine */
      returnInSub = false ;
      AV107TFConceptoConveCodigo = AV35SearchTxt ;
      AV108TFConceptoConveCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV149Conceptowwds_1_tfconcodigo = AV10TFConCodigo ;
      AV150Conceptowwds_2_tfconcodigo_sels = AV55TFConCodigo_Sels ;
      AV151Conceptowwds_3_tfcondescrip = AV12TFConDescrip ;
      AV152Conceptowwds_4_tfcondescrip_sels = AV57TFConDescrip_Sels ;
      AV153Conceptowwds_5_tftipoconcod_sels = AV70TFTipoConCod_Sels ;
      AV154Conceptowwds_6_tfconclasifaux = AV93TFConClasifAux ;
      AV155Conceptowwds_7_tfconclasifaux_sels = AV94TFConClasifAux_Sels ;
      AV156Conceptowwds_8_tfcontipoliqaux = AV84TFConTipoLiqAux ;
      AV157Conceptowwds_9_tfcontipoliqaux_sels = AV85TFConTipoLiqAux_Sels ;
      AV158Conceptowwds_10_tfconceptoconvecodigo = AV107TFConceptoConveCodigo ;
      AV159Conceptowwds_11_tfconceptoconvecodigo_sels = AV108TFConceptoConveCodigo_Sels ;
      AV160Conceptowwds_12_tfconvigencia_sels = AV22TFConVigencia_Sels ;
      AV161Conceptowwds_13_tfconvariable_sel = AV23TFConVariable_Sel ;
      AV162Conceptowwds_14_tfconformula = AV25TFConFormula ;
      AV163Conceptowwds_15_tfconhabilitado_sel = AV14TFConHabilitado_Sel ;
      AV164Conceptowwds_16_tfconobservacion = AV27TFConObservacion ;
      AV165Conceptowwds_17_tfconobservacion_sels = AV61TFConObservacion_Sels ;
      AV166Conceptowwds_18_tfapliigg_sels = AV101TFAplIIGG_Sels ;
      AV167Conceptowwds_19_tfconfchmodfor = AV33TFConFchModFor ;
      AV168Conceptowwds_20_tfconfchmodfor_to = AV34TFConFchModFor_To ;
      AV169Conceptowwds_21_tfconrecalcular_sel = AV89TFConRecalcular_Sel ;
      AV170Conceptowwds_22_tfconcondicion_sels = AV99TFConCondicion_Sels ;
      AV171Conceptowwds_23_tfconsacdeven_sels = AV105TFConSacDeven_Sels ;
      AV172Conceptowwds_24_tfconcodafip = AV110TFConCodAfip ;
      AV173Conceptowwds_25_tfconcodafip_sels = AV111TFConCodAfip_Sels ;
      AV174Conceptowwds_26_tfconbasepres_sels = AV115TFConBasePres_Sels ;
      AV175Conceptowwds_27_tfconbaseant_sels = AV117TFConBaseAnt_Sels ;
      AV176Conceptowwds_28_tfconbasefer_sels = AV119TFConBaseFer_Sels ;
      AV177Conceptowwds_29_tfconbaseferprom_sels = AV121TFConBaseFerProm_Sels ;
      AV178Conceptowwds_30_tfconbasehorext_sels = AV123TFConBaseHorExt_Sels ;
      AV179Conceptowwds_31_tfconbasehorextprom_sels = AV125TFConBaseHorExtProm_Sels ;
      AV180Conceptowwds_32_tfconbaselic_sels = AV127TFConBaseLic_Sels ;
      AV181Conceptowwds_33_tfconbaselicprom_sels = AV129TFConBaseLicProm_Sels ;
      AV182Conceptowwds_34_tfconbaseosdif_sels = AV131TFConBaseOSDif_Sels ;
      AV183Conceptowwds_35_tfconrelref = AV142TFConRelRef ;
      AV184Conceptowwds_36_tfconrelref_sels = AV143TFConRelRef_Sels ;
      pr_default.dynParam(4, new Object[]{ new Object[]{
                                           A26ConCodigo ,
                                           AV150Conceptowwds_2_tfconcodigo_sels ,
                                           A41ConDescrip ,
                                           AV152Conceptowwds_4_tfcondescrip_sels ,
                                           A37TipoConCod ,
                                           AV153Conceptowwds_5_tftipoconcod_sels ,
                                           A970ConClasifAux ,
                                           AV155Conceptowwds_7_tfconclasifaux_sels ,
                                           A503ConTipoLiqAux ,
                                           AV157Conceptowwds_9_tfcontipoliqaux_sels ,
                                           A1645ConceptoConveCodigo ,
                                           AV159Conceptowwds_11_tfconceptoconvecodigo_sels ,
                                           Byte.valueOf(A162ConVigencia) ,
                                           AV160Conceptowwds_12_tfconvigencia_sels ,
                                           A153ConObservacion ,
                                           AV165Conceptowwds_17_tfconobservacion_sels ,
                                           Short.valueOf(A1112AplIIGG) ,
                                           AV166Conceptowwds_18_tfapliigg_sels ,
                                           A953ConCondicion ,
                                           AV170Conceptowwds_22_tfconcondicion_sels ,
                                           Byte.valueOf(A1539ConSacDeven) ,
                                           AV171Conceptowwds_23_tfconsacdeven_sels ,
                                           A1648ConCodAfip ,
                                           AV173Conceptowwds_25_tfconcodafip_sels ,
                                           Byte.valueOf(A1800ConBasePres) ,
                                           AV174Conceptowwds_26_tfconbasepres_sels ,
                                           Byte.valueOf(A1801ConBaseAnt) ,
                                           AV175Conceptowwds_27_tfconbaseant_sels ,
                                           Byte.valueOf(A1621ConBaseFer) ,
                                           AV176Conceptowwds_28_tfconbasefer_sels ,
                                           Byte.valueOf(A1798ConBaseFerProm) ,
                                           AV177Conceptowwds_29_tfconbaseferprom_sels ,
                                           Byte.valueOf(A1622ConBaseHorExt) ,
                                           AV178Conceptowwds_30_tfconbasehorext_sels ,
                                           Byte.valueOf(A1799ConBaseHorExtProm) ,
                                           AV179Conceptowwds_31_tfconbasehorextprom_sels ,
                                           Byte.valueOf(A1620ConBaseLic) ,
                                           AV180Conceptowwds_32_tfconbaselic_sels ,
                                           Byte.valueOf(A1797ConBaseLicProm) ,
                                           AV181Conceptowwds_33_tfconbaselicprom_sels ,
                                           Byte.valueOf(A1827ConBaseOSDif) ,
                                           AV182Conceptowwds_34_tfconbaseosdif_sels ,
                                           A2013ConRelRef ,
                                           AV184Conceptowwds_36_tfconrelref_sels ,
                                           Integer.valueOf(AV150Conceptowwds_2_tfconcodigo_sels.size()) ,
                                           AV149Conceptowwds_1_tfconcodigo ,
                                           Integer.valueOf(AV152Conceptowwds_4_tfcondescrip_sels.size()) ,
                                           AV151Conceptowwds_3_tfcondescrip ,
                                           Integer.valueOf(AV153Conceptowwds_5_tftipoconcod_sels.size()) ,
                                           Integer.valueOf(AV155Conceptowwds_7_tfconclasifaux_sels.size()) ,
                                           AV154Conceptowwds_6_tfconclasifaux ,
                                           Integer.valueOf(AV157Conceptowwds_9_tfcontipoliqaux_sels.size()) ,
                                           AV156Conceptowwds_8_tfcontipoliqaux ,
                                           Integer.valueOf(AV159Conceptowwds_11_tfconceptoconvecodigo_sels.size()) ,
                                           AV158Conceptowwds_10_tfconceptoconvecodigo ,
                                           Integer.valueOf(AV160Conceptowwds_12_tfconvigencia_sels.size()) ,
                                           Byte.valueOf(AV161Conceptowwds_13_tfconvariable_sel) ,
                                           Byte.valueOf(AV163Conceptowwds_15_tfconhabilitado_sel) ,
                                           Integer.valueOf(AV165Conceptowwds_17_tfconobservacion_sels.size()) ,
                                           AV164Conceptowwds_16_tfconobservacion ,
                                           Integer.valueOf(AV166Conceptowwds_18_tfapliigg_sels.size()) ,
                                           AV167Conceptowwds_19_tfconfchmodfor ,
                                           AV168Conceptowwds_20_tfconfchmodfor_to ,
                                           Byte.valueOf(AV169Conceptowwds_21_tfconrecalcular_sel) ,
                                           Integer.valueOf(AV170Conceptowwds_22_tfconcondicion_sels.size()) ,
                                           Integer.valueOf(AV171Conceptowwds_23_tfconsacdeven_sels.size()) ,
                                           Integer.valueOf(AV173Conceptowwds_25_tfconcodafip_sels.size()) ,
                                           AV172Conceptowwds_24_tfconcodafip ,
                                           Integer.valueOf(AV174Conceptowwds_26_tfconbasepres_sels.size()) ,
                                           Integer.valueOf(AV175Conceptowwds_27_tfconbaseant_sels.size()) ,
                                           Integer.valueOf(AV176Conceptowwds_28_tfconbasefer_sels.size()) ,
                                           Integer.valueOf(AV177Conceptowwds_29_tfconbaseferprom_sels.size()) ,
                                           Integer.valueOf(AV178Conceptowwds_30_tfconbasehorext_sels.size()) ,
                                           Integer.valueOf(AV179Conceptowwds_31_tfconbasehorextprom_sels.size()) ,
                                           Integer.valueOf(AV180Conceptowwds_32_tfconbaselic_sels.size()) ,
                                           Integer.valueOf(AV181Conceptowwds_33_tfconbaselicprom_sels.size()) ,
                                           Integer.valueOf(AV182Conceptowwds_34_tfconbaseosdif_sels.size()) ,
                                           Integer.valueOf(AV184Conceptowwds_36_tfconrelref_sels.size()) ,
                                           AV183Conceptowwds_35_tfconrelref ,
                                           AV25TFConFormula ,
                                           A160ConveDescri ,
                                           Boolean.valueOf(A159ConVariable) ,
                                           Boolean.valueOf(A150ConHabilitado) ,
                                           A145ConFchModFor ,
                                           Boolean.valueOf(A762ConRecalcular) ,
                                           A148ConFormula ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV64CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV149Conceptowwds_1_tfconcodigo = GXutil.padr( GXutil.rtrim( AV149Conceptowwds_1_tfconcodigo), 10, "%") ;
      lV151Conceptowwds_3_tfcondescrip = GXutil.concat( GXutil.rtrim( AV151Conceptowwds_3_tfcondescrip), "%", "") ;
      lV154Conceptowwds_6_tfconclasifaux = GXutil.concat( GXutil.rtrim( AV154Conceptowwds_6_tfconclasifaux), "%", "") ;
      lV156Conceptowwds_8_tfcontipoliqaux = GXutil.concat( GXutil.rtrim( AV156Conceptowwds_8_tfcontipoliqaux), "%", "") ;
      lV158Conceptowwds_10_tfconceptoconvecodigo = GXutil.concat( GXutil.rtrim( AV158Conceptowwds_10_tfconceptoconvecodigo), "%", "") ;
      lV164Conceptowwds_16_tfconobservacion = GXutil.concat( GXutil.rtrim( AV164Conceptowwds_16_tfconobservacion), "%", "") ;
      lV172Conceptowwds_24_tfconcodafip = GXutil.padr( GXutil.rtrim( AV172Conceptowwds_24_tfconcodafip), 6, "%") ;
      lV183Conceptowwds_35_tfconrelref = GXutil.concat( GXutil.rtrim( AV183Conceptowwds_35_tfconrelref), "%", "") ;
      lV25TFConFormula = GXutil.concat( GXutil.rtrim( AV25TFConFormula), "%", "") ;
      /* Using cursor P003V6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(AV64CliCod), lV149Conceptowwds_1_tfconcodigo, lV151Conceptowwds_3_tfcondescrip, lV154Conceptowwds_6_tfconclasifaux, lV156Conceptowwds_8_tfcontipoliqaux, lV158Conceptowwds_10_tfconceptoconvecodigo, lV164Conceptowwds_16_tfconobservacion, AV167Conceptowwds_19_tfconfchmodfor, AV168Conceptowwds_20_tfconfchmodfor_to, lV172Conceptowwds_24_tfconcodafip, lV183Conceptowwds_35_tfconrelref, lV25TFConFormula});
      while ( (pr_default.getStatus(4) != 101) )
      {
         brk3V10 = false ;
         A1644ConceptoPais = P003V6_A1644ConceptoPais[0] ;
         n1644ConceptoPais = P003V6_n1644ConceptoPais[0] ;
         A3CliCod = P003V6_A3CliCod[0] ;
         A1645ConceptoConveCodigo = P003V6_A1645ConceptoConveCodigo[0] ;
         n1645ConceptoConveCodigo = P003V6_n1645ConceptoConveCodigo[0] ;
         A148ConFormula = P003V6_A148ConFormula[0] ;
         n148ConFormula = P003V6_n148ConFormula[0] ;
         A160ConveDescri = P003V6_A160ConveDescri[0] ;
         n160ConveDescri = P003V6_n160ConveDescri[0] ;
         A2013ConRelRef = P003V6_A2013ConRelRef[0] ;
         A1827ConBaseOSDif = P003V6_A1827ConBaseOSDif[0] ;
         A1797ConBaseLicProm = P003V6_A1797ConBaseLicProm[0] ;
         A1620ConBaseLic = P003V6_A1620ConBaseLic[0] ;
         A1799ConBaseHorExtProm = P003V6_A1799ConBaseHorExtProm[0] ;
         A1622ConBaseHorExt = P003V6_A1622ConBaseHorExt[0] ;
         A1798ConBaseFerProm = P003V6_A1798ConBaseFerProm[0] ;
         A1621ConBaseFer = P003V6_A1621ConBaseFer[0] ;
         A1801ConBaseAnt = P003V6_A1801ConBaseAnt[0] ;
         A1800ConBasePres = P003V6_A1800ConBasePres[0] ;
         A1648ConCodAfip = P003V6_A1648ConCodAfip[0] ;
         A1539ConSacDeven = P003V6_A1539ConSacDeven[0] ;
         A953ConCondicion = P003V6_A953ConCondicion[0] ;
         n953ConCondicion = P003V6_n953ConCondicion[0] ;
         A762ConRecalcular = P003V6_A762ConRecalcular[0] ;
         A145ConFchModFor = P003V6_A145ConFchModFor[0] ;
         n145ConFchModFor = P003V6_n145ConFchModFor[0] ;
         A1112AplIIGG = P003V6_A1112AplIIGG[0] ;
         n1112AplIIGG = P003V6_n1112AplIIGG[0] ;
         A153ConObservacion = P003V6_A153ConObservacion[0] ;
         A150ConHabilitado = P003V6_A150ConHabilitado[0] ;
         A159ConVariable = P003V6_A159ConVariable[0] ;
         A162ConVigencia = P003V6_A162ConVigencia[0] ;
         A503ConTipoLiqAux = P003V6_A503ConTipoLiqAux[0] ;
         n503ConTipoLiqAux = P003V6_n503ConTipoLiqAux[0] ;
         A970ConClasifAux = P003V6_A970ConClasifAux[0] ;
         n970ConClasifAux = P003V6_n970ConClasifAux[0] ;
         A37TipoConCod = P003V6_A37TipoConCod[0] ;
         A41ConDescrip = P003V6_A41ConDescrip[0] ;
         A26ConCodigo = P003V6_A26ConCodigo[0] ;
         A160ConveDescri = P003V6_A160ConveDescri[0] ;
         n160ConveDescri = P003V6_n160ConveDescri[0] ;
         AV47count = 0 ;
         while ( (pr_default.getStatus(4) != 101) && ( GXutil.strcmp(P003V6_A1645ConceptoConveCodigo[0], A1645ConceptoConveCodigo) == 0 ) )
         {
            brk3V10 = false ;
            A3CliCod = P003V6_A3CliCod[0] ;
            A26ConCodigo = P003V6_A26ConCodigo[0] ;
            AV47count = (long)(AV47count+1) ;
            brk3V10 = true ;
            pr_default.readNext(4);
         }
         if ( ! (GXutil.strcmp("", A160ConveDescri)==0) )
         {
            AV39Option = A1645ConceptoConveCodigo ;
            AV42OptionDesc = A160ConveDescri ;
            AV38InsertIndex = 1 ;
            while ( ( AV38InsertIndex <= AV40Options.size() ) && ( GXutil.strcmp((String)AV43OptionsDesc.elementAt(-1+AV38InsertIndex), AV42OptionDesc) < 0 ) )
            {
               AV38InsertIndex = (int)(AV38InsertIndex+1) ;
            }
            AV40Options.add(AV39Option, AV38InsertIndex);
            AV43OptionsDesc.add(AV42OptionDesc, AV38InsertIndex);
            AV45OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV47count), "Z,ZZZ,ZZZ,ZZ9")), AV38InsertIndex);
         }
         if ( AV40Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3V10 )
         {
            brk3V10 = true ;
            pr_default.readNext(4);
         }
      }
      pr_default.close(4);
   }

   public void S171( )
   {
      /* 'LOADCONOBSERVACIONOPTIONS' Routine */
      returnInSub = false ;
      new web.msgdebug(remoteHandle, context).execute( AV146Pgmname, "10") ;
      AV27TFConObservacion = AV35SearchTxt ;
      AV61TFConObservacion_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV149Conceptowwds_1_tfconcodigo = AV10TFConCodigo ;
      AV150Conceptowwds_2_tfconcodigo_sels = AV55TFConCodigo_Sels ;
      AV151Conceptowwds_3_tfcondescrip = AV12TFConDescrip ;
      AV152Conceptowwds_4_tfcondescrip_sels = AV57TFConDescrip_Sels ;
      AV153Conceptowwds_5_tftipoconcod_sels = AV70TFTipoConCod_Sels ;
      AV154Conceptowwds_6_tfconclasifaux = AV93TFConClasifAux ;
      AV155Conceptowwds_7_tfconclasifaux_sels = AV94TFConClasifAux_Sels ;
      AV156Conceptowwds_8_tfcontipoliqaux = AV84TFConTipoLiqAux ;
      AV157Conceptowwds_9_tfcontipoliqaux_sels = AV85TFConTipoLiqAux_Sels ;
      AV158Conceptowwds_10_tfconceptoconvecodigo = AV107TFConceptoConveCodigo ;
      AV159Conceptowwds_11_tfconceptoconvecodigo_sels = AV108TFConceptoConveCodigo_Sels ;
      AV160Conceptowwds_12_tfconvigencia_sels = AV22TFConVigencia_Sels ;
      AV161Conceptowwds_13_tfconvariable_sel = AV23TFConVariable_Sel ;
      AV162Conceptowwds_14_tfconformula = AV25TFConFormula ;
      AV163Conceptowwds_15_tfconhabilitado_sel = AV14TFConHabilitado_Sel ;
      AV164Conceptowwds_16_tfconobservacion = AV27TFConObservacion ;
      AV165Conceptowwds_17_tfconobservacion_sels = AV61TFConObservacion_Sels ;
      AV166Conceptowwds_18_tfapliigg_sels = AV101TFAplIIGG_Sels ;
      AV167Conceptowwds_19_tfconfchmodfor = AV33TFConFchModFor ;
      AV168Conceptowwds_20_tfconfchmodfor_to = AV34TFConFchModFor_To ;
      AV169Conceptowwds_21_tfconrecalcular_sel = AV89TFConRecalcular_Sel ;
      AV170Conceptowwds_22_tfconcondicion_sels = AV99TFConCondicion_Sels ;
      AV171Conceptowwds_23_tfconsacdeven_sels = AV105TFConSacDeven_Sels ;
      AV172Conceptowwds_24_tfconcodafip = AV110TFConCodAfip ;
      AV173Conceptowwds_25_tfconcodafip_sels = AV111TFConCodAfip_Sels ;
      AV174Conceptowwds_26_tfconbasepres_sels = AV115TFConBasePres_Sels ;
      AV175Conceptowwds_27_tfconbaseant_sels = AV117TFConBaseAnt_Sels ;
      AV176Conceptowwds_28_tfconbasefer_sels = AV119TFConBaseFer_Sels ;
      AV177Conceptowwds_29_tfconbaseferprom_sels = AV121TFConBaseFerProm_Sels ;
      AV178Conceptowwds_30_tfconbasehorext_sels = AV123TFConBaseHorExt_Sels ;
      AV179Conceptowwds_31_tfconbasehorextprom_sels = AV125TFConBaseHorExtProm_Sels ;
      AV180Conceptowwds_32_tfconbaselic_sels = AV127TFConBaseLic_Sels ;
      AV181Conceptowwds_33_tfconbaselicprom_sels = AV129TFConBaseLicProm_Sels ;
      AV182Conceptowwds_34_tfconbaseosdif_sels = AV131TFConBaseOSDif_Sels ;
      AV183Conceptowwds_35_tfconrelref = AV142TFConRelRef ;
      AV184Conceptowwds_36_tfconrelref_sels = AV143TFConRelRef_Sels ;
      pr_default.dynParam(5, new Object[]{ new Object[]{
                                           A26ConCodigo ,
                                           AV150Conceptowwds_2_tfconcodigo_sels ,
                                           A41ConDescrip ,
                                           AV152Conceptowwds_4_tfcondescrip_sels ,
                                           A37TipoConCod ,
                                           AV153Conceptowwds_5_tftipoconcod_sels ,
                                           A970ConClasifAux ,
                                           AV155Conceptowwds_7_tfconclasifaux_sels ,
                                           A503ConTipoLiqAux ,
                                           AV157Conceptowwds_9_tfcontipoliqaux_sels ,
                                           A1645ConceptoConveCodigo ,
                                           AV159Conceptowwds_11_tfconceptoconvecodigo_sels ,
                                           Byte.valueOf(A162ConVigencia) ,
                                           AV160Conceptowwds_12_tfconvigencia_sels ,
                                           A153ConObservacion ,
                                           AV165Conceptowwds_17_tfconobservacion_sels ,
                                           Short.valueOf(A1112AplIIGG) ,
                                           AV166Conceptowwds_18_tfapliigg_sels ,
                                           A953ConCondicion ,
                                           AV170Conceptowwds_22_tfconcondicion_sels ,
                                           Byte.valueOf(A1539ConSacDeven) ,
                                           AV171Conceptowwds_23_tfconsacdeven_sels ,
                                           A1648ConCodAfip ,
                                           AV173Conceptowwds_25_tfconcodafip_sels ,
                                           Byte.valueOf(A1800ConBasePres) ,
                                           AV174Conceptowwds_26_tfconbasepres_sels ,
                                           Byte.valueOf(A1801ConBaseAnt) ,
                                           AV175Conceptowwds_27_tfconbaseant_sels ,
                                           Byte.valueOf(A1621ConBaseFer) ,
                                           AV176Conceptowwds_28_tfconbasefer_sels ,
                                           Byte.valueOf(A1798ConBaseFerProm) ,
                                           AV177Conceptowwds_29_tfconbaseferprom_sels ,
                                           Byte.valueOf(A1622ConBaseHorExt) ,
                                           AV178Conceptowwds_30_tfconbasehorext_sels ,
                                           Byte.valueOf(A1799ConBaseHorExtProm) ,
                                           AV179Conceptowwds_31_tfconbasehorextprom_sels ,
                                           Byte.valueOf(A1620ConBaseLic) ,
                                           AV180Conceptowwds_32_tfconbaselic_sels ,
                                           Byte.valueOf(A1797ConBaseLicProm) ,
                                           AV181Conceptowwds_33_tfconbaselicprom_sels ,
                                           Byte.valueOf(A1827ConBaseOSDif) ,
                                           AV182Conceptowwds_34_tfconbaseosdif_sels ,
                                           A2013ConRelRef ,
                                           AV184Conceptowwds_36_tfconrelref_sels ,
                                           Integer.valueOf(AV150Conceptowwds_2_tfconcodigo_sels.size()) ,
                                           AV149Conceptowwds_1_tfconcodigo ,
                                           Integer.valueOf(AV152Conceptowwds_4_tfcondescrip_sels.size()) ,
                                           AV151Conceptowwds_3_tfcondescrip ,
                                           Integer.valueOf(AV153Conceptowwds_5_tftipoconcod_sels.size()) ,
                                           Integer.valueOf(AV155Conceptowwds_7_tfconclasifaux_sels.size()) ,
                                           AV154Conceptowwds_6_tfconclasifaux ,
                                           Integer.valueOf(AV157Conceptowwds_9_tfcontipoliqaux_sels.size()) ,
                                           AV156Conceptowwds_8_tfcontipoliqaux ,
                                           Integer.valueOf(AV159Conceptowwds_11_tfconceptoconvecodigo_sels.size()) ,
                                           AV158Conceptowwds_10_tfconceptoconvecodigo ,
                                           Integer.valueOf(AV160Conceptowwds_12_tfconvigencia_sels.size()) ,
                                           Byte.valueOf(AV161Conceptowwds_13_tfconvariable_sel) ,
                                           Byte.valueOf(AV163Conceptowwds_15_tfconhabilitado_sel) ,
                                           Integer.valueOf(AV165Conceptowwds_17_tfconobservacion_sels.size()) ,
                                           AV164Conceptowwds_16_tfconobservacion ,
                                           Integer.valueOf(AV166Conceptowwds_18_tfapliigg_sels.size()) ,
                                           AV167Conceptowwds_19_tfconfchmodfor ,
                                           AV168Conceptowwds_20_tfconfchmodfor_to ,
                                           Byte.valueOf(AV169Conceptowwds_21_tfconrecalcular_sel) ,
                                           Integer.valueOf(AV170Conceptowwds_22_tfconcondicion_sels.size()) ,
                                           Integer.valueOf(AV171Conceptowwds_23_tfconsacdeven_sels.size()) ,
                                           Integer.valueOf(AV173Conceptowwds_25_tfconcodafip_sels.size()) ,
                                           AV172Conceptowwds_24_tfconcodafip ,
                                           Integer.valueOf(AV174Conceptowwds_26_tfconbasepres_sels.size()) ,
                                           Integer.valueOf(AV175Conceptowwds_27_tfconbaseant_sels.size()) ,
                                           Integer.valueOf(AV176Conceptowwds_28_tfconbasefer_sels.size()) ,
                                           Integer.valueOf(AV177Conceptowwds_29_tfconbaseferprom_sels.size()) ,
                                           Integer.valueOf(AV178Conceptowwds_30_tfconbasehorext_sels.size()) ,
                                           Integer.valueOf(AV179Conceptowwds_31_tfconbasehorextprom_sels.size()) ,
                                           Integer.valueOf(AV180Conceptowwds_32_tfconbaselic_sels.size()) ,
                                           Integer.valueOf(AV181Conceptowwds_33_tfconbaselicprom_sels.size()) ,
                                           Integer.valueOf(AV182Conceptowwds_34_tfconbaseosdif_sels.size()) ,
                                           Integer.valueOf(AV184Conceptowwds_36_tfconrelref_sels.size()) ,
                                           AV183Conceptowwds_35_tfconrelref ,
                                           AV25TFConFormula ,
                                           A160ConveDescri ,
                                           Boolean.valueOf(A159ConVariable) ,
                                           Boolean.valueOf(A150ConHabilitado) ,
                                           A145ConFchModFor ,
                                           Boolean.valueOf(A762ConRecalcular) ,
                                           A148ConFormula ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV64CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV149Conceptowwds_1_tfconcodigo = GXutil.padr( GXutil.rtrim( AV149Conceptowwds_1_tfconcodigo), 10, "%") ;
      lV151Conceptowwds_3_tfcondescrip = GXutil.concat( GXutil.rtrim( AV151Conceptowwds_3_tfcondescrip), "%", "") ;
      lV154Conceptowwds_6_tfconclasifaux = GXutil.concat( GXutil.rtrim( AV154Conceptowwds_6_tfconclasifaux), "%", "") ;
      lV156Conceptowwds_8_tfcontipoliqaux = GXutil.concat( GXutil.rtrim( AV156Conceptowwds_8_tfcontipoliqaux), "%", "") ;
      lV158Conceptowwds_10_tfconceptoconvecodigo = GXutil.concat( GXutil.rtrim( AV158Conceptowwds_10_tfconceptoconvecodigo), "%", "") ;
      lV164Conceptowwds_16_tfconobservacion = GXutil.concat( GXutil.rtrim( AV164Conceptowwds_16_tfconobservacion), "%", "") ;
      lV172Conceptowwds_24_tfconcodafip = GXutil.padr( GXutil.rtrim( AV172Conceptowwds_24_tfconcodafip), 6, "%") ;
      lV183Conceptowwds_35_tfconrelref = GXutil.concat( GXutil.rtrim( AV183Conceptowwds_35_tfconrelref), "%", "") ;
      lV25TFConFormula = GXutil.concat( GXutil.rtrim( AV25TFConFormula), "%", "") ;
      /* Using cursor P003V7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(AV64CliCod), lV149Conceptowwds_1_tfconcodigo, lV151Conceptowwds_3_tfcondescrip, lV154Conceptowwds_6_tfconclasifaux, lV156Conceptowwds_8_tfcontipoliqaux, lV158Conceptowwds_10_tfconceptoconvecodigo, lV164Conceptowwds_16_tfconobservacion, AV167Conceptowwds_19_tfconfchmodfor, AV168Conceptowwds_20_tfconfchmodfor_to, lV172Conceptowwds_24_tfconcodafip, lV183Conceptowwds_35_tfconrelref, lV25TFConFormula});
      while ( (pr_default.getStatus(5) != 101) )
      {
         brk3V12 = false ;
         A1644ConceptoPais = P003V7_A1644ConceptoPais[0] ;
         n1644ConceptoPais = P003V7_n1644ConceptoPais[0] ;
         A3CliCod = P003V7_A3CliCod[0] ;
         A153ConObservacion = P003V7_A153ConObservacion[0] ;
         A148ConFormula = P003V7_A148ConFormula[0] ;
         n148ConFormula = P003V7_n148ConFormula[0] ;
         A160ConveDescri = P003V7_A160ConveDescri[0] ;
         n160ConveDescri = P003V7_n160ConveDescri[0] ;
         A2013ConRelRef = P003V7_A2013ConRelRef[0] ;
         A1827ConBaseOSDif = P003V7_A1827ConBaseOSDif[0] ;
         A1797ConBaseLicProm = P003V7_A1797ConBaseLicProm[0] ;
         A1620ConBaseLic = P003V7_A1620ConBaseLic[0] ;
         A1799ConBaseHorExtProm = P003V7_A1799ConBaseHorExtProm[0] ;
         A1622ConBaseHorExt = P003V7_A1622ConBaseHorExt[0] ;
         A1798ConBaseFerProm = P003V7_A1798ConBaseFerProm[0] ;
         A1621ConBaseFer = P003V7_A1621ConBaseFer[0] ;
         A1801ConBaseAnt = P003V7_A1801ConBaseAnt[0] ;
         A1800ConBasePres = P003V7_A1800ConBasePres[0] ;
         A1648ConCodAfip = P003V7_A1648ConCodAfip[0] ;
         A1539ConSacDeven = P003V7_A1539ConSacDeven[0] ;
         A953ConCondicion = P003V7_A953ConCondicion[0] ;
         n953ConCondicion = P003V7_n953ConCondicion[0] ;
         A762ConRecalcular = P003V7_A762ConRecalcular[0] ;
         A145ConFchModFor = P003V7_A145ConFchModFor[0] ;
         n145ConFchModFor = P003V7_n145ConFchModFor[0] ;
         A1112AplIIGG = P003V7_A1112AplIIGG[0] ;
         n1112AplIIGG = P003V7_n1112AplIIGG[0] ;
         A150ConHabilitado = P003V7_A150ConHabilitado[0] ;
         A159ConVariable = P003V7_A159ConVariable[0] ;
         A162ConVigencia = P003V7_A162ConVigencia[0] ;
         A1645ConceptoConveCodigo = P003V7_A1645ConceptoConveCodigo[0] ;
         n1645ConceptoConveCodigo = P003V7_n1645ConceptoConveCodigo[0] ;
         A503ConTipoLiqAux = P003V7_A503ConTipoLiqAux[0] ;
         n503ConTipoLiqAux = P003V7_n503ConTipoLiqAux[0] ;
         A970ConClasifAux = P003V7_A970ConClasifAux[0] ;
         n970ConClasifAux = P003V7_n970ConClasifAux[0] ;
         A37TipoConCod = P003V7_A37TipoConCod[0] ;
         A41ConDescrip = P003V7_A41ConDescrip[0] ;
         A26ConCodigo = P003V7_A26ConCodigo[0] ;
         A160ConveDescri = P003V7_A160ConveDescri[0] ;
         n160ConveDescri = P003V7_n160ConveDescri[0] ;
         AV47count = 0 ;
         while ( (pr_default.getStatus(5) != 101) && ( GXutil.strcmp(P003V7_A153ConObservacion[0], A153ConObservacion) == 0 ) )
         {
            brk3V12 = false ;
            A3CliCod = P003V7_A3CliCod[0] ;
            A26ConCodigo = P003V7_A26ConCodigo[0] ;
            AV47count = (long)(AV47count+1) ;
            brk3V12 = true ;
            pr_default.readNext(5);
         }
         if ( ! (GXutil.strcmp("", A153ConObservacion)==0) )
         {
            AV39Option = A153ConObservacion ;
            AV40Options.add(AV39Option, 0);
            AV45OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV47count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV40Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3V12 )
         {
            brk3V12 = true ;
            pr_default.readNext(5);
         }
      }
      pr_default.close(5);
      new web.msgdebug(remoteHandle, context).execute( AV146Pgmname, "11") ;
   }

   public void S181( )
   {
      /* 'LOADCONCODAFIPOPTIONS' Routine */
      returnInSub = false ;
      AV110TFConCodAfip = AV35SearchTxt ;
      AV111TFConCodAfip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV149Conceptowwds_1_tfconcodigo = AV10TFConCodigo ;
      AV150Conceptowwds_2_tfconcodigo_sels = AV55TFConCodigo_Sels ;
      AV151Conceptowwds_3_tfcondescrip = AV12TFConDescrip ;
      AV152Conceptowwds_4_tfcondescrip_sels = AV57TFConDescrip_Sels ;
      AV153Conceptowwds_5_tftipoconcod_sels = AV70TFTipoConCod_Sels ;
      AV154Conceptowwds_6_tfconclasifaux = AV93TFConClasifAux ;
      AV155Conceptowwds_7_tfconclasifaux_sels = AV94TFConClasifAux_Sels ;
      AV156Conceptowwds_8_tfcontipoliqaux = AV84TFConTipoLiqAux ;
      AV157Conceptowwds_9_tfcontipoliqaux_sels = AV85TFConTipoLiqAux_Sels ;
      AV158Conceptowwds_10_tfconceptoconvecodigo = AV107TFConceptoConveCodigo ;
      AV159Conceptowwds_11_tfconceptoconvecodigo_sels = AV108TFConceptoConveCodigo_Sels ;
      AV160Conceptowwds_12_tfconvigencia_sels = AV22TFConVigencia_Sels ;
      AV161Conceptowwds_13_tfconvariable_sel = AV23TFConVariable_Sel ;
      AV162Conceptowwds_14_tfconformula = AV25TFConFormula ;
      AV163Conceptowwds_15_tfconhabilitado_sel = AV14TFConHabilitado_Sel ;
      AV164Conceptowwds_16_tfconobservacion = AV27TFConObservacion ;
      AV165Conceptowwds_17_tfconobservacion_sels = AV61TFConObservacion_Sels ;
      AV166Conceptowwds_18_tfapliigg_sels = AV101TFAplIIGG_Sels ;
      AV167Conceptowwds_19_tfconfchmodfor = AV33TFConFchModFor ;
      AV168Conceptowwds_20_tfconfchmodfor_to = AV34TFConFchModFor_To ;
      AV169Conceptowwds_21_tfconrecalcular_sel = AV89TFConRecalcular_Sel ;
      AV170Conceptowwds_22_tfconcondicion_sels = AV99TFConCondicion_Sels ;
      AV171Conceptowwds_23_tfconsacdeven_sels = AV105TFConSacDeven_Sels ;
      AV172Conceptowwds_24_tfconcodafip = AV110TFConCodAfip ;
      AV173Conceptowwds_25_tfconcodafip_sels = AV111TFConCodAfip_Sels ;
      AV174Conceptowwds_26_tfconbasepres_sels = AV115TFConBasePres_Sels ;
      AV175Conceptowwds_27_tfconbaseant_sels = AV117TFConBaseAnt_Sels ;
      AV176Conceptowwds_28_tfconbasefer_sels = AV119TFConBaseFer_Sels ;
      AV177Conceptowwds_29_tfconbaseferprom_sels = AV121TFConBaseFerProm_Sels ;
      AV178Conceptowwds_30_tfconbasehorext_sels = AV123TFConBaseHorExt_Sels ;
      AV179Conceptowwds_31_tfconbasehorextprom_sels = AV125TFConBaseHorExtProm_Sels ;
      AV180Conceptowwds_32_tfconbaselic_sels = AV127TFConBaseLic_Sels ;
      AV181Conceptowwds_33_tfconbaselicprom_sels = AV129TFConBaseLicProm_Sels ;
      AV182Conceptowwds_34_tfconbaseosdif_sels = AV131TFConBaseOSDif_Sels ;
      AV183Conceptowwds_35_tfconrelref = AV142TFConRelRef ;
      AV184Conceptowwds_36_tfconrelref_sels = AV143TFConRelRef_Sels ;
      pr_default.dynParam(6, new Object[]{ new Object[]{
                                           A26ConCodigo ,
                                           AV150Conceptowwds_2_tfconcodigo_sels ,
                                           A41ConDescrip ,
                                           AV152Conceptowwds_4_tfcondescrip_sels ,
                                           A37TipoConCod ,
                                           AV153Conceptowwds_5_tftipoconcod_sels ,
                                           A970ConClasifAux ,
                                           AV155Conceptowwds_7_tfconclasifaux_sels ,
                                           A503ConTipoLiqAux ,
                                           AV157Conceptowwds_9_tfcontipoliqaux_sels ,
                                           A1645ConceptoConveCodigo ,
                                           AV159Conceptowwds_11_tfconceptoconvecodigo_sels ,
                                           Byte.valueOf(A162ConVigencia) ,
                                           AV160Conceptowwds_12_tfconvigencia_sels ,
                                           A153ConObservacion ,
                                           AV165Conceptowwds_17_tfconobservacion_sels ,
                                           Short.valueOf(A1112AplIIGG) ,
                                           AV166Conceptowwds_18_tfapliigg_sels ,
                                           A953ConCondicion ,
                                           AV170Conceptowwds_22_tfconcondicion_sels ,
                                           Byte.valueOf(A1539ConSacDeven) ,
                                           AV171Conceptowwds_23_tfconsacdeven_sels ,
                                           A1648ConCodAfip ,
                                           AV173Conceptowwds_25_tfconcodafip_sels ,
                                           Byte.valueOf(A1800ConBasePres) ,
                                           AV174Conceptowwds_26_tfconbasepres_sels ,
                                           Byte.valueOf(A1801ConBaseAnt) ,
                                           AV175Conceptowwds_27_tfconbaseant_sels ,
                                           Byte.valueOf(A1621ConBaseFer) ,
                                           AV176Conceptowwds_28_tfconbasefer_sels ,
                                           Byte.valueOf(A1798ConBaseFerProm) ,
                                           AV177Conceptowwds_29_tfconbaseferprom_sels ,
                                           Byte.valueOf(A1622ConBaseHorExt) ,
                                           AV178Conceptowwds_30_tfconbasehorext_sels ,
                                           Byte.valueOf(A1799ConBaseHorExtProm) ,
                                           AV179Conceptowwds_31_tfconbasehorextprom_sels ,
                                           Byte.valueOf(A1620ConBaseLic) ,
                                           AV180Conceptowwds_32_tfconbaselic_sels ,
                                           Byte.valueOf(A1797ConBaseLicProm) ,
                                           AV181Conceptowwds_33_tfconbaselicprom_sels ,
                                           Byte.valueOf(A1827ConBaseOSDif) ,
                                           AV182Conceptowwds_34_tfconbaseosdif_sels ,
                                           A2013ConRelRef ,
                                           AV184Conceptowwds_36_tfconrelref_sels ,
                                           Integer.valueOf(AV150Conceptowwds_2_tfconcodigo_sels.size()) ,
                                           AV149Conceptowwds_1_tfconcodigo ,
                                           Integer.valueOf(AV152Conceptowwds_4_tfcondescrip_sels.size()) ,
                                           AV151Conceptowwds_3_tfcondescrip ,
                                           Integer.valueOf(AV153Conceptowwds_5_tftipoconcod_sels.size()) ,
                                           Integer.valueOf(AV155Conceptowwds_7_tfconclasifaux_sels.size()) ,
                                           AV154Conceptowwds_6_tfconclasifaux ,
                                           Integer.valueOf(AV157Conceptowwds_9_tfcontipoliqaux_sels.size()) ,
                                           AV156Conceptowwds_8_tfcontipoliqaux ,
                                           Integer.valueOf(AV159Conceptowwds_11_tfconceptoconvecodigo_sels.size()) ,
                                           AV158Conceptowwds_10_tfconceptoconvecodigo ,
                                           Integer.valueOf(AV160Conceptowwds_12_tfconvigencia_sels.size()) ,
                                           Byte.valueOf(AV161Conceptowwds_13_tfconvariable_sel) ,
                                           Byte.valueOf(AV163Conceptowwds_15_tfconhabilitado_sel) ,
                                           Integer.valueOf(AV165Conceptowwds_17_tfconobservacion_sels.size()) ,
                                           AV164Conceptowwds_16_tfconobservacion ,
                                           Integer.valueOf(AV166Conceptowwds_18_tfapliigg_sels.size()) ,
                                           AV167Conceptowwds_19_tfconfchmodfor ,
                                           AV168Conceptowwds_20_tfconfchmodfor_to ,
                                           Byte.valueOf(AV169Conceptowwds_21_tfconrecalcular_sel) ,
                                           Integer.valueOf(AV170Conceptowwds_22_tfconcondicion_sels.size()) ,
                                           Integer.valueOf(AV171Conceptowwds_23_tfconsacdeven_sels.size()) ,
                                           Integer.valueOf(AV173Conceptowwds_25_tfconcodafip_sels.size()) ,
                                           AV172Conceptowwds_24_tfconcodafip ,
                                           Integer.valueOf(AV174Conceptowwds_26_tfconbasepres_sels.size()) ,
                                           Integer.valueOf(AV175Conceptowwds_27_tfconbaseant_sels.size()) ,
                                           Integer.valueOf(AV176Conceptowwds_28_tfconbasefer_sels.size()) ,
                                           Integer.valueOf(AV177Conceptowwds_29_tfconbaseferprom_sels.size()) ,
                                           Integer.valueOf(AV178Conceptowwds_30_tfconbasehorext_sels.size()) ,
                                           Integer.valueOf(AV179Conceptowwds_31_tfconbasehorextprom_sels.size()) ,
                                           Integer.valueOf(AV180Conceptowwds_32_tfconbaselic_sels.size()) ,
                                           Integer.valueOf(AV181Conceptowwds_33_tfconbaselicprom_sels.size()) ,
                                           Integer.valueOf(AV182Conceptowwds_34_tfconbaseosdif_sels.size()) ,
                                           Integer.valueOf(AV184Conceptowwds_36_tfconrelref_sels.size()) ,
                                           AV183Conceptowwds_35_tfconrelref ,
                                           AV25TFConFormula ,
                                           A160ConveDescri ,
                                           Boolean.valueOf(A159ConVariable) ,
                                           Boolean.valueOf(A150ConHabilitado) ,
                                           A145ConFchModFor ,
                                           Boolean.valueOf(A762ConRecalcular) ,
                                           A148ConFormula ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV64CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV149Conceptowwds_1_tfconcodigo = GXutil.padr( GXutil.rtrim( AV149Conceptowwds_1_tfconcodigo), 10, "%") ;
      lV151Conceptowwds_3_tfcondescrip = GXutil.concat( GXutil.rtrim( AV151Conceptowwds_3_tfcondescrip), "%", "") ;
      lV154Conceptowwds_6_tfconclasifaux = GXutil.concat( GXutil.rtrim( AV154Conceptowwds_6_tfconclasifaux), "%", "") ;
      lV156Conceptowwds_8_tfcontipoliqaux = GXutil.concat( GXutil.rtrim( AV156Conceptowwds_8_tfcontipoliqaux), "%", "") ;
      lV158Conceptowwds_10_tfconceptoconvecodigo = GXutil.concat( GXutil.rtrim( AV158Conceptowwds_10_tfconceptoconvecodigo), "%", "") ;
      lV164Conceptowwds_16_tfconobservacion = GXutil.concat( GXutil.rtrim( AV164Conceptowwds_16_tfconobservacion), "%", "") ;
      lV172Conceptowwds_24_tfconcodafip = GXutil.padr( GXutil.rtrim( AV172Conceptowwds_24_tfconcodafip), 6, "%") ;
      lV183Conceptowwds_35_tfconrelref = GXutil.concat( GXutil.rtrim( AV183Conceptowwds_35_tfconrelref), "%", "") ;
      lV25TFConFormula = GXutil.concat( GXutil.rtrim( AV25TFConFormula), "%", "") ;
      /* Using cursor P003V8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(AV64CliCod), lV149Conceptowwds_1_tfconcodigo, lV151Conceptowwds_3_tfcondescrip, lV154Conceptowwds_6_tfconclasifaux, lV156Conceptowwds_8_tfcontipoliqaux, lV158Conceptowwds_10_tfconceptoconvecodigo, lV164Conceptowwds_16_tfconobservacion, AV167Conceptowwds_19_tfconfchmodfor, AV168Conceptowwds_20_tfconfchmodfor_to, lV172Conceptowwds_24_tfconcodafip, lV183Conceptowwds_35_tfconrelref, lV25TFConFormula});
      while ( (pr_default.getStatus(6) != 101) )
      {
         brk3V14 = false ;
         A1644ConceptoPais = P003V8_A1644ConceptoPais[0] ;
         n1644ConceptoPais = P003V8_n1644ConceptoPais[0] ;
         A3CliCod = P003V8_A3CliCod[0] ;
         A1648ConCodAfip = P003V8_A1648ConCodAfip[0] ;
         A148ConFormula = P003V8_A148ConFormula[0] ;
         n148ConFormula = P003V8_n148ConFormula[0] ;
         A160ConveDescri = P003V8_A160ConveDescri[0] ;
         n160ConveDescri = P003V8_n160ConveDescri[0] ;
         A2013ConRelRef = P003V8_A2013ConRelRef[0] ;
         A1827ConBaseOSDif = P003V8_A1827ConBaseOSDif[0] ;
         A1797ConBaseLicProm = P003V8_A1797ConBaseLicProm[0] ;
         A1620ConBaseLic = P003V8_A1620ConBaseLic[0] ;
         A1799ConBaseHorExtProm = P003V8_A1799ConBaseHorExtProm[0] ;
         A1622ConBaseHorExt = P003V8_A1622ConBaseHorExt[0] ;
         A1798ConBaseFerProm = P003V8_A1798ConBaseFerProm[0] ;
         A1621ConBaseFer = P003V8_A1621ConBaseFer[0] ;
         A1801ConBaseAnt = P003V8_A1801ConBaseAnt[0] ;
         A1800ConBasePres = P003V8_A1800ConBasePres[0] ;
         A1539ConSacDeven = P003V8_A1539ConSacDeven[0] ;
         A953ConCondicion = P003V8_A953ConCondicion[0] ;
         n953ConCondicion = P003V8_n953ConCondicion[0] ;
         A762ConRecalcular = P003V8_A762ConRecalcular[0] ;
         A145ConFchModFor = P003V8_A145ConFchModFor[0] ;
         n145ConFchModFor = P003V8_n145ConFchModFor[0] ;
         A1112AplIIGG = P003V8_A1112AplIIGG[0] ;
         n1112AplIIGG = P003V8_n1112AplIIGG[0] ;
         A153ConObservacion = P003V8_A153ConObservacion[0] ;
         A150ConHabilitado = P003V8_A150ConHabilitado[0] ;
         A159ConVariable = P003V8_A159ConVariable[0] ;
         A162ConVigencia = P003V8_A162ConVigencia[0] ;
         A1645ConceptoConveCodigo = P003V8_A1645ConceptoConveCodigo[0] ;
         n1645ConceptoConveCodigo = P003V8_n1645ConceptoConveCodigo[0] ;
         A503ConTipoLiqAux = P003V8_A503ConTipoLiqAux[0] ;
         n503ConTipoLiqAux = P003V8_n503ConTipoLiqAux[0] ;
         A970ConClasifAux = P003V8_A970ConClasifAux[0] ;
         n970ConClasifAux = P003V8_n970ConClasifAux[0] ;
         A37TipoConCod = P003V8_A37TipoConCod[0] ;
         A41ConDescrip = P003V8_A41ConDescrip[0] ;
         A26ConCodigo = P003V8_A26ConCodigo[0] ;
         A160ConveDescri = P003V8_A160ConveDescri[0] ;
         n160ConveDescri = P003V8_n160ConveDescri[0] ;
         AV47count = 0 ;
         while ( (pr_default.getStatus(6) != 101) && ( GXutil.strcmp(P003V8_A1648ConCodAfip[0], A1648ConCodAfip) == 0 ) )
         {
            brk3V14 = false ;
            A3CliCod = P003V8_A3CliCod[0] ;
            A26ConCodigo = P003V8_A26ConCodigo[0] ;
            AV47count = (long)(AV47count+1) ;
            brk3V14 = true ;
            pr_default.readNext(6);
         }
         if ( ! (GXutil.strcmp("", A1648ConCodAfip)==0) )
         {
            AV39Option = A1648ConCodAfip ;
            AV40Options.add(AV39Option, 0);
            AV45OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV47count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV40Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3V14 )
         {
            brk3V14 = true ;
            pr_default.readNext(6);
         }
      }
      pr_default.close(6);
   }

   public void S191( )
   {
      /* 'LOADCONRELREFOPTIONS' Routine */
      returnInSub = false ;
      AV142TFConRelRef = AV35SearchTxt ;
      AV143TFConRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV149Conceptowwds_1_tfconcodigo = AV10TFConCodigo ;
      AV150Conceptowwds_2_tfconcodigo_sels = AV55TFConCodigo_Sels ;
      AV151Conceptowwds_3_tfcondescrip = AV12TFConDescrip ;
      AV152Conceptowwds_4_tfcondescrip_sels = AV57TFConDescrip_Sels ;
      AV153Conceptowwds_5_tftipoconcod_sels = AV70TFTipoConCod_Sels ;
      AV154Conceptowwds_6_tfconclasifaux = AV93TFConClasifAux ;
      AV155Conceptowwds_7_tfconclasifaux_sels = AV94TFConClasifAux_Sels ;
      AV156Conceptowwds_8_tfcontipoliqaux = AV84TFConTipoLiqAux ;
      AV157Conceptowwds_9_tfcontipoliqaux_sels = AV85TFConTipoLiqAux_Sels ;
      AV158Conceptowwds_10_tfconceptoconvecodigo = AV107TFConceptoConveCodigo ;
      AV159Conceptowwds_11_tfconceptoconvecodigo_sels = AV108TFConceptoConveCodigo_Sels ;
      AV160Conceptowwds_12_tfconvigencia_sels = AV22TFConVigencia_Sels ;
      AV161Conceptowwds_13_tfconvariable_sel = AV23TFConVariable_Sel ;
      AV162Conceptowwds_14_tfconformula = AV25TFConFormula ;
      AV163Conceptowwds_15_tfconhabilitado_sel = AV14TFConHabilitado_Sel ;
      AV164Conceptowwds_16_tfconobservacion = AV27TFConObservacion ;
      AV165Conceptowwds_17_tfconobservacion_sels = AV61TFConObservacion_Sels ;
      AV166Conceptowwds_18_tfapliigg_sels = AV101TFAplIIGG_Sels ;
      AV167Conceptowwds_19_tfconfchmodfor = AV33TFConFchModFor ;
      AV168Conceptowwds_20_tfconfchmodfor_to = AV34TFConFchModFor_To ;
      AV169Conceptowwds_21_tfconrecalcular_sel = AV89TFConRecalcular_Sel ;
      AV170Conceptowwds_22_tfconcondicion_sels = AV99TFConCondicion_Sels ;
      AV171Conceptowwds_23_tfconsacdeven_sels = AV105TFConSacDeven_Sels ;
      AV172Conceptowwds_24_tfconcodafip = AV110TFConCodAfip ;
      AV173Conceptowwds_25_tfconcodafip_sels = AV111TFConCodAfip_Sels ;
      AV174Conceptowwds_26_tfconbasepres_sels = AV115TFConBasePres_Sels ;
      AV175Conceptowwds_27_tfconbaseant_sels = AV117TFConBaseAnt_Sels ;
      AV176Conceptowwds_28_tfconbasefer_sels = AV119TFConBaseFer_Sels ;
      AV177Conceptowwds_29_tfconbaseferprom_sels = AV121TFConBaseFerProm_Sels ;
      AV178Conceptowwds_30_tfconbasehorext_sels = AV123TFConBaseHorExt_Sels ;
      AV179Conceptowwds_31_tfconbasehorextprom_sels = AV125TFConBaseHorExtProm_Sels ;
      AV180Conceptowwds_32_tfconbaselic_sels = AV127TFConBaseLic_Sels ;
      AV181Conceptowwds_33_tfconbaselicprom_sels = AV129TFConBaseLicProm_Sels ;
      AV182Conceptowwds_34_tfconbaseosdif_sels = AV131TFConBaseOSDif_Sels ;
      AV183Conceptowwds_35_tfconrelref = AV142TFConRelRef ;
      AV184Conceptowwds_36_tfconrelref_sels = AV143TFConRelRef_Sels ;
      pr_default.dynParam(7, new Object[]{ new Object[]{
                                           A26ConCodigo ,
                                           AV150Conceptowwds_2_tfconcodigo_sels ,
                                           A41ConDescrip ,
                                           AV152Conceptowwds_4_tfcondescrip_sels ,
                                           A37TipoConCod ,
                                           AV153Conceptowwds_5_tftipoconcod_sels ,
                                           A970ConClasifAux ,
                                           AV155Conceptowwds_7_tfconclasifaux_sels ,
                                           A503ConTipoLiqAux ,
                                           AV157Conceptowwds_9_tfcontipoliqaux_sels ,
                                           A1645ConceptoConveCodigo ,
                                           AV159Conceptowwds_11_tfconceptoconvecodigo_sels ,
                                           Byte.valueOf(A162ConVigencia) ,
                                           AV160Conceptowwds_12_tfconvigencia_sels ,
                                           A153ConObservacion ,
                                           AV165Conceptowwds_17_tfconobservacion_sels ,
                                           Short.valueOf(A1112AplIIGG) ,
                                           AV166Conceptowwds_18_tfapliigg_sels ,
                                           A953ConCondicion ,
                                           AV170Conceptowwds_22_tfconcondicion_sels ,
                                           Byte.valueOf(A1539ConSacDeven) ,
                                           AV171Conceptowwds_23_tfconsacdeven_sels ,
                                           A1648ConCodAfip ,
                                           AV173Conceptowwds_25_tfconcodafip_sels ,
                                           Byte.valueOf(A1800ConBasePres) ,
                                           AV174Conceptowwds_26_tfconbasepres_sels ,
                                           Byte.valueOf(A1801ConBaseAnt) ,
                                           AV175Conceptowwds_27_tfconbaseant_sels ,
                                           Byte.valueOf(A1621ConBaseFer) ,
                                           AV176Conceptowwds_28_tfconbasefer_sels ,
                                           Byte.valueOf(A1798ConBaseFerProm) ,
                                           AV177Conceptowwds_29_tfconbaseferprom_sels ,
                                           Byte.valueOf(A1622ConBaseHorExt) ,
                                           AV178Conceptowwds_30_tfconbasehorext_sels ,
                                           Byte.valueOf(A1799ConBaseHorExtProm) ,
                                           AV179Conceptowwds_31_tfconbasehorextprom_sels ,
                                           Byte.valueOf(A1620ConBaseLic) ,
                                           AV180Conceptowwds_32_tfconbaselic_sels ,
                                           Byte.valueOf(A1797ConBaseLicProm) ,
                                           AV181Conceptowwds_33_tfconbaselicprom_sels ,
                                           Byte.valueOf(A1827ConBaseOSDif) ,
                                           AV182Conceptowwds_34_tfconbaseosdif_sels ,
                                           A2013ConRelRef ,
                                           AV184Conceptowwds_36_tfconrelref_sels ,
                                           Integer.valueOf(AV150Conceptowwds_2_tfconcodigo_sels.size()) ,
                                           AV149Conceptowwds_1_tfconcodigo ,
                                           Integer.valueOf(AV152Conceptowwds_4_tfcondescrip_sels.size()) ,
                                           AV151Conceptowwds_3_tfcondescrip ,
                                           Integer.valueOf(AV153Conceptowwds_5_tftipoconcod_sels.size()) ,
                                           Integer.valueOf(AV155Conceptowwds_7_tfconclasifaux_sels.size()) ,
                                           AV154Conceptowwds_6_tfconclasifaux ,
                                           Integer.valueOf(AV157Conceptowwds_9_tfcontipoliqaux_sels.size()) ,
                                           AV156Conceptowwds_8_tfcontipoliqaux ,
                                           Integer.valueOf(AV159Conceptowwds_11_tfconceptoconvecodigo_sels.size()) ,
                                           AV158Conceptowwds_10_tfconceptoconvecodigo ,
                                           Integer.valueOf(AV160Conceptowwds_12_tfconvigencia_sels.size()) ,
                                           Byte.valueOf(AV161Conceptowwds_13_tfconvariable_sel) ,
                                           Byte.valueOf(AV163Conceptowwds_15_tfconhabilitado_sel) ,
                                           Integer.valueOf(AV165Conceptowwds_17_tfconobservacion_sels.size()) ,
                                           AV164Conceptowwds_16_tfconobservacion ,
                                           Integer.valueOf(AV166Conceptowwds_18_tfapliigg_sels.size()) ,
                                           AV167Conceptowwds_19_tfconfchmodfor ,
                                           AV168Conceptowwds_20_tfconfchmodfor_to ,
                                           Byte.valueOf(AV169Conceptowwds_21_tfconrecalcular_sel) ,
                                           Integer.valueOf(AV170Conceptowwds_22_tfconcondicion_sels.size()) ,
                                           Integer.valueOf(AV171Conceptowwds_23_tfconsacdeven_sels.size()) ,
                                           Integer.valueOf(AV173Conceptowwds_25_tfconcodafip_sels.size()) ,
                                           AV172Conceptowwds_24_tfconcodafip ,
                                           Integer.valueOf(AV174Conceptowwds_26_tfconbasepres_sels.size()) ,
                                           Integer.valueOf(AV175Conceptowwds_27_tfconbaseant_sels.size()) ,
                                           Integer.valueOf(AV176Conceptowwds_28_tfconbasefer_sels.size()) ,
                                           Integer.valueOf(AV177Conceptowwds_29_tfconbaseferprom_sels.size()) ,
                                           Integer.valueOf(AV178Conceptowwds_30_tfconbasehorext_sels.size()) ,
                                           Integer.valueOf(AV179Conceptowwds_31_tfconbasehorextprom_sels.size()) ,
                                           Integer.valueOf(AV180Conceptowwds_32_tfconbaselic_sels.size()) ,
                                           Integer.valueOf(AV181Conceptowwds_33_tfconbaselicprom_sels.size()) ,
                                           Integer.valueOf(AV182Conceptowwds_34_tfconbaseosdif_sels.size()) ,
                                           Integer.valueOf(AV184Conceptowwds_36_tfconrelref_sels.size()) ,
                                           AV183Conceptowwds_35_tfconrelref ,
                                           AV25TFConFormula ,
                                           A160ConveDescri ,
                                           Boolean.valueOf(A159ConVariable) ,
                                           Boolean.valueOf(A150ConHabilitado) ,
                                           A145ConFchModFor ,
                                           Boolean.valueOf(A762ConRecalcular) ,
                                           A148ConFormula ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV64CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV149Conceptowwds_1_tfconcodigo = GXutil.padr( GXutil.rtrim( AV149Conceptowwds_1_tfconcodigo), 10, "%") ;
      lV151Conceptowwds_3_tfcondescrip = GXutil.concat( GXutil.rtrim( AV151Conceptowwds_3_tfcondescrip), "%", "") ;
      lV154Conceptowwds_6_tfconclasifaux = GXutil.concat( GXutil.rtrim( AV154Conceptowwds_6_tfconclasifaux), "%", "") ;
      lV156Conceptowwds_8_tfcontipoliqaux = GXutil.concat( GXutil.rtrim( AV156Conceptowwds_8_tfcontipoliqaux), "%", "") ;
      lV158Conceptowwds_10_tfconceptoconvecodigo = GXutil.concat( GXutil.rtrim( AV158Conceptowwds_10_tfconceptoconvecodigo), "%", "") ;
      lV164Conceptowwds_16_tfconobservacion = GXutil.concat( GXutil.rtrim( AV164Conceptowwds_16_tfconobservacion), "%", "") ;
      lV172Conceptowwds_24_tfconcodafip = GXutil.padr( GXutil.rtrim( AV172Conceptowwds_24_tfconcodafip), 6, "%") ;
      lV183Conceptowwds_35_tfconrelref = GXutil.concat( GXutil.rtrim( AV183Conceptowwds_35_tfconrelref), "%", "") ;
      lV25TFConFormula = GXutil.concat( GXutil.rtrim( AV25TFConFormula), "%", "") ;
      /* Using cursor P003V9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(AV64CliCod), lV149Conceptowwds_1_tfconcodigo, lV151Conceptowwds_3_tfcondescrip, lV154Conceptowwds_6_tfconclasifaux, lV156Conceptowwds_8_tfcontipoliqaux, lV158Conceptowwds_10_tfconceptoconvecodigo, lV164Conceptowwds_16_tfconobservacion, AV167Conceptowwds_19_tfconfchmodfor, AV168Conceptowwds_20_tfconfchmodfor_to, lV172Conceptowwds_24_tfconcodafip, lV183Conceptowwds_35_tfconrelref, lV25TFConFormula});
      while ( (pr_default.getStatus(7) != 101) )
      {
         brk3V16 = false ;
         A1644ConceptoPais = P003V9_A1644ConceptoPais[0] ;
         n1644ConceptoPais = P003V9_n1644ConceptoPais[0] ;
         A3CliCod = P003V9_A3CliCod[0] ;
         A2013ConRelRef = P003V9_A2013ConRelRef[0] ;
         A148ConFormula = P003V9_A148ConFormula[0] ;
         n148ConFormula = P003V9_n148ConFormula[0] ;
         A160ConveDescri = P003V9_A160ConveDescri[0] ;
         n160ConveDescri = P003V9_n160ConveDescri[0] ;
         A1827ConBaseOSDif = P003V9_A1827ConBaseOSDif[0] ;
         A1797ConBaseLicProm = P003V9_A1797ConBaseLicProm[0] ;
         A1620ConBaseLic = P003V9_A1620ConBaseLic[0] ;
         A1799ConBaseHorExtProm = P003V9_A1799ConBaseHorExtProm[0] ;
         A1622ConBaseHorExt = P003V9_A1622ConBaseHorExt[0] ;
         A1798ConBaseFerProm = P003V9_A1798ConBaseFerProm[0] ;
         A1621ConBaseFer = P003V9_A1621ConBaseFer[0] ;
         A1801ConBaseAnt = P003V9_A1801ConBaseAnt[0] ;
         A1800ConBasePres = P003V9_A1800ConBasePres[0] ;
         A1648ConCodAfip = P003V9_A1648ConCodAfip[0] ;
         A1539ConSacDeven = P003V9_A1539ConSacDeven[0] ;
         A953ConCondicion = P003V9_A953ConCondicion[0] ;
         n953ConCondicion = P003V9_n953ConCondicion[0] ;
         A762ConRecalcular = P003V9_A762ConRecalcular[0] ;
         A145ConFchModFor = P003V9_A145ConFchModFor[0] ;
         n145ConFchModFor = P003V9_n145ConFchModFor[0] ;
         A1112AplIIGG = P003V9_A1112AplIIGG[0] ;
         n1112AplIIGG = P003V9_n1112AplIIGG[0] ;
         A153ConObservacion = P003V9_A153ConObservacion[0] ;
         A150ConHabilitado = P003V9_A150ConHabilitado[0] ;
         A159ConVariable = P003V9_A159ConVariable[0] ;
         A162ConVigencia = P003V9_A162ConVigencia[0] ;
         A1645ConceptoConveCodigo = P003V9_A1645ConceptoConveCodigo[0] ;
         n1645ConceptoConveCodigo = P003V9_n1645ConceptoConveCodigo[0] ;
         A503ConTipoLiqAux = P003V9_A503ConTipoLiqAux[0] ;
         n503ConTipoLiqAux = P003V9_n503ConTipoLiqAux[0] ;
         A970ConClasifAux = P003V9_A970ConClasifAux[0] ;
         n970ConClasifAux = P003V9_n970ConClasifAux[0] ;
         A37TipoConCod = P003V9_A37TipoConCod[0] ;
         A41ConDescrip = P003V9_A41ConDescrip[0] ;
         A26ConCodigo = P003V9_A26ConCodigo[0] ;
         A160ConveDescri = P003V9_A160ConveDescri[0] ;
         n160ConveDescri = P003V9_n160ConveDescri[0] ;
         AV47count = 0 ;
         while ( (pr_default.getStatus(7) != 101) && ( GXutil.strcmp(P003V9_A2013ConRelRef[0], A2013ConRelRef) == 0 ) )
         {
            brk3V16 = false ;
            A3CliCod = P003V9_A3CliCod[0] ;
            A26ConCodigo = P003V9_A26ConCodigo[0] ;
            AV47count = (long)(AV47count+1) ;
            brk3V16 = true ;
            pr_default.readNext(7);
         }
         if ( ! (GXutil.strcmp("", A2013ConRelRef)==0) )
         {
            AV39Option = A2013ConRelRef ;
            AV40Options.add(AV39Option, 0);
            AV45OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV47count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV40Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3V16 )
         {
            brk3V16 = true ;
            pr_default.readNext(7);
         }
      }
      pr_default.close(7);
   }

   public void S201( )
   {
      /* 'LOADCONFORMULAOPTIONS' Routine */
      returnInSub = false ;
      new web.msgdebug(remoteHandle, context).execute( AV146Pgmname, "8") ;
      new web.msgdebug(remoteHandle, context).execute( AV146Pgmname, "9") ;
   }

   protected void cleanup( )
   {
      this.aP3[0] = conceptowwgetfilterdata.this.AV41OptionsJson;
      this.aP4[0] = conceptowwgetfilterdata.this.AV44OptionsDescJson;
      this.aP5[0] = conceptowwgetfilterdata.this.AV46OptionIndexesJson;
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
      AV44OptionsDescJson = "" ;
      AV46OptionIndexesJson = "" ;
      AV146Pgmname = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV40Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV45OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV48Session = httpContext.getWebSession();
      AV50GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV51GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV10TFConCodigo = "" ;
      AV54TFConCodigo_SelsJson = "" ;
      AV55TFConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV12TFConDescrip = "" ;
      AV56TFConDescrip_SelsJson = "" ;
      AV57TFConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV69TFTipoConCod_SelsJson = "" ;
      AV70TFTipoConCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV93TFConClasifAux = "" ;
      AV92TFConClasifAux_SelsJson = "" ;
      AV94TFConClasifAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV84TFConTipoLiqAux = "" ;
      AV83TFConTipoLiqAux_SelsJson = "" ;
      AV85TFConTipoLiqAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV107TFConceptoConveCodigo = "" ;
      AV106TFConceptoConveCodigo_SelsJson = "" ;
      AV108TFConceptoConveCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV21TFConVigencia_SelsJson = "" ;
      AV22TFConVigencia_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV25TFConFormula = "" ;
      AV27TFConObservacion = "" ;
      AV60TFConObservacion_SelsJson = "" ;
      AV61TFConObservacion_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV100TFAplIIGG_SelsJson = "" ;
      AV101TFAplIIGG_Sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV33TFConFchModFor = GXutil.resetTime( GXutil.nullDate() );
      AV34TFConFchModFor_To = GXutil.resetTime( GXutil.nullDate() );
      AV98TFConCondicion_SelsJson = "" ;
      AV99TFConCondicion_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV104TFConSacDeven_SelsJson = "" ;
      AV105TFConSacDeven_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV110TFConCodAfip = "" ;
      AV109TFConCodAfip_SelsJson = "" ;
      AV111TFConCodAfip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV114TFConBasePres_SelsJson = "" ;
      AV115TFConBasePres_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV116TFConBaseAnt_SelsJson = "" ;
      AV117TFConBaseAnt_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV118TFConBaseFer_SelsJson = "" ;
      AV119TFConBaseFer_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV120TFConBaseFerProm_SelsJson = "" ;
      AV121TFConBaseFerProm_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV122TFConBaseHorExt_SelsJson = "" ;
      AV123TFConBaseHorExt_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV124TFConBaseHorExtProm_SelsJson = "" ;
      AV125TFConBaseHorExtProm_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV126TFConBaseLic_SelsJson = "" ;
      AV127TFConBaseLic_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV128TFConBaseLicProm_SelsJson = "" ;
      AV129TFConBaseLicProm_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV130TFConBaseOSDif_SelsJson = "" ;
      AV131TFConBaseOSDif_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV142TFConRelRef = "" ;
      AV141TFConRelRef_SelsJson = "" ;
      AV143TFConRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV140MenuOpcCod = "" ;
      A26ConCodigo = "" ;
      AV149Conceptowwds_1_tfconcodigo = "" ;
      AV150Conceptowwds_2_tfconcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV151Conceptowwds_3_tfcondescrip = "" ;
      AV152Conceptowwds_4_tfcondescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV153Conceptowwds_5_tftipoconcod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV154Conceptowwds_6_tfconclasifaux = "" ;
      AV155Conceptowwds_7_tfconclasifaux_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV156Conceptowwds_8_tfcontipoliqaux = "" ;
      AV157Conceptowwds_9_tfcontipoliqaux_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV158Conceptowwds_10_tfconceptoconvecodigo = "" ;
      AV159Conceptowwds_11_tfconceptoconvecodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV160Conceptowwds_12_tfconvigencia_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV162Conceptowwds_14_tfconformula = "" ;
      AV164Conceptowwds_16_tfconobservacion = "" ;
      AV165Conceptowwds_17_tfconobservacion_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV166Conceptowwds_18_tfapliigg_sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV167Conceptowwds_19_tfconfchmodfor = GXutil.resetTime( GXutil.nullDate() );
      AV168Conceptowwds_20_tfconfchmodfor_to = GXutil.resetTime( GXutil.nullDate() );
      AV170Conceptowwds_22_tfconcondicion_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV171Conceptowwds_23_tfconsacdeven_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV172Conceptowwds_24_tfconcodafip = "" ;
      AV173Conceptowwds_25_tfconcodafip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV174Conceptowwds_26_tfconbasepres_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV175Conceptowwds_27_tfconbaseant_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV176Conceptowwds_28_tfconbasefer_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV177Conceptowwds_29_tfconbaseferprom_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV178Conceptowwds_30_tfconbasehorext_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV179Conceptowwds_31_tfconbasehorextprom_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV180Conceptowwds_32_tfconbaselic_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV181Conceptowwds_33_tfconbaselicprom_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV182Conceptowwds_34_tfconbaseosdif_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV183Conceptowwds_35_tfconrelref = "" ;
      AV184Conceptowwds_36_tfconrelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV149Conceptowwds_1_tfconcodigo = "" ;
      lV151Conceptowwds_3_tfcondescrip = "" ;
      lV154Conceptowwds_6_tfconclasifaux = "" ;
      lV156Conceptowwds_8_tfcontipoliqaux = "" ;
      lV158Conceptowwds_10_tfconceptoconvecodigo = "" ;
      lV164Conceptowwds_16_tfconobservacion = "" ;
      lV172Conceptowwds_24_tfconcodafip = "" ;
      lV183Conceptowwds_35_tfconrelref = "" ;
      lV25TFConFormula = "" ;
      A41ConDescrip = "" ;
      A37TipoConCod = "" ;
      A970ConClasifAux = "" ;
      A503ConTipoLiqAux = "" ;
      A1645ConceptoConveCodigo = "" ;
      A153ConObservacion = "" ;
      A953ConCondicion = "" ;
      A1648ConCodAfip = "" ;
      A2013ConRelRef = "" ;
      A160ConveDescri = "" ;
      A145ConFchModFor = GXutil.resetTime( GXutil.nullDate() );
      A148ConFormula = "" ;
      P003V2_A1644ConceptoPais = new short[1] ;
      P003V2_n1644ConceptoPais = new boolean[] {false} ;
      P003V2_A3CliCod = new int[1] ;
      P003V2_A26ConCodigo = new String[] {""} ;
      P003V2_A148ConFormula = new String[] {""} ;
      P003V2_n148ConFormula = new boolean[] {false} ;
      P003V2_A160ConveDescri = new String[] {""} ;
      P003V2_n160ConveDescri = new boolean[] {false} ;
      P003V2_A2013ConRelRef = new String[] {""} ;
      P003V2_A1827ConBaseOSDif = new byte[1] ;
      P003V2_A1797ConBaseLicProm = new byte[1] ;
      P003V2_A1620ConBaseLic = new byte[1] ;
      P003V2_A1799ConBaseHorExtProm = new byte[1] ;
      P003V2_A1622ConBaseHorExt = new byte[1] ;
      P003V2_A1798ConBaseFerProm = new byte[1] ;
      P003V2_A1621ConBaseFer = new byte[1] ;
      P003V2_A1801ConBaseAnt = new byte[1] ;
      P003V2_A1800ConBasePres = new byte[1] ;
      P003V2_A1648ConCodAfip = new String[] {""} ;
      P003V2_A1539ConSacDeven = new byte[1] ;
      P003V2_A953ConCondicion = new String[] {""} ;
      P003V2_n953ConCondicion = new boolean[] {false} ;
      P003V2_A762ConRecalcular = new boolean[] {false} ;
      P003V2_A145ConFchModFor = new java.util.Date[] {GXutil.nullDate()} ;
      P003V2_n145ConFchModFor = new boolean[] {false} ;
      P003V2_A1112AplIIGG = new short[1] ;
      P003V2_n1112AplIIGG = new boolean[] {false} ;
      P003V2_A153ConObservacion = new String[] {""} ;
      P003V2_A150ConHabilitado = new boolean[] {false} ;
      P003V2_A159ConVariable = new boolean[] {false} ;
      P003V2_A162ConVigencia = new byte[1] ;
      P003V2_A1645ConceptoConveCodigo = new String[] {""} ;
      P003V2_n1645ConceptoConveCodigo = new boolean[] {false} ;
      P003V2_A503ConTipoLiqAux = new String[] {""} ;
      P003V2_n503ConTipoLiqAux = new boolean[] {false} ;
      P003V2_A970ConClasifAux = new String[] {""} ;
      P003V2_n970ConClasifAux = new boolean[] {false} ;
      P003V2_A37TipoConCod = new String[] {""} ;
      P003V2_A41ConDescrip = new String[] {""} ;
      AV39Option = "" ;
      AV42OptionDesc = "" ;
      P003V3_A1644ConceptoPais = new short[1] ;
      P003V3_n1644ConceptoPais = new boolean[] {false} ;
      P003V3_A3CliCod = new int[1] ;
      P003V3_A41ConDescrip = new String[] {""} ;
      P003V3_A148ConFormula = new String[] {""} ;
      P003V3_n148ConFormula = new boolean[] {false} ;
      P003V3_A160ConveDescri = new String[] {""} ;
      P003V3_n160ConveDescri = new boolean[] {false} ;
      P003V3_A2013ConRelRef = new String[] {""} ;
      P003V3_A1827ConBaseOSDif = new byte[1] ;
      P003V3_A1797ConBaseLicProm = new byte[1] ;
      P003V3_A1620ConBaseLic = new byte[1] ;
      P003V3_A1799ConBaseHorExtProm = new byte[1] ;
      P003V3_A1622ConBaseHorExt = new byte[1] ;
      P003V3_A1798ConBaseFerProm = new byte[1] ;
      P003V3_A1621ConBaseFer = new byte[1] ;
      P003V3_A1801ConBaseAnt = new byte[1] ;
      P003V3_A1800ConBasePres = new byte[1] ;
      P003V3_A1648ConCodAfip = new String[] {""} ;
      P003V3_A1539ConSacDeven = new byte[1] ;
      P003V3_A953ConCondicion = new String[] {""} ;
      P003V3_n953ConCondicion = new boolean[] {false} ;
      P003V3_A762ConRecalcular = new boolean[] {false} ;
      P003V3_A145ConFchModFor = new java.util.Date[] {GXutil.nullDate()} ;
      P003V3_n145ConFchModFor = new boolean[] {false} ;
      P003V3_A1112AplIIGG = new short[1] ;
      P003V3_n1112AplIIGG = new boolean[] {false} ;
      P003V3_A153ConObservacion = new String[] {""} ;
      P003V3_A150ConHabilitado = new boolean[] {false} ;
      P003V3_A159ConVariable = new boolean[] {false} ;
      P003V3_A162ConVigencia = new byte[1] ;
      P003V3_A1645ConceptoConveCodigo = new String[] {""} ;
      P003V3_n1645ConceptoConveCodigo = new boolean[] {false} ;
      P003V3_A503ConTipoLiqAux = new String[] {""} ;
      P003V3_n503ConTipoLiqAux = new boolean[] {false} ;
      P003V3_A970ConClasifAux = new String[] {""} ;
      P003V3_n970ConClasifAux = new boolean[] {false} ;
      P003V3_A37TipoConCod = new String[] {""} ;
      P003V3_A26ConCodigo = new String[] {""} ;
      P003V4_A1644ConceptoPais = new short[1] ;
      P003V4_n1644ConceptoPais = new boolean[] {false} ;
      P003V4_A3CliCod = new int[1] ;
      P003V4_A970ConClasifAux = new String[] {""} ;
      P003V4_n970ConClasifAux = new boolean[] {false} ;
      P003V4_A148ConFormula = new String[] {""} ;
      P003V4_n148ConFormula = new boolean[] {false} ;
      P003V4_A160ConveDescri = new String[] {""} ;
      P003V4_n160ConveDescri = new boolean[] {false} ;
      P003V4_A2013ConRelRef = new String[] {""} ;
      P003V4_A1827ConBaseOSDif = new byte[1] ;
      P003V4_A1797ConBaseLicProm = new byte[1] ;
      P003V4_A1620ConBaseLic = new byte[1] ;
      P003V4_A1799ConBaseHorExtProm = new byte[1] ;
      P003V4_A1622ConBaseHorExt = new byte[1] ;
      P003V4_A1798ConBaseFerProm = new byte[1] ;
      P003V4_A1621ConBaseFer = new byte[1] ;
      P003V4_A1801ConBaseAnt = new byte[1] ;
      P003V4_A1800ConBasePres = new byte[1] ;
      P003V4_A1648ConCodAfip = new String[] {""} ;
      P003V4_A1539ConSacDeven = new byte[1] ;
      P003V4_A953ConCondicion = new String[] {""} ;
      P003V4_n953ConCondicion = new boolean[] {false} ;
      P003V4_A762ConRecalcular = new boolean[] {false} ;
      P003V4_A145ConFchModFor = new java.util.Date[] {GXutil.nullDate()} ;
      P003V4_n145ConFchModFor = new boolean[] {false} ;
      P003V4_A1112AplIIGG = new short[1] ;
      P003V4_n1112AplIIGG = new boolean[] {false} ;
      P003V4_A153ConObservacion = new String[] {""} ;
      P003V4_A150ConHabilitado = new boolean[] {false} ;
      P003V4_A159ConVariable = new boolean[] {false} ;
      P003V4_A162ConVigencia = new byte[1] ;
      P003V4_A1645ConceptoConveCodigo = new String[] {""} ;
      P003V4_n1645ConceptoConveCodigo = new boolean[] {false} ;
      P003V4_A503ConTipoLiqAux = new String[] {""} ;
      P003V4_n503ConTipoLiqAux = new boolean[] {false} ;
      P003V4_A37TipoConCod = new String[] {""} ;
      P003V4_A41ConDescrip = new String[] {""} ;
      P003V4_A26ConCodigo = new String[] {""} ;
      P003V5_A1644ConceptoPais = new short[1] ;
      P003V5_n1644ConceptoPais = new boolean[] {false} ;
      P003V5_A3CliCod = new int[1] ;
      P003V5_A503ConTipoLiqAux = new String[] {""} ;
      P003V5_n503ConTipoLiqAux = new boolean[] {false} ;
      P003V5_A148ConFormula = new String[] {""} ;
      P003V5_n148ConFormula = new boolean[] {false} ;
      P003V5_A160ConveDescri = new String[] {""} ;
      P003V5_n160ConveDescri = new boolean[] {false} ;
      P003V5_A2013ConRelRef = new String[] {""} ;
      P003V5_A1827ConBaseOSDif = new byte[1] ;
      P003V5_A1797ConBaseLicProm = new byte[1] ;
      P003V5_A1620ConBaseLic = new byte[1] ;
      P003V5_A1799ConBaseHorExtProm = new byte[1] ;
      P003V5_A1622ConBaseHorExt = new byte[1] ;
      P003V5_A1798ConBaseFerProm = new byte[1] ;
      P003V5_A1621ConBaseFer = new byte[1] ;
      P003V5_A1801ConBaseAnt = new byte[1] ;
      P003V5_A1800ConBasePres = new byte[1] ;
      P003V5_A1648ConCodAfip = new String[] {""} ;
      P003V5_A1539ConSacDeven = new byte[1] ;
      P003V5_A953ConCondicion = new String[] {""} ;
      P003V5_n953ConCondicion = new boolean[] {false} ;
      P003V5_A762ConRecalcular = new boolean[] {false} ;
      P003V5_A145ConFchModFor = new java.util.Date[] {GXutil.nullDate()} ;
      P003V5_n145ConFchModFor = new boolean[] {false} ;
      P003V5_A1112AplIIGG = new short[1] ;
      P003V5_n1112AplIIGG = new boolean[] {false} ;
      P003V5_A153ConObservacion = new String[] {""} ;
      P003V5_A150ConHabilitado = new boolean[] {false} ;
      P003V5_A159ConVariable = new boolean[] {false} ;
      P003V5_A162ConVigencia = new byte[1] ;
      P003V5_A1645ConceptoConveCodigo = new String[] {""} ;
      P003V5_n1645ConceptoConveCodigo = new boolean[] {false} ;
      P003V5_A970ConClasifAux = new String[] {""} ;
      P003V5_n970ConClasifAux = new boolean[] {false} ;
      P003V5_A37TipoConCod = new String[] {""} ;
      P003V5_A41ConDescrip = new String[] {""} ;
      P003V5_A26ConCodigo = new String[] {""} ;
      P003V6_A1644ConceptoPais = new short[1] ;
      P003V6_n1644ConceptoPais = new boolean[] {false} ;
      P003V6_A3CliCod = new int[1] ;
      P003V6_A1645ConceptoConveCodigo = new String[] {""} ;
      P003V6_n1645ConceptoConveCodigo = new boolean[] {false} ;
      P003V6_A148ConFormula = new String[] {""} ;
      P003V6_n148ConFormula = new boolean[] {false} ;
      P003V6_A160ConveDescri = new String[] {""} ;
      P003V6_n160ConveDescri = new boolean[] {false} ;
      P003V6_A2013ConRelRef = new String[] {""} ;
      P003V6_A1827ConBaseOSDif = new byte[1] ;
      P003V6_A1797ConBaseLicProm = new byte[1] ;
      P003V6_A1620ConBaseLic = new byte[1] ;
      P003V6_A1799ConBaseHorExtProm = new byte[1] ;
      P003V6_A1622ConBaseHorExt = new byte[1] ;
      P003V6_A1798ConBaseFerProm = new byte[1] ;
      P003V6_A1621ConBaseFer = new byte[1] ;
      P003V6_A1801ConBaseAnt = new byte[1] ;
      P003V6_A1800ConBasePres = new byte[1] ;
      P003V6_A1648ConCodAfip = new String[] {""} ;
      P003V6_A1539ConSacDeven = new byte[1] ;
      P003V6_A953ConCondicion = new String[] {""} ;
      P003V6_n953ConCondicion = new boolean[] {false} ;
      P003V6_A762ConRecalcular = new boolean[] {false} ;
      P003V6_A145ConFchModFor = new java.util.Date[] {GXutil.nullDate()} ;
      P003V6_n145ConFchModFor = new boolean[] {false} ;
      P003V6_A1112AplIIGG = new short[1] ;
      P003V6_n1112AplIIGG = new boolean[] {false} ;
      P003V6_A153ConObservacion = new String[] {""} ;
      P003V6_A150ConHabilitado = new boolean[] {false} ;
      P003V6_A159ConVariable = new boolean[] {false} ;
      P003V6_A162ConVigencia = new byte[1] ;
      P003V6_A503ConTipoLiqAux = new String[] {""} ;
      P003V6_n503ConTipoLiqAux = new boolean[] {false} ;
      P003V6_A970ConClasifAux = new String[] {""} ;
      P003V6_n970ConClasifAux = new boolean[] {false} ;
      P003V6_A37TipoConCod = new String[] {""} ;
      P003V6_A41ConDescrip = new String[] {""} ;
      P003V6_A26ConCodigo = new String[] {""} ;
      P003V7_A1644ConceptoPais = new short[1] ;
      P003V7_n1644ConceptoPais = new boolean[] {false} ;
      P003V7_A3CliCod = new int[1] ;
      P003V7_A153ConObservacion = new String[] {""} ;
      P003V7_A148ConFormula = new String[] {""} ;
      P003V7_n148ConFormula = new boolean[] {false} ;
      P003V7_A160ConveDescri = new String[] {""} ;
      P003V7_n160ConveDescri = new boolean[] {false} ;
      P003V7_A2013ConRelRef = new String[] {""} ;
      P003V7_A1827ConBaseOSDif = new byte[1] ;
      P003V7_A1797ConBaseLicProm = new byte[1] ;
      P003V7_A1620ConBaseLic = new byte[1] ;
      P003V7_A1799ConBaseHorExtProm = new byte[1] ;
      P003V7_A1622ConBaseHorExt = new byte[1] ;
      P003V7_A1798ConBaseFerProm = new byte[1] ;
      P003V7_A1621ConBaseFer = new byte[1] ;
      P003V7_A1801ConBaseAnt = new byte[1] ;
      P003V7_A1800ConBasePres = new byte[1] ;
      P003V7_A1648ConCodAfip = new String[] {""} ;
      P003V7_A1539ConSacDeven = new byte[1] ;
      P003V7_A953ConCondicion = new String[] {""} ;
      P003V7_n953ConCondicion = new boolean[] {false} ;
      P003V7_A762ConRecalcular = new boolean[] {false} ;
      P003V7_A145ConFchModFor = new java.util.Date[] {GXutil.nullDate()} ;
      P003V7_n145ConFchModFor = new boolean[] {false} ;
      P003V7_A1112AplIIGG = new short[1] ;
      P003V7_n1112AplIIGG = new boolean[] {false} ;
      P003V7_A150ConHabilitado = new boolean[] {false} ;
      P003V7_A159ConVariable = new boolean[] {false} ;
      P003V7_A162ConVigencia = new byte[1] ;
      P003V7_A1645ConceptoConveCodigo = new String[] {""} ;
      P003V7_n1645ConceptoConveCodigo = new boolean[] {false} ;
      P003V7_A503ConTipoLiqAux = new String[] {""} ;
      P003V7_n503ConTipoLiqAux = new boolean[] {false} ;
      P003V7_A970ConClasifAux = new String[] {""} ;
      P003V7_n970ConClasifAux = new boolean[] {false} ;
      P003V7_A37TipoConCod = new String[] {""} ;
      P003V7_A41ConDescrip = new String[] {""} ;
      P003V7_A26ConCodigo = new String[] {""} ;
      P003V8_A1644ConceptoPais = new short[1] ;
      P003V8_n1644ConceptoPais = new boolean[] {false} ;
      P003V8_A3CliCod = new int[1] ;
      P003V8_A1648ConCodAfip = new String[] {""} ;
      P003V8_A148ConFormula = new String[] {""} ;
      P003V8_n148ConFormula = new boolean[] {false} ;
      P003V8_A160ConveDescri = new String[] {""} ;
      P003V8_n160ConveDescri = new boolean[] {false} ;
      P003V8_A2013ConRelRef = new String[] {""} ;
      P003V8_A1827ConBaseOSDif = new byte[1] ;
      P003V8_A1797ConBaseLicProm = new byte[1] ;
      P003V8_A1620ConBaseLic = new byte[1] ;
      P003V8_A1799ConBaseHorExtProm = new byte[1] ;
      P003V8_A1622ConBaseHorExt = new byte[1] ;
      P003V8_A1798ConBaseFerProm = new byte[1] ;
      P003V8_A1621ConBaseFer = new byte[1] ;
      P003V8_A1801ConBaseAnt = new byte[1] ;
      P003V8_A1800ConBasePres = new byte[1] ;
      P003V8_A1539ConSacDeven = new byte[1] ;
      P003V8_A953ConCondicion = new String[] {""} ;
      P003V8_n953ConCondicion = new boolean[] {false} ;
      P003V8_A762ConRecalcular = new boolean[] {false} ;
      P003V8_A145ConFchModFor = new java.util.Date[] {GXutil.nullDate()} ;
      P003V8_n145ConFchModFor = new boolean[] {false} ;
      P003V8_A1112AplIIGG = new short[1] ;
      P003V8_n1112AplIIGG = new boolean[] {false} ;
      P003V8_A153ConObservacion = new String[] {""} ;
      P003V8_A150ConHabilitado = new boolean[] {false} ;
      P003V8_A159ConVariable = new boolean[] {false} ;
      P003V8_A162ConVigencia = new byte[1] ;
      P003V8_A1645ConceptoConveCodigo = new String[] {""} ;
      P003V8_n1645ConceptoConveCodigo = new boolean[] {false} ;
      P003V8_A503ConTipoLiqAux = new String[] {""} ;
      P003V8_n503ConTipoLiqAux = new boolean[] {false} ;
      P003V8_A970ConClasifAux = new String[] {""} ;
      P003V8_n970ConClasifAux = new boolean[] {false} ;
      P003V8_A37TipoConCod = new String[] {""} ;
      P003V8_A41ConDescrip = new String[] {""} ;
      P003V8_A26ConCodigo = new String[] {""} ;
      P003V9_A1644ConceptoPais = new short[1] ;
      P003V9_n1644ConceptoPais = new boolean[] {false} ;
      P003V9_A3CliCod = new int[1] ;
      P003V9_A2013ConRelRef = new String[] {""} ;
      P003V9_A148ConFormula = new String[] {""} ;
      P003V9_n148ConFormula = new boolean[] {false} ;
      P003V9_A160ConveDescri = new String[] {""} ;
      P003V9_n160ConveDescri = new boolean[] {false} ;
      P003V9_A1827ConBaseOSDif = new byte[1] ;
      P003V9_A1797ConBaseLicProm = new byte[1] ;
      P003V9_A1620ConBaseLic = new byte[1] ;
      P003V9_A1799ConBaseHorExtProm = new byte[1] ;
      P003V9_A1622ConBaseHorExt = new byte[1] ;
      P003V9_A1798ConBaseFerProm = new byte[1] ;
      P003V9_A1621ConBaseFer = new byte[1] ;
      P003V9_A1801ConBaseAnt = new byte[1] ;
      P003V9_A1800ConBasePres = new byte[1] ;
      P003V9_A1648ConCodAfip = new String[] {""} ;
      P003V9_A1539ConSacDeven = new byte[1] ;
      P003V9_A953ConCondicion = new String[] {""} ;
      P003V9_n953ConCondicion = new boolean[] {false} ;
      P003V9_A762ConRecalcular = new boolean[] {false} ;
      P003V9_A145ConFchModFor = new java.util.Date[] {GXutil.nullDate()} ;
      P003V9_n145ConFchModFor = new boolean[] {false} ;
      P003V9_A1112AplIIGG = new short[1] ;
      P003V9_n1112AplIIGG = new boolean[] {false} ;
      P003V9_A153ConObservacion = new String[] {""} ;
      P003V9_A150ConHabilitado = new boolean[] {false} ;
      P003V9_A159ConVariable = new boolean[] {false} ;
      P003V9_A162ConVigencia = new byte[1] ;
      P003V9_A1645ConceptoConveCodigo = new String[] {""} ;
      P003V9_n1645ConceptoConveCodigo = new boolean[] {false} ;
      P003V9_A503ConTipoLiqAux = new String[] {""} ;
      P003V9_n503ConTipoLiqAux = new boolean[] {false} ;
      P003V9_A970ConClasifAux = new String[] {""} ;
      P003V9_n970ConClasifAux = new boolean[] {false} ;
      P003V9_A37TipoConCod = new String[] {""} ;
      P003V9_A41ConDescrip = new String[] {""} ;
      P003V9_A26ConCodigo = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptowwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P003V2_A1644ConceptoPais, P003V2_n1644ConceptoPais, P003V2_A3CliCod, P003V2_A26ConCodigo, P003V2_A148ConFormula, P003V2_n148ConFormula, P003V2_A160ConveDescri, P003V2_n160ConveDescri, P003V2_A2013ConRelRef, P003V2_A1827ConBaseOSDif,
            P003V2_A1797ConBaseLicProm, P003V2_A1620ConBaseLic, P003V2_A1799ConBaseHorExtProm, P003V2_A1622ConBaseHorExt, P003V2_A1798ConBaseFerProm, P003V2_A1621ConBaseFer, P003V2_A1801ConBaseAnt, P003V2_A1800ConBasePres, P003V2_A1648ConCodAfip, P003V2_A1539ConSacDeven,
            P003V2_A953ConCondicion, P003V2_n953ConCondicion, P003V2_A762ConRecalcular, P003V2_A145ConFchModFor, P003V2_n145ConFchModFor, P003V2_A1112AplIIGG, P003V2_n1112AplIIGG, P003V2_A153ConObservacion, P003V2_A150ConHabilitado, P003V2_A159ConVariable,
            P003V2_A162ConVigencia, P003V2_A1645ConceptoConveCodigo, P003V2_n1645ConceptoConveCodigo, P003V2_A503ConTipoLiqAux, P003V2_n503ConTipoLiqAux, P003V2_A970ConClasifAux, P003V2_n970ConClasifAux, P003V2_A37TipoConCod, P003V2_A41ConDescrip
            }
            , new Object[] {
            P003V3_A1644ConceptoPais, P003V3_n1644ConceptoPais, P003V3_A3CliCod, P003V3_A41ConDescrip, P003V3_A148ConFormula, P003V3_n148ConFormula, P003V3_A160ConveDescri, P003V3_n160ConveDescri, P003V3_A2013ConRelRef, P003V3_A1827ConBaseOSDif,
            P003V3_A1797ConBaseLicProm, P003V3_A1620ConBaseLic, P003V3_A1799ConBaseHorExtProm, P003V3_A1622ConBaseHorExt, P003V3_A1798ConBaseFerProm, P003V3_A1621ConBaseFer, P003V3_A1801ConBaseAnt, P003V3_A1800ConBasePres, P003V3_A1648ConCodAfip, P003V3_A1539ConSacDeven,
            P003V3_A953ConCondicion, P003V3_n953ConCondicion, P003V3_A762ConRecalcular, P003V3_A145ConFchModFor, P003V3_n145ConFchModFor, P003V3_A1112AplIIGG, P003V3_n1112AplIIGG, P003V3_A153ConObservacion, P003V3_A150ConHabilitado, P003V3_A159ConVariable,
            P003V3_A162ConVigencia, P003V3_A1645ConceptoConveCodigo, P003V3_n1645ConceptoConveCodigo, P003V3_A503ConTipoLiqAux, P003V3_n503ConTipoLiqAux, P003V3_A970ConClasifAux, P003V3_n970ConClasifAux, P003V3_A37TipoConCod, P003V3_A26ConCodigo
            }
            , new Object[] {
            P003V4_A1644ConceptoPais, P003V4_n1644ConceptoPais, P003V4_A3CliCod, P003V4_A970ConClasifAux, P003V4_n970ConClasifAux, P003V4_A148ConFormula, P003V4_n148ConFormula, P003V4_A160ConveDescri, P003V4_n160ConveDescri, P003V4_A2013ConRelRef,
            P003V4_A1827ConBaseOSDif, P003V4_A1797ConBaseLicProm, P003V4_A1620ConBaseLic, P003V4_A1799ConBaseHorExtProm, P003V4_A1622ConBaseHorExt, P003V4_A1798ConBaseFerProm, P003V4_A1621ConBaseFer, P003V4_A1801ConBaseAnt, P003V4_A1800ConBasePres, P003V4_A1648ConCodAfip,
            P003V4_A1539ConSacDeven, P003V4_A953ConCondicion, P003V4_n953ConCondicion, P003V4_A762ConRecalcular, P003V4_A145ConFchModFor, P003V4_n145ConFchModFor, P003V4_A1112AplIIGG, P003V4_n1112AplIIGG, P003V4_A153ConObservacion, P003V4_A150ConHabilitado,
            P003V4_A159ConVariable, P003V4_A162ConVigencia, P003V4_A1645ConceptoConveCodigo, P003V4_n1645ConceptoConveCodigo, P003V4_A503ConTipoLiqAux, P003V4_n503ConTipoLiqAux, P003V4_A37TipoConCod, P003V4_A41ConDescrip, P003V4_A26ConCodigo
            }
            , new Object[] {
            P003V5_A1644ConceptoPais, P003V5_n1644ConceptoPais, P003V5_A3CliCod, P003V5_A503ConTipoLiqAux, P003V5_n503ConTipoLiqAux, P003V5_A148ConFormula, P003V5_n148ConFormula, P003V5_A160ConveDescri, P003V5_n160ConveDescri, P003V5_A2013ConRelRef,
            P003V5_A1827ConBaseOSDif, P003V5_A1797ConBaseLicProm, P003V5_A1620ConBaseLic, P003V5_A1799ConBaseHorExtProm, P003V5_A1622ConBaseHorExt, P003V5_A1798ConBaseFerProm, P003V5_A1621ConBaseFer, P003V5_A1801ConBaseAnt, P003V5_A1800ConBasePres, P003V5_A1648ConCodAfip,
            P003V5_A1539ConSacDeven, P003V5_A953ConCondicion, P003V5_n953ConCondicion, P003V5_A762ConRecalcular, P003V5_A145ConFchModFor, P003V5_n145ConFchModFor, P003V5_A1112AplIIGG, P003V5_n1112AplIIGG, P003V5_A153ConObservacion, P003V5_A150ConHabilitado,
            P003V5_A159ConVariable, P003V5_A162ConVigencia, P003V5_A1645ConceptoConveCodigo, P003V5_n1645ConceptoConveCodigo, P003V5_A970ConClasifAux, P003V5_n970ConClasifAux, P003V5_A37TipoConCod, P003V5_A41ConDescrip, P003V5_A26ConCodigo
            }
            , new Object[] {
            P003V6_A1644ConceptoPais, P003V6_n1644ConceptoPais, P003V6_A3CliCod, P003V6_A1645ConceptoConveCodigo, P003V6_n1645ConceptoConveCodigo, P003V6_A148ConFormula, P003V6_n148ConFormula, P003V6_A160ConveDescri, P003V6_n160ConveDescri, P003V6_A2013ConRelRef,
            P003V6_A1827ConBaseOSDif, P003V6_A1797ConBaseLicProm, P003V6_A1620ConBaseLic, P003V6_A1799ConBaseHorExtProm, P003V6_A1622ConBaseHorExt, P003V6_A1798ConBaseFerProm, P003V6_A1621ConBaseFer, P003V6_A1801ConBaseAnt, P003V6_A1800ConBasePres, P003V6_A1648ConCodAfip,
            P003V6_A1539ConSacDeven, P003V6_A953ConCondicion, P003V6_n953ConCondicion, P003V6_A762ConRecalcular, P003V6_A145ConFchModFor, P003V6_n145ConFchModFor, P003V6_A1112AplIIGG, P003V6_n1112AplIIGG, P003V6_A153ConObservacion, P003V6_A150ConHabilitado,
            P003V6_A159ConVariable, P003V6_A162ConVigencia, P003V6_A503ConTipoLiqAux, P003V6_n503ConTipoLiqAux, P003V6_A970ConClasifAux, P003V6_n970ConClasifAux, P003V6_A37TipoConCod, P003V6_A41ConDescrip, P003V6_A26ConCodigo
            }
            , new Object[] {
            P003V7_A1644ConceptoPais, P003V7_n1644ConceptoPais, P003V7_A3CliCod, P003V7_A153ConObservacion, P003V7_A148ConFormula, P003V7_n148ConFormula, P003V7_A160ConveDescri, P003V7_n160ConveDescri, P003V7_A2013ConRelRef, P003V7_A1827ConBaseOSDif,
            P003V7_A1797ConBaseLicProm, P003V7_A1620ConBaseLic, P003V7_A1799ConBaseHorExtProm, P003V7_A1622ConBaseHorExt, P003V7_A1798ConBaseFerProm, P003V7_A1621ConBaseFer, P003V7_A1801ConBaseAnt, P003V7_A1800ConBasePres, P003V7_A1648ConCodAfip, P003V7_A1539ConSacDeven,
            P003V7_A953ConCondicion, P003V7_n953ConCondicion, P003V7_A762ConRecalcular, P003V7_A145ConFchModFor, P003V7_n145ConFchModFor, P003V7_A1112AplIIGG, P003V7_n1112AplIIGG, P003V7_A150ConHabilitado, P003V7_A159ConVariable, P003V7_A162ConVigencia,
            P003V7_A1645ConceptoConveCodigo, P003V7_n1645ConceptoConveCodigo, P003V7_A503ConTipoLiqAux, P003V7_n503ConTipoLiqAux, P003V7_A970ConClasifAux, P003V7_n970ConClasifAux, P003V7_A37TipoConCod, P003V7_A41ConDescrip, P003V7_A26ConCodigo
            }
            , new Object[] {
            P003V8_A1644ConceptoPais, P003V8_n1644ConceptoPais, P003V8_A3CliCod, P003V8_A1648ConCodAfip, P003V8_A148ConFormula, P003V8_n148ConFormula, P003V8_A160ConveDescri, P003V8_n160ConveDescri, P003V8_A2013ConRelRef, P003V8_A1827ConBaseOSDif,
            P003V8_A1797ConBaseLicProm, P003V8_A1620ConBaseLic, P003V8_A1799ConBaseHorExtProm, P003V8_A1622ConBaseHorExt, P003V8_A1798ConBaseFerProm, P003V8_A1621ConBaseFer, P003V8_A1801ConBaseAnt, P003V8_A1800ConBasePres, P003V8_A1539ConSacDeven, P003V8_A953ConCondicion,
            P003V8_n953ConCondicion, P003V8_A762ConRecalcular, P003V8_A145ConFchModFor, P003V8_n145ConFchModFor, P003V8_A1112AplIIGG, P003V8_n1112AplIIGG, P003V8_A153ConObservacion, P003V8_A150ConHabilitado, P003V8_A159ConVariable, P003V8_A162ConVigencia,
            P003V8_A1645ConceptoConveCodigo, P003V8_n1645ConceptoConveCodigo, P003V8_A503ConTipoLiqAux, P003V8_n503ConTipoLiqAux, P003V8_A970ConClasifAux, P003V8_n970ConClasifAux, P003V8_A37TipoConCod, P003V8_A41ConDescrip, P003V8_A26ConCodigo
            }
            , new Object[] {
            P003V9_A1644ConceptoPais, P003V9_n1644ConceptoPais, P003V9_A3CliCod, P003V9_A2013ConRelRef, P003V9_A148ConFormula, P003V9_n148ConFormula, P003V9_A160ConveDescri, P003V9_n160ConveDescri, P003V9_A1827ConBaseOSDif, P003V9_A1797ConBaseLicProm,
            P003V9_A1620ConBaseLic, P003V9_A1799ConBaseHorExtProm, P003V9_A1622ConBaseHorExt, P003V9_A1798ConBaseFerProm, P003V9_A1621ConBaseFer, P003V9_A1801ConBaseAnt, P003V9_A1800ConBasePres, P003V9_A1648ConCodAfip, P003V9_A1539ConSacDeven, P003V9_A953ConCondicion,
            P003V9_n953ConCondicion, P003V9_A762ConRecalcular, P003V9_A145ConFchModFor, P003V9_n145ConFchModFor, P003V9_A1112AplIIGG, P003V9_n1112AplIIGG, P003V9_A153ConObservacion, P003V9_A150ConHabilitado, P003V9_A159ConVariable, P003V9_A162ConVigencia,
            P003V9_A1645ConceptoConveCodigo, P003V9_n1645ConceptoConveCodigo, P003V9_A503ConTipoLiqAux, P003V9_n503ConTipoLiqAux, P003V9_A970ConClasifAux, P003V9_n970ConClasifAux, P003V9_A37TipoConCod, P003V9_A41ConDescrip, P003V9_A26ConCodigo
            }
         }
      );
      AV146Pgmname = "ConceptoWWGetFilterData" ;
      /* GeneXus formulas. */
      AV146Pgmname = "ConceptoWWGetFilterData" ;
      Gx_err = (short)(0) ;
   }

   private byte AV23TFConVariable_Sel ;
   private byte AV14TFConHabilitado_Sel ;
   private byte AV89TFConRecalcular_Sel ;
   private byte AV161Conceptowwds_13_tfconvariable_sel ;
   private byte AV163Conceptowwds_15_tfconhabilitado_sel ;
   private byte AV169Conceptowwds_21_tfconrecalcular_sel ;
   private byte A162ConVigencia ;
   private byte A1539ConSacDeven ;
   private byte A1800ConBasePres ;
   private byte A1801ConBaseAnt ;
   private byte A1621ConBaseFer ;
   private byte A1798ConBaseFerProm ;
   private byte A1622ConBaseHorExt ;
   private byte A1799ConBaseHorExtProm ;
   private byte A1620ConBaseLic ;
   private byte A1797ConBaseLicProm ;
   private byte A1827ConBaseOSDif ;
   private short AV65EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A1112AplIIGG ;
   private short A1644ConceptoPais ;
   private short Gx_err ;
   private int AV64CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV147GXV1 ;
   private int AV150Conceptowwds_2_tfconcodigo_sels_size ;
   private int AV152Conceptowwds_4_tfcondescrip_sels_size ;
   private int AV153Conceptowwds_5_tftipoconcod_sels_size ;
   private int AV155Conceptowwds_7_tfconclasifaux_sels_size ;
   private int AV157Conceptowwds_9_tfcontipoliqaux_sels_size ;
   private int AV159Conceptowwds_11_tfconceptoconvecodigo_sels_size ;
   private int AV160Conceptowwds_12_tfconvigencia_sels_size ;
   private int AV165Conceptowwds_17_tfconobservacion_sels_size ;
   private int AV166Conceptowwds_18_tfapliigg_sels_size ;
   private int AV170Conceptowwds_22_tfconcondicion_sels_size ;
   private int AV171Conceptowwds_23_tfconsacdeven_sels_size ;
   private int AV173Conceptowwds_25_tfconcodafip_sels_size ;
   private int AV174Conceptowwds_26_tfconbasepres_sels_size ;
   private int AV175Conceptowwds_27_tfconbaseant_sels_size ;
   private int AV176Conceptowwds_28_tfconbasefer_sels_size ;
   private int AV177Conceptowwds_29_tfconbaseferprom_sels_size ;
   private int AV178Conceptowwds_30_tfconbasehorext_sels_size ;
   private int AV179Conceptowwds_31_tfconbasehorextprom_sels_size ;
   private int AV180Conceptowwds_32_tfconbaselic_sels_size ;
   private int AV181Conceptowwds_33_tfconbaselicprom_sels_size ;
   private int AV182Conceptowwds_34_tfconbaseosdif_sels_size ;
   private int AV184Conceptowwds_36_tfconrelref_sels_size ;
   private int A3CliCod ;
   private int AV38InsertIndex ;
   private long AV47count ;
   private String AV146Pgmname ;
   private String AV10TFConCodigo ;
   private String AV110TFConCodAfip ;
   private String A26ConCodigo ;
   private String AV149Conceptowwds_1_tfconcodigo ;
   private String AV172Conceptowwds_24_tfconcodafip ;
   private String scmdbuf ;
   private String lV149Conceptowwds_1_tfconcodigo ;
   private String lV172Conceptowwds_24_tfconcodafip ;
   private String A37TipoConCod ;
   private String A1645ConceptoConveCodigo ;
   private String A953ConCondicion ;
   private String A1648ConCodAfip ;
   private java.util.Date AV33TFConFchModFor ;
   private java.util.Date AV34TFConFchModFor_To ;
   private java.util.Date AV167Conceptowwds_19_tfconfchmodfor ;
   private java.util.Date AV168Conceptowwds_20_tfconfchmodfor_to ;
   private java.util.Date A145ConFchModFor ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean A159ConVariable ;
   private boolean A150ConHabilitado ;
   private boolean A762ConRecalcular ;
   private boolean brk3V2 ;
   private boolean n1644ConceptoPais ;
   private boolean n148ConFormula ;
   private boolean n160ConveDescri ;
   private boolean n953ConCondicion ;
   private boolean n145ConFchModFor ;
   private boolean n1112AplIIGG ;
   private boolean n1645ConceptoConveCodigo ;
   private boolean n503ConTipoLiqAux ;
   private boolean n970ConClasifAux ;
   private boolean brk3V4 ;
   private boolean brk3V6 ;
   private boolean brk3V8 ;
   private boolean brk3V10 ;
   private boolean brk3V12 ;
   private boolean brk3V14 ;
   private boolean brk3V16 ;
   private String AV41OptionsJson ;
   private String AV44OptionsDescJson ;
   private String AV46OptionIndexesJson ;
   private String AV54TFConCodigo_SelsJson ;
   private String AV56TFConDescrip_SelsJson ;
   private String AV69TFTipoConCod_SelsJson ;
   private String AV92TFConClasifAux_SelsJson ;
   private String AV83TFConTipoLiqAux_SelsJson ;
   private String AV106TFConceptoConveCodigo_SelsJson ;
   private String AV21TFConVigencia_SelsJson ;
   private String AV60TFConObservacion_SelsJson ;
   private String AV100TFAplIIGG_SelsJson ;
   private String AV98TFConCondicion_SelsJson ;
   private String AV104TFConSacDeven_SelsJson ;
   private String AV109TFConCodAfip_SelsJson ;
   private String AV114TFConBasePres_SelsJson ;
   private String AV116TFConBaseAnt_SelsJson ;
   private String AV118TFConBaseFer_SelsJson ;
   private String AV120TFConBaseFerProm_SelsJson ;
   private String AV122TFConBaseHorExt_SelsJson ;
   private String AV124TFConBaseHorExtProm_SelsJson ;
   private String AV126TFConBaseLic_SelsJson ;
   private String AV128TFConBaseLicProm_SelsJson ;
   private String AV130TFConBaseOSDif_SelsJson ;
   private String AV141TFConRelRef_SelsJson ;
   private String A153ConObservacion ;
   private String A148ConFormula ;
   private String AV37DDOName ;
   private String AV35SearchTxt ;
   private String AV36SearchTxtTo ;
   private String AV12TFConDescrip ;
   private String AV93TFConClasifAux ;
   private String AV84TFConTipoLiqAux ;
   private String AV107TFConceptoConveCodigo ;
   private String AV25TFConFormula ;
   private String AV27TFConObservacion ;
   private String AV142TFConRelRef ;
   private String AV140MenuOpcCod ;
   private String AV151Conceptowwds_3_tfcondescrip ;
   private String AV154Conceptowwds_6_tfconclasifaux ;
   private String AV156Conceptowwds_8_tfcontipoliqaux ;
   private String AV158Conceptowwds_10_tfconceptoconvecodigo ;
   private String AV162Conceptowwds_14_tfconformula ;
   private String AV164Conceptowwds_16_tfconobservacion ;
   private String AV183Conceptowwds_35_tfconrelref ;
   private String lV151Conceptowwds_3_tfcondescrip ;
   private String lV154Conceptowwds_6_tfconclasifaux ;
   private String lV156Conceptowwds_8_tfcontipoliqaux ;
   private String lV158Conceptowwds_10_tfconceptoconvecodigo ;
   private String lV164Conceptowwds_16_tfconobservacion ;
   private String lV183Conceptowwds_35_tfconrelref ;
   private String lV25TFConFormula ;
   private String A41ConDescrip ;
   private String A970ConClasifAux ;
   private String A503ConTipoLiqAux ;
   private String A2013ConRelRef ;
   private String A160ConveDescri ;
   private String AV39Option ;
   private String AV42OptionDesc ;
   private GXSimpleCollection<Byte> AV22TFConVigencia_Sels ;
   private GXSimpleCollection<Byte> AV105TFConSacDeven_Sels ;
   private GXSimpleCollection<Byte> AV115TFConBasePres_Sels ;
   private GXSimpleCollection<Byte> AV117TFConBaseAnt_Sels ;
   private GXSimpleCollection<Byte> AV119TFConBaseFer_Sels ;
   private GXSimpleCollection<Byte> AV121TFConBaseFerProm_Sels ;
   private GXSimpleCollection<Byte> AV123TFConBaseHorExt_Sels ;
   private GXSimpleCollection<Byte> AV125TFConBaseHorExtProm_Sels ;
   private GXSimpleCollection<Byte> AV127TFConBaseLic_Sels ;
   private GXSimpleCollection<Byte> AV129TFConBaseLicProm_Sels ;
   private GXSimpleCollection<Byte> AV131TFConBaseOSDif_Sels ;
   private GXSimpleCollection<Byte> AV160Conceptowwds_12_tfconvigencia_sels ;
   private GXSimpleCollection<Byte> AV171Conceptowwds_23_tfconsacdeven_sels ;
   private GXSimpleCollection<Byte> AV174Conceptowwds_26_tfconbasepres_sels ;
   private GXSimpleCollection<Byte> AV175Conceptowwds_27_tfconbaseant_sels ;
   private GXSimpleCollection<Byte> AV176Conceptowwds_28_tfconbasefer_sels ;
   private GXSimpleCollection<Byte> AV177Conceptowwds_29_tfconbaseferprom_sels ;
   private GXSimpleCollection<Byte> AV178Conceptowwds_30_tfconbasehorext_sels ;
   private GXSimpleCollection<Byte> AV179Conceptowwds_31_tfconbasehorextprom_sels ;
   private GXSimpleCollection<Byte> AV180Conceptowwds_32_tfconbaselic_sels ;
   private GXSimpleCollection<Byte> AV181Conceptowwds_33_tfconbaselicprom_sels ;
   private GXSimpleCollection<Byte> AV182Conceptowwds_34_tfconbaseosdif_sels ;
   private GXSimpleCollection<Short> AV101TFAplIIGG_Sels ;
   private GXSimpleCollection<Short> AV166Conceptowwds_18_tfapliigg_sels ;
   private com.genexus.webpanels.WebSession AV48Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private short[] P003V2_A1644ConceptoPais ;
   private boolean[] P003V2_n1644ConceptoPais ;
   private int[] P003V2_A3CliCod ;
   private String[] P003V2_A26ConCodigo ;
   private String[] P003V2_A148ConFormula ;
   private boolean[] P003V2_n148ConFormula ;
   private String[] P003V2_A160ConveDescri ;
   private boolean[] P003V2_n160ConveDescri ;
   private String[] P003V2_A2013ConRelRef ;
   private byte[] P003V2_A1827ConBaseOSDif ;
   private byte[] P003V2_A1797ConBaseLicProm ;
   private byte[] P003V2_A1620ConBaseLic ;
   private byte[] P003V2_A1799ConBaseHorExtProm ;
   private byte[] P003V2_A1622ConBaseHorExt ;
   private byte[] P003V2_A1798ConBaseFerProm ;
   private byte[] P003V2_A1621ConBaseFer ;
   private byte[] P003V2_A1801ConBaseAnt ;
   private byte[] P003V2_A1800ConBasePres ;
   private String[] P003V2_A1648ConCodAfip ;
   private byte[] P003V2_A1539ConSacDeven ;
   private String[] P003V2_A953ConCondicion ;
   private boolean[] P003V2_n953ConCondicion ;
   private boolean[] P003V2_A762ConRecalcular ;
   private java.util.Date[] P003V2_A145ConFchModFor ;
   private boolean[] P003V2_n145ConFchModFor ;
   private short[] P003V2_A1112AplIIGG ;
   private boolean[] P003V2_n1112AplIIGG ;
   private String[] P003V2_A153ConObservacion ;
   private boolean[] P003V2_A150ConHabilitado ;
   private boolean[] P003V2_A159ConVariable ;
   private byte[] P003V2_A162ConVigencia ;
   private String[] P003V2_A1645ConceptoConveCodigo ;
   private boolean[] P003V2_n1645ConceptoConveCodigo ;
   private String[] P003V2_A503ConTipoLiqAux ;
   private boolean[] P003V2_n503ConTipoLiqAux ;
   private String[] P003V2_A970ConClasifAux ;
   private boolean[] P003V2_n970ConClasifAux ;
   private String[] P003V2_A37TipoConCod ;
   private String[] P003V2_A41ConDescrip ;
   private short[] P003V3_A1644ConceptoPais ;
   private boolean[] P003V3_n1644ConceptoPais ;
   private int[] P003V3_A3CliCod ;
   private String[] P003V3_A41ConDescrip ;
   private String[] P003V3_A148ConFormula ;
   private boolean[] P003V3_n148ConFormula ;
   private String[] P003V3_A160ConveDescri ;
   private boolean[] P003V3_n160ConveDescri ;
   private String[] P003V3_A2013ConRelRef ;
   private byte[] P003V3_A1827ConBaseOSDif ;
   private byte[] P003V3_A1797ConBaseLicProm ;
   private byte[] P003V3_A1620ConBaseLic ;
   private byte[] P003V3_A1799ConBaseHorExtProm ;
   private byte[] P003V3_A1622ConBaseHorExt ;
   private byte[] P003V3_A1798ConBaseFerProm ;
   private byte[] P003V3_A1621ConBaseFer ;
   private byte[] P003V3_A1801ConBaseAnt ;
   private byte[] P003V3_A1800ConBasePres ;
   private String[] P003V3_A1648ConCodAfip ;
   private byte[] P003V3_A1539ConSacDeven ;
   private String[] P003V3_A953ConCondicion ;
   private boolean[] P003V3_n953ConCondicion ;
   private boolean[] P003V3_A762ConRecalcular ;
   private java.util.Date[] P003V3_A145ConFchModFor ;
   private boolean[] P003V3_n145ConFchModFor ;
   private short[] P003V3_A1112AplIIGG ;
   private boolean[] P003V3_n1112AplIIGG ;
   private String[] P003V3_A153ConObservacion ;
   private boolean[] P003V3_A150ConHabilitado ;
   private boolean[] P003V3_A159ConVariable ;
   private byte[] P003V3_A162ConVigencia ;
   private String[] P003V3_A1645ConceptoConveCodigo ;
   private boolean[] P003V3_n1645ConceptoConveCodigo ;
   private String[] P003V3_A503ConTipoLiqAux ;
   private boolean[] P003V3_n503ConTipoLiqAux ;
   private String[] P003V3_A970ConClasifAux ;
   private boolean[] P003V3_n970ConClasifAux ;
   private String[] P003V3_A37TipoConCod ;
   private String[] P003V3_A26ConCodigo ;
   private short[] P003V4_A1644ConceptoPais ;
   private boolean[] P003V4_n1644ConceptoPais ;
   private int[] P003V4_A3CliCod ;
   private String[] P003V4_A970ConClasifAux ;
   private boolean[] P003V4_n970ConClasifAux ;
   private String[] P003V4_A148ConFormula ;
   private boolean[] P003V4_n148ConFormula ;
   private String[] P003V4_A160ConveDescri ;
   private boolean[] P003V4_n160ConveDescri ;
   private String[] P003V4_A2013ConRelRef ;
   private byte[] P003V4_A1827ConBaseOSDif ;
   private byte[] P003V4_A1797ConBaseLicProm ;
   private byte[] P003V4_A1620ConBaseLic ;
   private byte[] P003V4_A1799ConBaseHorExtProm ;
   private byte[] P003V4_A1622ConBaseHorExt ;
   private byte[] P003V4_A1798ConBaseFerProm ;
   private byte[] P003V4_A1621ConBaseFer ;
   private byte[] P003V4_A1801ConBaseAnt ;
   private byte[] P003V4_A1800ConBasePres ;
   private String[] P003V4_A1648ConCodAfip ;
   private byte[] P003V4_A1539ConSacDeven ;
   private String[] P003V4_A953ConCondicion ;
   private boolean[] P003V4_n953ConCondicion ;
   private boolean[] P003V4_A762ConRecalcular ;
   private java.util.Date[] P003V4_A145ConFchModFor ;
   private boolean[] P003V4_n145ConFchModFor ;
   private short[] P003V4_A1112AplIIGG ;
   private boolean[] P003V4_n1112AplIIGG ;
   private String[] P003V4_A153ConObservacion ;
   private boolean[] P003V4_A150ConHabilitado ;
   private boolean[] P003V4_A159ConVariable ;
   private byte[] P003V4_A162ConVigencia ;
   private String[] P003V4_A1645ConceptoConveCodigo ;
   private boolean[] P003V4_n1645ConceptoConveCodigo ;
   private String[] P003V4_A503ConTipoLiqAux ;
   private boolean[] P003V4_n503ConTipoLiqAux ;
   private String[] P003V4_A37TipoConCod ;
   private String[] P003V4_A41ConDescrip ;
   private String[] P003V4_A26ConCodigo ;
   private short[] P003V5_A1644ConceptoPais ;
   private boolean[] P003V5_n1644ConceptoPais ;
   private int[] P003V5_A3CliCod ;
   private String[] P003V5_A503ConTipoLiqAux ;
   private boolean[] P003V5_n503ConTipoLiqAux ;
   private String[] P003V5_A148ConFormula ;
   private boolean[] P003V5_n148ConFormula ;
   private String[] P003V5_A160ConveDescri ;
   private boolean[] P003V5_n160ConveDescri ;
   private String[] P003V5_A2013ConRelRef ;
   private byte[] P003V5_A1827ConBaseOSDif ;
   private byte[] P003V5_A1797ConBaseLicProm ;
   private byte[] P003V5_A1620ConBaseLic ;
   private byte[] P003V5_A1799ConBaseHorExtProm ;
   private byte[] P003V5_A1622ConBaseHorExt ;
   private byte[] P003V5_A1798ConBaseFerProm ;
   private byte[] P003V5_A1621ConBaseFer ;
   private byte[] P003V5_A1801ConBaseAnt ;
   private byte[] P003V5_A1800ConBasePres ;
   private String[] P003V5_A1648ConCodAfip ;
   private byte[] P003V5_A1539ConSacDeven ;
   private String[] P003V5_A953ConCondicion ;
   private boolean[] P003V5_n953ConCondicion ;
   private boolean[] P003V5_A762ConRecalcular ;
   private java.util.Date[] P003V5_A145ConFchModFor ;
   private boolean[] P003V5_n145ConFchModFor ;
   private short[] P003V5_A1112AplIIGG ;
   private boolean[] P003V5_n1112AplIIGG ;
   private String[] P003V5_A153ConObservacion ;
   private boolean[] P003V5_A150ConHabilitado ;
   private boolean[] P003V5_A159ConVariable ;
   private byte[] P003V5_A162ConVigencia ;
   private String[] P003V5_A1645ConceptoConveCodigo ;
   private boolean[] P003V5_n1645ConceptoConveCodigo ;
   private String[] P003V5_A970ConClasifAux ;
   private boolean[] P003V5_n970ConClasifAux ;
   private String[] P003V5_A37TipoConCod ;
   private String[] P003V5_A41ConDescrip ;
   private String[] P003V5_A26ConCodigo ;
   private short[] P003V6_A1644ConceptoPais ;
   private boolean[] P003V6_n1644ConceptoPais ;
   private int[] P003V6_A3CliCod ;
   private String[] P003V6_A1645ConceptoConveCodigo ;
   private boolean[] P003V6_n1645ConceptoConveCodigo ;
   private String[] P003V6_A148ConFormula ;
   private boolean[] P003V6_n148ConFormula ;
   private String[] P003V6_A160ConveDescri ;
   private boolean[] P003V6_n160ConveDescri ;
   private String[] P003V6_A2013ConRelRef ;
   private byte[] P003V6_A1827ConBaseOSDif ;
   private byte[] P003V6_A1797ConBaseLicProm ;
   private byte[] P003V6_A1620ConBaseLic ;
   private byte[] P003V6_A1799ConBaseHorExtProm ;
   private byte[] P003V6_A1622ConBaseHorExt ;
   private byte[] P003V6_A1798ConBaseFerProm ;
   private byte[] P003V6_A1621ConBaseFer ;
   private byte[] P003V6_A1801ConBaseAnt ;
   private byte[] P003V6_A1800ConBasePres ;
   private String[] P003V6_A1648ConCodAfip ;
   private byte[] P003V6_A1539ConSacDeven ;
   private String[] P003V6_A953ConCondicion ;
   private boolean[] P003V6_n953ConCondicion ;
   private boolean[] P003V6_A762ConRecalcular ;
   private java.util.Date[] P003V6_A145ConFchModFor ;
   private boolean[] P003V6_n145ConFchModFor ;
   private short[] P003V6_A1112AplIIGG ;
   private boolean[] P003V6_n1112AplIIGG ;
   private String[] P003V6_A153ConObservacion ;
   private boolean[] P003V6_A150ConHabilitado ;
   private boolean[] P003V6_A159ConVariable ;
   private byte[] P003V6_A162ConVigencia ;
   private String[] P003V6_A503ConTipoLiqAux ;
   private boolean[] P003V6_n503ConTipoLiqAux ;
   private String[] P003V6_A970ConClasifAux ;
   private boolean[] P003V6_n970ConClasifAux ;
   private String[] P003V6_A37TipoConCod ;
   private String[] P003V6_A41ConDescrip ;
   private String[] P003V6_A26ConCodigo ;
   private short[] P003V7_A1644ConceptoPais ;
   private boolean[] P003V7_n1644ConceptoPais ;
   private int[] P003V7_A3CliCod ;
   private String[] P003V7_A153ConObservacion ;
   private String[] P003V7_A148ConFormula ;
   private boolean[] P003V7_n148ConFormula ;
   private String[] P003V7_A160ConveDescri ;
   private boolean[] P003V7_n160ConveDescri ;
   private String[] P003V7_A2013ConRelRef ;
   private byte[] P003V7_A1827ConBaseOSDif ;
   private byte[] P003V7_A1797ConBaseLicProm ;
   private byte[] P003V7_A1620ConBaseLic ;
   private byte[] P003V7_A1799ConBaseHorExtProm ;
   private byte[] P003V7_A1622ConBaseHorExt ;
   private byte[] P003V7_A1798ConBaseFerProm ;
   private byte[] P003V7_A1621ConBaseFer ;
   private byte[] P003V7_A1801ConBaseAnt ;
   private byte[] P003V7_A1800ConBasePres ;
   private String[] P003V7_A1648ConCodAfip ;
   private byte[] P003V7_A1539ConSacDeven ;
   private String[] P003V7_A953ConCondicion ;
   private boolean[] P003V7_n953ConCondicion ;
   private boolean[] P003V7_A762ConRecalcular ;
   private java.util.Date[] P003V7_A145ConFchModFor ;
   private boolean[] P003V7_n145ConFchModFor ;
   private short[] P003V7_A1112AplIIGG ;
   private boolean[] P003V7_n1112AplIIGG ;
   private boolean[] P003V7_A150ConHabilitado ;
   private boolean[] P003V7_A159ConVariable ;
   private byte[] P003V7_A162ConVigencia ;
   private String[] P003V7_A1645ConceptoConveCodigo ;
   private boolean[] P003V7_n1645ConceptoConveCodigo ;
   private String[] P003V7_A503ConTipoLiqAux ;
   private boolean[] P003V7_n503ConTipoLiqAux ;
   private String[] P003V7_A970ConClasifAux ;
   private boolean[] P003V7_n970ConClasifAux ;
   private String[] P003V7_A37TipoConCod ;
   private String[] P003V7_A41ConDescrip ;
   private String[] P003V7_A26ConCodigo ;
   private short[] P003V8_A1644ConceptoPais ;
   private boolean[] P003V8_n1644ConceptoPais ;
   private int[] P003V8_A3CliCod ;
   private String[] P003V8_A1648ConCodAfip ;
   private String[] P003V8_A148ConFormula ;
   private boolean[] P003V8_n148ConFormula ;
   private String[] P003V8_A160ConveDescri ;
   private boolean[] P003V8_n160ConveDescri ;
   private String[] P003V8_A2013ConRelRef ;
   private byte[] P003V8_A1827ConBaseOSDif ;
   private byte[] P003V8_A1797ConBaseLicProm ;
   private byte[] P003V8_A1620ConBaseLic ;
   private byte[] P003V8_A1799ConBaseHorExtProm ;
   private byte[] P003V8_A1622ConBaseHorExt ;
   private byte[] P003V8_A1798ConBaseFerProm ;
   private byte[] P003V8_A1621ConBaseFer ;
   private byte[] P003V8_A1801ConBaseAnt ;
   private byte[] P003V8_A1800ConBasePres ;
   private byte[] P003V8_A1539ConSacDeven ;
   private String[] P003V8_A953ConCondicion ;
   private boolean[] P003V8_n953ConCondicion ;
   private boolean[] P003V8_A762ConRecalcular ;
   private java.util.Date[] P003V8_A145ConFchModFor ;
   private boolean[] P003V8_n145ConFchModFor ;
   private short[] P003V8_A1112AplIIGG ;
   private boolean[] P003V8_n1112AplIIGG ;
   private String[] P003V8_A153ConObservacion ;
   private boolean[] P003V8_A150ConHabilitado ;
   private boolean[] P003V8_A159ConVariable ;
   private byte[] P003V8_A162ConVigencia ;
   private String[] P003V8_A1645ConceptoConveCodigo ;
   private boolean[] P003V8_n1645ConceptoConveCodigo ;
   private String[] P003V8_A503ConTipoLiqAux ;
   private boolean[] P003V8_n503ConTipoLiqAux ;
   private String[] P003V8_A970ConClasifAux ;
   private boolean[] P003V8_n970ConClasifAux ;
   private String[] P003V8_A37TipoConCod ;
   private String[] P003V8_A41ConDescrip ;
   private String[] P003V8_A26ConCodigo ;
   private short[] P003V9_A1644ConceptoPais ;
   private boolean[] P003V9_n1644ConceptoPais ;
   private int[] P003V9_A3CliCod ;
   private String[] P003V9_A2013ConRelRef ;
   private String[] P003V9_A148ConFormula ;
   private boolean[] P003V9_n148ConFormula ;
   private String[] P003V9_A160ConveDescri ;
   private boolean[] P003V9_n160ConveDescri ;
   private byte[] P003V9_A1827ConBaseOSDif ;
   private byte[] P003V9_A1797ConBaseLicProm ;
   private byte[] P003V9_A1620ConBaseLic ;
   private byte[] P003V9_A1799ConBaseHorExtProm ;
   private byte[] P003V9_A1622ConBaseHorExt ;
   private byte[] P003V9_A1798ConBaseFerProm ;
   private byte[] P003V9_A1621ConBaseFer ;
   private byte[] P003V9_A1801ConBaseAnt ;
   private byte[] P003V9_A1800ConBasePres ;
   private String[] P003V9_A1648ConCodAfip ;
   private byte[] P003V9_A1539ConSacDeven ;
   private String[] P003V9_A953ConCondicion ;
   private boolean[] P003V9_n953ConCondicion ;
   private boolean[] P003V9_A762ConRecalcular ;
   private java.util.Date[] P003V9_A145ConFchModFor ;
   private boolean[] P003V9_n145ConFchModFor ;
   private short[] P003V9_A1112AplIIGG ;
   private boolean[] P003V9_n1112AplIIGG ;
   private String[] P003V9_A153ConObservacion ;
   private boolean[] P003V9_A150ConHabilitado ;
   private boolean[] P003V9_A159ConVariable ;
   private byte[] P003V9_A162ConVigencia ;
   private String[] P003V9_A1645ConceptoConveCodigo ;
   private boolean[] P003V9_n1645ConceptoConveCodigo ;
   private String[] P003V9_A503ConTipoLiqAux ;
   private boolean[] P003V9_n503ConTipoLiqAux ;
   private String[] P003V9_A970ConClasifAux ;
   private boolean[] P003V9_n970ConClasifAux ;
   private String[] P003V9_A37TipoConCod ;
   private String[] P003V9_A41ConDescrip ;
   private String[] P003V9_A26ConCodigo ;
   private GXSimpleCollection<String> AV55TFConCodigo_Sels ;
   private GXSimpleCollection<String> AV70TFTipoConCod_Sels ;
   private GXSimpleCollection<String> AV108TFConceptoConveCodigo_Sels ;
   private GXSimpleCollection<String> AV99TFConCondicion_Sels ;
   private GXSimpleCollection<String> AV111TFConCodAfip_Sels ;
   private GXSimpleCollection<String> AV150Conceptowwds_2_tfconcodigo_sels ;
   private GXSimpleCollection<String> AV153Conceptowwds_5_tftipoconcod_sels ;
   private GXSimpleCollection<String> AV159Conceptowwds_11_tfconceptoconvecodigo_sels ;
   private GXSimpleCollection<String> AV170Conceptowwds_22_tfconcondicion_sels ;
   private GXSimpleCollection<String> AV173Conceptowwds_25_tfconcodafip_sels ;
   private GXSimpleCollection<String> AV40Options ;
   private GXSimpleCollection<String> AV43OptionsDesc ;
   private GXSimpleCollection<String> AV45OptionIndexes ;
   private GXSimpleCollection<String> AV57TFConDescrip_Sels ;
   private GXSimpleCollection<String> AV94TFConClasifAux_Sels ;
   private GXSimpleCollection<String> AV85TFConTipoLiqAux_Sels ;
   private GXSimpleCollection<String> AV61TFConObservacion_Sels ;
   private GXSimpleCollection<String> AV143TFConRelRef_Sels ;
   private GXSimpleCollection<String> AV152Conceptowwds_4_tfcondescrip_sels ;
   private GXSimpleCollection<String> AV155Conceptowwds_7_tfconclasifaux_sels ;
   private GXSimpleCollection<String> AV157Conceptowwds_9_tfcontipoliqaux_sels ;
   private GXSimpleCollection<String> AV165Conceptowwds_17_tfconobservacion_sels ;
   private GXSimpleCollection<String> AV184Conceptowwds_36_tfconrelref_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV50GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV51GridStateFilterValue ;
}

final  class conceptowwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P003V2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV150Conceptowwds_2_tfconcodigo_sels ,
                                          String A41ConDescrip ,
                                          GXSimpleCollection<String> AV152Conceptowwds_4_tfcondescrip_sels ,
                                          String A37TipoConCod ,
                                          GXSimpleCollection<String> AV153Conceptowwds_5_tftipoconcod_sels ,
                                          String A970ConClasifAux ,
                                          GXSimpleCollection<String> AV155Conceptowwds_7_tfconclasifaux_sels ,
                                          String A503ConTipoLiqAux ,
                                          GXSimpleCollection<String> AV157Conceptowwds_9_tfcontipoliqaux_sels ,
                                          String A1645ConceptoConveCodigo ,
                                          GXSimpleCollection<String> AV159Conceptowwds_11_tfconceptoconvecodigo_sels ,
                                          byte A162ConVigencia ,
                                          GXSimpleCollection<Byte> AV160Conceptowwds_12_tfconvigencia_sels ,
                                          String A153ConObservacion ,
                                          GXSimpleCollection<String> AV165Conceptowwds_17_tfconobservacion_sels ,
                                          short A1112AplIIGG ,
                                          GXSimpleCollection<Short> AV166Conceptowwds_18_tfapliigg_sels ,
                                          String A953ConCondicion ,
                                          GXSimpleCollection<String> AV170Conceptowwds_22_tfconcondicion_sels ,
                                          byte A1539ConSacDeven ,
                                          GXSimpleCollection<Byte> AV171Conceptowwds_23_tfconsacdeven_sels ,
                                          String A1648ConCodAfip ,
                                          GXSimpleCollection<String> AV173Conceptowwds_25_tfconcodafip_sels ,
                                          byte A1800ConBasePres ,
                                          GXSimpleCollection<Byte> AV174Conceptowwds_26_tfconbasepres_sels ,
                                          byte A1801ConBaseAnt ,
                                          GXSimpleCollection<Byte> AV175Conceptowwds_27_tfconbaseant_sels ,
                                          byte A1621ConBaseFer ,
                                          GXSimpleCollection<Byte> AV176Conceptowwds_28_tfconbasefer_sels ,
                                          byte A1798ConBaseFerProm ,
                                          GXSimpleCollection<Byte> AV177Conceptowwds_29_tfconbaseferprom_sels ,
                                          byte A1622ConBaseHorExt ,
                                          GXSimpleCollection<Byte> AV178Conceptowwds_30_tfconbasehorext_sels ,
                                          byte A1799ConBaseHorExtProm ,
                                          GXSimpleCollection<Byte> AV179Conceptowwds_31_tfconbasehorextprom_sels ,
                                          byte A1620ConBaseLic ,
                                          GXSimpleCollection<Byte> AV180Conceptowwds_32_tfconbaselic_sels ,
                                          byte A1797ConBaseLicProm ,
                                          GXSimpleCollection<Byte> AV181Conceptowwds_33_tfconbaselicprom_sels ,
                                          byte A1827ConBaseOSDif ,
                                          GXSimpleCollection<Byte> AV182Conceptowwds_34_tfconbaseosdif_sels ,
                                          String A2013ConRelRef ,
                                          GXSimpleCollection<String> AV184Conceptowwds_36_tfconrelref_sels ,
                                          int AV150Conceptowwds_2_tfconcodigo_sels_size ,
                                          String AV149Conceptowwds_1_tfconcodigo ,
                                          int AV152Conceptowwds_4_tfcondescrip_sels_size ,
                                          String AV151Conceptowwds_3_tfcondescrip ,
                                          int AV153Conceptowwds_5_tftipoconcod_sels_size ,
                                          int AV155Conceptowwds_7_tfconclasifaux_sels_size ,
                                          String AV154Conceptowwds_6_tfconclasifaux ,
                                          int AV157Conceptowwds_9_tfcontipoliqaux_sels_size ,
                                          String AV156Conceptowwds_8_tfcontipoliqaux ,
                                          int AV159Conceptowwds_11_tfconceptoconvecodigo_sels_size ,
                                          String AV158Conceptowwds_10_tfconceptoconvecodigo ,
                                          int AV160Conceptowwds_12_tfconvigencia_sels_size ,
                                          byte AV161Conceptowwds_13_tfconvariable_sel ,
                                          byte AV163Conceptowwds_15_tfconhabilitado_sel ,
                                          int AV165Conceptowwds_17_tfconobservacion_sels_size ,
                                          String AV164Conceptowwds_16_tfconobservacion ,
                                          int AV166Conceptowwds_18_tfapliigg_sels_size ,
                                          java.util.Date AV167Conceptowwds_19_tfconfchmodfor ,
                                          java.util.Date AV168Conceptowwds_20_tfconfchmodfor_to ,
                                          byte AV169Conceptowwds_21_tfconrecalcular_sel ,
                                          int AV170Conceptowwds_22_tfconcondicion_sels_size ,
                                          int AV171Conceptowwds_23_tfconsacdeven_sels_size ,
                                          int AV173Conceptowwds_25_tfconcodafip_sels_size ,
                                          String AV172Conceptowwds_24_tfconcodafip ,
                                          int AV174Conceptowwds_26_tfconbasepres_sels_size ,
                                          int AV175Conceptowwds_27_tfconbaseant_sels_size ,
                                          int AV176Conceptowwds_28_tfconbasefer_sels_size ,
                                          int AV177Conceptowwds_29_tfconbaseferprom_sels_size ,
                                          int AV178Conceptowwds_30_tfconbasehorext_sels_size ,
                                          int AV179Conceptowwds_31_tfconbasehorextprom_sels_size ,
                                          int AV180Conceptowwds_32_tfconbaselic_sels_size ,
                                          int AV181Conceptowwds_33_tfconbaselicprom_sels_size ,
                                          int AV182Conceptowwds_34_tfconbaseosdif_sels_size ,
                                          int AV184Conceptowwds_36_tfconrelref_sels_size ,
                                          String AV183Conceptowwds_35_tfconrelref ,
                                          String AV25TFConFormula ,
                                          String A160ConveDescri ,
                                          boolean A159ConVariable ,
                                          boolean A150ConHabilitado ,
                                          java.util.Date A145ConFchModFor ,
                                          boolean A762ConRecalcular ,
                                          String A148ConFormula ,
                                          int AV64CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[12];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT T1.ConceptoPais AS ConceptoPais, T1.CliCod, T1.ConCodigo, T1.ConFormula, T2.ConveDescri, T1.ConRelRef, T1.ConBaseOSDif, T1.ConBaseLicProm, T1.ConBaseLic," ;
      scmdbuf += " T1.ConBaseHorExtProm, T1.ConBaseHorExt, T1.ConBaseFerProm, T1.ConBaseFer, T1.ConBaseAnt, T1.ConBasePres, T1.ConCodAfip, T1.ConSacDeven, T1.ConCondicion, T1.ConRecalcular," ;
      scmdbuf += " T1.ConFchModFor, T1.AplIIGG, T1.ConObservacion, T1.ConHabilitado, T1.ConVariable, T1.ConVigencia, T1.ConceptoConveCodigo AS ConceptoConveCodigo, T1.ConTipoLiqAux," ;
      scmdbuf += " T1.ConClasifAux, T1.TipoConCod, T1.ConDescrip FROM (Concepto T1 LEFT JOIN Convenio T2 ON T2.PaiCod = T1.ConceptoPais AND T2.ConveCodigo = T1.ConceptoConveCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      if ( ( AV150Conceptowwds_2_tfconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV149Conceptowwds_1_tfconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV150Conceptowwds_2_tfconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV150Conceptowwds_2_tfconcodigo_sels, "T1.ConCodigo IN (", ")")+")");
      }
      if ( ( AV152Conceptowwds_4_tfcondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV151Conceptowwds_3_tfcondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV152Conceptowwds_4_tfcondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV152Conceptowwds_4_tfcondescrip_sels, "T1.ConDescrip IN (", ")")+")");
      }
      if ( AV153Conceptowwds_5_tftipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV153Conceptowwds_5_tftipoconcod_sels, "T1.TipoConCod IN (", ")")+")");
      }
      if ( ( AV155Conceptowwds_7_tfconclasifaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV154Conceptowwds_6_tfconclasifaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConClasifAux) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV155Conceptowwds_7_tfconclasifaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV155Conceptowwds_7_tfconclasifaux_sels, "T1.ConClasifAux IN (", ")")+")");
      }
      if ( ( AV157Conceptowwds_9_tfcontipoliqaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV156Conceptowwds_8_tfcontipoliqaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConTipoLiqAux) like LOWER(?))");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( AV157Conceptowwds_9_tfcontipoliqaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV157Conceptowwds_9_tfcontipoliqaux_sels, "T1.ConTipoLiqAux IN (", ")")+")");
      }
      if ( ( AV159Conceptowwds_11_tfconceptoconvecodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV158Conceptowwds_10_tfconceptoconvecodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.ConveDescri) like LOWER(?))");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( AV159Conceptowwds_11_tfconceptoconvecodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV159Conceptowwds_11_tfconceptoconvecodigo_sels, "T1.ConceptoConveCodigo IN (", ")")+")");
      }
      if ( AV160Conceptowwds_12_tfconvigencia_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV160Conceptowwds_12_tfconvigencia_sels, "T1.ConVigencia IN (", ")")+")");
      }
      if ( AV161Conceptowwds_13_tfconvariable_sel == 1 )
      {
         addWhere(sWhereString, "(T1.ConVariable = TRUE)");
      }
      if ( AV161Conceptowwds_13_tfconvariable_sel == 2 )
      {
         addWhere(sWhereString, "(T1.ConVariable = FALSE)");
      }
      if ( AV163Conceptowwds_15_tfconhabilitado_sel == 1 )
      {
         addWhere(sWhereString, "(T1.ConHabilitado = TRUE)");
      }
      if ( AV163Conceptowwds_15_tfconhabilitado_sel == 2 )
      {
         addWhere(sWhereString, "(T1.ConHabilitado = FALSE)");
      }
      if ( ( AV165Conceptowwds_17_tfconobservacion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV164Conceptowwds_16_tfconobservacion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConObservacion) like LOWER(?))");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( AV165Conceptowwds_17_tfconobservacion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV165Conceptowwds_17_tfconobservacion_sels, "T1.ConObservacion IN (", ")")+")");
      }
      if ( AV166Conceptowwds_18_tfapliigg_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV166Conceptowwds_18_tfapliigg_sels, "T1.AplIIGG IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV167Conceptowwds_19_tfconfchmodfor) )
      {
         addWhere(sWhereString, "(T1.ConFchModFor >= ?)");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV168Conceptowwds_20_tfconfchmodfor_to) )
      {
         addWhere(sWhereString, "(T1.ConFchModFor <= ?)");
      }
      else
      {
         GXv_int8[8] = (byte)(1) ;
      }
      if ( AV169Conceptowwds_21_tfconrecalcular_sel == 1 )
      {
         addWhere(sWhereString, "(T1.ConRecalcular = TRUE)");
      }
      if ( AV169Conceptowwds_21_tfconrecalcular_sel == 2 )
      {
         addWhere(sWhereString, "(T1.ConRecalcular = FALSE)");
      }
      if ( AV170Conceptowwds_22_tfconcondicion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV170Conceptowwds_22_tfconcondicion_sels, "T1.ConCondicion IN (", ")")+")");
      }
      if ( AV171Conceptowwds_23_tfconsacdeven_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV171Conceptowwds_23_tfconsacdeven_sels, "T1.ConSacDeven IN (", ")")+")");
      }
      if ( ( AV173Conceptowwds_25_tfconcodafip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV172Conceptowwds_24_tfconcodafip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConCodAfip) like LOWER(?))");
      }
      else
      {
         GXv_int8[9] = (byte)(1) ;
      }
      if ( AV173Conceptowwds_25_tfconcodafip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV173Conceptowwds_25_tfconcodafip_sels, "T1.ConCodAfip IN (", ")")+")");
      }
      if ( AV174Conceptowwds_26_tfconbasepres_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV174Conceptowwds_26_tfconbasepres_sels, "T1.ConBasePres IN (", ")")+")");
      }
      if ( AV175Conceptowwds_27_tfconbaseant_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV175Conceptowwds_27_tfconbaseant_sels, "T1.ConBaseAnt IN (", ")")+")");
      }
      if ( AV176Conceptowwds_28_tfconbasefer_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV176Conceptowwds_28_tfconbasefer_sels, "T1.ConBaseFer IN (", ")")+")");
      }
      if ( AV177Conceptowwds_29_tfconbaseferprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV177Conceptowwds_29_tfconbaseferprom_sels, "T1.ConBaseFerProm IN (", ")")+")");
      }
      if ( AV178Conceptowwds_30_tfconbasehorext_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV178Conceptowwds_30_tfconbasehorext_sels, "T1.ConBaseHorExt IN (", ")")+")");
      }
      if ( AV179Conceptowwds_31_tfconbasehorextprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV179Conceptowwds_31_tfconbasehorextprom_sels, "T1.ConBaseHorExtProm IN (", ")")+")");
      }
      if ( AV180Conceptowwds_32_tfconbaselic_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV180Conceptowwds_32_tfconbaselic_sels, "T1.ConBaseLic IN (", ")")+")");
      }
      if ( AV181Conceptowwds_33_tfconbaselicprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV181Conceptowwds_33_tfconbaselicprom_sels, "T1.ConBaseLicProm IN (", ")")+")");
      }
      if ( AV182Conceptowwds_34_tfconbaseosdif_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV182Conceptowwds_34_tfconbaseosdif_sels, "T1.ConBaseOSDif IN (", ")")+")");
      }
      if ( ( AV184Conceptowwds_36_tfconrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV183Conceptowwds_35_tfconrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int8[10] = (byte)(1) ;
      }
      if ( AV184Conceptowwds_36_tfconrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV184Conceptowwds_36_tfconrelref_sels, "T1.ConRelRef IN (", ")")+")");
      }
      if ( ! (GXutil.strcmp("", AV25TFConFormula)==0) )
      {
         addWhere(sWhereString, "(T1.ConFormula like ?)");
      }
      else
      {
         GXv_int8[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.ConCodigo" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P003V3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV150Conceptowwds_2_tfconcodigo_sels ,
                                          String A41ConDescrip ,
                                          GXSimpleCollection<String> AV152Conceptowwds_4_tfcondescrip_sels ,
                                          String A37TipoConCod ,
                                          GXSimpleCollection<String> AV153Conceptowwds_5_tftipoconcod_sels ,
                                          String A970ConClasifAux ,
                                          GXSimpleCollection<String> AV155Conceptowwds_7_tfconclasifaux_sels ,
                                          String A503ConTipoLiqAux ,
                                          GXSimpleCollection<String> AV157Conceptowwds_9_tfcontipoliqaux_sels ,
                                          String A1645ConceptoConveCodigo ,
                                          GXSimpleCollection<String> AV159Conceptowwds_11_tfconceptoconvecodigo_sels ,
                                          byte A162ConVigencia ,
                                          GXSimpleCollection<Byte> AV160Conceptowwds_12_tfconvigencia_sels ,
                                          String A153ConObservacion ,
                                          GXSimpleCollection<String> AV165Conceptowwds_17_tfconobservacion_sels ,
                                          short A1112AplIIGG ,
                                          GXSimpleCollection<Short> AV166Conceptowwds_18_tfapliigg_sels ,
                                          String A953ConCondicion ,
                                          GXSimpleCollection<String> AV170Conceptowwds_22_tfconcondicion_sels ,
                                          byte A1539ConSacDeven ,
                                          GXSimpleCollection<Byte> AV171Conceptowwds_23_tfconsacdeven_sels ,
                                          String A1648ConCodAfip ,
                                          GXSimpleCollection<String> AV173Conceptowwds_25_tfconcodafip_sels ,
                                          byte A1800ConBasePres ,
                                          GXSimpleCollection<Byte> AV174Conceptowwds_26_tfconbasepres_sels ,
                                          byte A1801ConBaseAnt ,
                                          GXSimpleCollection<Byte> AV175Conceptowwds_27_tfconbaseant_sels ,
                                          byte A1621ConBaseFer ,
                                          GXSimpleCollection<Byte> AV176Conceptowwds_28_tfconbasefer_sels ,
                                          byte A1798ConBaseFerProm ,
                                          GXSimpleCollection<Byte> AV177Conceptowwds_29_tfconbaseferprom_sels ,
                                          byte A1622ConBaseHorExt ,
                                          GXSimpleCollection<Byte> AV178Conceptowwds_30_tfconbasehorext_sels ,
                                          byte A1799ConBaseHorExtProm ,
                                          GXSimpleCollection<Byte> AV179Conceptowwds_31_tfconbasehorextprom_sels ,
                                          byte A1620ConBaseLic ,
                                          GXSimpleCollection<Byte> AV180Conceptowwds_32_tfconbaselic_sels ,
                                          byte A1797ConBaseLicProm ,
                                          GXSimpleCollection<Byte> AV181Conceptowwds_33_tfconbaselicprom_sels ,
                                          byte A1827ConBaseOSDif ,
                                          GXSimpleCollection<Byte> AV182Conceptowwds_34_tfconbaseosdif_sels ,
                                          String A2013ConRelRef ,
                                          GXSimpleCollection<String> AV184Conceptowwds_36_tfconrelref_sels ,
                                          int AV150Conceptowwds_2_tfconcodigo_sels_size ,
                                          String AV149Conceptowwds_1_tfconcodigo ,
                                          int AV152Conceptowwds_4_tfcondescrip_sels_size ,
                                          String AV151Conceptowwds_3_tfcondescrip ,
                                          int AV153Conceptowwds_5_tftipoconcod_sels_size ,
                                          int AV155Conceptowwds_7_tfconclasifaux_sels_size ,
                                          String AV154Conceptowwds_6_tfconclasifaux ,
                                          int AV157Conceptowwds_9_tfcontipoliqaux_sels_size ,
                                          String AV156Conceptowwds_8_tfcontipoliqaux ,
                                          int AV159Conceptowwds_11_tfconceptoconvecodigo_sels_size ,
                                          String AV158Conceptowwds_10_tfconceptoconvecodigo ,
                                          int AV160Conceptowwds_12_tfconvigencia_sels_size ,
                                          byte AV161Conceptowwds_13_tfconvariable_sel ,
                                          byte AV163Conceptowwds_15_tfconhabilitado_sel ,
                                          int AV165Conceptowwds_17_tfconobservacion_sels_size ,
                                          String AV164Conceptowwds_16_tfconobservacion ,
                                          int AV166Conceptowwds_18_tfapliigg_sels_size ,
                                          java.util.Date AV167Conceptowwds_19_tfconfchmodfor ,
                                          java.util.Date AV168Conceptowwds_20_tfconfchmodfor_to ,
                                          byte AV169Conceptowwds_21_tfconrecalcular_sel ,
                                          int AV170Conceptowwds_22_tfconcondicion_sels_size ,
                                          int AV171Conceptowwds_23_tfconsacdeven_sels_size ,
                                          int AV173Conceptowwds_25_tfconcodafip_sels_size ,
                                          String AV172Conceptowwds_24_tfconcodafip ,
                                          int AV174Conceptowwds_26_tfconbasepres_sels_size ,
                                          int AV175Conceptowwds_27_tfconbaseant_sels_size ,
                                          int AV176Conceptowwds_28_tfconbasefer_sels_size ,
                                          int AV177Conceptowwds_29_tfconbaseferprom_sels_size ,
                                          int AV178Conceptowwds_30_tfconbasehorext_sels_size ,
                                          int AV179Conceptowwds_31_tfconbasehorextprom_sels_size ,
                                          int AV180Conceptowwds_32_tfconbaselic_sels_size ,
                                          int AV181Conceptowwds_33_tfconbaselicprom_sels_size ,
                                          int AV182Conceptowwds_34_tfconbaseosdif_sels_size ,
                                          int AV184Conceptowwds_36_tfconrelref_sels_size ,
                                          String AV183Conceptowwds_35_tfconrelref ,
                                          String AV25TFConFormula ,
                                          String A160ConveDescri ,
                                          boolean A159ConVariable ,
                                          boolean A150ConHabilitado ,
                                          java.util.Date A145ConFchModFor ,
                                          boolean A762ConRecalcular ,
                                          String A148ConFormula ,
                                          int AV64CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[12];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT T1.ConceptoPais AS ConceptoPais, T1.CliCod, T1.ConDescrip, T1.ConFormula, T2.ConveDescri, T1.ConRelRef, T1.ConBaseOSDif, T1.ConBaseLicProm, T1.ConBaseLic," ;
      scmdbuf += " T1.ConBaseHorExtProm, T1.ConBaseHorExt, T1.ConBaseFerProm, T1.ConBaseFer, T1.ConBaseAnt, T1.ConBasePres, T1.ConCodAfip, T1.ConSacDeven, T1.ConCondicion, T1.ConRecalcular," ;
      scmdbuf += " T1.ConFchModFor, T1.AplIIGG, T1.ConObservacion, T1.ConHabilitado, T1.ConVariable, T1.ConVigencia, T1.ConceptoConveCodigo AS ConceptoConveCodigo, T1.ConTipoLiqAux," ;
      scmdbuf += " T1.ConClasifAux, T1.TipoConCod, T1.ConCodigo FROM (Concepto T1 LEFT JOIN Convenio T2 ON T2.PaiCod = T1.ConceptoPais AND T2.ConveCodigo = T1.ConceptoConveCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      if ( ( AV150Conceptowwds_2_tfconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV149Conceptowwds_1_tfconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV150Conceptowwds_2_tfconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV150Conceptowwds_2_tfconcodigo_sels, "T1.ConCodigo IN (", ")")+")");
      }
      if ( ( AV152Conceptowwds_4_tfcondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV151Conceptowwds_3_tfcondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV152Conceptowwds_4_tfcondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV152Conceptowwds_4_tfcondescrip_sels, "T1.ConDescrip IN (", ")")+")");
      }
      if ( AV153Conceptowwds_5_tftipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV153Conceptowwds_5_tftipoconcod_sels, "T1.TipoConCod IN (", ")")+")");
      }
      if ( ( AV155Conceptowwds_7_tfconclasifaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV154Conceptowwds_6_tfconclasifaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConClasifAux) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV155Conceptowwds_7_tfconclasifaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV155Conceptowwds_7_tfconclasifaux_sels, "T1.ConClasifAux IN (", ")")+")");
      }
      if ( ( AV157Conceptowwds_9_tfcontipoliqaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV156Conceptowwds_8_tfcontipoliqaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConTipoLiqAux) like LOWER(?))");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( AV157Conceptowwds_9_tfcontipoliqaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV157Conceptowwds_9_tfcontipoliqaux_sels, "T1.ConTipoLiqAux IN (", ")")+")");
      }
      if ( ( AV159Conceptowwds_11_tfconceptoconvecodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV158Conceptowwds_10_tfconceptoconvecodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.ConveDescri) like LOWER(?))");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( AV159Conceptowwds_11_tfconceptoconvecodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV159Conceptowwds_11_tfconceptoconvecodigo_sels, "T1.ConceptoConveCodigo IN (", ")")+")");
      }
      if ( AV160Conceptowwds_12_tfconvigencia_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV160Conceptowwds_12_tfconvigencia_sels, "T1.ConVigencia IN (", ")")+")");
      }
      if ( AV161Conceptowwds_13_tfconvariable_sel == 1 )
      {
         addWhere(sWhereString, "(T1.ConVariable = TRUE)");
      }
      if ( AV161Conceptowwds_13_tfconvariable_sel == 2 )
      {
         addWhere(sWhereString, "(T1.ConVariable = FALSE)");
      }
      if ( AV163Conceptowwds_15_tfconhabilitado_sel == 1 )
      {
         addWhere(sWhereString, "(T1.ConHabilitado = TRUE)");
      }
      if ( AV163Conceptowwds_15_tfconhabilitado_sel == 2 )
      {
         addWhere(sWhereString, "(T1.ConHabilitado = FALSE)");
      }
      if ( ( AV165Conceptowwds_17_tfconobservacion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV164Conceptowwds_16_tfconobservacion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConObservacion) like LOWER(?))");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( AV165Conceptowwds_17_tfconobservacion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV165Conceptowwds_17_tfconobservacion_sels, "T1.ConObservacion IN (", ")")+")");
      }
      if ( AV166Conceptowwds_18_tfapliigg_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV166Conceptowwds_18_tfapliigg_sels, "T1.AplIIGG IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV167Conceptowwds_19_tfconfchmodfor) )
      {
         addWhere(sWhereString, "(T1.ConFchModFor >= ?)");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV168Conceptowwds_20_tfconfchmodfor_to) )
      {
         addWhere(sWhereString, "(T1.ConFchModFor <= ?)");
      }
      else
      {
         GXv_int11[8] = (byte)(1) ;
      }
      if ( AV169Conceptowwds_21_tfconrecalcular_sel == 1 )
      {
         addWhere(sWhereString, "(T1.ConRecalcular = TRUE)");
      }
      if ( AV169Conceptowwds_21_tfconrecalcular_sel == 2 )
      {
         addWhere(sWhereString, "(T1.ConRecalcular = FALSE)");
      }
      if ( AV170Conceptowwds_22_tfconcondicion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV170Conceptowwds_22_tfconcondicion_sels, "T1.ConCondicion IN (", ")")+")");
      }
      if ( AV171Conceptowwds_23_tfconsacdeven_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV171Conceptowwds_23_tfconsacdeven_sels, "T1.ConSacDeven IN (", ")")+")");
      }
      if ( ( AV173Conceptowwds_25_tfconcodafip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV172Conceptowwds_24_tfconcodafip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConCodAfip) like LOWER(?))");
      }
      else
      {
         GXv_int11[9] = (byte)(1) ;
      }
      if ( AV173Conceptowwds_25_tfconcodafip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV173Conceptowwds_25_tfconcodafip_sels, "T1.ConCodAfip IN (", ")")+")");
      }
      if ( AV174Conceptowwds_26_tfconbasepres_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV174Conceptowwds_26_tfconbasepres_sels, "T1.ConBasePres IN (", ")")+")");
      }
      if ( AV175Conceptowwds_27_tfconbaseant_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV175Conceptowwds_27_tfconbaseant_sels, "T1.ConBaseAnt IN (", ")")+")");
      }
      if ( AV176Conceptowwds_28_tfconbasefer_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV176Conceptowwds_28_tfconbasefer_sels, "T1.ConBaseFer IN (", ")")+")");
      }
      if ( AV177Conceptowwds_29_tfconbaseferprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV177Conceptowwds_29_tfconbaseferprom_sels, "T1.ConBaseFerProm IN (", ")")+")");
      }
      if ( AV178Conceptowwds_30_tfconbasehorext_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV178Conceptowwds_30_tfconbasehorext_sels, "T1.ConBaseHorExt IN (", ")")+")");
      }
      if ( AV179Conceptowwds_31_tfconbasehorextprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV179Conceptowwds_31_tfconbasehorextprom_sels, "T1.ConBaseHorExtProm IN (", ")")+")");
      }
      if ( AV180Conceptowwds_32_tfconbaselic_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV180Conceptowwds_32_tfconbaselic_sels, "T1.ConBaseLic IN (", ")")+")");
      }
      if ( AV181Conceptowwds_33_tfconbaselicprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV181Conceptowwds_33_tfconbaselicprom_sels, "T1.ConBaseLicProm IN (", ")")+")");
      }
      if ( AV182Conceptowwds_34_tfconbaseosdif_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV182Conceptowwds_34_tfconbaseosdif_sels, "T1.ConBaseOSDif IN (", ")")+")");
      }
      if ( ( AV184Conceptowwds_36_tfconrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV183Conceptowwds_35_tfconrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int11[10] = (byte)(1) ;
      }
      if ( AV184Conceptowwds_36_tfconrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV184Conceptowwds_36_tfconrelref_sels, "T1.ConRelRef IN (", ")")+")");
      }
      if ( ! (GXutil.strcmp("", AV25TFConFormula)==0) )
      {
         addWhere(sWhereString, "(T1.ConFormula like ?)");
      }
      else
      {
         GXv_int11[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.ConDescrip" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P003V4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV150Conceptowwds_2_tfconcodigo_sels ,
                                          String A41ConDescrip ,
                                          GXSimpleCollection<String> AV152Conceptowwds_4_tfcondescrip_sels ,
                                          String A37TipoConCod ,
                                          GXSimpleCollection<String> AV153Conceptowwds_5_tftipoconcod_sels ,
                                          String A970ConClasifAux ,
                                          GXSimpleCollection<String> AV155Conceptowwds_7_tfconclasifaux_sels ,
                                          String A503ConTipoLiqAux ,
                                          GXSimpleCollection<String> AV157Conceptowwds_9_tfcontipoliqaux_sels ,
                                          String A1645ConceptoConveCodigo ,
                                          GXSimpleCollection<String> AV159Conceptowwds_11_tfconceptoconvecodigo_sels ,
                                          byte A162ConVigencia ,
                                          GXSimpleCollection<Byte> AV160Conceptowwds_12_tfconvigencia_sels ,
                                          String A153ConObservacion ,
                                          GXSimpleCollection<String> AV165Conceptowwds_17_tfconobservacion_sels ,
                                          short A1112AplIIGG ,
                                          GXSimpleCollection<Short> AV166Conceptowwds_18_tfapliigg_sels ,
                                          String A953ConCondicion ,
                                          GXSimpleCollection<String> AV170Conceptowwds_22_tfconcondicion_sels ,
                                          byte A1539ConSacDeven ,
                                          GXSimpleCollection<Byte> AV171Conceptowwds_23_tfconsacdeven_sels ,
                                          String A1648ConCodAfip ,
                                          GXSimpleCollection<String> AV173Conceptowwds_25_tfconcodafip_sels ,
                                          byte A1800ConBasePres ,
                                          GXSimpleCollection<Byte> AV174Conceptowwds_26_tfconbasepres_sels ,
                                          byte A1801ConBaseAnt ,
                                          GXSimpleCollection<Byte> AV175Conceptowwds_27_tfconbaseant_sels ,
                                          byte A1621ConBaseFer ,
                                          GXSimpleCollection<Byte> AV176Conceptowwds_28_tfconbasefer_sels ,
                                          byte A1798ConBaseFerProm ,
                                          GXSimpleCollection<Byte> AV177Conceptowwds_29_tfconbaseferprom_sels ,
                                          byte A1622ConBaseHorExt ,
                                          GXSimpleCollection<Byte> AV178Conceptowwds_30_tfconbasehorext_sels ,
                                          byte A1799ConBaseHorExtProm ,
                                          GXSimpleCollection<Byte> AV179Conceptowwds_31_tfconbasehorextprom_sels ,
                                          byte A1620ConBaseLic ,
                                          GXSimpleCollection<Byte> AV180Conceptowwds_32_tfconbaselic_sels ,
                                          byte A1797ConBaseLicProm ,
                                          GXSimpleCollection<Byte> AV181Conceptowwds_33_tfconbaselicprom_sels ,
                                          byte A1827ConBaseOSDif ,
                                          GXSimpleCollection<Byte> AV182Conceptowwds_34_tfconbaseosdif_sels ,
                                          String A2013ConRelRef ,
                                          GXSimpleCollection<String> AV184Conceptowwds_36_tfconrelref_sels ,
                                          int AV150Conceptowwds_2_tfconcodigo_sels_size ,
                                          String AV149Conceptowwds_1_tfconcodigo ,
                                          int AV152Conceptowwds_4_tfcondescrip_sels_size ,
                                          String AV151Conceptowwds_3_tfcondescrip ,
                                          int AV153Conceptowwds_5_tftipoconcod_sels_size ,
                                          int AV155Conceptowwds_7_tfconclasifaux_sels_size ,
                                          String AV154Conceptowwds_6_tfconclasifaux ,
                                          int AV157Conceptowwds_9_tfcontipoliqaux_sels_size ,
                                          String AV156Conceptowwds_8_tfcontipoliqaux ,
                                          int AV159Conceptowwds_11_tfconceptoconvecodigo_sels_size ,
                                          String AV158Conceptowwds_10_tfconceptoconvecodigo ,
                                          int AV160Conceptowwds_12_tfconvigencia_sels_size ,
                                          byte AV161Conceptowwds_13_tfconvariable_sel ,
                                          byte AV163Conceptowwds_15_tfconhabilitado_sel ,
                                          int AV165Conceptowwds_17_tfconobservacion_sels_size ,
                                          String AV164Conceptowwds_16_tfconobservacion ,
                                          int AV166Conceptowwds_18_tfapliigg_sels_size ,
                                          java.util.Date AV167Conceptowwds_19_tfconfchmodfor ,
                                          java.util.Date AV168Conceptowwds_20_tfconfchmodfor_to ,
                                          byte AV169Conceptowwds_21_tfconrecalcular_sel ,
                                          int AV170Conceptowwds_22_tfconcondicion_sels_size ,
                                          int AV171Conceptowwds_23_tfconsacdeven_sels_size ,
                                          int AV173Conceptowwds_25_tfconcodafip_sels_size ,
                                          String AV172Conceptowwds_24_tfconcodafip ,
                                          int AV174Conceptowwds_26_tfconbasepres_sels_size ,
                                          int AV175Conceptowwds_27_tfconbaseant_sels_size ,
                                          int AV176Conceptowwds_28_tfconbasefer_sels_size ,
                                          int AV177Conceptowwds_29_tfconbaseferprom_sels_size ,
                                          int AV178Conceptowwds_30_tfconbasehorext_sels_size ,
                                          int AV179Conceptowwds_31_tfconbasehorextprom_sels_size ,
                                          int AV180Conceptowwds_32_tfconbaselic_sels_size ,
                                          int AV181Conceptowwds_33_tfconbaselicprom_sels_size ,
                                          int AV182Conceptowwds_34_tfconbaseosdif_sels_size ,
                                          int AV184Conceptowwds_36_tfconrelref_sels_size ,
                                          String AV183Conceptowwds_35_tfconrelref ,
                                          String AV25TFConFormula ,
                                          String A160ConveDescri ,
                                          boolean A159ConVariable ,
                                          boolean A150ConHabilitado ,
                                          java.util.Date A145ConFchModFor ,
                                          boolean A762ConRecalcular ,
                                          String A148ConFormula ,
                                          int A3CliCod ,
                                          int AV64CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[12];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT T1.ConceptoPais AS ConceptoPais, T1.CliCod, T1.ConClasifAux, T1.ConFormula, T2.ConveDescri, T1.ConRelRef, T1.ConBaseOSDif, T1.ConBaseLicProm, T1.ConBaseLic," ;
      scmdbuf += " T1.ConBaseHorExtProm, T1.ConBaseHorExt, T1.ConBaseFerProm, T1.ConBaseFer, T1.ConBaseAnt, T1.ConBasePres, T1.ConCodAfip, T1.ConSacDeven, T1.ConCondicion, T1.ConRecalcular," ;
      scmdbuf += " T1.ConFchModFor, T1.AplIIGG, T1.ConObservacion, T1.ConHabilitado, T1.ConVariable, T1.ConVigencia, T1.ConceptoConveCodigo AS ConceptoConveCodigo, T1.ConTipoLiqAux," ;
      scmdbuf += " T1.TipoConCod, T1.ConDescrip, T1.ConCodigo FROM (Concepto T1 LEFT JOIN Convenio T2 ON T2.PaiCod = T1.ConceptoPais AND T2.ConveCodigo = T1.ConceptoConveCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      if ( ( AV150Conceptowwds_2_tfconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV149Conceptowwds_1_tfconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int14[1] = (byte)(1) ;
      }
      if ( AV150Conceptowwds_2_tfconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV150Conceptowwds_2_tfconcodigo_sels, "T1.ConCodigo IN (", ")")+")");
      }
      if ( ( AV152Conceptowwds_4_tfcondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV151Conceptowwds_3_tfcondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( AV152Conceptowwds_4_tfcondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV152Conceptowwds_4_tfcondescrip_sels, "T1.ConDescrip IN (", ")")+")");
      }
      if ( AV153Conceptowwds_5_tftipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV153Conceptowwds_5_tftipoconcod_sels, "T1.TipoConCod IN (", ")")+")");
      }
      if ( ( AV155Conceptowwds_7_tfconclasifaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV154Conceptowwds_6_tfconclasifaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConClasifAux) like LOWER(?))");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( AV155Conceptowwds_7_tfconclasifaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV155Conceptowwds_7_tfconclasifaux_sels, "T1.ConClasifAux IN (", ")")+")");
      }
      if ( ( AV157Conceptowwds_9_tfcontipoliqaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV156Conceptowwds_8_tfcontipoliqaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConTipoLiqAux) like LOWER(?))");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( AV157Conceptowwds_9_tfcontipoliqaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV157Conceptowwds_9_tfcontipoliqaux_sels, "T1.ConTipoLiqAux IN (", ")")+")");
      }
      if ( ( AV159Conceptowwds_11_tfconceptoconvecodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV158Conceptowwds_10_tfconceptoconvecodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.ConveDescri) like LOWER(?))");
      }
      else
      {
         GXv_int14[5] = (byte)(1) ;
      }
      if ( AV159Conceptowwds_11_tfconceptoconvecodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV159Conceptowwds_11_tfconceptoconvecodigo_sels, "T1.ConceptoConveCodigo IN (", ")")+")");
      }
      if ( AV160Conceptowwds_12_tfconvigencia_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV160Conceptowwds_12_tfconvigencia_sels, "T1.ConVigencia IN (", ")")+")");
      }
      if ( AV161Conceptowwds_13_tfconvariable_sel == 1 )
      {
         addWhere(sWhereString, "(T1.ConVariable = TRUE)");
      }
      if ( AV161Conceptowwds_13_tfconvariable_sel == 2 )
      {
         addWhere(sWhereString, "(T1.ConVariable = FALSE)");
      }
      if ( AV163Conceptowwds_15_tfconhabilitado_sel == 1 )
      {
         addWhere(sWhereString, "(T1.ConHabilitado = TRUE)");
      }
      if ( AV163Conceptowwds_15_tfconhabilitado_sel == 2 )
      {
         addWhere(sWhereString, "(T1.ConHabilitado = FALSE)");
      }
      if ( ( AV165Conceptowwds_17_tfconobservacion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV164Conceptowwds_16_tfconobservacion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConObservacion) like LOWER(?))");
      }
      else
      {
         GXv_int14[6] = (byte)(1) ;
      }
      if ( AV165Conceptowwds_17_tfconobservacion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV165Conceptowwds_17_tfconobservacion_sels, "T1.ConObservacion IN (", ")")+")");
      }
      if ( AV166Conceptowwds_18_tfapliigg_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV166Conceptowwds_18_tfapliigg_sels, "T1.AplIIGG IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV167Conceptowwds_19_tfconfchmodfor) )
      {
         addWhere(sWhereString, "(T1.ConFchModFor >= ?)");
      }
      else
      {
         GXv_int14[7] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV168Conceptowwds_20_tfconfchmodfor_to) )
      {
         addWhere(sWhereString, "(T1.ConFchModFor <= ?)");
      }
      else
      {
         GXv_int14[8] = (byte)(1) ;
      }
      if ( AV169Conceptowwds_21_tfconrecalcular_sel == 1 )
      {
         addWhere(sWhereString, "(T1.ConRecalcular = TRUE)");
      }
      if ( AV169Conceptowwds_21_tfconrecalcular_sel == 2 )
      {
         addWhere(sWhereString, "(T1.ConRecalcular = FALSE)");
      }
      if ( AV170Conceptowwds_22_tfconcondicion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV170Conceptowwds_22_tfconcondicion_sels, "T1.ConCondicion IN (", ")")+")");
      }
      if ( AV171Conceptowwds_23_tfconsacdeven_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV171Conceptowwds_23_tfconsacdeven_sels, "T1.ConSacDeven IN (", ")")+")");
      }
      if ( ( AV173Conceptowwds_25_tfconcodafip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV172Conceptowwds_24_tfconcodafip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConCodAfip) like LOWER(?))");
      }
      else
      {
         GXv_int14[9] = (byte)(1) ;
      }
      if ( AV173Conceptowwds_25_tfconcodafip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV173Conceptowwds_25_tfconcodafip_sels, "T1.ConCodAfip IN (", ")")+")");
      }
      if ( AV174Conceptowwds_26_tfconbasepres_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV174Conceptowwds_26_tfconbasepres_sels, "T1.ConBasePres IN (", ")")+")");
      }
      if ( AV175Conceptowwds_27_tfconbaseant_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV175Conceptowwds_27_tfconbaseant_sels, "T1.ConBaseAnt IN (", ")")+")");
      }
      if ( AV176Conceptowwds_28_tfconbasefer_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV176Conceptowwds_28_tfconbasefer_sels, "T1.ConBaseFer IN (", ")")+")");
      }
      if ( AV177Conceptowwds_29_tfconbaseferprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV177Conceptowwds_29_tfconbaseferprom_sels, "T1.ConBaseFerProm IN (", ")")+")");
      }
      if ( AV178Conceptowwds_30_tfconbasehorext_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV178Conceptowwds_30_tfconbasehorext_sels, "T1.ConBaseHorExt IN (", ")")+")");
      }
      if ( AV179Conceptowwds_31_tfconbasehorextprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV179Conceptowwds_31_tfconbasehorextprom_sels, "T1.ConBaseHorExtProm IN (", ")")+")");
      }
      if ( AV180Conceptowwds_32_tfconbaselic_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV180Conceptowwds_32_tfconbaselic_sels, "T1.ConBaseLic IN (", ")")+")");
      }
      if ( AV181Conceptowwds_33_tfconbaselicprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV181Conceptowwds_33_tfconbaselicprom_sels, "T1.ConBaseLicProm IN (", ")")+")");
      }
      if ( AV182Conceptowwds_34_tfconbaseosdif_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV182Conceptowwds_34_tfconbaseosdif_sels, "T1.ConBaseOSDif IN (", ")")+")");
      }
      if ( ( AV184Conceptowwds_36_tfconrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV183Conceptowwds_35_tfconrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int14[10] = (byte)(1) ;
      }
      if ( AV184Conceptowwds_36_tfconrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV184Conceptowwds_36_tfconrelref_sels, "T1.ConRelRef IN (", ")")+")");
      }
      if ( ! (GXutil.strcmp("", AV25TFConFormula)==0) )
      {
         addWhere(sWhereString, "(T1.ConFormula like ?)");
      }
      else
      {
         GXv_int14[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.ConClasifAux" ;
      GXv_Object15[0] = scmdbuf ;
      GXv_Object15[1] = GXv_int14 ;
      return GXv_Object15 ;
   }

   protected Object[] conditional_P003V5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV150Conceptowwds_2_tfconcodigo_sels ,
                                          String A41ConDescrip ,
                                          GXSimpleCollection<String> AV152Conceptowwds_4_tfcondescrip_sels ,
                                          String A37TipoConCod ,
                                          GXSimpleCollection<String> AV153Conceptowwds_5_tftipoconcod_sels ,
                                          String A970ConClasifAux ,
                                          GXSimpleCollection<String> AV155Conceptowwds_7_tfconclasifaux_sels ,
                                          String A503ConTipoLiqAux ,
                                          GXSimpleCollection<String> AV157Conceptowwds_9_tfcontipoliqaux_sels ,
                                          String A1645ConceptoConveCodigo ,
                                          GXSimpleCollection<String> AV159Conceptowwds_11_tfconceptoconvecodigo_sels ,
                                          byte A162ConVigencia ,
                                          GXSimpleCollection<Byte> AV160Conceptowwds_12_tfconvigencia_sels ,
                                          String A153ConObservacion ,
                                          GXSimpleCollection<String> AV165Conceptowwds_17_tfconobservacion_sels ,
                                          short A1112AplIIGG ,
                                          GXSimpleCollection<Short> AV166Conceptowwds_18_tfapliigg_sels ,
                                          String A953ConCondicion ,
                                          GXSimpleCollection<String> AV170Conceptowwds_22_tfconcondicion_sels ,
                                          byte A1539ConSacDeven ,
                                          GXSimpleCollection<Byte> AV171Conceptowwds_23_tfconsacdeven_sels ,
                                          String A1648ConCodAfip ,
                                          GXSimpleCollection<String> AV173Conceptowwds_25_tfconcodafip_sels ,
                                          byte A1800ConBasePres ,
                                          GXSimpleCollection<Byte> AV174Conceptowwds_26_tfconbasepres_sels ,
                                          byte A1801ConBaseAnt ,
                                          GXSimpleCollection<Byte> AV175Conceptowwds_27_tfconbaseant_sels ,
                                          byte A1621ConBaseFer ,
                                          GXSimpleCollection<Byte> AV176Conceptowwds_28_tfconbasefer_sels ,
                                          byte A1798ConBaseFerProm ,
                                          GXSimpleCollection<Byte> AV177Conceptowwds_29_tfconbaseferprom_sels ,
                                          byte A1622ConBaseHorExt ,
                                          GXSimpleCollection<Byte> AV178Conceptowwds_30_tfconbasehorext_sels ,
                                          byte A1799ConBaseHorExtProm ,
                                          GXSimpleCollection<Byte> AV179Conceptowwds_31_tfconbasehorextprom_sels ,
                                          byte A1620ConBaseLic ,
                                          GXSimpleCollection<Byte> AV180Conceptowwds_32_tfconbaselic_sels ,
                                          byte A1797ConBaseLicProm ,
                                          GXSimpleCollection<Byte> AV181Conceptowwds_33_tfconbaselicprom_sels ,
                                          byte A1827ConBaseOSDif ,
                                          GXSimpleCollection<Byte> AV182Conceptowwds_34_tfconbaseosdif_sels ,
                                          String A2013ConRelRef ,
                                          GXSimpleCollection<String> AV184Conceptowwds_36_tfconrelref_sels ,
                                          int AV150Conceptowwds_2_tfconcodigo_sels_size ,
                                          String AV149Conceptowwds_1_tfconcodigo ,
                                          int AV152Conceptowwds_4_tfcondescrip_sels_size ,
                                          String AV151Conceptowwds_3_tfcondescrip ,
                                          int AV153Conceptowwds_5_tftipoconcod_sels_size ,
                                          int AV155Conceptowwds_7_tfconclasifaux_sels_size ,
                                          String AV154Conceptowwds_6_tfconclasifaux ,
                                          int AV157Conceptowwds_9_tfcontipoliqaux_sels_size ,
                                          String AV156Conceptowwds_8_tfcontipoliqaux ,
                                          int AV159Conceptowwds_11_tfconceptoconvecodigo_sels_size ,
                                          String AV158Conceptowwds_10_tfconceptoconvecodigo ,
                                          int AV160Conceptowwds_12_tfconvigencia_sels_size ,
                                          byte AV161Conceptowwds_13_tfconvariable_sel ,
                                          byte AV163Conceptowwds_15_tfconhabilitado_sel ,
                                          int AV165Conceptowwds_17_tfconobservacion_sels_size ,
                                          String AV164Conceptowwds_16_tfconobservacion ,
                                          int AV166Conceptowwds_18_tfapliigg_sels_size ,
                                          java.util.Date AV167Conceptowwds_19_tfconfchmodfor ,
                                          java.util.Date AV168Conceptowwds_20_tfconfchmodfor_to ,
                                          byte AV169Conceptowwds_21_tfconrecalcular_sel ,
                                          int AV170Conceptowwds_22_tfconcondicion_sels_size ,
                                          int AV171Conceptowwds_23_tfconsacdeven_sels_size ,
                                          int AV173Conceptowwds_25_tfconcodafip_sels_size ,
                                          String AV172Conceptowwds_24_tfconcodafip ,
                                          int AV174Conceptowwds_26_tfconbasepres_sels_size ,
                                          int AV175Conceptowwds_27_tfconbaseant_sels_size ,
                                          int AV176Conceptowwds_28_tfconbasefer_sels_size ,
                                          int AV177Conceptowwds_29_tfconbaseferprom_sels_size ,
                                          int AV178Conceptowwds_30_tfconbasehorext_sels_size ,
                                          int AV179Conceptowwds_31_tfconbasehorextprom_sels_size ,
                                          int AV180Conceptowwds_32_tfconbaselic_sels_size ,
                                          int AV181Conceptowwds_33_tfconbaselicprom_sels_size ,
                                          int AV182Conceptowwds_34_tfconbaseosdif_sels_size ,
                                          int AV184Conceptowwds_36_tfconrelref_sels_size ,
                                          String AV183Conceptowwds_35_tfconrelref ,
                                          String AV25TFConFormula ,
                                          String A160ConveDescri ,
                                          boolean A159ConVariable ,
                                          boolean A150ConHabilitado ,
                                          java.util.Date A145ConFchModFor ,
                                          boolean A762ConRecalcular ,
                                          String A148ConFormula ,
                                          int AV64CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int17 = new byte[12];
      Object[] GXv_Object18 = new Object[2];
      scmdbuf = "SELECT T1.ConceptoPais AS ConceptoPais, T1.CliCod, T1.ConTipoLiqAux, T1.ConFormula, T2.ConveDescri, T1.ConRelRef, T1.ConBaseOSDif, T1.ConBaseLicProm, T1.ConBaseLic," ;
      scmdbuf += " T1.ConBaseHorExtProm, T1.ConBaseHorExt, T1.ConBaseFerProm, T1.ConBaseFer, T1.ConBaseAnt, T1.ConBasePres, T1.ConCodAfip, T1.ConSacDeven, T1.ConCondicion, T1.ConRecalcular," ;
      scmdbuf += " T1.ConFchModFor, T1.AplIIGG, T1.ConObservacion, T1.ConHabilitado, T1.ConVariable, T1.ConVigencia, T1.ConceptoConveCodigo AS ConceptoConveCodigo, T1.ConClasifAux," ;
      scmdbuf += " T1.TipoConCod, T1.ConDescrip, T1.ConCodigo FROM (Concepto T1 LEFT JOIN Convenio T2 ON T2.PaiCod = T1.ConceptoPais AND T2.ConveCodigo = T1.ConceptoConveCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      if ( ( AV150Conceptowwds_2_tfconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV149Conceptowwds_1_tfconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int17[1] = (byte)(1) ;
      }
      if ( AV150Conceptowwds_2_tfconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV150Conceptowwds_2_tfconcodigo_sels, "T1.ConCodigo IN (", ")")+")");
      }
      if ( ( AV152Conceptowwds_4_tfcondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV151Conceptowwds_3_tfcondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int17[2] = (byte)(1) ;
      }
      if ( AV152Conceptowwds_4_tfcondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV152Conceptowwds_4_tfcondescrip_sels, "T1.ConDescrip IN (", ")")+")");
      }
      if ( AV153Conceptowwds_5_tftipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV153Conceptowwds_5_tftipoconcod_sels, "T1.TipoConCod IN (", ")")+")");
      }
      if ( ( AV155Conceptowwds_7_tfconclasifaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV154Conceptowwds_6_tfconclasifaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConClasifAux) like LOWER(?))");
      }
      else
      {
         GXv_int17[3] = (byte)(1) ;
      }
      if ( AV155Conceptowwds_7_tfconclasifaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV155Conceptowwds_7_tfconclasifaux_sels, "T1.ConClasifAux IN (", ")")+")");
      }
      if ( ( AV157Conceptowwds_9_tfcontipoliqaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV156Conceptowwds_8_tfcontipoliqaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConTipoLiqAux) like LOWER(?))");
      }
      else
      {
         GXv_int17[4] = (byte)(1) ;
      }
      if ( AV157Conceptowwds_9_tfcontipoliqaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV157Conceptowwds_9_tfcontipoliqaux_sels, "T1.ConTipoLiqAux IN (", ")")+")");
      }
      if ( ( AV159Conceptowwds_11_tfconceptoconvecodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV158Conceptowwds_10_tfconceptoconvecodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.ConveDescri) like LOWER(?))");
      }
      else
      {
         GXv_int17[5] = (byte)(1) ;
      }
      if ( AV159Conceptowwds_11_tfconceptoconvecodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV159Conceptowwds_11_tfconceptoconvecodigo_sels, "T1.ConceptoConveCodigo IN (", ")")+")");
      }
      if ( AV160Conceptowwds_12_tfconvigencia_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV160Conceptowwds_12_tfconvigencia_sels, "T1.ConVigencia IN (", ")")+")");
      }
      if ( AV161Conceptowwds_13_tfconvariable_sel == 1 )
      {
         addWhere(sWhereString, "(T1.ConVariable = TRUE)");
      }
      if ( AV161Conceptowwds_13_tfconvariable_sel == 2 )
      {
         addWhere(sWhereString, "(T1.ConVariable = FALSE)");
      }
      if ( AV163Conceptowwds_15_tfconhabilitado_sel == 1 )
      {
         addWhere(sWhereString, "(T1.ConHabilitado = TRUE)");
      }
      if ( AV163Conceptowwds_15_tfconhabilitado_sel == 2 )
      {
         addWhere(sWhereString, "(T1.ConHabilitado = FALSE)");
      }
      if ( ( AV165Conceptowwds_17_tfconobservacion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV164Conceptowwds_16_tfconobservacion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConObservacion) like LOWER(?))");
      }
      else
      {
         GXv_int17[6] = (byte)(1) ;
      }
      if ( AV165Conceptowwds_17_tfconobservacion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV165Conceptowwds_17_tfconobservacion_sels, "T1.ConObservacion IN (", ")")+")");
      }
      if ( AV166Conceptowwds_18_tfapliigg_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV166Conceptowwds_18_tfapliigg_sels, "T1.AplIIGG IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV167Conceptowwds_19_tfconfchmodfor) )
      {
         addWhere(sWhereString, "(T1.ConFchModFor >= ?)");
      }
      else
      {
         GXv_int17[7] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV168Conceptowwds_20_tfconfchmodfor_to) )
      {
         addWhere(sWhereString, "(T1.ConFchModFor <= ?)");
      }
      else
      {
         GXv_int17[8] = (byte)(1) ;
      }
      if ( AV169Conceptowwds_21_tfconrecalcular_sel == 1 )
      {
         addWhere(sWhereString, "(T1.ConRecalcular = TRUE)");
      }
      if ( AV169Conceptowwds_21_tfconrecalcular_sel == 2 )
      {
         addWhere(sWhereString, "(T1.ConRecalcular = FALSE)");
      }
      if ( AV170Conceptowwds_22_tfconcondicion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV170Conceptowwds_22_tfconcondicion_sels, "T1.ConCondicion IN (", ")")+")");
      }
      if ( AV171Conceptowwds_23_tfconsacdeven_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV171Conceptowwds_23_tfconsacdeven_sels, "T1.ConSacDeven IN (", ")")+")");
      }
      if ( ( AV173Conceptowwds_25_tfconcodafip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV172Conceptowwds_24_tfconcodafip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConCodAfip) like LOWER(?))");
      }
      else
      {
         GXv_int17[9] = (byte)(1) ;
      }
      if ( AV173Conceptowwds_25_tfconcodafip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV173Conceptowwds_25_tfconcodafip_sels, "T1.ConCodAfip IN (", ")")+")");
      }
      if ( AV174Conceptowwds_26_tfconbasepres_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV174Conceptowwds_26_tfconbasepres_sels, "T1.ConBasePres IN (", ")")+")");
      }
      if ( AV175Conceptowwds_27_tfconbaseant_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV175Conceptowwds_27_tfconbaseant_sels, "T1.ConBaseAnt IN (", ")")+")");
      }
      if ( AV176Conceptowwds_28_tfconbasefer_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV176Conceptowwds_28_tfconbasefer_sels, "T1.ConBaseFer IN (", ")")+")");
      }
      if ( AV177Conceptowwds_29_tfconbaseferprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV177Conceptowwds_29_tfconbaseferprom_sels, "T1.ConBaseFerProm IN (", ")")+")");
      }
      if ( AV178Conceptowwds_30_tfconbasehorext_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV178Conceptowwds_30_tfconbasehorext_sels, "T1.ConBaseHorExt IN (", ")")+")");
      }
      if ( AV179Conceptowwds_31_tfconbasehorextprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV179Conceptowwds_31_tfconbasehorextprom_sels, "T1.ConBaseHorExtProm IN (", ")")+")");
      }
      if ( AV180Conceptowwds_32_tfconbaselic_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV180Conceptowwds_32_tfconbaselic_sels, "T1.ConBaseLic IN (", ")")+")");
      }
      if ( AV181Conceptowwds_33_tfconbaselicprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV181Conceptowwds_33_tfconbaselicprom_sels, "T1.ConBaseLicProm IN (", ")")+")");
      }
      if ( AV182Conceptowwds_34_tfconbaseosdif_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV182Conceptowwds_34_tfconbaseosdif_sels, "T1.ConBaseOSDif IN (", ")")+")");
      }
      if ( ( AV184Conceptowwds_36_tfconrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV183Conceptowwds_35_tfconrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int17[10] = (byte)(1) ;
      }
      if ( AV184Conceptowwds_36_tfconrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV184Conceptowwds_36_tfconrelref_sels, "T1.ConRelRef IN (", ")")+")");
      }
      if ( ! (GXutil.strcmp("", AV25TFConFormula)==0) )
      {
         addWhere(sWhereString, "(T1.ConFormula like ?)");
      }
      else
      {
         GXv_int17[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.ConTipoLiqAux" ;
      GXv_Object18[0] = scmdbuf ;
      GXv_Object18[1] = GXv_int17 ;
      return GXv_Object18 ;
   }

   protected Object[] conditional_P003V6( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV150Conceptowwds_2_tfconcodigo_sels ,
                                          String A41ConDescrip ,
                                          GXSimpleCollection<String> AV152Conceptowwds_4_tfcondescrip_sels ,
                                          String A37TipoConCod ,
                                          GXSimpleCollection<String> AV153Conceptowwds_5_tftipoconcod_sels ,
                                          String A970ConClasifAux ,
                                          GXSimpleCollection<String> AV155Conceptowwds_7_tfconclasifaux_sels ,
                                          String A503ConTipoLiqAux ,
                                          GXSimpleCollection<String> AV157Conceptowwds_9_tfcontipoliqaux_sels ,
                                          String A1645ConceptoConveCodigo ,
                                          GXSimpleCollection<String> AV159Conceptowwds_11_tfconceptoconvecodigo_sels ,
                                          byte A162ConVigencia ,
                                          GXSimpleCollection<Byte> AV160Conceptowwds_12_tfconvigencia_sels ,
                                          String A153ConObservacion ,
                                          GXSimpleCollection<String> AV165Conceptowwds_17_tfconobservacion_sels ,
                                          short A1112AplIIGG ,
                                          GXSimpleCollection<Short> AV166Conceptowwds_18_tfapliigg_sels ,
                                          String A953ConCondicion ,
                                          GXSimpleCollection<String> AV170Conceptowwds_22_tfconcondicion_sels ,
                                          byte A1539ConSacDeven ,
                                          GXSimpleCollection<Byte> AV171Conceptowwds_23_tfconsacdeven_sels ,
                                          String A1648ConCodAfip ,
                                          GXSimpleCollection<String> AV173Conceptowwds_25_tfconcodafip_sels ,
                                          byte A1800ConBasePres ,
                                          GXSimpleCollection<Byte> AV174Conceptowwds_26_tfconbasepres_sels ,
                                          byte A1801ConBaseAnt ,
                                          GXSimpleCollection<Byte> AV175Conceptowwds_27_tfconbaseant_sels ,
                                          byte A1621ConBaseFer ,
                                          GXSimpleCollection<Byte> AV176Conceptowwds_28_tfconbasefer_sels ,
                                          byte A1798ConBaseFerProm ,
                                          GXSimpleCollection<Byte> AV177Conceptowwds_29_tfconbaseferprom_sels ,
                                          byte A1622ConBaseHorExt ,
                                          GXSimpleCollection<Byte> AV178Conceptowwds_30_tfconbasehorext_sels ,
                                          byte A1799ConBaseHorExtProm ,
                                          GXSimpleCollection<Byte> AV179Conceptowwds_31_tfconbasehorextprom_sels ,
                                          byte A1620ConBaseLic ,
                                          GXSimpleCollection<Byte> AV180Conceptowwds_32_tfconbaselic_sels ,
                                          byte A1797ConBaseLicProm ,
                                          GXSimpleCollection<Byte> AV181Conceptowwds_33_tfconbaselicprom_sels ,
                                          byte A1827ConBaseOSDif ,
                                          GXSimpleCollection<Byte> AV182Conceptowwds_34_tfconbaseosdif_sels ,
                                          String A2013ConRelRef ,
                                          GXSimpleCollection<String> AV184Conceptowwds_36_tfconrelref_sels ,
                                          int AV150Conceptowwds_2_tfconcodigo_sels_size ,
                                          String AV149Conceptowwds_1_tfconcodigo ,
                                          int AV152Conceptowwds_4_tfcondescrip_sels_size ,
                                          String AV151Conceptowwds_3_tfcondescrip ,
                                          int AV153Conceptowwds_5_tftipoconcod_sels_size ,
                                          int AV155Conceptowwds_7_tfconclasifaux_sels_size ,
                                          String AV154Conceptowwds_6_tfconclasifaux ,
                                          int AV157Conceptowwds_9_tfcontipoliqaux_sels_size ,
                                          String AV156Conceptowwds_8_tfcontipoliqaux ,
                                          int AV159Conceptowwds_11_tfconceptoconvecodigo_sels_size ,
                                          String AV158Conceptowwds_10_tfconceptoconvecodigo ,
                                          int AV160Conceptowwds_12_tfconvigencia_sels_size ,
                                          byte AV161Conceptowwds_13_tfconvariable_sel ,
                                          byte AV163Conceptowwds_15_tfconhabilitado_sel ,
                                          int AV165Conceptowwds_17_tfconobservacion_sels_size ,
                                          String AV164Conceptowwds_16_tfconobservacion ,
                                          int AV166Conceptowwds_18_tfapliigg_sels_size ,
                                          java.util.Date AV167Conceptowwds_19_tfconfchmodfor ,
                                          java.util.Date AV168Conceptowwds_20_tfconfchmodfor_to ,
                                          byte AV169Conceptowwds_21_tfconrecalcular_sel ,
                                          int AV170Conceptowwds_22_tfconcondicion_sels_size ,
                                          int AV171Conceptowwds_23_tfconsacdeven_sels_size ,
                                          int AV173Conceptowwds_25_tfconcodafip_sels_size ,
                                          String AV172Conceptowwds_24_tfconcodafip ,
                                          int AV174Conceptowwds_26_tfconbasepres_sels_size ,
                                          int AV175Conceptowwds_27_tfconbaseant_sels_size ,
                                          int AV176Conceptowwds_28_tfconbasefer_sels_size ,
                                          int AV177Conceptowwds_29_tfconbaseferprom_sels_size ,
                                          int AV178Conceptowwds_30_tfconbasehorext_sels_size ,
                                          int AV179Conceptowwds_31_tfconbasehorextprom_sels_size ,
                                          int AV180Conceptowwds_32_tfconbaselic_sels_size ,
                                          int AV181Conceptowwds_33_tfconbaselicprom_sels_size ,
                                          int AV182Conceptowwds_34_tfconbaseosdif_sels_size ,
                                          int AV184Conceptowwds_36_tfconrelref_sels_size ,
                                          String AV183Conceptowwds_35_tfconrelref ,
                                          String AV25TFConFormula ,
                                          String A160ConveDescri ,
                                          boolean A159ConVariable ,
                                          boolean A150ConHabilitado ,
                                          java.util.Date A145ConFchModFor ,
                                          boolean A762ConRecalcular ,
                                          String A148ConFormula ,
                                          int A3CliCod ,
                                          int AV64CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int20 = new byte[12];
      Object[] GXv_Object21 = new Object[2];
      scmdbuf = "SELECT T1.ConceptoPais AS ConceptoPais, T1.CliCod, T1.ConceptoConveCodigo AS ConceptoConveCodigo, T1.ConFormula, T2.ConveDescri, T1.ConRelRef, T1.ConBaseOSDif, T1.ConBaseLicProm," ;
      scmdbuf += " T1.ConBaseLic, T1.ConBaseHorExtProm, T1.ConBaseHorExt, T1.ConBaseFerProm, T1.ConBaseFer, T1.ConBaseAnt, T1.ConBasePres, T1.ConCodAfip, T1.ConSacDeven, T1.ConCondicion," ;
      scmdbuf += " T1.ConRecalcular, T1.ConFchModFor, T1.AplIIGG, T1.ConObservacion, T1.ConHabilitado, T1.ConVariable, T1.ConVigencia, T1.ConTipoLiqAux, T1.ConClasifAux, T1.TipoConCod," ;
      scmdbuf += " T1.ConDescrip, T1.ConCodigo FROM (Concepto T1 LEFT JOIN Convenio T2 ON T2.PaiCod = T1.ConceptoPais AND T2.ConveCodigo = T1.ConceptoConveCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      if ( ( AV150Conceptowwds_2_tfconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV149Conceptowwds_1_tfconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int20[1] = (byte)(1) ;
      }
      if ( AV150Conceptowwds_2_tfconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV150Conceptowwds_2_tfconcodigo_sels, "T1.ConCodigo IN (", ")")+")");
      }
      if ( ( AV152Conceptowwds_4_tfcondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV151Conceptowwds_3_tfcondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int20[2] = (byte)(1) ;
      }
      if ( AV152Conceptowwds_4_tfcondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV152Conceptowwds_4_tfcondescrip_sels, "T1.ConDescrip IN (", ")")+")");
      }
      if ( AV153Conceptowwds_5_tftipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV153Conceptowwds_5_tftipoconcod_sels, "T1.TipoConCod IN (", ")")+")");
      }
      if ( ( AV155Conceptowwds_7_tfconclasifaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV154Conceptowwds_6_tfconclasifaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConClasifAux) like LOWER(?))");
      }
      else
      {
         GXv_int20[3] = (byte)(1) ;
      }
      if ( AV155Conceptowwds_7_tfconclasifaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV155Conceptowwds_7_tfconclasifaux_sels, "T1.ConClasifAux IN (", ")")+")");
      }
      if ( ( AV157Conceptowwds_9_tfcontipoliqaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV156Conceptowwds_8_tfcontipoliqaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConTipoLiqAux) like LOWER(?))");
      }
      else
      {
         GXv_int20[4] = (byte)(1) ;
      }
      if ( AV157Conceptowwds_9_tfcontipoliqaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV157Conceptowwds_9_tfcontipoliqaux_sels, "T1.ConTipoLiqAux IN (", ")")+")");
      }
      if ( ( AV159Conceptowwds_11_tfconceptoconvecodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV158Conceptowwds_10_tfconceptoconvecodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.ConveDescri) like LOWER(?))");
      }
      else
      {
         GXv_int20[5] = (byte)(1) ;
      }
      if ( AV159Conceptowwds_11_tfconceptoconvecodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV159Conceptowwds_11_tfconceptoconvecodigo_sels, "T1.ConceptoConveCodigo IN (", ")")+")");
      }
      if ( AV160Conceptowwds_12_tfconvigencia_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV160Conceptowwds_12_tfconvigencia_sels, "T1.ConVigencia IN (", ")")+")");
      }
      if ( AV161Conceptowwds_13_tfconvariable_sel == 1 )
      {
         addWhere(sWhereString, "(T1.ConVariable = TRUE)");
      }
      if ( AV161Conceptowwds_13_tfconvariable_sel == 2 )
      {
         addWhere(sWhereString, "(T1.ConVariable = FALSE)");
      }
      if ( AV163Conceptowwds_15_tfconhabilitado_sel == 1 )
      {
         addWhere(sWhereString, "(T1.ConHabilitado = TRUE)");
      }
      if ( AV163Conceptowwds_15_tfconhabilitado_sel == 2 )
      {
         addWhere(sWhereString, "(T1.ConHabilitado = FALSE)");
      }
      if ( ( AV165Conceptowwds_17_tfconobservacion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV164Conceptowwds_16_tfconobservacion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConObservacion) like LOWER(?))");
      }
      else
      {
         GXv_int20[6] = (byte)(1) ;
      }
      if ( AV165Conceptowwds_17_tfconobservacion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV165Conceptowwds_17_tfconobservacion_sels, "T1.ConObservacion IN (", ")")+")");
      }
      if ( AV166Conceptowwds_18_tfapliigg_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV166Conceptowwds_18_tfapliigg_sels, "T1.AplIIGG IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV167Conceptowwds_19_tfconfchmodfor) )
      {
         addWhere(sWhereString, "(T1.ConFchModFor >= ?)");
      }
      else
      {
         GXv_int20[7] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV168Conceptowwds_20_tfconfchmodfor_to) )
      {
         addWhere(sWhereString, "(T1.ConFchModFor <= ?)");
      }
      else
      {
         GXv_int20[8] = (byte)(1) ;
      }
      if ( AV169Conceptowwds_21_tfconrecalcular_sel == 1 )
      {
         addWhere(sWhereString, "(T1.ConRecalcular = TRUE)");
      }
      if ( AV169Conceptowwds_21_tfconrecalcular_sel == 2 )
      {
         addWhere(sWhereString, "(T1.ConRecalcular = FALSE)");
      }
      if ( AV170Conceptowwds_22_tfconcondicion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV170Conceptowwds_22_tfconcondicion_sels, "T1.ConCondicion IN (", ")")+")");
      }
      if ( AV171Conceptowwds_23_tfconsacdeven_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV171Conceptowwds_23_tfconsacdeven_sels, "T1.ConSacDeven IN (", ")")+")");
      }
      if ( ( AV173Conceptowwds_25_tfconcodafip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV172Conceptowwds_24_tfconcodafip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConCodAfip) like LOWER(?))");
      }
      else
      {
         GXv_int20[9] = (byte)(1) ;
      }
      if ( AV173Conceptowwds_25_tfconcodafip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV173Conceptowwds_25_tfconcodafip_sels, "T1.ConCodAfip IN (", ")")+")");
      }
      if ( AV174Conceptowwds_26_tfconbasepres_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV174Conceptowwds_26_tfconbasepres_sels, "T1.ConBasePres IN (", ")")+")");
      }
      if ( AV175Conceptowwds_27_tfconbaseant_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV175Conceptowwds_27_tfconbaseant_sels, "T1.ConBaseAnt IN (", ")")+")");
      }
      if ( AV176Conceptowwds_28_tfconbasefer_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV176Conceptowwds_28_tfconbasefer_sels, "T1.ConBaseFer IN (", ")")+")");
      }
      if ( AV177Conceptowwds_29_tfconbaseferprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV177Conceptowwds_29_tfconbaseferprom_sels, "T1.ConBaseFerProm IN (", ")")+")");
      }
      if ( AV178Conceptowwds_30_tfconbasehorext_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV178Conceptowwds_30_tfconbasehorext_sels, "T1.ConBaseHorExt IN (", ")")+")");
      }
      if ( AV179Conceptowwds_31_tfconbasehorextprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV179Conceptowwds_31_tfconbasehorextprom_sels, "T1.ConBaseHorExtProm IN (", ")")+")");
      }
      if ( AV180Conceptowwds_32_tfconbaselic_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV180Conceptowwds_32_tfconbaselic_sels, "T1.ConBaseLic IN (", ")")+")");
      }
      if ( AV181Conceptowwds_33_tfconbaselicprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV181Conceptowwds_33_tfconbaselicprom_sels, "T1.ConBaseLicProm IN (", ")")+")");
      }
      if ( AV182Conceptowwds_34_tfconbaseosdif_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV182Conceptowwds_34_tfconbaseosdif_sels, "T1.ConBaseOSDif IN (", ")")+")");
      }
      if ( ( AV184Conceptowwds_36_tfconrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV183Conceptowwds_35_tfconrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int20[10] = (byte)(1) ;
      }
      if ( AV184Conceptowwds_36_tfconrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV184Conceptowwds_36_tfconrelref_sels, "T1.ConRelRef IN (", ")")+")");
      }
      if ( ! (GXutil.strcmp("", AV25TFConFormula)==0) )
      {
         addWhere(sWhereString, "(T1.ConFormula like ?)");
      }
      else
      {
         GXv_int20[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.ConceptoConveCodigo" ;
      GXv_Object21[0] = scmdbuf ;
      GXv_Object21[1] = GXv_int20 ;
      return GXv_Object21 ;
   }

   protected Object[] conditional_P003V7( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV150Conceptowwds_2_tfconcodigo_sels ,
                                          String A41ConDescrip ,
                                          GXSimpleCollection<String> AV152Conceptowwds_4_tfcondescrip_sels ,
                                          String A37TipoConCod ,
                                          GXSimpleCollection<String> AV153Conceptowwds_5_tftipoconcod_sels ,
                                          String A970ConClasifAux ,
                                          GXSimpleCollection<String> AV155Conceptowwds_7_tfconclasifaux_sels ,
                                          String A503ConTipoLiqAux ,
                                          GXSimpleCollection<String> AV157Conceptowwds_9_tfcontipoliqaux_sels ,
                                          String A1645ConceptoConveCodigo ,
                                          GXSimpleCollection<String> AV159Conceptowwds_11_tfconceptoconvecodigo_sels ,
                                          byte A162ConVigencia ,
                                          GXSimpleCollection<Byte> AV160Conceptowwds_12_tfconvigencia_sels ,
                                          String A153ConObservacion ,
                                          GXSimpleCollection<String> AV165Conceptowwds_17_tfconobservacion_sels ,
                                          short A1112AplIIGG ,
                                          GXSimpleCollection<Short> AV166Conceptowwds_18_tfapliigg_sels ,
                                          String A953ConCondicion ,
                                          GXSimpleCollection<String> AV170Conceptowwds_22_tfconcondicion_sels ,
                                          byte A1539ConSacDeven ,
                                          GXSimpleCollection<Byte> AV171Conceptowwds_23_tfconsacdeven_sels ,
                                          String A1648ConCodAfip ,
                                          GXSimpleCollection<String> AV173Conceptowwds_25_tfconcodafip_sels ,
                                          byte A1800ConBasePres ,
                                          GXSimpleCollection<Byte> AV174Conceptowwds_26_tfconbasepres_sels ,
                                          byte A1801ConBaseAnt ,
                                          GXSimpleCollection<Byte> AV175Conceptowwds_27_tfconbaseant_sels ,
                                          byte A1621ConBaseFer ,
                                          GXSimpleCollection<Byte> AV176Conceptowwds_28_tfconbasefer_sels ,
                                          byte A1798ConBaseFerProm ,
                                          GXSimpleCollection<Byte> AV177Conceptowwds_29_tfconbaseferprom_sels ,
                                          byte A1622ConBaseHorExt ,
                                          GXSimpleCollection<Byte> AV178Conceptowwds_30_tfconbasehorext_sels ,
                                          byte A1799ConBaseHorExtProm ,
                                          GXSimpleCollection<Byte> AV179Conceptowwds_31_tfconbasehorextprom_sels ,
                                          byte A1620ConBaseLic ,
                                          GXSimpleCollection<Byte> AV180Conceptowwds_32_tfconbaselic_sels ,
                                          byte A1797ConBaseLicProm ,
                                          GXSimpleCollection<Byte> AV181Conceptowwds_33_tfconbaselicprom_sels ,
                                          byte A1827ConBaseOSDif ,
                                          GXSimpleCollection<Byte> AV182Conceptowwds_34_tfconbaseosdif_sels ,
                                          String A2013ConRelRef ,
                                          GXSimpleCollection<String> AV184Conceptowwds_36_tfconrelref_sels ,
                                          int AV150Conceptowwds_2_tfconcodigo_sels_size ,
                                          String AV149Conceptowwds_1_tfconcodigo ,
                                          int AV152Conceptowwds_4_tfcondescrip_sels_size ,
                                          String AV151Conceptowwds_3_tfcondescrip ,
                                          int AV153Conceptowwds_5_tftipoconcod_sels_size ,
                                          int AV155Conceptowwds_7_tfconclasifaux_sels_size ,
                                          String AV154Conceptowwds_6_tfconclasifaux ,
                                          int AV157Conceptowwds_9_tfcontipoliqaux_sels_size ,
                                          String AV156Conceptowwds_8_tfcontipoliqaux ,
                                          int AV159Conceptowwds_11_tfconceptoconvecodigo_sels_size ,
                                          String AV158Conceptowwds_10_tfconceptoconvecodigo ,
                                          int AV160Conceptowwds_12_tfconvigencia_sels_size ,
                                          byte AV161Conceptowwds_13_tfconvariable_sel ,
                                          byte AV163Conceptowwds_15_tfconhabilitado_sel ,
                                          int AV165Conceptowwds_17_tfconobservacion_sels_size ,
                                          String AV164Conceptowwds_16_tfconobservacion ,
                                          int AV166Conceptowwds_18_tfapliigg_sels_size ,
                                          java.util.Date AV167Conceptowwds_19_tfconfchmodfor ,
                                          java.util.Date AV168Conceptowwds_20_tfconfchmodfor_to ,
                                          byte AV169Conceptowwds_21_tfconrecalcular_sel ,
                                          int AV170Conceptowwds_22_tfconcondicion_sels_size ,
                                          int AV171Conceptowwds_23_tfconsacdeven_sels_size ,
                                          int AV173Conceptowwds_25_tfconcodafip_sels_size ,
                                          String AV172Conceptowwds_24_tfconcodafip ,
                                          int AV174Conceptowwds_26_tfconbasepres_sels_size ,
                                          int AV175Conceptowwds_27_tfconbaseant_sels_size ,
                                          int AV176Conceptowwds_28_tfconbasefer_sels_size ,
                                          int AV177Conceptowwds_29_tfconbaseferprom_sels_size ,
                                          int AV178Conceptowwds_30_tfconbasehorext_sels_size ,
                                          int AV179Conceptowwds_31_tfconbasehorextprom_sels_size ,
                                          int AV180Conceptowwds_32_tfconbaselic_sels_size ,
                                          int AV181Conceptowwds_33_tfconbaselicprom_sels_size ,
                                          int AV182Conceptowwds_34_tfconbaseosdif_sels_size ,
                                          int AV184Conceptowwds_36_tfconrelref_sels_size ,
                                          String AV183Conceptowwds_35_tfconrelref ,
                                          String AV25TFConFormula ,
                                          String A160ConveDescri ,
                                          boolean A159ConVariable ,
                                          boolean A150ConHabilitado ,
                                          java.util.Date A145ConFchModFor ,
                                          boolean A762ConRecalcular ,
                                          String A148ConFormula ,
                                          int A3CliCod ,
                                          int AV64CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int23 = new byte[12];
      Object[] GXv_Object24 = new Object[2];
      scmdbuf = "SELECT T1.ConceptoPais AS ConceptoPais, T1.CliCod, T1.ConObservacion, T1.ConFormula, T2.ConveDescri, T1.ConRelRef, T1.ConBaseOSDif, T1.ConBaseLicProm, T1.ConBaseLic," ;
      scmdbuf += " T1.ConBaseHorExtProm, T1.ConBaseHorExt, T1.ConBaseFerProm, T1.ConBaseFer, T1.ConBaseAnt, T1.ConBasePres, T1.ConCodAfip, T1.ConSacDeven, T1.ConCondicion, T1.ConRecalcular," ;
      scmdbuf += " T1.ConFchModFor, T1.AplIIGG, T1.ConHabilitado, T1.ConVariable, T1.ConVigencia, T1.ConceptoConveCodigo AS ConceptoConveCodigo, T1.ConTipoLiqAux, T1.ConClasifAux," ;
      scmdbuf += " T1.TipoConCod, T1.ConDescrip, T1.ConCodigo FROM (Concepto T1 LEFT JOIN Convenio T2 ON T2.PaiCod = T1.ConceptoPais AND T2.ConveCodigo = T1.ConceptoConveCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      if ( ( AV150Conceptowwds_2_tfconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV149Conceptowwds_1_tfconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int23[1] = (byte)(1) ;
      }
      if ( AV150Conceptowwds_2_tfconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV150Conceptowwds_2_tfconcodigo_sels, "T1.ConCodigo IN (", ")")+")");
      }
      if ( ( AV152Conceptowwds_4_tfcondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV151Conceptowwds_3_tfcondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int23[2] = (byte)(1) ;
      }
      if ( AV152Conceptowwds_4_tfcondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV152Conceptowwds_4_tfcondescrip_sels, "T1.ConDescrip IN (", ")")+")");
      }
      if ( AV153Conceptowwds_5_tftipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV153Conceptowwds_5_tftipoconcod_sels, "T1.TipoConCod IN (", ")")+")");
      }
      if ( ( AV155Conceptowwds_7_tfconclasifaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV154Conceptowwds_6_tfconclasifaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConClasifAux) like LOWER(?))");
      }
      else
      {
         GXv_int23[3] = (byte)(1) ;
      }
      if ( AV155Conceptowwds_7_tfconclasifaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV155Conceptowwds_7_tfconclasifaux_sels, "T1.ConClasifAux IN (", ")")+")");
      }
      if ( ( AV157Conceptowwds_9_tfcontipoliqaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV156Conceptowwds_8_tfcontipoliqaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConTipoLiqAux) like LOWER(?))");
      }
      else
      {
         GXv_int23[4] = (byte)(1) ;
      }
      if ( AV157Conceptowwds_9_tfcontipoliqaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV157Conceptowwds_9_tfcontipoliqaux_sels, "T1.ConTipoLiqAux IN (", ")")+")");
      }
      if ( ( AV159Conceptowwds_11_tfconceptoconvecodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV158Conceptowwds_10_tfconceptoconvecodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.ConveDescri) like LOWER(?))");
      }
      else
      {
         GXv_int23[5] = (byte)(1) ;
      }
      if ( AV159Conceptowwds_11_tfconceptoconvecodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV159Conceptowwds_11_tfconceptoconvecodigo_sels, "T1.ConceptoConveCodigo IN (", ")")+")");
      }
      if ( AV160Conceptowwds_12_tfconvigencia_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV160Conceptowwds_12_tfconvigencia_sels, "T1.ConVigencia IN (", ")")+")");
      }
      if ( AV161Conceptowwds_13_tfconvariable_sel == 1 )
      {
         addWhere(sWhereString, "(T1.ConVariable = TRUE)");
      }
      if ( AV161Conceptowwds_13_tfconvariable_sel == 2 )
      {
         addWhere(sWhereString, "(T1.ConVariable = FALSE)");
      }
      if ( AV163Conceptowwds_15_tfconhabilitado_sel == 1 )
      {
         addWhere(sWhereString, "(T1.ConHabilitado = TRUE)");
      }
      if ( AV163Conceptowwds_15_tfconhabilitado_sel == 2 )
      {
         addWhere(sWhereString, "(T1.ConHabilitado = FALSE)");
      }
      if ( ( AV165Conceptowwds_17_tfconobservacion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV164Conceptowwds_16_tfconobservacion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConObservacion) like LOWER(?))");
      }
      else
      {
         GXv_int23[6] = (byte)(1) ;
      }
      if ( AV165Conceptowwds_17_tfconobservacion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV165Conceptowwds_17_tfconobservacion_sels, "T1.ConObservacion IN (", ")")+")");
      }
      if ( AV166Conceptowwds_18_tfapliigg_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV166Conceptowwds_18_tfapliigg_sels, "T1.AplIIGG IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV167Conceptowwds_19_tfconfchmodfor) )
      {
         addWhere(sWhereString, "(T1.ConFchModFor >= ?)");
      }
      else
      {
         GXv_int23[7] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV168Conceptowwds_20_tfconfchmodfor_to) )
      {
         addWhere(sWhereString, "(T1.ConFchModFor <= ?)");
      }
      else
      {
         GXv_int23[8] = (byte)(1) ;
      }
      if ( AV169Conceptowwds_21_tfconrecalcular_sel == 1 )
      {
         addWhere(sWhereString, "(T1.ConRecalcular = TRUE)");
      }
      if ( AV169Conceptowwds_21_tfconrecalcular_sel == 2 )
      {
         addWhere(sWhereString, "(T1.ConRecalcular = FALSE)");
      }
      if ( AV170Conceptowwds_22_tfconcondicion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV170Conceptowwds_22_tfconcondicion_sels, "T1.ConCondicion IN (", ")")+")");
      }
      if ( AV171Conceptowwds_23_tfconsacdeven_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV171Conceptowwds_23_tfconsacdeven_sels, "T1.ConSacDeven IN (", ")")+")");
      }
      if ( ( AV173Conceptowwds_25_tfconcodafip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV172Conceptowwds_24_tfconcodafip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConCodAfip) like LOWER(?))");
      }
      else
      {
         GXv_int23[9] = (byte)(1) ;
      }
      if ( AV173Conceptowwds_25_tfconcodafip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV173Conceptowwds_25_tfconcodafip_sels, "T1.ConCodAfip IN (", ")")+")");
      }
      if ( AV174Conceptowwds_26_tfconbasepres_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV174Conceptowwds_26_tfconbasepres_sels, "T1.ConBasePres IN (", ")")+")");
      }
      if ( AV175Conceptowwds_27_tfconbaseant_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV175Conceptowwds_27_tfconbaseant_sels, "T1.ConBaseAnt IN (", ")")+")");
      }
      if ( AV176Conceptowwds_28_tfconbasefer_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV176Conceptowwds_28_tfconbasefer_sels, "T1.ConBaseFer IN (", ")")+")");
      }
      if ( AV177Conceptowwds_29_tfconbaseferprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV177Conceptowwds_29_tfconbaseferprom_sels, "T1.ConBaseFerProm IN (", ")")+")");
      }
      if ( AV178Conceptowwds_30_tfconbasehorext_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV178Conceptowwds_30_tfconbasehorext_sels, "T1.ConBaseHorExt IN (", ")")+")");
      }
      if ( AV179Conceptowwds_31_tfconbasehorextprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV179Conceptowwds_31_tfconbasehorextprom_sels, "T1.ConBaseHorExtProm IN (", ")")+")");
      }
      if ( AV180Conceptowwds_32_tfconbaselic_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV180Conceptowwds_32_tfconbaselic_sels, "T1.ConBaseLic IN (", ")")+")");
      }
      if ( AV181Conceptowwds_33_tfconbaselicprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV181Conceptowwds_33_tfconbaselicprom_sels, "T1.ConBaseLicProm IN (", ")")+")");
      }
      if ( AV182Conceptowwds_34_tfconbaseosdif_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV182Conceptowwds_34_tfconbaseosdif_sels, "T1.ConBaseOSDif IN (", ")")+")");
      }
      if ( ( AV184Conceptowwds_36_tfconrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV183Conceptowwds_35_tfconrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int23[10] = (byte)(1) ;
      }
      if ( AV184Conceptowwds_36_tfconrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV184Conceptowwds_36_tfconrelref_sels, "T1.ConRelRef IN (", ")")+")");
      }
      if ( ! (GXutil.strcmp("", AV25TFConFormula)==0) )
      {
         addWhere(sWhereString, "(T1.ConFormula like ?)");
      }
      else
      {
         GXv_int23[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.ConObservacion" ;
      GXv_Object24[0] = scmdbuf ;
      GXv_Object24[1] = GXv_int23 ;
      return GXv_Object24 ;
   }

   protected Object[] conditional_P003V8( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV150Conceptowwds_2_tfconcodigo_sels ,
                                          String A41ConDescrip ,
                                          GXSimpleCollection<String> AV152Conceptowwds_4_tfcondescrip_sels ,
                                          String A37TipoConCod ,
                                          GXSimpleCollection<String> AV153Conceptowwds_5_tftipoconcod_sels ,
                                          String A970ConClasifAux ,
                                          GXSimpleCollection<String> AV155Conceptowwds_7_tfconclasifaux_sels ,
                                          String A503ConTipoLiqAux ,
                                          GXSimpleCollection<String> AV157Conceptowwds_9_tfcontipoliqaux_sels ,
                                          String A1645ConceptoConveCodigo ,
                                          GXSimpleCollection<String> AV159Conceptowwds_11_tfconceptoconvecodigo_sels ,
                                          byte A162ConVigencia ,
                                          GXSimpleCollection<Byte> AV160Conceptowwds_12_tfconvigencia_sels ,
                                          String A153ConObservacion ,
                                          GXSimpleCollection<String> AV165Conceptowwds_17_tfconobservacion_sels ,
                                          short A1112AplIIGG ,
                                          GXSimpleCollection<Short> AV166Conceptowwds_18_tfapliigg_sels ,
                                          String A953ConCondicion ,
                                          GXSimpleCollection<String> AV170Conceptowwds_22_tfconcondicion_sels ,
                                          byte A1539ConSacDeven ,
                                          GXSimpleCollection<Byte> AV171Conceptowwds_23_tfconsacdeven_sels ,
                                          String A1648ConCodAfip ,
                                          GXSimpleCollection<String> AV173Conceptowwds_25_tfconcodafip_sels ,
                                          byte A1800ConBasePres ,
                                          GXSimpleCollection<Byte> AV174Conceptowwds_26_tfconbasepres_sels ,
                                          byte A1801ConBaseAnt ,
                                          GXSimpleCollection<Byte> AV175Conceptowwds_27_tfconbaseant_sels ,
                                          byte A1621ConBaseFer ,
                                          GXSimpleCollection<Byte> AV176Conceptowwds_28_tfconbasefer_sels ,
                                          byte A1798ConBaseFerProm ,
                                          GXSimpleCollection<Byte> AV177Conceptowwds_29_tfconbaseferprom_sels ,
                                          byte A1622ConBaseHorExt ,
                                          GXSimpleCollection<Byte> AV178Conceptowwds_30_tfconbasehorext_sels ,
                                          byte A1799ConBaseHorExtProm ,
                                          GXSimpleCollection<Byte> AV179Conceptowwds_31_tfconbasehorextprom_sels ,
                                          byte A1620ConBaseLic ,
                                          GXSimpleCollection<Byte> AV180Conceptowwds_32_tfconbaselic_sels ,
                                          byte A1797ConBaseLicProm ,
                                          GXSimpleCollection<Byte> AV181Conceptowwds_33_tfconbaselicprom_sels ,
                                          byte A1827ConBaseOSDif ,
                                          GXSimpleCollection<Byte> AV182Conceptowwds_34_tfconbaseosdif_sels ,
                                          String A2013ConRelRef ,
                                          GXSimpleCollection<String> AV184Conceptowwds_36_tfconrelref_sels ,
                                          int AV150Conceptowwds_2_tfconcodigo_sels_size ,
                                          String AV149Conceptowwds_1_tfconcodigo ,
                                          int AV152Conceptowwds_4_tfcondescrip_sels_size ,
                                          String AV151Conceptowwds_3_tfcondescrip ,
                                          int AV153Conceptowwds_5_tftipoconcod_sels_size ,
                                          int AV155Conceptowwds_7_tfconclasifaux_sels_size ,
                                          String AV154Conceptowwds_6_tfconclasifaux ,
                                          int AV157Conceptowwds_9_tfcontipoliqaux_sels_size ,
                                          String AV156Conceptowwds_8_tfcontipoliqaux ,
                                          int AV159Conceptowwds_11_tfconceptoconvecodigo_sels_size ,
                                          String AV158Conceptowwds_10_tfconceptoconvecodigo ,
                                          int AV160Conceptowwds_12_tfconvigencia_sels_size ,
                                          byte AV161Conceptowwds_13_tfconvariable_sel ,
                                          byte AV163Conceptowwds_15_tfconhabilitado_sel ,
                                          int AV165Conceptowwds_17_tfconobservacion_sels_size ,
                                          String AV164Conceptowwds_16_tfconobservacion ,
                                          int AV166Conceptowwds_18_tfapliigg_sels_size ,
                                          java.util.Date AV167Conceptowwds_19_tfconfchmodfor ,
                                          java.util.Date AV168Conceptowwds_20_tfconfchmodfor_to ,
                                          byte AV169Conceptowwds_21_tfconrecalcular_sel ,
                                          int AV170Conceptowwds_22_tfconcondicion_sels_size ,
                                          int AV171Conceptowwds_23_tfconsacdeven_sels_size ,
                                          int AV173Conceptowwds_25_tfconcodafip_sels_size ,
                                          String AV172Conceptowwds_24_tfconcodafip ,
                                          int AV174Conceptowwds_26_tfconbasepres_sels_size ,
                                          int AV175Conceptowwds_27_tfconbaseant_sels_size ,
                                          int AV176Conceptowwds_28_tfconbasefer_sels_size ,
                                          int AV177Conceptowwds_29_tfconbaseferprom_sels_size ,
                                          int AV178Conceptowwds_30_tfconbasehorext_sels_size ,
                                          int AV179Conceptowwds_31_tfconbasehorextprom_sels_size ,
                                          int AV180Conceptowwds_32_tfconbaselic_sels_size ,
                                          int AV181Conceptowwds_33_tfconbaselicprom_sels_size ,
                                          int AV182Conceptowwds_34_tfconbaseosdif_sels_size ,
                                          int AV184Conceptowwds_36_tfconrelref_sels_size ,
                                          String AV183Conceptowwds_35_tfconrelref ,
                                          String AV25TFConFormula ,
                                          String A160ConveDescri ,
                                          boolean A159ConVariable ,
                                          boolean A150ConHabilitado ,
                                          java.util.Date A145ConFchModFor ,
                                          boolean A762ConRecalcular ,
                                          String A148ConFormula ,
                                          int A3CliCod ,
                                          int AV64CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int26 = new byte[12];
      Object[] GXv_Object27 = new Object[2];
      scmdbuf = "SELECT T1.ConceptoPais AS ConceptoPais, T1.CliCod, T1.ConCodAfip, T1.ConFormula, T2.ConveDescri, T1.ConRelRef, T1.ConBaseOSDif, T1.ConBaseLicProm, T1.ConBaseLic," ;
      scmdbuf += " T1.ConBaseHorExtProm, T1.ConBaseHorExt, T1.ConBaseFerProm, T1.ConBaseFer, T1.ConBaseAnt, T1.ConBasePres, T1.ConSacDeven, T1.ConCondicion, T1.ConRecalcular, T1.ConFchModFor," ;
      scmdbuf += " T1.AplIIGG, T1.ConObservacion, T1.ConHabilitado, T1.ConVariable, T1.ConVigencia, T1.ConceptoConveCodigo AS ConceptoConveCodigo, T1.ConTipoLiqAux, T1.ConClasifAux," ;
      scmdbuf += " T1.TipoConCod, T1.ConDescrip, T1.ConCodigo FROM (Concepto T1 LEFT JOIN Convenio T2 ON T2.PaiCod = T1.ConceptoPais AND T2.ConveCodigo = T1.ConceptoConveCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      if ( ( AV150Conceptowwds_2_tfconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV149Conceptowwds_1_tfconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int26[1] = (byte)(1) ;
      }
      if ( AV150Conceptowwds_2_tfconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV150Conceptowwds_2_tfconcodigo_sels, "T1.ConCodigo IN (", ")")+")");
      }
      if ( ( AV152Conceptowwds_4_tfcondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV151Conceptowwds_3_tfcondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int26[2] = (byte)(1) ;
      }
      if ( AV152Conceptowwds_4_tfcondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV152Conceptowwds_4_tfcondescrip_sels, "T1.ConDescrip IN (", ")")+")");
      }
      if ( AV153Conceptowwds_5_tftipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV153Conceptowwds_5_tftipoconcod_sels, "T1.TipoConCod IN (", ")")+")");
      }
      if ( ( AV155Conceptowwds_7_tfconclasifaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV154Conceptowwds_6_tfconclasifaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConClasifAux) like LOWER(?))");
      }
      else
      {
         GXv_int26[3] = (byte)(1) ;
      }
      if ( AV155Conceptowwds_7_tfconclasifaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV155Conceptowwds_7_tfconclasifaux_sels, "T1.ConClasifAux IN (", ")")+")");
      }
      if ( ( AV157Conceptowwds_9_tfcontipoliqaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV156Conceptowwds_8_tfcontipoliqaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConTipoLiqAux) like LOWER(?))");
      }
      else
      {
         GXv_int26[4] = (byte)(1) ;
      }
      if ( AV157Conceptowwds_9_tfcontipoliqaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV157Conceptowwds_9_tfcontipoliqaux_sels, "T1.ConTipoLiqAux IN (", ")")+")");
      }
      if ( ( AV159Conceptowwds_11_tfconceptoconvecodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV158Conceptowwds_10_tfconceptoconvecodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.ConveDescri) like LOWER(?))");
      }
      else
      {
         GXv_int26[5] = (byte)(1) ;
      }
      if ( AV159Conceptowwds_11_tfconceptoconvecodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV159Conceptowwds_11_tfconceptoconvecodigo_sels, "T1.ConceptoConveCodigo IN (", ")")+")");
      }
      if ( AV160Conceptowwds_12_tfconvigencia_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV160Conceptowwds_12_tfconvigencia_sels, "T1.ConVigencia IN (", ")")+")");
      }
      if ( AV161Conceptowwds_13_tfconvariable_sel == 1 )
      {
         addWhere(sWhereString, "(T1.ConVariable = TRUE)");
      }
      if ( AV161Conceptowwds_13_tfconvariable_sel == 2 )
      {
         addWhere(sWhereString, "(T1.ConVariable = FALSE)");
      }
      if ( AV163Conceptowwds_15_tfconhabilitado_sel == 1 )
      {
         addWhere(sWhereString, "(T1.ConHabilitado = TRUE)");
      }
      if ( AV163Conceptowwds_15_tfconhabilitado_sel == 2 )
      {
         addWhere(sWhereString, "(T1.ConHabilitado = FALSE)");
      }
      if ( ( AV165Conceptowwds_17_tfconobservacion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV164Conceptowwds_16_tfconobservacion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConObservacion) like LOWER(?))");
      }
      else
      {
         GXv_int26[6] = (byte)(1) ;
      }
      if ( AV165Conceptowwds_17_tfconobservacion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV165Conceptowwds_17_tfconobservacion_sels, "T1.ConObservacion IN (", ")")+")");
      }
      if ( AV166Conceptowwds_18_tfapliigg_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV166Conceptowwds_18_tfapliigg_sels, "T1.AplIIGG IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV167Conceptowwds_19_tfconfchmodfor) )
      {
         addWhere(sWhereString, "(T1.ConFchModFor >= ?)");
      }
      else
      {
         GXv_int26[7] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV168Conceptowwds_20_tfconfchmodfor_to) )
      {
         addWhere(sWhereString, "(T1.ConFchModFor <= ?)");
      }
      else
      {
         GXv_int26[8] = (byte)(1) ;
      }
      if ( AV169Conceptowwds_21_tfconrecalcular_sel == 1 )
      {
         addWhere(sWhereString, "(T1.ConRecalcular = TRUE)");
      }
      if ( AV169Conceptowwds_21_tfconrecalcular_sel == 2 )
      {
         addWhere(sWhereString, "(T1.ConRecalcular = FALSE)");
      }
      if ( AV170Conceptowwds_22_tfconcondicion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV170Conceptowwds_22_tfconcondicion_sels, "T1.ConCondicion IN (", ")")+")");
      }
      if ( AV171Conceptowwds_23_tfconsacdeven_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV171Conceptowwds_23_tfconsacdeven_sels, "T1.ConSacDeven IN (", ")")+")");
      }
      if ( ( AV173Conceptowwds_25_tfconcodafip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV172Conceptowwds_24_tfconcodafip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConCodAfip) like LOWER(?))");
      }
      else
      {
         GXv_int26[9] = (byte)(1) ;
      }
      if ( AV173Conceptowwds_25_tfconcodafip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV173Conceptowwds_25_tfconcodafip_sels, "T1.ConCodAfip IN (", ")")+")");
      }
      if ( AV174Conceptowwds_26_tfconbasepres_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV174Conceptowwds_26_tfconbasepres_sels, "T1.ConBasePres IN (", ")")+")");
      }
      if ( AV175Conceptowwds_27_tfconbaseant_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV175Conceptowwds_27_tfconbaseant_sels, "T1.ConBaseAnt IN (", ")")+")");
      }
      if ( AV176Conceptowwds_28_tfconbasefer_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV176Conceptowwds_28_tfconbasefer_sels, "T1.ConBaseFer IN (", ")")+")");
      }
      if ( AV177Conceptowwds_29_tfconbaseferprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV177Conceptowwds_29_tfconbaseferprom_sels, "T1.ConBaseFerProm IN (", ")")+")");
      }
      if ( AV178Conceptowwds_30_tfconbasehorext_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV178Conceptowwds_30_tfconbasehorext_sels, "T1.ConBaseHorExt IN (", ")")+")");
      }
      if ( AV179Conceptowwds_31_tfconbasehorextprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV179Conceptowwds_31_tfconbasehorextprom_sels, "T1.ConBaseHorExtProm IN (", ")")+")");
      }
      if ( AV180Conceptowwds_32_tfconbaselic_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV180Conceptowwds_32_tfconbaselic_sels, "T1.ConBaseLic IN (", ")")+")");
      }
      if ( AV181Conceptowwds_33_tfconbaselicprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV181Conceptowwds_33_tfconbaselicprom_sels, "T1.ConBaseLicProm IN (", ")")+")");
      }
      if ( AV182Conceptowwds_34_tfconbaseosdif_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV182Conceptowwds_34_tfconbaseosdif_sels, "T1.ConBaseOSDif IN (", ")")+")");
      }
      if ( ( AV184Conceptowwds_36_tfconrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV183Conceptowwds_35_tfconrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int26[10] = (byte)(1) ;
      }
      if ( AV184Conceptowwds_36_tfconrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV184Conceptowwds_36_tfconrelref_sels, "T1.ConRelRef IN (", ")")+")");
      }
      if ( ! (GXutil.strcmp("", AV25TFConFormula)==0) )
      {
         addWhere(sWhereString, "(T1.ConFormula like ?)");
      }
      else
      {
         GXv_int26[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.ConCodAfip" ;
      GXv_Object27[0] = scmdbuf ;
      GXv_Object27[1] = GXv_int26 ;
      return GXv_Object27 ;
   }

   protected Object[] conditional_P003V9( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV150Conceptowwds_2_tfconcodigo_sels ,
                                          String A41ConDescrip ,
                                          GXSimpleCollection<String> AV152Conceptowwds_4_tfcondescrip_sels ,
                                          String A37TipoConCod ,
                                          GXSimpleCollection<String> AV153Conceptowwds_5_tftipoconcod_sels ,
                                          String A970ConClasifAux ,
                                          GXSimpleCollection<String> AV155Conceptowwds_7_tfconclasifaux_sels ,
                                          String A503ConTipoLiqAux ,
                                          GXSimpleCollection<String> AV157Conceptowwds_9_tfcontipoliqaux_sels ,
                                          String A1645ConceptoConveCodigo ,
                                          GXSimpleCollection<String> AV159Conceptowwds_11_tfconceptoconvecodigo_sels ,
                                          byte A162ConVigencia ,
                                          GXSimpleCollection<Byte> AV160Conceptowwds_12_tfconvigencia_sels ,
                                          String A153ConObservacion ,
                                          GXSimpleCollection<String> AV165Conceptowwds_17_tfconobservacion_sels ,
                                          short A1112AplIIGG ,
                                          GXSimpleCollection<Short> AV166Conceptowwds_18_tfapliigg_sels ,
                                          String A953ConCondicion ,
                                          GXSimpleCollection<String> AV170Conceptowwds_22_tfconcondicion_sels ,
                                          byte A1539ConSacDeven ,
                                          GXSimpleCollection<Byte> AV171Conceptowwds_23_tfconsacdeven_sels ,
                                          String A1648ConCodAfip ,
                                          GXSimpleCollection<String> AV173Conceptowwds_25_tfconcodafip_sels ,
                                          byte A1800ConBasePres ,
                                          GXSimpleCollection<Byte> AV174Conceptowwds_26_tfconbasepres_sels ,
                                          byte A1801ConBaseAnt ,
                                          GXSimpleCollection<Byte> AV175Conceptowwds_27_tfconbaseant_sels ,
                                          byte A1621ConBaseFer ,
                                          GXSimpleCollection<Byte> AV176Conceptowwds_28_tfconbasefer_sels ,
                                          byte A1798ConBaseFerProm ,
                                          GXSimpleCollection<Byte> AV177Conceptowwds_29_tfconbaseferprom_sels ,
                                          byte A1622ConBaseHorExt ,
                                          GXSimpleCollection<Byte> AV178Conceptowwds_30_tfconbasehorext_sels ,
                                          byte A1799ConBaseHorExtProm ,
                                          GXSimpleCollection<Byte> AV179Conceptowwds_31_tfconbasehorextprom_sels ,
                                          byte A1620ConBaseLic ,
                                          GXSimpleCollection<Byte> AV180Conceptowwds_32_tfconbaselic_sels ,
                                          byte A1797ConBaseLicProm ,
                                          GXSimpleCollection<Byte> AV181Conceptowwds_33_tfconbaselicprom_sels ,
                                          byte A1827ConBaseOSDif ,
                                          GXSimpleCollection<Byte> AV182Conceptowwds_34_tfconbaseosdif_sels ,
                                          String A2013ConRelRef ,
                                          GXSimpleCollection<String> AV184Conceptowwds_36_tfconrelref_sels ,
                                          int AV150Conceptowwds_2_tfconcodigo_sels_size ,
                                          String AV149Conceptowwds_1_tfconcodigo ,
                                          int AV152Conceptowwds_4_tfcondescrip_sels_size ,
                                          String AV151Conceptowwds_3_tfcondescrip ,
                                          int AV153Conceptowwds_5_tftipoconcod_sels_size ,
                                          int AV155Conceptowwds_7_tfconclasifaux_sels_size ,
                                          String AV154Conceptowwds_6_tfconclasifaux ,
                                          int AV157Conceptowwds_9_tfcontipoliqaux_sels_size ,
                                          String AV156Conceptowwds_8_tfcontipoliqaux ,
                                          int AV159Conceptowwds_11_tfconceptoconvecodigo_sels_size ,
                                          String AV158Conceptowwds_10_tfconceptoconvecodigo ,
                                          int AV160Conceptowwds_12_tfconvigencia_sels_size ,
                                          byte AV161Conceptowwds_13_tfconvariable_sel ,
                                          byte AV163Conceptowwds_15_tfconhabilitado_sel ,
                                          int AV165Conceptowwds_17_tfconobservacion_sels_size ,
                                          String AV164Conceptowwds_16_tfconobservacion ,
                                          int AV166Conceptowwds_18_tfapliigg_sels_size ,
                                          java.util.Date AV167Conceptowwds_19_tfconfchmodfor ,
                                          java.util.Date AV168Conceptowwds_20_tfconfchmodfor_to ,
                                          byte AV169Conceptowwds_21_tfconrecalcular_sel ,
                                          int AV170Conceptowwds_22_tfconcondicion_sels_size ,
                                          int AV171Conceptowwds_23_tfconsacdeven_sels_size ,
                                          int AV173Conceptowwds_25_tfconcodafip_sels_size ,
                                          String AV172Conceptowwds_24_tfconcodafip ,
                                          int AV174Conceptowwds_26_tfconbasepres_sels_size ,
                                          int AV175Conceptowwds_27_tfconbaseant_sels_size ,
                                          int AV176Conceptowwds_28_tfconbasefer_sels_size ,
                                          int AV177Conceptowwds_29_tfconbaseferprom_sels_size ,
                                          int AV178Conceptowwds_30_tfconbasehorext_sels_size ,
                                          int AV179Conceptowwds_31_tfconbasehorextprom_sels_size ,
                                          int AV180Conceptowwds_32_tfconbaselic_sels_size ,
                                          int AV181Conceptowwds_33_tfconbaselicprom_sels_size ,
                                          int AV182Conceptowwds_34_tfconbaseosdif_sels_size ,
                                          int AV184Conceptowwds_36_tfconrelref_sels_size ,
                                          String AV183Conceptowwds_35_tfconrelref ,
                                          String AV25TFConFormula ,
                                          String A160ConveDescri ,
                                          boolean A159ConVariable ,
                                          boolean A150ConHabilitado ,
                                          java.util.Date A145ConFchModFor ,
                                          boolean A762ConRecalcular ,
                                          String A148ConFormula ,
                                          int A3CliCod ,
                                          int AV64CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int29 = new byte[12];
      Object[] GXv_Object30 = new Object[2];
      scmdbuf = "SELECT T1.ConceptoPais AS ConceptoPais, T1.CliCod, T1.ConRelRef, T1.ConFormula, T2.ConveDescri, T1.ConBaseOSDif, T1.ConBaseLicProm, T1.ConBaseLic, T1.ConBaseHorExtProm," ;
      scmdbuf += " T1.ConBaseHorExt, T1.ConBaseFerProm, T1.ConBaseFer, T1.ConBaseAnt, T1.ConBasePres, T1.ConCodAfip, T1.ConSacDeven, T1.ConCondicion, T1.ConRecalcular, T1.ConFchModFor," ;
      scmdbuf += " T1.AplIIGG, T1.ConObservacion, T1.ConHabilitado, T1.ConVariable, T1.ConVigencia, T1.ConceptoConveCodigo AS ConceptoConveCodigo, T1.ConTipoLiqAux, T1.ConClasifAux," ;
      scmdbuf += " T1.TipoConCod, T1.ConDescrip, T1.ConCodigo FROM (Concepto T1 LEFT JOIN Convenio T2 ON T2.PaiCod = T1.ConceptoPais AND T2.ConveCodigo = T1.ConceptoConveCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      if ( ( AV150Conceptowwds_2_tfconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV149Conceptowwds_1_tfconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int29[1] = (byte)(1) ;
      }
      if ( AV150Conceptowwds_2_tfconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV150Conceptowwds_2_tfconcodigo_sels, "T1.ConCodigo IN (", ")")+")");
      }
      if ( ( AV152Conceptowwds_4_tfcondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV151Conceptowwds_3_tfcondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int29[2] = (byte)(1) ;
      }
      if ( AV152Conceptowwds_4_tfcondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV152Conceptowwds_4_tfcondescrip_sels, "T1.ConDescrip IN (", ")")+")");
      }
      if ( AV153Conceptowwds_5_tftipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV153Conceptowwds_5_tftipoconcod_sels, "T1.TipoConCod IN (", ")")+")");
      }
      if ( ( AV155Conceptowwds_7_tfconclasifaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV154Conceptowwds_6_tfconclasifaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConClasifAux) like LOWER(?))");
      }
      else
      {
         GXv_int29[3] = (byte)(1) ;
      }
      if ( AV155Conceptowwds_7_tfconclasifaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV155Conceptowwds_7_tfconclasifaux_sels, "T1.ConClasifAux IN (", ")")+")");
      }
      if ( ( AV157Conceptowwds_9_tfcontipoliqaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV156Conceptowwds_8_tfcontipoliqaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConTipoLiqAux) like LOWER(?))");
      }
      else
      {
         GXv_int29[4] = (byte)(1) ;
      }
      if ( AV157Conceptowwds_9_tfcontipoliqaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV157Conceptowwds_9_tfcontipoliqaux_sels, "T1.ConTipoLiqAux IN (", ")")+")");
      }
      if ( ( AV159Conceptowwds_11_tfconceptoconvecodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV158Conceptowwds_10_tfconceptoconvecodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.ConveDescri) like LOWER(?))");
      }
      else
      {
         GXv_int29[5] = (byte)(1) ;
      }
      if ( AV159Conceptowwds_11_tfconceptoconvecodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV159Conceptowwds_11_tfconceptoconvecodigo_sels, "T1.ConceptoConveCodigo IN (", ")")+")");
      }
      if ( AV160Conceptowwds_12_tfconvigencia_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV160Conceptowwds_12_tfconvigencia_sels, "T1.ConVigencia IN (", ")")+")");
      }
      if ( AV161Conceptowwds_13_tfconvariable_sel == 1 )
      {
         addWhere(sWhereString, "(T1.ConVariable = TRUE)");
      }
      if ( AV161Conceptowwds_13_tfconvariable_sel == 2 )
      {
         addWhere(sWhereString, "(T1.ConVariable = FALSE)");
      }
      if ( AV163Conceptowwds_15_tfconhabilitado_sel == 1 )
      {
         addWhere(sWhereString, "(T1.ConHabilitado = TRUE)");
      }
      if ( AV163Conceptowwds_15_tfconhabilitado_sel == 2 )
      {
         addWhere(sWhereString, "(T1.ConHabilitado = FALSE)");
      }
      if ( ( AV165Conceptowwds_17_tfconobservacion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV164Conceptowwds_16_tfconobservacion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConObservacion) like LOWER(?))");
      }
      else
      {
         GXv_int29[6] = (byte)(1) ;
      }
      if ( AV165Conceptowwds_17_tfconobservacion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV165Conceptowwds_17_tfconobservacion_sels, "T1.ConObservacion IN (", ")")+")");
      }
      if ( AV166Conceptowwds_18_tfapliigg_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV166Conceptowwds_18_tfapliigg_sels, "T1.AplIIGG IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV167Conceptowwds_19_tfconfchmodfor) )
      {
         addWhere(sWhereString, "(T1.ConFchModFor >= ?)");
      }
      else
      {
         GXv_int29[7] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV168Conceptowwds_20_tfconfchmodfor_to) )
      {
         addWhere(sWhereString, "(T1.ConFchModFor <= ?)");
      }
      else
      {
         GXv_int29[8] = (byte)(1) ;
      }
      if ( AV169Conceptowwds_21_tfconrecalcular_sel == 1 )
      {
         addWhere(sWhereString, "(T1.ConRecalcular = TRUE)");
      }
      if ( AV169Conceptowwds_21_tfconrecalcular_sel == 2 )
      {
         addWhere(sWhereString, "(T1.ConRecalcular = FALSE)");
      }
      if ( AV170Conceptowwds_22_tfconcondicion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV170Conceptowwds_22_tfconcondicion_sels, "T1.ConCondicion IN (", ")")+")");
      }
      if ( AV171Conceptowwds_23_tfconsacdeven_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV171Conceptowwds_23_tfconsacdeven_sels, "T1.ConSacDeven IN (", ")")+")");
      }
      if ( ( AV173Conceptowwds_25_tfconcodafip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV172Conceptowwds_24_tfconcodafip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConCodAfip) like LOWER(?))");
      }
      else
      {
         GXv_int29[9] = (byte)(1) ;
      }
      if ( AV173Conceptowwds_25_tfconcodafip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV173Conceptowwds_25_tfconcodafip_sels, "T1.ConCodAfip IN (", ")")+")");
      }
      if ( AV174Conceptowwds_26_tfconbasepres_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV174Conceptowwds_26_tfconbasepres_sels, "T1.ConBasePres IN (", ")")+")");
      }
      if ( AV175Conceptowwds_27_tfconbaseant_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV175Conceptowwds_27_tfconbaseant_sels, "T1.ConBaseAnt IN (", ")")+")");
      }
      if ( AV176Conceptowwds_28_tfconbasefer_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV176Conceptowwds_28_tfconbasefer_sels, "T1.ConBaseFer IN (", ")")+")");
      }
      if ( AV177Conceptowwds_29_tfconbaseferprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV177Conceptowwds_29_tfconbaseferprom_sels, "T1.ConBaseFerProm IN (", ")")+")");
      }
      if ( AV178Conceptowwds_30_tfconbasehorext_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV178Conceptowwds_30_tfconbasehorext_sels, "T1.ConBaseHorExt IN (", ")")+")");
      }
      if ( AV179Conceptowwds_31_tfconbasehorextprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV179Conceptowwds_31_tfconbasehorextprom_sels, "T1.ConBaseHorExtProm IN (", ")")+")");
      }
      if ( AV180Conceptowwds_32_tfconbaselic_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV180Conceptowwds_32_tfconbaselic_sels, "T1.ConBaseLic IN (", ")")+")");
      }
      if ( AV181Conceptowwds_33_tfconbaselicprom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV181Conceptowwds_33_tfconbaselicprom_sels, "T1.ConBaseLicProm IN (", ")")+")");
      }
      if ( AV182Conceptowwds_34_tfconbaseosdif_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV182Conceptowwds_34_tfconbaseosdif_sels, "T1.ConBaseOSDif IN (", ")")+")");
      }
      if ( ( AV184Conceptowwds_36_tfconrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV183Conceptowwds_35_tfconrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int29[10] = (byte)(1) ;
      }
      if ( AV184Conceptowwds_36_tfconrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV184Conceptowwds_36_tfconrelref_sels, "T1.ConRelRef IN (", ")")+")");
      }
      if ( ! (GXutil.strcmp("", AV25TFConFormula)==0) )
      {
         addWhere(sWhereString, "(T1.ConFormula like ?)");
      }
      else
      {
         GXv_int29[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.ConRelRef" ;
      GXv_Object30[0] = scmdbuf ;
      GXv_Object30[1] = GXv_int29 ;
      return GXv_Object30 ;
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
                  return conditional_P003V2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , ((Number) dynConstraints[12]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[13] , (String)dynConstraints[14] , (GXSimpleCollection<String>)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , ((Number) dynConstraints[20]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , ((Number) dynConstraints[24]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[25] , ((Number) dynConstraints[26]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[27] , ((Number) dynConstraints[28]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[29] , ((Number) dynConstraints[30]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[33] , ((Number) dynConstraints[34]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[35] , ((Number) dynConstraints[36]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[37] , ((Number) dynConstraints[38]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[39] , ((Number) dynConstraints[40]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[41] , (String)dynConstraints[42] , (GXSimpleCollection<String>)dynConstraints[43] , ((Number) dynConstraints[44]).intValue() , (String)dynConstraints[45] , ((Number) dynConstraints[46]).intValue() , (String)dynConstraints[47] , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , (String)dynConstraints[50] , ((Number) dynConstraints[51]).intValue() , (String)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , ((Number) dynConstraints[55]).intValue() , ((Number) dynConstraints[56]).byteValue() , ((Number) dynConstraints[57]).byteValue() , ((Number) dynConstraints[58]).intValue() , (String)dynConstraints[59] , ((Number) dynConstraints[60]).intValue() , (java.util.Date)dynConstraints[61] , (java.util.Date)dynConstraints[62] , ((Number) dynConstraints[63]).byteValue() , ((Number) dynConstraints[64]).intValue() , ((Number) dynConstraints[65]).intValue() , ((Number) dynConstraints[66]).intValue() , (String)dynConstraints[67] , ((Number) dynConstraints[68]).intValue() , ((Number) dynConstraints[69]).intValue() , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).intValue() , ((Number) dynConstraints[72]).intValue() , ((Number) dynConstraints[73]).intValue() , ((Number) dynConstraints[74]).intValue() , ((Number) dynConstraints[75]).intValue() , ((Number) dynConstraints[76]).intValue() , ((Number) dynConstraints[77]).intValue() , (String)dynConstraints[78] , (String)dynConstraints[79] , (String)dynConstraints[80] , ((Boolean) dynConstraints[81]).booleanValue() , ((Boolean) dynConstraints[82]).booleanValue() , (java.util.Date)dynConstraints[83] , ((Boolean) dynConstraints[84]).booleanValue() , (String)dynConstraints[85] , ((Number) dynConstraints[86]).intValue() , ((Number) dynConstraints[87]).intValue() );
            case 1 :
                  return conditional_P003V3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , ((Number) dynConstraints[12]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[13] , (String)dynConstraints[14] , (GXSimpleCollection<String>)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , ((Number) dynConstraints[20]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , ((Number) dynConstraints[24]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[25] , ((Number) dynConstraints[26]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[27] , ((Number) dynConstraints[28]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[29] , ((Number) dynConstraints[30]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[33] , ((Number) dynConstraints[34]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[35] , ((Number) dynConstraints[36]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[37] , ((Number) dynConstraints[38]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[39] , ((Number) dynConstraints[40]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[41] , (String)dynConstraints[42] , (GXSimpleCollection<String>)dynConstraints[43] , ((Number) dynConstraints[44]).intValue() , (String)dynConstraints[45] , ((Number) dynConstraints[46]).intValue() , (String)dynConstraints[47] , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , (String)dynConstraints[50] , ((Number) dynConstraints[51]).intValue() , (String)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , ((Number) dynConstraints[55]).intValue() , ((Number) dynConstraints[56]).byteValue() , ((Number) dynConstraints[57]).byteValue() , ((Number) dynConstraints[58]).intValue() , (String)dynConstraints[59] , ((Number) dynConstraints[60]).intValue() , (java.util.Date)dynConstraints[61] , (java.util.Date)dynConstraints[62] , ((Number) dynConstraints[63]).byteValue() , ((Number) dynConstraints[64]).intValue() , ((Number) dynConstraints[65]).intValue() , ((Number) dynConstraints[66]).intValue() , (String)dynConstraints[67] , ((Number) dynConstraints[68]).intValue() , ((Number) dynConstraints[69]).intValue() , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).intValue() , ((Number) dynConstraints[72]).intValue() , ((Number) dynConstraints[73]).intValue() , ((Number) dynConstraints[74]).intValue() , ((Number) dynConstraints[75]).intValue() , ((Number) dynConstraints[76]).intValue() , ((Number) dynConstraints[77]).intValue() , (String)dynConstraints[78] , (String)dynConstraints[79] , (String)dynConstraints[80] , ((Boolean) dynConstraints[81]).booleanValue() , ((Boolean) dynConstraints[82]).booleanValue() , (java.util.Date)dynConstraints[83] , ((Boolean) dynConstraints[84]).booleanValue() , (String)dynConstraints[85] , ((Number) dynConstraints[86]).intValue() , ((Number) dynConstraints[87]).intValue() );
            case 2 :
                  return conditional_P003V4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , ((Number) dynConstraints[12]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[13] , (String)dynConstraints[14] , (GXSimpleCollection<String>)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , ((Number) dynConstraints[20]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , ((Number) dynConstraints[24]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[25] , ((Number) dynConstraints[26]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[27] , ((Number) dynConstraints[28]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[29] , ((Number) dynConstraints[30]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[33] , ((Number) dynConstraints[34]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[35] , ((Number) dynConstraints[36]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[37] , ((Number) dynConstraints[38]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[39] , ((Number) dynConstraints[40]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[41] , (String)dynConstraints[42] , (GXSimpleCollection<String>)dynConstraints[43] , ((Number) dynConstraints[44]).intValue() , (String)dynConstraints[45] , ((Number) dynConstraints[46]).intValue() , (String)dynConstraints[47] , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , (String)dynConstraints[50] , ((Number) dynConstraints[51]).intValue() , (String)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , ((Number) dynConstraints[55]).intValue() , ((Number) dynConstraints[56]).byteValue() , ((Number) dynConstraints[57]).byteValue() , ((Number) dynConstraints[58]).intValue() , (String)dynConstraints[59] , ((Number) dynConstraints[60]).intValue() , (java.util.Date)dynConstraints[61] , (java.util.Date)dynConstraints[62] , ((Number) dynConstraints[63]).byteValue() , ((Number) dynConstraints[64]).intValue() , ((Number) dynConstraints[65]).intValue() , ((Number) dynConstraints[66]).intValue() , (String)dynConstraints[67] , ((Number) dynConstraints[68]).intValue() , ((Number) dynConstraints[69]).intValue() , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).intValue() , ((Number) dynConstraints[72]).intValue() , ((Number) dynConstraints[73]).intValue() , ((Number) dynConstraints[74]).intValue() , ((Number) dynConstraints[75]).intValue() , ((Number) dynConstraints[76]).intValue() , ((Number) dynConstraints[77]).intValue() , (String)dynConstraints[78] , (String)dynConstraints[79] , (String)dynConstraints[80] , ((Boolean) dynConstraints[81]).booleanValue() , ((Boolean) dynConstraints[82]).booleanValue() , (java.util.Date)dynConstraints[83] , ((Boolean) dynConstraints[84]).booleanValue() , (String)dynConstraints[85] , ((Number) dynConstraints[86]).intValue() , ((Number) dynConstraints[87]).intValue() );
            case 3 :
                  return conditional_P003V5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , ((Number) dynConstraints[12]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[13] , (String)dynConstraints[14] , (GXSimpleCollection<String>)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , ((Number) dynConstraints[20]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , ((Number) dynConstraints[24]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[25] , ((Number) dynConstraints[26]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[27] , ((Number) dynConstraints[28]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[29] , ((Number) dynConstraints[30]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[33] , ((Number) dynConstraints[34]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[35] , ((Number) dynConstraints[36]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[37] , ((Number) dynConstraints[38]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[39] , ((Number) dynConstraints[40]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[41] , (String)dynConstraints[42] , (GXSimpleCollection<String>)dynConstraints[43] , ((Number) dynConstraints[44]).intValue() , (String)dynConstraints[45] , ((Number) dynConstraints[46]).intValue() , (String)dynConstraints[47] , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , (String)dynConstraints[50] , ((Number) dynConstraints[51]).intValue() , (String)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , ((Number) dynConstraints[55]).intValue() , ((Number) dynConstraints[56]).byteValue() , ((Number) dynConstraints[57]).byteValue() , ((Number) dynConstraints[58]).intValue() , (String)dynConstraints[59] , ((Number) dynConstraints[60]).intValue() , (java.util.Date)dynConstraints[61] , (java.util.Date)dynConstraints[62] , ((Number) dynConstraints[63]).byteValue() , ((Number) dynConstraints[64]).intValue() , ((Number) dynConstraints[65]).intValue() , ((Number) dynConstraints[66]).intValue() , (String)dynConstraints[67] , ((Number) dynConstraints[68]).intValue() , ((Number) dynConstraints[69]).intValue() , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).intValue() , ((Number) dynConstraints[72]).intValue() , ((Number) dynConstraints[73]).intValue() , ((Number) dynConstraints[74]).intValue() , ((Number) dynConstraints[75]).intValue() , ((Number) dynConstraints[76]).intValue() , ((Number) dynConstraints[77]).intValue() , (String)dynConstraints[78] , (String)dynConstraints[79] , (String)dynConstraints[80] , ((Boolean) dynConstraints[81]).booleanValue() , ((Boolean) dynConstraints[82]).booleanValue() , (java.util.Date)dynConstraints[83] , ((Boolean) dynConstraints[84]).booleanValue() , (String)dynConstraints[85] , ((Number) dynConstraints[86]).intValue() , ((Number) dynConstraints[87]).intValue() );
            case 4 :
                  return conditional_P003V6(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , ((Number) dynConstraints[12]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[13] , (String)dynConstraints[14] , (GXSimpleCollection<String>)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , ((Number) dynConstraints[20]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , ((Number) dynConstraints[24]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[25] , ((Number) dynConstraints[26]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[27] , ((Number) dynConstraints[28]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[29] , ((Number) dynConstraints[30]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[33] , ((Number) dynConstraints[34]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[35] , ((Number) dynConstraints[36]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[37] , ((Number) dynConstraints[38]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[39] , ((Number) dynConstraints[40]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[41] , (String)dynConstraints[42] , (GXSimpleCollection<String>)dynConstraints[43] , ((Number) dynConstraints[44]).intValue() , (String)dynConstraints[45] , ((Number) dynConstraints[46]).intValue() , (String)dynConstraints[47] , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , (String)dynConstraints[50] , ((Number) dynConstraints[51]).intValue() , (String)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , ((Number) dynConstraints[55]).intValue() , ((Number) dynConstraints[56]).byteValue() , ((Number) dynConstraints[57]).byteValue() , ((Number) dynConstraints[58]).intValue() , (String)dynConstraints[59] , ((Number) dynConstraints[60]).intValue() , (java.util.Date)dynConstraints[61] , (java.util.Date)dynConstraints[62] , ((Number) dynConstraints[63]).byteValue() , ((Number) dynConstraints[64]).intValue() , ((Number) dynConstraints[65]).intValue() , ((Number) dynConstraints[66]).intValue() , (String)dynConstraints[67] , ((Number) dynConstraints[68]).intValue() , ((Number) dynConstraints[69]).intValue() , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).intValue() , ((Number) dynConstraints[72]).intValue() , ((Number) dynConstraints[73]).intValue() , ((Number) dynConstraints[74]).intValue() , ((Number) dynConstraints[75]).intValue() , ((Number) dynConstraints[76]).intValue() , ((Number) dynConstraints[77]).intValue() , (String)dynConstraints[78] , (String)dynConstraints[79] , (String)dynConstraints[80] , ((Boolean) dynConstraints[81]).booleanValue() , ((Boolean) dynConstraints[82]).booleanValue() , (java.util.Date)dynConstraints[83] , ((Boolean) dynConstraints[84]).booleanValue() , (String)dynConstraints[85] , ((Number) dynConstraints[86]).intValue() , ((Number) dynConstraints[87]).intValue() );
            case 5 :
                  return conditional_P003V7(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , ((Number) dynConstraints[12]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[13] , (String)dynConstraints[14] , (GXSimpleCollection<String>)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , ((Number) dynConstraints[20]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , ((Number) dynConstraints[24]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[25] , ((Number) dynConstraints[26]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[27] , ((Number) dynConstraints[28]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[29] , ((Number) dynConstraints[30]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[33] , ((Number) dynConstraints[34]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[35] , ((Number) dynConstraints[36]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[37] , ((Number) dynConstraints[38]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[39] , ((Number) dynConstraints[40]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[41] , (String)dynConstraints[42] , (GXSimpleCollection<String>)dynConstraints[43] , ((Number) dynConstraints[44]).intValue() , (String)dynConstraints[45] , ((Number) dynConstraints[46]).intValue() , (String)dynConstraints[47] , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , (String)dynConstraints[50] , ((Number) dynConstraints[51]).intValue() , (String)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , ((Number) dynConstraints[55]).intValue() , ((Number) dynConstraints[56]).byteValue() , ((Number) dynConstraints[57]).byteValue() , ((Number) dynConstraints[58]).intValue() , (String)dynConstraints[59] , ((Number) dynConstraints[60]).intValue() , (java.util.Date)dynConstraints[61] , (java.util.Date)dynConstraints[62] , ((Number) dynConstraints[63]).byteValue() , ((Number) dynConstraints[64]).intValue() , ((Number) dynConstraints[65]).intValue() , ((Number) dynConstraints[66]).intValue() , (String)dynConstraints[67] , ((Number) dynConstraints[68]).intValue() , ((Number) dynConstraints[69]).intValue() , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).intValue() , ((Number) dynConstraints[72]).intValue() , ((Number) dynConstraints[73]).intValue() , ((Number) dynConstraints[74]).intValue() , ((Number) dynConstraints[75]).intValue() , ((Number) dynConstraints[76]).intValue() , ((Number) dynConstraints[77]).intValue() , (String)dynConstraints[78] , (String)dynConstraints[79] , (String)dynConstraints[80] , ((Boolean) dynConstraints[81]).booleanValue() , ((Boolean) dynConstraints[82]).booleanValue() , (java.util.Date)dynConstraints[83] , ((Boolean) dynConstraints[84]).booleanValue() , (String)dynConstraints[85] , ((Number) dynConstraints[86]).intValue() , ((Number) dynConstraints[87]).intValue() );
            case 6 :
                  return conditional_P003V8(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , ((Number) dynConstraints[12]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[13] , (String)dynConstraints[14] , (GXSimpleCollection<String>)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , ((Number) dynConstraints[20]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , ((Number) dynConstraints[24]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[25] , ((Number) dynConstraints[26]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[27] , ((Number) dynConstraints[28]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[29] , ((Number) dynConstraints[30]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[33] , ((Number) dynConstraints[34]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[35] , ((Number) dynConstraints[36]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[37] , ((Number) dynConstraints[38]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[39] , ((Number) dynConstraints[40]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[41] , (String)dynConstraints[42] , (GXSimpleCollection<String>)dynConstraints[43] , ((Number) dynConstraints[44]).intValue() , (String)dynConstraints[45] , ((Number) dynConstraints[46]).intValue() , (String)dynConstraints[47] , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , (String)dynConstraints[50] , ((Number) dynConstraints[51]).intValue() , (String)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , ((Number) dynConstraints[55]).intValue() , ((Number) dynConstraints[56]).byteValue() , ((Number) dynConstraints[57]).byteValue() , ((Number) dynConstraints[58]).intValue() , (String)dynConstraints[59] , ((Number) dynConstraints[60]).intValue() , (java.util.Date)dynConstraints[61] , (java.util.Date)dynConstraints[62] , ((Number) dynConstraints[63]).byteValue() , ((Number) dynConstraints[64]).intValue() , ((Number) dynConstraints[65]).intValue() , ((Number) dynConstraints[66]).intValue() , (String)dynConstraints[67] , ((Number) dynConstraints[68]).intValue() , ((Number) dynConstraints[69]).intValue() , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).intValue() , ((Number) dynConstraints[72]).intValue() , ((Number) dynConstraints[73]).intValue() , ((Number) dynConstraints[74]).intValue() , ((Number) dynConstraints[75]).intValue() , ((Number) dynConstraints[76]).intValue() , ((Number) dynConstraints[77]).intValue() , (String)dynConstraints[78] , (String)dynConstraints[79] , (String)dynConstraints[80] , ((Boolean) dynConstraints[81]).booleanValue() , ((Boolean) dynConstraints[82]).booleanValue() , (java.util.Date)dynConstraints[83] , ((Boolean) dynConstraints[84]).booleanValue() , (String)dynConstraints[85] , ((Number) dynConstraints[86]).intValue() , ((Number) dynConstraints[87]).intValue() );
            case 7 :
                  return conditional_P003V9(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , ((Number) dynConstraints[12]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[13] , (String)dynConstraints[14] , (GXSimpleCollection<String>)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , ((Number) dynConstraints[20]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , ((Number) dynConstraints[24]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[25] , ((Number) dynConstraints[26]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[27] , ((Number) dynConstraints[28]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[29] , ((Number) dynConstraints[30]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[31] , ((Number) dynConstraints[32]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[33] , ((Number) dynConstraints[34]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[35] , ((Number) dynConstraints[36]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[37] , ((Number) dynConstraints[38]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[39] , ((Number) dynConstraints[40]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[41] , (String)dynConstraints[42] , (GXSimpleCollection<String>)dynConstraints[43] , ((Number) dynConstraints[44]).intValue() , (String)dynConstraints[45] , ((Number) dynConstraints[46]).intValue() , (String)dynConstraints[47] , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , (String)dynConstraints[50] , ((Number) dynConstraints[51]).intValue() , (String)dynConstraints[52] , ((Number) dynConstraints[53]).intValue() , (String)dynConstraints[54] , ((Number) dynConstraints[55]).intValue() , ((Number) dynConstraints[56]).byteValue() , ((Number) dynConstraints[57]).byteValue() , ((Number) dynConstraints[58]).intValue() , (String)dynConstraints[59] , ((Number) dynConstraints[60]).intValue() , (java.util.Date)dynConstraints[61] , (java.util.Date)dynConstraints[62] , ((Number) dynConstraints[63]).byteValue() , ((Number) dynConstraints[64]).intValue() , ((Number) dynConstraints[65]).intValue() , ((Number) dynConstraints[66]).intValue() , (String)dynConstraints[67] , ((Number) dynConstraints[68]).intValue() , ((Number) dynConstraints[69]).intValue() , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).intValue() , ((Number) dynConstraints[72]).intValue() , ((Number) dynConstraints[73]).intValue() , ((Number) dynConstraints[74]).intValue() , ((Number) dynConstraints[75]).intValue() , ((Number) dynConstraints[76]).intValue() , ((Number) dynConstraints[77]).intValue() , (String)dynConstraints[78] , (String)dynConstraints[79] , (String)dynConstraints[80] , ((Boolean) dynConstraints[81]).booleanValue() , ((Boolean) dynConstraints[82]).booleanValue() , (java.util.Date)dynConstraints[83] , ((Boolean) dynConstraints[84]).booleanValue() , (String)dynConstraints[85] , ((Number) dynConstraints[86]).intValue() , ((Number) dynConstraints[87]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P003V2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003V3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003V4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003V5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003V6", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003V7", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003V8", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003V9", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((String[]) buf[3])[0] = rslt.getString(3, 10);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(6);
               ((byte[]) buf[9])[0] = rslt.getByte(7);
               ((byte[]) buf[10])[0] = rslt.getByte(8);
               ((byte[]) buf[11])[0] = rslt.getByte(9);
               ((byte[]) buf[12])[0] = rslt.getByte(10);
               ((byte[]) buf[13])[0] = rslt.getByte(11);
               ((byte[]) buf[14])[0] = rslt.getByte(12);
               ((byte[]) buf[15])[0] = rslt.getByte(13);
               ((byte[]) buf[16])[0] = rslt.getByte(14);
               ((byte[]) buf[17])[0] = rslt.getByte(15);
               ((String[]) buf[18])[0] = rslt.getString(16, 6);
               ((byte[]) buf[19])[0] = rslt.getByte(17);
               ((String[]) buf[20])[0] = rslt.getString(18, 20);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((boolean[]) buf[22])[0] = rslt.getBoolean(19);
               ((java.util.Date[]) buf[23])[0] = rslt.getGXDateTime(20);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((short[]) buf[25])[0] = rslt.getShort(21);
               ((boolean[]) buf[26])[0] = rslt.wasNull();
               ((String[]) buf[27])[0] = rslt.getLongVarchar(22);
               ((boolean[]) buf[28])[0] = rslt.getBoolean(23);
               ((boolean[]) buf[29])[0] = rslt.getBoolean(24);
               ((byte[]) buf[30])[0] = rslt.getByte(25);
               ((String[]) buf[31])[0] = rslt.getString(26, 20);
               ((boolean[]) buf[32])[0] = rslt.wasNull();
               ((String[]) buf[33])[0] = rslt.getVarchar(27);
               ((boolean[]) buf[34])[0] = rslt.wasNull();
               ((String[]) buf[35])[0] = rslt.getVarchar(28);
               ((boolean[]) buf[36])[0] = rslt.wasNull();
               ((String[]) buf[37])[0] = rslt.getString(29, 20);
               ((String[]) buf[38])[0] = rslt.getVarchar(30);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(6);
               ((byte[]) buf[9])[0] = rslt.getByte(7);
               ((byte[]) buf[10])[0] = rslt.getByte(8);
               ((byte[]) buf[11])[0] = rslt.getByte(9);
               ((byte[]) buf[12])[0] = rslt.getByte(10);
               ((byte[]) buf[13])[0] = rslt.getByte(11);
               ((byte[]) buf[14])[0] = rslt.getByte(12);
               ((byte[]) buf[15])[0] = rslt.getByte(13);
               ((byte[]) buf[16])[0] = rslt.getByte(14);
               ((byte[]) buf[17])[0] = rslt.getByte(15);
               ((String[]) buf[18])[0] = rslt.getString(16, 6);
               ((byte[]) buf[19])[0] = rslt.getByte(17);
               ((String[]) buf[20])[0] = rslt.getString(18, 20);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((boolean[]) buf[22])[0] = rslt.getBoolean(19);
               ((java.util.Date[]) buf[23])[0] = rslt.getGXDateTime(20);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((short[]) buf[25])[0] = rslt.getShort(21);
               ((boolean[]) buf[26])[0] = rslt.wasNull();
               ((String[]) buf[27])[0] = rslt.getLongVarchar(22);
               ((boolean[]) buf[28])[0] = rslt.getBoolean(23);
               ((boolean[]) buf[29])[0] = rslt.getBoolean(24);
               ((byte[]) buf[30])[0] = rslt.getByte(25);
               ((String[]) buf[31])[0] = rslt.getString(26, 20);
               ((boolean[]) buf[32])[0] = rslt.wasNull();
               ((String[]) buf[33])[0] = rslt.getVarchar(27);
               ((boolean[]) buf[34])[0] = rslt.wasNull();
               ((String[]) buf[35])[0] = rslt.getVarchar(28);
               ((boolean[]) buf[36])[0] = rslt.wasNull();
               ((String[]) buf[37])[0] = rslt.getString(29, 20);
               ((String[]) buf[38])[0] = rslt.getString(30, 10);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getVarchar(6);
               ((byte[]) buf[10])[0] = rslt.getByte(7);
               ((byte[]) buf[11])[0] = rslt.getByte(8);
               ((byte[]) buf[12])[0] = rslt.getByte(9);
               ((byte[]) buf[13])[0] = rslt.getByte(10);
               ((byte[]) buf[14])[0] = rslt.getByte(11);
               ((byte[]) buf[15])[0] = rslt.getByte(12);
               ((byte[]) buf[16])[0] = rslt.getByte(13);
               ((byte[]) buf[17])[0] = rslt.getByte(14);
               ((byte[]) buf[18])[0] = rslt.getByte(15);
               ((String[]) buf[19])[0] = rslt.getString(16, 6);
               ((byte[]) buf[20])[0] = rslt.getByte(17);
               ((String[]) buf[21])[0] = rslt.getString(18, 20);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((boolean[]) buf[23])[0] = rslt.getBoolean(19);
               ((java.util.Date[]) buf[24])[0] = rslt.getGXDateTime(20);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((short[]) buf[26])[0] = rslt.getShort(21);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((String[]) buf[28])[0] = rslt.getLongVarchar(22);
               ((boolean[]) buf[29])[0] = rslt.getBoolean(23);
               ((boolean[]) buf[30])[0] = rslt.getBoolean(24);
               ((byte[]) buf[31])[0] = rslt.getByte(25);
               ((String[]) buf[32])[0] = rslt.getString(26, 20);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
               ((String[]) buf[34])[0] = rslt.getVarchar(27);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((String[]) buf[36])[0] = rslt.getString(28, 20);
               ((String[]) buf[37])[0] = rslt.getVarchar(29);
               ((String[]) buf[38])[0] = rslt.getString(30, 10);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getVarchar(6);
               ((byte[]) buf[10])[0] = rslt.getByte(7);
               ((byte[]) buf[11])[0] = rslt.getByte(8);
               ((byte[]) buf[12])[0] = rslt.getByte(9);
               ((byte[]) buf[13])[0] = rslt.getByte(10);
               ((byte[]) buf[14])[0] = rslt.getByte(11);
               ((byte[]) buf[15])[0] = rslt.getByte(12);
               ((byte[]) buf[16])[0] = rslt.getByte(13);
               ((byte[]) buf[17])[0] = rslt.getByte(14);
               ((byte[]) buf[18])[0] = rslt.getByte(15);
               ((String[]) buf[19])[0] = rslt.getString(16, 6);
               ((byte[]) buf[20])[0] = rslt.getByte(17);
               ((String[]) buf[21])[0] = rslt.getString(18, 20);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((boolean[]) buf[23])[0] = rslt.getBoolean(19);
               ((java.util.Date[]) buf[24])[0] = rslt.getGXDateTime(20);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((short[]) buf[26])[0] = rslt.getShort(21);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((String[]) buf[28])[0] = rslt.getLongVarchar(22);
               ((boolean[]) buf[29])[0] = rslt.getBoolean(23);
               ((boolean[]) buf[30])[0] = rslt.getBoolean(24);
               ((byte[]) buf[31])[0] = rslt.getByte(25);
               ((String[]) buf[32])[0] = rslt.getString(26, 20);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
               ((String[]) buf[34])[0] = rslt.getVarchar(27);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((String[]) buf[36])[0] = rslt.getString(28, 20);
               ((String[]) buf[37])[0] = rslt.getVarchar(29);
               ((String[]) buf[38])[0] = rslt.getString(30, 10);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getVarchar(6);
               ((byte[]) buf[10])[0] = rslt.getByte(7);
               ((byte[]) buf[11])[0] = rslt.getByte(8);
               ((byte[]) buf[12])[0] = rslt.getByte(9);
               ((byte[]) buf[13])[0] = rslt.getByte(10);
               ((byte[]) buf[14])[0] = rslt.getByte(11);
               ((byte[]) buf[15])[0] = rslt.getByte(12);
               ((byte[]) buf[16])[0] = rslt.getByte(13);
               ((byte[]) buf[17])[0] = rslt.getByte(14);
               ((byte[]) buf[18])[0] = rslt.getByte(15);
               ((String[]) buf[19])[0] = rslt.getString(16, 6);
               ((byte[]) buf[20])[0] = rslt.getByte(17);
               ((String[]) buf[21])[0] = rslt.getString(18, 20);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((boolean[]) buf[23])[0] = rslt.getBoolean(19);
               ((java.util.Date[]) buf[24])[0] = rslt.getGXDateTime(20);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((short[]) buf[26])[0] = rslt.getShort(21);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((String[]) buf[28])[0] = rslt.getLongVarchar(22);
               ((boolean[]) buf[29])[0] = rslt.getBoolean(23);
               ((boolean[]) buf[30])[0] = rslt.getBoolean(24);
               ((byte[]) buf[31])[0] = rslt.getByte(25);
               ((String[]) buf[32])[0] = rslt.getVarchar(26);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
               ((String[]) buf[34])[0] = rslt.getVarchar(27);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((String[]) buf[36])[0] = rslt.getString(28, 20);
               ((String[]) buf[37])[0] = rslt.getVarchar(29);
               ((String[]) buf[38])[0] = rslt.getString(30, 10);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(6);
               ((byte[]) buf[9])[0] = rslt.getByte(7);
               ((byte[]) buf[10])[0] = rslt.getByte(8);
               ((byte[]) buf[11])[0] = rslt.getByte(9);
               ((byte[]) buf[12])[0] = rslt.getByte(10);
               ((byte[]) buf[13])[0] = rslt.getByte(11);
               ((byte[]) buf[14])[0] = rslt.getByte(12);
               ((byte[]) buf[15])[0] = rslt.getByte(13);
               ((byte[]) buf[16])[0] = rslt.getByte(14);
               ((byte[]) buf[17])[0] = rslt.getByte(15);
               ((String[]) buf[18])[0] = rslt.getString(16, 6);
               ((byte[]) buf[19])[0] = rslt.getByte(17);
               ((String[]) buf[20])[0] = rslt.getString(18, 20);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((boolean[]) buf[22])[0] = rslt.getBoolean(19);
               ((java.util.Date[]) buf[23])[0] = rslt.getGXDateTime(20);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((short[]) buf[25])[0] = rslt.getShort(21);
               ((boolean[]) buf[26])[0] = rslt.wasNull();
               ((boolean[]) buf[27])[0] = rslt.getBoolean(22);
               ((boolean[]) buf[28])[0] = rslt.getBoolean(23);
               ((byte[]) buf[29])[0] = rslt.getByte(24);
               ((String[]) buf[30])[0] = rslt.getString(25, 20);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getVarchar(26);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
               ((String[]) buf[34])[0] = rslt.getVarchar(27);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((String[]) buf[36])[0] = rslt.getString(28, 20);
               ((String[]) buf[37])[0] = rslt.getVarchar(29);
               ((String[]) buf[38])[0] = rslt.getString(30, 10);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((String[]) buf[3])[0] = rslt.getString(3, 6);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(6);
               ((byte[]) buf[9])[0] = rslt.getByte(7);
               ((byte[]) buf[10])[0] = rslt.getByte(8);
               ((byte[]) buf[11])[0] = rslt.getByte(9);
               ((byte[]) buf[12])[0] = rslt.getByte(10);
               ((byte[]) buf[13])[0] = rslt.getByte(11);
               ((byte[]) buf[14])[0] = rslt.getByte(12);
               ((byte[]) buf[15])[0] = rslt.getByte(13);
               ((byte[]) buf[16])[0] = rslt.getByte(14);
               ((byte[]) buf[17])[0] = rslt.getByte(15);
               ((byte[]) buf[18])[0] = rslt.getByte(16);
               ((String[]) buf[19])[0] = rslt.getString(17, 20);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((boolean[]) buf[21])[0] = rslt.getBoolean(18);
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDateTime(19);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((short[]) buf[24])[0] = rslt.getShort(20);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((String[]) buf[26])[0] = rslt.getLongVarchar(21);
               ((boolean[]) buf[27])[0] = rslt.getBoolean(22);
               ((boolean[]) buf[28])[0] = rslt.getBoolean(23);
               ((byte[]) buf[29])[0] = rslt.getByte(24);
               ((String[]) buf[30])[0] = rslt.getString(25, 20);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getVarchar(26);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
               ((String[]) buf[34])[0] = rslt.getVarchar(27);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((String[]) buf[36])[0] = rslt.getString(28, 20);
               ((String[]) buf[37])[0] = rslt.getVarchar(29);
               ((String[]) buf[38])[0] = rslt.getString(30, 10);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((byte[]) buf[8])[0] = rslt.getByte(6);
               ((byte[]) buf[9])[0] = rslt.getByte(7);
               ((byte[]) buf[10])[0] = rslt.getByte(8);
               ((byte[]) buf[11])[0] = rslt.getByte(9);
               ((byte[]) buf[12])[0] = rslt.getByte(10);
               ((byte[]) buf[13])[0] = rslt.getByte(11);
               ((byte[]) buf[14])[0] = rslt.getByte(12);
               ((byte[]) buf[15])[0] = rslt.getByte(13);
               ((byte[]) buf[16])[0] = rslt.getByte(14);
               ((String[]) buf[17])[0] = rslt.getString(15, 6);
               ((byte[]) buf[18])[0] = rslt.getByte(16);
               ((String[]) buf[19])[0] = rslt.getString(17, 20);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((boolean[]) buf[21])[0] = rslt.getBoolean(18);
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDateTime(19);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((short[]) buf[24])[0] = rslt.getShort(20);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((String[]) buf[26])[0] = rslt.getLongVarchar(21);
               ((boolean[]) buf[27])[0] = rslt.getBoolean(22);
               ((boolean[]) buf[28])[0] = rslt.getBoolean(23);
               ((byte[]) buf[29])[0] = rslt.getByte(24);
               ((String[]) buf[30])[0] = rslt.getString(25, 20);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getVarchar(26);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
               ((String[]) buf[34])[0] = rslt.getVarchar(27);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((String[]) buf[36])[0] = rslt.getString(28, 20);
               ((String[]) buf[37])[0] = rslt.getVarchar(29);
               ((String[]) buf[38])[0] = rslt.getString(30, 10);
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
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 10);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 80);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 200);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[19], false);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[20], false);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 6);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 40);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 200);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 10);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 80);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 200);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[19], false);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[20], false);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 6);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 40);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 200);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 10);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 80);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 200);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[19], false);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[20], false);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 6);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 40);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 200);
               }
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 10);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 80);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 200);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[19], false);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[20], false);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 6);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 40);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 200);
               }
               return;
            case 4 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 10);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 80);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 200);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[19], false);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[20], false);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 6);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 40);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 200);
               }
               return;
            case 5 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 10);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 80);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 200);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[19], false);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[20], false);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 6);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 40);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 200);
               }
               return;
            case 6 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 10);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 80);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 200);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[19], false);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[20], false);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 6);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 40);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 200);
               }
               return;
            case 7 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 10);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 80);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 200);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[19], false);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[20], false);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 6);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 40);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 200);
               }
               return;
      }
   }

}

