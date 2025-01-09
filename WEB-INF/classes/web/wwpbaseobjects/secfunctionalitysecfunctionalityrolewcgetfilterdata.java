package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class secfunctionalitysecfunctionalityrolewcgetfilterdata extends GXProcedure
{
   public secfunctionalitysecfunctionalityrolewcgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secfunctionalitysecfunctionalityrolewcgetfilterdata.class ), "" );
   }

   public secfunctionalitysecfunctionalityrolewcgetfilterdata( int remoteHandle ,
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
      secfunctionalitysecfunctionalityrolewcgetfilterdata.this.aP5 = new String[] {""};
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
      secfunctionalitysecfunctionalityrolewcgetfilterdata.this.AV16DDOName = aP0;
      secfunctionalitysecfunctionalityrolewcgetfilterdata.this.AV14SearchTxt = aP1;
      secfunctionalitysecfunctionalityrolewcgetfilterdata.this.AV15SearchTxtTo = aP2;
      secfunctionalitysecfunctionalityrolewcgetfilterdata.this.aP3 = aP3;
      secfunctionalitysecfunctionalityrolewcgetfilterdata.this.aP4 = aP4;
      secfunctionalitysecfunctionalityrolewcgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV19Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV22OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV24OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSecFunctionality", GXv_boolean2) ;
      secfunctionalitysecfunctionalityrolewcgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV33WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV33WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(GXutil.upper( AV16DDOName), "DDO_SECROLENAME") == 0 )
         {
            /* Execute user subroutine: 'LOADSECROLENAMEOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV16DDOName), "DDO_SECROLEDESCRIPTION") == 0 )
         {
            /* Execute user subroutine: 'LOADSECROLEDESCRIPTIONOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV20OptionsJson = AV19Options.toJSonString(false) ;
      AV23OptionsDescJson = AV22OptionsDesc.toJSonString(false) ;
      AV25OptionIndexesJson = AV24OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV27Session.getValue("WWPBaseObjects.SecFunctionalitySecFunctionalityRoleWCGridState"), "") == 0 )
      {
         AV29GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "WWPBaseObjects.SecFunctionalitySecFunctionalityRoleWCGridState"), null, null);
      }
      else
      {
         AV29GridState.fromxml(AV27Session.getValue("WWPBaseObjects.SecFunctionalitySecFunctionalityRoleWCGridState"), null, null);
      }
      AV42GXV1 = 1 ;
      while ( AV42GXV1 <= AV29GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV30GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV29GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV42GXV1));
         if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLENAME") == 0 )
         {
            AV10TFSecRoleName = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLENAME_SEL") == 0 )
         {
            AV34TFSecRoleName_SelsJson = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV35TFSecRoleName_Sels.fromJSonString(AV34TFSecRoleName_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLEDESCRIPTION") == 0 )
         {
            AV12TFSecRoleDescription = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLEDESCRIPTION_SEL") == 0 )
         {
            AV36TFSecRoleDescription_SelsJson = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV37TFSecRoleDescription_Sels.fromJSonString(AV36TFSecRoleDescription_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&SECFUNCTIONALITYID") == 0 )
         {
            AV32SecFunctionalityId = GXutil.lval( AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
         }
         AV42GXV1 = (int)(AV42GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADSECROLENAMEOPTIONS' Routine */
      returnInSub = false ;
      AV10TFSecRoleName = AV14SearchTxt ;
      AV35TFSecRoleName_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A355SecRoleName ,
                                           AV35TFSecRoleName_Sels ,
                                           A354SecRoleDescription ,
                                           AV37TFSecRoleDescription_Sels ,
                                           Integer.valueOf(AV35TFSecRoleName_Sels.size()) ,
                                           AV10TFSecRoleName ,
                                           Integer.valueOf(AV37TFSecRoleDescription_Sels.size()) ,
                                           AV12TFSecRoleDescription ,
                                           Long.valueOf(AV32SecFunctionalityId) ,
                                           Long.valueOf(A62SecFunctionalityId) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG
                                           }
      });
      lV10TFSecRoleName = GXutil.concat( GXutil.rtrim( AV10TFSecRoleName), "%", "") ;
      lV12TFSecRoleDescription = GXutil.concat( GXutil.rtrim( AV12TFSecRoleDescription), "%", "") ;
      /* Using cursor P00BR2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV32SecFunctionalityId), lV10TFSecRoleName, lV12TFSecRoleDescription});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brkBR2 = false ;
         A65SecRoleId = P00BR2_A65SecRoleId[0] ;
         A62SecFunctionalityId = P00BR2_A62SecFunctionalityId[0] ;
         A355SecRoleName = P00BR2_A355SecRoleName[0] ;
         A354SecRoleDescription = P00BR2_A354SecRoleDescription[0] ;
         A355SecRoleName = P00BR2_A355SecRoleName[0] ;
         A354SecRoleDescription = P00BR2_A354SecRoleDescription[0] ;
         AV26count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P00BR2_A62SecFunctionalityId[0] == A62SecFunctionalityId ) && ( GXutil.strcmp(P00BR2_A355SecRoleName[0], A355SecRoleName) == 0 ) )
         {
            brkBR2 = false ;
            A65SecRoleId = P00BR2_A65SecRoleId[0] ;
            AV26count = (long)(AV26count+1) ;
            brkBR2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A355SecRoleName)==0) )
         {
            AV18Option = A355SecRoleName ;
            AV19Options.add(AV18Option, 0);
            AV24OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV26count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV19Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brkBR2 )
         {
            brkBR2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADSECROLEDESCRIPTIONOPTIONS' Routine */
      returnInSub = false ;
      AV12TFSecRoleDescription = AV14SearchTxt ;
      AV37TFSecRoleDescription_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A355SecRoleName ,
                                           AV35TFSecRoleName_Sels ,
                                           A354SecRoleDescription ,
                                           AV37TFSecRoleDescription_Sels ,
                                           Integer.valueOf(AV35TFSecRoleName_Sels.size()) ,
                                           AV10TFSecRoleName ,
                                           Integer.valueOf(AV37TFSecRoleDescription_Sels.size()) ,
                                           AV12TFSecRoleDescription ,
                                           Long.valueOf(AV32SecFunctionalityId) ,
                                           Long.valueOf(A62SecFunctionalityId) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG
                                           }
      });
      lV10TFSecRoleName = GXutil.concat( GXutil.rtrim( AV10TFSecRoleName), "%", "") ;
      lV12TFSecRoleDescription = GXutil.concat( GXutil.rtrim( AV12TFSecRoleDescription), "%", "") ;
      /* Using cursor P00BR3 */
      pr_default.execute(1, new Object[] {Long.valueOf(AV32SecFunctionalityId), lV10TFSecRoleName, lV12TFSecRoleDescription});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brkBR4 = false ;
         A65SecRoleId = P00BR3_A65SecRoleId[0] ;
         A62SecFunctionalityId = P00BR3_A62SecFunctionalityId[0] ;
         A354SecRoleDescription = P00BR3_A354SecRoleDescription[0] ;
         A355SecRoleName = P00BR3_A355SecRoleName[0] ;
         A354SecRoleDescription = P00BR3_A354SecRoleDescription[0] ;
         A355SecRoleName = P00BR3_A355SecRoleName[0] ;
         AV26count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( P00BR3_A62SecFunctionalityId[0] == A62SecFunctionalityId ) && ( GXutil.strcmp(P00BR3_A354SecRoleDescription[0], A354SecRoleDescription) == 0 ) )
         {
            brkBR4 = false ;
            A65SecRoleId = P00BR3_A65SecRoleId[0] ;
            AV26count = (long)(AV26count+1) ;
            brkBR4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A354SecRoleDescription)==0) )
         {
            AV18Option = A354SecRoleDescription ;
            AV19Options.add(AV18Option, 0);
            AV24OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV26count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV19Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brkBR4 )
         {
            brkBR4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = secfunctionalitysecfunctionalityrolewcgetfilterdata.this.AV20OptionsJson;
      this.aP4[0] = secfunctionalitysecfunctionalityrolewcgetfilterdata.this.AV23OptionsDescJson;
      this.aP5[0] = secfunctionalitysecfunctionalityrolewcgetfilterdata.this.AV25OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV20OptionsJson = "" ;
      AV23OptionsDescJson = "" ;
      AV25OptionIndexesJson = "" ;
      AV19Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV22OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV24OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV33WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV27Session = httpContext.getWebSession();
      AV29GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV30GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV10TFSecRoleName = "" ;
      AV34TFSecRoleName_SelsJson = "" ;
      AV35TFSecRoleName_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV12TFSecRoleDescription = "" ;
      AV36TFSecRoleDescription_SelsJson = "" ;
      AV37TFSecRoleDescription_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV10TFSecRoleName = "" ;
      lV12TFSecRoleDescription = "" ;
      A355SecRoleName = "" ;
      A354SecRoleDescription = "" ;
      P00BR2_A65SecRoleId = new short[1] ;
      P00BR2_A62SecFunctionalityId = new long[1] ;
      P00BR2_A355SecRoleName = new String[] {""} ;
      P00BR2_A354SecRoleDescription = new String[] {""} ;
      AV18Option = "" ;
      P00BR3_A65SecRoleId = new short[1] ;
      P00BR3_A62SecFunctionalityId = new long[1] ;
      P00BR3_A354SecRoleDescription = new String[] {""} ;
      P00BR3_A355SecRoleName = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.wwpbaseobjects.secfunctionalitysecfunctionalityrolewcgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P00BR2_A65SecRoleId, P00BR2_A62SecFunctionalityId, P00BR2_A355SecRoleName, P00BR2_A354SecRoleDescription
            }
            , new Object[] {
            P00BR3_A65SecRoleId, P00BR3_A62SecFunctionalityId, P00BR3_A354SecRoleDescription, P00BR3_A355SecRoleName
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A65SecRoleId ;
   private short Gx_err ;
   private int AV42GXV1 ;
   private int AV35TFSecRoleName_Sels_size ;
   private int AV37TFSecRoleDescription_Sels_size ;
   private long AV32SecFunctionalityId ;
   private long A62SecFunctionalityId ;
   private long AV26count ;
   private String scmdbuf ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brkBR2 ;
   private boolean brkBR4 ;
   private String AV20OptionsJson ;
   private String AV23OptionsDescJson ;
   private String AV25OptionIndexesJson ;
   private String AV34TFSecRoleName_SelsJson ;
   private String AV36TFSecRoleDescription_SelsJson ;
   private String AV16DDOName ;
   private String AV14SearchTxt ;
   private String AV15SearchTxtTo ;
   private String AV10TFSecRoleName ;
   private String AV12TFSecRoleDescription ;
   private String lV10TFSecRoleName ;
   private String lV12TFSecRoleDescription ;
   private String A355SecRoleName ;
   private String A354SecRoleDescription ;
   private String AV18Option ;
   private com.genexus.webpanels.WebSession AV27Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private short[] P00BR2_A65SecRoleId ;
   private long[] P00BR2_A62SecFunctionalityId ;
   private String[] P00BR2_A355SecRoleName ;
   private String[] P00BR2_A354SecRoleDescription ;
   private short[] P00BR3_A65SecRoleId ;
   private long[] P00BR3_A62SecFunctionalityId ;
   private String[] P00BR3_A354SecRoleDescription ;
   private String[] P00BR3_A355SecRoleName ;
   private GXSimpleCollection<String> AV19Options ;
   private GXSimpleCollection<String> AV22OptionsDesc ;
   private GXSimpleCollection<String> AV24OptionIndexes ;
   private GXSimpleCollection<String> AV35TFSecRoleName_Sels ;
   private GXSimpleCollection<String> AV37TFSecRoleDescription_Sels ;
   private web.wwpbaseobjects.SdtWWPGridState AV29GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV30GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPContext AV33WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
}

