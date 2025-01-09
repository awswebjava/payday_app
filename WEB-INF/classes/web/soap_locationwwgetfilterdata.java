package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class soap_locationwwgetfilterdata extends GXProcedure
{
   public soap_locationwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( soap_locationwwgetfilterdata.class ), "" );
   }

   public soap_locationwwgetfilterdata( int remoteHandle ,
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
      soap_locationwwgetfilterdata.this.aP5 = new String[] {""};
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
      soap_locationwwgetfilterdata.this.AV44DDOName = aP0;
      soap_locationwwgetfilterdata.this.AV45SearchTxt = aP1;
      soap_locationwwgetfilterdata.this.AV46SearchTxtTo = aP2;
      soap_locationwwgetfilterdata.this.aP3 = aP3;
      soap_locationwwgetfilterdata.this.aP4 = aP4;
      soap_locationwwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV51EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      soap_locationwwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV51EmpCod = GXt_int1 ;
      GXt_int3 = AV50CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      soap_locationwwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV50CliCod = GXt_int3 ;
      AV34Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV36OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV37OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWsoap_location", GXv_boolean6) ;
      soap_locationwwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV44DDOName), "DDO_SOAPLOCID") == 0 )
         {
            /* Execute user subroutine: 'LOADSOAPLOCIDOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV44DDOName), "DDO_SOAPLOCBASEURL") == 0 )
         {
            /* Execute user subroutine: 'LOADSOAPLOCBASEURLOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV44DDOName), "DDO_SOAPLOCHOST") == 0 )
         {
            /* Execute user subroutine: 'LOADSOAPLOCHOSTOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV44DDOName), "DDO_SOAPLOCRESOURCENAME") == 0 )
         {
            /* Execute user subroutine: 'LOADSOAPLOCRESOURCENAMEOPTIONS' */
            S151 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV47OptionsJson = AV34Options.toJSonString(false) ;
      AV48OptionsDescJson = AV36OptionsDesc.toJSonString(false) ;
      AV49OptionIndexesJson = AV37OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV39Session.getValue("soap_locationWWGridState"), "") == 0 )
      {
         AV41GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "soap_locationWWGridState"), null, null);
      }
      else
      {
         AV41GridState.fromxml(AV39Session.getValue("soap_locationWWGridState"), null, null);
      }
      AV57GXV1 = 1 ;
      while ( AV57GXV1 <= AV41GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV42GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV41GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV57GXV1));
         if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICOD") == 0 )
         {
            AV52TFCliCod = (int)(GXutil.lval( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV53TFCliCod_To = (int)(GXutil.lval( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCID") == 0 )
         {
            AV12TFSoapLocId = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCID_SEL") == 0 )
         {
            AV11TFSoapLocId_SelsJson = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFSoapLocId_Sels.fromJSonString(AV11TFSoapLocId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCHAB_SEL") == 0 )
         {
            AV14TFSoapLocHab_Sel = (byte)(GXutil.lval( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCBASEURL") == 0 )
         {
            AV16TFSoapLocBaseUrl = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCBASEURL_SEL") == 0 )
         {
            AV15TFSoapLocBaseUrl_SelsJson = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV17TFSoapLocBaseUrl_Sels.fromJSonString(AV15TFSoapLocBaseUrl_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCCANCELONERROR") == 0 )
         {
            AV18TFSoapLocCancelOnError = (byte)(GXutil.lval( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV19TFSoapLocCancelOnError_To = (byte)(GXutil.lval( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCHOST") == 0 )
         {
            AV21TFSoapLocHost = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCHOST_SEL") == 0 )
         {
            AV20TFSoapLocHost_SelsJson = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV22TFSoapLocHost_Sels.fromJSonString(AV20TFSoapLocHost_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCPORT") == 0 )
         {
            AV23TFSoapLocPort = (int)(GXutil.lval( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV24TFSoapLocPort_To = (int)(GXutil.lval( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCRESOURCENAME") == 0 )
         {
            AV26TFSoapLocResourceName = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCRESOURCENAME_SEL") == 0 )
         {
            AV25TFSoapLocResourceName_SelsJson = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV27TFSoapLocResourceName_Sels.fromJSonString(AV25TFSoapLocResourceName_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCSECURE") == 0 )
         {
            AV28TFSoapLocSecure = (byte)(GXutil.lval( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV29TFSoapLocSecure_To = (byte)(GXutil.lval( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSOAPLOCTIMEOUT") == 0 )
         {
            AV30TFSoapLocTimeout = (short)(GXutil.lval( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV31TFSoapLocTimeout_To = (short)(GXutil.lval( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV54MenuOpcCod = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV57GXV1 = (int)(AV57GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADSOAPLOCIDOPTIONS' Routine */
      returnInSub = false ;
      AV12TFSoapLocId = AV45SearchTxt ;
      AV13TFSoapLocId_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV59Soap_locationwwds_1_tfclicod = AV52TFCliCod ;
      AV60Soap_locationwwds_2_tfclicod_to = AV53TFCliCod_To ;
      AV61Soap_locationwwds_3_tfsoaplocid = AV12TFSoapLocId ;
      AV62Soap_locationwwds_4_tfsoaplocid_sels = AV13TFSoapLocId_Sels ;
      AV63Soap_locationwwds_5_tfsoaplochab_sel = AV14TFSoapLocHab_Sel ;
      AV64Soap_locationwwds_6_tfsoaplocbaseurl = AV16TFSoapLocBaseUrl ;
      AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels = AV17TFSoapLocBaseUrl_Sels ;
      AV66Soap_locationwwds_8_tfsoaploccancelonerror = AV18TFSoapLocCancelOnError ;
      AV67Soap_locationwwds_9_tfsoaploccancelonerror_to = AV19TFSoapLocCancelOnError_To ;
      AV68Soap_locationwwds_10_tfsoaplochost = AV21TFSoapLocHost ;
      AV69Soap_locationwwds_11_tfsoaplochost_sels = AV22TFSoapLocHost_Sels ;
      AV70Soap_locationwwds_12_tfsoaplocport = AV23TFSoapLocPort ;
      AV71Soap_locationwwds_13_tfsoaplocport_to = AV24TFSoapLocPort_To ;
      AV72Soap_locationwwds_14_tfsoaplocresourcename = AV26TFSoapLocResourceName ;
      AV73Soap_locationwwds_15_tfsoaplocresourcename_sels = AV27TFSoapLocResourceName_Sels ;
      AV74Soap_locationwwds_16_tfsoaplocsecure = AV28TFSoapLocSecure ;
      AV75Soap_locationwwds_17_tfsoaplocsecure_to = AV29TFSoapLocSecure_To ;
      AV76Soap_locationwwds_18_tfsoaploctimeout = AV30TFSoapLocTimeout ;
      AV77Soap_locationwwds_19_tfsoaploctimeout_to = AV31TFSoapLocTimeout_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A2162SoapLocId ,
                                           AV62Soap_locationwwds_4_tfsoaplocid_sels ,
                                           A2164SoapLocBaseUrl ,
                                           AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels ,
                                           A2166SoapLocHost ,
                                           AV69Soap_locationwwds_11_tfsoaplochost_sels ,
                                           A2168SoapLocResourceName ,
                                           AV73Soap_locationwwds_15_tfsoaplocresourcename_sels ,
                                           Integer.valueOf(AV59Soap_locationwwds_1_tfclicod) ,
                                           Integer.valueOf(AV60Soap_locationwwds_2_tfclicod_to) ,
                                           Integer.valueOf(AV62Soap_locationwwds_4_tfsoaplocid_sels.size()) ,
                                           AV61Soap_locationwwds_3_tfsoaplocid ,
                                           Byte.valueOf(AV63Soap_locationwwds_5_tfsoaplochab_sel) ,
                                           Integer.valueOf(AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels.size()) ,
                                           AV64Soap_locationwwds_6_tfsoaplocbaseurl ,
                                           Byte.valueOf(AV66Soap_locationwwds_8_tfsoaploccancelonerror) ,
                                           Byte.valueOf(AV67Soap_locationwwds_9_tfsoaploccancelonerror_to) ,
                                           Integer.valueOf(AV69Soap_locationwwds_11_tfsoaplochost_sels.size()) ,
                                           AV68Soap_locationwwds_10_tfsoaplochost ,
                                           Integer.valueOf(AV70Soap_locationwwds_12_tfsoaplocport) ,
                                           Integer.valueOf(AV71Soap_locationwwds_13_tfsoaplocport_to) ,
                                           Integer.valueOf(AV73Soap_locationwwds_15_tfsoaplocresourcename_sels.size()) ,
                                           AV72Soap_locationwwds_14_tfsoaplocresourcename ,
                                           Byte.valueOf(AV74Soap_locationwwds_16_tfsoaplocsecure) ,
                                           Byte.valueOf(AV75Soap_locationwwds_17_tfsoaplocsecure_to) ,
                                           Short.valueOf(AV76Soap_locationwwds_18_tfsoaploctimeout) ,
                                           Short.valueOf(AV77Soap_locationwwds_19_tfsoaploctimeout_to) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Boolean.valueOf(A2163SoapLocHab) ,
                                           Byte.valueOf(A2165SoapLocCancelOnError) ,
                                           Integer.valueOf(A2167SoapLocPort) ,
                                           Byte.valueOf(A2169SoapLocSecure) ,
                                           Short.valueOf(A2170SoapLocTimeout) ,
                                           Integer.valueOf(AV50CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      lV61Soap_locationwwds_3_tfsoaplocid = GXutil.padr( GXutil.rtrim( AV61Soap_locationwwds_3_tfsoaplocid), 40, "%") ;
      lV64Soap_locationwwds_6_tfsoaplocbaseurl = GXutil.concat( GXutil.rtrim( AV64Soap_locationwwds_6_tfsoaplocbaseurl), "%", "") ;
      lV68Soap_locationwwds_10_tfsoaplochost = GXutil.concat( GXutil.rtrim( AV68Soap_locationwwds_10_tfsoaplochost), "%", "") ;
      lV72Soap_locationwwds_14_tfsoaplocresourcename = GXutil.concat( GXutil.rtrim( AV72Soap_locationwwds_14_tfsoaplocresourcename), "%", "") ;
      /* Using cursor P028Y2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV50CliCod), Integer.valueOf(AV59Soap_locationwwds_1_tfclicod), Integer.valueOf(AV60Soap_locationwwds_2_tfclicod_to), lV61Soap_locationwwds_3_tfsoaplocid, lV64Soap_locationwwds_6_tfsoaplocbaseurl, Byte.valueOf(AV66Soap_locationwwds_8_tfsoaploccancelonerror), Byte.valueOf(AV67Soap_locationwwds_9_tfsoaploccancelonerror_to), lV68Soap_locationwwds_10_tfsoaplochost, Integer.valueOf(AV70Soap_locationwwds_12_tfsoaplocport), Integer.valueOf(AV71Soap_locationwwds_13_tfsoaplocport_to), lV72Soap_locationwwds_14_tfsoaplocresourcename, Byte.valueOf(AV74Soap_locationwwds_16_tfsoaplocsecure), Byte.valueOf(AV75Soap_locationwwds_17_tfsoaplocsecure_to), Short.valueOf(AV76Soap_locationwwds_18_tfsoaploctimeout), Short.valueOf(AV77Soap_locationwwds_19_tfsoaploctimeout_to)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk28Y2 = false ;
         A3CliCod = P028Y2_A3CliCod[0] ;
         A2162SoapLocId = P028Y2_A2162SoapLocId[0] ;
         A2170SoapLocTimeout = P028Y2_A2170SoapLocTimeout[0] ;
         A2169SoapLocSecure = P028Y2_A2169SoapLocSecure[0] ;
         A2168SoapLocResourceName = P028Y2_A2168SoapLocResourceName[0] ;
         A2167SoapLocPort = P028Y2_A2167SoapLocPort[0] ;
         A2166SoapLocHost = P028Y2_A2166SoapLocHost[0] ;
         A2165SoapLocCancelOnError = P028Y2_A2165SoapLocCancelOnError[0] ;
         A2164SoapLocBaseUrl = P028Y2_A2164SoapLocBaseUrl[0] ;
         A2163SoapLocHab = P028Y2_A2163SoapLocHab[0] ;
         AV38count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P028Y2_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P028Y2_A2162SoapLocId[0], A2162SoapLocId) == 0 ) )
         {
            brk28Y2 = false ;
            AV38count = (long)(AV38count+1) ;
            brk28Y2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A2162SoapLocId)==0) )
         {
            AV33Option = A2162SoapLocId ;
            AV34Options.add(AV33Option, 0);
            AV37OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV38count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV34Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk28Y2 )
         {
            brk28Y2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADSOAPLOCBASEURLOPTIONS' Routine */
      returnInSub = false ;
      AV16TFSoapLocBaseUrl = AV45SearchTxt ;
      AV17TFSoapLocBaseUrl_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV59Soap_locationwwds_1_tfclicod = AV52TFCliCod ;
      AV60Soap_locationwwds_2_tfclicod_to = AV53TFCliCod_To ;
      AV61Soap_locationwwds_3_tfsoaplocid = AV12TFSoapLocId ;
      AV62Soap_locationwwds_4_tfsoaplocid_sels = AV13TFSoapLocId_Sels ;
      AV63Soap_locationwwds_5_tfsoaplochab_sel = AV14TFSoapLocHab_Sel ;
      AV64Soap_locationwwds_6_tfsoaplocbaseurl = AV16TFSoapLocBaseUrl ;
      AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels = AV17TFSoapLocBaseUrl_Sels ;
      AV66Soap_locationwwds_8_tfsoaploccancelonerror = AV18TFSoapLocCancelOnError ;
      AV67Soap_locationwwds_9_tfsoaploccancelonerror_to = AV19TFSoapLocCancelOnError_To ;
      AV68Soap_locationwwds_10_tfsoaplochost = AV21TFSoapLocHost ;
      AV69Soap_locationwwds_11_tfsoaplochost_sels = AV22TFSoapLocHost_Sels ;
      AV70Soap_locationwwds_12_tfsoaplocport = AV23TFSoapLocPort ;
      AV71Soap_locationwwds_13_tfsoaplocport_to = AV24TFSoapLocPort_To ;
      AV72Soap_locationwwds_14_tfsoaplocresourcename = AV26TFSoapLocResourceName ;
      AV73Soap_locationwwds_15_tfsoaplocresourcename_sels = AV27TFSoapLocResourceName_Sels ;
      AV74Soap_locationwwds_16_tfsoaplocsecure = AV28TFSoapLocSecure ;
      AV75Soap_locationwwds_17_tfsoaplocsecure_to = AV29TFSoapLocSecure_To ;
      AV76Soap_locationwwds_18_tfsoaploctimeout = AV30TFSoapLocTimeout ;
      AV77Soap_locationwwds_19_tfsoaploctimeout_to = AV31TFSoapLocTimeout_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A2162SoapLocId ,
                                           AV62Soap_locationwwds_4_tfsoaplocid_sels ,
                                           A2164SoapLocBaseUrl ,
                                           AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels ,
                                           A2166SoapLocHost ,
                                           AV69Soap_locationwwds_11_tfsoaplochost_sels ,
                                           A2168SoapLocResourceName ,
                                           AV73Soap_locationwwds_15_tfsoaplocresourcename_sels ,
                                           Integer.valueOf(AV59Soap_locationwwds_1_tfclicod) ,
                                           Integer.valueOf(AV60Soap_locationwwds_2_tfclicod_to) ,
                                           Integer.valueOf(AV62Soap_locationwwds_4_tfsoaplocid_sels.size()) ,
                                           AV61Soap_locationwwds_3_tfsoaplocid ,
                                           Byte.valueOf(AV63Soap_locationwwds_5_tfsoaplochab_sel) ,
                                           Integer.valueOf(AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels.size()) ,
                                           AV64Soap_locationwwds_6_tfsoaplocbaseurl ,
                                           Byte.valueOf(AV66Soap_locationwwds_8_tfsoaploccancelonerror) ,
                                           Byte.valueOf(AV67Soap_locationwwds_9_tfsoaploccancelonerror_to) ,
                                           Integer.valueOf(AV69Soap_locationwwds_11_tfsoaplochost_sels.size()) ,
                                           AV68Soap_locationwwds_10_tfsoaplochost ,
                                           Integer.valueOf(AV70Soap_locationwwds_12_tfsoaplocport) ,
                                           Integer.valueOf(AV71Soap_locationwwds_13_tfsoaplocport_to) ,
                                           Integer.valueOf(AV73Soap_locationwwds_15_tfsoaplocresourcename_sels.size()) ,
                                           AV72Soap_locationwwds_14_tfsoaplocresourcename ,
                                           Byte.valueOf(AV74Soap_locationwwds_16_tfsoaplocsecure) ,
                                           Byte.valueOf(AV75Soap_locationwwds_17_tfsoaplocsecure_to) ,
                                           Short.valueOf(AV76Soap_locationwwds_18_tfsoaploctimeout) ,
                                           Short.valueOf(AV77Soap_locationwwds_19_tfsoaploctimeout_to) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Boolean.valueOf(A2163SoapLocHab) ,
                                           Byte.valueOf(A2165SoapLocCancelOnError) ,
                                           Integer.valueOf(A2167SoapLocPort) ,
                                           Byte.valueOf(A2169SoapLocSecure) ,
                                           Short.valueOf(A2170SoapLocTimeout) ,
                                           Integer.valueOf(AV50CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      lV61Soap_locationwwds_3_tfsoaplocid = GXutil.padr( GXutil.rtrim( AV61Soap_locationwwds_3_tfsoaplocid), 40, "%") ;
      lV64Soap_locationwwds_6_tfsoaplocbaseurl = GXutil.concat( GXutil.rtrim( AV64Soap_locationwwds_6_tfsoaplocbaseurl), "%", "") ;
      lV68Soap_locationwwds_10_tfsoaplochost = GXutil.concat( GXutil.rtrim( AV68Soap_locationwwds_10_tfsoaplochost), "%", "") ;
      lV72Soap_locationwwds_14_tfsoaplocresourcename = GXutil.concat( GXutil.rtrim( AV72Soap_locationwwds_14_tfsoaplocresourcename), "%", "") ;
      /* Using cursor P028Y3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV50CliCod), Integer.valueOf(AV59Soap_locationwwds_1_tfclicod), Integer.valueOf(AV60Soap_locationwwds_2_tfclicod_to), lV61Soap_locationwwds_3_tfsoaplocid, lV64Soap_locationwwds_6_tfsoaplocbaseurl, Byte.valueOf(AV66Soap_locationwwds_8_tfsoaploccancelonerror), Byte.valueOf(AV67Soap_locationwwds_9_tfsoaploccancelonerror_to), lV68Soap_locationwwds_10_tfsoaplochost, Integer.valueOf(AV70Soap_locationwwds_12_tfsoaplocport), Integer.valueOf(AV71Soap_locationwwds_13_tfsoaplocport_to), lV72Soap_locationwwds_14_tfsoaplocresourcename, Byte.valueOf(AV74Soap_locationwwds_16_tfsoaplocsecure), Byte.valueOf(AV75Soap_locationwwds_17_tfsoaplocsecure_to), Short.valueOf(AV76Soap_locationwwds_18_tfsoaploctimeout), Short.valueOf(AV77Soap_locationwwds_19_tfsoaploctimeout_to)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk28Y4 = false ;
         A3CliCod = P028Y3_A3CliCod[0] ;
         A2164SoapLocBaseUrl = P028Y3_A2164SoapLocBaseUrl[0] ;
         A2170SoapLocTimeout = P028Y3_A2170SoapLocTimeout[0] ;
         A2169SoapLocSecure = P028Y3_A2169SoapLocSecure[0] ;
         A2168SoapLocResourceName = P028Y3_A2168SoapLocResourceName[0] ;
         A2167SoapLocPort = P028Y3_A2167SoapLocPort[0] ;
         A2166SoapLocHost = P028Y3_A2166SoapLocHost[0] ;
         A2165SoapLocCancelOnError = P028Y3_A2165SoapLocCancelOnError[0] ;
         A2163SoapLocHab = P028Y3_A2163SoapLocHab[0] ;
         A2162SoapLocId = P028Y3_A2162SoapLocId[0] ;
         AV38count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P028Y3_A2164SoapLocBaseUrl[0], A2164SoapLocBaseUrl) == 0 ) )
         {
            brk28Y4 = false ;
            A3CliCod = P028Y3_A3CliCod[0] ;
            A2162SoapLocId = P028Y3_A2162SoapLocId[0] ;
            AV38count = (long)(AV38count+1) ;
            brk28Y4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A2164SoapLocBaseUrl)==0) )
         {
            AV33Option = A2164SoapLocBaseUrl ;
            AV34Options.add(AV33Option, 0);
            AV37OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV38count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV34Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk28Y4 )
         {
            brk28Y4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADSOAPLOCHOSTOPTIONS' Routine */
      returnInSub = false ;
      AV21TFSoapLocHost = AV45SearchTxt ;
      AV22TFSoapLocHost_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV59Soap_locationwwds_1_tfclicod = AV52TFCliCod ;
      AV60Soap_locationwwds_2_tfclicod_to = AV53TFCliCod_To ;
      AV61Soap_locationwwds_3_tfsoaplocid = AV12TFSoapLocId ;
      AV62Soap_locationwwds_4_tfsoaplocid_sels = AV13TFSoapLocId_Sels ;
      AV63Soap_locationwwds_5_tfsoaplochab_sel = AV14TFSoapLocHab_Sel ;
      AV64Soap_locationwwds_6_tfsoaplocbaseurl = AV16TFSoapLocBaseUrl ;
      AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels = AV17TFSoapLocBaseUrl_Sels ;
      AV66Soap_locationwwds_8_tfsoaploccancelonerror = AV18TFSoapLocCancelOnError ;
      AV67Soap_locationwwds_9_tfsoaploccancelonerror_to = AV19TFSoapLocCancelOnError_To ;
      AV68Soap_locationwwds_10_tfsoaplochost = AV21TFSoapLocHost ;
      AV69Soap_locationwwds_11_tfsoaplochost_sels = AV22TFSoapLocHost_Sels ;
      AV70Soap_locationwwds_12_tfsoaplocport = AV23TFSoapLocPort ;
      AV71Soap_locationwwds_13_tfsoaplocport_to = AV24TFSoapLocPort_To ;
      AV72Soap_locationwwds_14_tfsoaplocresourcename = AV26TFSoapLocResourceName ;
      AV73Soap_locationwwds_15_tfsoaplocresourcename_sels = AV27TFSoapLocResourceName_Sels ;
      AV74Soap_locationwwds_16_tfsoaplocsecure = AV28TFSoapLocSecure ;
      AV75Soap_locationwwds_17_tfsoaplocsecure_to = AV29TFSoapLocSecure_To ;
      AV76Soap_locationwwds_18_tfsoaploctimeout = AV30TFSoapLocTimeout ;
      AV77Soap_locationwwds_19_tfsoaploctimeout_to = AV31TFSoapLocTimeout_To ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A2162SoapLocId ,
                                           AV62Soap_locationwwds_4_tfsoaplocid_sels ,
                                           A2164SoapLocBaseUrl ,
                                           AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels ,
                                           A2166SoapLocHost ,
                                           AV69Soap_locationwwds_11_tfsoaplochost_sels ,
                                           A2168SoapLocResourceName ,
                                           AV73Soap_locationwwds_15_tfsoaplocresourcename_sels ,
                                           Integer.valueOf(AV59Soap_locationwwds_1_tfclicod) ,
                                           Integer.valueOf(AV60Soap_locationwwds_2_tfclicod_to) ,
                                           Integer.valueOf(AV62Soap_locationwwds_4_tfsoaplocid_sels.size()) ,
                                           AV61Soap_locationwwds_3_tfsoaplocid ,
                                           Byte.valueOf(AV63Soap_locationwwds_5_tfsoaplochab_sel) ,
                                           Integer.valueOf(AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels.size()) ,
                                           AV64Soap_locationwwds_6_tfsoaplocbaseurl ,
                                           Byte.valueOf(AV66Soap_locationwwds_8_tfsoaploccancelonerror) ,
                                           Byte.valueOf(AV67Soap_locationwwds_9_tfsoaploccancelonerror_to) ,
                                           Integer.valueOf(AV69Soap_locationwwds_11_tfsoaplochost_sels.size()) ,
                                           AV68Soap_locationwwds_10_tfsoaplochost ,
                                           Integer.valueOf(AV70Soap_locationwwds_12_tfsoaplocport) ,
                                           Integer.valueOf(AV71Soap_locationwwds_13_tfsoaplocport_to) ,
                                           Integer.valueOf(AV73Soap_locationwwds_15_tfsoaplocresourcename_sels.size()) ,
                                           AV72Soap_locationwwds_14_tfsoaplocresourcename ,
                                           Byte.valueOf(AV74Soap_locationwwds_16_tfsoaplocsecure) ,
                                           Byte.valueOf(AV75Soap_locationwwds_17_tfsoaplocsecure_to) ,
                                           Short.valueOf(AV76Soap_locationwwds_18_tfsoaploctimeout) ,
                                           Short.valueOf(AV77Soap_locationwwds_19_tfsoaploctimeout_to) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Boolean.valueOf(A2163SoapLocHab) ,
                                           Byte.valueOf(A2165SoapLocCancelOnError) ,
                                           Integer.valueOf(A2167SoapLocPort) ,
                                           Byte.valueOf(A2169SoapLocSecure) ,
                                           Short.valueOf(A2170SoapLocTimeout) ,
                                           Integer.valueOf(AV50CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      lV61Soap_locationwwds_3_tfsoaplocid = GXutil.padr( GXutil.rtrim( AV61Soap_locationwwds_3_tfsoaplocid), 40, "%") ;
      lV64Soap_locationwwds_6_tfsoaplocbaseurl = GXutil.concat( GXutil.rtrim( AV64Soap_locationwwds_6_tfsoaplocbaseurl), "%", "") ;
      lV68Soap_locationwwds_10_tfsoaplochost = GXutil.concat( GXutil.rtrim( AV68Soap_locationwwds_10_tfsoaplochost), "%", "") ;
      lV72Soap_locationwwds_14_tfsoaplocresourcename = GXutil.concat( GXutil.rtrim( AV72Soap_locationwwds_14_tfsoaplocresourcename), "%", "") ;
      /* Using cursor P028Y4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV50CliCod), Integer.valueOf(AV59Soap_locationwwds_1_tfclicod), Integer.valueOf(AV60Soap_locationwwds_2_tfclicod_to), lV61Soap_locationwwds_3_tfsoaplocid, lV64Soap_locationwwds_6_tfsoaplocbaseurl, Byte.valueOf(AV66Soap_locationwwds_8_tfsoaploccancelonerror), Byte.valueOf(AV67Soap_locationwwds_9_tfsoaploccancelonerror_to), lV68Soap_locationwwds_10_tfsoaplochost, Integer.valueOf(AV70Soap_locationwwds_12_tfsoaplocport), Integer.valueOf(AV71Soap_locationwwds_13_tfsoaplocport_to), lV72Soap_locationwwds_14_tfsoaplocresourcename, Byte.valueOf(AV74Soap_locationwwds_16_tfsoaplocsecure), Byte.valueOf(AV75Soap_locationwwds_17_tfsoaplocsecure_to), Short.valueOf(AV76Soap_locationwwds_18_tfsoaploctimeout), Short.valueOf(AV77Soap_locationwwds_19_tfsoaploctimeout_to)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk28Y6 = false ;
         A3CliCod = P028Y4_A3CliCod[0] ;
         A2166SoapLocHost = P028Y4_A2166SoapLocHost[0] ;
         A2170SoapLocTimeout = P028Y4_A2170SoapLocTimeout[0] ;
         A2169SoapLocSecure = P028Y4_A2169SoapLocSecure[0] ;
         A2168SoapLocResourceName = P028Y4_A2168SoapLocResourceName[0] ;
         A2167SoapLocPort = P028Y4_A2167SoapLocPort[0] ;
         A2165SoapLocCancelOnError = P028Y4_A2165SoapLocCancelOnError[0] ;
         A2164SoapLocBaseUrl = P028Y4_A2164SoapLocBaseUrl[0] ;
         A2163SoapLocHab = P028Y4_A2163SoapLocHab[0] ;
         A2162SoapLocId = P028Y4_A2162SoapLocId[0] ;
         AV38count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P028Y4_A2166SoapLocHost[0], A2166SoapLocHost) == 0 ) )
         {
            brk28Y6 = false ;
            A3CliCod = P028Y4_A3CliCod[0] ;
            A2162SoapLocId = P028Y4_A2162SoapLocId[0] ;
            AV38count = (long)(AV38count+1) ;
            brk28Y6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A2166SoapLocHost)==0) )
         {
            AV33Option = A2166SoapLocHost ;
            AV34Options.add(AV33Option, 0);
            AV37OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV38count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV34Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk28Y6 )
         {
            brk28Y6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   public void S151( )
   {
      /* 'LOADSOAPLOCRESOURCENAMEOPTIONS' Routine */
      returnInSub = false ;
      AV26TFSoapLocResourceName = AV45SearchTxt ;
      AV27TFSoapLocResourceName_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV59Soap_locationwwds_1_tfclicod = AV52TFCliCod ;
      AV60Soap_locationwwds_2_tfclicod_to = AV53TFCliCod_To ;
      AV61Soap_locationwwds_3_tfsoaplocid = AV12TFSoapLocId ;
      AV62Soap_locationwwds_4_tfsoaplocid_sels = AV13TFSoapLocId_Sels ;
      AV63Soap_locationwwds_5_tfsoaplochab_sel = AV14TFSoapLocHab_Sel ;
      AV64Soap_locationwwds_6_tfsoaplocbaseurl = AV16TFSoapLocBaseUrl ;
      AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels = AV17TFSoapLocBaseUrl_Sels ;
      AV66Soap_locationwwds_8_tfsoaploccancelonerror = AV18TFSoapLocCancelOnError ;
      AV67Soap_locationwwds_9_tfsoaploccancelonerror_to = AV19TFSoapLocCancelOnError_To ;
      AV68Soap_locationwwds_10_tfsoaplochost = AV21TFSoapLocHost ;
      AV69Soap_locationwwds_11_tfsoaplochost_sels = AV22TFSoapLocHost_Sels ;
      AV70Soap_locationwwds_12_tfsoaplocport = AV23TFSoapLocPort ;
      AV71Soap_locationwwds_13_tfsoaplocport_to = AV24TFSoapLocPort_To ;
      AV72Soap_locationwwds_14_tfsoaplocresourcename = AV26TFSoapLocResourceName ;
      AV73Soap_locationwwds_15_tfsoaplocresourcename_sels = AV27TFSoapLocResourceName_Sels ;
      AV74Soap_locationwwds_16_tfsoaplocsecure = AV28TFSoapLocSecure ;
      AV75Soap_locationwwds_17_tfsoaplocsecure_to = AV29TFSoapLocSecure_To ;
      AV76Soap_locationwwds_18_tfsoaploctimeout = AV30TFSoapLocTimeout ;
      AV77Soap_locationwwds_19_tfsoaploctimeout_to = AV31TFSoapLocTimeout_To ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           A2162SoapLocId ,
                                           AV62Soap_locationwwds_4_tfsoaplocid_sels ,
                                           A2164SoapLocBaseUrl ,
                                           AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels ,
                                           A2166SoapLocHost ,
                                           AV69Soap_locationwwds_11_tfsoaplochost_sels ,
                                           A2168SoapLocResourceName ,
                                           AV73Soap_locationwwds_15_tfsoaplocresourcename_sels ,
                                           Integer.valueOf(AV59Soap_locationwwds_1_tfclicod) ,
                                           Integer.valueOf(AV60Soap_locationwwds_2_tfclicod_to) ,
                                           Integer.valueOf(AV62Soap_locationwwds_4_tfsoaplocid_sels.size()) ,
                                           AV61Soap_locationwwds_3_tfsoaplocid ,
                                           Byte.valueOf(AV63Soap_locationwwds_5_tfsoaplochab_sel) ,
                                           Integer.valueOf(AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels.size()) ,
                                           AV64Soap_locationwwds_6_tfsoaplocbaseurl ,
                                           Byte.valueOf(AV66Soap_locationwwds_8_tfsoaploccancelonerror) ,
                                           Byte.valueOf(AV67Soap_locationwwds_9_tfsoaploccancelonerror_to) ,
                                           Integer.valueOf(AV69Soap_locationwwds_11_tfsoaplochost_sels.size()) ,
                                           AV68Soap_locationwwds_10_tfsoaplochost ,
                                           Integer.valueOf(AV70Soap_locationwwds_12_tfsoaplocport) ,
                                           Integer.valueOf(AV71Soap_locationwwds_13_tfsoaplocport_to) ,
                                           Integer.valueOf(AV73Soap_locationwwds_15_tfsoaplocresourcename_sels.size()) ,
                                           AV72Soap_locationwwds_14_tfsoaplocresourcename ,
                                           Byte.valueOf(AV74Soap_locationwwds_16_tfsoaplocsecure) ,
                                           Byte.valueOf(AV75Soap_locationwwds_17_tfsoaplocsecure_to) ,
                                           Short.valueOf(AV76Soap_locationwwds_18_tfsoaploctimeout) ,
                                           Short.valueOf(AV77Soap_locationwwds_19_tfsoaploctimeout_to) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Boolean.valueOf(A2163SoapLocHab) ,
                                           Byte.valueOf(A2165SoapLocCancelOnError) ,
                                           Integer.valueOf(A2167SoapLocPort) ,
                                           Byte.valueOf(A2169SoapLocSecure) ,
                                           Short.valueOf(A2170SoapLocTimeout) ,
                                           Integer.valueOf(AV50CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      lV61Soap_locationwwds_3_tfsoaplocid = GXutil.padr( GXutil.rtrim( AV61Soap_locationwwds_3_tfsoaplocid), 40, "%") ;
      lV64Soap_locationwwds_6_tfsoaplocbaseurl = GXutil.concat( GXutil.rtrim( AV64Soap_locationwwds_6_tfsoaplocbaseurl), "%", "") ;
      lV68Soap_locationwwds_10_tfsoaplochost = GXutil.concat( GXutil.rtrim( AV68Soap_locationwwds_10_tfsoaplochost), "%", "") ;
      lV72Soap_locationwwds_14_tfsoaplocresourcename = GXutil.concat( GXutil.rtrim( AV72Soap_locationwwds_14_tfsoaplocresourcename), "%", "") ;
      /* Using cursor P028Y5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV50CliCod), Integer.valueOf(AV59Soap_locationwwds_1_tfclicod), Integer.valueOf(AV60Soap_locationwwds_2_tfclicod_to), lV61Soap_locationwwds_3_tfsoaplocid, lV64Soap_locationwwds_6_tfsoaplocbaseurl, Byte.valueOf(AV66Soap_locationwwds_8_tfsoaploccancelonerror), Byte.valueOf(AV67Soap_locationwwds_9_tfsoaploccancelonerror_to), lV68Soap_locationwwds_10_tfsoaplochost, Integer.valueOf(AV70Soap_locationwwds_12_tfsoaplocport), Integer.valueOf(AV71Soap_locationwwds_13_tfsoaplocport_to), lV72Soap_locationwwds_14_tfsoaplocresourcename, Byte.valueOf(AV74Soap_locationwwds_16_tfsoaplocsecure), Byte.valueOf(AV75Soap_locationwwds_17_tfsoaplocsecure_to), Short.valueOf(AV76Soap_locationwwds_18_tfsoaploctimeout), Short.valueOf(AV77Soap_locationwwds_19_tfsoaploctimeout_to)});
      while ( (pr_default.getStatus(3) != 101) )
      {
         brk28Y8 = false ;
         A3CliCod = P028Y5_A3CliCod[0] ;
         A2168SoapLocResourceName = P028Y5_A2168SoapLocResourceName[0] ;
         A2170SoapLocTimeout = P028Y5_A2170SoapLocTimeout[0] ;
         A2169SoapLocSecure = P028Y5_A2169SoapLocSecure[0] ;
         A2167SoapLocPort = P028Y5_A2167SoapLocPort[0] ;
         A2166SoapLocHost = P028Y5_A2166SoapLocHost[0] ;
         A2165SoapLocCancelOnError = P028Y5_A2165SoapLocCancelOnError[0] ;
         A2164SoapLocBaseUrl = P028Y5_A2164SoapLocBaseUrl[0] ;
         A2163SoapLocHab = P028Y5_A2163SoapLocHab[0] ;
         A2162SoapLocId = P028Y5_A2162SoapLocId[0] ;
         AV38count = 0 ;
         while ( (pr_default.getStatus(3) != 101) && ( GXutil.strcmp(P028Y5_A2168SoapLocResourceName[0], A2168SoapLocResourceName) == 0 ) )
         {
            brk28Y8 = false ;
            A3CliCod = P028Y5_A3CliCod[0] ;
            A2162SoapLocId = P028Y5_A2162SoapLocId[0] ;
            AV38count = (long)(AV38count+1) ;
            brk28Y8 = true ;
            pr_default.readNext(3);
         }
         if ( ! (GXutil.strcmp("", A2168SoapLocResourceName)==0) )
         {
            AV33Option = A2168SoapLocResourceName ;
            AV34Options.add(AV33Option, 0);
            AV37OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV38count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV34Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk28Y8 )
         {
            brk28Y8 = true ;
            pr_default.readNext(3);
         }
      }
      pr_default.close(3);
   }

   protected void cleanup( )
   {
      this.aP3[0] = soap_locationwwgetfilterdata.this.AV47OptionsJson;
      this.aP4[0] = soap_locationwwgetfilterdata.this.AV48OptionsDescJson;
      this.aP5[0] = soap_locationwwgetfilterdata.this.AV49OptionIndexesJson;
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
      AV48OptionsDescJson = "" ;
      AV49OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV34Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV36OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV37OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV39Session = httpContext.getWebSession();
      AV41GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV42GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV12TFSoapLocId = "" ;
      AV11TFSoapLocId_SelsJson = "" ;
      AV13TFSoapLocId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV16TFSoapLocBaseUrl = "" ;
      AV15TFSoapLocBaseUrl_SelsJson = "" ;
      AV17TFSoapLocBaseUrl_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV21TFSoapLocHost = "" ;
      AV20TFSoapLocHost_SelsJson = "" ;
      AV22TFSoapLocHost_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV26TFSoapLocResourceName = "" ;
      AV25TFSoapLocResourceName_SelsJson = "" ;
      AV27TFSoapLocResourceName_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV54MenuOpcCod = "" ;
      A2162SoapLocId = "" ;
      AV61Soap_locationwwds_3_tfsoaplocid = "" ;
      AV62Soap_locationwwds_4_tfsoaplocid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV64Soap_locationwwds_6_tfsoaplocbaseurl = "" ;
      AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV68Soap_locationwwds_10_tfsoaplochost = "" ;
      AV69Soap_locationwwds_11_tfsoaplochost_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV72Soap_locationwwds_14_tfsoaplocresourcename = "" ;
      AV73Soap_locationwwds_15_tfsoaplocresourcename_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV61Soap_locationwwds_3_tfsoaplocid = "" ;
      lV64Soap_locationwwds_6_tfsoaplocbaseurl = "" ;
      lV68Soap_locationwwds_10_tfsoaplochost = "" ;
      lV72Soap_locationwwds_14_tfsoaplocresourcename = "" ;
      A2164SoapLocBaseUrl = "" ;
      A2166SoapLocHost = "" ;
      A2168SoapLocResourceName = "" ;
      P028Y2_A3CliCod = new int[1] ;
      P028Y2_A2162SoapLocId = new String[] {""} ;
      P028Y2_A2170SoapLocTimeout = new short[1] ;
      P028Y2_A2169SoapLocSecure = new byte[1] ;
      P028Y2_A2168SoapLocResourceName = new String[] {""} ;
      P028Y2_A2167SoapLocPort = new int[1] ;
      P028Y2_A2166SoapLocHost = new String[] {""} ;
      P028Y2_A2165SoapLocCancelOnError = new byte[1] ;
      P028Y2_A2164SoapLocBaseUrl = new String[] {""} ;
      P028Y2_A2163SoapLocHab = new boolean[] {false} ;
      AV33Option = "" ;
      P028Y3_A3CliCod = new int[1] ;
      P028Y3_A2164SoapLocBaseUrl = new String[] {""} ;
      P028Y3_A2170SoapLocTimeout = new short[1] ;
      P028Y3_A2169SoapLocSecure = new byte[1] ;
      P028Y3_A2168SoapLocResourceName = new String[] {""} ;
      P028Y3_A2167SoapLocPort = new int[1] ;
      P028Y3_A2166SoapLocHost = new String[] {""} ;
      P028Y3_A2165SoapLocCancelOnError = new byte[1] ;
      P028Y3_A2163SoapLocHab = new boolean[] {false} ;
      P028Y3_A2162SoapLocId = new String[] {""} ;
      P028Y4_A3CliCod = new int[1] ;
      P028Y4_A2166SoapLocHost = new String[] {""} ;
      P028Y4_A2170SoapLocTimeout = new short[1] ;
      P028Y4_A2169SoapLocSecure = new byte[1] ;
      P028Y4_A2168SoapLocResourceName = new String[] {""} ;
      P028Y4_A2167SoapLocPort = new int[1] ;
      P028Y4_A2165SoapLocCancelOnError = new byte[1] ;
      P028Y4_A2164SoapLocBaseUrl = new String[] {""} ;
      P028Y4_A2163SoapLocHab = new boolean[] {false} ;
      P028Y4_A2162SoapLocId = new String[] {""} ;
      P028Y5_A3CliCod = new int[1] ;
      P028Y5_A2168SoapLocResourceName = new String[] {""} ;
      P028Y5_A2170SoapLocTimeout = new short[1] ;
      P028Y5_A2169SoapLocSecure = new byte[1] ;
      P028Y5_A2167SoapLocPort = new int[1] ;
      P028Y5_A2166SoapLocHost = new String[] {""} ;
      P028Y5_A2165SoapLocCancelOnError = new byte[1] ;
      P028Y5_A2164SoapLocBaseUrl = new String[] {""} ;
      P028Y5_A2163SoapLocHab = new boolean[] {false} ;
      P028Y5_A2162SoapLocId = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.soap_locationwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P028Y2_A3CliCod, P028Y2_A2162SoapLocId, P028Y2_A2170SoapLocTimeout, P028Y2_A2169SoapLocSecure, P028Y2_A2168SoapLocResourceName, P028Y2_A2167SoapLocPort, P028Y2_A2166SoapLocHost, P028Y2_A2165SoapLocCancelOnError, P028Y2_A2164SoapLocBaseUrl, P028Y2_A2163SoapLocHab
            }
            , new Object[] {
            P028Y3_A3CliCod, P028Y3_A2164SoapLocBaseUrl, P028Y3_A2170SoapLocTimeout, P028Y3_A2169SoapLocSecure, P028Y3_A2168SoapLocResourceName, P028Y3_A2167SoapLocPort, P028Y3_A2166SoapLocHost, P028Y3_A2165SoapLocCancelOnError, P028Y3_A2163SoapLocHab, P028Y3_A2162SoapLocId
            }
            , new Object[] {
            P028Y4_A3CliCod, P028Y4_A2166SoapLocHost, P028Y4_A2170SoapLocTimeout, P028Y4_A2169SoapLocSecure, P028Y4_A2168SoapLocResourceName, P028Y4_A2167SoapLocPort, P028Y4_A2165SoapLocCancelOnError, P028Y4_A2164SoapLocBaseUrl, P028Y4_A2163SoapLocHab, P028Y4_A2162SoapLocId
            }
            , new Object[] {
            P028Y5_A3CliCod, P028Y5_A2168SoapLocResourceName, P028Y5_A2170SoapLocTimeout, P028Y5_A2169SoapLocSecure, P028Y5_A2167SoapLocPort, P028Y5_A2166SoapLocHost, P028Y5_A2165SoapLocCancelOnError, P028Y5_A2164SoapLocBaseUrl, P028Y5_A2163SoapLocHab, P028Y5_A2162SoapLocId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV14TFSoapLocHab_Sel ;
   private byte AV18TFSoapLocCancelOnError ;
   private byte AV19TFSoapLocCancelOnError_To ;
   private byte AV28TFSoapLocSecure ;
   private byte AV29TFSoapLocSecure_To ;
   private byte AV63Soap_locationwwds_5_tfsoaplochab_sel ;
   private byte AV66Soap_locationwwds_8_tfsoaploccancelonerror ;
   private byte AV67Soap_locationwwds_9_tfsoaploccancelonerror_to ;
   private byte AV74Soap_locationwwds_16_tfsoaplocsecure ;
   private byte AV75Soap_locationwwds_17_tfsoaplocsecure_to ;
   private byte A2165SoapLocCancelOnError ;
   private byte A2169SoapLocSecure ;
   private short AV51EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV30TFSoapLocTimeout ;
   private short AV31TFSoapLocTimeout_To ;
   private short AV76Soap_locationwwds_18_tfsoaploctimeout ;
   private short AV77Soap_locationwwds_19_tfsoaploctimeout_to ;
   private short A2170SoapLocTimeout ;
   private short Gx_err ;
   private int AV50CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV57GXV1 ;
   private int AV52TFCliCod ;
   private int AV53TFCliCod_To ;
   private int AV23TFSoapLocPort ;
   private int AV24TFSoapLocPort_To ;
   private int AV59Soap_locationwwds_1_tfclicod ;
   private int AV60Soap_locationwwds_2_tfclicod_to ;
   private int AV70Soap_locationwwds_12_tfsoaplocport ;
   private int AV71Soap_locationwwds_13_tfsoaplocport_to ;
   private int AV62Soap_locationwwds_4_tfsoaplocid_sels_size ;
   private int AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels_size ;
   private int AV69Soap_locationwwds_11_tfsoaplochost_sels_size ;
   private int AV73Soap_locationwwds_15_tfsoaplocresourcename_sels_size ;
   private int A3CliCod ;
   private int A2167SoapLocPort ;
   private long AV38count ;
   private String AV12TFSoapLocId ;
   private String A2162SoapLocId ;
   private String AV61Soap_locationwwds_3_tfsoaplocid ;
   private String scmdbuf ;
   private String lV61Soap_locationwwds_3_tfsoaplocid ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean A2163SoapLocHab ;
   private boolean brk28Y2 ;
   private boolean brk28Y4 ;
   private boolean brk28Y6 ;
   private boolean brk28Y8 ;
   private String AV47OptionsJson ;
   private String AV48OptionsDescJson ;
   private String AV49OptionIndexesJson ;
   private String AV11TFSoapLocId_SelsJson ;
   private String AV15TFSoapLocBaseUrl_SelsJson ;
   private String AV20TFSoapLocHost_SelsJson ;
   private String AV25TFSoapLocResourceName_SelsJson ;
   private String AV44DDOName ;
   private String AV45SearchTxt ;
   private String AV46SearchTxtTo ;
   private String AV16TFSoapLocBaseUrl ;
   private String AV21TFSoapLocHost ;
   private String AV26TFSoapLocResourceName ;
   private String AV54MenuOpcCod ;
   private String AV64Soap_locationwwds_6_tfsoaplocbaseurl ;
   private String AV68Soap_locationwwds_10_tfsoaplochost ;
   private String AV72Soap_locationwwds_14_tfsoaplocresourcename ;
   private String lV64Soap_locationwwds_6_tfsoaplocbaseurl ;
   private String lV68Soap_locationwwds_10_tfsoaplochost ;
   private String lV72Soap_locationwwds_14_tfsoaplocresourcename ;
   private String A2164SoapLocBaseUrl ;
   private String A2166SoapLocHost ;
   private String A2168SoapLocResourceName ;
   private String AV33Option ;
   private com.genexus.webpanels.WebSession AV39Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P028Y2_A3CliCod ;
   private String[] P028Y2_A2162SoapLocId ;
   private short[] P028Y2_A2170SoapLocTimeout ;
   private byte[] P028Y2_A2169SoapLocSecure ;
   private String[] P028Y2_A2168SoapLocResourceName ;
   private int[] P028Y2_A2167SoapLocPort ;
   private String[] P028Y2_A2166SoapLocHost ;
   private byte[] P028Y2_A2165SoapLocCancelOnError ;
   private String[] P028Y2_A2164SoapLocBaseUrl ;
   private boolean[] P028Y2_A2163SoapLocHab ;
   private int[] P028Y3_A3CliCod ;
   private String[] P028Y3_A2164SoapLocBaseUrl ;
   private short[] P028Y3_A2170SoapLocTimeout ;
   private byte[] P028Y3_A2169SoapLocSecure ;
   private String[] P028Y3_A2168SoapLocResourceName ;
   private int[] P028Y3_A2167SoapLocPort ;
   private String[] P028Y3_A2166SoapLocHost ;
   private byte[] P028Y3_A2165SoapLocCancelOnError ;
   private boolean[] P028Y3_A2163SoapLocHab ;
   private String[] P028Y3_A2162SoapLocId ;
   private int[] P028Y4_A3CliCod ;
   private String[] P028Y4_A2166SoapLocHost ;
   private short[] P028Y4_A2170SoapLocTimeout ;
   private byte[] P028Y4_A2169SoapLocSecure ;
   private String[] P028Y4_A2168SoapLocResourceName ;
   private int[] P028Y4_A2167SoapLocPort ;
   private byte[] P028Y4_A2165SoapLocCancelOnError ;
   private String[] P028Y4_A2164SoapLocBaseUrl ;
   private boolean[] P028Y4_A2163SoapLocHab ;
   private String[] P028Y4_A2162SoapLocId ;
   private int[] P028Y5_A3CliCod ;
   private String[] P028Y5_A2168SoapLocResourceName ;
   private short[] P028Y5_A2170SoapLocTimeout ;
   private byte[] P028Y5_A2169SoapLocSecure ;
   private int[] P028Y5_A2167SoapLocPort ;
   private String[] P028Y5_A2166SoapLocHost ;
   private byte[] P028Y5_A2165SoapLocCancelOnError ;
   private String[] P028Y5_A2164SoapLocBaseUrl ;
   private boolean[] P028Y5_A2163SoapLocHab ;
   private String[] P028Y5_A2162SoapLocId ;
   private GXSimpleCollection<String> AV13TFSoapLocId_Sels ;
   private GXSimpleCollection<String> AV62Soap_locationwwds_4_tfsoaplocid_sels ;
   private GXSimpleCollection<String> AV34Options ;
   private GXSimpleCollection<String> AV36OptionsDesc ;
   private GXSimpleCollection<String> AV37OptionIndexes ;
   private GXSimpleCollection<String> AV17TFSoapLocBaseUrl_Sels ;
   private GXSimpleCollection<String> AV22TFSoapLocHost_Sels ;
   private GXSimpleCollection<String> AV27TFSoapLocResourceName_Sels ;
   private GXSimpleCollection<String> AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels ;
   private GXSimpleCollection<String> AV69Soap_locationwwds_11_tfsoaplochost_sels ;
   private GXSimpleCollection<String> AV73Soap_locationwwds_15_tfsoaplocresourcename_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV41GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV42GridStateFilterValue ;
}

final  class soap_locationwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P028Y2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2162SoapLocId ,
                                          GXSimpleCollection<String> AV62Soap_locationwwds_4_tfsoaplocid_sels ,
                                          String A2164SoapLocBaseUrl ,
                                          GXSimpleCollection<String> AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels ,
                                          String A2166SoapLocHost ,
                                          GXSimpleCollection<String> AV69Soap_locationwwds_11_tfsoaplochost_sels ,
                                          String A2168SoapLocResourceName ,
                                          GXSimpleCollection<String> AV73Soap_locationwwds_15_tfsoaplocresourcename_sels ,
                                          int AV59Soap_locationwwds_1_tfclicod ,
                                          int AV60Soap_locationwwds_2_tfclicod_to ,
                                          int AV62Soap_locationwwds_4_tfsoaplocid_sels_size ,
                                          String AV61Soap_locationwwds_3_tfsoaplocid ,
                                          byte AV63Soap_locationwwds_5_tfsoaplochab_sel ,
                                          int AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels_size ,
                                          String AV64Soap_locationwwds_6_tfsoaplocbaseurl ,
                                          byte AV66Soap_locationwwds_8_tfsoaploccancelonerror ,
                                          byte AV67Soap_locationwwds_9_tfsoaploccancelonerror_to ,
                                          int AV69Soap_locationwwds_11_tfsoaplochost_sels_size ,
                                          String AV68Soap_locationwwds_10_tfsoaplochost ,
                                          int AV70Soap_locationwwds_12_tfsoaplocport ,
                                          int AV71Soap_locationwwds_13_tfsoaplocport_to ,
                                          int AV73Soap_locationwwds_15_tfsoaplocresourcename_sels_size ,
                                          String AV72Soap_locationwwds_14_tfsoaplocresourcename ,
                                          byte AV74Soap_locationwwds_16_tfsoaplocsecure ,
                                          byte AV75Soap_locationwwds_17_tfsoaplocsecure_to ,
                                          short AV76Soap_locationwwds_18_tfsoaploctimeout ,
                                          short AV77Soap_locationwwds_19_tfsoaploctimeout_to ,
                                          int A3CliCod ,
                                          boolean A2163SoapLocHab ,
                                          byte A2165SoapLocCancelOnError ,
                                          int A2167SoapLocPort ,
                                          byte A2169SoapLocSecure ,
                                          short A2170SoapLocTimeout ,
                                          int AV50CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[15];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliCod, SoapLocId, SoapLocTimeout, SoapLocSecure, SoapLocResourceName, SoapLocPort, SoapLocHost, SoapLocCancelOnError, SoapLocBaseUrl, SoapLocHab FROM soap_location" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV59Soap_locationwwds_1_tfclicod) )
      {
         addWhere(sWhereString, "(CliCod >= ?)");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( ! (0==AV60Soap_locationwwds_2_tfclicod_to) )
      {
         addWhere(sWhereString, "(CliCod <= ?)");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( ( AV62Soap_locationwwds_4_tfsoaplocid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV61Soap_locationwwds_3_tfsoaplocid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SoapLocId) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV62Soap_locationwwds_4_tfsoaplocid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV62Soap_locationwwds_4_tfsoaplocid_sels, "SoapLocId IN (", ")")+")");
      }
      if ( AV63Soap_locationwwds_5_tfsoaplochab_sel == 1 )
      {
         addWhere(sWhereString, "(SoapLocHab = TRUE)");
      }
      if ( AV63Soap_locationwwds_5_tfsoaplochab_sel == 2 )
      {
         addWhere(sWhereString, "(SoapLocHab = FALSE)");
      }
      if ( ( AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV64Soap_locationwwds_6_tfsoaplocbaseurl)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SoapLocBaseUrl) like LOWER(?))");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels, "SoapLocBaseUrl IN (", ")")+")");
      }
      if ( ! (0==AV66Soap_locationwwds_8_tfsoaploccancelonerror) )
      {
         addWhere(sWhereString, "(SoapLocCancelOnError >= ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( ! (0==AV67Soap_locationwwds_9_tfsoaploccancelonerror_to) )
      {
         addWhere(sWhereString, "(SoapLocCancelOnError <= ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( ( AV69Soap_locationwwds_11_tfsoaplochost_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV68Soap_locationwwds_10_tfsoaplochost)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SoapLocHost) like LOWER(?))");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( AV69Soap_locationwwds_11_tfsoaplochost_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69Soap_locationwwds_11_tfsoaplochost_sels, "SoapLocHost IN (", ")")+")");
      }
      if ( ! (0==AV70Soap_locationwwds_12_tfsoaplocport) )
      {
         addWhere(sWhereString, "(SoapLocPort >= ?)");
      }
      else
      {
         GXv_int8[8] = (byte)(1) ;
      }
      if ( ! (0==AV71Soap_locationwwds_13_tfsoaplocport_to) )
      {
         addWhere(sWhereString, "(SoapLocPort <= ?)");
      }
      else
      {
         GXv_int8[9] = (byte)(1) ;
      }
      if ( ( AV73Soap_locationwwds_15_tfsoaplocresourcename_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV72Soap_locationwwds_14_tfsoaplocresourcename)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SoapLocResourceName) like LOWER(?))");
      }
      else
      {
         GXv_int8[10] = (byte)(1) ;
      }
      if ( AV73Soap_locationwwds_15_tfsoaplocresourcename_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV73Soap_locationwwds_15_tfsoaplocresourcename_sels, "SoapLocResourceName IN (", ")")+")");
      }
      if ( ! (0==AV74Soap_locationwwds_16_tfsoaplocsecure) )
      {
         addWhere(sWhereString, "(SoapLocSecure >= ?)");
      }
      else
      {
         GXv_int8[11] = (byte)(1) ;
      }
      if ( ! (0==AV75Soap_locationwwds_17_tfsoaplocsecure_to) )
      {
         addWhere(sWhereString, "(SoapLocSecure <= ?)");
      }
      else
      {
         GXv_int8[12] = (byte)(1) ;
      }
      if ( ! (0==AV76Soap_locationwwds_18_tfsoaploctimeout) )
      {
         addWhere(sWhereString, "(SoapLocTimeout >= ?)");
      }
      else
      {
         GXv_int8[13] = (byte)(1) ;
      }
      if ( ! (0==AV77Soap_locationwwds_19_tfsoaploctimeout_to) )
      {
         addWhere(sWhereString, "(SoapLocTimeout <= ?)");
      }
      else
      {
         GXv_int8[14] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, SoapLocId" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P028Y3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2162SoapLocId ,
                                          GXSimpleCollection<String> AV62Soap_locationwwds_4_tfsoaplocid_sels ,
                                          String A2164SoapLocBaseUrl ,
                                          GXSimpleCollection<String> AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels ,
                                          String A2166SoapLocHost ,
                                          GXSimpleCollection<String> AV69Soap_locationwwds_11_tfsoaplochost_sels ,
                                          String A2168SoapLocResourceName ,
                                          GXSimpleCollection<String> AV73Soap_locationwwds_15_tfsoaplocresourcename_sels ,
                                          int AV59Soap_locationwwds_1_tfclicod ,
                                          int AV60Soap_locationwwds_2_tfclicod_to ,
                                          int AV62Soap_locationwwds_4_tfsoaplocid_sels_size ,
                                          String AV61Soap_locationwwds_3_tfsoaplocid ,
                                          byte AV63Soap_locationwwds_5_tfsoaplochab_sel ,
                                          int AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels_size ,
                                          String AV64Soap_locationwwds_6_tfsoaplocbaseurl ,
                                          byte AV66Soap_locationwwds_8_tfsoaploccancelonerror ,
                                          byte AV67Soap_locationwwds_9_tfsoaploccancelonerror_to ,
                                          int AV69Soap_locationwwds_11_tfsoaplochost_sels_size ,
                                          String AV68Soap_locationwwds_10_tfsoaplochost ,
                                          int AV70Soap_locationwwds_12_tfsoaplocport ,
                                          int AV71Soap_locationwwds_13_tfsoaplocport_to ,
                                          int AV73Soap_locationwwds_15_tfsoaplocresourcename_sels_size ,
                                          String AV72Soap_locationwwds_14_tfsoaplocresourcename ,
                                          byte AV74Soap_locationwwds_16_tfsoaplocsecure ,
                                          byte AV75Soap_locationwwds_17_tfsoaplocsecure_to ,
                                          short AV76Soap_locationwwds_18_tfsoaploctimeout ,
                                          short AV77Soap_locationwwds_19_tfsoaploctimeout_to ,
                                          int A3CliCod ,
                                          boolean A2163SoapLocHab ,
                                          byte A2165SoapLocCancelOnError ,
                                          int A2167SoapLocPort ,
                                          byte A2169SoapLocSecure ,
                                          short A2170SoapLocTimeout ,
                                          int AV50CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[15];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT CliCod, SoapLocBaseUrl, SoapLocTimeout, SoapLocSecure, SoapLocResourceName, SoapLocPort, SoapLocHost, SoapLocCancelOnError, SoapLocHab, SoapLocId FROM soap_location" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV59Soap_locationwwds_1_tfclicod) )
      {
         addWhere(sWhereString, "(CliCod >= ?)");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( ! (0==AV60Soap_locationwwds_2_tfclicod_to) )
      {
         addWhere(sWhereString, "(CliCod <= ?)");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( ( AV62Soap_locationwwds_4_tfsoaplocid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV61Soap_locationwwds_3_tfsoaplocid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SoapLocId) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV62Soap_locationwwds_4_tfsoaplocid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV62Soap_locationwwds_4_tfsoaplocid_sels, "SoapLocId IN (", ")")+")");
      }
      if ( AV63Soap_locationwwds_5_tfsoaplochab_sel == 1 )
      {
         addWhere(sWhereString, "(SoapLocHab = TRUE)");
      }
      if ( AV63Soap_locationwwds_5_tfsoaplochab_sel == 2 )
      {
         addWhere(sWhereString, "(SoapLocHab = FALSE)");
      }
      if ( ( AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV64Soap_locationwwds_6_tfsoaplocbaseurl)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SoapLocBaseUrl) like LOWER(?))");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels, "SoapLocBaseUrl IN (", ")")+")");
      }
      if ( ! (0==AV66Soap_locationwwds_8_tfsoaploccancelonerror) )
      {
         addWhere(sWhereString, "(SoapLocCancelOnError >= ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( ! (0==AV67Soap_locationwwds_9_tfsoaploccancelonerror_to) )
      {
         addWhere(sWhereString, "(SoapLocCancelOnError <= ?)");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( ( AV69Soap_locationwwds_11_tfsoaplochost_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV68Soap_locationwwds_10_tfsoaplochost)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SoapLocHost) like LOWER(?))");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( AV69Soap_locationwwds_11_tfsoaplochost_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69Soap_locationwwds_11_tfsoaplochost_sels, "SoapLocHost IN (", ")")+")");
      }
      if ( ! (0==AV70Soap_locationwwds_12_tfsoaplocport) )
      {
         addWhere(sWhereString, "(SoapLocPort >= ?)");
      }
      else
      {
         GXv_int11[8] = (byte)(1) ;
      }
      if ( ! (0==AV71Soap_locationwwds_13_tfsoaplocport_to) )
      {
         addWhere(sWhereString, "(SoapLocPort <= ?)");
      }
      else
      {
         GXv_int11[9] = (byte)(1) ;
      }
      if ( ( AV73Soap_locationwwds_15_tfsoaplocresourcename_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV72Soap_locationwwds_14_tfsoaplocresourcename)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SoapLocResourceName) like LOWER(?))");
      }
      else
      {
         GXv_int11[10] = (byte)(1) ;
      }
      if ( AV73Soap_locationwwds_15_tfsoaplocresourcename_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV73Soap_locationwwds_15_tfsoaplocresourcename_sels, "SoapLocResourceName IN (", ")")+")");
      }
      if ( ! (0==AV74Soap_locationwwds_16_tfsoaplocsecure) )
      {
         addWhere(sWhereString, "(SoapLocSecure >= ?)");
      }
      else
      {
         GXv_int11[11] = (byte)(1) ;
      }
      if ( ! (0==AV75Soap_locationwwds_17_tfsoaplocsecure_to) )
      {
         addWhere(sWhereString, "(SoapLocSecure <= ?)");
      }
      else
      {
         GXv_int11[12] = (byte)(1) ;
      }
      if ( ! (0==AV76Soap_locationwwds_18_tfsoaploctimeout) )
      {
         addWhere(sWhereString, "(SoapLocTimeout >= ?)");
      }
      else
      {
         GXv_int11[13] = (byte)(1) ;
      }
      if ( ! (0==AV77Soap_locationwwds_19_tfsoaploctimeout_to) )
      {
         addWhere(sWhereString, "(SoapLocTimeout <= ?)");
      }
      else
      {
         GXv_int11[14] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY SoapLocBaseUrl" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P028Y4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2162SoapLocId ,
                                          GXSimpleCollection<String> AV62Soap_locationwwds_4_tfsoaplocid_sels ,
                                          String A2164SoapLocBaseUrl ,
                                          GXSimpleCollection<String> AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels ,
                                          String A2166SoapLocHost ,
                                          GXSimpleCollection<String> AV69Soap_locationwwds_11_tfsoaplochost_sels ,
                                          String A2168SoapLocResourceName ,
                                          GXSimpleCollection<String> AV73Soap_locationwwds_15_tfsoaplocresourcename_sels ,
                                          int AV59Soap_locationwwds_1_tfclicod ,
                                          int AV60Soap_locationwwds_2_tfclicod_to ,
                                          int AV62Soap_locationwwds_4_tfsoaplocid_sels_size ,
                                          String AV61Soap_locationwwds_3_tfsoaplocid ,
                                          byte AV63Soap_locationwwds_5_tfsoaplochab_sel ,
                                          int AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels_size ,
                                          String AV64Soap_locationwwds_6_tfsoaplocbaseurl ,
                                          byte AV66Soap_locationwwds_8_tfsoaploccancelonerror ,
                                          byte AV67Soap_locationwwds_9_tfsoaploccancelonerror_to ,
                                          int AV69Soap_locationwwds_11_tfsoaplochost_sels_size ,
                                          String AV68Soap_locationwwds_10_tfsoaplochost ,
                                          int AV70Soap_locationwwds_12_tfsoaplocport ,
                                          int AV71Soap_locationwwds_13_tfsoaplocport_to ,
                                          int AV73Soap_locationwwds_15_tfsoaplocresourcename_sels_size ,
                                          String AV72Soap_locationwwds_14_tfsoaplocresourcename ,
                                          byte AV74Soap_locationwwds_16_tfsoaplocsecure ,
                                          byte AV75Soap_locationwwds_17_tfsoaplocsecure_to ,
                                          short AV76Soap_locationwwds_18_tfsoaploctimeout ,
                                          short AV77Soap_locationwwds_19_tfsoaploctimeout_to ,
                                          int A3CliCod ,
                                          boolean A2163SoapLocHab ,
                                          byte A2165SoapLocCancelOnError ,
                                          int A2167SoapLocPort ,
                                          byte A2169SoapLocSecure ,
                                          short A2170SoapLocTimeout ,
                                          int AV50CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[15];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT CliCod, SoapLocHost, SoapLocTimeout, SoapLocSecure, SoapLocResourceName, SoapLocPort, SoapLocCancelOnError, SoapLocBaseUrl, SoapLocHab, SoapLocId FROM soap_location" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV59Soap_locationwwds_1_tfclicod) )
      {
         addWhere(sWhereString, "(CliCod >= ?)");
      }
      else
      {
         GXv_int14[1] = (byte)(1) ;
      }
      if ( ! (0==AV60Soap_locationwwds_2_tfclicod_to) )
      {
         addWhere(sWhereString, "(CliCod <= ?)");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( ( AV62Soap_locationwwds_4_tfsoaplocid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV61Soap_locationwwds_3_tfsoaplocid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SoapLocId) like LOWER(?))");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( AV62Soap_locationwwds_4_tfsoaplocid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV62Soap_locationwwds_4_tfsoaplocid_sels, "SoapLocId IN (", ")")+")");
      }
      if ( AV63Soap_locationwwds_5_tfsoaplochab_sel == 1 )
      {
         addWhere(sWhereString, "(SoapLocHab = TRUE)");
      }
      if ( AV63Soap_locationwwds_5_tfsoaplochab_sel == 2 )
      {
         addWhere(sWhereString, "(SoapLocHab = FALSE)");
      }
      if ( ( AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV64Soap_locationwwds_6_tfsoaplocbaseurl)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SoapLocBaseUrl) like LOWER(?))");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels, "SoapLocBaseUrl IN (", ")")+")");
      }
      if ( ! (0==AV66Soap_locationwwds_8_tfsoaploccancelonerror) )
      {
         addWhere(sWhereString, "(SoapLocCancelOnError >= ?)");
      }
      else
      {
         GXv_int14[5] = (byte)(1) ;
      }
      if ( ! (0==AV67Soap_locationwwds_9_tfsoaploccancelonerror_to) )
      {
         addWhere(sWhereString, "(SoapLocCancelOnError <= ?)");
      }
      else
      {
         GXv_int14[6] = (byte)(1) ;
      }
      if ( ( AV69Soap_locationwwds_11_tfsoaplochost_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV68Soap_locationwwds_10_tfsoaplochost)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SoapLocHost) like LOWER(?))");
      }
      else
      {
         GXv_int14[7] = (byte)(1) ;
      }
      if ( AV69Soap_locationwwds_11_tfsoaplochost_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69Soap_locationwwds_11_tfsoaplochost_sels, "SoapLocHost IN (", ")")+")");
      }
      if ( ! (0==AV70Soap_locationwwds_12_tfsoaplocport) )
      {
         addWhere(sWhereString, "(SoapLocPort >= ?)");
      }
      else
      {
         GXv_int14[8] = (byte)(1) ;
      }
      if ( ! (0==AV71Soap_locationwwds_13_tfsoaplocport_to) )
      {
         addWhere(sWhereString, "(SoapLocPort <= ?)");
      }
      else
      {
         GXv_int14[9] = (byte)(1) ;
      }
      if ( ( AV73Soap_locationwwds_15_tfsoaplocresourcename_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV72Soap_locationwwds_14_tfsoaplocresourcename)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SoapLocResourceName) like LOWER(?))");
      }
      else
      {
         GXv_int14[10] = (byte)(1) ;
      }
      if ( AV73Soap_locationwwds_15_tfsoaplocresourcename_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV73Soap_locationwwds_15_tfsoaplocresourcename_sels, "SoapLocResourceName IN (", ")")+")");
      }
      if ( ! (0==AV74Soap_locationwwds_16_tfsoaplocsecure) )
      {
         addWhere(sWhereString, "(SoapLocSecure >= ?)");
      }
      else
      {
         GXv_int14[11] = (byte)(1) ;
      }
      if ( ! (0==AV75Soap_locationwwds_17_tfsoaplocsecure_to) )
      {
         addWhere(sWhereString, "(SoapLocSecure <= ?)");
      }
      else
      {
         GXv_int14[12] = (byte)(1) ;
      }
      if ( ! (0==AV76Soap_locationwwds_18_tfsoaploctimeout) )
      {
         addWhere(sWhereString, "(SoapLocTimeout >= ?)");
      }
      else
      {
         GXv_int14[13] = (byte)(1) ;
      }
      if ( ! (0==AV77Soap_locationwwds_19_tfsoaploctimeout_to) )
      {
         addWhere(sWhereString, "(SoapLocTimeout <= ?)");
      }
      else
      {
         GXv_int14[14] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY SoapLocHost" ;
      GXv_Object15[0] = scmdbuf ;
      GXv_Object15[1] = GXv_int14 ;
      return GXv_Object15 ;
   }

   protected Object[] conditional_P028Y5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2162SoapLocId ,
                                          GXSimpleCollection<String> AV62Soap_locationwwds_4_tfsoaplocid_sels ,
                                          String A2164SoapLocBaseUrl ,
                                          GXSimpleCollection<String> AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels ,
                                          String A2166SoapLocHost ,
                                          GXSimpleCollection<String> AV69Soap_locationwwds_11_tfsoaplochost_sels ,
                                          String A2168SoapLocResourceName ,
                                          GXSimpleCollection<String> AV73Soap_locationwwds_15_tfsoaplocresourcename_sels ,
                                          int AV59Soap_locationwwds_1_tfclicod ,
                                          int AV60Soap_locationwwds_2_tfclicod_to ,
                                          int AV62Soap_locationwwds_4_tfsoaplocid_sels_size ,
                                          String AV61Soap_locationwwds_3_tfsoaplocid ,
                                          byte AV63Soap_locationwwds_5_tfsoaplochab_sel ,
                                          int AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels_size ,
                                          String AV64Soap_locationwwds_6_tfsoaplocbaseurl ,
                                          byte AV66Soap_locationwwds_8_tfsoaploccancelonerror ,
                                          byte AV67Soap_locationwwds_9_tfsoaploccancelonerror_to ,
                                          int AV69Soap_locationwwds_11_tfsoaplochost_sels_size ,
                                          String AV68Soap_locationwwds_10_tfsoaplochost ,
                                          int AV70Soap_locationwwds_12_tfsoaplocport ,
                                          int AV71Soap_locationwwds_13_tfsoaplocport_to ,
                                          int AV73Soap_locationwwds_15_tfsoaplocresourcename_sels_size ,
                                          String AV72Soap_locationwwds_14_tfsoaplocresourcename ,
                                          byte AV74Soap_locationwwds_16_tfsoaplocsecure ,
                                          byte AV75Soap_locationwwds_17_tfsoaplocsecure_to ,
                                          short AV76Soap_locationwwds_18_tfsoaploctimeout ,
                                          short AV77Soap_locationwwds_19_tfsoaploctimeout_to ,
                                          int A3CliCod ,
                                          boolean A2163SoapLocHab ,
                                          byte A2165SoapLocCancelOnError ,
                                          int A2167SoapLocPort ,
                                          byte A2169SoapLocSecure ,
                                          short A2170SoapLocTimeout ,
                                          int AV50CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int17 = new byte[15];
      Object[] GXv_Object18 = new Object[2];
      scmdbuf = "SELECT CliCod, SoapLocResourceName, SoapLocTimeout, SoapLocSecure, SoapLocPort, SoapLocHost, SoapLocCancelOnError, SoapLocBaseUrl, SoapLocHab, SoapLocId FROM soap_location" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV59Soap_locationwwds_1_tfclicod) )
      {
         addWhere(sWhereString, "(CliCod >= ?)");
      }
      else
      {
         GXv_int17[1] = (byte)(1) ;
      }
      if ( ! (0==AV60Soap_locationwwds_2_tfclicod_to) )
      {
         addWhere(sWhereString, "(CliCod <= ?)");
      }
      else
      {
         GXv_int17[2] = (byte)(1) ;
      }
      if ( ( AV62Soap_locationwwds_4_tfsoaplocid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV61Soap_locationwwds_3_tfsoaplocid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SoapLocId) like LOWER(?))");
      }
      else
      {
         GXv_int17[3] = (byte)(1) ;
      }
      if ( AV62Soap_locationwwds_4_tfsoaplocid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV62Soap_locationwwds_4_tfsoaplocid_sels, "SoapLocId IN (", ")")+")");
      }
      if ( AV63Soap_locationwwds_5_tfsoaplochab_sel == 1 )
      {
         addWhere(sWhereString, "(SoapLocHab = TRUE)");
      }
      if ( AV63Soap_locationwwds_5_tfsoaplochab_sel == 2 )
      {
         addWhere(sWhereString, "(SoapLocHab = FALSE)");
      }
      if ( ( AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV64Soap_locationwwds_6_tfsoaplocbaseurl)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SoapLocBaseUrl) like LOWER(?))");
      }
      else
      {
         GXv_int17[4] = (byte)(1) ;
      }
      if ( AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Soap_locationwwds_7_tfsoaplocbaseurl_sels, "SoapLocBaseUrl IN (", ")")+")");
      }
      if ( ! (0==AV66Soap_locationwwds_8_tfsoaploccancelonerror) )
      {
         addWhere(sWhereString, "(SoapLocCancelOnError >= ?)");
      }
      else
      {
         GXv_int17[5] = (byte)(1) ;
      }
      if ( ! (0==AV67Soap_locationwwds_9_tfsoaploccancelonerror_to) )
      {
         addWhere(sWhereString, "(SoapLocCancelOnError <= ?)");
      }
      else
      {
         GXv_int17[6] = (byte)(1) ;
      }
      if ( ( AV69Soap_locationwwds_11_tfsoaplochost_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV68Soap_locationwwds_10_tfsoaplochost)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SoapLocHost) like LOWER(?))");
      }
      else
      {
         GXv_int17[7] = (byte)(1) ;
      }
      if ( AV69Soap_locationwwds_11_tfsoaplochost_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69Soap_locationwwds_11_tfsoaplochost_sels, "SoapLocHost IN (", ")")+")");
      }
      if ( ! (0==AV70Soap_locationwwds_12_tfsoaplocport) )
      {
         addWhere(sWhereString, "(SoapLocPort >= ?)");
      }
      else
      {
         GXv_int17[8] = (byte)(1) ;
      }
      if ( ! (0==AV71Soap_locationwwds_13_tfsoaplocport_to) )
      {
         addWhere(sWhereString, "(SoapLocPort <= ?)");
      }
      else
      {
         GXv_int17[9] = (byte)(1) ;
      }
      if ( ( AV73Soap_locationwwds_15_tfsoaplocresourcename_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV72Soap_locationwwds_14_tfsoaplocresourcename)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SoapLocResourceName) like LOWER(?))");
      }
      else
      {
         GXv_int17[10] = (byte)(1) ;
      }
      if ( AV73Soap_locationwwds_15_tfsoaplocresourcename_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV73Soap_locationwwds_15_tfsoaplocresourcename_sels, "SoapLocResourceName IN (", ")")+")");
      }
      if ( ! (0==AV74Soap_locationwwds_16_tfsoaplocsecure) )
      {
         addWhere(sWhereString, "(SoapLocSecure >= ?)");
      }
      else
      {
         GXv_int17[11] = (byte)(1) ;
      }
      if ( ! (0==AV75Soap_locationwwds_17_tfsoaplocsecure_to) )
      {
         addWhere(sWhereString, "(SoapLocSecure <= ?)");
      }
      else
      {
         GXv_int17[12] = (byte)(1) ;
      }
      if ( ! (0==AV76Soap_locationwwds_18_tfsoaploctimeout) )
      {
         addWhere(sWhereString, "(SoapLocTimeout >= ?)");
      }
      else
      {
         GXv_int17[13] = (byte)(1) ;
      }
      if ( ! (0==AV77Soap_locationwwds_19_tfsoaploctimeout_to) )
      {
         addWhere(sWhereString, "(SoapLocTimeout <= ?)");
      }
      else
      {
         GXv_int17[14] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY SoapLocResourceName" ;
      GXv_Object18[0] = scmdbuf ;
      GXv_Object18[1] = GXv_int17 ;
      return GXv_Object18 ;
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
                  return conditional_P028Y2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).byteValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).byteValue() , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).byteValue() , ((Number) dynConstraints[24]).byteValue() , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).shortValue() , ((Number) dynConstraints[27]).intValue() , ((Boolean) dynConstraints[28]).booleanValue() , ((Number) dynConstraints[29]).byteValue() , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).byteValue() , ((Number) dynConstraints[32]).shortValue() , ((Number) dynConstraints[33]).intValue() );
            case 1 :
                  return conditional_P028Y3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).byteValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).byteValue() , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).byteValue() , ((Number) dynConstraints[24]).byteValue() , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).shortValue() , ((Number) dynConstraints[27]).intValue() , ((Boolean) dynConstraints[28]).booleanValue() , ((Number) dynConstraints[29]).byteValue() , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).byteValue() , ((Number) dynConstraints[32]).shortValue() , ((Number) dynConstraints[33]).intValue() );
            case 2 :
                  return conditional_P028Y4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).byteValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).byteValue() , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).byteValue() , ((Number) dynConstraints[24]).byteValue() , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).shortValue() , ((Number) dynConstraints[27]).intValue() , ((Boolean) dynConstraints[28]).booleanValue() , ((Number) dynConstraints[29]).byteValue() , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).byteValue() , ((Number) dynConstraints[32]).shortValue() , ((Number) dynConstraints[33]).intValue() );
            case 3 :
                  return conditional_P028Y5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).byteValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).byteValue() , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).byteValue() , ((Number) dynConstraints[24]).byteValue() , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).shortValue() , ((Number) dynConstraints[27]).intValue() , ((Boolean) dynConstraints[28]).booleanValue() , ((Number) dynConstraints[29]).byteValue() , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).byteValue() , ((Number) dynConstraints[32]).shortValue() , ((Number) dynConstraints[33]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P028Y2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P028Y3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P028Y4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P028Y5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 40);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 40);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 40);
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
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[16]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[17]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[18], 40);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 1000);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[20]).byteValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[21]).byteValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 40);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[23]).intValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[24]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 80);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[26]).byteValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[27]).byteValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[28]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[29]).shortValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[16]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[17]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[18], 40);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 1000);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[20]).byteValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[21]).byteValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 40);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[23]).intValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[24]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 80);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[26]).byteValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[27]).byteValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[28]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[29]).shortValue());
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[16]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[17]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[18], 40);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 1000);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[20]).byteValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[21]).byteValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 40);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[23]).intValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[24]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 80);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[26]).byteValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[27]).byteValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[28]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[29]).shortValue());
               }
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[16]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[17]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[18], 40);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 1000);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[20]).byteValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[21]).byteValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 40);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[23]).intValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[24]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 80);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[26]).byteValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[27]).byteValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[28]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[29]).shortValue());
               }
               return;
      }
   }

}

