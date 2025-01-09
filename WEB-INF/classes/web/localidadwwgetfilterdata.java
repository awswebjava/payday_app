package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class localidadwwgetfilterdata extends GXProcedure
{
   public localidadwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( localidadwwgetfilterdata.class ), "" );
   }

   public localidadwwgetfilterdata( int remoteHandle ,
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
      localidadwwgetfilterdata.this.aP5 = new String[] {""};
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
      localidadwwgetfilterdata.this.AV27DDOName = aP0;
      localidadwwgetfilterdata.this.AV25SearchTxt = aP1;
      localidadwwgetfilterdata.this.AV26SearchTxtTo = aP2;
      localidadwwgetfilterdata.this.aP3 = aP3;
      localidadwwgetfilterdata.this.aP4 = aP4;
      localidadwwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV48EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      localidadwwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV48EmpCod = GXt_int1 ;
      GXt_int3 = AV49CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      localidadwwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV49CliCod = GXt_int3 ;
      AV30Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV33OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV35OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLocalidad", GXv_boolean6) ;
      localidadwwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV27DDOName), "DDO_PAINOM") == 0 )
         {
            /* Execute user subroutine: 'LOADPAINOMOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV27DDOName), "DDO_PROVNOM") == 0 )
         {
            /* Execute user subroutine: 'LOADPROVNOMOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV27DDOName), "DDO_LOCNOM") == 0 )
         {
            /* Execute user subroutine: 'LOADLOCNOMOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV31OptionsJson = AV30Options.toJSonString(false) ;
      AV34OptionsDescJson = AV33OptionsDesc.toJSonString(false) ;
      AV36OptionIndexesJson = AV35OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV38Session.getValue("LocalidadWWGridState"), "") == 0 )
      {
         AV40GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "LocalidadWWGridState"), null, null);
      }
      else
      {
         AV40GridState.fromxml(AV38Session.getValue("LocalidadWWGridState"), null, null);
      }
      AV53GXV1 = 1 ;
      while ( AV53GXV1 <= AV40GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV41GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV40GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV53GXV1));
         if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PAICOD") == 0 )
         {
            AV44PaiCod = (short)(GXutil.lval( AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PROVCOD") == 0 )
         {
            AV46ProvCod = (short)(GXutil.lval( AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAINOM") == 0 )
         {
            AV12TFPaiNom = AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAINOM_SEL") == 0 )
         {
            AV11TFPaiNom_SelsJson = AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFPaiNom_Sels.fromJSonString(AV11TFPaiNom_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROVNOM") == 0 )
         {
            AV15TFProvNom = AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROVNOM_SEL") == 0 )
         {
            AV14TFProvNom_SelsJson = AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV16TFProvNom_Sels.fromJSonString(AV14TFProvNom_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLOCCOD") == 0 )
         {
            AV17TFLocCod = (short)(GXutil.lval( AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV18TFLocCod_To = (short)(GXutil.lval( AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLOCNOM") == 0 )
         {
            AV20TFLocNom = AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLOCNOM_SEL") == 0 )
         {
            AV19TFLocNom_SelsJson = AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV21TFLocNom_Sels.fromJSonString(AV19TFLocNom_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV50MenuOpcCod = AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV53GXV1 = (int)(AV53GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADPAINOMOPTIONS' Routine */
      returnInSub = false ;
      AV12TFPaiNom = AV25SearchTxt ;
      AV13TFPaiNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV55Localidadwwds_1_paicod = AV44PaiCod ;
      AV56Localidadwwds_2_provcod = AV46ProvCod ;
      AV57Localidadwwds_3_tfpainom = AV12TFPaiNom ;
      AV58Localidadwwds_4_tfpainom_sels = AV13TFPaiNom_Sels ;
      AV59Localidadwwds_5_tfprovnom = AV15TFProvNom ;
      AV60Localidadwwds_6_tfprovnom_sels = AV16TFProvNom_Sels ;
      AV61Localidadwwds_7_tfloccod = AV17TFLocCod ;
      AV62Localidadwwds_8_tfloccod_to = AV18TFLocCod_To ;
      AV63Localidadwwds_9_tflocnom = AV20TFLocNom ;
      AV64Localidadwwds_10_tflocnom_sels = AV21TFLocNom_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A312PaiNom ,
                                           AV58Localidadwwds_4_tfpainom_sels ,
                                           A322ProvNom ,
                                           AV60Localidadwwds_6_tfprovnom_sels ,
                                           A286LocNom ,
                                           AV64Localidadwwds_10_tflocnom_sels ,
                                           Short.valueOf(AV55Localidadwwds_1_paicod) ,
                                           Short.valueOf(AV56Localidadwwds_2_provcod) ,
                                           Integer.valueOf(AV58Localidadwwds_4_tfpainom_sels.size()) ,
                                           AV57Localidadwwds_3_tfpainom ,
                                           Integer.valueOf(AV60Localidadwwds_6_tfprovnom_sels.size()) ,
                                           AV59Localidadwwds_5_tfprovnom ,
                                           Short.valueOf(AV61Localidadwwds_7_tfloccod) ,
                                           Short.valueOf(AV62Localidadwwds_8_tfloccod_to) ,
                                           Integer.valueOf(AV64Localidadwwds_10_tflocnom_sels.size()) ,
                                           Short.valueOf(AV44PaiCod) ,
                                           Short.valueOf(A46PaiCod) ,
                                           Short.valueOf(A47ProvCod) ,
                                           Short.valueOf(A48LocCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV57Localidadwwds_3_tfpainom = GXutil.concat( GXutil.rtrim( AV57Localidadwwds_3_tfpainom), "%", "") ;
      lV59Localidadwwds_5_tfprovnom = GXutil.concat( GXutil.rtrim( AV59Localidadwwds_5_tfprovnom), "%", "") ;
      /* Using cursor P00EO2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV55Localidadwwds_1_paicod), Short.valueOf(AV56Localidadwwds_2_provcod), lV57Localidadwwds_3_tfpainom, lV59Localidadwwds_5_tfprovnom, Short.valueOf(AV61Localidadwwds_7_tfloccod), Short.valueOf(AV62Localidadwwds_8_tfloccod_to), Short.valueOf(AV44PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brkEO2 = false ;
         A312PaiNom = P00EO2_A312PaiNom[0] ;
         A286LocNom = P00EO2_A286LocNom[0] ;
         A48LocCod = P00EO2_A48LocCod[0] ;
         A322ProvNom = P00EO2_A322ProvNom[0] ;
         A47ProvCod = P00EO2_A47ProvCod[0] ;
         A46PaiCod = P00EO2_A46PaiCod[0] ;
         A312PaiNom = P00EO2_A312PaiNom[0] ;
         A322ProvNom = P00EO2_A322ProvNom[0] ;
         AV37count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P00EO2_A312PaiNom[0], A312PaiNom) == 0 ) )
         {
            brkEO2 = false ;
            A48LocCod = P00EO2_A48LocCod[0] ;
            A47ProvCod = P00EO2_A47ProvCod[0] ;
            A46PaiCod = P00EO2_A46PaiCod[0] ;
            AV37count = (long)(AV37count+1) ;
            brkEO2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A312PaiNom)==0) )
         {
            AV29Option = A312PaiNom ;
            AV30Options.add(AV29Option, 0);
            AV35OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV37count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV30Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brkEO2 )
         {
            brkEO2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADPROVNOMOPTIONS' Routine */
      returnInSub = false ;
      AV15TFProvNom = AV25SearchTxt ;
      AV16TFProvNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV55Localidadwwds_1_paicod = AV44PaiCod ;
      AV56Localidadwwds_2_provcod = AV46ProvCod ;
      AV57Localidadwwds_3_tfpainom = AV12TFPaiNom ;
      AV58Localidadwwds_4_tfpainom_sels = AV13TFPaiNom_Sels ;
      AV59Localidadwwds_5_tfprovnom = AV15TFProvNom ;
      AV60Localidadwwds_6_tfprovnom_sels = AV16TFProvNom_Sels ;
      AV61Localidadwwds_7_tfloccod = AV17TFLocCod ;
      AV62Localidadwwds_8_tfloccod_to = AV18TFLocCod_To ;
      AV63Localidadwwds_9_tflocnom = AV20TFLocNom ;
      AV64Localidadwwds_10_tflocnom_sels = AV21TFLocNom_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A312PaiNom ,
                                           AV58Localidadwwds_4_tfpainom_sels ,
                                           A322ProvNom ,
                                           AV60Localidadwwds_6_tfprovnom_sels ,
                                           A286LocNom ,
                                           AV64Localidadwwds_10_tflocnom_sels ,
                                           Short.valueOf(AV55Localidadwwds_1_paicod) ,
                                           Short.valueOf(AV56Localidadwwds_2_provcod) ,
                                           Integer.valueOf(AV58Localidadwwds_4_tfpainom_sels.size()) ,
                                           AV57Localidadwwds_3_tfpainom ,
                                           Integer.valueOf(AV60Localidadwwds_6_tfprovnom_sels.size()) ,
                                           AV59Localidadwwds_5_tfprovnom ,
                                           Short.valueOf(AV61Localidadwwds_7_tfloccod) ,
                                           Short.valueOf(AV62Localidadwwds_8_tfloccod_to) ,
                                           Integer.valueOf(AV64Localidadwwds_10_tflocnom_sels.size()) ,
                                           Short.valueOf(AV44PaiCod) ,
                                           Short.valueOf(A46PaiCod) ,
                                           Short.valueOf(A47ProvCod) ,
                                           Short.valueOf(A48LocCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV57Localidadwwds_3_tfpainom = GXutil.concat( GXutil.rtrim( AV57Localidadwwds_3_tfpainom), "%", "") ;
      lV59Localidadwwds_5_tfprovnom = GXutil.concat( GXutil.rtrim( AV59Localidadwwds_5_tfprovnom), "%", "") ;
      /* Using cursor P00EO3 */
      pr_default.execute(1, new Object[] {Short.valueOf(AV55Localidadwwds_1_paicod), Short.valueOf(AV56Localidadwwds_2_provcod), lV57Localidadwwds_3_tfpainom, lV59Localidadwwds_5_tfprovnom, Short.valueOf(AV61Localidadwwds_7_tfloccod), Short.valueOf(AV62Localidadwwds_8_tfloccod_to), Short.valueOf(AV44PaiCod)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brkEO4 = false ;
         A47ProvCod = P00EO3_A47ProvCod[0] ;
         A46PaiCod = P00EO3_A46PaiCod[0] ;
         A286LocNom = P00EO3_A286LocNom[0] ;
         A48LocCod = P00EO3_A48LocCod[0] ;
         A322ProvNom = P00EO3_A322ProvNom[0] ;
         A312PaiNom = P00EO3_A312PaiNom[0] ;
         A312PaiNom = P00EO3_A312PaiNom[0] ;
         A322ProvNom = P00EO3_A322ProvNom[0] ;
         AV37count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( P00EO3_A46PaiCod[0] == A46PaiCod ) && ( P00EO3_A47ProvCod[0] == A47ProvCod ) )
         {
            brkEO4 = false ;
            A48LocCod = P00EO3_A48LocCod[0] ;
            AV37count = (long)(AV37count+1) ;
            brkEO4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A322ProvNom)==0) )
         {
            AV29Option = A322ProvNom ;
            AV28InsertIndex = 1 ;
            while ( ( AV28InsertIndex <= AV30Options.size() ) && ( GXutil.strcmp((String)AV30Options.elementAt(-1+AV28InsertIndex), AV29Option) < 0 ) )
            {
               AV28InsertIndex = (int)(AV28InsertIndex+1) ;
            }
            AV30Options.add(AV29Option, AV28InsertIndex);
            AV35OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV37count), "Z,ZZZ,ZZZ,ZZ9")), AV28InsertIndex);
         }
         if ( AV30Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brkEO4 )
         {
            brkEO4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADLOCNOMOPTIONS' Routine */
      returnInSub = false ;
      AV20TFLocNom = AV25SearchTxt ;
      AV21TFLocNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV55Localidadwwds_1_paicod = AV44PaiCod ;
      AV56Localidadwwds_2_provcod = AV46ProvCod ;
      AV57Localidadwwds_3_tfpainom = AV12TFPaiNom ;
      AV58Localidadwwds_4_tfpainom_sels = AV13TFPaiNom_Sels ;
      AV59Localidadwwds_5_tfprovnom = AV15TFProvNom ;
      AV60Localidadwwds_6_tfprovnom_sels = AV16TFProvNom_Sels ;
      AV61Localidadwwds_7_tfloccod = AV17TFLocCod ;
      AV62Localidadwwds_8_tfloccod_to = AV18TFLocCod_To ;
      AV63Localidadwwds_9_tflocnom = AV20TFLocNom ;
      AV64Localidadwwds_10_tflocnom_sels = AV21TFLocNom_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A312PaiNom ,
                                           AV58Localidadwwds_4_tfpainom_sels ,
                                           A322ProvNom ,
                                           AV60Localidadwwds_6_tfprovnom_sels ,
                                           A286LocNom ,
                                           AV64Localidadwwds_10_tflocnom_sels ,
                                           Short.valueOf(AV55Localidadwwds_1_paicod) ,
                                           Short.valueOf(AV56Localidadwwds_2_provcod) ,
                                           Integer.valueOf(AV58Localidadwwds_4_tfpainom_sels.size()) ,
                                           AV57Localidadwwds_3_tfpainom ,
                                           Integer.valueOf(AV60Localidadwwds_6_tfprovnom_sels.size()) ,
                                           AV59Localidadwwds_5_tfprovnom ,
                                           Short.valueOf(AV61Localidadwwds_7_tfloccod) ,
                                           Short.valueOf(AV62Localidadwwds_8_tfloccod_to) ,
                                           Integer.valueOf(AV64Localidadwwds_10_tflocnom_sels.size()) ,
                                           Short.valueOf(AV44PaiCod) ,
                                           Short.valueOf(A46PaiCod) ,
                                           Short.valueOf(A47ProvCod) ,
                                           Short.valueOf(A48LocCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV57Localidadwwds_3_tfpainom = GXutil.concat( GXutil.rtrim( AV57Localidadwwds_3_tfpainom), "%", "") ;
      lV59Localidadwwds_5_tfprovnom = GXutil.concat( GXutil.rtrim( AV59Localidadwwds_5_tfprovnom), "%", "") ;
      /* Using cursor P00EO4 */
      pr_default.execute(2, new Object[] {Short.valueOf(AV55Localidadwwds_1_paicod), Short.valueOf(AV56Localidadwwds_2_provcod), lV57Localidadwwds_3_tfpainom, lV59Localidadwwds_5_tfprovnom, Short.valueOf(AV61Localidadwwds_7_tfloccod), Short.valueOf(AV62Localidadwwds_8_tfloccod_to), Short.valueOf(AV44PaiCod)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A286LocNom = P00EO4_A286LocNom[0] ;
         A48LocCod = P00EO4_A48LocCod[0] ;
         A322ProvNom = P00EO4_A322ProvNom[0] ;
         A312PaiNom = P00EO4_A312PaiNom[0] ;
         A47ProvCod = P00EO4_A47ProvCod[0] ;
         A46PaiCod = P00EO4_A46PaiCod[0] ;
         A312PaiNom = P00EO4_A312PaiNom[0] ;
         A322ProvNom = P00EO4_A322ProvNom[0] ;
         if ( ! (GXutil.strcmp("", A286LocNom)==0) )
         {
            AV29Option = A286LocNom ;
            AV30Options.add(AV29Option, 0);
         }
         if ( AV30Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(2);
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = localidadwwgetfilterdata.this.AV31OptionsJson;
      this.aP4[0] = localidadwwgetfilterdata.this.AV34OptionsDescJson;
      this.aP5[0] = localidadwwgetfilterdata.this.AV36OptionIndexesJson;
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
      AV34OptionsDescJson = "" ;
      AV36OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV30Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV33OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV35OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV38Session = httpContext.getWebSession();
      AV40GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV41GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV12TFPaiNom = "" ;
      AV11TFPaiNom_SelsJson = "" ;
      AV13TFPaiNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV15TFProvNom = "" ;
      AV14TFProvNom_SelsJson = "" ;
      AV16TFProvNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV20TFLocNom = "" ;
      AV19TFLocNom_SelsJson = "" ;
      AV21TFLocNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV50MenuOpcCod = "" ;
      A312PaiNom = "" ;
      AV57Localidadwwds_3_tfpainom = "" ;
      AV58Localidadwwds_4_tfpainom_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV59Localidadwwds_5_tfprovnom = "" ;
      AV60Localidadwwds_6_tfprovnom_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV63Localidadwwds_9_tflocnom = "" ;
      AV64Localidadwwds_10_tflocnom_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV57Localidadwwds_3_tfpainom = "" ;
      lV59Localidadwwds_5_tfprovnom = "" ;
      A322ProvNom = "" ;
      A286LocNom = "" ;
      P00EO2_A312PaiNom = new String[] {""} ;
      P00EO2_A286LocNom = new String[] {""} ;
      P00EO2_A48LocCod = new short[1] ;
      P00EO2_A322ProvNom = new String[] {""} ;
      P00EO2_A47ProvCod = new short[1] ;
      P00EO2_A46PaiCod = new short[1] ;
      AV29Option = "" ;
      P00EO3_A47ProvCod = new short[1] ;
      P00EO3_A46PaiCod = new short[1] ;
      P00EO3_A286LocNom = new String[] {""} ;
      P00EO3_A48LocCod = new short[1] ;
      P00EO3_A322ProvNom = new String[] {""} ;
      P00EO3_A312PaiNom = new String[] {""} ;
      P00EO4_A286LocNom = new String[] {""} ;
      P00EO4_A48LocCod = new short[1] ;
      P00EO4_A322ProvNom = new String[] {""} ;
      P00EO4_A312PaiNom = new String[] {""} ;
      P00EO4_A47ProvCod = new short[1] ;
      P00EO4_A46PaiCod = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.localidadwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P00EO2_A312PaiNom, P00EO2_A286LocNom, P00EO2_A48LocCod, P00EO2_A322ProvNom, P00EO2_A47ProvCod, P00EO2_A46PaiCod
            }
            , new Object[] {
            P00EO3_A47ProvCod, P00EO3_A46PaiCod, P00EO3_A286LocNom, P00EO3_A48LocCod, P00EO3_A322ProvNom, P00EO3_A312PaiNom
            }
            , new Object[] {
            P00EO4_A286LocNom, P00EO4_A48LocCod, P00EO4_A322ProvNom, P00EO4_A312PaiNom, P00EO4_A47ProvCod, P00EO4_A46PaiCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV48EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV44PaiCod ;
   private short AV46ProvCod ;
   private short AV17TFLocCod ;
   private short AV18TFLocCod_To ;
   private short AV55Localidadwwds_1_paicod ;
   private short AV56Localidadwwds_2_provcod ;
   private short AV61Localidadwwds_7_tfloccod ;
   private short AV62Localidadwwds_8_tfloccod_to ;
   private short A46PaiCod ;
   private short A47ProvCod ;
   private short A48LocCod ;
   private short Gx_err ;
   private int AV49CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV53GXV1 ;
   private int AV58Localidadwwds_4_tfpainom_sels_size ;
   private int AV60Localidadwwds_6_tfprovnom_sels_size ;
   private int AV64Localidadwwds_10_tflocnom_sels_size ;
   private int AV28InsertIndex ;
   private long AV37count ;
   private String scmdbuf ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brkEO2 ;
   private boolean brkEO4 ;
   private String AV31OptionsJson ;
   private String AV34OptionsDescJson ;
   private String AV36OptionIndexesJson ;
   private String AV11TFPaiNom_SelsJson ;
   private String AV14TFProvNom_SelsJson ;
   private String AV19TFLocNom_SelsJson ;
   private String AV27DDOName ;
   private String AV25SearchTxt ;
   private String AV26SearchTxtTo ;
   private String AV12TFPaiNom ;
   private String AV15TFProvNom ;
   private String AV20TFLocNom ;
   private String AV50MenuOpcCod ;
   private String A312PaiNom ;
   private String AV57Localidadwwds_3_tfpainom ;
   private String AV59Localidadwwds_5_tfprovnom ;
   private String AV63Localidadwwds_9_tflocnom ;
   private String lV57Localidadwwds_3_tfpainom ;
   private String lV59Localidadwwds_5_tfprovnom ;
   private String A322ProvNom ;
   private String A286LocNom ;
   private String AV29Option ;
   private com.genexus.webpanels.WebSession AV38Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P00EO2_A312PaiNom ;
   private String[] P00EO2_A286LocNom ;
   private short[] P00EO2_A48LocCod ;
   private String[] P00EO2_A322ProvNom ;
   private short[] P00EO2_A47ProvCod ;
   private short[] P00EO2_A46PaiCod ;
   private short[] P00EO3_A47ProvCod ;
   private short[] P00EO3_A46PaiCod ;
   private String[] P00EO3_A286LocNom ;
   private short[] P00EO3_A48LocCod ;
   private String[] P00EO3_A322ProvNom ;
   private String[] P00EO3_A312PaiNom ;
   private String[] P00EO4_A286LocNom ;
   private short[] P00EO4_A48LocCod ;
   private String[] P00EO4_A322ProvNom ;
   private String[] P00EO4_A312PaiNom ;
   private short[] P00EO4_A47ProvCod ;
   private short[] P00EO4_A46PaiCod ;
   private GXSimpleCollection<String> AV30Options ;
   private GXSimpleCollection<String> AV33OptionsDesc ;
   private GXSimpleCollection<String> AV35OptionIndexes ;
   private GXSimpleCollection<String> AV13TFPaiNom_Sels ;
   private GXSimpleCollection<String> AV16TFProvNom_Sels ;
   private GXSimpleCollection<String> AV21TFLocNom_Sels ;
   private GXSimpleCollection<String> AV58Localidadwwds_4_tfpainom_sels ;
   private GXSimpleCollection<String> AV60Localidadwwds_6_tfprovnom_sels ;
   private GXSimpleCollection<String> AV64Localidadwwds_10_tflocnom_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV40GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV41GridStateFilterValue ;
}

final  class localidadwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00EO2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A312PaiNom ,
                                          GXSimpleCollection<String> AV58Localidadwwds_4_tfpainom_sels ,
                                          String A322ProvNom ,
                                          GXSimpleCollection<String> AV60Localidadwwds_6_tfprovnom_sels ,
                                          String A286LocNom ,
                                          GXSimpleCollection<String> AV64Localidadwwds_10_tflocnom_sels ,
                                          short AV55Localidadwwds_1_paicod ,
                                          short AV56Localidadwwds_2_provcod ,
                                          int AV58Localidadwwds_4_tfpainom_sels_size ,
                                          String AV57Localidadwwds_3_tfpainom ,
                                          int AV60Localidadwwds_6_tfprovnom_sels_size ,
                                          String AV59Localidadwwds_5_tfprovnom ,
                                          short AV61Localidadwwds_7_tfloccod ,
                                          short AV62Localidadwwds_8_tfloccod_to ,
                                          int AV64Localidadwwds_10_tflocnom_sels_size ,
                                          short AV44PaiCod ,
                                          short A46PaiCod ,
                                          short A47ProvCod ,
                                          short A48LocCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[7];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT T2.PaiNom, T1.LocNom, T1.LocCod, T3.ProvNom, T1.ProvCod, T1.PaiCod FROM ((Localidad T1 INNER JOIN Pais T2 ON T2.PaiCod = T1.PaiCod) INNER JOIN Provincia T3" ;
      scmdbuf += " ON T3.PaiCod = T1.PaiCod AND T3.ProvCod = T1.ProvCod)" ;
      if ( ! (0==AV55Localidadwwds_1_paicod) )
      {
         addWhere(sWhereString, "(T1.PaiCod >= ?)");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( ! (0==AV56Localidadwwds_2_provcod) )
      {
         addWhere(sWhereString, "(T1.ProvCod >= ?)");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( ( AV58Localidadwwds_4_tfpainom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV57Localidadwwds_3_tfpainom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.PaiNom) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV58Localidadwwds_4_tfpainom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58Localidadwwds_4_tfpainom_sels, "T2.PaiNom IN (", ")")+")");
      }
      if ( ( AV60Localidadwwds_6_tfprovnom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV59Localidadwwds_5_tfprovnom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.ProvNom) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV60Localidadwwds_6_tfprovnom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV60Localidadwwds_6_tfprovnom_sels, "T3.ProvNom IN (", ")")+")");
      }
      if ( ! (0==AV61Localidadwwds_7_tfloccod) )
      {
         addWhere(sWhereString, "(T1.LocCod >= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( ! (0==AV62Localidadwwds_8_tfloccod_to) )
      {
         addWhere(sWhereString, "(T1.LocCod <= ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( AV64Localidadwwds_10_tflocnom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV64Localidadwwds_10_tflocnom_sels, "T1.LocNom IN (", ")")+")");
      }
      if ( ! (0==AV44PaiCod) )
      {
         addWhere(sWhereString, "(T1.PaiCod = ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T2.PaiNom" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P00EO3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A312PaiNom ,
                                          GXSimpleCollection<String> AV58Localidadwwds_4_tfpainom_sels ,
                                          String A322ProvNom ,
                                          GXSimpleCollection<String> AV60Localidadwwds_6_tfprovnom_sels ,
                                          String A286LocNom ,
                                          GXSimpleCollection<String> AV64Localidadwwds_10_tflocnom_sels ,
                                          short AV55Localidadwwds_1_paicod ,
                                          short AV56Localidadwwds_2_provcod ,
                                          int AV58Localidadwwds_4_tfpainom_sels_size ,
                                          String AV57Localidadwwds_3_tfpainom ,
                                          int AV60Localidadwwds_6_tfprovnom_sels_size ,
                                          String AV59Localidadwwds_5_tfprovnom ,
                                          short AV61Localidadwwds_7_tfloccod ,
                                          short AV62Localidadwwds_8_tfloccod_to ,
                                          int AV64Localidadwwds_10_tflocnom_sels_size ,
                                          short AV44PaiCod ,
                                          short A46PaiCod ,
                                          short A47ProvCod ,
                                          short A48LocCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[7];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT T1.ProvCod, T1.PaiCod, T1.LocNom, T1.LocCod, T3.ProvNom, T2.PaiNom FROM ((Localidad T1 INNER JOIN Pais T2 ON T2.PaiCod = T1.PaiCod) INNER JOIN Provincia T3" ;
      scmdbuf += " ON T3.PaiCod = T1.PaiCod AND T3.ProvCod = T1.ProvCod)" ;
      if ( ! (0==AV55Localidadwwds_1_paicod) )
      {
         addWhere(sWhereString, "(T1.PaiCod >= ?)");
      }
      else
      {
         GXv_int11[0] = (byte)(1) ;
      }
      if ( ! (0==AV56Localidadwwds_2_provcod) )
      {
         addWhere(sWhereString, "(T1.ProvCod >= ?)");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( ( AV58Localidadwwds_4_tfpainom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV57Localidadwwds_3_tfpainom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.PaiNom) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV58Localidadwwds_4_tfpainom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58Localidadwwds_4_tfpainom_sels, "T2.PaiNom IN (", ")")+")");
      }
      if ( ( AV60Localidadwwds_6_tfprovnom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV59Localidadwwds_5_tfprovnom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.ProvNom) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV60Localidadwwds_6_tfprovnom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV60Localidadwwds_6_tfprovnom_sels, "T3.ProvNom IN (", ")")+")");
      }
      if ( ! (0==AV61Localidadwwds_7_tfloccod) )
      {
         addWhere(sWhereString, "(T1.LocCod >= ?)");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( ! (0==AV62Localidadwwds_8_tfloccod_to) )
      {
         addWhere(sWhereString, "(T1.LocCod <= ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( AV64Localidadwwds_10_tflocnom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV64Localidadwwds_10_tflocnom_sels, "T1.LocNom IN (", ")")+")");
      }
      if ( ! (0==AV44PaiCod) )
      {
         addWhere(sWhereString, "(T1.PaiCod = ?)");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.PaiCod, T1.ProvCod" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P00EO4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A312PaiNom ,
                                          GXSimpleCollection<String> AV58Localidadwwds_4_tfpainom_sels ,
                                          String A322ProvNom ,
                                          GXSimpleCollection<String> AV60Localidadwwds_6_tfprovnom_sels ,
                                          String A286LocNom ,
                                          GXSimpleCollection<String> AV64Localidadwwds_10_tflocnom_sels ,
                                          short AV55Localidadwwds_1_paicod ,
                                          short AV56Localidadwwds_2_provcod ,
                                          int AV58Localidadwwds_4_tfpainom_sels_size ,
                                          String AV57Localidadwwds_3_tfpainom ,
                                          int AV60Localidadwwds_6_tfprovnom_sels_size ,
                                          String AV59Localidadwwds_5_tfprovnom ,
                                          short AV61Localidadwwds_7_tfloccod ,
                                          short AV62Localidadwwds_8_tfloccod_to ,
                                          int AV64Localidadwwds_10_tflocnom_sels_size ,
                                          short AV44PaiCod ,
                                          short A46PaiCod ,
                                          short A47ProvCod ,
                                          short A48LocCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[7];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT DISTINCT LocNom, NULL AS LocCod, NULL AS ProvNom, NULL AS PaiNom, NULL AS ProvCod, NULL AS PaiCod FROM ( SELECT T1.LocNom, T1.LocCod, T3.ProvNom, T2.PaiNom," ;
      scmdbuf += " T1.ProvCod, T1.PaiCod FROM ((Localidad T1 INNER JOIN Pais T2 ON T2.PaiCod = T1.PaiCod) INNER JOIN Provincia T3 ON T3.PaiCod = T1.PaiCod AND T3.ProvCod = T1.ProvCod)" ;
      if ( ! (0==AV55Localidadwwds_1_paicod) )
      {
         addWhere(sWhereString, "(T1.PaiCod >= ?)");
      }
      else
      {
         GXv_int14[0] = (byte)(1) ;
      }
      if ( ! (0==AV56Localidadwwds_2_provcod) )
      {
         addWhere(sWhereString, "(T1.ProvCod >= ?)");
      }
      else
      {
         GXv_int14[1] = (byte)(1) ;
      }
      if ( ( AV58Localidadwwds_4_tfpainom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV57Localidadwwds_3_tfpainom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.PaiNom) like LOWER(?))");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( AV58Localidadwwds_4_tfpainom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58Localidadwwds_4_tfpainom_sels, "T2.PaiNom IN (", ")")+")");
      }
      if ( ( AV60Localidadwwds_6_tfprovnom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV59Localidadwwds_5_tfprovnom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.ProvNom) like LOWER(?))");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( AV60Localidadwwds_6_tfprovnom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV60Localidadwwds_6_tfprovnom_sels, "T3.ProvNom IN (", ")")+")");
      }
      if ( ! (0==AV61Localidadwwds_7_tfloccod) )
      {
         addWhere(sWhereString, "(T1.LocCod >= ?)");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( ! (0==AV62Localidadwwds_8_tfloccod_to) )
      {
         addWhere(sWhereString, "(T1.LocCod <= ?)");
      }
      else
      {
         GXv_int14[5] = (byte)(1) ;
      }
      if ( AV64Localidadwwds_10_tflocnom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV64Localidadwwds_10_tflocnom_sels, "T1.LocNom IN (", ")")+")");
      }
      if ( ! (0==AV44PaiCod) )
      {
         addWhere(sWhereString, "(T1.PaiCod = ?)");
      }
      else
      {
         GXv_int14[6] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.LocNom" ;
      scmdbuf += ") DistinctT" ;
      scmdbuf += " ORDER BY LocNom" ;
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
                  return conditional_P00EO2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).shortValue() );
            case 1 :
                  return conditional_P00EO3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).shortValue() );
            case 2 :
                  return conditional_P00EO4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00EO2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00EO3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00EO4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
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
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 30);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 30);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 30);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               return;
      }
   }

}

