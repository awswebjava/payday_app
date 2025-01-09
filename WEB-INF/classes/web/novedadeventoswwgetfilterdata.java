package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class novedadeventoswwgetfilterdata extends GXProcedure
{
   public novedadeventoswwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( novedadeventoswwgetfilterdata.class ), "" );
   }

   public novedadeventoswwgetfilterdata( int remoteHandle ,
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
      novedadeventoswwgetfilterdata.this.aP5 = new String[] {""};
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
      novedadeventoswwgetfilterdata.this.AV30DDOName = aP0;
      novedadeventoswwgetfilterdata.this.AV31SearchTxt = aP1;
      novedadeventoswwgetfilterdata.this.AV32SearchTxtTo = aP2;
      novedadeventoswwgetfilterdata.this.aP3 = aP3;
      novedadeventoswwgetfilterdata.this.aP4 = aP4;
      novedadeventoswwgetfilterdata.this.aP5 = aP5;
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
      novedadeventoswwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV37EmpCod = GXt_int1 ;
      GXt_int3 = AV38CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      novedadeventoswwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV38CliCod = GXt_int3 ;
      AV20Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV22OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV23OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWNovedadEventos", GXv_boolean6) ;
      novedadeventoswwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV30DDOName), "DDO_LEGNOMAPE") == 0 )
         {
            /* Execute user subroutine: 'LOADLEGNOMAPEOPTIONS' */
            S121 ();
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
            S131 ();
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
      if ( GXutil.strcmp(AV25Session.getValue("NovedadEventosWWGridState"), "") == 0 )
      {
         AV27GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "NovedadEventosWWGridState"), null, null);
      }
      else
      {
         AV27GridState.fromxml(AV25Session.getValue("NovedadEventosWWGridState"), null, null);
      }
      AV52GXV1 = 1 ;
      while ( AV52GXV1 <= AV27GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV28GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV27GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV52GXV1));
         if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "SITESLICENCIA") == 0 )
         {
            AV46SitEsLicencia = GXutil.boolval( AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
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
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGLICESTADO_SEL") == 0 )
         {
            AV47TFLegLicEstado_SelsJson = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV48TFLegLicEstado_Sels.fromJSonString(AV47TFLegLicEstado_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGLICCONPLUS_SEL") == 0 )
         {
            AV45TFLegLicConPlus_Sel = (byte)(GXutil.lval( AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV49MenuOpcCod = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV52GXV1 = (int)(AV52GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADLEGNOMAPEOPTIONS' Routine */
      returnInSub = false ;
      AV43TFLegNomApe = AV31SearchTxt ;
      AV44TFLegNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV54Novedadeventoswwds_1_siteslicencia = AV46SitEsLicencia ;
      AV55Novedadeventoswwds_2_tflegnomape = AV43TFLegNomApe ;
      AV56Novedadeventoswwds_3_tflegnomape_sels = AV44TFLegNomApe_Sels ;
      AV57Novedadeventoswwds_4_tfleglicenini = AV11TFLegLicenIni ;
      AV58Novedadeventoswwds_5_tfleglicenini_to = AV12TFLegLicenIni_To ;
      AV59Novedadeventoswwds_6_tfleglicenfin = AV13TFLegLicenFin ;
      AV60Novedadeventoswwds_7_tfleglicenfin_to = AV14TFLegLicenFin_To ;
      AV61Novedadeventoswwds_8_tfleglicdescrip = AV16TFLegLicDescrip ;
      AV62Novedadeventoswwds_9_tfleglicdescrip_sels = AV17TFLegLicDescrip_Sels ;
      AV63Novedadeventoswwds_10_tfleglicestado_sels = AV48TFLegLicEstado_Sels ;
      AV64Novedadeventoswwds_11_tfleglicconplus_sel = AV45TFLegLicConPlus_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A591LegNomApe ,
                                           AV56Novedadeventoswwds_3_tflegnomape_sels ,
                                           A914LegLicDescrip ,
                                           AV62Novedadeventoswwds_9_tfleglicdescrip_sels ,
                                           A1497LegLicEstado ,
                                           AV63Novedadeventoswwds_10_tfleglicestado_sels ,
                                           Integer.valueOf(AV56Novedadeventoswwds_3_tflegnomape_sels.size()) ,
                                           AV55Novedadeventoswwds_2_tflegnomape ,
                                           AV57Novedadeventoswwds_4_tfleglicenini ,
                                           AV58Novedadeventoswwds_5_tfleglicenini_to ,
                                           AV59Novedadeventoswwds_6_tfleglicenfin ,
                                           AV60Novedadeventoswwds_7_tfleglicenfin_to ,
                                           Integer.valueOf(AV62Novedadeventoswwds_9_tfleglicdescrip_sels.size()) ,
                                           AV61Novedadeventoswwds_8_tfleglicdescrip ,
                                           Integer.valueOf(AV63Novedadeventoswwds_10_tfleglicestado_sels.size()) ,
                                           Byte.valueOf(AV64Novedadeventoswwds_11_tfleglicconplus_sel) ,
                                           A76LegLicenIni ,
                                           A481LegLicenFin ,
                                           Boolean.valueOf(A1218LegLicConPlus) ,
                                           Boolean.valueOf(A738SitEsLicencia) ,
                                           Integer.valueOf(AV38CliCod) ,
                                           Short.valueOf(AV37EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV55Novedadeventoswwds_2_tflegnomape = GXutil.concat( GXutil.rtrim( AV55Novedadeventoswwds_2_tflegnomape), "%", "") ;
      lV61Novedadeventoswwds_8_tfleglicdescrip = GXutil.concat( GXutil.rtrim( AV61Novedadeventoswwds_8_tfleglicdescrip), "%", "") ;
      /* Using cursor P013R2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV38CliCod), Short.valueOf(AV37EmpCod), lV55Novedadeventoswwds_2_tflegnomape, AV57Novedadeventoswwds_4_tfleglicenini, AV58Novedadeventoswwds_5_tfleglicenini_to, AV59Novedadeventoswwds_6_tfleglicenfin, AV60Novedadeventoswwds_7_tfleglicenfin_to, lV61Novedadeventoswwds_8_tfleglicdescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P013R2_A6LegNumero[0] ;
         A506LegLicSitCodigo = P013R2_A506LegLicSitCodigo[0] ;
         A1EmpCod = P013R2_A1EmpCod[0] ;
         A3CliCod = P013R2_A3CliCod[0] ;
         A1218LegLicConPlus = P013R2_A1218LegLicConPlus[0] ;
         A1497LegLicEstado = P013R2_A1497LegLicEstado[0] ;
         A914LegLicDescrip = P013R2_A914LegLicDescrip[0] ;
         A481LegLicenFin = P013R2_A481LegLicenFin[0] ;
         A76LegLicenIni = P013R2_A76LegLicenIni[0] ;
         A591LegNomApe = P013R2_A591LegNomApe[0] ;
         A738SitEsLicencia = P013R2_A738SitEsLicencia[0] ;
         n738SitEsLicencia = P013R2_n738SitEsLicencia[0] ;
         A738SitEsLicencia = P013R2_A738SitEsLicencia[0] ;
         n738SitEsLicencia = P013R2_n738SitEsLicencia[0] ;
         A591LegNomApe = P013R2_A591LegNomApe[0] ;
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
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADLEGLICDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV16TFLegLicDescrip = AV31SearchTxt ;
      AV17TFLegLicDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV54Novedadeventoswwds_1_siteslicencia = AV46SitEsLicencia ;
      AV55Novedadeventoswwds_2_tflegnomape = AV43TFLegNomApe ;
      AV56Novedadeventoswwds_3_tflegnomape_sels = AV44TFLegNomApe_Sels ;
      AV57Novedadeventoswwds_4_tfleglicenini = AV11TFLegLicenIni ;
      AV58Novedadeventoswwds_5_tfleglicenini_to = AV12TFLegLicenIni_To ;
      AV59Novedadeventoswwds_6_tfleglicenfin = AV13TFLegLicenFin ;
      AV60Novedadeventoswwds_7_tfleglicenfin_to = AV14TFLegLicenFin_To ;
      AV61Novedadeventoswwds_8_tfleglicdescrip = AV16TFLegLicDescrip ;
      AV62Novedadeventoswwds_9_tfleglicdescrip_sels = AV17TFLegLicDescrip_Sels ;
      AV63Novedadeventoswwds_10_tfleglicestado_sels = AV48TFLegLicEstado_Sels ;
      AV64Novedadeventoswwds_11_tfleglicconplus_sel = AV45TFLegLicConPlus_Sel ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A591LegNomApe ,
                                           AV56Novedadeventoswwds_3_tflegnomape_sels ,
                                           A914LegLicDescrip ,
                                           AV62Novedadeventoswwds_9_tfleglicdescrip_sels ,
                                           A1497LegLicEstado ,
                                           AV63Novedadeventoswwds_10_tfleglicestado_sels ,
                                           Integer.valueOf(AV56Novedadeventoswwds_3_tflegnomape_sels.size()) ,
                                           AV55Novedadeventoswwds_2_tflegnomape ,
                                           AV57Novedadeventoswwds_4_tfleglicenini ,
                                           AV58Novedadeventoswwds_5_tfleglicenini_to ,
                                           AV59Novedadeventoswwds_6_tfleglicenfin ,
                                           AV60Novedadeventoswwds_7_tfleglicenfin_to ,
                                           Integer.valueOf(AV62Novedadeventoswwds_9_tfleglicdescrip_sels.size()) ,
                                           AV61Novedadeventoswwds_8_tfleglicdescrip ,
                                           Integer.valueOf(AV63Novedadeventoswwds_10_tfleglicestado_sels.size()) ,
                                           Byte.valueOf(AV64Novedadeventoswwds_11_tfleglicconplus_sel) ,
                                           A76LegLicenIni ,
                                           A481LegLicenFin ,
                                           Boolean.valueOf(A1218LegLicConPlus) ,
                                           Boolean.valueOf(A738SitEsLicencia) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV38CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV37EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV55Novedadeventoswwds_2_tflegnomape = GXutil.concat( GXutil.rtrim( AV55Novedadeventoswwds_2_tflegnomape), "%", "") ;
      lV61Novedadeventoswwds_8_tfleglicdescrip = GXutil.concat( GXutil.rtrim( AV61Novedadeventoswwds_8_tfleglicdescrip), "%", "") ;
      /* Using cursor P013R3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV38CliCod), Short.valueOf(AV37EmpCod), lV55Novedadeventoswwds_2_tflegnomape, AV57Novedadeventoswwds_4_tfleglicenini, AV58Novedadeventoswwds_5_tfleglicenini_to, AV59Novedadeventoswwds_6_tfleglicenfin, AV60Novedadeventoswwds_7_tfleglicenfin_to, lV61Novedadeventoswwds_8_tfleglicdescrip});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk13R3 = false ;
         A6LegNumero = P013R3_A6LegNumero[0] ;
         A506LegLicSitCodigo = P013R3_A506LegLicSitCodigo[0] ;
         A738SitEsLicencia = P013R3_A738SitEsLicencia[0] ;
         n738SitEsLicencia = P013R3_n738SitEsLicencia[0] ;
         A3CliCod = P013R3_A3CliCod[0] ;
         A1EmpCod = P013R3_A1EmpCod[0] ;
         A914LegLicDescrip = P013R3_A914LegLicDescrip[0] ;
         A1218LegLicConPlus = P013R3_A1218LegLicConPlus[0] ;
         A1497LegLicEstado = P013R3_A1497LegLicEstado[0] ;
         A481LegLicenFin = P013R3_A481LegLicenFin[0] ;
         A76LegLicenIni = P013R3_A76LegLicenIni[0] ;
         A591LegNomApe = P013R3_A591LegNomApe[0] ;
         A738SitEsLicencia = P013R3_A738SitEsLicencia[0] ;
         n738SitEsLicencia = P013R3_n738SitEsLicencia[0] ;
         A591LegNomApe = P013R3_A591LegNomApe[0] ;
         AV24count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P013R3_A914LegLicDescrip[0], A914LegLicDescrip) == 0 ) )
         {
            brk13R3 = false ;
            A6LegNumero = P013R3_A6LegNumero[0] ;
            A3CliCod = P013R3_A3CliCod[0] ;
            A1EmpCod = P013R3_A1EmpCod[0] ;
            A76LegLicenIni = P013R3_A76LegLicenIni[0] ;
            AV24count = (long)(AV24count+1) ;
            brk13R3 = true ;
            pr_default.readNext(1);
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
         if ( ! brk13R3 )
         {
            brk13R3 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = novedadeventoswwgetfilterdata.this.AV33OptionsJson;
      this.aP4[0] = novedadeventoswwgetfilterdata.this.AV34OptionsDescJson;
      this.aP5[0] = novedadeventoswwgetfilterdata.this.AV35OptionIndexesJson;
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
      AV47TFLegLicEstado_SelsJson = "" ;
      AV48TFLegLicEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV49MenuOpcCod = "" ;
      A591LegNomApe = "" ;
      AV55Novedadeventoswwds_2_tflegnomape = "" ;
      AV56Novedadeventoswwds_3_tflegnomape_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV57Novedadeventoswwds_4_tfleglicenini = GXutil.nullDate() ;
      AV58Novedadeventoswwds_5_tfleglicenini_to = GXutil.nullDate() ;
      AV59Novedadeventoswwds_6_tfleglicenfin = GXutil.nullDate() ;
      AV60Novedadeventoswwds_7_tfleglicenfin_to = GXutil.nullDate() ;
      AV61Novedadeventoswwds_8_tfleglicdescrip = "" ;
      AV62Novedadeventoswwds_9_tfleglicdescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV63Novedadeventoswwds_10_tfleglicestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV55Novedadeventoswwds_2_tflegnomape = "" ;
      lV61Novedadeventoswwds_8_tfleglicdescrip = "" ;
      A914LegLicDescrip = "" ;
      A1497LegLicEstado = "" ;
      A76LegLicenIni = GXutil.nullDate() ;
      A481LegLicenFin = GXutil.nullDate() ;
      P013R2_A6LegNumero = new int[1] ;
      P013R2_A506LegLicSitCodigo = new String[] {""} ;
      P013R2_A1EmpCod = new short[1] ;
      P013R2_A3CliCod = new int[1] ;
      P013R2_A1218LegLicConPlus = new boolean[] {false} ;
      P013R2_A1497LegLicEstado = new String[] {""} ;
      P013R2_A914LegLicDescrip = new String[] {""} ;
      P013R2_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      P013R2_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      P013R2_A591LegNomApe = new String[] {""} ;
      P013R2_A738SitEsLicencia = new boolean[] {false} ;
      P013R2_n738SitEsLicencia = new boolean[] {false} ;
      A506LegLicSitCodigo = "" ;
      AV19Option = "" ;
      P013R3_A6LegNumero = new int[1] ;
      P013R3_A506LegLicSitCodigo = new String[] {""} ;
      P013R3_A738SitEsLicencia = new boolean[] {false} ;
      P013R3_n738SitEsLicencia = new boolean[] {false} ;
      P013R3_A3CliCod = new int[1] ;
      P013R3_A1EmpCod = new short[1] ;
      P013R3_A914LegLicDescrip = new String[] {""} ;
      P013R3_A1218LegLicConPlus = new boolean[] {false} ;
      P013R3_A1497LegLicEstado = new String[] {""} ;
      P013R3_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      P013R3_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      P013R3_A591LegNomApe = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.novedadeventoswwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P013R2_A6LegNumero, P013R2_A506LegLicSitCodigo, P013R2_A1EmpCod, P013R2_A3CliCod, P013R2_A1218LegLicConPlus, P013R2_A1497LegLicEstado, P013R2_A914LegLicDescrip, P013R2_A481LegLicenFin, P013R2_A76LegLicenIni, P013R2_A591LegNomApe,
            P013R2_A738SitEsLicencia, P013R2_n738SitEsLicencia
            }
            , new Object[] {
            P013R3_A6LegNumero, P013R3_A506LegLicSitCodigo, P013R3_A738SitEsLicencia, P013R3_n738SitEsLicencia, P013R3_A3CliCod, P013R3_A1EmpCod, P013R3_A914LegLicDescrip, P013R3_A1218LegLicConPlus, P013R3_A1497LegLicEstado, P013R3_A481LegLicenFin,
            P013R3_A76LegLicenIni, P013R3_A591LegNomApe
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV45TFLegLicConPlus_Sel ;
   private byte AV64Novedadeventoswwds_11_tfleglicconplus_sel ;
   private short AV37EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV38CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV52GXV1 ;
   private int AV56Novedadeventoswwds_3_tflegnomape_sels_size ;
   private int AV62Novedadeventoswwds_9_tfleglicdescrip_sels_size ;
   private int AV63Novedadeventoswwds_10_tfleglicestado_sels_size ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int AV18InsertIndex ;
   private long AV24count ;
   private String scmdbuf ;
   private String A1497LegLicEstado ;
   private String A506LegLicSitCodigo ;
   private java.util.Date AV11TFLegLicenIni ;
   private java.util.Date AV12TFLegLicenIni_To ;
   private java.util.Date AV13TFLegLicenFin ;
   private java.util.Date AV14TFLegLicenFin_To ;
   private java.util.Date AV57Novedadeventoswwds_4_tfleglicenini ;
   private java.util.Date AV58Novedadeventoswwds_5_tfleglicenini_to ;
   private java.util.Date AV59Novedadeventoswwds_6_tfleglicenfin ;
   private java.util.Date AV60Novedadeventoswwds_7_tfleglicenfin_to ;
   private java.util.Date A76LegLicenIni ;
   private java.util.Date A481LegLicenFin ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean AV46SitEsLicencia ;
   private boolean AV54Novedadeventoswwds_1_siteslicencia ;
   private boolean A1218LegLicConPlus ;
   private boolean A738SitEsLicencia ;
   private boolean n738SitEsLicencia ;
   private boolean brk13R3 ;
   private String AV33OptionsJson ;
   private String AV34OptionsDescJson ;
   private String AV35OptionIndexesJson ;
   private String AV42TFLegNomApe_SelsJson ;
   private String AV15TFLegLicDescrip_SelsJson ;
   private String AV47TFLegLicEstado_SelsJson ;
   private String AV30DDOName ;
   private String AV31SearchTxt ;
   private String AV32SearchTxtTo ;
   private String AV43TFLegNomApe ;
   private String AV16TFLegLicDescrip ;
   private String AV49MenuOpcCod ;
   private String A591LegNomApe ;
   private String AV55Novedadeventoswwds_2_tflegnomape ;
   private String AV61Novedadeventoswwds_8_tfleglicdescrip ;
   private String lV55Novedadeventoswwds_2_tflegnomape ;
   private String lV61Novedadeventoswwds_8_tfleglicdescrip ;
   private String A914LegLicDescrip ;
   private String AV19Option ;
   private com.genexus.webpanels.WebSession AV25Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P013R2_A6LegNumero ;
   private String[] P013R2_A506LegLicSitCodigo ;
   private short[] P013R2_A1EmpCod ;
   private int[] P013R2_A3CliCod ;
   private boolean[] P013R2_A1218LegLicConPlus ;
   private String[] P013R2_A1497LegLicEstado ;
   private String[] P013R2_A914LegLicDescrip ;
   private java.util.Date[] P013R2_A481LegLicenFin ;
   private java.util.Date[] P013R2_A76LegLicenIni ;
   private String[] P013R2_A591LegNomApe ;
   private boolean[] P013R2_A738SitEsLicencia ;
   private boolean[] P013R2_n738SitEsLicencia ;
   private int[] P013R3_A6LegNumero ;
   private String[] P013R3_A506LegLicSitCodigo ;
   private boolean[] P013R3_A738SitEsLicencia ;
   private boolean[] P013R3_n738SitEsLicencia ;
   private int[] P013R3_A3CliCod ;
   private short[] P013R3_A1EmpCod ;
   private String[] P013R3_A914LegLicDescrip ;
   private boolean[] P013R3_A1218LegLicConPlus ;
   private String[] P013R3_A1497LegLicEstado ;
   private java.util.Date[] P013R3_A481LegLicenFin ;
   private java.util.Date[] P013R3_A76LegLicenIni ;
   private String[] P013R3_A591LegNomApe ;
   private GXSimpleCollection<String> AV48TFLegLicEstado_Sels ;
   private GXSimpleCollection<String> AV63Novedadeventoswwds_10_tfleglicestado_sels ;
   private GXSimpleCollection<String> AV20Options ;
   private GXSimpleCollection<String> AV22OptionsDesc ;
   private GXSimpleCollection<String> AV23OptionIndexes ;
   private GXSimpleCollection<String> AV44TFLegNomApe_Sels ;
   private GXSimpleCollection<String> AV17TFLegLicDescrip_Sels ;
   private GXSimpleCollection<String> AV56Novedadeventoswwds_3_tflegnomape_sels ;
   private GXSimpleCollection<String> AV62Novedadeventoswwds_9_tfleglicdescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV27GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV28GridStateFilterValue ;
}

final  class novedadeventoswwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P013R2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A591LegNomApe ,
                                          GXSimpleCollection<String> AV56Novedadeventoswwds_3_tflegnomape_sels ,
                                          String A914LegLicDescrip ,
                                          GXSimpleCollection<String> AV62Novedadeventoswwds_9_tfleglicdescrip_sels ,
                                          String A1497LegLicEstado ,
                                          GXSimpleCollection<String> AV63Novedadeventoswwds_10_tfleglicestado_sels ,
                                          int AV56Novedadeventoswwds_3_tflegnomape_sels_size ,
                                          String AV55Novedadeventoswwds_2_tflegnomape ,
                                          java.util.Date AV57Novedadeventoswwds_4_tfleglicenini ,
                                          java.util.Date AV58Novedadeventoswwds_5_tfleglicenini_to ,
                                          java.util.Date AV59Novedadeventoswwds_6_tfleglicenfin ,
                                          java.util.Date AV60Novedadeventoswwds_7_tfleglicenfin_to ,
                                          int AV62Novedadeventoswwds_9_tfleglicdescrip_sels_size ,
                                          String AV61Novedadeventoswwds_8_tfleglicdescrip ,
                                          int AV63Novedadeventoswwds_10_tfleglicestado_sels_size ,
                                          byte AV64Novedadeventoswwds_11_tfleglicconplus_sel ,
                                          java.util.Date A76LegLicenIni ,
                                          java.util.Date A481LegLicenFin ,
                                          boolean A1218LegLicConPlus ,
                                          boolean A738SitEsLicencia ,
                                          int AV38CliCod ,
                                          short AV37EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[8];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T1.LegLicSitCodigo AS LegLicSitCodigo, T1.EmpCod, T1.CliCod, T1.LegLicConPlus, T1.LegLicEstado, T1.LegLicDescrip, T1.LegLicenFin, T1.LegLicenIni," ;
      scmdbuf += " T3.LegNomApe, T2.SitEsLicencia FROM ((LegajoLicencias T1 INNER JOIN Estado T2 ON T2.SitCodigo = T1.LegLicSitCodigo) INNER JOIN Legajo T3 ON T3.CliCod = T1.CliCod" ;
      scmdbuf += " AND T3.EmpCod = T1.EmpCod AND T3.LegNumero = T1.LegNumero)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      addWhere(sWhereString, "(T2.SitEsLicencia = TRUE)");
      if ( ( AV56Novedadeventoswwds_3_tflegnomape_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55Novedadeventoswwds_2_tflegnomape)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV56Novedadeventoswwds_3_tflegnomape_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56Novedadeventoswwds_3_tflegnomape_sels, "T3.LegNomApe IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV57Novedadeventoswwds_4_tfleglicenini)) )
      {
         addWhere(sWhereString, "(T1.LegLicenIni >= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV58Novedadeventoswwds_5_tfleglicenini_to)) )
      {
         addWhere(sWhereString, "(T1.LegLicenIni <= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV59Novedadeventoswwds_6_tfleglicenfin)) )
      {
         addWhere(sWhereString, "(T1.LegLicenFin >= ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV60Novedadeventoswwds_7_tfleglicenfin_to)) )
      {
         addWhere(sWhereString, "(T1.LegLicenFin <= ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( ( AV62Novedadeventoswwds_9_tfleglicdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV61Novedadeventoswwds_8_tfleglicdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LegLicDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( AV62Novedadeventoswwds_9_tfleglicdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV62Novedadeventoswwds_9_tfleglicdescrip_sels, "T1.LegLicDescrip IN (", ")")+")");
      }
      if ( AV63Novedadeventoswwds_10_tfleglicestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63Novedadeventoswwds_10_tfleglicestado_sels, "T1.LegLicEstado IN (", ")")+")");
      }
      if ( AV64Novedadeventoswwds_11_tfleglicconplus_sel == 1 )
      {
         addWhere(sWhereString, "(T1.LegLicConPlus = TRUE)");
      }
      if ( AV64Novedadeventoswwds_11_tfleglicconplus_sel == 2 )
      {
         addWhere(sWhereString, "(T1.LegLicConPlus = FALSE)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P013R3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A591LegNomApe ,
                                          GXSimpleCollection<String> AV56Novedadeventoswwds_3_tflegnomape_sels ,
                                          String A914LegLicDescrip ,
                                          GXSimpleCollection<String> AV62Novedadeventoswwds_9_tfleglicdescrip_sels ,
                                          String A1497LegLicEstado ,
                                          GXSimpleCollection<String> AV63Novedadeventoswwds_10_tfleglicestado_sels ,
                                          int AV56Novedadeventoswwds_3_tflegnomape_sels_size ,
                                          String AV55Novedadeventoswwds_2_tflegnomape ,
                                          java.util.Date AV57Novedadeventoswwds_4_tfleglicenini ,
                                          java.util.Date AV58Novedadeventoswwds_5_tfleglicenini_to ,
                                          java.util.Date AV59Novedadeventoswwds_6_tfleglicenfin ,
                                          java.util.Date AV60Novedadeventoswwds_7_tfleglicenfin_to ,
                                          int AV62Novedadeventoswwds_9_tfleglicdescrip_sels_size ,
                                          String AV61Novedadeventoswwds_8_tfleglicdescrip ,
                                          int AV63Novedadeventoswwds_10_tfleglicestado_sels_size ,
                                          byte AV64Novedadeventoswwds_11_tfleglicconplus_sel ,
                                          java.util.Date A76LegLicenIni ,
                                          java.util.Date A481LegLicenFin ,
                                          boolean A1218LegLicConPlus ,
                                          boolean A738SitEsLicencia ,
                                          int A3CliCod ,
                                          int AV38CliCod ,
                                          short A1EmpCod ,
                                          short AV37EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[8];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T1.LegLicSitCodigo AS LegLicSitCodigo, T2.SitEsLicencia, T1.CliCod, T1.EmpCod, T1.LegLicDescrip, T1.LegLicConPlus, T1.LegLicEstado, T1.LegLicenFin," ;
      scmdbuf += " T1.LegLicenIni, T3.LegNomApe FROM ((LegajoLicencias T1 INNER JOIN Estado T2 ON T2.SitCodigo = T1.LegLicSitCodigo) INNER JOIN Legajo T3 ON T3.CliCod = T1.CliCod" ;
      scmdbuf += " AND T3.EmpCod = T1.EmpCod AND T3.LegNumero = T1.LegNumero)" ;
      addWhere(sWhereString, "(T2.SitEsLicencia = TRUE)");
      addWhere(sWhereString, "(T1.CliCod = ?)");
      addWhere(sWhereString, "(T1.EmpCod = ?)");
      if ( ( AV56Novedadeventoswwds_3_tflegnomape_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55Novedadeventoswwds_2_tflegnomape)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV56Novedadeventoswwds_3_tflegnomape_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56Novedadeventoswwds_3_tflegnomape_sels, "T3.LegNomApe IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV57Novedadeventoswwds_4_tfleglicenini)) )
      {
         addWhere(sWhereString, "(T1.LegLicenIni >= ?)");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV58Novedadeventoswwds_5_tfleglicenini_to)) )
      {
         addWhere(sWhereString, "(T1.LegLicenIni <= ?)");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV59Novedadeventoswwds_6_tfleglicenfin)) )
      {
         addWhere(sWhereString, "(T1.LegLicenFin >= ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV60Novedadeventoswwds_7_tfleglicenfin_to)) )
      {
         addWhere(sWhereString, "(T1.LegLicenFin <= ?)");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( ( AV62Novedadeventoswwds_9_tfleglicdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV61Novedadeventoswwds_8_tfleglicdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LegLicDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( AV62Novedadeventoswwds_9_tfleglicdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV62Novedadeventoswwds_9_tfleglicdescrip_sels, "T1.LegLicDescrip IN (", ")")+")");
      }
      if ( AV63Novedadeventoswwds_10_tfleglicestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63Novedadeventoswwds_10_tfleglicestado_sels, "T1.LegLicEstado IN (", ")")+")");
      }
      if ( AV64Novedadeventoswwds_11_tfleglicconplus_sel == 1 )
      {
         addWhere(sWhereString, "(T1.LegLicConPlus = TRUE)");
      }
      if ( AV64Novedadeventoswwds_11_tfleglicconplus_sel == 2 )
      {
         addWhere(sWhereString, "(T1.LegLicConPlus = FALSE)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.LegLicDescrip" ;
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
                  return conditional_P013R2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (java.util.Date)dynConstraints[8] , (java.util.Date)dynConstraints[9] , (java.util.Date)dynConstraints[10] , (java.util.Date)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).byteValue() , (java.util.Date)dynConstraints[16] , (java.util.Date)dynConstraints[17] , ((Boolean) dynConstraints[18]).booleanValue() , ((Boolean) dynConstraints[19]).booleanValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).shortValue() , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).shortValue() );
            case 1 :
                  return conditional_P013R3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (java.util.Date)dynConstraints[8] , (java.util.Date)dynConstraints[9] , (java.util.Date)dynConstraints[10] , (java.util.Date)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).byteValue() , (java.util.Date)dynConstraints[16] , (java.util.Date)dynConstraints[17] , ((Boolean) dynConstraints[18]).booleanValue() , ((Boolean) dynConstraints[19]).booleanValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).shortValue() , ((Number) dynConstraints[23]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P013R2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P013R3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 4);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(8);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(11);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 4);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(7);
               ((String[]) buf[8])[0] = rslt.getString(8, 20);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(9);
               ((java.util.Date[]) buf[10])[0] = rslt.getGXDate(10);
               ((String[]) buf[11])[0] = rslt.getVarchar(11);
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
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[11]);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[12]);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[13]);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[14]);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 400);
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
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[11]);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[12]);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[13]);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[14]);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 400);
               }
               return;
      }
   }

}

