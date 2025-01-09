package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class legajo_permanenciawwgetfilterdata extends GXProcedure
{
   public legajo_permanenciawwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajo_permanenciawwgetfilterdata.class ), "" );
   }

   public legajo_permanenciawwgetfilterdata( int remoteHandle ,
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
      legajo_permanenciawwgetfilterdata.this.aP5 = new String[] {""};
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
      legajo_permanenciawwgetfilterdata.this.AV47DDOName = aP0;
      legajo_permanenciawwgetfilterdata.this.AV48SearchTxt = aP1;
      legajo_permanenciawwgetfilterdata.this.AV49SearchTxtTo = aP2;
      legajo_permanenciawwgetfilterdata.this.aP3 = aP3;
      legajo_permanenciawwgetfilterdata.this.aP4 = aP4;
      legajo_permanenciawwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV54EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      legajo_permanenciawwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV54EmpCod = GXt_int1 ;
      GXt_int3 = AV55CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      legajo_permanenciawwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV55CliCod = GXt_int3 ;
      AV37Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV39OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV40OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWlegajo_permanencia", GXv_boolean6) ;
      legajo_permanenciawwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV47DDOName), "DDO_LEGIDNOMAPE") == 0 )
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
         else if ( GXutil.strcmp(GXutil.upper( AV47DDOName), "DDO_LEGHISMOTIVO") == 0 )
         {
            /* Execute user subroutine: 'LOADLEGHISMOTIVOOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV50OptionsJson = AV37Options.toJSonString(false) ;
      AV51OptionsDescJson = AV39OptionsDesc.toJSonString(false) ;
      AV52OptionIndexesJson = AV40OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV42Session.getValue("legajo_permanenciaWWGridState"), "") == 0 )
      {
         AV44GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "legajo_permanenciaWWGridState"), null, null);
      }
      else
      {
         AV44GridState.fromxml(AV42Session.getValue("legajo_permanenciaWWGridState"), null, null);
      }
      AV58GXV1 = 1 ;
      while ( AV58GXV1 <= AV44GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV45GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV44GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV58GXV1));
         if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGIDNOMAPE") == 0 )
         {
            AV12TFLegIdNomApe = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGIDNOMAPE_SEL") == 0 )
         {
            AV11TFLegIdNomApe_SelsJson = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFLegIdNomApe_Sels.fromJSonString(AV11TFLegIdNomApe_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGHISFECING") == 0 )
         {
            AV14TFLegHisFecIng = localUtil.ctod( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV15TFLegHisFecIng_To = localUtil.ctod( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGHISFECEGR") == 0 )
         {
            AV16TFLegHisFecEgr = localUtil.ctod( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV17TFLegHisFecEgr_To = localUtil.ctod( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGHISAFECANT_SEL") == 0 )
         {
            AV34TFLegHisAfecAnt_Sel = (byte)(GXutil.lval( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGHISMOTIVO") == 0 )
         {
            AV21TFLegHisMotivo = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGHISMOTIVO_SEL") == 0 )
         {
            AV20TFLegHisMotivo_SelsJson = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV22TFLegHisMotivo_Sels.fromJSonString(AV20TFLegHisMotivo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV53MenuOpcCod = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV58GXV1 = (int)(AV58GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADLEGIDNOMAPEOPTIONS' Routine */
      returnInSub = false ;
      AV12TFLegIdNomApe = AV48SearchTxt ;
      AV13TFLegIdNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV60Legajo_permanenciawwds_1_tflegidnomape = AV12TFLegIdNomApe ;
      AV61Legajo_permanenciawwds_2_tflegidnomape_sels = AV13TFLegIdNomApe_Sels ;
      AV62Legajo_permanenciawwds_3_tfleghisfecing = AV14TFLegHisFecIng ;
      AV63Legajo_permanenciawwds_4_tfleghisfecing_to = AV15TFLegHisFecIng_To ;
      AV64Legajo_permanenciawwds_5_tfleghisfecegr = AV16TFLegHisFecEgr ;
      AV65Legajo_permanenciawwds_6_tfleghisfecegr_to = AV17TFLegHisFecEgr_To ;
      AV66Legajo_permanenciawwds_7_tfleghisafecant_sel = AV34TFLegHisAfecAnt_Sel ;
      AV67Legajo_permanenciawwds_8_tfleghismotivo = AV21TFLegHisMotivo ;
      AV68Legajo_permanenciawwds_9_tfleghismotivo_sels = AV22TFLegHisMotivo_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A250LegIdNomApe ,
                                           AV61Legajo_permanenciawwds_2_tflegidnomape_sels ,
                                           A2256LegHisMotivo ,
                                           AV68Legajo_permanenciawwds_9_tfleghismotivo_sels ,
                                           Integer.valueOf(AV61Legajo_permanenciawwds_2_tflegidnomape_sels.size()) ,
                                           AV60Legajo_permanenciawwds_1_tflegidnomape ,
                                           AV62Legajo_permanenciawwds_3_tfleghisfecing ,
                                           AV63Legajo_permanenciawwds_4_tfleghisfecing_to ,
                                           AV64Legajo_permanenciawwds_5_tfleghisfecegr ,
                                           AV65Legajo_permanenciawwds_6_tfleghisfecegr_to ,
                                           Byte.valueOf(AV66Legajo_permanenciawwds_7_tfleghisafecant_sel) ,
                                           Integer.valueOf(AV68Legajo_permanenciawwds_9_tfleghismotivo_sels.size()) ,
                                           AV67Legajo_permanenciawwds_8_tfleghismotivo ,
                                           A2253LegHisFecIng ,
                                           A2254LegHisFecEgr ,
                                           Boolean.valueOf(A2258LegHisAfecAnt) ,
                                           Integer.valueOf(AV55CliCod) ,
                                           Short.valueOf(AV54EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV60Legajo_permanenciawwds_1_tflegidnomape = GXutil.concat( GXutil.rtrim( AV60Legajo_permanenciawwds_1_tflegidnomape), "%", "") ;
      lV67Legajo_permanenciawwds_8_tfleghismotivo = GXutil.concat( GXutil.rtrim( AV67Legajo_permanenciawwds_8_tfleghismotivo), "%", "") ;
      /* Using cursor P02AA2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV55CliCod), Short.valueOf(AV54EmpCod), lV60Legajo_permanenciawwds_1_tflegidnomape, AV62Legajo_permanenciawwds_3_tfleghisfecing, AV63Legajo_permanenciawwds_4_tfleghisfecing_to, AV64Legajo_permanenciawwds_5_tfleghisfecegr, AV65Legajo_permanenciawwds_6_tfleghisfecegr_to, lV67Legajo_permanenciawwds_8_tfleghismotivo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P02AA2_A6LegNumero[0] ;
         A2330LegHisMotCod = P02AA2_A2330LegHisMotCod[0] ;
         n2330LegHisMotCod = P02AA2_n2330LegHisMotCod[0] ;
         A1EmpCod = P02AA2_A1EmpCod[0] ;
         A3CliCod = P02AA2_A3CliCod[0] ;
         A2256LegHisMotivo = P02AA2_A2256LegHisMotivo[0] ;
         A2258LegHisAfecAnt = P02AA2_A2258LegHisAfecAnt[0] ;
         A2254LegHisFecEgr = P02AA2_A2254LegHisFecEgr[0] ;
         A2253LegHisFecIng = P02AA2_A2253LegHisFecIng[0] ;
         A250LegIdNomApe = P02AA2_A250LegIdNomApe[0] ;
         A250LegIdNomApe = P02AA2_A250LegIdNomApe[0] ;
         A2256LegHisMotivo = P02AA2_A2256LegHisMotivo[0] ;
         if ( ! (GXutil.strcmp("", A250LegIdNomApe)==0) )
         {
            AV36Option = A250LegIdNomApe ;
            AV35InsertIndex = 1 ;
            while ( ( AV35InsertIndex <= AV37Options.size() ) && ( GXutil.strcmp((String)AV37Options.elementAt(-1+AV35InsertIndex), AV36Option) < 0 ) )
            {
               AV35InsertIndex = (int)(AV35InsertIndex+1) ;
            }
            if ( ( AV35InsertIndex <= AV37Options.size() ) && ( GXutil.strcmp((String)AV37Options.elementAt(-1+AV35InsertIndex), AV36Option) == 0 ) )
            {
               AV41count = GXutil.lval( (String)AV40OptionIndexes.elementAt(-1+AV35InsertIndex)) ;
               AV41count = (long)(AV41count+1) ;
               AV40OptionIndexes.removeItem(AV35InsertIndex);
               AV40OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV41count), "Z,ZZZ,ZZZ,ZZ9")), AV35InsertIndex);
            }
            else
            {
               AV37Options.add(AV36Option, AV35InsertIndex);
               AV40OptionIndexes.add("1", AV35InsertIndex);
            }
         }
         if ( AV37Options.size() == 50 )
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
      /* 'LOADLEGHISMOTIVOOPTIONS' Routine */
      returnInSub = false ;
      AV21TFLegHisMotivo = AV48SearchTxt ;
      AV22TFLegHisMotivo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV60Legajo_permanenciawwds_1_tflegidnomape = AV12TFLegIdNomApe ;
      AV61Legajo_permanenciawwds_2_tflegidnomape_sels = AV13TFLegIdNomApe_Sels ;
      AV62Legajo_permanenciawwds_3_tfleghisfecing = AV14TFLegHisFecIng ;
      AV63Legajo_permanenciawwds_4_tfleghisfecing_to = AV15TFLegHisFecIng_To ;
      AV64Legajo_permanenciawwds_5_tfleghisfecegr = AV16TFLegHisFecEgr ;
      AV65Legajo_permanenciawwds_6_tfleghisfecegr_to = AV17TFLegHisFecEgr_To ;
      AV66Legajo_permanenciawwds_7_tfleghisafecant_sel = AV34TFLegHisAfecAnt_Sel ;
      AV67Legajo_permanenciawwds_8_tfleghismotivo = AV21TFLegHisMotivo ;
      AV68Legajo_permanenciawwds_9_tfleghismotivo_sels = AV22TFLegHisMotivo_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A250LegIdNomApe ,
                                           AV61Legajo_permanenciawwds_2_tflegidnomape_sels ,
                                           A2256LegHisMotivo ,
                                           AV68Legajo_permanenciawwds_9_tfleghismotivo_sels ,
                                           Integer.valueOf(AV61Legajo_permanenciawwds_2_tflegidnomape_sels.size()) ,
                                           AV60Legajo_permanenciawwds_1_tflegidnomape ,
                                           AV62Legajo_permanenciawwds_3_tfleghisfecing ,
                                           AV63Legajo_permanenciawwds_4_tfleghisfecing_to ,
                                           AV64Legajo_permanenciawwds_5_tfleghisfecegr ,
                                           AV65Legajo_permanenciawwds_6_tfleghisfecegr_to ,
                                           Byte.valueOf(AV66Legajo_permanenciawwds_7_tfleghisafecant_sel) ,
                                           Integer.valueOf(AV68Legajo_permanenciawwds_9_tfleghismotivo_sels.size()) ,
                                           AV67Legajo_permanenciawwds_8_tfleghismotivo ,
                                           A2253LegHisFecIng ,
                                           A2254LegHisFecEgr ,
                                           Boolean.valueOf(A2258LegHisAfecAnt) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV54EmpCod) ,
                                           Integer.valueOf(AV55CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV60Legajo_permanenciawwds_1_tflegidnomape = GXutil.concat( GXutil.rtrim( AV60Legajo_permanenciawwds_1_tflegidnomape), "%", "") ;
      lV67Legajo_permanenciawwds_8_tfleghismotivo = GXutil.concat( GXutil.rtrim( AV67Legajo_permanenciawwds_8_tfleghismotivo), "%", "") ;
      /* Using cursor P02AA3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV55CliCod), Short.valueOf(AV54EmpCod), lV60Legajo_permanenciawwds_1_tflegidnomape, AV62Legajo_permanenciawwds_3_tfleghisfecing, AV63Legajo_permanenciawwds_4_tfleghisfecing_to, AV64Legajo_permanenciawwds_5_tfleghisfecegr, AV65Legajo_permanenciawwds_6_tfleghisfecegr_to, lV67Legajo_permanenciawwds_8_tfleghismotivo});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk2AA3 = false ;
         A6LegNumero = P02AA3_A6LegNumero[0] ;
         A2330LegHisMotCod = P02AA3_A2330LegHisMotCod[0] ;
         n2330LegHisMotCod = P02AA3_n2330LegHisMotCod[0] ;
         A3CliCod = P02AA3_A3CliCod[0] ;
         A1EmpCod = P02AA3_A1EmpCod[0] ;
         A2256LegHisMotivo = P02AA3_A2256LegHisMotivo[0] ;
         A2258LegHisAfecAnt = P02AA3_A2258LegHisAfecAnt[0] ;
         A2254LegHisFecEgr = P02AA3_A2254LegHisFecEgr[0] ;
         A2253LegHisFecIng = P02AA3_A2253LegHisFecIng[0] ;
         A250LegIdNomApe = P02AA3_A250LegIdNomApe[0] ;
         A2256LegHisMotivo = P02AA3_A2256LegHisMotivo[0] ;
         A250LegIdNomApe = P02AA3_A250LegIdNomApe[0] ;
         AV41count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( P02AA3_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P02AA3_A2330LegHisMotCod[0], A2330LegHisMotCod) == 0 ) )
         {
            brk2AA3 = false ;
            A6LegNumero = P02AA3_A6LegNumero[0] ;
            A1EmpCod = P02AA3_A1EmpCod[0] ;
            A2253LegHisFecIng = P02AA3_A2253LegHisFecIng[0] ;
            AV41count = (long)(AV41count+1) ;
            brk2AA3 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A2256LegHisMotivo)==0) )
         {
            AV36Option = A2256LegHisMotivo ;
            AV35InsertIndex = 1 ;
            while ( ( AV35InsertIndex <= AV37Options.size() ) && ( GXutil.strcmp((String)AV37Options.elementAt(-1+AV35InsertIndex), AV36Option) < 0 ) )
            {
               AV35InsertIndex = (int)(AV35InsertIndex+1) ;
            }
            AV37Options.add(AV36Option, AV35InsertIndex);
            AV40OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV41count), "Z,ZZZ,ZZZ,ZZ9")), AV35InsertIndex);
         }
         if ( AV37Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2AA3 )
         {
            brk2AA3 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = legajo_permanenciawwgetfilterdata.this.AV50OptionsJson;
      this.aP4[0] = legajo_permanenciawwgetfilterdata.this.AV51OptionsDescJson;
      this.aP5[0] = legajo_permanenciawwgetfilterdata.this.AV52OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV50OptionsJson = "" ;
      AV51OptionsDescJson = "" ;
      AV52OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV37Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV39OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV40OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV42Session = httpContext.getWebSession();
      AV44GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV45GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV12TFLegIdNomApe = "" ;
      AV11TFLegIdNomApe_SelsJson = "" ;
      AV13TFLegIdNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV14TFLegHisFecIng = GXutil.nullDate() ;
      AV15TFLegHisFecIng_To = GXutil.nullDate() ;
      AV16TFLegHisFecEgr = GXutil.nullDate() ;
      AV17TFLegHisFecEgr_To = GXutil.nullDate() ;
      AV21TFLegHisMotivo = "" ;
      AV20TFLegHisMotivo_SelsJson = "" ;
      AV22TFLegHisMotivo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV53MenuOpcCod = "" ;
      A250LegIdNomApe = "" ;
      AV60Legajo_permanenciawwds_1_tflegidnomape = "" ;
      AV61Legajo_permanenciawwds_2_tflegidnomape_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV62Legajo_permanenciawwds_3_tfleghisfecing = GXutil.nullDate() ;
      AV63Legajo_permanenciawwds_4_tfleghisfecing_to = GXutil.nullDate() ;
      AV64Legajo_permanenciawwds_5_tfleghisfecegr = GXutil.nullDate() ;
      AV65Legajo_permanenciawwds_6_tfleghisfecegr_to = GXutil.nullDate() ;
      AV67Legajo_permanenciawwds_8_tfleghismotivo = "" ;
      AV68Legajo_permanenciawwds_9_tfleghismotivo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV60Legajo_permanenciawwds_1_tflegidnomape = "" ;
      lV67Legajo_permanenciawwds_8_tfleghismotivo = "" ;
      A2256LegHisMotivo = "" ;
      A2253LegHisFecIng = GXutil.nullDate() ;
      A2254LegHisFecEgr = GXutil.nullDate() ;
      P02AA2_A6LegNumero = new int[1] ;
      P02AA2_A2330LegHisMotCod = new String[] {""} ;
      P02AA2_n2330LegHisMotCod = new boolean[] {false} ;
      P02AA2_A1EmpCod = new short[1] ;
      P02AA2_A3CliCod = new int[1] ;
      P02AA2_A2256LegHisMotivo = new String[] {""} ;
      P02AA2_A2258LegHisAfecAnt = new boolean[] {false} ;
      P02AA2_A2254LegHisFecEgr = new java.util.Date[] {GXutil.nullDate()} ;
      P02AA2_A2253LegHisFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      P02AA2_A250LegIdNomApe = new String[] {""} ;
      A2330LegHisMotCod = "" ;
      AV36Option = "" ;
      P02AA3_A6LegNumero = new int[1] ;
      P02AA3_A2330LegHisMotCod = new String[] {""} ;
      P02AA3_n2330LegHisMotCod = new boolean[] {false} ;
      P02AA3_A3CliCod = new int[1] ;
      P02AA3_A1EmpCod = new short[1] ;
      P02AA3_A2256LegHisMotivo = new String[] {""} ;
      P02AA3_A2258LegHisAfecAnt = new boolean[] {false} ;
      P02AA3_A2254LegHisFecEgr = new java.util.Date[] {GXutil.nullDate()} ;
      P02AA3_A2253LegHisFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      P02AA3_A250LegIdNomApe = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajo_permanenciawwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P02AA2_A6LegNumero, P02AA2_A2330LegHisMotCod, P02AA2_n2330LegHisMotCod, P02AA2_A1EmpCod, P02AA2_A3CliCod, P02AA2_A2256LegHisMotivo, P02AA2_A2258LegHisAfecAnt, P02AA2_A2254LegHisFecEgr, P02AA2_A2253LegHisFecIng, P02AA2_A250LegIdNomApe
            }
            , new Object[] {
            P02AA3_A6LegNumero, P02AA3_A2330LegHisMotCod, P02AA3_n2330LegHisMotCod, P02AA3_A3CliCod, P02AA3_A1EmpCod, P02AA3_A2256LegHisMotivo, P02AA3_A2258LegHisAfecAnt, P02AA3_A2254LegHisFecEgr, P02AA3_A2253LegHisFecIng, P02AA3_A250LegIdNomApe
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV34TFLegHisAfecAnt_Sel ;
   private byte AV66Legajo_permanenciawwds_7_tfleghisafecant_sel ;
   private short AV54EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV55CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV58GXV1 ;
   private int AV61Legajo_permanenciawwds_2_tflegidnomape_sels_size ;
   private int AV68Legajo_permanenciawwds_9_tfleghismotivo_sels_size ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int AV35InsertIndex ;
   private long AV41count ;
   private String scmdbuf ;
   private String A2330LegHisMotCod ;
   private java.util.Date AV14TFLegHisFecIng ;
   private java.util.Date AV15TFLegHisFecIng_To ;
   private java.util.Date AV16TFLegHisFecEgr ;
   private java.util.Date AV17TFLegHisFecEgr_To ;
   private java.util.Date AV62Legajo_permanenciawwds_3_tfleghisfecing ;
   private java.util.Date AV63Legajo_permanenciawwds_4_tfleghisfecing_to ;
   private java.util.Date AV64Legajo_permanenciawwds_5_tfleghisfecegr ;
   private java.util.Date AV65Legajo_permanenciawwds_6_tfleghisfecegr_to ;
   private java.util.Date A2253LegHisFecIng ;
   private java.util.Date A2254LegHisFecEgr ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean A2258LegHisAfecAnt ;
   private boolean n2330LegHisMotCod ;
   private boolean brk2AA3 ;
   private String AV50OptionsJson ;
   private String AV51OptionsDescJson ;
   private String AV52OptionIndexesJson ;
   private String AV11TFLegIdNomApe_SelsJson ;
   private String AV20TFLegHisMotivo_SelsJson ;
   private String AV47DDOName ;
   private String AV48SearchTxt ;
   private String AV49SearchTxtTo ;
   private String AV12TFLegIdNomApe ;
   private String AV21TFLegHisMotivo ;
   private String AV53MenuOpcCod ;
   private String A250LegIdNomApe ;
   private String AV60Legajo_permanenciawwds_1_tflegidnomape ;
   private String AV67Legajo_permanenciawwds_8_tfleghismotivo ;
   private String lV60Legajo_permanenciawwds_1_tflegidnomape ;
   private String lV67Legajo_permanenciawwds_8_tfleghismotivo ;
   private String A2256LegHisMotivo ;
   private String AV36Option ;
   private com.genexus.webpanels.WebSession AV42Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P02AA2_A6LegNumero ;
   private String[] P02AA2_A2330LegHisMotCod ;
   private boolean[] P02AA2_n2330LegHisMotCod ;
   private short[] P02AA2_A1EmpCod ;
   private int[] P02AA2_A3CliCod ;
   private String[] P02AA2_A2256LegHisMotivo ;
   private boolean[] P02AA2_A2258LegHisAfecAnt ;
   private java.util.Date[] P02AA2_A2254LegHisFecEgr ;
   private java.util.Date[] P02AA2_A2253LegHisFecIng ;
   private String[] P02AA2_A250LegIdNomApe ;
   private int[] P02AA3_A6LegNumero ;
   private String[] P02AA3_A2330LegHisMotCod ;
   private boolean[] P02AA3_n2330LegHisMotCod ;
   private int[] P02AA3_A3CliCod ;
   private short[] P02AA3_A1EmpCod ;
   private String[] P02AA3_A2256LegHisMotivo ;
   private boolean[] P02AA3_A2258LegHisAfecAnt ;
   private java.util.Date[] P02AA3_A2254LegHisFecEgr ;
   private java.util.Date[] P02AA3_A2253LegHisFecIng ;
   private String[] P02AA3_A250LegIdNomApe ;
   private GXSimpleCollection<String> AV37Options ;
   private GXSimpleCollection<String> AV39OptionsDesc ;
   private GXSimpleCollection<String> AV40OptionIndexes ;
   private GXSimpleCollection<String> AV13TFLegIdNomApe_Sels ;
   private GXSimpleCollection<String> AV22TFLegHisMotivo_Sels ;
   private GXSimpleCollection<String> AV61Legajo_permanenciawwds_2_tflegidnomape_sels ;
   private GXSimpleCollection<String> AV68Legajo_permanenciawwds_9_tfleghismotivo_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV44GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV45GridStateFilterValue ;
}

final  class legajo_permanenciawwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02AA2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A250LegIdNomApe ,
                                          GXSimpleCollection<String> AV61Legajo_permanenciawwds_2_tflegidnomape_sels ,
                                          String A2256LegHisMotivo ,
                                          GXSimpleCollection<String> AV68Legajo_permanenciawwds_9_tfleghismotivo_sels ,
                                          int AV61Legajo_permanenciawwds_2_tflegidnomape_sels_size ,
                                          String AV60Legajo_permanenciawwds_1_tflegidnomape ,
                                          java.util.Date AV62Legajo_permanenciawwds_3_tfleghisfecing ,
                                          java.util.Date AV63Legajo_permanenciawwds_4_tfleghisfecing_to ,
                                          java.util.Date AV64Legajo_permanenciawwds_5_tfleghisfecegr ,
                                          java.util.Date AV65Legajo_permanenciawwds_6_tfleghisfecegr_to ,
                                          byte AV66Legajo_permanenciawwds_7_tfleghisafecant_sel ,
                                          int AV68Legajo_permanenciawwds_9_tfleghismotivo_sels_size ,
                                          String AV67Legajo_permanenciawwds_8_tfleghismotivo ,
                                          java.util.Date A2253LegHisFecIng ,
                                          java.util.Date A2254LegHisFecEgr ,
                                          boolean A2258LegHisAfecAnt ,
                                          int AV55CliCod ,
                                          short AV54EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[8];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T1.LegHisMotCod AS LegHisMotCod, T1.EmpCod, T1.CliCod, T3.MegDescrip AS LegHisMotivo, T1.LegHisAfecAnt, T1.LegHisFecEgr, T1.LegHisFecIng, T2.LegIdNomApe" ;
      scmdbuf += " FROM ((legajo_permanencia T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) LEFT JOIN MotivoEgreso T3" ;
      scmdbuf += " ON T3.CliCod = T1.CliCod AND T3.MegCodigo = T1.LegHisMotCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      if ( ( AV61Legajo_permanenciawwds_2_tflegidnomape_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV60Legajo_permanenciawwds_1_tflegidnomape)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegIdNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV61Legajo_permanenciawwds_2_tflegidnomape_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Legajo_permanenciawwds_2_tflegidnomape_sels, "T2.LegIdNomApe IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV62Legajo_permanenciawwds_3_tfleghisfecing)) )
      {
         addWhere(sWhereString, "(T1.LegHisFecIng >= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV63Legajo_permanenciawwds_4_tfleghisfecing_to)) )
      {
         addWhere(sWhereString, "(T1.LegHisFecIng <= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV64Legajo_permanenciawwds_5_tfleghisfecegr)) )
      {
         addWhere(sWhereString, "(T1.LegHisFecEgr >= ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV65Legajo_permanenciawwds_6_tfleghisfecegr_to)) )
      {
         addWhere(sWhereString, "(T1.LegHisFecEgr <= ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( AV66Legajo_permanenciawwds_7_tfleghisafecant_sel == 1 )
      {
         addWhere(sWhereString, "(T1.LegHisAfecAnt = TRUE)");
      }
      if ( AV66Legajo_permanenciawwds_7_tfleghisafecant_sel == 2 )
      {
         addWhere(sWhereString, "(T1.LegHisAfecAnt = FALSE)");
      }
      if ( ( AV68Legajo_permanenciawwds_9_tfleghismotivo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV67Legajo_permanenciawwds_8_tfleghismotivo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.MegDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( AV68Legajo_permanenciawwds_9_tfleghismotivo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV68Legajo_permanenciawwds_9_tfleghismotivo_sels, "T3.MegDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P02AA3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A250LegIdNomApe ,
                                          GXSimpleCollection<String> AV61Legajo_permanenciawwds_2_tflegidnomape_sels ,
                                          String A2256LegHisMotivo ,
                                          GXSimpleCollection<String> AV68Legajo_permanenciawwds_9_tfleghismotivo_sels ,
                                          int AV61Legajo_permanenciawwds_2_tflegidnomape_sels_size ,
                                          String AV60Legajo_permanenciawwds_1_tflegidnomape ,
                                          java.util.Date AV62Legajo_permanenciawwds_3_tfleghisfecing ,
                                          java.util.Date AV63Legajo_permanenciawwds_4_tfleghisfecing_to ,
                                          java.util.Date AV64Legajo_permanenciawwds_5_tfleghisfecegr ,
                                          java.util.Date AV65Legajo_permanenciawwds_6_tfleghisfecegr_to ,
                                          byte AV66Legajo_permanenciawwds_7_tfleghisafecant_sel ,
                                          int AV68Legajo_permanenciawwds_9_tfleghismotivo_sels_size ,
                                          String AV67Legajo_permanenciawwds_8_tfleghismotivo ,
                                          java.util.Date A2253LegHisFecIng ,
                                          java.util.Date A2254LegHisFecEgr ,
                                          boolean A2258LegHisAfecAnt ,
                                          short A1EmpCod ,
                                          short AV54EmpCod ,
                                          int AV55CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[8];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T1.LegHisMotCod AS LegHisMotCod, T1.CliCod, T1.EmpCod, T2.MegDescrip AS LegHisMotivo, T1.LegHisAfecAnt, T1.LegHisFecEgr, T1.LegHisFecIng, T3.LegIdNomApe" ;
      scmdbuf += " FROM ((legajo_permanencia T1 LEFT JOIN MotivoEgreso T2 ON T2.CliCod = T1.CliCod AND T2.MegCodigo = T1.LegHisMotCod) INNER JOIN Legajo T3 ON T3.CliCod = T1.CliCod" ;
      scmdbuf += " AND T3.EmpCod = T1.EmpCod AND T3.LegNumero = T1.LegNumero)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      addWhere(sWhereString, "(T1.EmpCod = ?)");
      if ( ( AV61Legajo_permanenciawwds_2_tflegidnomape_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV60Legajo_permanenciawwds_1_tflegidnomape)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.LegIdNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV61Legajo_permanenciawwds_2_tflegidnomape_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Legajo_permanenciawwds_2_tflegidnomape_sels, "T3.LegIdNomApe IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV62Legajo_permanenciawwds_3_tfleghisfecing)) )
      {
         addWhere(sWhereString, "(T1.LegHisFecIng >= ?)");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV63Legajo_permanenciawwds_4_tfleghisfecing_to)) )
      {
         addWhere(sWhereString, "(T1.LegHisFecIng <= ?)");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV64Legajo_permanenciawwds_5_tfleghisfecegr)) )
      {
         addWhere(sWhereString, "(T1.LegHisFecEgr >= ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV65Legajo_permanenciawwds_6_tfleghisfecegr_to)) )
      {
         addWhere(sWhereString, "(T1.LegHisFecEgr <= ?)");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( AV66Legajo_permanenciawwds_7_tfleghisafecant_sel == 1 )
      {
         addWhere(sWhereString, "(T1.LegHisAfecAnt = TRUE)");
      }
      if ( AV66Legajo_permanenciawwds_7_tfleghisafecant_sel == 2 )
      {
         addWhere(sWhereString, "(T1.LegHisAfecAnt = FALSE)");
      }
      if ( ( AV68Legajo_permanenciawwds_9_tfleghismotivo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV67Legajo_permanenciawwds_8_tfleghismotivo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.MegDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( AV68Legajo_permanenciawwds_9_tfleghismotivo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV68Legajo_permanenciawwds_9_tfleghismotivo_sels, "T2.MegDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.LegHisMotCod" ;
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
                  return conditional_P02AA2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , (java.util.Date)dynConstraints[6] , (java.util.Date)dynConstraints[7] , (java.util.Date)dynConstraints[8] , (java.util.Date)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (java.util.Date)dynConstraints[13] , (java.util.Date)dynConstraints[14] , ((Boolean) dynConstraints[15]).booleanValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).shortValue() );
            case 1 :
                  return conditional_P02AA3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , (java.util.Date)dynConstraints[6] , (java.util.Date)dynConstraints[7] , (java.util.Date)dynConstraints[8] , (java.util.Date)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (java.util.Date)dynConstraints[13] , (java.util.Date)dynConstraints[14] , ((Boolean) dynConstraints[15]).booleanValue() , ((Number) dynConstraints[16]).shortValue() , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02AA2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02AA3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(6);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(7);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(8);
               ((String[]) buf[9])[0] = rslt.getVarchar(9);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((short[]) buf[4])[0] = rslt.getShort(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(6);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(7);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(8);
               ((String[]) buf[9])[0] = rslt.getVarchar(9);
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