final  class secfunctionalitysecfunctionalityrolewcgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00BR2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A355SecRoleName ,
                                          GXSimpleCollection<String> AV35TFSecRoleName_Sels ,
                                          String A354SecRoleDescription ,
                                          GXSimpleCollection<String> AV37TFSecRoleDescription_Sels ,
                                          int AV35TFSecRoleName_Sels_size ,
                                          String AV10TFSecRoleName ,
                                          int AV37TFSecRoleDescription_Sels_size ,
                                          String AV12TFSecRoleDescription ,
                                          long AV32SecFunctionalityId ,
                                          long A62SecFunctionalityId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[3];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T1.SecRoleId, T1.SecFunctionalityId, T2.SecRoleName, T2.SecRoleDescription FROM (SecFunctionalityRole T1 INNER JOIN SecRole T2 ON T2.SecRoleId = T1.SecRoleId)" ;
      addWhere(sWhereString, "(T1.SecFunctionalityId = ?)");
      if ( ( AV35TFSecRoleName_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV10TFSecRoleName)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.SecRoleName) like LOWER(?))");
      }
      else
      {
         GXv_int4[1] = (byte)(1) ;
      }
      if ( AV35TFSecRoleName_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV35TFSecRoleName_Sels, "T2.SecRoleName IN (", ")")+")");
      }
      if ( ( AV37TFSecRoleDescription_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFSecRoleDescription)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.SecRoleDescription) like LOWER(?))");
      }
      else
      {
         GXv_int4[2] = (byte)(1) ;
      }
      if ( AV37TFSecRoleDescription_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV37TFSecRoleDescription_Sels, "T2.SecRoleDescription IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.SecFunctionalityId, T2.SecRoleName" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P00BR3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A355SecRoleName ,
                                          GXSimpleCollection<String> AV35TFSecRoleName_Sels ,
                                          String A354SecRoleDescription ,
                                          GXSimpleCollection<String> AV37TFSecRoleDescription_Sels ,
                                          int AV35TFSecRoleName_Sels_size ,
                                          String AV10TFSecRoleName ,
                                          int AV37TFSecRoleDescription_Sels_size ,
                                          String AV12TFSecRoleDescription ,
                                          long AV32SecFunctionalityId ,
                                          long A62SecFunctionalityId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[3];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT T1.SecRoleId, T1.SecFunctionalityId, T2.SecRoleDescription, T2.SecRoleName FROM (SecFunctionalityRole T1 INNER JOIN SecRole T2 ON T2.SecRoleId = T1.SecRoleId)" ;
      addWhere(sWhereString, "(T1.SecFunctionalityId = ?)");
      if ( ( AV35TFSecRoleName_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV10TFSecRoleName)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.SecRoleName) like LOWER(?))");
      }
      else
      {
         GXv_int7[1] = (byte)(1) ;
      }
      if ( AV35TFSecRoleName_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV35TFSecRoleName_Sels, "T2.SecRoleName IN (", ")")+")");
      }
      if ( ( AV37TFSecRoleDescription_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFSecRoleDescription)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.SecRoleDescription) like LOWER(?))");
      }
      else
      {
         GXv_int7[2] = (byte)(1) ;
      }
      if ( AV37TFSecRoleDescription_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV37TFSecRoleDescription_Sels, "T2.SecRoleDescription IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.SecFunctionalityId, T2.SecRoleDescription" ;
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
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
                  return conditional_P00BR2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).longValue() , ((Number) dynConstraints[9]).longValue() );
            case 1 :
                  return conditional_P00BR3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).longValue() , ((Number) dynConstraints[9]).longValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00BR2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00BR3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
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
                  stmt.setLong(sIdx, ((Number) parms[3]).longValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[4], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 120);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[3]).longValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[4], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 120);
               }
               return;
      }
   }

}

