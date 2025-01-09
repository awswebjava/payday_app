package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class faltas_y_tardeswwgetfilterdata extends GXProcedure
{
   public faltas_y_tardeswwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( faltas_y_tardeswwgetfilterdata.class ), "" );
   }

   public faltas_y_tardeswwgetfilterdata( int remoteHandle ,
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
      faltas_y_tardeswwgetfilterdata.this.aP5 = new String[] {""};
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
      faltas_y_tardeswwgetfilterdata.this.AV30DDOName = aP0;
      faltas_y_tardeswwgetfilterdata.this.AV31SearchTxt = aP1;
      faltas_y_tardeswwgetfilterdata.this.AV32SearchTxtTo = aP2;
      faltas_y_tardeswwgetfilterdata.this.aP3 = aP3;
      faltas_y_tardeswwgetfilterdata.this.aP4 = aP4;
      faltas_y_tardeswwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV37EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      faltas_y_tardeswwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV37EmpCod = GXt_int1 ;
      GXt_int3 = AV38CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      faltas_y_tardeswwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV38CliCod = GXt_int3 ;
      AV20Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV22OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV23OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWNovedadEventos", GXv_boolean6) ;
      faltas_y_tardeswwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV30DDOName), "DDO_LEGID") == 0 )
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
         else if ( GXutil.strcmp(GXutil.upper( AV30DDOName), "DDO_LEGNOMAPE") == 0 )
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
         else if ( GXutil.strcmp(GXutil.upper( AV30DDOName), "DDO_LEGLICDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADLEGLICDESCRIPOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV33OptionsJson = AV20Options.toJSonString(false) ;
      AV34OptionsDescJson = AV22OptionsDesc.toJSonString(false) ;
      AV35OptionIndexesJson = AV23OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV25Session.getValue("faltas_y_tardesWWGridState"), "") == 0 )
      {
         AV27GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "faltas_y_tardesWWGridState"), null, null);
      }
      else
      {
         AV27GridState.fromxml(AV25Session.getValue("faltas_y_tardesWWGridState"), null, null);
      }
      AV53GXV1 = 1 ;
      while ( AV53GXV1 <= AV27GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV28GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV27GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV53GXV1));
         if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "SITLICCUENTATRAB") == 0 )
         {
            AV46SitLicCuentaTrab = GXutil.boolval( AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "SITESLICENCIA") == 0 )
         {
            AV47SitEsLicencia = GXutil.boolval( AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGID") == 0 )
         {
            AV40TFLegId = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGID_SEL") == 0 )
         {
            AV39TFLegId_SelsJson = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV41TFLegId_Sels.fromJSonString(AV39TFLegId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGNOMAPE") == 0 )
         {
            AV43TFLegNomApe = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGNOMAPE_SEL") == 0 )
         {
            AV42TFLegNomApe_SelsJson = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV44TFLegNomApe_Sels.fromJSonString(AV42TFLegNomApe_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGLICENINI") == 0 )
         {
            AV11TFLegLicenIni = localUtil.ctod( AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV12TFLegLicenIni_To = localUtil.ctod( AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGLICENFIN") == 0 )
         {
            AV13TFLegLicenFin = localUtil.ctod( AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV14TFLegLicenFin_To = localUtil.ctod( AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGLICDESCRIP") == 0 )
         {
            AV16TFLegLicDescrip = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGLICDESCRIP_SEL") == 0 )
         {
            AV15TFLegLicDescrip_SelsJson = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV17TFLegLicDescrip_Sels.fromJSonString(AV15TFLegLicDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV50MenuOpcCod = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV53GXV1 = (int)(AV53GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADLEGIDOPTIONS' Routine */
      returnInSub = false ;
      AV40TFLegId = AV31SearchTxt ;
      AV41TFLegId_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV55Faltas_y_tardeswwds_1_sitliccuentatrab = AV46SitLicCuentaTrab ;
      AV56Faltas_y_tardeswwds_2_siteslicencia = AV47SitEsLicencia ;
      AV57Faltas_y_tardeswwds_3_tflegid = AV40TFLegId ;
      AV58Faltas_y_tardeswwds_4_tflegid_sels = AV41TFLegId_Sels ;
      AV59Faltas_y_tardeswwds_5_tflegnomape = AV43TFLegNomApe ;
      AV60Faltas_y_tardeswwds_6_tflegnomape_sels = AV44TFLegNomApe_Sels ;
      AV61Faltas_y_tardeswwds_7_tfleglicenini = AV11TFLegLicenIni ;
      AV62Faltas_y_tardeswwds_8_tfleglicenini_to = AV12TFLegLicenIni_To ;
      AV63Faltas_y_tardeswwds_9_tfleglicenfin = AV13TFLegLicenFin ;
      AV64Faltas_y_tardeswwds_10_tfleglicenfin_to = AV14TFLegLicenFin_To ;
      AV65Faltas_y_tardeswwds_11_tfleglicdescrip = AV16TFLegLicDescrip ;
      AV66Faltas_y_tardeswwds_12_tfleglicdescrip_sels = AV17TFLegLicDescrip_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A93LegId ,
                                           AV58Faltas_y_tardeswwds_4_tflegid_sels ,
                                           A591LegNomApe ,
                                           AV60Faltas_y_tardeswwds_6_tflegnomape_sels ,
                                           A914LegLicDescrip ,
                                           AV66Faltas_y_tardeswwds_12_tfleglicdescrip_sels ,
                                           Integer.valueOf(AV58Faltas_y_tardeswwds_4_tflegid_sels.size()) ,
                                           AV57Faltas_y_tardeswwds_3_tflegid ,
                                           Integer.valueOf(AV60Faltas_y_tardeswwds_6_tflegnomape_sels.size()) ,
                                           AV59Faltas_y_tardeswwds_5_tflegnomape ,
                                           AV61Faltas_y_tardeswwds_7_tfleglicenini ,
                                           AV62Faltas_y_tardeswwds_8_tfleglicenini_to ,
                                           AV63Faltas_y_tardeswwds_9_tfleglicenfin ,
                                           AV64Faltas_y_tardeswwds_10_tfleglicenfin_to ,
                                           Integer.valueOf(AV66Faltas_y_tardeswwds_12_tfleglicdescrip_sels.size()) ,
                                           AV65Faltas_y_tardeswwds_11_tfleglicdescrip ,
                                           A76LegLicenIni ,
                                           A481LegLicenFin ,
                                           Byte.valueOf(A1643LegSitCuenTrab) ,
                                           Byte.valueOf(A1287LegSitEsLic) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV38CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV37EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV57Faltas_y_tardeswwds_3_tflegid = GXutil.padr( GXutil.rtrim( AV57Faltas_y_tardeswwds_3_tflegid), 20, "%") ;
      lV59Faltas_y_tardeswwds_5_tflegnomape = GXutil.concat( GXutil.rtrim( AV59Faltas_y_tardeswwds_5_tflegnomape), "%", "") ;
      lV65Faltas_y_tardeswwds_11_tfleglicdescrip = GXutil.concat( GXutil.rtrim( AV65Faltas_y_tardeswwds_11_tfleglicdescrip), "%", "") ;
      /* Using cursor P01CB2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV38CliCod), Short.valueOf(AV37EmpCod), lV57Faltas_y_tardeswwds_3_tflegid, lV59Faltas_y_tardeswwds_5_tflegnomape, AV61Faltas_y_tardeswwds_7_tfleglicenini, AV62Faltas_y_tardeswwds_8_tfleglicenini_to, AV63Faltas_y_tardeswwds_9_tfleglicenfin, AV64Faltas_y_tardeswwds_10_tfleglicenfin_to, lV65Faltas_y_tardeswwds_11_tfleglicdescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1CB2 = false ;
         A6LegNumero = P01CB2_A6LegNumero[0] ;
         A1643LegSitCuenTrab = P01CB2_A1643LegSitCuenTrab[0] ;
         A1287LegSitEsLic = P01CB2_A1287LegSitEsLic[0] ;
         A3CliCod = P01CB2_A3CliCod[0] ;
         A1EmpCod = P01CB2_A1EmpCod[0] ;
         A93LegId = P01CB2_A93LegId[0] ;
         n93LegId = P01CB2_n93LegId[0] ;
         A914LegLicDescrip = P01CB2_A914LegLicDescrip[0] ;
         A481LegLicenFin = P01CB2_A481LegLicenFin[0] ;
         A76LegLicenIni = P01CB2_A76LegLicenIni[0] ;
         A591LegNomApe = P01CB2_A591LegNomApe[0] ;
         A93LegId = P01CB2_A93LegId[0] ;
         n93LegId = P01CB2_n93LegId[0] ;
         A591LegNomApe = P01CB2_A591LegNomApe[0] ;
         AV24count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P01CB2_A93LegId[0], A93LegId) == 0 ) )
         {
            brk1CB2 = false ;
            A6LegNumero = P01CB2_A6LegNumero[0] ;
            A3CliCod = P01CB2_A3CliCod[0] ;
            A1EmpCod = P01CB2_A1EmpCod[0] ;
            A76LegLicenIni = P01CB2_A76LegLicenIni[0] ;
            AV24count = (long)(AV24count+1) ;
            brk1CB2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A93LegId)==0) )
         {
            AV19Option = A93LegId ;
            AV20Options.add(AV19Option, 0);
            AV23OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV24count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV20Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1CB2 )
         {
            brk1CB2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADLEGNOMAPEOPTIONS' Routine */
      returnInSub = false ;
      AV43TFLegNomApe = AV31SearchTxt ;
      AV44TFLegNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV55Faltas_y_tardeswwds_1_sitliccuentatrab = AV46SitLicCuentaTrab ;
      AV56Faltas_y_tardeswwds_2_siteslicencia = AV47SitEsLicencia ;
      AV57Faltas_y_tardeswwds_3_tflegid = AV40TFLegId ;
      AV58Faltas_y_tardeswwds_4_tflegid_sels = AV41TFLegId_Sels ;
      AV59Faltas_y_tardeswwds_5_tflegnomape = AV43TFLegNomApe ;
      AV60Faltas_y_tardeswwds_6_tflegnomape_sels = AV44TFLegNomApe_Sels ;
      AV61Faltas_y_tardeswwds_7_tfleglicenini = AV11TFLegLicenIni ;
      AV62Faltas_y_tardeswwds_8_tfleglicenini_to = AV12TFLegLicenIni_To ;
      AV63Faltas_y_tardeswwds_9_tfleglicenfin = AV13TFLegLicenFin ;
      AV64Faltas_y_tardeswwds_10_tfleglicenfin_to = AV14TFLegLicenFin_To ;
      AV65Faltas_y_tardeswwds_11_tfleglicdescrip = AV16TFLegLicDescrip ;
      AV66Faltas_y_tardeswwds_12_tfleglicdescrip_sels = AV17TFLegLicDescrip_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A93LegId ,
                                           AV58Faltas_y_tardeswwds_4_tflegid_sels ,
                                           A591LegNomApe ,
                                           AV60Faltas_y_tardeswwds_6_tflegnomape_sels ,
                                           A914LegLicDescrip ,
                                           AV66Faltas_y_tardeswwds_12_tfleglicdescrip_sels ,
                                           Integer.valueOf(AV58Faltas_y_tardeswwds_4_tflegid_sels.size()) ,
                                           AV57Faltas_y_tardeswwds_3_tflegid ,
                                           Integer.valueOf(AV60Faltas_y_tardeswwds_6_tflegnomape_sels.size()) ,
                                           AV59Faltas_y_tardeswwds_5_tflegnomape ,
                                           AV61Faltas_y_tardeswwds_7_tfleglicenini ,
                                           AV62Faltas_y_tardeswwds_8_tfleglicenini_to ,
                                           AV63Faltas_y_tardeswwds_9_tfleglicenfin ,
                                           AV64Faltas_y_tardeswwds_10_tfleglicenfin_to ,
                                           Integer.valueOf(AV66Faltas_y_tardeswwds_12_tfleglicdescrip_sels.size()) ,
                                           AV65Faltas_y_tardeswwds_11_tfleglicdescrip ,
                                           A76LegLicenIni ,
                                           A481LegLicenFin ,
                                           Byte.valueOf(A1643LegSitCuenTrab) ,
                                           Byte.valueOf(A1287LegSitEsLic) ,
                                           Integer.valueOf(AV38CliCod) ,
                                           Short.valueOf(AV37EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV57Faltas_y_tardeswwds_3_tflegid = GXutil.padr( GXutil.rtrim( AV57Faltas_y_tardeswwds_3_tflegid), 20, "%") ;
      lV59Faltas_y_tardeswwds_5_tflegnomape = GXutil.concat( GXutil.rtrim( AV59Faltas_y_tardeswwds_5_tflegnomape), "%", "") ;
      lV65Faltas_y_tardeswwds_11_tfleglicdescrip = GXutil.concat( GXutil.rtrim( AV65Faltas_y_tardeswwds_11_tfleglicdescrip), "%", "") ;
      /* Using cursor P01CB3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV38CliCod), Short.valueOf(AV37EmpCod), lV57Faltas_y_tardeswwds_3_tflegid, lV59Faltas_y_tardeswwds_5_tflegnomape, AV61Faltas_y_tardeswwds_7_tfleglicenini, AV62Faltas_y_tardeswwds_8_tfleglicenini_to, AV63Faltas_y_tardeswwds_9_tfleglicenfin, AV64Faltas_y_tardeswwds_10_tfleglicenfin_to, lV65Faltas_y_tardeswwds_11_tfleglicdescrip});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A6LegNumero = P01CB3_A6LegNumero[0] ;
         A1EmpCod = P01CB3_A1EmpCod[0] ;
         A3CliCod = P01CB3_A3CliCod[0] ;
         A914LegLicDescrip = P01CB3_A914LegLicDescrip[0] ;
         A481LegLicenFin = P01CB3_A481LegLicenFin[0] ;
         A76LegLicenIni = P01CB3_A76LegLicenIni[0] ;
         A591LegNomApe = P01CB3_A591LegNomApe[0] ;
         A93LegId = P01CB3_A93LegId[0] ;
         n93LegId = P01CB3_n93LegId[0] ;
         A1287LegSitEsLic = P01CB3_A1287LegSitEsLic[0] ;
         A1643LegSitCuenTrab = P01CB3_A1643LegSitCuenTrab[0] ;
         A591LegNomApe = P01CB3_A591LegNomApe[0] ;
         A93LegId = P01CB3_A93LegId[0] ;
         n93LegId = P01CB3_n93LegId[0] ;
         if ( ! (GXutil.strcmp("", A591LegNomApe)==0) )
         {
            AV19Option = A591LegNomApe ;
            AV18InsertIndex = 1 ;
            while ( ( AV18InsertIndex <= AV20Options.size() ) && ( GXutil.strcmp((String)AV20Options.elementAt(-1+AV18InsertIndex), AV19Option) < 0 ) )
            {
               AV18InsertIndex = (int)(AV18InsertIndex+1) ;
            }
            if ( ( AV18InsertIndex <= AV20Options.size() ) && ( GXutil.strcmp((String)AV20Options.elementAt(-1+AV18InsertIndex), AV19Option) == 0 ) )
            {
               AV24count = GXutil.lval( (String)AV23OptionIndexes.elementAt(-1+AV18InsertIndex)) ;
               AV24count = (long)(AV24count+1) ;
               AV23OptionIndexes.removeItem(AV18InsertIndex);
               AV23OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV24count), "Z,ZZZ,ZZZ,ZZ9")), AV18InsertIndex);
            }
            else
            {
               AV20Options.add(AV19Option, AV18InsertIndex);
               AV23OptionIndexes.add("1", AV18InsertIndex);
            }
         }
         if ( AV20Options.size() == 50 )
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
      /* 'LOADLEGLICDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV16TFLegLicDescrip = AV31SearchTxt ;
      AV17TFLegLicDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV55Faltas_y_tardeswwds_1_sitliccuentatrab = AV46SitLicCuentaTrab ;
      AV56Faltas_y_tardeswwds_2_siteslicencia = AV47SitEsLicencia ;
      AV57Faltas_y_tardeswwds_3_tflegid = AV40TFLegId ;
      AV58Faltas_y_tardeswwds_4_tflegid_sels = AV41TFLegId_Sels ;
      AV59Faltas_y_tardeswwds_5_tflegnomape = AV43TFLegNomApe ;
      AV60Faltas_y_tardeswwds_6_tflegnomape_sels = AV44TFLegNomApe_Sels ;
      AV61Faltas_y_tardeswwds_7_tfleglicenini = AV11TFLegLicenIni ;
      AV62Faltas_y_tardeswwds_8_tfleglicenini_to = AV12TFLegLicenIni_To ;
      AV63Faltas_y_tardeswwds_9_tfleglicenfin = AV13TFLegLicenFin ;
      AV64Faltas_y_tardeswwds_10_tfleglicenfin_to = AV14TFLegLicenFin_To ;
      AV65Faltas_y_tardeswwds_11_tfleglicdescrip = AV16TFLegLicDescrip ;
      AV66Faltas_y_tardeswwds_12_tfleglicdescrip_sels = AV17TFLegLicDescrip_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A93LegId ,
                                           AV58Faltas_y_tardeswwds_4_tflegid_sels ,
                                           A591LegNomApe ,
                                           AV60Faltas_y_tardeswwds_6_tflegnomape_sels ,
                                           A914LegLicDescrip ,
                                           AV66Faltas_y_tardeswwds_12_tfleglicdescrip_sels ,
                                           Integer.valueOf(AV58Faltas_y_tardeswwds_4_tflegid_sels.size()) ,
                                           AV57Faltas_y_tardeswwds_3_tflegid ,
                                           Integer.valueOf(AV60Faltas_y_tardeswwds_6_tflegnomape_sels.size()) ,
                                           AV59Faltas_y_tardeswwds_5_tflegnomape ,
                                           AV61Faltas_y_tardeswwds_7_tfleglicenini ,
                                           AV62Faltas_y_tardeswwds_8_tfleglicenini_to ,
                                           AV63Faltas_y_tardeswwds_9_tfleglicenfin ,
                                           AV64Faltas_y_tardeswwds_10_tfleglicenfin_to ,
                                           Integer.valueOf(AV66Faltas_y_tardeswwds_12_tfleglicdescrip_sels.size()) ,
                                           AV65Faltas_y_tardeswwds_11_tfleglicdescrip ,
                                           A76LegLicenIni ,
                                           A481LegLicenFin ,
                                           Byte.valueOf(A1643LegSitCuenTrab) ,
                                           Byte.valueOf(A1287LegSitEsLic) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV38CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV37EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV57Faltas_y_tardeswwds_3_tflegid = GXutil.padr( GXutil.rtrim( AV57Faltas_y_tardeswwds_3_tflegid), 20, "%") ;
      lV59Faltas_y_tardeswwds_5_tflegnomape = GXutil.concat( GXutil.rtrim( AV59Faltas_y_tardeswwds_5_tflegnomape), "%", "") ;
      lV65Faltas_y_tardeswwds_11_tfleglicdescrip = GXutil.concat( GXutil.rtrim( AV65Faltas_y_tardeswwds_11_tfleglicdescrip), "%", "") ;
      /* Using cursor P01CB4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV38CliCod), Short.valueOf(AV37EmpCod), lV57Faltas_y_tardeswwds_3_tflegid, lV59Faltas_y_tardeswwds_5_tflegnomape, AV61Faltas_y_tardeswwds_7_tfleglicenini, AV62Faltas_y_tardeswwds_8_tfleglicenini_to, AV63Faltas_y_tardeswwds_9_tfleglicenfin, AV64Faltas_y_tardeswwds_10_tfleglicenfin_to, lV65Faltas_y_tardeswwds_11_tfleglicdescrip});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk1CB5 = false ;
         A6LegNumero = P01CB4_A6LegNumero[0] ;
         A1643LegSitCuenTrab = P01CB4_A1643LegSitCuenTrab[0] ;
         A1287LegSitEsLic = P01CB4_A1287LegSitEsLic[0] ;
         A3CliCod = P01CB4_A3CliCod[0] ;
         A1EmpCod = P01CB4_A1EmpCod[0] ;
         A914LegLicDescrip = P01CB4_A914LegLicDescrip[0] ;
         A481LegLicenFin = P01CB4_A481LegLicenFin[0] ;
         A76LegLicenIni = P01CB4_A76LegLicenIni[0] ;
         A591LegNomApe = P01CB4_A591LegNomApe[0] ;
         A93LegId = P01CB4_A93LegId[0] ;
         n93LegId = P01CB4_n93LegId[0] ;
         A591LegNomApe = P01CB4_A591LegNomApe[0] ;
         A93LegId = P01CB4_A93LegId[0] ;
         n93LegId = P01CB4_n93LegId[0] ;
         AV24count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P01CB4_A914LegLicDescrip[0], A914LegLicDescrip) == 0 ) )
         {
            brk1CB5 = false ;
            A6LegNumero = P01CB4_A6LegNumero[0] ;
            A3CliCod = P01CB4_A3CliCod[0] ;
            A1EmpCod = P01CB4_A1EmpCod[0] ;
            A76LegLicenIni = P01CB4_A76LegLicenIni[0] ;
            AV24count = (long)(AV24count+1) ;
            brk1CB5 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A914LegLicDescrip)==0) )
         {
            AV19Option = A914LegLicDescrip ;
            AV20Options.add(AV19Option, 0);
            AV23OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV24count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV20Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1CB5 )
         {
            brk1CB5 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = faltas_y_tardeswwgetfilterdata.this.AV33OptionsJson;
      this.aP4[0] = faltas_y_tardeswwgetfilterdata.this.AV34OptionsDescJson;
      this.aP5[0] = faltas_y_tardeswwgetfilterdata.this.AV35OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV33OptionsJson = "" ;
      AV34OptionsDescJson = "" ;
      AV35OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV20Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV22OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV23OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV25Session = httpContext.getWebSession();
      AV27GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV28GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV40TFLegId = "" ;
      AV39TFLegId_SelsJson = "" ;
      AV41TFLegId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43TFLegNomApe = "" ;
      AV42TFLegNomApe_SelsJson = "" ;
      AV44TFLegNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV11TFLegLicenIni = GXutil.nullDate() ;
      AV12TFLegLicenIni_To = GXutil.nullDate() ;
      AV13TFLegLicenFin = GXutil.nullDate() ;
      AV14TFLegLicenFin_To = GXutil.nullDate() ;
      AV16TFLegLicDescrip = "" ;
      AV15TFLegLicDescrip_SelsJson = "" ;
      AV17TFLegLicDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV50MenuOpcCod = "" ;
      A93LegId = "" ;
      AV57Faltas_y_tardeswwds_3_tflegid = "" ;
      AV58Faltas_y_tardeswwds_4_tflegid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV59Faltas_y_tardeswwds_5_tflegnomape = "" ;
      AV60Faltas_y_tardeswwds_6_tflegnomape_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV61Faltas_y_tardeswwds_7_tfleglicenini = GXutil.nullDate() ;
      AV62Faltas_y_tardeswwds_8_tfleglicenini_to = GXutil.nullDate() ;
      AV63Faltas_y_tardeswwds_9_tfleglicenfin = GXutil.nullDate() ;
      AV64Faltas_y_tardeswwds_10_tfleglicenfin_to = GXutil.nullDate() ;
      AV65Faltas_y_tardeswwds_11_tfleglicdescrip = "" ;
      AV66Faltas_y_tardeswwds_12_tfleglicdescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV57Faltas_y_tardeswwds_3_tflegid = "" ;
      lV59Faltas_y_tardeswwds_5_tflegnomape = "" ;
      lV65Faltas_y_tardeswwds_11_tfleglicdescrip = "" ;
      A591LegNomApe = "" ;
      A914LegLicDescrip = "" ;
      A76LegLicenIni = GXutil.nullDate() ;
      A481LegLicenFin = GXutil.nullDate() ;
      P01CB2_A6LegNumero = new int[1] ;
      P01CB2_A1643LegSitCuenTrab = new byte[1] ;
      P01CB2_A1287LegSitEsLic = new byte[1] ;
      P01CB2_A3CliCod = new int[1] ;
      P01CB2_A1EmpCod = new short[1] ;
      P01CB2_A93LegId = new String[] {""} ;
      P01CB2_n93LegId = new boolean[] {false} ;
      P01CB2_A914LegLicDescrip = new String[] {""} ;
      P01CB2_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      P01CB2_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      P01CB2_A591LegNomApe = new String[] {""} ;
      AV19Option = "" ;
      P01CB3_A6LegNumero = new int[1] ;
      P01CB3_A1EmpCod = new short[1] ;
      P01CB3_A3CliCod = new int[1] ;
      P01CB3_A914LegLicDescrip = new String[] {""} ;
      P01CB3_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      P01CB3_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      P01CB3_A591LegNomApe = new String[] {""} ;
      P01CB3_A93LegId = new String[] {""} ;
      P01CB3_n93LegId = new boolean[] {false} ;
      P01CB3_A1287LegSitEsLic = new byte[1] ;
      P01CB3_A1643LegSitCuenTrab = new byte[1] ;
      P01CB4_A6LegNumero = new int[1] ;
      P01CB4_A1643LegSitCuenTrab = new byte[1] ;
      P01CB4_A1287LegSitEsLic = new byte[1] ;
      P01CB4_A3CliCod = new int[1] ;
      P01CB4_A1EmpCod = new short[1] ;
      P01CB4_A914LegLicDescrip = new String[] {""} ;
      P01CB4_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      P01CB4_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      P01CB4_A591LegNomApe = new String[] {""} ;
      P01CB4_A93LegId = new String[] {""} ;
      P01CB4_n93LegId = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.faltas_y_tardeswwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01CB2_A6LegNumero, P01CB2_A1643LegSitCuenTrab, P01CB2_A1287LegSitEsLic, P01CB2_A3CliCod, P01CB2_A1EmpCod, P01CB2_A93LegId, P01CB2_n93LegId, P01CB2_A914LegLicDescrip, P01CB2_A481LegLicenFin, P01CB2_A76LegLicenIni,
            P01CB2_A591LegNomApe
            }
            , new Object[] {
            P01CB3_A6LegNumero, P01CB3_A1EmpCod, P01CB3_A3CliCod, P01CB3_A914LegLicDescrip, P01CB3_A481LegLicenFin, P01CB3_A76LegLicenIni, P01CB3_A591LegNomApe, P01CB3_A93LegId, P01CB3_n93LegId, P01CB3_A1287LegSitEsLic,
            P01CB3_A1643LegSitCuenTrab
            }
            , new Object[] {
            P01CB4_A6LegNumero, P01CB4_A1643LegSitCuenTrab, P01CB4_A1287LegSitEsLic, P01CB4_A3CliCod, P01CB4_A1EmpCod, P01CB4_A914LegLicDescrip, P01CB4_A481LegLicenFin, P01CB4_A76LegLicenIni, P01CB4_A591LegNomApe, P01CB4_A93LegId,
            P01CB4_n93LegId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A1643LegSitCuenTrab ;
   private byte A1287LegSitEsLic ;
   private short AV37EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV38CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV53GXV1 ;
   private int AV58Faltas_y_tardeswwds_4_tflegid_sels_size ;
   private int AV60Faltas_y_tardeswwds_6_tflegnomape_sels_size ;
   private int AV66Faltas_y_tardeswwds_12_tfleglicdescrip_sels_size ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int AV18InsertIndex ;
   private long AV24count ;
   private String AV40TFLegId ;
   private String A93LegId ;
   private String AV57Faltas_y_tardeswwds_3_tflegid ;
   private String scmdbuf ;
   private String lV57Faltas_y_tardeswwds_3_tflegid ;
   private java.util.Date AV11TFLegLicenIni ;
   private java.util.Date AV12TFLegLicenIni_To ;
   private java.util.Date AV13TFLegLicenFin ;
   private java.util.Date AV14TFLegLicenFin_To ;
   private java.util.Date AV61Faltas_y_tardeswwds_7_tfleglicenini ;
   private java.util.Date AV62Faltas_y_tardeswwds_8_tfleglicenini_to ;
   private java.util.Date AV63Faltas_y_tardeswwds_9_tfleglicenfin ;
   private java.util.Date AV64Faltas_y_tardeswwds_10_tfleglicenfin_to ;
   private java.util.Date A76LegLicenIni ;
   private java.util.Date A481LegLicenFin ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean AV46SitLicCuentaTrab ;
   private boolean AV47SitEsLicencia ;
   private boolean AV55Faltas_y_tardeswwds_1_sitliccuentatrab ;
   private boolean AV56Faltas_y_tardeswwds_2_siteslicencia ;
   private boolean brk1CB2 ;
   private boolean n93LegId ;
   private boolean brk1CB5 ;
   private String AV33OptionsJson ;
   private String AV34OptionsDescJson ;
   private String AV35OptionIndexesJson ;
   private String AV39TFLegId_SelsJson ;
   private String AV42TFLegNomApe_SelsJson ;
   private String AV15TFLegLicDescrip_SelsJson ;
   private String AV30DDOName ;
   private String AV31SearchTxt ;
   private String AV32SearchTxtTo ;
   private String AV43TFLegNomApe ;
   private String AV16TFLegLicDescrip ;
   private String AV50MenuOpcCod ;
   private String AV59Faltas_y_tardeswwds_5_tflegnomape ;
   private String AV65Faltas_y_tardeswwds_11_tfleglicdescrip ;
   private String lV59Faltas_y_tardeswwds_5_tflegnomape ;
   private String lV65Faltas_y_tardeswwds_11_tfleglicdescrip ;
   private String A591LegNomApe ;
   private String A914LegLicDescrip ;
   private String AV19Option ;
   private com.genexus.webpanels.WebSession AV25Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P01CB2_A6LegNumero ;
   private byte[] P01CB2_A1643LegSitCuenTrab ;
   private byte[] P01CB2_A1287LegSitEsLic ;
   private int[] P01CB2_A3CliCod ;
   private short[] P01CB2_A1EmpCod ;
   private String[] P01CB2_A93LegId ;
   private boolean[] P01CB2_n93LegId ;
   private String[] P01CB2_A914LegLicDescrip ;
   private java.util.Date[] P01CB2_A481LegLicenFin ;
   private java.util.Date[] P01CB2_A76LegLicenIni ;
   private String[] P01CB2_A591LegNomApe ;
   private int[] P01CB3_A6LegNumero ;
   private short[] P01CB3_A1EmpCod ;
   private int[] P01CB3_A3CliCod ;
   private String[] P01CB3_A914LegLicDescrip ;
   private java.util.Date[] P01CB3_A481LegLicenFin ;
   private java.util.Date[] P01CB3_A76LegLicenIni ;
   private String[] P01CB3_A591LegNomApe ;
   private String[] P01CB3_A93LegId ;
   private boolean[] P01CB3_n93LegId ;
   private byte[] P01CB3_A1287LegSitEsLic ;
   private byte[] P01CB3_A1643LegSitCuenTrab ;
   private int[] P01CB4_A6LegNumero ;
   private byte[] P01CB4_A1643LegSitCuenTrab ;
   private byte[] P01CB4_A1287LegSitEsLic ;
   private int[] P01CB4_A3CliCod ;
   private short[] P01CB4_A1EmpCod ;
   private String[] P01CB4_A914LegLicDescrip ;
   private java.util.Date[] P01CB4_A481LegLicenFin ;
   private java.util.Date[] P01CB4_A76LegLicenIni ;
   private String[] P01CB4_A591LegNomApe ;
   private String[] P01CB4_A93LegId ;
   private boolean[] P01CB4_n93LegId ;
   private GXSimpleCollection<String> AV41TFLegId_Sels ;
   private GXSimpleCollection<String> AV58Faltas_y_tardeswwds_4_tflegid_sels ;
   private GXSimpleCollection<String> AV20Options ;
   private GXSimpleCollection<String> AV22OptionsDesc ;
   private GXSimpleCollection<String> AV23OptionIndexes ;
   private GXSimpleCollection<String> AV44TFLegNomApe_Sels ;
   private GXSimpleCollection<String> AV17TFLegLicDescrip_Sels ;
   private GXSimpleCollection<String> AV60Faltas_y_tardeswwds_6_tflegnomape_sels ;
   private GXSimpleCollection<String> AV66Faltas_y_tardeswwds_12_tfleglicdescrip_sels ;
   private web.wwpbaseobjects.SdtWWPGridState AV27GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV28GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
}

final  class faltas_y_tardeswwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01CB2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A93LegId ,
                                          GXSimpleCollection<String> AV58Faltas_y_tardeswwds_4_tflegid_sels ,
                                          String A591LegNomApe ,
                                          GXSimpleCollection<String> AV60Faltas_y_tardeswwds_6_tflegnomape_sels ,
                                          String A914LegLicDescrip ,
                                          GXSimpleCollection<String> AV66Faltas_y_tardeswwds_12_tfleglicdescrip_sels ,
                                          int AV58Faltas_y_tardeswwds_4_tflegid_sels_size ,
                                          String AV57Faltas_y_tardeswwds_3_tflegid ,
                                          int AV60Faltas_y_tardeswwds_6_tflegnomape_sels_size ,
                                          String AV59Faltas_y_tardeswwds_5_tflegnomape ,
                                          java.util.Date AV61Faltas_y_tardeswwds_7_tfleglicenini ,
                                          java.util.Date AV62Faltas_y_tardeswwds_8_tfleglicenini_to ,
                                          java.util.Date AV63Faltas_y_tardeswwds_9_tfleglicenfin ,
                                          java.util.Date AV64Faltas_y_tardeswwds_10_tfleglicenfin_to ,
                                          int AV66Faltas_y_tardeswwds_12_tfleglicdescrip_sels_size ,
                                          String AV65Faltas_y_tardeswwds_11_tfleglicdescrip ,
                                          java.util.Date A76LegLicenIni ,
                                          java.util.Date A481LegLicenFin ,
                                          byte A1643LegSitCuenTrab ,
                                          byte A1287LegSitEsLic ,
                                          int A3CliCod ,
                                          int AV38CliCod ,
                                          short A1EmpCod ,
                                          short AV37EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[9];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T1.LegSitCuenTrab, T1.LegSitEsLic, T1.CliCod, T1.EmpCod, T2.LegId, T1.LegLicDescrip, T1.LegLicenFin, T1.LegLicenIni, T2.LegNomApe FROM (LegajoLicencias" ;
      scmdbuf += " T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero)" ;
      addWhere(sWhereString, "(T1.LegSitCuenTrab = 0)");
      addWhere(sWhereString, "(T1.LegSitEsLic = 0)");
      addWhere(sWhereString, "(T1.CliCod = ?)");
      addWhere(sWhereString, "(T1.EmpCod = ?)");
      if ( ( AV58Faltas_y_tardeswwds_4_tflegid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV57Faltas_y_tardeswwds_3_tflegid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegId) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV58Faltas_y_tardeswwds_4_tflegid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58Faltas_y_tardeswwds_4_tflegid_sels, "T2.LegId IN (", ")")+")");
      }
      if ( ( AV60Faltas_y_tardeswwds_6_tflegnomape_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV59Faltas_y_tardeswwds_5_tflegnomape)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV60Faltas_y_tardeswwds_6_tflegnomape_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV60Faltas_y_tardeswwds_6_tflegnomape_sels, "T2.LegNomApe IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV61Faltas_y_tardeswwds_7_tfleglicenini)) )
      {
         addWhere(sWhereString, "(T1.LegLicenIni >= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV62Faltas_y_tardeswwds_8_tfleglicenini_to)) )
      {
         addWhere(sWhereString, "(T1.LegLicenIni <= ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV63Faltas_y_tardeswwds_9_tfleglicenfin)) )
      {
         addWhere(sWhereString, "(T1.LegLicenFin >= ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV64Faltas_y_tardeswwds_10_tfleglicenfin_to)) )
      {
         addWhere(sWhereString, "(T1.LegLicenFin <= ?)");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( ( AV66Faltas_y_tardeswwds_12_tfleglicdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV65Faltas_y_tardeswwds_11_tfleglicdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LegLicDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[8] = (byte)(1) ;
      }
      if ( AV66Faltas_y_tardeswwds_12_tfleglicdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV66Faltas_y_tardeswwds_12_tfleglicdescrip_sels, "T1.LegLicDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T2.LegId" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P01CB3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A93LegId ,
                                          GXSimpleCollection<String> AV58Faltas_y_tardeswwds_4_tflegid_sels ,
                                          String A591LegNomApe ,
                                          GXSimpleCollection<String> AV60Faltas_y_tardeswwds_6_tflegnomape_sels ,
                                          String A914LegLicDescrip ,
                                          GXSimpleCollection<String> AV66Faltas_y_tardeswwds_12_tfleglicdescrip_sels ,
                                          int AV58Faltas_y_tardeswwds_4_tflegid_sels_size ,
                                          String AV57Faltas_y_tardeswwds_3_tflegid ,
                                          int AV60Faltas_y_tardeswwds_6_tflegnomape_sels_size ,
                                          String AV59Faltas_y_tardeswwds_5_tflegnomape ,
                                          java.util.Date AV61Faltas_y_tardeswwds_7_tfleglicenini ,
                                          java.util.Date AV62Faltas_y_tardeswwds_8_tfleglicenini_to ,
                                          java.util.Date AV63Faltas_y_tardeswwds_9_tfleglicenfin ,
                                          java.util.Date AV64Faltas_y_tardeswwds_10_tfleglicenfin_to ,
                                          int AV66Faltas_y_tardeswwds_12_tfleglicdescrip_sels_size ,
                                          String AV65Faltas_y_tardeswwds_11_tfleglicdescrip ,
                                          java.util.Date A76LegLicenIni ,
                                          java.util.Date A481LegLicenFin ,
                                          byte A1643LegSitCuenTrab ,
                                          byte A1287LegSitEsLic ,
                                          int AV38CliCod ,
                                          short AV37EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[9];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T1.EmpCod, T1.CliCod, T1.LegLicDescrip, T1.LegLicenFin, T1.LegLicenIni, T2.LegNomApe, T2.LegId, T1.LegSitEsLic, T1.LegSitCuenTrab FROM (LegajoLicencias" ;
      scmdbuf += " T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      addWhere(sWhereString, "(T1.LegSitCuenTrab = 0)");
      addWhere(sWhereString, "(T1.LegSitEsLic = 0)");
      if ( ( AV58Faltas_y_tardeswwds_4_tflegid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV57Faltas_y_tardeswwds_3_tflegid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegId) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV58Faltas_y_tardeswwds_4_tflegid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58Faltas_y_tardeswwds_4_tflegid_sels, "T2.LegId IN (", ")")+")");
      }
      if ( ( AV60Faltas_y_tardeswwds_6_tflegnomape_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV59Faltas_y_tardeswwds_5_tflegnomape)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV60Faltas_y_tardeswwds_6_tflegnomape_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV60Faltas_y_tardeswwds_6_tflegnomape_sels, "T2.LegNomApe IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV61Faltas_y_tardeswwds_7_tfleglicenini)) )
      {
         addWhere(sWhereString, "(T1.LegLicenIni >= ?)");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV62Faltas_y_tardeswwds_8_tfleglicenini_to)) )
      {
         addWhere(sWhereString, "(T1.LegLicenIni <= ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV63Faltas_y_tardeswwds_9_tfleglicenfin)) )
      {
         addWhere(sWhereString, "(T1.LegLicenFin >= ?)");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV64Faltas_y_tardeswwds_10_tfleglicenfin_to)) )
      {
         addWhere(sWhereString, "(T1.LegLicenFin <= ?)");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( ( AV66Faltas_y_tardeswwds_12_tfleglicdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV65Faltas_y_tardeswwds_11_tfleglicdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LegLicDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[8] = (byte)(1) ;
      }
      if ( AV66Faltas_y_tardeswwds_12_tfleglicdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV66Faltas_y_tardeswwds_12_tfleglicdescrip_sels, "T1.LegLicDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P01CB4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A93LegId ,
                                          GXSimpleCollection<String> AV58Faltas_y_tardeswwds_4_tflegid_sels ,
                                          String A591LegNomApe ,
                                          GXSimpleCollection<String> AV60Faltas_y_tardeswwds_6_tflegnomape_sels ,
                                          String A914LegLicDescrip ,
                                          GXSimpleCollection<String> AV66Faltas_y_tardeswwds_12_tfleglicdescrip_sels ,
                                          int AV58Faltas_y_tardeswwds_4_tflegid_sels_size ,
                                          String AV57Faltas_y_tardeswwds_3_tflegid ,
                                          int AV60Faltas_y_tardeswwds_6_tflegnomape_sels_size ,
                                          String AV59Faltas_y_tardeswwds_5_tflegnomape ,
                                          java.util.Date AV61Faltas_y_tardeswwds_7_tfleglicenini ,
                                          java.util.Date AV62Faltas_y_tardeswwds_8_tfleglicenini_to ,
                                          java.util.Date AV63Faltas_y_tardeswwds_9_tfleglicenfin ,
                                          java.util.Date AV64Faltas_y_tardeswwds_10_tfleglicenfin_to ,
                                          int AV66Faltas_y_tardeswwds_12_tfleglicdescrip_sels_size ,
                                          String AV65Faltas_y_tardeswwds_11_tfleglicdescrip ,
                                          java.util.Date A76LegLicenIni ,
                                          java.util.Date A481LegLicenFin ,
                                          byte A1643LegSitCuenTrab ,
                                          byte A1287LegSitEsLic ,
                                          int A3CliCod ,
                                          int AV38CliCod ,
                                          short A1EmpCod ,
                                          short AV37EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[9];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T1.LegSitCuenTrab, T1.LegSitEsLic, T1.CliCod, T1.EmpCod, T1.LegLicDescrip, T1.LegLicenFin, T1.LegLicenIni, T2.LegNomApe, T2.LegId FROM (LegajoLicencias" ;
      scmdbuf += " T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero)" ;
      addWhere(sWhereString, "(T1.LegSitCuenTrab = 0)");
      addWhere(sWhereString, "(T1.LegSitEsLic = 0)");
      addWhere(sWhereString, "(T1.CliCod = ?)");
      addWhere(sWhereString, "(T1.EmpCod = ?)");
      if ( ( AV58Faltas_y_tardeswwds_4_tflegid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV57Faltas_y_tardeswwds_3_tflegid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegId) like LOWER(?))");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( AV58Faltas_y_tardeswwds_4_tflegid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58Faltas_y_tardeswwds_4_tflegid_sels, "T2.LegId IN (", ")")+")");
      }
      if ( ( AV60Faltas_y_tardeswwds_6_tflegnomape_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV59Faltas_y_tardeswwds_5_tflegnomape)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( AV60Faltas_y_tardeswwds_6_tflegnomape_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV60Faltas_y_tardeswwds_6_tflegnomape_sels, "T2.LegNomApe IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV61Faltas_y_tardeswwds_7_tfleglicenini)) )
      {
         addWhere(sWhereString, "(T1.LegLicenIni >= ?)");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV62Faltas_y_tardeswwds_8_tfleglicenini_to)) )
      {
         addWhere(sWhereString, "(T1.LegLicenIni <= ?)");
      }
      else
      {
         GXv_int14[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV63Faltas_y_tardeswwds_9_tfleglicenfin)) )
      {
         addWhere(sWhereString, "(T1.LegLicenFin >= ?)");
      }
      else
      {
         GXv_int14[6] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV64Faltas_y_tardeswwds_10_tfleglicenfin_to)) )
      {
         addWhere(sWhereString, "(T1.LegLicenFin <= ?)");
      }
      else
      {
         GXv_int14[7] = (byte)(1) ;
      }
      if ( ( AV66Faltas_y_tardeswwds_12_tfleglicdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV65Faltas_y_tardeswwds_11_tfleglicdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LegLicDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int14[8] = (byte)(1) ;
      }
      if ( AV66Faltas_y_tardeswwds_12_tfleglicdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV66Faltas_y_tardeswwds_12_tfleglicdescrip_sels, "T1.LegLicDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.LegLicDescrip" ;
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
                  return conditional_P01CB2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , (java.util.Date)dynConstraints[10] , (java.util.Date)dynConstraints[11] , (java.util.Date)dynConstraints[12] , (java.util.Date)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , (java.util.Date)dynConstraints[16] , (java.util.Date)dynConstraints[17] , ((Number) dynConstraints[18]).byteValue() , ((Number) dynConstraints[19]).byteValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).shortValue() , ((Number) dynConstraints[23]).shortValue() );
            case 1 :
                  return conditional_P01CB3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , (java.util.Date)dynConstraints[10] , (java.util.Date)dynConstraints[11] , (java.util.Date)dynConstraints[12] , (java.util.Date)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , (java.util.Date)dynConstraints[16] , (java.util.Date)dynConstraints[17] , ((Number) dynConstraints[18]).byteValue() , ((Number) dynConstraints[19]).byteValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).shortValue() , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).shortValue() );
            case 2 :
                  return conditional_P01CB4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , (java.util.Date)dynConstraints[10] , (java.util.Date)dynConstraints[11] , (java.util.Date)dynConstraints[12] , (java.util.Date)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , (java.util.Date)dynConstraints[16] , (java.util.Date)dynConstraints[17] , ((Number) dynConstraints[18]).byteValue() , ((Number) dynConstraints[19]).byteValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).shortValue() , ((Number) dynConstraints[23]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01CB2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01CB3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01CB4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(8);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(9);
               ((String[]) buf[10])[0] = rslt.getVarchar(10);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((byte[]) buf[9])[0] = rslt.getByte(9);
               ((byte[]) buf[10])[0] = rslt.getByte(10);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 20);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
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
                  stmt.setShort(sIdx, ((Number) parms[10]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[13]);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[14]);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[15]);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[16]);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
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
                  stmt.setShort(sIdx, ((Number) parms[10]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[13]);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[14]);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[15]);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[16]);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
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
                  stmt.setShort(sIdx, ((Number) parms[10]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[13]);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[14]);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[15]);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[16]);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               return;
      }
   }

}

