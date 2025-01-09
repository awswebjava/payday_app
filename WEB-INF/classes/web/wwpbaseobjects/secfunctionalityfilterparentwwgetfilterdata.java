package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class secfunctionalityfilterparentwwgetfilterdata extends GXProcedure
{
   public secfunctionalityfilterparentwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secfunctionalityfilterparentwwgetfilterdata.class ), "" );
   }

   public secfunctionalityfilterparentwwgetfilterdata( int remoteHandle ,
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
      secfunctionalityfilterparentwwgetfilterdata.this.aP5 = new String[] {""};
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
      secfunctionalityfilterparentwwgetfilterdata.this.AV19DDOName = aP0;
      secfunctionalityfilterparentwwgetfilterdata.this.AV17SearchTxt = aP1;
      secfunctionalityfilterparentwwgetfilterdata.this.AV18SearchTxtTo = aP2;
      secfunctionalityfilterparentwwgetfilterdata.this.aP3 = aP3;
      secfunctionalityfilterparentwwgetfilterdata.this.aP4 = aP4;
      secfunctionalityfilterparentwwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV22Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV25OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV27OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSecFunctionality", GXv_boolean2) ;
      secfunctionalityfilterparentwwgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV39WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV39WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(GXutil.upper( AV19DDOName), "DDO_SECFUNCTIONALITYKEY") == 0 )
         {
            /* Execute user subroutine: 'LOADSECFUNCTIONALITYKEYOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV19DDOName), "DDO_SECFUNCTIONALITYDESCRIPTION") == 0 )
         {
            /* Execute user subroutine: 'LOADSECFUNCTIONALITYDESCRIPTIONOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV19DDOName), "DDO_SECPARENTFUNCTIONALITYDESCRIPTION") == 0 )
         {
            /* Execute user subroutine: 'LOADSECPARENTFUNCTIONALITYDESCRIPTIONOPTIONS' */
            S141 ();
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
      if ( GXutil.strcmp(AV30Session.getValue("WWPBaseObjects.SecFunctionalityFilterParentWWGridState"), "") == 0 )
      {
         AV32GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "WWPBaseObjects.SecFunctionalityFilterParentWWGridState"), null, null);
      }
      else
      {
         AV32GridState.fromxml(AV30Session.getValue("WWPBaseObjects.SecFunctionalityFilterParentWWGridState"), null, null);
      }
      AV52GXV1 = 1 ;
      while ( AV52GXV1 <= AV32GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV33GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV32GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV52GXV1));
         if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYKEY") == 0 )
         {
            AV10TFSecFunctionalityKey = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYKEY_SEL") == 0 )
         {
            AV42TFSecFunctionalityKey_SelsJson = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV43TFSecFunctionalityKey_Sels.fromJSonString(AV42TFSecFunctionalityKey_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYDESCRIPTION") == 0 )
         {
            AV12TFSecFunctionalityDescription = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYDESCRIPTION_SEL") == 0 )
         {
            AV44TFSecFunctionalityDescription_SelsJson = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV45TFSecFunctionalityDescription_Sels.fromJSonString(AV44TFSecFunctionalityDescription_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYTYPE_SEL") == 0 )
         {
            AV40TFSecFunctionalityType_SelsJson = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV41TFSecFunctionalityType_Sels.fromJSonString(AV40TFSecFunctionalityType_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECPARENTFUNCTIONALITYDESCRIPTION") == 0 )
         {
            AV15TFSecParentFunctionalityDescription = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECPARENTFUNCTIONALITYDESCRIPTION_SEL") == 0 )
         {
            AV46TFSecParentFunctionalityDescription_SelsJson = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV47TFSecParentFunctionalityDescription_Sels.fromJSonString(AV46TFSecParentFunctionalityDescription_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&SECPARENTFUNCTIONALITYID") == 0 )
         {
            AV38SecParentFunctionalityId = GXutil.lval( AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
         }
         AV52GXV1 = (int)(AV52GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADSECFUNCTIONALITYKEYOPTIONS' Routine */
      returnInSub = false ;
      AV10TFSecFunctionalityKey = AV17SearchTxt ;
      AV43TFSecFunctionalityKey_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV54Wwpbaseobjects_secfunctionalityfilterparentwwds_1_secparentfunctionalityid = AV38SecParentFunctionalityId ;
      AV55Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey = AV10TFSecFunctionalityKey ;
      AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels = AV43TFSecFunctionalityKey_Sels ;
      AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription = AV12TFSecFunctionalityDescription ;
      AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels = AV45TFSecFunctionalityDescription_Sels ;
      AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels = AV41TFSecFunctionalityType_Sels ;
      AV60Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription = AV15TFSecParentFunctionalityDescription ;
      AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels = AV47TFSecParentFunctionalityDescription_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A64SecFunctionalityKey ,
                                           AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels ,
                                           A350SecFunctionalityDescription ,
                                           AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels ,
                                           Byte.valueOf(A351SecFunctionalityType) ,
                                           AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels ,
                                           A353SecParentFunctionalityDescript ,
                                           AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels ,
                                           Integer.valueOf(AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels.size()) ,
                                           AV55Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey ,
                                           Integer.valueOf(AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels.size()) ,
                                           AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription ,
                                           Integer.valueOf(AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels.size()) ,
                                           Integer.valueOf(AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels.size()) ,
                                           AV60Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription ,
                                           Long.valueOf(AV54Wwpbaseobjects_secfunctionalityfilterparentwwds_1_secparentfunctionalityid) ,
                                           Long.valueOf(A63SecParentFunctionalityId) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.BOOLEAN
                                           }
      });
      lV55Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey = GXutil.concat( GXutil.rtrim( AV55Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey), "%", "") ;
      lV57Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription), "%", "") ;
      lV60Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV60Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription), "%", "") ;
      /* Using cursor P00BP2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV54Wwpbaseobjects_secfunctionalityfilterparentwwds_1_secparentfunctionalityid), lV55Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey, lV57Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription, lV60Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brkBP2 = false ;
         A63SecParentFunctionalityId = P00BP2_A63SecParentFunctionalityId[0] ;
         n63SecParentFunctionalityId = P00BP2_n63SecParentFunctionalityId[0] ;
         A64SecFunctionalityKey = P00BP2_A64SecFunctionalityKey[0] ;
         A353SecParentFunctionalityDescript = P00BP2_A353SecParentFunctionalityDescript[0] ;
         A351SecFunctionalityType = P00BP2_A351SecFunctionalityType[0] ;
         A350SecFunctionalityDescription = P00BP2_A350SecFunctionalityDescription[0] ;
         A62SecFunctionalityId = P00BP2_A62SecFunctionalityId[0] ;
         A353SecParentFunctionalityDescript = P00BP2_A353SecParentFunctionalityDescript[0] ;
         AV29count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P00BP2_A63SecParentFunctionalityId[0] == A63SecParentFunctionalityId ) && ( GXutil.strcmp(P00BP2_A64SecFunctionalityKey[0], A64SecFunctionalityKey) == 0 ) )
         {
            brkBP2 = false ;
            A62SecFunctionalityId = P00BP2_A62SecFunctionalityId[0] ;
            AV29count = (long)(AV29count+1) ;
            brkBP2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A64SecFunctionalityKey)==0) )
         {
            AV21Option = A64SecFunctionalityKey ;
            AV22Options.add(AV21Option, 0);
            AV27OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV29count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV22Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brkBP2 )
         {
            brkBP2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADSECFUNCTIONALITYDESCRIPTIONOPTIONS' Routine */
      returnInSub = false ;
      AV12TFSecFunctionalityDescription = AV17SearchTxt ;
      AV45TFSecFunctionalityDescription_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV54Wwpbaseobjects_secfunctionalityfilterparentwwds_1_secparentfunctionalityid = AV38SecParentFunctionalityId ;
      AV55Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey = AV10TFSecFunctionalityKey ;
      AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels = AV43TFSecFunctionalityKey_Sels ;
      AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription = AV12TFSecFunctionalityDescription ;
      AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels = AV45TFSecFunctionalityDescription_Sels ;
      AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels = AV41TFSecFunctionalityType_Sels ;
      AV60Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription = AV15TFSecParentFunctionalityDescription ;
      AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels = AV47TFSecParentFunctionalityDescription_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A64SecFunctionalityKey ,
                                           AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels ,
                                           A350SecFunctionalityDescription ,
                                           AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels ,
                                           Byte.valueOf(A351SecFunctionalityType) ,
                                           AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels ,
                                           A353SecParentFunctionalityDescript ,
                                           AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels ,
                                           Integer.valueOf(AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels.size()) ,
                                           AV55Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey ,
                                           Integer.valueOf(AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels.size()) ,
                                           AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription ,
                                           Integer.valueOf(AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels.size()) ,
                                           Integer.valueOf(AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels.size()) ,
                                           AV60Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription ,
                                           Long.valueOf(AV54Wwpbaseobjects_secfunctionalityfilterparentwwds_1_secparentfunctionalityid) ,
                                           Long.valueOf(A63SecParentFunctionalityId) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.BOOLEAN
                                           }
      });
      lV55Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey = GXutil.concat( GXutil.rtrim( AV55Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey), "%", "") ;
      lV57Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription), "%", "") ;
      lV60Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV60Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription), "%", "") ;
      /* Using cursor P00BP3 */
      pr_default.execute(1, new Object[] {Long.valueOf(AV54Wwpbaseobjects_secfunctionalityfilterparentwwds_1_secparentfunctionalityid), lV55Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey, lV57Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription, lV60Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brkBP4 = false ;
         A63SecParentFunctionalityId = P00BP3_A63SecParentFunctionalityId[0] ;
         n63SecParentFunctionalityId = P00BP3_n63SecParentFunctionalityId[0] ;
         A350SecFunctionalityDescription = P00BP3_A350SecFunctionalityDescription[0] ;
         A353SecParentFunctionalityDescript = P00BP3_A353SecParentFunctionalityDescript[0] ;
         A351SecFunctionalityType = P00BP3_A351SecFunctionalityType[0] ;
         A64SecFunctionalityKey = P00BP3_A64SecFunctionalityKey[0] ;
         A62SecFunctionalityId = P00BP3_A62SecFunctionalityId[0] ;
         A353SecParentFunctionalityDescript = P00BP3_A353SecParentFunctionalityDescript[0] ;
         AV29count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( P00BP3_A63SecParentFunctionalityId[0] == A63SecParentFunctionalityId ) && ( GXutil.strcmp(P00BP3_A350SecFunctionalityDescription[0], A350SecFunctionalityDescription) == 0 ) )
         {
            brkBP4 = false ;
            A62SecFunctionalityId = P00BP3_A62SecFunctionalityId[0] ;
            AV29count = (long)(AV29count+1) ;
            brkBP4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A350SecFunctionalityDescription)==0) )
         {
            AV21Option = A350SecFunctionalityDescription ;
            AV22Options.add(AV21Option, 0);
            AV27OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV29count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV22Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brkBP4 )
         {
            brkBP4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADSECPARENTFUNCTIONALITYDESCRIPTIONOPTIONS' Routine */
      returnInSub = false ;
      AV15TFSecParentFunctionalityDescription = AV17SearchTxt ;
      AV47TFSecParentFunctionalityDescription_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV54Wwpbaseobjects_secfunctionalityfilterparentwwds_1_secparentfunctionalityid = AV38SecParentFunctionalityId ;
      AV55Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey = AV10TFSecFunctionalityKey ;
      AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels = AV43TFSecFunctionalityKey_Sels ;
      AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription = AV12TFSecFunctionalityDescription ;
      AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels = AV45TFSecFunctionalityDescription_Sels ;
      AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels = AV41TFSecFunctionalityType_Sels ;
      AV60Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription = AV15TFSecParentFunctionalityDescription ;
      AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels = AV47TFSecParentFunctionalityDescription_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A64SecFunctionalityKey ,
                                           AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels ,
                                           A350SecFunctionalityDescription ,
                                           AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels ,
                                           Byte.valueOf(A351SecFunctionalityType) ,
                                           AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels ,
                                           A353SecParentFunctionalityDescript ,
                                           AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels ,
                                           Integer.valueOf(AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels.size()) ,
                                           AV55Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey ,
                                           Integer.valueOf(AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels.size()) ,
                                           AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription ,
                                           Integer.valueOf(AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels.size()) ,
                                           Integer.valueOf(AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels.size()) ,
                                           AV60Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription ,
                                           Long.valueOf(AV54Wwpbaseobjects_secfunctionalityfilterparentwwds_1_secparentfunctionalityid) ,
                                           Long.valueOf(A63SecParentFunctionalityId) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.BOOLEAN
                                           }
      });
      lV55Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey = GXutil.concat( GXutil.rtrim( AV55Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey), "%", "") ;
      lV57Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription), "%", "") ;
      lV60Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV60Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription), "%", "") ;
      /* Using cursor P00BP4 */
      pr_default.execute(2, new Object[] {Long.valueOf(AV54Wwpbaseobjects_secfunctionalityfilterparentwwds_1_secparentfunctionalityid), lV55Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey, lV57Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription, lV60Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brkBP6 = false ;
         A63SecParentFunctionalityId = P00BP4_A63SecParentFunctionalityId[0] ;
         n63SecParentFunctionalityId = P00BP4_n63SecParentFunctionalityId[0] ;
         A353SecParentFunctionalityDescript = P00BP4_A353SecParentFunctionalityDescript[0] ;
         A351SecFunctionalityType = P00BP4_A351SecFunctionalityType[0] ;
         A350SecFunctionalityDescription = P00BP4_A350SecFunctionalityDescription[0] ;
         A64SecFunctionalityKey = P00BP4_A64SecFunctionalityKey[0] ;
         A62SecFunctionalityId = P00BP4_A62SecFunctionalityId[0] ;
         A353SecParentFunctionalityDescript = P00BP4_A353SecParentFunctionalityDescript[0] ;
         AV29count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( P00BP4_A63SecParentFunctionalityId[0] == A63SecParentFunctionalityId ) && ( GXutil.strcmp(P00BP4_A353SecParentFunctionalityDescript[0], A353SecParentFunctionalityDescript) == 0 ) )
         {
            brkBP6 = false ;
            A62SecFunctionalityId = P00BP4_A62SecFunctionalityId[0] ;
            AV29count = (long)(AV29count+1) ;
            brkBP6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A353SecParentFunctionalityDescript)==0) )
         {
            AV21Option = A353SecParentFunctionalityDescript ;
            AV22Options.add(AV21Option, 0);
            AV27OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV29count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV22Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brkBP6 )
         {
            brkBP6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = secfunctionalityfilterparentwwgetfilterdata.this.AV23OptionsJson;
      this.aP4[0] = secfunctionalityfilterparentwwgetfilterdata.this.AV26OptionsDescJson;
      this.aP5[0] = secfunctionalityfilterparentwwgetfilterdata.this.AV28OptionIndexesJson;
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
      AV22Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV25OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV27OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV39WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV30Session = httpContext.getWebSession();
      AV32GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV33GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV10TFSecFunctionalityKey = "" ;
      AV42TFSecFunctionalityKey_SelsJson = "" ;
      AV43TFSecFunctionalityKey_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV12TFSecFunctionalityDescription = "" ;
      AV44TFSecFunctionalityDescription_SelsJson = "" ;
      AV45TFSecFunctionalityDescription_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV40TFSecFunctionalityType_SelsJson = "" ;
      AV41TFSecFunctionalityType_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV15TFSecParentFunctionalityDescription = "" ;
      AV46TFSecParentFunctionalityDescription_SelsJson = "" ;
      AV47TFSecParentFunctionalityDescription_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      A64SecFunctionalityKey = "" ;
      AV55Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey = "" ;
      AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription = "" ;
      AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV60Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription = "" ;
      AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV55Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey = "" ;
      lV57Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription = "" ;
      lV60Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription = "" ;
      A350SecFunctionalityDescription = "" ;
      A353SecParentFunctionalityDescript = "" ;
      P00BP2_A63SecParentFunctionalityId = new long[1] ;
      P00BP2_n63SecParentFunctionalityId = new boolean[] {false} ;
      P00BP2_A64SecFunctionalityKey = new String[] {""} ;
      P00BP2_A353SecParentFunctionalityDescript = new String[] {""} ;
      P00BP2_A351SecFunctionalityType = new byte[1] ;
      P00BP2_A350SecFunctionalityDescription = new String[] {""} ;
      P00BP2_A62SecFunctionalityId = new long[1] ;
      AV21Option = "" ;
      P00BP3_A63SecParentFunctionalityId = new long[1] ;
      P00BP3_n63SecParentFunctionalityId = new boolean[] {false} ;
      P00BP3_A350SecFunctionalityDescription = new String[] {""} ;
      P00BP3_A353SecParentFunctionalityDescript = new String[] {""} ;
      P00BP3_A351SecFunctionalityType = new byte[1] ;
      P00BP3_A64SecFunctionalityKey = new String[] {""} ;
      P00BP3_A62SecFunctionalityId = new long[1] ;
      P00BP4_A63SecParentFunctionalityId = new long[1] ;
      P00BP4_n63SecParentFunctionalityId = new boolean[] {false} ;
      P00BP4_A353SecParentFunctionalityDescript = new String[] {""} ;
      P00BP4_A351SecFunctionalityType = new byte[1] ;
      P00BP4_A350SecFunctionalityDescription = new String[] {""} ;
      P00BP4_A64SecFunctionalityKey = new String[] {""} ;
      P00BP4_A62SecFunctionalityId = new long[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.wwpbaseobjects.secfunctionalityfilterparentwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P00BP2_A63SecParentFunctionalityId, P00BP2_n63SecParentFunctionalityId, P00BP2_A64SecFunctionalityKey, P00BP2_A353SecParentFunctionalityDescript, P00BP2_A351SecFunctionalityType, P00BP2_A350SecFunctionalityDescription, P00BP2_A62SecFunctionalityId
            }
            , new Object[] {
            P00BP3_A63SecParentFunctionalityId, P00BP3_n63SecParentFunctionalityId, P00BP3_A350SecFunctionalityDescription, P00BP3_A353SecParentFunctionalityDescript, P00BP3_A351SecFunctionalityType, P00BP3_A64SecFunctionalityKey, P00BP3_A62SecFunctionalityId
            }
            , new Object[] {
            P00BP4_A63SecParentFunctionalityId, P00BP4_n63SecParentFunctionalityId, P00BP4_A353SecParentFunctionalityDescript, P00BP4_A351SecFunctionalityType, P00BP4_A350SecFunctionalityDescription, P00BP4_A64SecFunctionalityKey, P00BP4_A62SecFunctionalityId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A351SecFunctionalityType ;
   private short Gx_err ;
   private int AV52GXV1 ;
   private int AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels_size ;
   private int AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels_size ;
   private int AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels_size ;
   private int AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels_size ;
   private long AV38SecParentFunctionalityId ;
   private long AV54Wwpbaseobjects_secfunctionalityfilterparentwwds_1_secparentfunctionalityid ;
   private long A63SecParentFunctionalityId ;
   private long A62SecFunctionalityId ;
   private long AV29count ;
   private String scmdbuf ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brkBP2 ;
   private boolean n63SecParentFunctionalityId ;
   private boolean brkBP4 ;
   private boolean brkBP6 ;
   private String AV23OptionsJson ;
   private String AV26OptionsDescJson ;
   private String AV28OptionIndexesJson ;
   private String AV42TFSecFunctionalityKey_SelsJson ;
   private String AV44TFSecFunctionalityDescription_SelsJson ;
   private String AV40TFSecFunctionalityType_SelsJson ;
   private String AV46TFSecParentFunctionalityDescription_SelsJson ;
   private String AV19DDOName ;
   private String AV17SearchTxt ;
   private String AV18SearchTxtTo ;
   private String AV10TFSecFunctionalityKey ;
   private String AV12TFSecFunctionalityDescription ;
   private String AV15TFSecParentFunctionalityDescription ;
   private String A64SecFunctionalityKey ;
   private String AV55Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey ;
   private String AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription ;
   private String AV60Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription ;
   private String lV55Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey ;
   private String lV57Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription ;
   private String lV60Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription ;
   private String A350SecFunctionalityDescription ;
   private String A353SecParentFunctionalityDescript ;
   private String AV21Option ;
   private GXSimpleCollection<Byte> AV41TFSecFunctionalityType_Sels ;
   private GXSimpleCollection<Byte> AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels ;
   private com.genexus.webpanels.WebSession AV30Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private long[] P00BP2_A63SecParentFunctionalityId ;
   private boolean[] P00BP2_n63SecParentFunctionalityId ;
   private String[] P00BP2_A64SecFunctionalityKey ;
   private String[] P00BP2_A353SecParentFunctionalityDescript ;
   private byte[] P00BP2_A351SecFunctionalityType ;
   private String[] P00BP2_A350SecFunctionalityDescription ;
   private long[] P00BP2_A62SecFunctionalityId ;
   private long[] P00BP3_A63SecParentFunctionalityId ;
   private boolean[] P00BP3_n63SecParentFunctionalityId ;
   private String[] P00BP3_A350SecFunctionalityDescription ;
   private String[] P00BP3_A353SecParentFunctionalityDescript ;
   private byte[] P00BP3_A351SecFunctionalityType ;
   private String[] P00BP3_A64SecFunctionalityKey ;
   private long[] P00BP3_A62SecFunctionalityId ;
   private long[] P00BP4_A63SecParentFunctionalityId ;
   private boolean[] P00BP4_n63SecParentFunctionalityId ;
   private String[] P00BP4_A353SecParentFunctionalityDescript ;
   private byte[] P00BP4_A351SecFunctionalityType ;
   private String[] P00BP4_A350SecFunctionalityDescription ;
   private String[] P00BP4_A64SecFunctionalityKey ;
   private long[] P00BP4_A62SecFunctionalityId ;
   private GXSimpleCollection<String> AV22Options ;
   private GXSimpleCollection<String> AV25OptionsDesc ;
   private GXSimpleCollection<String> AV27OptionIndexes ;
   private GXSimpleCollection<String> AV43TFSecFunctionalityKey_Sels ;
   private GXSimpleCollection<String> AV45TFSecFunctionalityDescription_Sels ;
   private GXSimpleCollection<String> AV47TFSecParentFunctionalityDescription_Sels ;
   private GXSimpleCollection<String> AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels ;
   private GXSimpleCollection<String> AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels ;
   private GXSimpleCollection<String> AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels ;
   private web.wwpbaseobjects.SdtWWPGridState AV32GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV33GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPContext AV39WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
}

final  class secfunctionalityfilterparentwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00BP2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A64SecFunctionalityKey ,
                                          GXSimpleCollection<String> AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels ,
                                          String A350SecFunctionalityDescription ,
                                          GXSimpleCollection<String> AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels ,
                                          byte A351SecFunctionalityType ,
                                          GXSimpleCollection<Byte> AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels ,
                                          String A353SecParentFunctionalityDescript ,
                                          GXSimpleCollection<String> AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels ,
                                          int AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels_size ,
                                          String AV55Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey ,
                                          int AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels_size ,
                                          String AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription ,
                                          int AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels_size ,
                                          int AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels_size ,
                                          String AV60Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription ,
                                          long AV54Wwpbaseobjects_secfunctionalityfilterparentwwds_1_secparentfunctionalityid ,
                                          long A63SecParentFunctionalityId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[4];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T1.SecParentFunctionalityId AS SecParentFunctionalityId, T1.SecFunctionalityKey, T2.SecFunctionalityDescription AS SecParentFunctionalityDescript, T1.SecFunctionalityType," ;
      scmdbuf += " T1.SecFunctionalityDescription, T1.SecFunctionalityId FROM (SecFunctionality T1 LEFT JOIN SecFunctionality T2 ON T2.SecFunctionalityId = T1.SecParentFunctionalityId)" ;
      addWhere(sWhereString, "(T1.SecParentFunctionalityId = ?)");
      if ( ( AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.SecFunctionalityKey) like LOWER(?))");
      }
      else
      {
         GXv_int4[1] = (byte)(1) ;
      }
      if ( AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels, "T1.SecFunctionalityKey IN (", ")")+")");
      }
      if ( ( AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.SecFunctionalityDescription) like LOWER(?))");
      }
      else
      {
         GXv_int4[2] = (byte)(1) ;
      }
      if ( AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels, "T1.SecFunctionalityDescription IN (", ")")+")");
      }
      if ( AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels, "T1.SecFunctionalityType IN (", ")")+")");
      }
      if ( ( AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV60Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.SecFunctionalityDescription) like LOWER(?))");
      }
      else
      {
         GXv_int4[3] = (byte)(1) ;
      }
      if ( AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels, "T2.SecFunctionalityDescription IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.SecParentFunctionalityId, T1.SecFunctionalityKey" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P00BP3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A64SecFunctionalityKey ,
                                          GXSimpleCollection<String> AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels ,
                                          String A350SecFunctionalityDescription ,
                                          GXSimpleCollection<String> AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels ,
                                          byte A351SecFunctionalityType ,
                                          GXSimpleCollection<Byte> AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels ,
                                          String A353SecParentFunctionalityDescript ,
                                          GXSimpleCollection<String> AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels ,
                                          int AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels_size ,
                                          String AV55Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey ,
                                          int AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels_size ,
                                          String AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription ,
                                          int AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels_size ,
                                          int AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels_size ,
                                          String AV60Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription ,
                                          long AV54Wwpbaseobjects_secfunctionalityfilterparentwwds_1_secparentfunctionalityid ,
                                          long A63SecParentFunctionalityId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[4];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT T1.SecParentFunctionalityId AS SecParentFunctionalityId, T1.SecFunctionalityDescription, T2.SecFunctionalityDescription AS SecParentFunctionalityDescript," ;
      scmdbuf += " T1.SecFunctionalityType, T1.SecFunctionalityKey, T1.SecFunctionalityId FROM (SecFunctionality T1 LEFT JOIN SecFunctionality T2 ON T2.SecFunctionalityId = T1.SecParentFunctionalityId)" ;
      addWhere(sWhereString, "(T1.SecParentFunctionalityId = ?)");
      if ( ( AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.SecFunctionalityKey) like LOWER(?))");
      }
      else
      {
         GXv_int7[1] = (byte)(1) ;
      }
      if ( AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels, "T1.SecFunctionalityKey IN (", ")")+")");
      }
      if ( ( AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.SecFunctionalityDescription) like LOWER(?))");
      }
      else
      {
         GXv_int7[2] = (byte)(1) ;
      }
      if ( AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels, "T1.SecFunctionalityDescription IN (", ")")+")");
      }
      if ( AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels, "T1.SecFunctionalityType IN (", ")")+")");
      }
      if ( ( AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV60Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.SecFunctionalityDescription) like LOWER(?))");
      }
      else
      {
         GXv_int7[3] = (byte)(1) ;
      }
      if ( AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels, "T2.SecFunctionalityDescription IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.SecParentFunctionalityId, T1.SecFunctionalityDescription" ;
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
   }

   protected Object[] conditional_P00BP4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A64SecFunctionalityKey ,
                                          GXSimpleCollection<String> AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels ,
                                          String A350SecFunctionalityDescription ,
                                          GXSimpleCollection<String> AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels ,
                                          byte A351SecFunctionalityType ,
                                          GXSimpleCollection<Byte> AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels ,
                                          String A353SecParentFunctionalityDescript ,
                                          GXSimpleCollection<String> AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels ,
                                          int AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels_size ,
                                          String AV55Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey ,
                                          int AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels_size ,
                                          String AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription ,
                                          int AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels_size ,
                                          int AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels_size ,
                                          String AV60Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription ,
                                          long AV54Wwpbaseobjects_secfunctionalityfilterparentwwds_1_secparentfunctionalityid ,
                                          long A63SecParentFunctionalityId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[4];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T1.SecParentFunctionalityId AS SecParentFunctionalityId, T2.SecFunctionalityDescription AS SecParentFunctionalityDescript, T1.SecFunctionalityType, T1.SecFunctionalityDescription," ;
      scmdbuf += " T1.SecFunctionalityKey, T1.SecFunctionalityId FROM (SecFunctionality T1 LEFT JOIN SecFunctionality T2 ON T2.SecFunctionalityId = T1.SecParentFunctionalityId)" ;
      addWhere(sWhereString, "(T1.SecParentFunctionalityId = ?)");
      if ( ( AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55Wwpbaseobjects_secfunctionalityfilterparentwwds_2_tfsecfunctionalitykey)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.SecFunctionalityKey) like LOWER(?))");
      }
      else
      {
         GXv_int10[1] = (byte)(1) ;
      }
      if ( AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_3_tfsecfunctionalitykey_sels, "T1.SecFunctionalityKey IN (", ")")+")");
      }
      if ( ( AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_4_tfsecfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.SecFunctionalityDescription) like LOWER(?))");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitydescription_sels, "T1.SecFunctionalityDescription IN (", ")")+")");
      }
      if ( AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitytype_sels, "T1.SecFunctionalityType IN (", ")")+")");
      }
      if ( ( AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV60Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecparentfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.SecFunctionalityDescription) like LOWER(?))");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecparentfunctionalitydescription_sels, "T2.SecFunctionalityDescription IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.SecParentFunctionalityId, T2.SecFunctionalityDescription" ;
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
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
                  return conditional_P00BP2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).longValue() , ((Number) dynConstraints[16]).longValue() );
            case 1 :
                  return conditional_P00BP3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).longValue() , ((Number) dynConstraints[16]).longValue() );
            case 2 :
                  return conditional_P00BP4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).longValue() , ((Number) dynConstraints[16]).longValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00BP2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00BP3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00BP4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((byte[]) buf[4])[0] = rslt.getByte(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((long[]) buf[6])[0] = rslt.getLong(6);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((byte[]) buf[4])[0] = rslt.getByte(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((long[]) buf[6])[0] = rslt.getLong(6);
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((byte[]) buf[3])[0] = rslt.getByte(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((long[]) buf[6])[0] = rslt.getLong(6);
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
                  stmt.setLong(sIdx, ((Number) parms[4]).longValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 100);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[4]).longValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 100);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[4]).longValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 100);
               }
               return;
      }
   }

}

