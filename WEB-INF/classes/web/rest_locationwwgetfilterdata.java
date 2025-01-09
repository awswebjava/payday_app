package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class rest_locationwwgetfilterdata extends GXProcedure
{
   public rest_locationwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( rest_locationwwgetfilterdata.class ), "" );
   }

   public rest_locationwwgetfilterdata( int remoteHandle ,
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
      rest_locationwwgetfilterdata.this.aP5 = new String[] {""};
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
      rest_locationwwgetfilterdata.this.AV41DDOName = aP0;
      rest_locationwwgetfilterdata.this.AV42SearchTxt = aP1;
      rest_locationwwgetfilterdata.this.AV43SearchTxtTo = aP2;
      rest_locationwwgetfilterdata.this.aP3 = aP3;
      rest_locationwwgetfilterdata.this.aP4 = aP4;
      rest_locationwwgetfilterdata.this.aP5 = aP5;
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
      rest_locationwwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV48EmpCod = GXt_int1 ;
      GXt_int3 = AV49CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      rest_locationwwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV49CliCod = GXt_int3 ;
      AV31Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV33OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV34OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWrest_location", GXv_boolean6) ;
      rest_locationwwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV41DDOName), "DDO_RESTLOCID") == 0 )
         {
            /* Execute user subroutine: 'LOADRESTLOCIDOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV41DDOName), "DDO_RESTLOCBASEURL") == 0 )
         {
            /* Execute user subroutine: 'LOADRESTLOCBASEURLOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV41DDOName), "DDO_RESTLOCHOST") == 0 )
         {
            /* Execute user subroutine: 'LOADRESTLOCHOSTOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV44OptionsJson = AV31Options.toJSonString(false) ;
      AV45OptionsDescJson = AV33OptionsDesc.toJSonString(false) ;
      AV46OptionIndexesJson = AV34OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV36Session.getValue("rest_locationWWGridState"), "") == 0 )
      {
         AV38GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "rest_locationWWGridState"), null, null);
      }
      else
      {
         AV38GridState.fromxml(AV36Session.getValue("rest_locationWWGridState"), null, null);
      }
      AV52GXV1 = 1 ;
      while ( AV52GXV1 <= AV38GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV39GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV38GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV52GXV1));
         if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRESTLOCID") == 0 )
         {
            AV12TFRestLocId = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRESTLOCID_SEL") == 0 )
         {
            AV11TFRestLocId_SelsJson = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFRestLocId_Sels.fromJSonString(AV11TFRestLocId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRESTLOCHAB_SEL") == 0 )
         {
            AV14TFRestLocHab_Sel = (byte)(GXutil.lval( AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRESTLOCBASEURL") == 0 )
         {
            AV16TFRestLocBaseUrl = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRESTLOCBASEURL_SEL") == 0 )
         {
            AV15TFRestLocBaseUrl_SelsJson = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV17TFRestLocBaseUrl_Sels.fromJSonString(AV15TFRestLocBaseUrl_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRESTLOCCANCELONERROR") == 0 )
         {
            AV18TFRestLocCancelOnError = (byte)(GXutil.lval( AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV19TFRestLocCancelOnError_To = (byte)(GXutil.lval( AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRESTLOCHOST") == 0 )
         {
            AV21TFRestLocHost = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRESTLOCHOST_SEL") == 0 )
         {
            AV20TFRestLocHost_SelsJson = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV22TFRestLocHost_Sels.fromJSonString(AV20TFRestLocHost_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRESTLOCPORT") == 0 )
         {
            AV23TFRestLocPort = (int)(GXutil.lval( AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV24TFRestLocPort_To = (int)(GXutil.lval( AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRESTLOCTIMEOUT") == 0 )
         {
            AV25TFRestLocTimeout = (short)(GXutil.lval( AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV26TFRestLocTimeout_To = (short)(GXutil.lval( AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFRESTLOCSECURE") == 0 )
         {
            AV27TFRestLocSecure = (byte)(GXutil.lval( AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV28TFRestLocSecure_To = (byte)(GXutil.lval( AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV47MenuOpcCod = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV52GXV1 = (int)(AV52GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADRESTLOCIDOPTIONS' Routine */
      returnInSub = false ;
      AV12TFRestLocId = AV42SearchTxt ;
      AV13TFRestLocId_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV54Rest_locationwwds_1_tfrestlocid = AV12TFRestLocId ;
      AV55Rest_locationwwds_2_tfrestlocid_sels = AV13TFRestLocId_Sels ;
      AV56Rest_locationwwds_3_tfrestlochab_sel = AV14TFRestLocHab_Sel ;
      AV57Rest_locationwwds_4_tfrestlocbaseurl = AV16TFRestLocBaseUrl ;
      AV58Rest_locationwwds_5_tfrestlocbaseurl_sels = AV17TFRestLocBaseUrl_Sels ;
      AV59Rest_locationwwds_6_tfrestloccancelonerror = AV18TFRestLocCancelOnError ;
      AV60Rest_locationwwds_7_tfrestloccancelonerror_to = AV19TFRestLocCancelOnError_To ;
      AV61Rest_locationwwds_8_tfrestlochost = AV21TFRestLocHost ;
      AV62Rest_locationwwds_9_tfrestlochost_sels = AV22TFRestLocHost_Sels ;
      AV63Rest_locationwwds_10_tfrestlocport = AV23TFRestLocPort ;
      AV64Rest_locationwwds_11_tfrestlocport_to = AV24TFRestLocPort_To ;
      AV65Rest_locationwwds_12_tfrestloctimeout = AV25TFRestLocTimeout ;
      AV66Rest_locationwwds_13_tfrestloctimeout_to = AV26TFRestLocTimeout_To ;
      AV67Rest_locationwwds_14_tfrestlocsecure = AV27TFRestLocSecure ;
      AV68Rest_locationwwds_15_tfrestlocsecure_to = AV28TFRestLocSecure_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A2171RestLocId ,
                                           AV55Rest_locationwwds_2_tfrestlocid_sels ,
                                           A2173RestLocBaseUrl ,
                                           AV58Rest_locationwwds_5_tfrestlocbaseurl_sels ,
                                           A2175RestLocHost ,
                                           AV62Rest_locationwwds_9_tfrestlochost_sels ,
                                           Integer.valueOf(AV55Rest_locationwwds_2_tfrestlocid_sels.size()) ,
                                           AV54Rest_locationwwds_1_tfrestlocid ,
                                           Byte.valueOf(AV56Rest_locationwwds_3_tfrestlochab_sel) ,
                                           Integer.valueOf(AV58Rest_locationwwds_5_tfrestlocbaseurl_sels.size()) ,
                                           AV57Rest_locationwwds_4_tfrestlocbaseurl ,
                                           Byte.valueOf(AV59Rest_locationwwds_6_tfrestloccancelonerror) ,
                                           Byte.valueOf(AV60Rest_locationwwds_7_tfrestloccancelonerror_to) ,
                                           Integer.valueOf(AV62Rest_locationwwds_9_tfrestlochost_sels.size()) ,
                                           AV61Rest_locationwwds_8_tfrestlochost ,
                                           Integer.valueOf(AV63Rest_locationwwds_10_tfrestlocport) ,
                                           Integer.valueOf(AV64Rest_locationwwds_11_tfrestlocport_to) ,
                                           Short.valueOf(AV65Rest_locationwwds_12_tfrestloctimeout) ,
                                           Short.valueOf(AV66Rest_locationwwds_13_tfrestloctimeout_to) ,
                                           Byte.valueOf(AV67Rest_locationwwds_14_tfrestlocsecure) ,
                                           Byte.valueOf(AV68Rest_locationwwds_15_tfrestlocsecure_to) ,
                                           Boolean.valueOf(A2172RestLocHab) ,
                                           Byte.valueOf(A2174RestLocCancelOnError) ,
                                           Integer.valueOf(A2176RestLocPort) ,
                                           Short.valueOf(A2177RestLocTimeout) ,
                                           Byte.valueOf(A2178RestLocSecure) ,
                                           Integer.valueOf(AV49CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.BYTE,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV54Rest_locationwwds_1_tfrestlocid = GXutil.padr( GXutil.rtrim( AV54Rest_locationwwds_1_tfrestlocid), 40, "%") ;
      lV57Rest_locationwwds_4_tfrestlocbaseurl = GXutil.concat( GXutil.rtrim( AV57Rest_locationwwds_4_tfrestlocbaseurl), "%", "") ;
      lV61Rest_locationwwds_8_tfrestlochost = GXutil.concat( GXutil.rtrim( AV61Rest_locationwwds_8_tfrestlochost), "%", "") ;
      /* Using cursor P02AC2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV49CliCod), lV54Rest_locationwwds_1_tfrestlocid, lV57Rest_locationwwds_4_tfrestlocbaseurl, Byte.valueOf(AV59Rest_locationwwds_6_tfrestloccancelonerror), Byte.valueOf(AV60Rest_locationwwds_7_tfrestloccancelonerror_to), lV61Rest_locationwwds_8_tfrestlochost, Integer.valueOf(AV63Rest_locationwwds_10_tfrestlocport), Integer.valueOf(AV64Rest_locationwwds_11_tfrestlocport_to), Short.valueOf(AV65Rest_locationwwds_12_tfrestloctimeout), Short.valueOf(AV66Rest_locationwwds_13_tfrestloctimeout_to), Byte.valueOf(AV67Rest_locationwwds_14_tfrestlocsecure), Byte.valueOf(AV68Rest_locationwwds_15_tfrestlocsecure_to)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk2AC2 = false ;
         A3CliCod = P02AC2_A3CliCod[0] ;
         A2171RestLocId = P02AC2_A2171RestLocId[0] ;
         A2178RestLocSecure = P02AC2_A2178RestLocSecure[0] ;
         A2177RestLocTimeout = P02AC2_A2177RestLocTimeout[0] ;
         A2176RestLocPort = P02AC2_A2176RestLocPort[0] ;
         A2175RestLocHost = P02AC2_A2175RestLocHost[0] ;
         A2174RestLocCancelOnError = P02AC2_A2174RestLocCancelOnError[0] ;
         A2173RestLocBaseUrl = P02AC2_A2173RestLocBaseUrl[0] ;
         A2172RestLocHab = P02AC2_A2172RestLocHab[0] ;
         AV35count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P02AC2_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P02AC2_A2171RestLocId[0], A2171RestLocId) == 0 ) )
         {
            brk2AC2 = false ;
            AV35count = (long)(AV35count+1) ;
            brk2AC2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A2171RestLocId)==0) )
         {
            AV30Option = A2171RestLocId ;
            AV31Options.add(AV30Option, 0);
            AV34OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV35count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV31Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2AC2 )
         {
            brk2AC2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADRESTLOCBASEURLOPTIONS' Routine */
      returnInSub = false ;
      AV16TFRestLocBaseUrl = AV42SearchTxt ;
      AV17TFRestLocBaseUrl_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV54Rest_locationwwds_1_tfrestlocid = AV12TFRestLocId ;
      AV55Rest_locationwwds_2_tfrestlocid_sels = AV13TFRestLocId_Sels ;
      AV56Rest_locationwwds_3_tfrestlochab_sel = AV14TFRestLocHab_Sel ;
      AV57Rest_locationwwds_4_tfrestlocbaseurl = AV16TFRestLocBaseUrl ;
      AV58Rest_locationwwds_5_tfrestlocbaseurl_sels = AV17TFRestLocBaseUrl_Sels ;
      AV59Rest_locationwwds_6_tfrestloccancelonerror = AV18TFRestLocCancelOnError ;
      AV60Rest_locationwwds_7_tfrestloccancelonerror_to = AV19TFRestLocCancelOnError_To ;
      AV61Rest_locationwwds_8_tfrestlochost = AV21TFRestLocHost ;
      AV62Rest_locationwwds_9_tfrestlochost_sels = AV22TFRestLocHost_Sels ;
      AV63Rest_locationwwds_10_tfrestlocport = AV23TFRestLocPort ;
      AV64Rest_locationwwds_11_tfrestlocport_to = AV24TFRestLocPort_To ;
      AV65Rest_locationwwds_12_tfrestloctimeout = AV25TFRestLocTimeout ;
      AV66Rest_locationwwds_13_tfrestloctimeout_to = AV26TFRestLocTimeout_To ;
      AV67Rest_locationwwds_14_tfrestlocsecure = AV27TFRestLocSecure ;
      AV68Rest_locationwwds_15_tfrestlocsecure_to = AV28TFRestLocSecure_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A2171RestLocId ,
                                           AV55Rest_locationwwds_2_tfrestlocid_sels ,
                                           A2173RestLocBaseUrl ,
                                           AV58Rest_locationwwds_5_tfrestlocbaseurl_sels ,
                                           A2175RestLocHost ,
                                           AV62Rest_locationwwds_9_tfrestlochost_sels ,
                                           Integer.valueOf(AV55Rest_locationwwds_2_tfrestlocid_sels.size()) ,
                                           AV54Rest_locationwwds_1_tfrestlocid ,
                                           Byte.valueOf(AV56Rest_locationwwds_3_tfrestlochab_sel) ,
                                           Integer.valueOf(AV58Rest_locationwwds_5_tfrestlocbaseurl_sels.size()) ,
                                           AV57Rest_locationwwds_4_tfrestlocbaseurl ,
                                           Byte.valueOf(AV59Rest_locationwwds_6_tfrestloccancelonerror) ,
                                           Byte.valueOf(AV60Rest_locationwwds_7_tfrestloccancelonerror_to) ,
                                           Integer.valueOf(AV62Rest_locationwwds_9_tfrestlochost_sels.size()) ,
                                           AV61Rest_locationwwds_8_tfrestlochost ,
                                           Integer.valueOf(AV63Rest_locationwwds_10_tfrestlocport) ,
                                           Integer.valueOf(AV64Rest_locationwwds_11_tfrestlocport_to) ,
                                           Short.valueOf(AV65Rest_locationwwds_12_tfrestloctimeout) ,
                                           Short.valueOf(AV66Rest_locationwwds_13_tfrestloctimeout_to) ,
                                           Byte.valueOf(AV67Rest_locationwwds_14_tfrestlocsecure) ,
                                           Byte.valueOf(AV68Rest_locationwwds_15_tfrestlocsecure_to) ,
                                           Boolean.valueOf(A2172RestLocHab) ,
                                           Byte.valueOf(A2174RestLocCancelOnError) ,
                                           Integer.valueOf(A2176RestLocPort) ,
                                           Short.valueOf(A2177RestLocTimeout) ,
                                           Byte.valueOf(A2178RestLocSecure) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV49CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.BYTE,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV54Rest_locationwwds_1_tfrestlocid = GXutil.padr( GXutil.rtrim( AV54Rest_locationwwds_1_tfrestlocid), 40, "%") ;
      lV57Rest_locationwwds_4_tfrestlocbaseurl = GXutil.concat( GXutil.rtrim( AV57Rest_locationwwds_4_tfrestlocbaseurl), "%", "") ;
      lV61Rest_locationwwds_8_tfrestlochost = GXutil.concat( GXutil.rtrim( AV61Rest_locationwwds_8_tfrestlochost), "%", "") ;
      /* Using cursor P02AC3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV49CliCod), lV54Rest_locationwwds_1_tfrestlocid, lV57Rest_locationwwds_4_tfrestlocbaseurl, Byte.valueOf(AV59Rest_locationwwds_6_tfrestloccancelonerror), Byte.valueOf(AV60Rest_locationwwds_7_tfrestloccancelonerror_to), lV61Rest_locationwwds_8_tfrestlochost, Integer.valueOf(AV63Rest_locationwwds_10_tfrestlocport), Integer.valueOf(AV64Rest_locationwwds_11_tfrestlocport_to), Short.valueOf(AV65Rest_locationwwds_12_tfrestloctimeout), Short.valueOf(AV66Rest_locationwwds_13_tfrestloctimeout_to), Byte.valueOf(AV67Rest_locationwwds_14_tfrestlocsecure), Byte.valueOf(AV68Rest_locationwwds_15_tfrestlocsecure_to)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk2AC4 = false ;
         A3CliCod = P02AC3_A3CliCod[0] ;
         A2173RestLocBaseUrl = P02AC3_A2173RestLocBaseUrl[0] ;
         A2178RestLocSecure = P02AC3_A2178RestLocSecure[0] ;
         A2177RestLocTimeout = P02AC3_A2177RestLocTimeout[0] ;
         A2176RestLocPort = P02AC3_A2176RestLocPort[0] ;
         A2175RestLocHost = P02AC3_A2175RestLocHost[0] ;
         A2174RestLocCancelOnError = P02AC3_A2174RestLocCancelOnError[0] ;
         A2172RestLocHab = P02AC3_A2172RestLocHab[0] ;
         A2171RestLocId = P02AC3_A2171RestLocId[0] ;
         AV35count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P02AC3_A2173RestLocBaseUrl[0], A2173RestLocBaseUrl) == 0 ) )
         {
            brk2AC4 = false ;
            A3CliCod = P02AC3_A3CliCod[0] ;
            A2171RestLocId = P02AC3_A2171RestLocId[0] ;
            AV35count = (long)(AV35count+1) ;
            brk2AC4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A2173RestLocBaseUrl)==0) )
         {
            AV30Option = A2173RestLocBaseUrl ;
            AV31Options.add(AV30Option, 0);
            AV34OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV35count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV31Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2AC4 )
         {
            brk2AC4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADRESTLOCHOSTOPTIONS' Routine */
      returnInSub = false ;
      AV21TFRestLocHost = AV42SearchTxt ;
      AV22TFRestLocHost_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV54Rest_locationwwds_1_tfrestlocid = AV12TFRestLocId ;
      AV55Rest_locationwwds_2_tfrestlocid_sels = AV13TFRestLocId_Sels ;
      AV56Rest_locationwwds_3_tfrestlochab_sel = AV14TFRestLocHab_Sel ;
      AV57Rest_locationwwds_4_tfrestlocbaseurl = AV16TFRestLocBaseUrl ;
      AV58Rest_locationwwds_5_tfrestlocbaseurl_sels = AV17TFRestLocBaseUrl_Sels ;
      AV59Rest_locationwwds_6_tfrestloccancelonerror = AV18TFRestLocCancelOnError ;
      AV60Rest_locationwwds_7_tfrestloccancelonerror_to = AV19TFRestLocCancelOnError_To ;
      AV61Rest_locationwwds_8_tfrestlochost = AV21TFRestLocHost ;
      AV62Rest_locationwwds_9_tfrestlochost_sels = AV22TFRestLocHost_Sels ;
      AV63Rest_locationwwds_10_tfrestlocport = AV23TFRestLocPort ;
      AV64Rest_locationwwds_11_tfrestlocport_to = AV24TFRestLocPort_To ;
      AV65Rest_locationwwds_12_tfrestloctimeout = AV25TFRestLocTimeout ;
      AV66Rest_locationwwds_13_tfrestloctimeout_to = AV26TFRestLocTimeout_To ;
      AV67Rest_locationwwds_14_tfrestlocsecure = AV27TFRestLocSecure ;
      AV68Rest_locationwwds_15_tfrestlocsecure_to = AV28TFRestLocSecure_To ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A2171RestLocId ,
                                           AV55Rest_locationwwds_2_tfrestlocid_sels ,
                                           A2173RestLocBaseUrl ,
                                           AV58Rest_locationwwds_5_tfrestlocbaseurl_sels ,
                                           A2175RestLocHost ,
                                           AV62Rest_locationwwds_9_tfrestlochost_sels ,
                                           Integer.valueOf(AV55Rest_locationwwds_2_tfrestlocid_sels.size()) ,
                                           AV54Rest_locationwwds_1_tfrestlocid ,
                                           Byte.valueOf(AV56Rest_locationwwds_3_tfrestlochab_sel) ,
                                           Integer.valueOf(AV58Rest_locationwwds_5_tfrestlocbaseurl_sels.size()) ,
                                           AV57Rest_locationwwds_4_tfrestlocbaseurl ,
                                           Byte.valueOf(AV59Rest_locationwwds_6_tfrestloccancelonerror) ,
                                           Byte.valueOf(AV60Rest_locationwwds_7_tfrestloccancelonerror_to) ,
                                           Integer.valueOf(AV62Rest_locationwwds_9_tfrestlochost_sels.size()) ,
                                           AV61Rest_locationwwds_8_tfrestlochost ,
                                           Integer.valueOf(AV63Rest_locationwwds_10_tfrestlocport) ,
                                           Integer.valueOf(AV64Rest_locationwwds_11_tfrestlocport_to) ,
                                           Short.valueOf(AV65Rest_locationwwds_12_tfrestloctimeout) ,
                                           Short.valueOf(AV66Rest_locationwwds_13_tfrestloctimeout_to) ,
                                           Byte.valueOf(AV67Rest_locationwwds_14_tfrestlocsecure) ,
                                           Byte.valueOf(AV68Rest_locationwwds_15_tfrestlocsecure_to) ,
                                           Boolean.valueOf(A2172RestLocHab) ,
                                           Byte.valueOf(A2174RestLocCancelOnError) ,
                                           Integer.valueOf(A2176RestLocPort) ,
                                           Short.valueOf(A2177RestLocTimeout) ,
                                           Byte.valueOf(A2178RestLocSecure) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV49CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.BYTE,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV54Rest_locationwwds_1_tfrestlocid = GXutil.padr( GXutil.rtrim( AV54Rest_locationwwds_1_tfrestlocid), 40, "%") ;
      lV57Rest_locationwwds_4_tfrestlocbaseurl = GXutil.concat( GXutil.rtrim( AV57Rest_locationwwds_4_tfrestlocbaseurl), "%", "") ;
      lV61Rest_locationwwds_8_tfrestlochost = GXutil.concat( GXutil.rtrim( AV61Rest_locationwwds_8_tfrestlochost), "%", "") ;
      /* Using cursor P02AC4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV49CliCod), lV54Rest_locationwwds_1_tfrestlocid, lV57Rest_locationwwds_4_tfrestlocbaseurl, Byte.valueOf(AV59Rest_locationwwds_6_tfrestloccancelonerror), Byte.valueOf(AV60Rest_locationwwds_7_tfrestloccancelonerror_to), lV61Rest_locationwwds_8_tfrestlochost, Integer.valueOf(AV63Rest_locationwwds_10_tfrestlocport), Integer.valueOf(AV64Rest_locationwwds_11_tfrestlocport_to), Short.valueOf(AV65Rest_locationwwds_12_tfrestloctimeout), Short.valueOf(AV66Rest_locationwwds_13_tfrestloctimeout_to), Byte.valueOf(AV67Rest_locationwwds_14_tfrestlocsecure), Byte.valueOf(AV68Rest_locationwwds_15_tfrestlocsecure_to)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk2AC6 = false ;
         A3CliCod = P02AC4_A3CliCod[0] ;
         A2175RestLocHost = P02AC4_A2175RestLocHost[0] ;
         A2178RestLocSecure = P02AC4_A2178RestLocSecure[0] ;
         A2177RestLocTimeout = P02AC4_A2177RestLocTimeout[0] ;
         A2176RestLocPort = P02AC4_A2176RestLocPort[0] ;
         A2174RestLocCancelOnError = P02AC4_A2174RestLocCancelOnError[0] ;
         A2173RestLocBaseUrl = P02AC4_A2173RestLocBaseUrl[0] ;
         A2172RestLocHab = P02AC4_A2172RestLocHab[0] ;
         A2171RestLocId = P02AC4_A2171RestLocId[0] ;
         AV35count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P02AC4_A2175RestLocHost[0], A2175RestLocHost) == 0 ) )
         {
            brk2AC6 = false ;
            A3CliCod = P02AC4_A3CliCod[0] ;
            A2171RestLocId = P02AC4_A2171RestLocId[0] ;
            AV35count = (long)(AV35count+1) ;
            brk2AC6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A2175RestLocHost)==0) )
         {
            AV30Option = A2175RestLocHost ;
            AV31Options.add(AV30Option, 0);
            AV34OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV35count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV31Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2AC6 )
         {
            brk2AC6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = rest_locationwwgetfilterdata.this.AV44OptionsJson;
      this.aP4[0] = rest_locationwwgetfilterdata.this.AV45OptionsDescJson;
      this.aP5[0] = rest_locationwwgetfilterdata.this.AV46OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV44OptionsJson = "" ;
      AV45OptionsDescJson = "" ;
      AV46OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV31Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV33OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV34OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV36Session = httpContext.getWebSession();
      AV38GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV39GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV12TFRestLocId = "" ;
      AV11TFRestLocId_SelsJson = "" ;
      AV13TFRestLocId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV16TFRestLocBaseUrl = "" ;
      AV15TFRestLocBaseUrl_SelsJson = "" ;
      AV17TFRestLocBaseUrl_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV21TFRestLocHost = "" ;
      AV20TFRestLocHost_SelsJson = "" ;
      AV22TFRestLocHost_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV47MenuOpcCod = "" ;
      A2171RestLocId = "" ;
      AV54Rest_locationwwds_1_tfrestlocid = "" ;
      AV55Rest_locationwwds_2_tfrestlocid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV57Rest_locationwwds_4_tfrestlocbaseurl = "" ;
      AV58Rest_locationwwds_5_tfrestlocbaseurl_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV61Rest_locationwwds_8_tfrestlochost = "" ;
      AV62Rest_locationwwds_9_tfrestlochost_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV54Rest_locationwwds_1_tfrestlocid = "" ;
      lV57Rest_locationwwds_4_tfrestlocbaseurl = "" ;
      lV61Rest_locationwwds_8_tfrestlochost = "" ;
      A2173RestLocBaseUrl = "" ;
      A2175RestLocHost = "" ;
      P02AC2_A3CliCod = new int[1] ;
      P02AC2_A2171RestLocId = new String[] {""} ;
      P02AC2_A2178RestLocSecure = new byte[1] ;
      P02AC2_A2177RestLocTimeout = new short[1] ;
      P02AC2_A2176RestLocPort = new int[1] ;
      P02AC2_A2175RestLocHost = new String[] {""} ;
      P02AC2_A2174RestLocCancelOnError = new byte[1] ;
      P02AC2_A2173RestLocBaseUrl = new String[] {""} ;
      P02AC2_A2172RestLocHab = new boolean[] {false} ;
      AV30Option = "" ;
      P02AC3_A3CliCod = new int[1] ;
      P02AC3_A2173RestLocBaseUrl = new String[] {""} ;
      P02AC3_A2178RestLocSecure = new byte[1] ;
      P02AC3_A2177RestLocTimeout = new short[1] ;
      P02AC3_A2176RestLocPort = new int[1] ;
      P02AC3_A2175RestLocHost = new String[] {""} ;
      P02AC3_A2174RestLocCancelOnError = new byte[1] ;
      P02AC3_A2172RestLocHab = new boolean[] {false} ;
      P02AC3_A2171RestLocId = new String[] {""} ;
      P02AC4_A3CliCod = new int[1] ;
      P02AC4_A2175RestLocHost = new String[] {""} ;
      P02AC4_A2178RestLocSecure = new byte[1] ;
      P02AC4_A2177RestLocTimeout = new short[1] ;
      P02AC4_A2176RestLocPort = new int[1] ;
      P02AC4_A2174RestLocCancelOnError = new byte[1] ;
      P02AC4_A2173RestLocBaseUrl = new String[] {""} ;
      P02AC4_A2172RestLocHab = new boolean[] {false} ;
      P02AC4_A2171RestLocId = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.rest_locationwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P02AC2_A3CliCod, P02AC2_A2171RestLocId, P02AC2_A2178RestLocSecure, P02AC2_A2177RestLocTimeout, P02AC2_A2176RestLocPort, P02AC2_A2175RestLocHost, P02AC2_A2174RestLocCancelOnError, P02AC2_A2173RestLocBaseUrl, P02AC2_A2172RestLocHab
            }
            , new Object[] {
            P02AC3_A3CliCod, P02AC3_A2173RestLocBaseUrl, P02AC3_A2178RestLocSecure, P02AC3_A2177RestLocTimeout, P02AC3_A2176RestLocPort, P02AC3_A2175RestLocHost, P02AC3_A2174RestLocCancelOnError, P02AC3_A2172RestLocHab, P02AC3_A2171RestLocId
            }
            , new Object[] {
            P02AC4_A3CliCod, P02AC4_A2175RestLocHost, P02AC4_A2178RestLocSecure, P02AC4_A2177RestLocTimeout, P02AC4_A2176RestLocPort, P02AC4_A2174RestLocCancelOnError, P02AC4_A2173RestLocBaseUrl, P02AC4_A2172RestLocHab, P02AC4_A2171RestLocId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV14TFRestLocHab_Sel ;
   private byte AV18TFRestLocCancelOnError ;
   private byte AV19TFRestLocCancelOnError_To ;
   private byte AV27TFRestLocSecure ;
   private byte AV28TFRestLocSecure_To ;
   private byte AV56Rest_locationwwds_3_tfrestlochab_sel ;
   private byte AV59Rest_locationwwds_6_tfrestloccancelonerror ;
   private byte AV60Rest_locationwwds_7_tfrestloccancelonerror_to ;
   private byte AV67Rest_locationwwds_14_tfrestlocsecure ;
   private byte AV68Rest_locationwwds_15_tfrestlocsecure_to ;
   private byte A2174RestLocCancelOnError ;
   private byte A2178RestLocSecure ;
   private short AV48EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV25TFRestLocTimeout ;
   private short AV26TFRestLocTimeout_To ;
   private short AV65Rest_locationwwds_12_tfrestloctimeout ;
   private short AV66Rest_locationwwds_13_tfrestloctimeout_to ;
   private short A2177RestLocTimeout ;
   private short Gx_err ;
   private int AV49CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV52GXV1 ;
   private int AV23TFRestLocPort ;
   private int AV24TFRestLocPort_To ;
   private int AV63Rest_locationwwds_10_tfrestlocport ;
   private int AV64Rest_locationwwds_11_tfrestlocport_to ;
   private int AV55Rest_locationwwds_2_tfrestlocid_sels_size ;
   private int AV58Rest_locationwwds_5_tfrestlocbaseurl_sels_size ;
   private int AV62Rest_locationwwds_9_tfrestlochost_sels_size ;
   private int A2176RestLocPort ;
   private int A3CliCod ;
   private long AV35count ;
   private String AV12TFRestLocId ;
   private String A2171RestLocId ;
   private String AV54Rest_locationwwds_1_tfrestlocid ;
   private String scmdbuf ;
   private String lV54Rest_locationwwds_1_tfrestlocid ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean A2172RestLocHab ;
   private boolean brk2AC2 ;
   private boolean brk2AC4 ;
   private boolean brk2AC6 ;
   private String AV44OptionsJson ;
   private String AV45OptionsDescJson ;
   private String AV46OptionIndexesJson ;
   private String AV11TFRestLocId_SelsJson ;
   private String AV15TFRestLocBaseUrl_SelsJson ;
   private String AV20TFRestLocHost_SelsJson ;
   private String AV41DDOName ;
   private String AV42SearchTxt ;
   private String AV43SearchTxtTo ;
   private String AV16TFRestLocBaseUrl ;
   private String AV21TFRestLocHost ;
   private String AV47MenuOpcCod ;
   private String AV57Rest_locationwwds_4_tfrestlocbaseurl ;
   private String AV61Rest_locationwwds_8_tfrestlochost ;
   private String lV57Rest_locationwwds_4_tfrestlocbaseurl ;
   private String lV61Rest_locationwwds_8_tfrestlochost ;
   private String A2173RestLocBaseUrl ;
   private String A2175RestLocHost ;
   private String AV30Option ;
   private com.genexus.webpanels.WebSession AV36Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P02AC2_A3CliCod ;
   private String[] P02AC2_A2171RestLocId ;
   private byte[] P02AC2_A2178RestLocSecure ;
   private short[] P02AC2_A2177RestLocTimeout ;
   private int[] P02AC2_A2176RestLocPort ;
   private String[] P02AC2_A2175RestLocHost ;
   private byte[] P02AC2_A2174RestLocCancelOnError ;
   private String[] P02AC2_A2173RestLocBaseUrl ;
   private boolean[] P02AC2_A2172RestLocHab ;
   private int[] P02AC3_A3CliCod ;
   private String[] P02AC3_A2173RestLocBaseUrl ;
   private byte[] P02AC3_A2178RestLocSecure ;
   private short[] P02AC3_A2177RestLocTimeout ;
   private int[] P02AC3_A2176RestLocPort ;
   private String[] P02AC3_A2175RestLocHost ;
   private byte[] P02AC3_A2174RestLocCancelOnError ;
   private boolean[] P02AC3_A2172RestLocHab ;
   private String[] P02AC3_A2171RestLocId ;
   private int[] P02AC4_A3CliCod ;
   private String[] P02AC4_A2175RestLocHost ;
   private byte[] P02AC4_A2178RestLocSecure ;
   private short[] P02AC4_A2177RestLocTimeout ;
   private int[] P02AC4_A2176RestLocPort ;
   private byte[] P02AC4_A2174RestLocCancelOnError ;
   private String[] P02AC4_A2173RestLocBaseUrl ;
   private boolean[] P02AC4_A2172RestLocHab ;
   private String[] P02AC4_A2171RestLocId ;
   private GXSimpleCollection<String> AV13TFRestLocId_Sels ;
   private GXSimpleCollection<String> AV55Rest_locationwwds_2_tfrestlocid_sels ;
   private GXSimpleCollection<String> AV31Options ;
   private GXSimpleCollection<String> AV33OptionsDesc ;
   private GXSimpleCollection<String> AV34OptionIndexes ;
   private GXSimpleCollection<String> AV17TFRestLocBaseUrl_Sels ;
   private GXSimpleCollection<String> AV22TFRestLocHost_Sels ;
   private GXSimpleCollection<String> AV58Rest_locationwwds_5_tfrestlocbaseurl_sels ;
   private GXSimpleCollection<String> AV62Rest_locationwwds_9_tfrestlochost_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV38GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV39GridStateFilterValue ;
}

final  class rest_locationwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02AC2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2171RestLocId ,
                                          GXSimpleCollection<String> AV55Rest_locationwwds_2_tfrestlocid_sels ,
                                          String A2173RestLocBaseUrl ,
                                          GXSimpleCollection<String> AV58Rest_locationwwds_5_tfrestlocbaseurl_sels ,
                                          String A2175RestLocHost ,
                                          GXSimpleCollection<String> AV62Rest_locationwwds_9_tfrestlochost_sels ,
                                          int AV55Rest_locationwwds_2_tfrestlocid_sels_size ,
                                          String AV54Rest_locationwwds_1_tfrestlocid ,
                                          byte AV56Rest_locationwwds_3_tfrestlochab_sel ,
                                          int AV58Rest_locationwwds_5_tfrestlocbaseurl_sels_size ,
                                          String AV57Rest_locationwwds_4_tfrestlocbaseurl ,
                                          byte AV59Rest_locationwwds_6_tfrestloccancelonerror ,
                                          byte AV60Rest_locationwwds_7_tfrestloccancelonerror_to ,
                                          int AV62Rest_locationwwds_9_tfrestlochost_sels_size ,
                                          String AV61Rest_locationwwds_8_tfrestlochost ,
                                          int AV63Rest_locationwwds_10_tfrestlocport ,
                                          int AV64Rest_locationwwds_11_tfrestlocport_to ,
                                          short AV65Rest_locationwwds_12_tfrestloctimeout ,
                                          short AV66Rest_locationwwds_13_tfrestloctimeout_to ,
                                          byte AV67Rest_locationwwds_14_tfrestlocsecure ,
                                          byte AV68Rest_locationwwds_15_tfrestlocsecure_to ,
                                          boolean A2172RestLocHab ,
                                          byte A2174RestLocCancelOnError ,
                                          int A2176RestLocPort ,
                                          short A2177RestLocTimeout ,
                                          byte A2178RestLocSecure ,
                                          int AV49CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[12];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliCod, RestLocId, RestLocSecure, RestLocTimeout, RestLocPort, RestLocHost, RestLocCancelOnError, RestLocBaseUrl, RestLocHab FROM rest_location" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV55Rest_locationwwds_2_tfrestlocid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV54Rest_locationwwds_1_tfrestlocid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(RestLocId) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV55Rest_locationwwds_2_tfrestlocid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55Rest_locationwwds_2_tfrestlocid_sels, "RestLocId IN (", ")")+")");
      }
      if ( AV56Rest_locationwwds_3_tfrestlochab_sel == 1 )
      {
         addWhere(sWhereString, "(RestLocHab = TRUE)");
      }
      if ( AV56Rest_locationwwds_3_tfrestlochab_sel == 2 )
      {
         addWhere(sWhereString, "(RestLocHab = FALSE)");
      }
      if ( ( AV58Rest_locationwwds_5_tfrestlocbaseurl_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV57Rest_locationwwds_4_tfrestlocbaseurl)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(RestLocBaseUrl) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV58Rest_locationwwds_5_tfrestlocbaseurl_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58Rest_locationwwds_5_tfrestlocbaseurl_sels, "RestLocBaseUrl IN (", ")")+")");
      }
      if ( ! (0==AV59Rest_locationwwds_6_tfrestloccancelonerror) )
      {
         addWhere(sWhereString, "(RestLocCancelOnError >= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ! (0==AV60Rest_locationwwds_7_tfrestloccancelonerror_to) )
      {
         addWhere(sWhereString, "(RestLocCancelOnError <= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( ( AV62Rest_locationwwds_9_tfrestlochost_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV61Rest_locationwwds_8_tfrestlochost)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(RestLocHost) like LOWER(?))");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( AV62Rest_locationwwds_9_tfrestlochost_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV62Rest_locationwwds_9_tfrestlochost_sels, "RestLocHost IN (", ")")+")");
      }
      if ( ! (0==AV63Rest_locationwwds_10_tfrestlocport) )
      {
         addWhere(sWhereString, "(RestLocPort >= ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( ! (0==AV64Rest_locationwwds_11_tfrestlocport_to) )
      {
         addWhere(sWhereString, "(RestLocPort <= ?)");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( ! (0==AV65Rest_locationwwds_12_tfrestloctimeout) )
      {
         addWhere(sWhereString, "(RestLocTimeout >= ?)");
      }
      else
      {
         GXv_int8[8] = (byte)(1) ;
      }
      if ( ! (0==AV66Rest_locationwwds_13_tfrestloctimeout_to) )
      {
         addWhere(sWhereString, "(RestLocTimeout <= ?)");
      }
      else
      {
         GXv_int8[9] = (byte)(1) ;
      }
      if ( ! (0==AV67Rest_locationwwds_14_tfrestlocsecure) )
      {
         addWhere(sWhereString, "(RestLocSecure >= ?)");
      }
      else
      {
         GXv_int8[10] = (byte)(1) ;
      }
      if ( ! (0==AV68Rest_locationwwds_15_tfrestlocsecure_to) )
      {
         addWhere(sWhereString, "(RestLocSecure <= ?)");
      }
      else
      {
         GXv_int8[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, RestLocId" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P02AC3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2171RestLocId ,
                                          GXSimpleCollection<String> AV55Rest_locationwwds_2_tfrestlocid_sels ,
                                          String A2173RestLocBaseUrl ,
                                          GXSimpleCollection<String> AV58Rest_locationwwds_5_tfrestlocbaseurl_sels ,
                                          String A2175RestLocHost ,
                                          GXSimpleCollection<String> AV62Rest_locationwwds_9_tfrestlochost_sels ,
                                          int AV55Rest_locationwwds_2_tfrestlocid_sels_size ,
                                          String AV54Rest_locationwwds_1_tfrestlocid ,
                                          byte AV56Rest_locationwwds_3_tfrestlochab_sel ,
                                          int AV58Rest_locationwwds_5_tfrestlocbaseurl_sels_size ,
                                          String AV57Rest_locationwwds_4_tfrestlocbaseurl ,
                                          byte AV59Rest_locationwwds_6_tfrestloccancelonerror ,
                                          byte AV60Rest_locationwwds_7_tfrestloccancelonerror_to ,
                                          int AV62Rest_locationwwds_9_tfrestlochost_sels_size ,
                                          String AV61Rest_locationwwds_8_tfrestlochost ,
                                          int AV63Rest_locationwwds_10_tfrestlocport ,
                                          int AV64Rest_locationwwds_11_tfrestlocport_to ,
                                          short AV65Rest_locationwwds_12_tfrestloctimeout ,
                                          short AV66Rest_locationwwds_13_tfrestloctimeout_to ,
                                          byte AV67Rest_locationwwds_14_tfrestlocsecure ,
                                          byte AV68Rest_locationwwds_15_tfrestlocsecure_to ,
                                          boolean A2172RestLocHab ,
                                          byte A2174RestLocCancelOnError ,
                                          int A2176RestLocPort ,
                                          short A2177RestLocTimeout ,
                                          byte A2178RestLocSecure ,
                                          int A3CliCod ,
                                          int AV49CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[12];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT CliCod, RestLocBaseUrl, RestLocSecure, RestLocTimeout, RestLocPort, RestLocHost, RestLocCancelOnError, RestLocHab, RestLocId FROM rest_location" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV55Rest_locationwwds_2_tfrestlocid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV54Rest_locationwwds_1_tfrestlocid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(RestLocId) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV55Rest_locationwwds_2_tfrestlocid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55Rest_locationwwds_2_tfrestlocid_sels, "RestLocId IN (", ")")+")");
      }
      if ( AV56Rest_locationwwds_3_tfrestlochab_sel == 1 )
      {
         addWhere(sWhereString, "(RestLocHab = TRUE)");
      }
      if ( AV56Rest_locationwwds_3_tfrestlochab_sel == 2 )
      {
         addWhere(sWhereString, "(RestLocHab = FALSE)");
      }
      if ( ( AV58Rest_locationwwds_5_tfrestlocbaseurl_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV57Rest_locationwwds_4_tfrestlocbaseurl)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(RestLocBaseUrl) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV58Rest_locationwwds_5_tfrestlocbaseurl_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58Rest_locationwwds_5_tfrestlocbaseurl_sels, "RestLocBaseUrl IN (", ")")+")");
      }
      if ( ! (0==AV59Rest_locationwwds_6_tfrestloccancelonerror) )
      {
         addWhere(sWhereString, "(RestLocCancelOnError >= ?)");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( ! (0==AV60Rest_locationwwds_7_tfrestloccancelonerror_to) )
      {
         addWhere(sWhereString, "(RestLocCancelOnError <= ?)");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( ( AV62Rest_locationwwds_9_tfrestlochost_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV61Rest_locationwwds_8_tfrestlochost)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(RestLocHost) like LOWER(?))");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( AV62Rest_locationwwds_9_tfrestlochost_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV62Rest_locationwwds_9_tfrestlochost_sels, "RestLocHost IN (", ")")+")");
      }
      if ( ! (0==AV63Rest_locationwwds_10_tfrestlocport) )
      {
         addWhere(sWhereString, "(RestLocPort >= ?)");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( ! (0==AV64Rest_locationwwds_11_tfrestlocport_to) )
      {
         addWhere(sWhereString, "(RestLocPort <= ?)");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( ! (0==AV65Rest_locationwwds_12_tfrestloctimeout) )
      {
         addWhere(sWhereString, "(RestLocTimeout >= ?)");
      }
      else
      {
         GXv_int11[8] = (byte)(1) ;
      }
      if ( ! (0==AV66Rest_locationwwds_13_tfrestloctimeout_to) )
      {
         addWhere(sWhereString, "(RestLocTimeout <= ?)");
      }
      else
      {
         GXv_int11[9] = (byte)(1) ;
      }
      if ( ! (0==AV67Rest_locationwwds_14_tfrestlocsecure) )
      {
         addWhere(sWhereString, "(RestLocSecure >= ?)");
      }
      else
      {
         GXv_int11[10] = (byte)(1) ;
      }
      if ( ! (0==AV68Rest_locationwwds_15_tfrestlocsecure_to) )
      {
         addWhere(sWhereString, "(RestLocSecure <= ?)");
      }
      else
      {
         GXv_int11[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY RestLocBaseUrl" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P02AC4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2171RestLocId ,
                                          GXSimpleCollection<String> AV55Rest_locationwwds_2_tfrestlocid_sels ,
                                          String A2173RestLocBaseUrl ,
                                          GXSimpleCollection<String> AV58Rest_locationwwds_5_tfrestlocbaseurl_sels ,
                                          String A2175RestLocHost ,
                                          GXSimpleCollection<String> AV62Rest_locationwwds_9_tfrestlochost_sels ,
                                          int AV55Rest_locationwwds_2_tfrestlocid_sels_size ,
                                          String AV54Rest_locationwwds_1_tfrestlocid ,
                                          byte AV56Rest_locationwwds_3_tfrestlochab_sel ,
                                          int AV58Rest_locationwwds_5_tfrestlocbaseurl_sels_size ,
                                          String AV57Rest_locationwwds_4_tfrestlocbaseurl ,
                                          byte AV59Rest_locationwwds_6_tfrestloccancelonerror ,
                                          byte AV60Rest_locationwwds_7_tfrestloccancelonerror_to ,
                                          int AV62Rest_locationwwds_9_tfrestlochost_sels_size ,
                                          String AV61Rest_locationwwds_8_tfrestlochost ,
                                          int AV63Rest_locationwwds_10_tfrestlocport ,
                                          int AV64Rest_locationwwds_11_tfrestlocport_to ,
                                          short AV65Rest_locationwwds_12_tfrestloctimeout ,
                                          short AV66Rest_locationwwds_13_tfrestloctimeout_to ,
                                          byte AV67Rest_locationwwds_14_tfrestlocsecure ,
                                          byte AV68Rest_locationwwds_15_tfrestlocsecure_to ,
                                          boolean A2172RestLocHab ,
                                          byte A2174RestLocCancelOnError ,
                                          int A2176RestLocPort ,
                                          short A2177RestLocTimeout ,
                                          byte A2178RestLocSecure ,
                                          int A3CliCod ,
                                          int AV49CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[12];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT CliCod, RestLocHost, RestLocSecure, RestLocTimeout, RestLocPort, RestLocCancelOnError, RestLocBaseUrl, RestLocHab, RestLocId FROM rest_location" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV55Rest_locationwwds_2_tfrestlocid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV54Rest_locationwwds_1_tfrestlocid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(RestLocId) like LOWER(?))");
      }
      else
      {
         GXv_int14[1] = (byte)(1) ;
      }
      if ( AV55Rest_locationwwds_2_tfrestlocid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55Rest_locationwwds_2_tfrestlocid_sels, "RestLocId IN (", ")")+")");
      }
      if ( AV56Rest_locationwwds_3_tfrestlochab_sel == 1 )
      {
         addWhere(sWhereString, "(RestLocHab = TRUE)");
      }
      if ( AV56Rest_locationwwds_3_tfrestlochab_sel == 2 )
      {
         addWhere(sWhereString, "(RestLocHab = FALSE)");
      }
      if ( ( AV58Rest_locationwwds_5_tfrestlocbaseurl_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV57Rest_locationwwds_4_tfrestlocbaseurl)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(RestLocBaseUrl) like LOWER(?))");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( AV58Rest_locationwwds_5_tfrestlocbaseurl_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58Rest_locationwwds_5_tfrestlocbaseurl_sels, "RestLocBaseUrl IN (", ")")+")");
      }
      if ( ! (0==AV59Rest_locationwwds_6_tfrestloccancelonerror) )
      {
         addWhere(sWhereString, "(RestLocCancelOnError >= ?)");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( ! (0==AV60Rest_locationwwds_7_tfrestloccancelonerror_to) )
      {
         addWhere(sWhereString, "(RestLocCancelOnError <= ?)");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( ( AV62Rest_locationwwds_9_tfrestlochost_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV61Rest_locationwwds_8_tfrestlochost)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(RestLocHost) like LOWER(?))");
      }
      else
      {
         GXv_int14[5] = (byte)(1) ;
      }
      if ( AV62Rest_locationwwds_9_tfrestlochost_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV62Rest_locationwwds_9_tfrestlochost_sels, "RestLocHost IN (", ")")+")");
      }
      if ( ! (0==AV63Rest_locationwwds_10_tfrestlocport) )
      {
         addWhere(sWhereString, "(RestLocPort >= ?)");
      }
      else
      {
         GXv_int14[6] = (byte)(1) ;
      }
      if ( ! (0==AV64Rest_locationwwds_11_tfrestlocport_to) )
      {
         addWhere(sWhereString, "(RestLocPort <= ?)");
      }
      else
      {
         GXv_int14[7] = (byte)(1) ;
      }
      if ( ! (0==AV65Rest_locationwwds_12_tfrestloctimeout) )
      {
         addWhere(sWhereString, "(RestLocTimeout >= ?)");
      }
      else
      {
         GXv_int14[8] = (byte)(1) ;
      }
      if ( ! (0==AV66Rest_locationwwds_13_tfrestloctimeout_to) )
      {
         addWhere(sWhereString, "(RestLocTimeout <= ?)");
      }
      else
      {
         GXv_int14[9] = (byte)(1) ;
      }
      if ( ! (0==AV67Rest_locationwwds_14_tfrestlocsecure) )
      {
         addWhere(sWhereString, "(RestLocSecure >= ?)");
      }
      else
      {
         GXv_int14[10] = (byte)(1) ;
      }
      if ( ! (0==AV68Rest_locationwwds_15_tfrestlocsecure_to) )
      {
         addWhere(sWhereString, "(RestLocSecure <= ?)");
      }
      else
      {
         GXv_int14[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY RestLocHost" ;
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
                  return conditional_P02AC2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , ((Number) dynConstraints[11]).byteValue() , ((Number) dynConstraints[12]).byteValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).shortValue() , ((Number) dynConstraints[19]).byteValue() , ((Number) dynConstraints[20]).byteValue() , ((Boolean) dynConstraints[21]).booleanValue() , ((Number) dynConstraints[22]).byteValue() , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).byteValue() , ((Number) dynConstraints[26]).intValue() , ((Number) dynConstraints[27]).intValue() );
            case 1 :
                  return conditional_P02AC3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , ((Number) dynConstraints[11]).byteValue() , ((Number) dynConstraints[12]).byteValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).shortValue() , ((Number) dynConstraints[19]).byteValue() , ((Number) dynConstraints[20]).byteValue() , ((Boolean) dynConstraints[21]).booleanValue() , ((Number) dynConstraints[22]).byteValue() , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).byteValue() , ((Number) dynConstraints[26]).intValue() , ((Number) dynConstraints[27]).intValue() );
            case 2 :
                  return conditional_P02AC4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , ((Number) dynConstraints[11]).byteValue() , ((Number) dynConstraints[12]).byteValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).shortValue() , ((Number) dynConstraints[19]).byteValue() , ((Number) dynConstraints[20]).byteValue() , ((Boolean) dynConstraints[21]).booleanValue() , ((Number) dynConstraints[22]).byteValue() , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).byteValue() , ((Number) dynConstraints[26]).intValue() , ((Number) dynConstraints[27]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02AC2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02AC3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02AC4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 40);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 40);
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
                  stmt.setString(sIdx, (String)parms[13], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 1000);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[15]).byteValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[16]).byteValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 200);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[18]).intValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[19]).intValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[20]).shortValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[21]).shortValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[22]).byteValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[23]).byteValue());
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
                  stmt.setString(sIdx, (String)parms[13], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 1000);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[15]).byteValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[16]).byteValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 200);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[18]).intValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[19]).intValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[20]).shortValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[21]).shortValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[22]).byteValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[23]).byteValue());
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
                  stmt.setString(sIdx, (String)parms[13], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 1000);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[15]).byteValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[16]).byteValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 200);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[18]).intValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[19]).intValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[20]).shortValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[21]).shortValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[22]).byteValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[23]).byteValue());
               }
               return;
      }
   }

}

