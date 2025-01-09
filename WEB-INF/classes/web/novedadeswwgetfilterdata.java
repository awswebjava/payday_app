package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class novedadeswwgetfilterdata extends GXProcedure
{
   public novedadeswwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( novedadeswwgetfilterdata.class ), "" );
   }

   public novedadeswwgetfilterdata( int remoteHandle ,
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
      novedadeswwgetfilterdata.this.aP5 = new String[] {""};
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
      novedadeswwgetfilterdata.this.AV43DDOName = aP0;
      novedadeswwgetfilterdata.this.AV41SearchTxt = aP1;
      novedadeswwgetfilterdata.this.AV42SearchTxtTo = aP2;
      novedadeswwgetfilterdata.this.aP3 = aP3;
      novedadeswwgetfilterdata.this.aP4 = aP4;
      novedadeswwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV73EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      novedadeswwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV73EmpCod = GXt_int1 ;
      GXt_int3 = AV72CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      novedadeswwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV72CliCod = GXt_int3 ;
      AV46Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV49OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV51OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWNovedades", GXv_boolean6) ;
      novedadeswwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV43DDOName), "DDO_LEGID") == 0 )
         {
            /* Execute user subroutine: 'LOADLEGIDOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV43DDOName), "DDO_LEGNOMAPE") == 0 )
         {
            /* Execute user subroutine: 'LOADLEGNOMAPEOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV43DDOName), "DDO_CONCODIGO") == 0 )
         {
            /* Execute user subroutine: 'LOADCONCODIGOOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV43DDOName), "DDO_CONDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADCONDESCRIPOPTIONS' */
            S151 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV43DDOName), "DDO_AGEPERDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADAGEPERDESCRIPOPTIONS' */
            S161 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV43DDOName), "DDO_AGEFECDES") == 0 )
         {
            /* Execute user subroutine: 'LOADAGEFECDESOPTIONS' */
            S171 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV43DDOName), "DDO_AGEFECHAS") == 0 )
         {
            /* Execute user subroutine: 'LOADAGEFECHASOPTIONS' */
            S181 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV47OptionsJson = AV46Options.toJSonString(false) ;
      AV50OptionsDescJson = AV49OptionsDesc.toJSonString(false) ;
      AV52OptionIndexesJson = AV51OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV54Session.getValue("NovedadesWWGridState"), "") == 0 )
      {
         AV56GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "NovedadesWWGridState"), null, null);
      }
      else
      {
         AV56GridState.fromxml(AV54Session.getValue("NovedadesWWGridState"), null, null);
      }
      AV102GXV1 = 1 ;
      while ( AV102GXV1 <= AV56GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV57GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV56GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV102GXV1));
         if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "VERLIQUIDADAS") == 0 )
         {
            AV91VerLiquidadas = GXutil.boolval( AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGID") == 0 )
         {
            AV39TFLegId = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGID_SEL") == 0 )
         {
            AV70TFLegId_SelsJson = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV71TFLegId_Sels.fromJSonString(AV70TFLegId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGNOMAPE") == 0 )
         {
            AV81TFLegNomApe = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGNOMAPE_SEL") == 0 )
         {
            AV80TFLegNomApe_SelsJson = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV82TFLegNomApe_Sels.fromJSonString(AV80TFLegNomApe_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODIGO") == 0 )
         {
            AV24TFConCodigo = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODIGO_SEL") == 0 )
         {
            AV66TFConCodigo_SelsJson = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV67TFConCodigo_Sels.fromJSonString(AV66TFConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDESCRIP") == 0 )
         {
            AV26TFConDescrip = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDESCRIP_SEL") == 0 )
         {
            AV68TFConDescrip_SelsJson = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV69TFConDescrip_Sels.fromJSonString(AV68TFConDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOCONCOD_SEL") == 0 )
         {
            AV78TFTipoConCod_SelsJson = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV79TFTipoConCod_Sels.fromJSonString(AV78TFTipoConCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAGECANTI") == 0 )
         {
            AV28TFAgeCanti = CommonUtil.decimalVal( AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV29TFAgeCanti_To = CommonUtil.decimalVal( AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAGEPERDESCRIP") == 0 )
         {
            AV98TFAgePerDescrip = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAGEPERDESCRIP_SEL") == 0 )
         {
            AV97TFAgePerDescrip_SelsJson = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV99TFAgePerDescrip_Sels.fromJSonString(AV97TFAgePerDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAGEFECDES") == 0 )
         {
            AV34TFAgeFecDes = localUtil.ctod( AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAGEFECDES_SEL") == 0 )
         {
            AV92TFAgeFecDes_SelsJson = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV93TFAgeFecDes_Sels.fromJSonString(AV92TFAgeFecDes_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAGEFECHAS") == 0 )
         {
            AV36TFAgeFecHas = localUtil.ctod( AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAGEFECHAS_SEL") == 0 )
         {
            AV94TFAgeFecHas_SelsJson = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV95TFAgeFecHas_Sels.fromJSonString(AV94TFAgeFecHas_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAGELIQNRO") == 0 )
         {
            AV89TFAgeLiqNro = (int)(GXutil.lval( AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV90TFAgeLiqNro_To = (int)(GXutil.lval( AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV96MenuOpcCod = AV57GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV102GXV1 = (int)(AV102GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADLEGIDOPTIONS' Routine */
      returnInSub = false ;
      AV39TFLegId = AV41SearchTxt ;
      AV71TFLegId_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A93LegId ,
                                           AV71TFLegId_Sels ,
                                           A591LegNomApe ,
                                           AV82TFLegNomApe_Sels ,
                                           A26ConCodigo ,
                                           AV67TFConCodigo_Sels ,
                                           A41ConDescrip ,
                                           AV69TFConDescrip_Sels ,
                                           A37TipoConCod ,
                                           AV79TFTipoConCod_Sels ,
                                           A2159AgePerDescrip ,
                                           AV99TFAgePerDescrip_Sels ,
                                           A111AgeFecDes ,
                                           AV93TFAgeFecDes_Sels ,
                                           A112AgeFecHas ,
                                           AV95TFAgeFecHas_Sels ,
                                           Boolean.valueOf(AV91VerLiquidadas) ,
                                           Integer.valueOf(AV71TFLegId_Sels.size()) ,
                                           AV39TFLegId ,
                                           Integer.valueOf(AV82TFLegNomApe_Sels.size()) ,
                                           AV81TFLegNomApe ,
                                           Integer.valueOf(AV67TFConCodigo_Sels.size()) ,
                                           AV24TFConCodigo ,
                                           Integer.valueOf(AV69TFConDescrip_Sels.size()) ,
                                           AV26TFConDescrip ,
                                           Integer.valueOf(AV79TFTipoConCod_Sels.size()) ,
                                           AV28TFAgeCanti ,
                                           AV29TFAgeCanti_To ,
                                           Integer.valueOf(AV99TFAgePerDescrip_Sels.size()) ,
                                           AV98TFAgePerDescrip ,
                                           Integer.valueOf(AV93TFAgeFecDes_Sels.size()) ,
                                           Integer.valueOf(AV95TFAgeFecHas_Sels.size()) ,
                                           Integer.valueOf(AV89TFAgeLiqNro) ,
                                           Integer.valueOf(AV90TFAgeLiqNro_To) ,
                                           Integer.valueOf(A1254AgeLiqNro) ,
                                           A110AgeCanti ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV72CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV73EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE,
                                           TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV39TFLegId = GXutil.padr( GXutil.rtrim( AV39TFLegId), 20, "%") ;
      lV81TFLegNomApe = GXutil.concat( GXutil.rtrim( AV81TFLegNomApe), "%", "") ;
      lV24TFConCodigo = GXutil.padr( GXutil.rtrim( AV24TFConCodigo), 10, "%") ;
      lV26TFConDescrip = GXutil.concat( GXutil.rtrim( AV26TFConDescrip), "%", "") ;
      lV98TFAgePerDescrip = GXutil.concat( GXutil.rtrim( AV98TFAgePerDescrip), "%", "") ;
      /* Using cursor P006O2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV72CliCod), Short.valueOf(AV73EmpCod), lV39TFLegId, lV81TFLegNomApe, lV24TFConCodigo, lV26TFConDescrip, AV28TFAgeCanti, AV29TFAgeCanti_To, lV98TFAgePerDescrip, Integer.valueOf(AV89TFAgeLiqNro), Integer.valueOf(AV90TFAgeLiqNro_To)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk6O2 = false ;
         A6LegNumero = P006O2_A6LegNumero[0] ;
         A3CliCod = P006O2_A3CliCod[0] ;
         A1EmpCod = P006O2_A1EmpCod[0] ;
         A93LegId = P006O2_A93LegId[0] ;
         n93LegId = P006O2_n93LegId[0] ;
         A112AgeFecHas = P006O2_A112AgeFecHas[0] ;
         n112AgeFecHas = P006O2_n112AgeFecHas[0] ;
         A111AgeFecDes = P006O2_A111AgeFecDes[0] ;
         n111AgeFecDes = P006O2_n111AgeFecDes[0] ;
         A2159AgePerDescrip = P006O2_A2159AgePerDescrip[0] ;
         A110AgeCanti = P006O2_A110AgeCanti[0] ;
         n110AgeCanti = P006O2_n110AgeCanti[0] ;
         A37TipoConCod = P006O2_A37TipoConCod[0] ;
         A41ConDescrip = P006O2_A41ConDescrip[0] ;
         A26ConCodigo = P006O2_A26ConCodigo[0] ;
         A591LegNomApe = P006O2_A591LegNomApe[0] ;
         A1254AgeLiqNro = P006O2_A1254AgeLiqNro[0] ;
         n1254AgeLiqNro = P006O2_n1254AgeLiqNro[0] ;
         A25AgeOrden = P006O2_A25AgeOrden[0] ;
         A93LegId = P006O2_A93LegId[0] ;
         n93LegId = P006O2_n93LegId[0] ;
         A591LegNomApe = P006O2_A591LegNomApe[0] ;
         A37TipoConCod = P006O2_A37TipoConCod[0] ;
         A41ConDescrip = P006O2_A41ConDescrip[0] ;
         AV53count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P006O2_A93LegId[0], A93LegId) == 0 ) )
         {
            brk6O2 = false ;
            A6LegNumero = P006O2_A6LegNumero[0] ;
            A3CliCod = P006O2_A3CliCod[0] ;
            A1EmpCod = P006O2_A1EmpCod[0] ;
            A25AgeOrden = P006O2_A25AgeOrden[0] ;
            AV53count = (long)(AV53count+1) ;
            brk6O2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A93LegId)==0) )
         {
            AV45Option = A93LegId ;
            AV46Options.add(AV45Option, 0);
            AV51OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV53count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV46Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6O2 )
         {
            brk6O2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADLEGNOMAPEOPTIONS' Routine */
      returnInSub = false ;
      AV81TFLegNomApe = AV41SearchTxt ;
      AV82TFLegNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A93LegId ,
                                           AV71TFLegId_Sels ,
                                           A591LegNomApe ,
                                           AV82TFLegNomApe_Sels ,
                                           A26ConCodigo ,
                                           AV67TFConCodigo_Sels ,
                                           A41ConDescrip ,
                                           AV69TFConDescrip_Sels ,
                                           A37TipoConCod ,
                                           AV79TFTipoConCod_Sels ,
                                           A2159AgePerDescrip ,
                                           AV99TFAgePerDescrip_Sels ,
                                           A111AgeFecDes ,
                                           AV93TFAgeFecDes_Sels ,
                                           A112AgeFecHas ,
                                           AV95TFAgeFecHas_Sels ,
                                           Boolean.valueOf(AV91VerLiquidadas) ,
                                           Integer.valueOf(AV71TFLegId_Sels.size()) ,
                                           AV39TFLegId ,
                                           Integer.valueOf(AV82TFLegNomApe_Sels.size()) ,
                                           AV81TFLegNomApe ,
                                           Integer.valueOf(AV67TFConCodigo_Sels.size()) ,
                                           AV24TFConCodigo ,
                                           Integer.valueOf(AV69TFConDescrip_Sels.size()) ,
                                           AV26TFConDescrip ,
                                           Integer.valueOf(AV79TFTipoConCod_Sels.size()) ,
                                           AV28TFAgeCanti ,
                                           AV29TFAgeCanti_To ,
                                           Integer.valueOf(AV99TFAgePerDescrip_Sels.size()) ,
                                           AV98TFAgePerDescrip ,
                                           Integer.valueOf(AV93TFAgeFecDes_Sels.size()) ,
                                           Integer.valueOf(AV95TFAgeFecHas_Sels.size()) ,
                                           Integer.valueOf(AV89TFAgeLiqNro) ,
                                           Integer.valueOf(AV90TFAgeLiqNro_To) ,
                                           Integer.valueOf(A1254AgeLiqNro) ,
                                           A110AgeCanti ,
                                           Integer.valueOf(AV72CliCod) ,
                                           Short.valueOf(AV73EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE,
                                           TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV39TFLegId = GXutil.padr( GXutil.rtrim( AV39TFLegId), 20, "%") ;
      lV81TFLegNomApe = GXutil.concat( GXutil.rtrim( AV81TFLegNomApe), "%", "") ;
      lV24TFConCodigo = GXutil.padr( GXutil.rtrim( AV24TFConCodigo), 10, "%") ;
      lV26TFConDescrip = GXutil.concat( GXutil.rtrim( AV26TFConDescrip), "%", "") ;
      lV98TFAgePerDescrip = GXutil.concat( GXutil.rtrim( AV98TFAgePerDescrip), "%", "") ;
      /* Using cursor P006O3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV72CliCod), Short.valueOf(AV73EmpCod), lV39TFLegId, lV81TFLegNomApe, lV24TFConCodigo, lV26TFConDescrip, AV28TFAgeCanti, AV29TFAgeCanti_To, lV98TFAgePerDescrip, Integer.valueOf(AV89TFAgeLiqNro), Integer.valueOf(AV90TFAgeLiqNro_To)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A6LegNumero = P006O3_A6LegNumero[0] ;
         A1EmpCod = P006O3_A1EmpCod[0] ;
         A3CliCod = P006O3_A3CliCod[0] ;
         A112AgeFecHas = P006O3_A112AgeFecHas[0] ;
         n112AgeFecHas = P006O3_n112AgeFecHas[0] ;
         A111AgeFecDes = P006O3_A111AgeFecDes[0] ;
         n111AgeFecDes = P006O3_n111AgeFecDes[0] ;
         A2159AgePerDescrip = P006O3_A2159AgePerDescrip[0] ;
         A110AgeCanti = P006O3_A110AgeCanti[0] ;
         n110AgeCanti = P006O3_n110AgeCanti[0] ;
         A37TipoConCod = P006O3_A37TipoConCod[0] ;
         A41ConDescrip = P006O3_A41ConDescrip[0] ;
         A26ConCodigo = P006O3_A26ConCodigo[0] ;
         A591LegNomApe = P006O3_A591LegNomApe[0] ;
         A93LegId = P006O3_A93LegId[0] ;
         n93LegId = P006O3_n93LegId[0] ;
         A1254AgeLiqNro = P006O3_A1254AgeLiqNro[0] ;
         n1254AgeLiqNro = P006O3_n1254AgeLiqNro[0] ;
         A25AgeOrden = P006O3_A25AgeOrden[0] ;
         A591LegNomApe = P006O3_A591LegNomApe[0] ;
         A93LegId = P006O3_A93LegId[0] ;
         n93LegId = P006O3_n93LegId[0] ;
         A37TipoConCod = P006O3_A37TipoConCod[0] ;
         A41ConDescrip = P006O3_A41ConDescrip[0] ;
         if ( ! (GXutil.strcmp("", A591LegNomApe)==0) )
         {
            AV45Option = A591LegNomApe ;
            AV44InsertIndex = 1 ;
            while ( ( AV44InsertIndex <= AV46Options.size() ) && ( GXutil.strcmp((String)AV46Options.elementAt(-1+AV44InsertIndex), AV45Option) < 0 ) )
            {
               AV44InsertIndex = (int)(AV44InsertIndex+1) ;
            }
            if ( ( AV44InsertIndex <= AV46Options.size() ) && ( GXutil.strcmp((String)AV46Options.elementAt(-1+AV44InsertIndex), AV45Option) == 0 ) )
            {
               AV53count = GXutil.lval( (String)AV51OptionIndexes.elementAt(-1+AV44InsertIndex)) ;
               AV53count = (long)(AV53count+1) ;
               AV51OptionIndexes.removeItem(AV44InsertIndex);
               AV51OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV53count), "Z,ZZZ,ZZZ,ZZ9")), AV44InsertIndex);
            }
            else
            {
               AV46Options.add(AV45Option, AV44InsertIndex);
               AV51OptionIndexes.add("1", AV44InsertIndex);
            }
         }
         if ( AV46Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(1);
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADCONCODIGOOPTIONS' Routine */
      returnInSub = false ;
      AV24TFConCodigo = AV41SearchTxt ;
      AV67TFConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A93LegId ,
                                           AV71TFLegId_Sels ,
                                           A591LegNomApe ,
                                           AV82TFLegNomApe_Sels ,
                                           A26ConCodigo ,
                                           AV67TFConCodigo_Sels ,
                                           A41ConDescrip ,
                                           AV69TFConDescrip_Sels ,
                                           A37TipoConCod ,
                                           AV79TFTipoConCod_Sels ,
                                           A2159AgePerDescrip ,
                                           AV99TFAgePerDescrip_Sels ,
                                           A111AgeFecDes ,
                                           AV93TFAgeFecDes_Sels ,
                                           A112AgeFecHas ,
                                           AV95TFAgeFecHas_Sels ,
                                           Boolean.valueOf(AV91VerLiquidadas) ,
                                           Integer.valueOf(AV71TFLegId_Sels.size()) ,
                                           AV39TFLegId ,
                                           Integer.valueOf(AV82TFLegNomApe_Sels.size()) ,
                                           AV81TFLegNomApe ,
                                           Integer.valueOf(AV67TFConCodigo_Sels.size()) ,
                                           AV24TFConCodigo ,
                                           Integer.valueOf(AV69TFConDescrip_Sels.size()) ,
                                           AV26TFConDescrip ,
                                           Integer.valueOf(AV79TFTipoConCod_Sels.size()) ,
                                           AV28TFAgeCanti ,
                                           AV29TFAgeCanti_To ,
                                           Integer.valueOf(AV99TFAgePerDescrip_Sels.size()) ,
                                           AV98TFAgePerDescrip ,
                                           Integer.valueOf(AV93TFAgeFecDes_Sels.size()) ,
                                           Integer.valueOf(AV95TFAgeFecHas_Sels.size()) ,
                                           Integer.valueOf(AV89TFAgeLiqNro) ,
                                           Integer.valueOf(AV90TFAgeLiqNro_To) ,
                                           Integer.valueOf(A1254AgeLiqNro) ,
                                           A110AgeCanti ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV73EmpCod) ,
                                           Integer.valueOf(AV72CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE,
                                           TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV39TFLegId = GXutil.padr( GXutil.rtrim( AV39TFLegId), 20, "%") ;
      lV81TFLegNomApe = GXutil.concat( GXutil.rtrim( AV81TFLegNomApe), "%", "") ;
      lV24TFConCodigo = GXutil.padr( GXutil.rtrim( AV24TFConCodigo), 10, "%") ;
      lV26TFConDescrip = GXutil.concat( GXutil.rtrim( AV26TFConDescrip), "%", "") ;
      lV98TFAgePerDescrip = GXutil.concat( GXutil.rtrim( AV98TFAgePerDescrip), "%", "") ;
      /* Using cursor P006O4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV72CliCod), Short.valueOf(AV73EmpCod), lV39TFLegId, lV81TFLegNomApe, lV24TFConCodigo, lV26TFConDescrip, AV28TFAgeCanti, AV29TFAgeCanti_To, lV98TFAgePerDescrip, Integer.valueOf(AV89TFAgeLiqNro), Integer.valueOf(AV90TFAgeLiqNro_To)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk6O5 = false ;
         A6LegNumero = P006O4_A6LegNumero[0] ;
         A3CliCod = P006O4_A3CliCod[0] ;
         A26ConCodigo = P006O4_A26ConCodigo[0] ;
         A1EmpCod = P006O4_A1EmpCod[0] ;
         A112AgeFecHas = P006O4_A112AgeFecHas[0] ;
         n112AgeFecHas = P006O4_n112AgeFecHas[0] ;
         A111AgeFecDes = P006O4_A111AgeFecDes[0] ;
         n111AgeFecDes = P006O4_n111AgeFecDes[0] ;
         A2159AgePerDescrip = P006O4_A2159AgePerDescrip[0] ;
         A110AgeCanti = P006O4_A110AgeCanti[0] ;
         n110AgeCanti = P006O4_n110AgeCanti[0] ;
         A37TipoConCod = P006O4_A37TipoConCod[0] ;
         A41ConDescrip = P006O4_A41ConDescrip[0] ;
         A591LegNomApe = P006O4_A591LegNomApe[0] ;
         A93LegId = P006O4_A93LegId[0] ;
         n93LegId = P006O4_n93LegId[0] ;
         A1254AgeLiqNro = P006O4_A1254AgeLiqNro[0] ;
         n1254AgeLiqNro = P006O4_n1254AgeLiqNro[0] ;
         A25AgeOrden = P006O4_A25AgeOrden[0] ;
         A37TipoConCod = P006O4_A37TipoConCod[0] ;
         A41ConDescrip = P006O4_A41ConDescrip[0] ;
         A591LegNomApe = P006O4_A591LegNomApe[0] ;
         A93LegId = P006O4_A93LegId[0] ;
         n93LegId = P006O4_n93LegId[0] ;
         AV53count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( P006O4_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P006O4_A26ConCodigo[0], A26ConCodigo) == 0 ) )
         {
            brk6O5 = false ;
            A6LegNumero = P006O4_A6LegNumero[0] ;
            A1EmpCod = P006O4_A1EmpCod[0] ;
            A25AgeOrden = P006O4_A25AgeOrden[0] ;
            AV53count = (long)(AV53count+1) ;
            brk6O5 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A26ConCodigo)==0) )
         {
            AV45Option = A26ConCodigo ;
            AV48OptionDesc = GXutil.trim( GXutil.rtrim( localUtil.format( A26ConCodigo, ""))) ;
            AV46Options.add(AV45Option, 0);
            AV49OptionsDesc.add(AV48OptionDesc, 0);
            AV51OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV53count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV46Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6O5 )
         {
            brk6O5 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   public void S151( )
   {
      /* 'LOADCONDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV26TFConDescrip = AV41SearchTxt ;
      AV69TFConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           A93LegId ,
                                           AV71TFLegId_Sels ,
                                           A591LegNomApe ,
                                           AV82TFLegNomApe_Sels ,
                                           A26ConCodigo ,
                                           AV67TFConCodigo_Sels ,
                                           A41ConDescrip ,
                                           AV69TFConDescrip_Sels ,
                                           A37TipoConCod ,
                                           AV79TFTipoConCod_Sels ,
                                           A2159AgePerDescrip ,
                                           AV99TFAgePerDescrip_Sels ,
                                           A111AgeFecDes ,
                                           AV93TFAgeFecDes_Sels ,
                                           A112AgeFecHas ,
                                           AV95TFAgeFecHas_Sels ,
                                           Boolean.valueOf(AV91VerLiquidadas) ,
                                           Integer.valueOf(AV71TFLegId_Sels.size()) ,
                                           AV39TFLegId ,
                                           Integer.valueOf(AV82TFLegNomApe_Sels.size()) ,
                                           AV81TFLegNomApe ,
                                           Integer.valueOf(AV67TFConCodigo_Sels.size()) ,
                                           AV24TFConCodigo ,
                                           Integer.valueOf(AV69TFConDescrip_Sels.size()) ,
                                           AV26TFConDescrip ,
                                           Integer.valueOf(AV79TFTipoConCod_Sels.size()) ,
                                           AV28TFAgeCanti ,
                                           AV29TFAgeCanti_To ,
                                           Integer.valueOf(AV99TFAgePerDescrip_Sels.size()) ,
                                           AV98TFAgePerDescrip ,
                                           Integer.valueOf(AV93TFAgeFecDes_Sels.size()) ,
                                           Integer.valueOf(AV95TFAgeFecHas_Sels.size()) ,
                                           Integer.valueOf(AV89TFAgeLiqNro) ,
                                           Integer.valueOf(AV90TFAgeLiqNro_To) ,
                                           Integer.valueOf(A1254AgeLiqNro) ,
                                           A110AgeCanti ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV72CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV73EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE,
                                           TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV39TFLegId = GXutil.padr( GXutil.rtrim( AV39TFLegId), 20, "%") ;
      lV81TFLegNomApe = GXutil.concat( GXutil.rtrim( AV81TFLegNomApe), "%", "") ;
      lV24TFConCodigo = GXutil.padr( GXutil.rtrim( AV24TFConCodigo), 10, "%") ;
      lV26TFConDescrip = GXutil.concat( GXutil.rtrim( AV26TFConDescrip), "%", "") ;
      lV98TFAgePerDescrip = GXutil.concat( GXutil.rtrim( AV98TFAgePerDescrip), "%", "") ;
      /* Using cursor P006O5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV72CliCod), Short.valueOf(AV73EmpCod), lV39TFLegId, lV81TFLegNomApe, lV24TFConCodigo, lV26TFConDescrip, AV28TFAgeCanti, AV29TFAgeCanti_To, lV98TFAgePerDescrip, Integer.valueOf(AV89TFAgeLiqNro), Integer.valueOf(AV90TFAgeLiqNro_To)});
      while ( (pr_default.getStatus(3) != 101) )
      {
         brk6O7 = false ;
         A6LegNumero = P006O5_A6LegNumero[0] ;
         A3CliCod = P006O5_A3CliCod[0] ;
         A1EmpCod = P006O5_A1EmpCod[0] ;
         A41ConDescrip = P006O5_A41ConDescrip[0] ;
         A112AgeFecHas = P006O5_A112AgeFecHas[0] ;
         n112AgeFecHas = P006O5_n112AgeFecHas[0] ;
         A111AgeFecDes = P006O5_A111AgeFecDes[0] ;
         n111AgeFecDes = P006O5_n111AgeFecDes[0] ;
         A2159AgePerDescrip = P006O5_A2159AgePerDescrip[0] ;
         A110AgeCanti = P006O5_A110AgeCanti[0] ;
         n110AgeCanti = P006O5_n110AgeCanti[0] ;
         A37TipoConCod = P006O5_A37TipoConCod[0] ;
         A26ConCodigo = P006O5_A26ConCodigo[0] ;
         A591LegNomApe = P006O5_A591LegNomApe[0] ;
         A93LegId = P006O5_A93LegId[0] ;
         n93LegId = P006O5_n93LegId[0] ;
         A1254AgeLiqNro = P006O5_A1254AgeLiqNro[0] ;
         n1254AgeLiqNro = P006O5_n1254AgeLiqNro[0] ;
         A25AgeOrden = P006O5_A25AgeOrden[0] ;
         A591LegNomApe = P006O5_A591LegNomApe[0] ;
         A93LegId = P006O5_A93LegId[0] ;
         n93LegId = P006O5_n93LegId[0] ;
         A41ConDescrip = P006O5_A41ConDescrip[0] ;
         A37TipoConCod = P006O5_A37TipoConCod[0] ;
         AV53count = 0 ;
         while ( (pr_default.getStatus(3) != 101) && ( GXutil.strcmp(P006O5_A41ConDescrip[0], A41ConDescrip) == 0 ) )
         {
            brk6O7 = false ;
            A6LegNumero = P006O5_A6LegNumero[0] ;
            A3CliCod = P006O5_A3CliCod[0] ;
            A1EmpCod = P006O5_A1EmpCod[0] ;
            A26ConCodigo = P006O5_A26ConCodigo[0] ;
            A25AgeOrden = P006O5_A25AgeOrden[0] ;
            AV53count = (long)(AV53count+1) ;
            brk6O7 = true ;
            pr_default.readNext(3);
         }
         if ( ! (GXutil.strcmp("", A41ConDescrip)==0) )
         {
            AV45Option = A41ConDescrip ;
            AV46Options.add(AV45Option, 0);
            AV51OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV53count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV46Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6O7 )
         {
            brk6O7 = true ;
            pr_default.readNext(3);
         }
      }
      pr_default.close(3);
   }

   public void S161( )
   {
      /* 'LOADAGEPERDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV98TFAgePerDescrip = AV41SearchTxt ;
      AV99TFAgePerDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(4, new Object[]{ new Object[]{
                                           A93LegId ,
                                           AV71TFLegId_Sels ,
                                           A591LegNomApe ,
                                           AV82TFLegNomApe_Sels ,
                                           A26ConCodigo ,
                                           AV67TFConCodigo_Sels ,
                                           A41ConDescrip ,
                                           AV69TFConDescrip_Sels ,
                                           A37TipoConCod ,
                                           AV79TFTipoConCod_Sels ,
                                           A2159AgePerDescrip ,
                                           AV99TFAgePerDescrip_Sels ,
                                           A111AgeFecDes ,
                                           AV93TFAgeFecDes_Sels ,
                                           A112AgeFecHas ,
                                           AV95TFAgeFecHas_Sels ,
                                           Boolean.valueOf(AV91VerLiquidadas) ,
                                           Integer.valueOf(AV71TFLegId_Sels.size()) ,
                                           AV39TFLegId ,
                                           Integer.valueOf(AV82TFLegNomApe_Sels.size()) ,
                                           AV81TFLegNomApe ,
                                           Integer.valueOf(AV67TFConCodigo_Sels.size()) ,
                                           AV24TFConCodigo ,
                                           Integer.valueOf(AV69TFConDescrip_Sels.size()) ,
                                           AV26TFConDescrip ,
                                           Integer.valueOf(AV79TFTipoConCod_Sels.size()) ,
                                           AV28TFAgeCanti ,
                                           AV29TFAgeCanti_To ,
                                           Integer.valueOf(AV99TFAgePerDescrip_Sels.size()) ,
                                           AV98TFAgePerDescrip ,
                                           Integer.valueOf(AV93TFAgeFecDes_Sels.size()) ,
                                           Integer.valueOf(AV95TFAgeFecHas_Sels.size()) ,
                                           Integer.valueOf(AV89TFAgeLiqNro) ,
                                           Integer.valueOf(AV90TFAgeLiqNro_To) ,
                                           Integer.valueOf(A1254AgeLiqNro) ,
                                           A110AgeCanti ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV72CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV73EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE,
                                           TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV39TFLegId = GXutil.padr( GXutil.rtrim( AV39TFLegId), 20, "%") ;
      lV81TFLegNomApe = GXutil.concat( GXutil.rtrim( AV81TFLegNomApe), "%", "") ;
      lV24TFConCodigo = GXutil.padr( GXutil.rtrim( AV24TFConCodigo), 10, "%") ;
      lV26TFConDescrip = GXutil.concat( GXutil.rtrim( AV26TFConDescrip), "%", "") ;
      lV98TFAgePerDescrip = GXutil.concat( GXutil.rtrim( AV98TFAgePerDescrip), "%", "") ;
      /* Using cursor P006O6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(AV72CliCod), Short.valueOf(AV73EmpCod), lV39TFLegId, lV81TFLegNomApe, lV24TFConCodigo, lV26TFConDescrip, AV28TFAgeCanti, AV29TFAgeCanti_To, lV98TFAgePerDescrip, Integer.valueOf(AV89TFAgeLiqNro), Integer.valueOf(AV90TFAgeLiqNro_To)});
      while ( (pr_default.getStatus(4) != 101) )
      {
         brk6O9 = false ;
         A6LegNumero = P006O6_A6LegNumero[0] ;
         A3CliCod = P006O6_A3CliCod[0] ;
         A1EmpCod = P006O6_A1EmpCod[0] ;
         A2159AgePerDescrip = P006O6_A2159AgePerDescrip[0] ;
         A112AgeFecHas = P006O6_A112AgeFecHas[0] ;
         n112AgeFecHas = P006O6_n112AgeFecHas[0] ;
         A111AgeFecDes = P006O6_A111AgeFecDes[0] ;
         n111AgeFecDes = P006O6_n111AgeFecDes[0] ;
         A110AgeCanti = P006O6_A110AgeCanti[0] ;
         n110AgeCanti = P006O6_n110AgeCanti[0] ;
         A37TipoConCod = P006O6_A37TipoConCod[0] ;
         A41ConDescrip = P006O6_A41ConDescrip[0] ;
         A26ConCodigo = P006O6_A26ConCodigo[0] ;
         A591LegNomApe = P006O6_A591LegNomApe[0] ;
         A93LegId = P006O6_A93LegId[0] ;
         n93LegId = P006O6_n93LegId[0] ;
         A1254AgeLiqNro = P006O6_A1254AgeLiqNro[0] ;
         n1254AgeLiqNro = P006O6_n1254AgeLiqNro[0] ;
         A25AgeOrden = P006O6_A25AgeOrden[0] ;
         A591LegNomApe = P006O6_A591LegNomApe[0] ;
         A93LegId = P006O6_A93LegId[0] ;
         n93LegId = P006O6_n93LegId[0] ;
         A37TipoConCod = P006O6_A37TipoConCod[0] ;
         A41ConDescrip = P006O6_A41ConDescrip[0] ;
         AV53count = 0 ;
         while ( (pr_default.getStatus(4) != 101) && ( GXutil.strcmp(P006O6_A2159AgePerDescrip[0], A2159AgePerDescrip) == 0 ) )
         {
            brk6O9 = false ;
            A6LegNumero = P006O6_A6LegNumero[0] ;
            A3CliCod = P006O6_A3CliCod[0] ;
            A1EmpCod = P006O6_A1EmpCod[0] ;
            A25AgeOrden = P006O6_A25AgeOrden[0] ;
            AV53count = (long)(AV53count+1) ;
            brk6O9 = true ;
            pr_default.readNext(4);
         }
         if ( ! (GXutil.strcmp("", A2159AgePerDescrip)==0) )
         {
            AV45Option = A2159AgePerDescrip ;
            AV46Options.add(AV45Option, 0);
            AV51OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV53count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV46Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6O9 )
         {
            brk6O9 = true ;
            pr_default.readNext(4);
         }
      }
      pr_default.close(4);
   }

   public void S171( )
   {
      /* 'LOADAGEFECDESOPTIONS' Routine */
      returnInSub = false ;
      AV34TFAgeFecDes = localUtil.ctod( AV41SearchTxt, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
      AV93TFAgeFecDes_Sels = new GXSimpleCollection<java.util.Date>(java.util.Date.class, "internal", "") ;
      pr_default.dynParam(5, new Object[]{ new Object[]{
                                           A93LegId ,
                                           AV71TFLegId_Sels ,
                                           A591LegNomApe ,
                                           AV82TFLegNomApe_Sels ,
                                           A26ConCodigo ,
                                           AV67TFConCodigo_Sels ,
                                           A41ConDescrip ,
                                           AV69TFConDescrip_Sels ,
                                           A37TipoConCod ,
                                           AV79TFTipoConCod_Sels ,
                                           A2159AgePerDescrip ,
                                           AV99TFAgePerDescrip_Sels ,
                                           A111AgeFecDes ,
                                           AV93TFAgeFecDes_Sels ,
                                           A112AgeFecHas ,
                                           AV95TFAgeFecHas_Sels ,
                                           Boolean.valueOf(AV91VerLiquidadas) ,
                                           Integer.valueOf(AV71TFLegId_Sels.size()) ,
                                           AV39TFLegId ,
                                           Integer.valueOf(AV82TFLegNomApe_Sels.size()) ,
                                           AV81TFLegNomApe ,
                                           Integer.valueOf(AV67TFConCodigo_Sels.size()) ,
                                           AV24TFConCodigo ,
                                           Integer.valueOf(AV69TFConDescrip_Sels.size()) ,
                                           AV26TFConDescrip ,
                                           Integer.valueOf(AV79TFTipoConCod_Sels.size()) ,
                                           AV28TFAgeCanti ,
                                           AV29TFAgeCanti_To ,
                                           Integer.valueOf(AV99TFAgePerDescrip_Sels.size()) ,
                                           AV98TFAgePerDescrip ,
                                           Integer.valueOf(AV93TFAgeFecDes_Sels.size()) ,
                                           Integer.valueOf(AV95TFAgeFecHas_Sels.size()) ,
                                           Integer.valueOf(AV89TFAgeLiqNro) ,
                                           Integer.valueOf(AV90TFAgeLiqNro_To) ,
                                           Integer.valueOf(A1254AgeLiqNro) ,
                                           A110AgeCanti ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV72CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV73EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE,
                                           TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV39TFLegId = GXutil.padr( GXutil.rtrim( AV39TFLegId), 20, "%") ;
      lV81TFLegNomApe = GXutil.concat( GXutil.rtrim( AV81TFLegNomApe), "%", "") ;
      lV24TFConCodigo = GXutil.padr( GXutil.rtrim( AV24TFConCodigo), 10, "%") ;
      lV26TFConDescrip = GXutil.concat( GXutil.rtrim( AV26TFConDescrip), "%", "") ;
      lV98TFAgePerDescrip = GXutil.concat( GXutil.rtrim( AV98TFAgePerDescrip), "%", "") ;
      /* Using cursor P006O7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(AV72CliCod), Short.valueOf(AV73EmpCod), lV39TFLegId, lV81TFLegNomApe, lV24TFConCodigo, lV26TFConDescrip, AV28TFAgeCanti, AV29TFAgeCanti_To, lV98TFAgePerDescrip, Integer.valueOf(AV89TFAgeLiqNro), Integer.valueOf(AV90TFAgeLiqNro_To)});
      while ( (pr_default.getStatus(5) != 101) )
      {
         brk6O11 = false ;
         A6LegNumero = P006O7_A6LegNumero[0] ;
         A3CliCod = P006O7_A3CliCod[0] ;
         A1EmpCod = P006O7_A1EmpCod[0] ;
         A111AgeFecDes = P006O7_A111AgeFecDes[0] ;
         n111AgeFecDes = P006O7_n111AgeFecDes[0] ;
         A112AgeFecHas = P006O7_A112AgeFecHas[0] ;
         n112AgeFecHas = P006O7_n112AgeFecHas[0] ;
         A2159AgePerDescrip = P006O7_A2159AgePerDescrip[0] ;
         A110AgeCanti = P006O7_A110AgeCanti[0] ;
         n110AgeCanti = P006O7_n110AgeCanti[0] ;
         A37TipoConCod = P006O7_A37TipoConCod[0] ;
         A41ConDescrip = P006O7_A41ConDescrip[0] ;
         A26ConCodigo = P006O7_A26ConCodigo[0] ;
         A591LegNomApe = P006O7_A591LegNomApe[0] ;
         A93LegId = P006O7_A93LegId[0] ;
         n93LegId = P006O7_n93LegId[0] ;
         A1254AgeLiqNro = P006O7_A1254AgeLiqNro[0] ;
         n1254AgeLiqNro = P006O7_n1254AgeLiqNro[0] ;
         A25AgeOrden = P006O7_A25AgeOrden[0] ;
         A591LegNomApe = P006O7_A591LegNomApe[0] ;
         A93LegId = P006O7_A93LegId[0] ;
         n93LegId = P006O7_n93LegId[0] ;
         A37TipoConCod = P006O7_A37TipoConCod[0] ;
         A41ConDescrip = P006O7_A41ConDescrip[0] ;
         AV53count = 0 ;
         while ( (pr_default.getStatus(5) != 101) && GXutil.dateCompare(GXutil.resetTime(P006O7_A111AgeFecDes[0]), GXutil.resetTime(A111AgeFecDes)) )
         {
            brk6O11 = false ;
            A6LegNumero = P006O7_A6LegNumero[0] ;
            A3CliCod = P006O7_A3CliCod[0] ;
            A1EmpCod = P006O7_A1EmpCod[0] ;
            A25AgeOrden = P006O7_A25AgeOrden[0] ;
            AV53count = (long)(AV53count+1) ;
            brk6O11 = true ;
            pr_default.readNext(5);
         }
         if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A111AgeFecDes)) )
         {
            AV45Option = localUtil.dtoc( A111AgeFecDes, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/") ;
            AV46Options.add(AV45Option, 0);
            AV51OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV53count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV46Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6O11 )
         {
            brk6O11 = true ;
            pr_default.readNext(5);
         }
      }
      pr_default.close(5);
   }

   public void S181( )
   {
      /* 'LOADAGEFECHASOPTIONS' Routine */
      returnInSub = false ;
      AV36TFAgeFecHas = localUtil.ctod( AV41SearchTxt, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
      AV95TFAgeFecHas_Sels = new GXSimpleCollection<java.util.Date>(java.util.Date.class, "internal", "") ;
      pr_default.dynParam(6, new Object[]{ new Object[]{
                                           A93LegId ,
                                           AV71TFLegId_Sels ,
                                           A591LegNomApe ,
                                           AV82TFLegNomApe_Sels ,
                                           A26ConCodigo ,
                                           AV67TFConCodigo_Sels ,
                                           A41ConDescrip ,
                                           AV69TFConDescrip_Sels ,
                                           A37TipoConCod ,
                                           AV79TFTipoConCod_Sels ,
                                           A2159AgePerDescrip ,
                                           AV99TFAgePerDescrip_Sels ,
                                           A111AgeFecDes ,
                                           AV93TFAgeFecDes_Sels ,
                                           A112AgeFecHas ,
                                           AV95TFAgeFecHas_Sels ,
                                           Boolean.valueOf(AV91VerLiquidadas) ,
                                           Integer.valueOf(AV71TFLegId_Sels.size()) ,
                                           AV39TFLegId ,
                                           Integer.valueOf(AV82TFLegNomApe_Sels.size()) ,
                                           AV81TFLegNomApe ,
                                           Integer.valueOf(AV67TFConCodigo_Sels.size()) ,
                                           AV24TFConCodigo ,
                                           Integer.valueOf(AV69TFConDescrip_Sels.size()) ,
                                           AV26TFConDescrip ,
                                           Integer.valueOf(AV79TFTipoConCod_Sels.size()) ,
                                           AV28TFAgeCanti ,
                                           AV29TFAgeCanti_To ,
                                           Integer.valueOf(AV99TFAgePerDescrip_Sels.size()) ,
                                           AV98TFAgePerDescrip ,
                                           Integer.valueOf(AV93TFAgeFecDes_Sels.size()) ,
                                           Integer.valueOf(AV95TFAgeFecHas_Sels.size()) ,
                                           Integer.valueOf(AV89TFAgeLiqNro) ,
                                           Integer.valueOf(AV90TFAgeLiqNro_To) ,
                                           Integer.valueOf(A1254AgeLiqNro) ,
                                           A110AgeCanti ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV72CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV73EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE,
                                           TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV39TFLegId = GXutil.padr( GXutil.rtrim( AV39TFLegId), 20, "%") ;
      lV81TFLegNomApe = GXutil.concat( GXutil.rtrim( AV81TFLegNomApe), "%", "") ;
      lV24TFConCodigo = GXutil.padr( GXutil.rtrim( AV24TFConCodigo), 10, "%") ;
      lV26TFConDescrip = GXutil.concat( GXutil.rtrim( AV26TFConDescrip), "%", "") ;
      lV98TFAgePerDescrip = GXutil.concat( GXutil.rtrim( AV98TFAgePerDescrip), "%", "") ;
      /* Using cursor P006O8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(AV72CliCod), Short.valueOf(AV73EmpCod), lV39TFLegId, lV81TFLegNomApe, lV24TFConCodigo, lV26TFConDescrip, AV28TFAgeCanti, AV29TFAgeCanti_To, lV98TFAgePerDescrip, Integer.valueOf(AV89TFAgeLiqNro), Integer.valueOf(AV90TFAgeLiqNro_To)});
      while ( (pr_default.getStatus(6) != 101) )
      {
         brk6O13 = false ;
         A6LegNumero = P006O8_A6LegNumero[0] ;
         A3CliCod = P006O8_A3CliCod[0] ;
         A1EmpCod = P006O8_A1EmpCod[0] ;
         A112AgeFecHas = P006O8_A112AgeFecHas[0] ;
         n112AgeFecHas = P006O8_n112AgeFecHas[0] ;
         A111AgeFecDes = P006O8_A111AgeFecDes[0] ;
         n111AgeFecDes = P006O8_n111AgeFecDes[0] ;
         A2159AgePerDescrip = P006O8_A2159AgePerDescrip[0] ;
         A110AgeCanti = P006O8_A110AgeCanti[0] ;
         n110AgeCanti = P006O8_n110AgeCanti[0] ;
         A37TipoConCod = P006O8_A37TipoConCod[0] ;
         A41ConDescrip = P006O8_A41ConDescrip[0] ;
         A26ConCodigo = P006O8_A26ConCodigo[0] ;
         A591LegNomApe = P006O8_A591LegNomApe[0] ;
         A93LegId = P006O8_A93LegId[0] ;
         n93LegId = P006O8_n93LegId[0] ;
         A1254AgeLiqNro = P006O8_A1254AgeLiqNro[0] ;
         n1254AgeLiqNro = P006O8_n1254AgeLiqNro[0] ;
         A25AgeOrden = P006O8_A25AgeOrden[0] ;
         A591LegNomApe = P006O8_A591LegNomApe[0] ;
         A93LegId = P006O8_A93LegId[0] ;
         n93LegId = P006O8_n93LegId[0] ;
         A37TipoConCod = P006O8_A37TipoConCod[0] ;
         A41ConDescrip = P006O8_A41ConDescrip[0] ;
         AV53count = 0 ;
         while ( (pr_default.getStatus(6) != 101) && GXutil.dateCompare(GXutil.resetTime(P006O8_A112AgeFecHas[0]), GXutil.resetTime(A112AgeFecHas)) )
         {
            brk6O13 = false ;
            A6LegNumero = P006O8_A6LegNumero[0] ;
            A3CliCod = P006O8_A3CliCod[0] ;
            A1EmpCod = P006O8_A1EmpCod[0] ;
            A25AgeOrden = P006O8_A25AgeOrden[0] ;
            AV53count = (long)(AV53count+1) ;
            brk6O13 = true ;
            pr_default.readNext(6);
         }
         if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A112AgeFecHas)) )
         {
            AV45Option = localUtil.dtoc( A112AgeFecHas, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/") ;
            AV46Options.add(AV45Option, 0);
            AV51OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV53count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV46Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6O13 )
         {
            brk6O13 = true ;
            pr_default.readNext(6);
         }
      }
      pr_default.close(6);
   }

   protected void cleanup( )
   {
      this.aP3[0] = novedadeswwgetfilterdata.this.AV47OptionsJson;
      this.aP4[0] = novedadeswwgetfilterdata.this.AV50OptionsDescJson;
      this.aP5[0] = novedadeswwgetfilterdata.this.AV52OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV47OptionsJson = "" ;
      AV50OptionsDescJson = "" ;
      AV52OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV46Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV49OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV51OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV54Session = httpContext.getWebSession();
      AV56GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV57GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV39TFLegId = "" ;
      AV70TFLegId_SelsJson = "" ;
      AV71TFLegId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV81TFLegNomApe = "" ;
      AV80TFLegNomApe_SelsJson = "" ;
      AV82TFLegNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV24TFConCodigo = "" ;
      AV66TFConCodigo_SelsJson = "" ;
      AV67TFConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV26TFConDescrip = "" ;
      AV68TFConDescrip_SelsJson = "" ;
      AV69TFConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV78TFTipoConCod_SelsJson = "" ;
      AV79TFTipoConCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV28TFAgeCanti = DecimalUtil.ZERO ;
      AV29TFAgeCanti_To = DecimalUtil.ZERO ;
      AV98TFAgePerDescrip = "" ;
      AV97TFAgePerDescrip_SelsJson = "" ;
      AV99TFAgePerDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV34TFAgeFecDes = GXutil.nullDate() ;
      AV92TFAgeFecDes_SelsJson = "" ;
      AV93TFAgeFecDes_Sels = new GXSimpleCollection<java.util.Date>(java.util.Date.class, "internal", "");
      AV36TFAgeFecHas = GXutil.nullDate() ;
      AV94TFAgeFecHas_SelsJson = "" ;
      AV95TFAgeFecHas_Sels = new GXSimpleCollection<java.util.Date>(java.util.Date.class, "internal", "");
      AV96MenuOpcCod = "" ;
      scmdbuf = "" ;
      lV39TFLegId = "" ;
      lV81TFLegNomApe = "" ;
      lV24TFConCodigo = "" ;
      lV26TFConDescrip = "" ;
      lV98TFAgePerDescrip = "" ;
      A93LegId = "" ;
      A591LegNomApe = "" ;
      A26ConCodigo = "" ;
      A41ConDescrip = "" ;
      A37TipoConCod = "" ;
      A2159AgePerDescrip = "" ;
      A111AgeFecDes = GXutil.nullDate() ;
      A112AgeFecHas = GXutil.nullDate() ;
      A110AgeCanti = DecimalUtil.ZERO ;
      P006O2_A6LegNumero = new int[1] ;
      P006O2_A3CliCod = new int[1] ;
      P006O2_A1EmpCod = new short[1] ;
      P006O2_A93LegId = new String[] {""} ;
      P006O2_n93LegId = new boolean[] {false} ;
      P006O2_A112AgeFecHas = new java.util.Date[] {GXutil.nullDate()} ;
      P006O2_n112AgeFecHas = new boolean[] {false} ;
      P006O2_A111AgeFecDes = new java.util.Date[] {GXutil.nullDate()} ;
      P006O2_n111AgeFecDes = new boolean[] {false} ;
      P006O2_A2159AgePerDescrip = new String[] {""} ;
      P006O2_A110AgeCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P006O2_n110AgeCanti = new boolean[] {false} ;
      P006O2_A37TipoConCod = new String[] {""} ;
      P006O2_A41ConDescrip = new String[] {""} ;
      P006O2_A26ConCodigo = new String[] {""} ;
      P006O2_A591LegNomApe = new String[] {""} ;
      P006O2_A1254AgeLiqNro = new int[1] ;
      P006O2_n1254AgeLiqNro = new boolean[] {false} ;
      P006O2_A25AgeOrden = new short[1] ;
      AV45Option = "" ;
      P006O3_A6LegNumero = new int[1] ;
      P006O3_A1EmpCod = new short[1] ;
      P006O3_A3CliCod = new int[1] ;
      P006O3_A112AgeFecHas = new java.util.Date[] {GXutil.nullDate()} ;
      P006O3_n112AgeFecHas = new boolean[] {false} ;
      P006O3_A111AgeFecDes = new java.util.Date[] {GXutil.nullDate()} ;
      P006O3_n111AgeFecDes = new boolean[] {false} ;
      P006O3_A2159AgePerDescrip = new String[] {""} ;
      P006O3_A110AgeCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P006O3_n110AgeCanti = new boolean[] {false} ;
      P006O3_A37TipoConCod = new String[] {""} ;
      P006O3_A41ConDescrip = new String[] {""} ;
      P006O3_A26ConCodigo = new String[] {""} ;
      P006O3_A591LegNomApe = new String[] {""} ;
      P006O3_A93LegId = new String[] {""} ;
      P006O3_n93LegId = new boolean[] {false} ;
      P006O3_A1254AgeLiqNro = new int[1] ;
      P006O3_n1254AgeLiqNro = new boolean[] {false} ;
      P006O3_A25AgeOrden = new short[1] ;
      P006O4_A6LegNumero = new int[1] ;
      P006O4_A3CliCod = new int[1] ;
      P006O4_A26ConCodigo = new String[] {""} ;
      P006O4_A1EmpCod = new short[1] ;
      P006O4_A112AgeFecHas = new java.util.Date[] {GXutil.nullDate()} ;
      P006O4_n112AgeFecHas = new boolean[] {false} ;
      P006O4_A111AgeFecDes = new java.util.Date[] {GXutil.nullDate()} ;
      P006O4_n111AgeFecDes = new boolean[] {false} ;
      P006O4_A2159AgePerDescrip = new String[] {""} ;
      P006O4_A110AgeCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P006O4_n110AgeCanti = new boolean[] {false} ;
      P006O4_A37TipoConCod = new String[] {""} ;
      P006O4_A41ConDescrip = new String[] {""} ;
      P006O4_A591LegNomApe = new String[] {""} ;
      P006O4_A93LegId = new String[] {""} ;
      P006O4_n93LegId = new boolean[] {false} ;
      P006O4_A1254AgeLiqNro = new int[1] ;
      P006O4_n1254AgeLiqNro = new boolean[] {false} ;
      P006O4_A25AgeOrden = new short[1] ;
      AV48OptionDesc = "" ;
      P006O5_A6LegNumero = new int[1] ;
      P006O5_A3CliCod = new int[1] ;
      P006O5_A1EmpCod = new short[1] ;
      P006O5_A41ConDescrip = new String[] {""} ;
      P006O5_A112AgeFecHas = new java.util.Date[] {GXutil.nullDate()} ;
      P006O5_n112AgeFecHas = new boolean[] {false} ;
      P006O5_A111AgeFecDes = new java.util.Date[] {GXutil.nullDate()} ;
      P006O5_n111AgeFecDes = new boolean[] {false} ;
      P006O5_A2159AgePerDescrip = new String[] {""} ;
      P006O5_A110AgeCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P006O5_n110AgeCanti = new boolean[] {false} ;
      P006O5_A37TipoConCod = new String[] {""} ;
      P006O5_A26ConCodigo = new String[] {""} ;
      P006O5_A591LegNomApe = new String[] {""} ;
      P006O5_A93LegId = new String[] {""} ;
      P006O5_n93LegId = new boolean[] {false} ;
      P006O5_A1254AgeLiqNro = new int[1] ;
      P006O5_n1254AgeLiqNro = new boolean[] {false} ;
      P006O5_A25AgeOrden = new short[1] ;
      P006O6_A6LegNumero = new int[1] ;
      P006O6_A3CliCod = new int[1] ;
      P006O6_A1EmpCod = new short[1] ;
      P006O6_A2159AgePerDescrip = new String[] {""} ;
      P006O6_A112AgeFecHas = new java.util.Date[] {GXutil.nullDate()} ;
      P006O6_n112AgeFecHas = new boolean[] {false} ;
      P006O6_A111AgeFecDes = new java.util.Date[] {GXutil.nullDate()} ;
      P006O6_n111AgeFecDes = new boolean[] {false} ;
      P006O6_A110AgeCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P006O6_n110AgeCanti = new boolean[] {false} ;
      P006O6_A37TipoConCod = new String[] {""} ;
      P006O6_A41ConDescrip = new String[] {""} ;
      P006O6_A26ConCodigo = new String[] {""} ;
      P006O6_A591LegNomApe = new String[] {""} ;
      P006O6_A93LegId = new String[] {""} ;
      P006O6_n93LegId = new boolean[] {false} ;
      P006O6_A1254AgeLiqNro = new int[1] ;
      P006O6_n1254AgeLiqNro = new boolean[] {false} ;
      P006O6_A25AgeOrden = new short[1] ;
      P006O7_A6LegNumero = new int[1] ;
      P006O7_A3CliCod = new int[1] ;
      P006O7_A1EmpCod = new short[1] ;
      P006O7_A111AgeFecDes = new java.util.Date[] {GXutil.nullDate()} ;
      P006O7_n111AgeFecDes = new boolean[] {false} ;
      P006O7_A112AgeFecHas = new java.util.Date[] {GXutil.nullDate()} ;
      P006O7_n112AgeFecHas = new boolean[] {false} ;
      P006O7_A2159AgePerDescrip = new String[] {""} ;
      P006O7_A110AgeCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P006O7_n110AgeCanti = new boolean[] {false} ;
      P006O7_A37TipoConCod = new String[] {""} ;
      P006O7_A41ConDescrip = new String[] {""} ;
      P006O7_A26ConCodigo = new String[] {""} ;
      P006O7_A591LegNomApe = new String[] {""} ;
      P006O7_A93LegId = new String[] {""} ;
      P006O7_n93LegId = new boolean[] {false} ;
      P006O7_A1254AgeLiqNro = new int[1] ;
      P006O7_n1254AgeLiqNro = new boolean[] {false} ;
      P006O7_A25AgeOrden = new short[1] ;
      P006O8_A6LegNumero = new int[1] ;
      P006O8_A3CliCod = new int[1] ;
      P006O8_A1EmpCod = new short[1] ;
      P006O8_A112AgeFecHas = new java.util.Date[] {GXutil.nullDate()} ;
      P006O8_n112AgeFecHas = new boolean[] {false} ;
      P006O8_A111AgeFecDes = new java.util.Date[] {GXutil.nullDate()} ;
      P006O8_n111AgeFecDes = new boolean[] {false} ;
      P006O8_A2159AgePerDescrip = new String[] {""} ;
      P006O8_A110AgeCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P006O8_n110AgeCanti = new boolean[] {false} ;
      P006O8_A37TipoConCod = new String[] {""} ;
      P006O8_A41ConDescrip = new String[] {""} ;
      P006O8_A26ConCodigo = new String[] {""} ;
      P006O8_A591LegNomApe = new String[] {""} ;
      P006O8_A93LegId = new String[] {""} ;
      P006O8_n93LegId = new boolean[] {false} ;
      P006O8_A1254AgeLiqNro = new int[1] ;
      P006O8_n1254AgeLiqNro = new boolean[] {false} ;
      P006O8_A25AgeOrden = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.novedadeswwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P006O2_A6LegNumero, P006O2_A3CliCod, P006O2_A1EmpCod, P006O2_A93LegId, P006O2_n93LegId, P006O2_A112AgeFecHas, P006O2_n112AgeFecHas, P006O2_A111AgeFecDes, P006O2_n111AgeFecDes, P006O2_A2159AgePerDescrip,
            P006O2_A110AgeCanti, P006O2_n110AgeCanti, P006O2_A37TipoConCod, P006O2_A41ConDescrip, P006O2_A26ConCodigo, P006O2_A591LegNomApe, P006O2_A1254AgeLiqNro, P006O2_n1254AgeLiqNro, P006O2_A25AgeOrden
            }
            , new Object[] {
            P006O3_A6LegNumero, P006O3_A1EmpCod, P006O3_A3CliCod, P006O3_A112AgeFecHas, P006O3_n112AgeFecHas, P006O3_A111AgeFecDes, P006O3_n111AgeFecDes, P006O3_A2159AgePerDescrip, P006O3_A110AgeCanti, P006O3_n110AgeCanti,
            P006O3_A37TipoConCod, P006O3_A41ConDescrip, P006O3_A26ConCodigo, P006O3_A591LegNomApe, P006O3_A93LegId, P006O3_n93LegId, P006O3_A1254AgeLiqNro, P006O3_n1254AgeLiqNro, P006O3_A25AgeOrden
            }
            , new Object[] {
            P006O4_A6LegNumero, P006O4_A3CliCod, P006O4_A26ConCodigo, P006O4_A1EmpCod, P006O4_A112AgeFecHas, P006O4_n112AgeFecHas, P006O4_A111AgeFecDes, P006O4_n111AgeFecDes, P006O4_A2159AgePerDescrip, P006O4_A110AgeCanti,
            P006O4_n110AgeCanti, P006O4_A37TipoConCod, P006O4_A41ConDescrip, P006O4_A591LegNomApe, P006O4_A93LegId, P006O4_n93LegId, P006O4_A1254AgeLiqNro, P006O4_n1254AgeLiqNro, P006O4_A25AgeOrden
            }
            , new Object[] {
            P006O5_A6LegNumero, P006O5_A3CliCod, P006O5_A1EmpCod, P006O5_A41ConDescrip, P006O5_A112AgeFecHas, P006O5_n112AgeFecHas, P006O5_A111AgeFecDes, P006O5_n111AgeFecDes, P006O5_A2159AgePerDescrip, P006O5_A110AgeCanti,
            P006O5_n110AgeCanti, P006O5_A37TipoConCod, P006O5_A26ConCodigo, P006O5_A591LegNomApe, P006O5_A93LegId, P006O5_n93LegId, P006O5_A1254AgeLiqNro, P006O5_n1254AgeLiqNro, P006O5_A25AgeOrden
            }
            , new Object[] {
            P006O6_A6LegNumero, P006O6_A3CliCod, P006O6_A1EmpCod, P006O6_A2159AgePerDescrip, P006O6_A112AgeFecHas, P006O6_n112AgeFecHas, P006O6_A111AgeFecDes, P006O6_n111AgeFecDes, P006O6_A110AgeCanti, P006O6_n110AgeCanti,
            P006O6_A37TipoConCod, P006O6_A41ConDescrip, P006O6_A26ConCodigo, P006O6_A591LegNomApe, P006O6_A93LegId, P006O6_n93LegId, P006O6_A1254AgeLiqNro, P006O6_n1254AgeLiqNro, P006O6_A25AgeOrden
            }
            , new Object[] {
            P006O7_A6LegNumero, P006O7_A3CliCod, P006O7_A1EmpCod, P006O7_A111AgeFecDes, P006O7_n111AgeFecDes, P006O7_A112AgeFecHas, P006O7_n112AgeFecHas, P006O7_A2159AgePerDescrip, P006O7_A110AgeCanti, P006O7_n110AgeCanti,
            P006O7_A37TipoConCod, P006O7_A41ConDescrip, P006O7_A26ConCodigo, P006O7_A591LegNomApe, P006O7_A93LegId, P006O7_n93LegId, P006O7_A1254AgeLiqNro, P006O7_n1254AgeLiqNro, P006O7_A25AgeOrden
            }
            , new Object[] {
            P006O8_A6LegNumero, P006O8_A3CliCod, P006O8_A1EmpCod, P006O8_A112AgeFecHas, P006O8_n112AgeFecHas, P006O8_A111AgeFecDes, P006O8_n111AgeFecDes, P006O8_A2159AgePerDescrip, P006O8_A110AgeCanti, P006O8_n110AgeCanti,
            P006O8_A37TipoConCod, P006O8_A41ConDescrip, P006O8_A26ConCodigo, P006O8_A591LegNomApe, P006O8_A93LegId, P006O8_n93LegId, P006O8_A1254AgeLiqNro, P006O8_n1254AgeLiqNro, P006O8_A25AgeOrden
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV73EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A1EmpCod ;
   private short A25AgeOrden ;
   private short Gx_err ;
   private int AV72CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV102GXV1 ;
   private int AV89TFAgeLiqNro ;
   private int AV90TFAgeLiqNro_To ;
   private int AV71TFLegId_Sels_size ;
   private int AV82TFLegNomApe_Sels_size ;
   private int AV67TFConCodigo_Sels_size ;
   private int AV69TFConDescrip_Sels_size ;
   private int AV79TFTipoConCod_Sels_size ;
   private int AV99TFAgePerDescrip_Sels_size ;
   private int AV93TFAgeFecDes_Sels_size ;
   private int AV95TFAgeFecHas_Sels_size ;
   private int A1254AgeLiqNro ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int AV44InsertIndex ;
   private long AV53count ;
   private java.math.BigDecimal AV28TFAgeCanti ;
   private java.math.BigDecimal AV29TFAgeCanti_To ;
   private java.math.BigDecimal A110AgeCanti ;
   private String AV39TFLegId ;
   private String AV24TFConCodigo ;
   private String scmdbuf ;
   private String lV39TFLegId ;
   private String lV24TFConCodigo ;
   private String A93LegId ;
   private String A26ConCodigo ;
   private String A37TipoConCod ;
   private java.util.Date AV34TFAgeFecDes ;
   private java.util.Date AV36TFAgeFecHas ;
   private java.util.Date A111AgeFecDes ;
   private java.util.Date A112AgeFecHas ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean AV91VerLiquidadas ;
   private boolean brk6O2 ;
   private boolean n93LegId ;
   private boolean n112AgeFecHas ;
   private boolean n111AgeFecDes ;
   private boolean n110AgeCanti ;
   private boolean n1254AgeLiqNro ;
   private boolean brk6O5 ;
   private boolean brk6O7 ;
   private boolean brk6O9 ;
   private boolean brk6O11 ;
   private boolean brk6O13 ;
   private String AV47OptionsJson ;
   private String AV50OptionsDescJson ;
   private String AV52OptionIndexesJson ;
   private String AV70TFLegId_SelsJson ;
   private String AV80TFLegNomApe_SelsJson ;
   private String AV66TFConCodigo_SelsJson ;
   private String AV68TFConDescrip_SelsJson ;
   private String AV78TFTipoConCod_SelsJson ;
   private String AV97TFAgePerDescrip_SelsJson ;
   private String AV92TFAgeFecDes_SelsJson ;
   private String AV94TFAgeFecHas_SelsJson ;
   private String AV43DDOName ;
   private String AV41SearchTxt ;
   private String AV42SearchTxtTo ;
   private String AV81TFLegNomApe ;
   private String AV26TFConDescrip ;
   private String AV98TFAgePerDescrip ;
   private String AV96MenuOpcCod ;
   private String lV81TFLegNomApe ;
   private String lV26TFConDescrip ;
   private String lV98TFAgePerDescrip ;
   private String A591LegNomApe ;
   private String A41ConDescrip ;
   private String A2159AgePerDescrip ;
   private String AV45Option ;
   private String AV48OptionDesc ;
   private com.genexus.webpanels.WebSession AV54Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P006O2_A6LegNumero ;
   private int[] P006O2_A3CliCod ;
   private short[] P006O2_A1EmpCod ;
   private String[] P006O2_A93LegId ;
   private boolean[] P006O2_n93LegId ;
   private java.util.Date[] P006O2_A112AgeFecHas ;
   private boolean[] P006O2_n112AgeFecHas ;
   private java.util.Date[] P006O2_A111AgeFecDes ;
   private boolean[] P006O2_n111AgeFecDes ;
   private String[] P006O2_A2159AgePerDescrip ;
   private java.math.BigDecimal[] P006O2_A110AgeCanti ;
   private boolean[] P006O2_n110AgeCanti ;
   private String[] P006O2_A37TipoConCod ;
   private String[] P006O2_A41ConDescrip ;
   private String[] P006O2_A26ConCodigo ;
   private String[] P006O2_A591LegNomApe ;
   private int[] P006O2_A1254AgeLiqNro ;
   private boolean[] P006O2_n1254AgeLiqNro ;
   private short[] P006O2_A25AgeOrden ;
   private int[] P006O3_A6LegNumero ;
   private short[] P006O3_A1EmpCod ;
   private int[] P006O3_A3CliCod ;
   private java.util.Date[] P006O3_A112AgeFecHas ;
   private boolean[] P006O3_n112AgeFecHas ;
   private java.util.Date[] P006O3_A111AgeFecDes ;
   private boolean[] P006O3_n111AgeFecDes ;
   private String[] P006O3_A2159AgePerDescrip ;
   private java.math.BigDecimal[] P006O3_A110AgeCanti ;
   private boolean[] P006O3_n110AgeCanti ;
   private String[] P006O3_A37TipoConCod ;
   private String[] P006O3_A41ConDescrip ;
   private String[] P006O3_A26ConCodigo ;
   private String[] P006O3_A591LegNomApe ;
   private String[] P006O3_A93LegId ;
   private boolean[] P006O3_n93LegId ;
   private int[] P006O3_A1254AgeLiqNro ;
   private boolean[] P006O3_n1254AgeLiqNro ;
   private short[] P006O3_A25AgeOrden ;
   private int[] P006O4_A6LegNumero ;
   private int[] P006O4_A3CliCod ;
   private String[] P006O4_A26ConCodigo ;
   private short[] P006O4_A1EmpCod ;
   private java.util.Date[] P006O4_A112AgeFecHas ;
   private boolean[] P006O4_n112AgeFecHas ;
   private java.util.Date[] P006O4_A111AgeFecDes ;
   private boolean[] P006O4_n111AgeFecDes ;
   private String[] P006O4_A2159AgePerDescrip ;
   private java.math.BigDecimal[] P006O4_A110AgeCanti ;
   private boolean[] P006O4_n110AgeCanti ;
   private String[] P006O4_A37TipoConCod ;
   private String[] P006O4_A41ConDescrip ;
   private String[] P006O4_A591LegNomApe ;
   private String[] P006O4_A93LegId ;
   private boolean[] P006O4_n93LegId ;
   private int[] P006O4_A1254AgeLiqNro ;
   private boolean[] P006O4_n1254AgeLiqNro ;
   private short[] P006O4_A25AgeOrden ;
   private int[] P006O5_A6LegNumero ;
   private int[] P006O5_A3CliCod ;
   private short[] P006O5_A1EmpCod ;
   private String[] P006O5_A41ConDescrip ;
   private java.util.Date[] P006O5_A112AgeFecHas ;
   private boolean[] P006O5_n112AgeFecHas ;
   private java.util.Date[] P006O5_A111AgeFecDes ;
   private boolean[] P006O5_n111AgeFecDes ;
   private String[] P006O5_A2159AgePerDescrip ;
   private java.math.BigDecimal[] P006O5_A110AgeCanti ;
   private boolean[] P006O5_n110AgeCanti ;
   private String[] P006O5_A37TipoConCod ;
   private String[] P006O5_A26ConCodigo ;
   private String[] P006O5_A591LegNomApe ;
   private String[] P006O5_A93LegId ;
   private boolean[] P006O5_n93LegId ;
   private int[] P006O5_A1254AgeLiqNro ;
   private boolean[] P006O5_n1254AgeLiqNro ;
   private short[] P006O5_A25AgeOrden ;
   private int[] P006O6_A6LegNumero ;
   private int[] P006O6_A3CliCod ;
   private short[] P006O6_A1EmpCod ;
   private String[] P006O6_A2159AgePerDescrip ;
   private java.util.Date[] P006O6_A112AgeFecHas ;
   private boolean[] P006O6_n112AgeFecHas ;
   private java.util.Date[] P006O6_A111AgeFecDes ;
   private boolean[] P006O6_n111AgeFecDes ;
   private java.math.BigDecimal[] P006O6_A110AgeCanti ;
   private boolean[] P006O6_n110AgeCanti ;
   private String[] P006O6_A37TipoConCod ;
   private String[] P006O6_A41ConDescrip ;
   private String[] P006O6_A26ConCodigo ;
   private String[] P006O6_A591LegNomApe ;
   private String[] P006O6_A93LegId ;
   private boolean[] P006O6_n93LegId ;
   private int[] P006O6_A1254AgeLiqNro ;
   private boolean[] P006O6_n1254AgeLiqNro ;
   private short[] P006O6_A25AgeOrden ;
   private int[] P006O7_A6LegNumero ;
   private int[] P006O7_A3CliCod ;
   private short[] P006O7_A1EmpCod ;
   private java.util.Date[] P006O7_A111AgeFecDes ;
   private boolean[] P006O7_n111AgeFecDes ;
   private java.util.Date[] P006O7_A112AgeFecHas ;
   private boolean[] P006O7_n112AgeFecHas ;
   private String[] P006O7_A2159AgePerDescrip ;
   private java.math.BigDecimal[] P006O7_A110AgeCanti ;
   private boolean[] P006O7_n110AgeCanti ;
   private String[] P006O7_A37TipoConCod ;
   private String[] P006O7_A41ConDescrip ;
   private String[] P006O7_A26ConCodigo ;
   private String[] P006O7_A591LegNomApe ;
   private String[] P006O7_A93LegId ;
   private boolean[] P006O7_n93LegId ;
   private int[] P006O7_A1254AgeLiqNro ;
   private boolean[] P006O7_n1254AgeLiqNro ;
   private short[] P006O7_A25AgeOrden ;
   private int[] P006O8_A6LegNumero ;
   private int[] P006O8_A3CliCod ;
   private short[] P006O8_A1EmpCod ;
   private java.util.Date[] P006O8_A112AgeFecHas ;
   private boolean[] P006O8_n112AgeFecHas ;
   private java.util.Date[] P006O8_A111AgeFecDes ;
   private boolean[] P006O8_n111AgeFecDes ;
   private String[] P006O8_A2159AgePerDescrip ;
   private java.math.BigDecimal[] P006O8_A110AgeCanti ;
   private boolean[] P006O8_n110AgeCanti ;
   private String[] P006O8_A37TipoConCod ;
   private String[] P006O8_A41ConDescrip ;
   private String[] P006O8_A26ConCodigo ;
   private String[] P006O8_A591LegNomApe ;
   private String[] P006O8_A93LegId ;
   private boolean[] P006O8_n93LegId ;
   private int[] P006O8_A1254AgeLiqNro ;
   private boolean[] P006O8_n1254AgeLiqNro ;
   private short[] P006O8_A25AgeOrden ;
   private GXSimpleCollection<String> AV71TFLegId_Sels ;
   private GXSimpleCollection<String> AV67TFConCodigo_Sels ;
   private GXSimpleCollection<String> AV79TFTipoConCod_Sels ;
   private GXSimpleCollection<String> AV46Options ;
   private GXSimpleCollection<String> AV49OptionsDesc ;
   private GXSimpleCollection<String> AV51OptionIndexes ;
   private GXSimpleCollection<String> AV82TFLegNomApe_Sels ;
   private GXSimpleCollection<String> AV69TFConDescrip_Sels ;
   private GXSimpleCollection<String> AV99TFAgePerDescrip_Sels ;
   private GXSimpleCollection<java.util.Date> AV93TFAgeFecDes_Sels ;
   private GXSimpleCollection<java.util.Date> AV95TFAgeFecHas_Sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV56GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV57GridStateFilterValue ;
}

final  class novedadeswwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P006O2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A93LegId ,
                                          GXSimpleCollection<String> AV71TFLegId_Sels ,
                                          String A591LegNomApe ,
                                          GXSimpleCollection<String> AV82TFLegNomApe_Sels ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV67TFConCodigo_Sels ,
                                          String A41ConDescrip ,
                                          GXSimpleCollection<String> AV69TFConDescrip_Sels ,
                                          String A37TipoConCod ,
                                          GXSimpleCollection<String> AV79TFTipoConCod_Sels ,
                                          String A2159AgePerDescrip ,
                                          GXSimpleCollection<String> AV99TFAgePerDescrip_Sels ,
                                          java.util.Date A111AgeFecDes ,
                                          GXSimpleCollection<java.util.Date> AV93TFAgeFecDes_Sels ,
                                          java.util.Date A112AgeFecHas ,
                                          GXSimpleCollection<java.util.Date> AV95TFAgeFecHas_Sels ,
                                          boolean AV91VerLiquidadas ,
                                          int AV71TFLegId_Sels_size ,
                                          String AV39TFLegId ,
                                          int AV82TFLegNomApe_Sels_size ,
                                          String AV81TFLegNomApe ,
                                          int AV67TFConCodigo_Sels_size ,
                                          String AV24TFConCodigo ,
                                          int AV69TFConDescrip_Sels_size ,
                                          String AV26TFConDescrip ,
                                          int AV79TFTipoConCod_Sels_size ,
                                          java.math.BigDecimal AV28TFAgeCanti ,
                                          java.math.BigDecimal AV29TFAgeCanti_To ,
                                          int AV99TFAgePerDescrip_Sels_size ,
                                          String AV98TFAgePerDescrip ,
                                          int AV93TFAgeFecDes_Sels_size ,
                                          int AV95TFAgeFecHas_Sels_size ,
                                          int AV89TFAgeLiqNro ,
                                          int AV90TFAgeLiqNro_To ,
                                          int A1254AgeLiqNro ,
                                          java.math.BigDecimal A110AgeCanti ,
                                          int A3CliCod ,
                                          int AV72CliCod ,
                                          short A1EmpCod ,
                                          short AV73EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[11];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T1.CliCod, T1.EmpCod, T2.LegId, T1.AgeFecHas, T1.AgeFecDes, T1.AgePerDescrip, T1.AgeCanti, T3.TipoConCod, T3.ConDescrip, T1.ConCodigo, T2.LegNomApe," ;
      scmdbuf += " T1.AgeLiqNro, T1.AgeOrden FROM ((AgendaNovedades T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) INNER" ;
      scmdbuf += " JOIN Concepto T3 ON T3.CliCod = T1.CliCod AND T3.ConCodigo = T1.ConCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      addWhere(sWhereString, "(T1.EmpCod = ?)");
      if ( ! AV91VerLiquidadas )
      {
         addWhere(sWhereString, "(T1.AgeLiqNro IS NULL)");
      }
      if ( ( AV71TFLegId_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV39TFLegId)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegId) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV71TFLegId_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV71TFLegId_Sels, "T2.LegId IN (", ")")+")");
      }
      if ( ( AV82TFLegNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV81TFLegNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV82TFLegNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV82TFLegNomApe_Sels, "T2.LegNomApe IN (", ")")+")");
      }
      if ( ( AV67TFConCodigo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV24TFConCodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( AV67TFConCodigo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV67TFConCodigo_Sels, "T1.ConCodigo IN (", ")")+")");
      }
      if ( ( AV69TFConDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV26TFConDescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.ConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( AV69TFConDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69TFConDescrip_Sels, "T3.ConDescrip IN (", ")")+")");
      }
      if ( AV79TFTipoConCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV79TFTipoConCod_Sels, "T3.TipoConCod IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV28TFAgeCanti)==0) )
      {
         addWhere(sWhereString, "(T1.AgeCanti >= ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV29TFAgeCanti_To)==0) )
      {
         addWhere(sWhereString, "(T1.AgeCanti <= ?)");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( ( AV99TFAgePerDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV98TFAgePerDescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.AgePerDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[8] = (byte)(1) ;
      }
      if ( AV99TFAgePerDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99TFAgePerDescrip_Sels, "T1.AgePerDescrip IN (", ")")+")");
      }
      if ( AV93TFAgeFecDes_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV93TFAgeFecDes_Sels, "T1.AgeFecDes IN (", ")")+")");
      }
      if ( AV95TFAgeFecHas_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV95TFAgeFecHas_Sels, "T1.AgeFecHas IN (", ")")+")");
      }
      if ( ! (0==AV89TFAgeLiqNro) )
      {
         addWhere(sWhereString, "(T1.AgeLiqNro >= ?)");
      }
      else
      {
         GXv_int8[9] = (byte)(1) ;
      }
      if ( ! (0==AV90TFAgeLiqNro_To) )
      {
         addWhere(sWhereString, "(T1.AgeLiqNro <= ?)");
      }
      else
      {
         GXv_int8[10] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T2.LegId" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P006O3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A93LegId ,
                                          GXSimpleCollection<String> AV71TFLegId_Sels ,
                                          String A591LegNomApe ,
                                          GXSimpleCollection<String> AV82TFLegNomApe_Sels ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV67TFConCodigo_Sels ,
                                          String A41ConDescrip ,
                                          GXSimpleCollection<String> AV69TFConDescrip_Sels ,
                                          String A37TipoConCod ,
                                          GXSimpleCollection<String> AV79TFTipoConCod_Sels ,
                                          String A2159AgePerDescrip ,
                                          GXSimpleCollection<String> AV99TFAgePerDescrip_Sels ,
                                          java.util.Date A111AgeFecDes ,
                                          GXSimpleCollection<java.util.Date> AV93TFAgeFecDes_Sels ,
                                          java.util.Date A112AgeFecHas ,
                                          GXSimpleCollection<java.util.Date> AV95TFAgeFecHas_Sels ,
                                          boolean AV91VerLiquidadas ,
                                          int AV71TFLegId_Sels_size ,
                                          String AV39TFLegId ,
                                          int AV82TFLegNomApe_Sels_size ,
                                          String AV81TFLegNomApe ,
                                          int AV67TFConCodigo_Sels_size ,
                                          String AV24TFConCodigo ,
                                          int AV69TFConDescrip_Sels_size ,
                                          String AV26TFConDescrip ,
                                          int AV79TFTipoConCod_Sels_size ,
                                          java.math.BigDecimal AV28TFAgeCanti ,
                                          java.math.BigDecimal AV29TFAgeCanti_To ,
                                          int AV99TFAgePerDescrip_Sels_size ,
                                          String AV98TFAgePerDescrip ,
                                          int AV93TFAgeFecDes_Sels_size ,
                                          int AV95TFAgeFecHas_Sels_size ,
                                          int AV89TFAgeLiqNro ,
                                          int AV90TFAgeLiqNro_To ,
                                          int A1254AgeLiqNro ,
                                          java.math.BigDecimal A110AgeCanti ,
                                          int AV72CliCod ,
                                          short AV73EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[11];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T1.EmpCod, T1.CliCod, T1.AgeFecHas, T1.AgeFecDes, T1.AgePerDescrip, T1.AgeCanti, T3.TipoConCod, T3.ConDescrip, T1.ConCodigo, T2.LegNomApe, T2.LegId," ;
      scmdbuf += " T1.AgeLiqNro, T1.AgeOrden FROM ((AgendaNovedades T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) INNER" ;
      scmdbuf += " JOIN Concepto T3 ON T3.CliCod = T1.CliCod AND T3.ConCodigo = T1.ConCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      if ( ! AV91VerLiquidadas )
      {
         addWhere(sWhereString, "(T1.AgeLiqNro IS NULL)");
      }
      if ( ( AV71TFLegId_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV39TFLegId)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegId) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV71TFLegId_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV71TFLegId_Sels, "T2.LegId IN (", ")")+")");
      }
      if ( ( AV82TFLegNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV81TFLegNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV82TFLegNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV82TFLegNomApe_Sels, "T2.LegNomApe IN (", ")")+")");
      }
      if ( ( AV67TFConCodigo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV24TFConCodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( AV67TFConCodigo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV67TFConCodigo_Sels, "T1.ConCodigo IN (", ")")+")");
      }
      if ( ( AV69TFConDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV26TFConDescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.ConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( AV69TFConDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69TFConDescrip_Sels, "T3.ConDescrip IN (", ")")+")");
      }
      if ( AV79TFTipoConCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV79TFTipoConCod_Sels, "T3.TipoConCod IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV28TFAgeCanti)==0) )
      {
         addWhere(sWhereString, "(T1.AgeCanti >= ?)");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV29TFAgeCanti_To)==0) )
      {
         addWhere(sWhereString, "(T1.AgeCanti <= ?)");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( ( AV99TFAgePerDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV98TFAgePerDescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.AgePerDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[8] = (byte)(1) ;
      }
      if ( AV99TFAgePerDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99TFAgePerDescrip_Sels, "T1.AgePerDescrip IN (", ")")+")");
      }
      if ( AV93TFAgeFecDes_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV93TFAgeFecDes_Sels, "T1.AgeFecDes IN (", ")")+")");
      }
      if ( AV95TFAgeFecHas_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV95TFAgeFecHas_Sels, "T1.AgeFecHas IN (", ")")+")");
      }
      if ( ! (0==AV89TFAgeLiqNro) )
      {
         addWhere(sWhereString, "(T1.AgeLiqNro >= ?)");
      }
      else
      {
         GXv_int11[9] = (byte)(1) ;
      }
      if ( ! (0==AV90TFAgeLiqNro_To) )
      {
         addWhere(sWhereString, "(T1.AgeLiqNro <= ?)");
      }
      else
      {
         GXv_int11[10] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P006O4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A93LegId ,
                                          GXSimpleCollection<String> AV71TFLegId_Sels ,
                                          String A591LegNomApe ,
                                          GXSimpleCollection<String> AV82TFLegNomApe_Sels ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV67TFConCodigo_Sels ,
                                          String A41ConDescrip ,
                                          GXSimpleCollection<String> AV69TFConDescrip_Sels ,
                                          String A37TipoConCod ,
                                          GXSimpleCollection<String> AV79TFTipoConCod_Sels ,
                                          String A2159AgePerDescrip ,
                                          GXSimpleCollection<String> AV99TFAgePerDescrip_Sels ,
                                          java.util.Date A111AgeFecDes ,
                                          GXSimpleCollection<java.util.Date> AV93TFAgeFecDes_Sels ,
                                          java.util.Date A112AgeFecHas ,
                                          GXSimpleCollection<java.util.Date> AV95TFAgeFecHas_Sels ,
                                          boolean AV91VerLiquidadas ,
                                          int AV71TFLegId_Sels_size ,
                                          String AV39TFLegId ,
                                          int AV82TFLegNomApe_Sels_size ,
                                          String AV81TFLegNomApe ,
                                          int AV67TFConCodigo_Sels_size ,
                                          String AV24TFConCodigo ,
                                          int AV69TFConDescrip_Sels_size ,
                                          String AV26TFConDescrip ,
                                          int AV79TFTipoConCod_Sels_size ,
                                          java.math.BigDecimal AV28TFAgeCanti ,
                                          java.math.BigDecimal AV29TFAgeCanti_To ,
                                          int AV99TFAgePerDescrip_Sels_size ,
                                          String AV98TFAgePerDescrip ,
                                          int AV93TFAgeFecDes_Sels_size ,
                                          int AV95TFAgeFecHas_Sels_size ,
                                          int AV89TFAgeLiqNro ,
                                          int AV90TFAgeLiqNro_To ,
                                          int A1254AgeLiqNro ,
                                          java.math.BigDecimal A110AgeCanti ,
                                          short A1EmpCod ,
                                          short AV73EmpCod ,
                                          int AV72CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[11];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T1.CliCod, T1.ConCodigo, T1.EmpCod, T1.AgeFecHas, T1.AgeFecDes, T1.AgePerDescrip, T1.AgeCanti, T2.TipoConCod, T2.ConDescrip, T3.LegNomApe, T3.LegId," ;
      scmdbuf += " T1.AgeLiqNro, T1.AgeOrden FROM ((AgendaNovedades T1 INNER JOIN Concepto T2 ON T2.CliCod = T1.CliCod AND T2.ConCodigo = T1.ConCodigo) INNER JOIN Legajo T3 ON T3.CliCod" ;
      scmdbuf += " = T1.CliCod AND T3.EmpCod = T1.EmpCod AND T3.LegNumero = T1.LegNumero)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      addWhere(sWhereString, "(T1.EmpCod = ?)");
      if ( ! AV91VerLiquidadas )
      {
         addWhere(sWhereString, "(T1.AgeLiqNro IS NULL)");
      }
      if ( ( AV71TFLegId_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV39TFLegId)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.LegId) like LOWER(?))");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( AV71TFLegId_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV71TFLegId_Sels, "T3.LegId IN (", ")")+")");
      }
      if ( ( AV82TFLegNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV81TFLegNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( AV82TFLegNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV82TFLegNomApe_Sels, "T3.LegNomApe IN (", ")")+")");
      }
      if ( ( AV67TFConCodigo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV24TFConCodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( AV67TFConCodigo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV67TFConCodigo_Sels, "T1.ConCodigo IN (", ")")+")");
      }
      if ( ( AV69TFConDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV26TFConDescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.ConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int14[5] = (byte)(1) ;
      }
      if ( AV69TFConDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69TFConDescrip_Sels, "T2.ConDescrip IN (", ")")+")");
      }
      if ( AV79TFTipoConCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV79TFTipoConCod_Sels, "T2.TipoConCod IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV28TFAgeCanti)==0) )
      {
         addWhere(sWhereString, "(T1.AgeCanti >= ?)");
      }
      else
      {
         GXv_int14[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV29TFAgeCanti_To)==0) )
      {
         addWhere(sWhereString, "(T1.AgeCanti <= ?)");
      }
      else
      {
         GXv_int14[7] = (byte)(1) ;
      }
      if ( ( AV99TFAgePerDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV98TFAgePerDescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.AgePerDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int14[8] = (byte)(1) ;
      }
      if ( AV99TFAgePerDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99TFAgePerDescrip_Sels, "T1.AgePerDescrip IN (", ")")+")");
      }
      if ( AV93TFAgeFecDes_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV93TFAgeFecDes_Sels, "T1.AgeFecDes IN (", ")")+")");
      }
      if ( AV95TFAgeFecHas_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV95TFAgeFecHas_Sels, "T1.AgeFecHas IN (", ")")+")");
      }
      if ( ! (0==AV89TFAgeLiqNro) )
      {
         addWhere(sWhereString, "(T1.AgeLiqNro >= ?)");
      }
      else
      {
         GXv_int14[9] = (byte)(1) ;
      }
      if ( ! (0==AV90TFAgeLiqNro_To) )
      {
         addWhere(sWhereString, "(T1.AgeLiqNro <= ?)");
      }
      else
      {
         GXv_int14[10] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.ConCodigo" ;
      GXv_Object15[0] = scmdbuf ;
      GXv_Object15[1] = GXv_int14 ;
      return GXv_Object15 ;
   }

   protected Object[] conditional_P006O5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A93LegId ,
                                          GXSimpleCollection<String> AV71TFLegId_Sels ,
                                          String A591LegNomApe ,
                                          GXSimpleCollection<String> AV82TFLegNomApe_Sels ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV67TFConCodigo_Sels ,
                                          String A41ConDescrip ,
                                          GXSimpleCollection<String> AV69TFConDescrip_Sels ,
                                          String A37TipoConCod ,
                                          GXSimpleCollection<String> AV79TFTipoConCod_Sels ,
                                          String A2159AgePerDescrip ,
                                          GXSimpleCollection<String> AV99TFAgePerDescrip_Sels ,
                                          java.util.Date A111AgeFecDes ,
                                          GXSimpleCollection<java.util.Date> AV93TFAgeFecDes_Sels ,
                                          java.util.Date A112AgeFecHas ,
                                          GXSimpleCollection<java.util.Date> AV95TFAgeFecHas_Sels ,
                                          boolean AV91VerLiquidadas ,
                                          int AV71TFLegId_Sels_size ,
                                          String AV39TFLegId ,
                                          int AV82TFLegNomApe_Sels_size ,
                                          String AV81TFLegNomApe ,
                                          int AV67TFConCodigo_Sels_size ,
                                          String AV24TFConCodigo ,
                                          int AV69TFConDescrip_Sels_size ,
                                          String AV26TFConDescrip ,
                                          int AV79TFTipoConCod_Sels_size ,
                                          java.math.BigDecimal AV28TFAgeCanti ,
                                          java.math.BigDecimal AV29TFAgeCanti_To ,
                                          int AV99TFAgePerDescrip_Sels_size ,
                                          String AV98TFAgePerDescrip ,
                                          int AV93TFAgeFecDes_Sels_size ,
                                          int AV95TFAgeFecHas_Sels_size ,
                                          int AV89TFAgeLiqNro ,
                                          int AV90TFAgeLiqNro_To ,
                                          int A1254AgeLiqNro ,
                                          java.math.BigDecimal A110AgeCanti ,
                                          int A3CliCod ,
                                          int AV72CliCod ,
                                          short A1EmpCod ,
                                          short AV73EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int17 = new byte[11];
      Object[] GXv_Object18 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T1.CliCod, T1.EmpCod, T3.ConDescrip, T1.AgeFecHas, T1.AgeFecDes, T1.AgePerDescrip, T1.AgeCanti, T3.TipoConCod, T1.ConCodigo, T2.LegNomApe, T2.LegId," ;
      scmdbuf += " T1.AgeLiqNro, T1.AgeOrden FROM ((AgendaNovedades T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) INNER" ;
      scmdbuf += " JOIN Concepto T3 ON T3.CliCod = T1.CliCod AND T3.ConCodigo = T1.ConCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      addWhere(sWhereString, "(T1.EmpCod = ?)");
      if ( ! AV91VerLiquidadas )
      {
         addWhere(sWhereString, "(T1.AgeLiqNro IS NULL)");
      }
      if ( ( AV71TFLegId_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV39TFLegId)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegId) like LOWER(?))");
      }
      else
      {
         GXv_int17[2] = (byte)(1) ;
      }
      if ( AV71TFLegId_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV71TFLegId_Sels, "T2.LegId IN (", ")")+")");
      }
      if ( ( AV82TFLegNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV81TFLegNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int17[3] = (byte)(1) ;
      }
      if ( AV82TFLegNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV82TFLegNomApe_Sels, "T2.LegNomApe IN (", ")")+")");
      }
      if ( ( AV67TFConCodigo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV24TFConCodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int17[4] = (byte)(1) ;
      }
      if ( AV67TFConCodigo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV67TFConCodigo_Sels, "T1.ConCodigo IN (", ")")+")");
      }
      if ( ( AV69TFConDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV26TFConDescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.ConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int17[5] = (byte)(1) ;
      }
      if ( AV69TFConDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69TFConDescrip_Sels, "T3.ConDescrip IN (", ")")+")");
      }
      if ( AV79TFTipoConCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV79TFTipoConCod_Sels, "T3.TipoConCod IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV28TFAgeCanti)==0) )
      {
         addWhere(sWhereString, "(T1.AgeCanti >= ?)");
      }
      else
      {
         GXv_int17[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV29TFAgeCanti_To)==0) )
      {
         addWhere(sWhereString, "(T1.AgeCanti <= ?)");
      }
      else
      {
         GXv_int17[7] = (byte)(1) ;
      }
      if ( ( AV99TFAgePerDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV98TFAgePerDescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.AgePerDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int17[8] = (byte)(1) ;
      }
      if ( AV99TFAgePerDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99TFAgePerDescrip_Sels, "T1.AgePerDescrip IN (", ")")+")");
      }
      if ( AV93TFAgeFecDes_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV93TFAgeFecDes_Sels, "T1.AgeFecDes IN (", ")")+")");
      }
      if ( AV95TFAgeFecHas_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV95TFAgeFecHas_Sels, "T1.AgeFecHas IN (", ")")+")");
      }
      if ( ! (0==AV89TFAgeLiqNro) )
      {
         addWhere(sWhereString, "(T1.AgeLiqNro >= ?)");
      }
      else
      {
         GXv_int17[9] = (byte)(1) ;
      }
      if ( ! (0==AV90TFAgeLiqNro_To) )
      {
         addWhere(sWhereString, "(T1.AgeLiqNro <= ?)");
      }
      else
      {
         GXv_int17[10] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T3.ConDescrip" ;
      GXv_Object18[0] = scmdbuf ;
      GXv_Object18[1] = GXv_int17 ;
      return GXv_Object18 ;
   }

   protected Object[] conditional_P006O6( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A93LegId ,
                                          GXSimpleCollection<String> AV71TFLegId_Sels ,
                                          String A591LegNomApe ,
                                          GXSimpleCollection<String> AV82TFLegNomApe_Sels ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV67TFConCodigo_Sels ,
                                          String A41ConDescrip ,
                                          GXSimpleCollection<String> AV69TFConDescrip_Sels ,
                                          String A37TipoConCod ,
                                          GXSimpleCollection<String> AV79TFTipoConCod_Sels ,
                                          String A2159AgePerDescrip ,
                                          GXSimpleCollection<String> AV99TFAgePerDescrip_Sels ,
                                          java.util.Date A111AgeFecDes ,
                                          GXSimpleCollection<java.util.Date> AV93TFAgeFecDes_Sels ,
                                          java.util.Date A112AgeFecHas ,
                                          GXSimpleCollection<java.util.Date> AV95TFAgeFecHas_Sels ,
                                          boolean AV91VerLiquidadas ,
                                          int AV71TFLegId_Sels_size ,
                                          String AV39TFLegId ,
                                          int AV82TFLegNomApe_Sels_size ,
                                          String AV81TFLegNomApe ,
                                          int AV67TFConCodigo_Sels_size ,
                                          String AV24TFConCodigo ,
                                          int AV69TFConDescrip_Sels_size ,
                                          String AV26TFConDescrip ,
                                          int AV79TFTipoConCod_Sels_size ,
                                          java.math.BigDecimal AV28TFAgeCanti ,
                                          java.math.BigDecimal AV29TFAgeCanti_To ,
                                          int AV99TFAgePerDescrip_Sels_size ,
                                          String AV98TFAgePerDescrip ,
                                          int AV93TFAgeFecDes_Sels_size ,
                                          int AV95TFAgeFecHas_Sels_size ,
                                          int AV89TFAgeLiqNro ,
                                          int AV90TFAgeLiqNro_To ,
                                          int A1254AgeLiqNro ,
                                          java.math.BigDecimal A110AgeCanti ,
                                          int A3CliCod ,
                                          int AV72CliCod ,
                                          short A1EmpCod ,
                                          short AV73EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int20 = new byte[11];
      Object[] GXv_Object21 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T1.CliCod, T1.EmpCod, T1.AgePerDescrip, T1.AgeFecHas, T1.AgeFecDes, T1.AgeCanti, T3.TipoConCod, T3.ConDescrip, T1.ConCodigo, T2.LegNomApe, T2.LegId," ;
      scmdbuf += " T1.AgeLiqNro, T1.AgeOrden FROM ((AgendaNovedades T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) INNER" ;
      scmdbuf += " JOIN Concepto T3 ON T3.CliCod = T1.CliCod AND T3.ConCodigo = T1.ConCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      addWhere(sWhereString, "(T1.EmpCod = ?)");
      if ( ! AV91VerLiquidadas )
      {
         addWhere(sWhereString, "(T1.AgeLiqNro IS NULL)");
      }
      if ( ( AV71TFLegId_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV39TFLegId)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegId) like LOWER(?))");
      }
      else
      {
         GXv_int20[2] = (byte)(1) ;
      }
      if ( AV71TFLegId_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV71TFLegId_Sels, "T2.LegId IN (", ")")+")");
      }
      if ( ( AV82TFLegNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV81TFLegNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int20[3] = (byte)(1) ;
      }
      if ( AV82TFLegNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV82TFLegNomApe_Sels, "T2.LegNomApe IN (", ")")+")");
      }
      if ( ( AV67TFConCodigo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV24TFConCodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int20[4] = (byte)(1) ;
      }
      if ( AV67TFConCodigo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV67TFConCodigo_Sels, "T1.ConCodigo IN (", ")")+")");
      }
      if ( ( AV69TFConDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV26TFConDescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.ConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int20[5] = (byte)(1) ;
      }
      if ( AV69TFConDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69TFConDescrip_Sels, "T3.ConDescrip IN (", ")")+")");
      }
      if ( AV79TFTipoConCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV79TFTipoConCod_Sels, "T3.TipoConCod IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV28TFAgeCanti)==0) )
      {
         addWhere(sWhereString, "(T1.AgeCanti >= ?)");
      }
      else
      {
         GXv_int20[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV29TFAgeCanti_To)==0) )
      {
         addWhere(sWhereString, "(T1.AgeCanti <= ?)");
      }
      else
      {
         GXv_int20[7] = (byte)(1) ;
      }
      if ( ( AV99TFAgePerDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV98TFAgePerDescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.AgePerDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int20[8] = (byte)(1) ;
      }
      if ( AV99TFAgePerDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99TFAgePerDescrip_Sels, "T1.AgePerDescrip IN (", ")")+")");
      }
      if ( AV93TFAgeFecDes_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV93TFAgeFecDes_Sels, "T1.AgeFecDes IN (", ")")+")");
      }
      if ( AV95TFAgeFecHas_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV95TFAgeFecHas_Sels, "T1.AgeFecHas IN (", ")")+")");
      }
      if ( ! (0==AV89TFAgeLiqNro) )
      {
         addWhere(sWhereString, "(T1.AgeLiqNro >= ?)");
      }
      else
      {
         GXv_int20[9] = (byte)(1) ;
      }
      if ( ! (0==AV90TFAgeLiqNro_To) )
      {
         addWhere(sWhereString, "(T1.AgeLiqNro <= ?)");
      }
      else
      {
         GXv_int20[10] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.AgePerDescrip" ;
      GXv_Object21[0] = scmdbuf ;
      GXv_Object21[1] = GXv_int20 ;
      return GXv_Object21 ;
   }

   protected Object[] conditional_P006O7( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A93LegId ,
                                          GXSimpleCollection<String> AV71TFLegId_Sels ,
                                          String A591LegNomApe ,
                                          GXSimpleCollection<String> AV82TFLegNomApe_Sels ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV67TFConCodigo_Sels ,
                                          String A41ConDescrip ,
                                          GXSimpleCollection<String> AV69TFConDescrip_Sels ,
                                          String A37TipoConCod ,
                                          GXSimpleCollection<String> AV79TFTipoConCod_Sels ,
                                          String A2159AgePerDescrip ,
                                          GXSimpleCollection<String> AV99TFAgePerDescrip_Sels ,
                                          java.util.Date A111AgeFecDes ,
                                          GXSimpleCollection<java.util.Date> AV93TFAgeFecDes_Sels ,
                                          java.util.Date A112AgeFecHas ,
                                          GXSimpleCollection<java.util.Date> AV95TFAgeFecHas_Sels ,
                                          boolean AV91VerLiquidadas ,
                                          int AV71TFLegId_Sels_size ,
                                          String AV39TFLegId ,
                                          int AV82TFLegNomApe_Sels_size ,
                                          String AV81TFLegNomApe ,
                                          int AV67TFConCodigo_Sels_size ,
                                          String AV24TFConCodigo ,
                                          int AV69TFConDescrip_Sels_size ,
                                          String AV26TFConDescrip ,
                                          int AV79TFTipoConCod_Sels_size ,
                                          java.math.BigDecimal AV28TFAgeCanti ,
                                          java.math.BigDecimal AV29TFAgeCanti_To ,
                                          int AV99TFAgePerDescrip_Sels_size ,
                                          String AV98TFAgePerDescrip ,
                                          int AV93TFAgeFecDes_Sels_size ,
                                          int AV95TFAgeFecHas_Sels_size ,
                                          int AV89TFAgeLiqNro ,
                                          int AV90TFAgeLiqNro_To ,
                                          int A1254AgeLiqNro ,
                                          java.math.BigDecimal A110AgeCanti ,
                                          int A3CliCod ,
                                          int AV72CliCod ,
                                          short A1EmpCod ,
                                          short AV73EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int23 = new byte[11];
      Object[] GXv_Object24 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T1.CliCod, T1.EmpCod, T1.AgeFecDes, T1.AgeFecHas, T1.AgePerDescrip, T1.AgeCanti, T3.TipoConCod, T3.ConDescrip, T1.ConCodigo, T2.LegNomApe, T2.LegId," ;
      scmdbuf += " T1.AgeLiqNro, T1.AgeOrden FROM ((AgendaNovedades T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) INNER" ;
      scmdbuf += " JOIN Concepto T3 ON T3.CliCod = T1.CliCod AND T3.ConCodigo = T1.ConCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      addWhere(sWhereString, "(T1.EmpCod = ?)");
      if ( ! AV91VerLiquidadas )
      {
         addWhere(sWhereString, "(T1.AgeLiqNro IS NULL)");
      }
      if ( ( AV71TFLegId_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV39TFLegId)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegId) like LOWER(?))");
      }
      else
      {
         GXv_int23[2] = (byte)(1) ;
      }
      if ( AV71TFLegId_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV71TFLegId_Sels, "T2.LegId IN (", ")")+")");
      }
      if ( ( AV82TFLegNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV81TFLegNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int23[3] = (byte)(1) ;
      }
      if ( AV82TFLegNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV82TFLegNomApe_Sels, "T2.LegNomApe IN (", ")")+")");
      }
      if ( ( AV67TFConCodigo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV24TFConCodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int23[4] = (byte)(1) ;
      }
      if ( AV67TFConCodigo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV67TFConCodigo_Sels, "T1.ConCodigo IN (", ")")+")");
      }
      if ( ( AV69TFConDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV26TFConDescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.ConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int23[5] = (byte)(1) ;
      }
      if ( AV69TFConDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69TFConDescrip_Sels, "T3.ConDescrip IN (", ")")+")");
      }
      if ( AV79TFTipoConCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV79TFTipoConCod_Sels, "T3.TipoConCod IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV28TFAgeCanti)==0) )
      {
         addWhere(sWhereString, "(T1.AgeCanti >= ?)");
      }
      else
      {
         GXv_int23[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV29TFAgeCanti_To)==0) )
      {
         addWhere(sWhereString, "(T1.AgeCanti <= ?)");
      }
      else
      {
         GXv_int23[7] = (byte)(1) ;
      }
      if ( ( AV99TFAgePerDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV98TFAgePerDescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.AgePerDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int23[8] = (byte)(1) ;
      }
      if ( AV99TFAgePerDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99TFAgePerDescrip_Sels, "T1.AgePerDescrip IN (", ")")+")");
      }
      if ( AV93TFAgeFecDes_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV93TFAgeFecDes_Sels, "T1.AgeFecDes IN (", ")")+")");
      }
      if ( AV95TFAgeFecHas_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV95TFAgeFecHas_Sels, "T1.AgeFecHas IN (", ")")+")");
      }
      if ( ! (0==AV89TFAgeLiqNro) )
      {
         addWhere(sWhereString, "(T1.AgeLiqNro >= ?)");
      }
      else
      {
         GXv_int23[9] = (byte)(1) ;
      }
      if ( ! (0==AV90TFAgeLiqNro_To) )
      {
         addWhere(sWhereString, "(T1.AgeLiqNro <= ?)");
      }
      else
      {
         GXv_int23[10] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.AgeFecDes" ;
      GXv_Object24[0] = scmdbuf ;
      GXv_Object24[1] = GXv_int23 ;
      return GXv_Object24 ;
   }

   protected Object[] conditional_P006O8( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A93LegId ,
                                          GXSimpleCollection<String> AV71TFLegId_Sels ,
                                          String A591LegNomApe ,
                                          GXSimpleCollection<String> AV82TFLegNomApe_Sels ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV67TFConCodigo_Sels ,
                                          String A41ConDescrip ,
                                          GXSimpleCollection<String> AV69TFConDescrip_Sels ,
                                          String A37TipoConCod ,
                                          GXSimpleCollection<String> AV79TFTipoConCod_Sels ,
                                          String A2159AgePerDescrip ,
                                          GXSimpleCollection<String> AV99TFAgePerDescrip_Sels ,
                                          java.util.Date A111AgeFecDes ,
                                          GXSimpleCollection<java.util.Date> AV93TFAgeFecDes_Sels ,
                                          java.util.Date A112AgeFecHas ,
                                          GXSimpleCollection<java.util.Date> AV95TFAgeFecHas_Sels ,
                                          boolean AV91VerLiquidadas ,
                                          int AV71TFLegId_Sels_size ,
                                          String AV39TFLegId ,
                                          int AV82TFLegNomApe_Sels_size ,
                                          String AV81TFLegNomApe ,
                                          int AV67TFConCodigo_Sels_size ,
                                          String AV24TFConCodigo ,
                                          int AV69TFConDescrip_Sels_size ,
                                          String AV26TFConDescrip ,
                                          int AV79TFTipoConCod_Sels_size ,
                                          java.math.BigDecimal AV28TFAgeCanti ,
                                          java.math.BigDecimal AV29TFAgeCanti_To ,
                                          int AV99TFAgePerDescrip_Sels_size ,
                                          String AV98TFAgePerDescrip ,
                                          int AV93TFAgeFecDes_Sels_size ,
                                          int AV95TFAgeFecHas_Sels_size ,
                                          int AV89TFAgeLiqNro ,
                                          int AV90TFAgeLiqNro_To ,
                                          int A1254AgeLiqNro ,
                                          java.math.BigDecimal A110AgeCanti ,
                                          int A3CliCod ,
                                          int AV72CliCod ,
                                          short A1EmpCod ,
                                          short AV73EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int26 = new byte[11];
      Object[] GXv_Object27 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T1.CliCod, T1.EmpCod, T1.AgeFecHas, T1.AgeFecDes, T1.AgePerDescrip, T1.AgeCanti, T3.TipoConCod, T3.ConDescrip, T1.ConCodigo, T2.LegNomApe, T2.LegId," ;
      scmdbuf += " T1.AgeLiqNro, T1.AgeOrden FROM ((AgendaNovedades T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) INNER" ;
      scmdbuf += " JOIN Concepto T3 ON T3.CliCod = T1.CliCod AND T3.ConCodigo = T1.ConCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      addWhere(sWhereString, "(T1.EmpCod = ?)");
      if ( ! AV91VerLiquidadas )
      {
         addWhere(sWhereString, "(T1.AgeLiqNro IS NULL)");
      }
      if ( ( AV71TFLegId_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV39TFLegId)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegId) like LOWER(?))");
      }
      else
      {
         GXv_int26[2] = (byte)(1) ;
      }
      if ( AV71TFLegId_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV71TFLegId_Sels, "T2.LegId IN (", ")")+")");
      }
      if ( ( AV82TFLegNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV81TFLegNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int26[3] = (byte)(1) ;
      }
      if ( AV82TFLegNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV82TFLegNomApe_Sels, "T2.LegNomApe IN (", ")")+")");
      }
      if ( ( AV67TFConCodigo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV24TFConCodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int26[4] = (byte)(1) ;
      }
      if ( AV67TFConCodigo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV67TFConCodigo_Sels, "T1.ConCodigo IN (", ")")+")");
      }
      if ( ( AV69TFConDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV26TFConDescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.ConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int26[5] = (byte)(1) ;
      }
      if ( AV69TFConDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69TFConDescrip_Sels, "T3.ConDescrip IN (", ")")+")");
      }
      if ( AV79TFTipoConCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV79TFTipoConCod_Sels, "T3.TipoConCod IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV28TFAgeCanti)==0) )
      {
         addWhere(sWhereString, "(T1.AgeCanti >= ?)");
      }
      else
      {
         GXv_int26[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV29TFAgeCanti_To)==0) )
      {
         addWhere(sWhereString, "(T1.AgeCanti <= ?)");
      }
      else
      {
         GXv_int26[7] = (byte)(1) ;
      }
      if ( ( AV99TFAgePerDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV98TFAgePerDescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.AgePerDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int26[8] = (byte)(1) ;
      }
      if ( AV99TFAgePerDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99TFAgePerDescrip_Sels, "T1.AgePerDescrip IN (", ")")+")");
      }
      if ( AV93TFAgeFecDes_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV93TFAgeFecDes_Sels, "T1.AgeFecDes IN (", ")")+")");
      }
      if ( AV95TFAgeFecHas_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV95TFAgeFecHas_Sels, "T1.AgeFecHas IN (", ")")+")");
      }
      if ( ! (0==AV89TFAgeLiqNro) )
      {
         addWhere(sWhereString, "(T1.AgeLiqNro >= ?)");
      }
      else
      {
         GXv_int26[9] = (byte)(1) ;
      }
      if ( ! (0==AV90TFAgeLiqNro_To) )
      {
         addWhere(sWhereString, "(T1.AgeLiqNro <= ?)");
      }
      else
      {
         GXv_int26[10] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.AgeFecHas" ;
      GXv_Object27[0] = scmdbuf ;
      GXv_Object27[1] = GXv_int26 ;
      return GXv_Object27 ;
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
                  return conditional_P006O2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (java.util.Date)dynConstraints[12] , (GXSimpleCollection<java.util.Date>)dynConstraints[13] , (java.util.Date)dynConstraints[14] , (GXSimpleCollection<java.util.Date>)dynConstraints[15] , ((Boolean) dynConstraints[16]).booleanValue() , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , (String)dynConstraints[24] , ((Number) dynConstraints[25]).intValue() , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).intValue() , (java.math.BigDecimal)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , ((Number) dynConstraints[37]).intValue() , ((Number) dynConstraints[38]).shortValue() , ((Number) dynConstraints[39]).shortValue() );
            case 1 :
                  return conditional_P006O3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (java.util.Date)dynConstraints[12] , (GXSimpleCollection<java.util.Date>)dynConstraints[13] , (java.util.Date)dynConstraints[14] , (GXSimpleCollection<java.util.Date>)dynConstraints[15] , ((Boolean) dynConstraints[16]).booleanValue() , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , (String)dynConstraints[24] , ((Number) dynConstraints[25]).intValue() , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).intValue() , (java.math.BigDecimal)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , ((Number) dynConstraints[37]).shortValue() , ((Number) dynConstraints[38]).intValue() , ((Number) dynConstraints[39]).shortValue() );
            case 2 :
                  return conditional_P006O4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (java.util.Date)dynConstraints[12] , (GXSimpleCollection<java.util.Date>)dynConstraints[13] , (java.util.Date)dynConstraints[14] , (GXSimpleCollection<java.util.Date>)dynConstraints[15] , ((Boolean) dynConstraints[16]).booleanValue() , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , (String)dynConstraints[24] , ((Number) dynConstraints[25]).intValue() , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).intValue() , (java.math.BigDecimal)dynConstraints[35] , ((Number) dynConstraints[36]).shortValue() , ((Number) dynConstraints[37]).shortValue() , ((Number) dynConstraints[38]).intValue() , ((Number) dynConstraints[39]).intValue() );
            case 3 :
                  return conditional_P006O5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (java.util.Date)dynConstraints[12] , (GXSimpleCollection<java.util.Date>)dynConstraints[13] , (java.util.Date)dynConstraints[14] , (GXSimpleCollection<java.util.Date>)dynConstraints[15] , ((Boolean) dynConstraints[16]).booleanValue() , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , (String)dynConstraints[24] , ((Number) dynConstraints[25]).intValue() , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).intValue() , (java.math.BigDecimal)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , ((Number) dynConstraints[37]).intValue() , ((Number) dynConstraints[38]).shortValue() , ((Number) dynConstraints[39]).shortValue() );
            case 4 :
                  return conditional_P006O6(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (java.util.Date)dynConstraints[12] , (GXSimpleCollection<java.util.Date>)dynConstraints[13] , (java.util.Date)dynConstraints[14] , (GXSimpleCollection<java.util.Date>)dynConstraints[15] , ((Boolean) dynConstraints[16]).booleanValue() , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , (String)dynConstraints[24] , ((Number) dynConstraints[25]).intValue() , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).intValue() , (java.math.BigDecimal)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , ((Number) dynConstraints[37]).intValue() , ((Number) dynConstraints[38]).shortValue() , ((Number) dynConstraints[39]).shortValue() );
            case 5 :
                  return conditional_P006O7(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (java.util.Date)dynConstraints[12] , (GXSimpleCollection<java.util.Date>)dynConstraints[13] , (java.util.Date)dynConstraints[14] , (GXSimpleCollection<java.util.Date>)dynConstraints[15] , ((Boolean) dynConstraints[16]).booleanValue() , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , (String)dynConstraints[24] , ((Number) dynConstraints[25]).intValue() , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).intValue() , (java.math.BigDecimal)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , ((Number) dynConstraints[37]).intValue() , ((Number) dynConstraints[38]).shortValue() , ((Number) dynConstraints[39]).shortValue() );
            case 6 :
                  return conditional_P006O8(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (java.util.Date)dynConstraints[12] , (GXSimpleCollection<java.util.Date>)dynConstraints[13] , (java.util.Date)dynConstraints[14] , (GXSimpleCollection<java.util.Date>)dynConstraints[15] , ((Boolean) dynConstraints[16]).booleanValue() , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , (String)dynConstraints[24] , ((Number) dynConstraints[25]).intValue() , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).intValue() , (java.math.BigDecimal)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , ((Number) dynConstraints[37]).intValue() , ((Number) dynConstraints[38]).shortValue() , ((Number) dynConstraints[39]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006O2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006O3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006O4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006O5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006O6", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006O7", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006O8", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getVarchar(7);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(8,2);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((String[]) buf[12])[0] = rslt.getString(9, 20);
               ((String[]) buf[13])[0] = rslt.getVarchar(10);
               ((String[]) buf[14])[0] = rslt.getString(11, 10);
               ((String[]) buf[15])[0] = rslt.getVarchar(12);
               ((int[]) buf[16])[0] = rslt.getInt(13);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((short[]) buf[18])[0] = rslt.getShort(14);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(6);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(7,2);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(8, 20);
               ((String[]) buf[11])[0] = rslt.getVarchar(9);
               ((String[]) buf[12])[0] = rslt.getString(10, 10);
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((String[]) buf[14])[0] = rslt.getString(12, 20);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((int[]) buf[16])[0] = rslt.getInt(13);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((short[]) buf[18])[0] = rslt.getShort(14);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(8,2);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getString(9, 20);
               ((String[]) buf[12])[0] = rslt.getVarchar(10);
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((String[]) buf[14])[0] = rslt.getString(12, 20);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((int[]) buf[16])[0] = rslt.getInt(13);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((short[]) buf[18])[0] = rslt.getShort(14);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(8,2);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getString(9, 20);
               ((String[]) buf[12])[0] = rslt.getString(10, 10);
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((String[]) buf[14])[0] = rslt.getString(12, 20);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((int[]) buf[16])[0] = rslt.getInt(13);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((short[]) buf[18])[0] = rslt.getShort(14);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(7,2);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(8, 20);
               ((String[]) buf[11])[0] = rslt.getVarchar(9);
               ((String[]) buf[12])[0] = rslt.getString(10, 10);
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((String[]) buf[14])[0] = rslt.getString(12, 20);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((int[]) buf[16])[0] = rslt.getInt(13);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((short[]) buf[18])[0] = rslt.getShort(14);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(6);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(7,2);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(8, 20);
               ((String[]) buf[11])[0] = rslt.getVarchar(9);
               ((String[]) buf[12])[0] = rslt.getString(10, 10);
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((String[]) buf[14])[0] = rslt.getString(12, 20);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((int[]) buf[16])[0] = rslt.getInt(13);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((short[]) buf[18])[0] = rslt.getShort(14);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(6);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(7,2);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(8, 20);
               ((String[]) buf[11])[0] = rslt.getVarchar(9);
               ((String[]) buf[12])[0] = rslt.getString(10, 10);
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((String[]) buf[14])[0] = rslt.getString(12, 20);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((int[]) buf[16])[0] = rslt.getInt(13);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((short[]) buf[18])[0] = rslt.getShort(14);
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
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[15], 10);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[17], 2);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[18], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 400);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[20]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[21]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[15], 10);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[17], 2);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[18], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 400);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[20]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[21]).intValue());
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[15], 10);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[17], 2);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[18], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 400);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[20]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[21]).intValue());
               }
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[15], 10);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[17], 2);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[18], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 400);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[20]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[21]).intValue());
               }
               return;
            case 4 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[15], 10);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[17], 2);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[18], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 400);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[20]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[21]).intValue());
               }
               return;
            case 5 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[15], 10);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[17], 2);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[18], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 400);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[20]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[21]).intValue());
               }
               return;
            case 6 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[15], 10);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[17], 2);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[18], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 400);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[20]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[21]).intValue());
               }
               return;
      }
   }

}

