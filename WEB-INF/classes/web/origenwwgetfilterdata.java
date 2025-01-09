package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class origenwwgetfilterdata extends GXProcedure
{
   public origenwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( origenwwgetfilterdata.class ), "" );
   }

   public origenwwgetfilterdata( int remoteHandle ,
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
      origenwwgetfilterdata.this.aP5 = new String[] {""};
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
      origenwwgetfilterdata.this.AV29DDOName = aP0;
      origenwwgetfilterdata.this.AV30SearchTxt = aP1;
      origenwwgetfilterdata.this.AV31SearchTxtTo = aP2;
      origenwwgetfilterdata.this.aP3 = aP3;
      origenwwgetfilterdata.this.aP4 = aP4;
      origenwwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV36EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      origenwwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV36EmpCod = GXt_int1 ;
      GXt_int3 = AV37CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      origenwwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV37CliCod = GXt_int3 ;
      AV19Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV21OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV22OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWOrigen", GXv_boolean6) ;
      origenwwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV29DDOName), "DDO_ORIGID") == 0 )
         {
            /* Execute user subroutine: 'LOADORIGIDOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV29DDOName), "DDO_ORIGNOMBRE") == 0 )
         {
            /* Execute user subroutine: 'LOADORIGNOMBREOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV32OptionsJson = AV19Options.toJSonString(false) ;
      AV33OptionsDescJson = AV21OptionsDesc.toJSonString(false) ;
      AV34OptionIndexesJson = AV22OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV24Session.getValue("OrigenWWGridState"), "") == 0 )
      {
         AV26GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "OrigenWWGridState"), null, null);
      }
      else
      {
         AV26GridState.fromxml(AV24Session.getValue("OrigenWWGridState"), null, null);
      }
      AV41GXV1 = 1 ;
      while ( AV41GXV1 <= AV26GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV27GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV26GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV41GXV1));
         if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFORIGID") == 0 )
         {
            AV12TFOrigId = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFORIGID_SEL") == 0 )
         {
            AV11TFOrigId_SelsJson = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFOrigId_Sels.fromJSonString(AV11TFOrigId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFORIGNOMBRE") == 0 )
         {
            AV15TFOrigNombre = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFORIGNOMBRE_SEL") == 0 )
         {
            AV14TFOrigNombre_SelsJson = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV16TFOrigNombre_Sels.fromJSonString(AV14TFOrigNombre_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV38MenuOpcCod = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV41GXV1 = (int)(AV41GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADORIGIDOPTIONS' Routine */
      returnInSub = false ;
      AV12TFOrigId = AV30SearchTxt ;
      AV13TFOrigId_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV43Origenwwds_1_tforigid = AV12TFOrigId ;
      AV44Origenwwds_2_tforigid_sels = AV13TFOrigId_Sels ;
      AV45Origenwwds_3_tforignombre = AV15TFOrigNombre ;
      AV46Origenwwds_4_tforignombre_sels = AV16TFOrigNombre_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1231OrigId ,
                                           AV44Origenwwds_2_tforigid_sels ,
                                           A1284OrigNombre ,
                                           AV46Origenwwds_4_tforignombre_sels ,
                                           Integer.valueOf(AV44Origenwwds_2_tforigid_sels.size()) ,
                                           AV43Origenwwds_1_tforigid ,
                                           Integer.valueOf(AV46Origenwwds_4_tforignombre_sels.size()) ,
                                           AV45Origenwwds_3_tforignombre } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING
                                           }
      });
      lV43Origenwwds_1_tforigid = GXutil.padr( GXutil.rtrim( AV43Origenwwds_1_tforigid), 20, "%") ;
      lV45Origenwwds_3_tforignombre = GXutil.concat( GXutil.rtrim( AV45Origenwwds_3_tforignombre), "%", "") ;
      /* Using cursor P01HM2 */
      pr_default.execute(0, new Object[] {lV43Origenwwds_1_tforigid, lV45Origenwwds_3_tforignombre});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1284OrigNombre = P01HM2_A1284OrigNombre[0] ;
         A1231OrigId = P01HM2_A1231OrigId[0] ;
         if ( ! (GXutil.strcmp("", A1231OrigId)==0) )
         {
            AV18Option = A1231OrigId ;
            AV19Options.add(AV18Option, 0);
         }
         if ( AV19Options.size() == 50 )
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
      /* 'LOADORIGNOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV15TFOrigNombre = AV30SearchTxt ;
      AV16TFOrigNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV43Origenwwds_1_tforigid = AV12TFOrigId ;
      AV44Origenwwds_2_tforigid_sels = AV13TFOrigId_Sels ;
      AV45Origenwwds_3_tforignombre = AV15TFOrigNombre ;
      AV46Origenwwds_4_tforignombre_sels = AV16TFOrigNombre_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A1231OrigId ,
                                           AV44Origenwwds_2_tforigid_sels ,
                                           A1284OrigNombre ,
                                           AV46Origenwwds_4_tforignombre_sels ,
                                           Integer.valueOf(AV44Origenwwds_2_tforigid_sels.size()) ,
                                           AV43Origenwwds_1_tforigid ,
                                           Integer.valueOf(AV46Origenwwds_4_tforignombre_sels.size()) ,
                                           AV45Origenwwds_3_tforignombre } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING
                                           }
      });
      lV43Origenwwds_1_tforigid = GXutil.padr( GXutil.rtrim( AV43Origenwwds_1_tforigid), 20, "%") ;
      lV45Origenwwds_3_tforignombre = GXutil.concat( GXutil.rtrim( AV45Origenwwds_3_tforignombre), "%", "") ;
      /* Using cursor P01HM3 */
      pr_default.execute(1, new Object[] {lV43Origenwwds_1_tforigid, lV45Origenwwds_3_tforignombre});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1HM3 = false ;
         A1284OrigNombre = P01HM3_A1284OrigNombre[0] ;
         A1231OrigId = P01HM3_A1231OrigId[0] ;
         AV23count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P01HM3_A1284OrigNombre[0], A1284OrigNombre) == 0 ) )
         {
            brk1HM3 = false ;
            A1231OrigId = P01HM3_A1231OrigId[0] ;
            AV23count = (long)(AV23count+1) ;
            brk1HM3 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A1284OrigNombre)==0) )
         {
            AV18Option = A1284OrigNombre ;
            AV19Options.add(AV18Option, 0);
            AV22OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV23count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV19Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1HM3 )
         {
            brk1HM3 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = origenwwgetfilterdata.this.AV32OptionsJson;
      this.aP4[0] = origenwwgetfilterdata.this.AV33OptionsDescJson;
      this.aP5[0] = origenwwgetfilterdata.this.AV34OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV32OptionsJson = "" ;
      AV33OptionsDescJson = "" ;
      AV34OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV19Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV21OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV22OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV24Session = httpContext.getWebSession();
      AV26GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV27GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV12TFOrigId = "" ;
      AV11TFOrigId_SelsJson = "" ;
      AV13TFOrigId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV15TFOrigNombre = "" ;
      AV14TFOrigNombre_SelsJson = "" ;
      AV16TFOrigNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38MenuOpcCod = "" ;
      A1231OrigId = "" ;
      AV43Origenwwds_1_tforigid = "" ;
      AV44Origenwwds_2_tforigid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV45Origenwwds_3_tforignombre = "" ;
      AV46Origenwwds_4_tforignombre_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV43Origenwwds_1_tforigid = "" ;
      lV45Origenwwds_3_tforignombre = "" ;
      A1284OrigNombre = "" ;
      P01HM2_A1284OrigNombre = new String[] {""} ;
      P01HM2_A1231OrigId = new String[] {""} ;
      AV18Option = "" ;
      P01HM3_A1284OrigNombre = new String[] {""} ;
      P01HM3_A1231OrigId = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.origenwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01HM2_A1284OrigNombre, P01HM2_A1231OrigId
            }
            , new Object[] {
            P01HM3_A1284OrigNombre, P01HM3_A1231OrigId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV36EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV37CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV41GXV1 ;
   private int AV44Origenwwds_2_tforigid_sels_size ;
   private int AV46Origenwwds_4_tforignombre_sels_size ;
   private long AV23count ;
   private String AV12TFOrigId ;
   private String A1231OrigId ;
   private String AV43Origenwwds_1_tforigid ;
   private String scmdbuf ;
   private String lV43Origenwwds_1_tforigid ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk1HM3 ;
   private String AV32OptionsJson ;
   private String AV33OptionsDescJson ;
   private String AV34OptionIndexesJson ;
   private String AV11TFOrigId_SelsJson ;
   private String AV14TFOrigNombre_SelsJson ;
   private String AV29DDOName ;
   private String AV30SearchTxt ;
   private String AV31SearchTxtTo ;
   private String AV15TFOrigNombre ;
   private String AV38MenuOpcCod ;
   private String AV45Origenwwds_3_tforignombre ;
   private String lV45Origenwwds_3_tforignombre ;
   private String A1284OrigNombre ;
   private String AV18Option ;
   private com.genexus.webpanels.WebSession AV24Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01HM2_A1284OrigNombre ;
   private String[] P01HM2_A1231OrigId ;
   private String[] P01HM3_A1284OrigNombre ;
   private String[] P01HM3_A1231OrigId ;
   private GXSimpleCollection<String> AV13TFOrigId_Sels ;
   private GXSimpleCollection<String> AV44Origenwwds_2_tforigid_sels ;
   private GXSimpleCollection<String> AV19Options ;
   private GXSimpleCollection<String> AV21OptionsDesc ;
   private GXSimpleCollection<String> AV22OptionIndexes ;
   private GXSimpleCollection<String> AV16TFOrigNombre_Sels ;
   private GXSimpleCollection<String> AV46Origenwwds_4_tforignombre_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV26GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV27GridStateFilterValue ;
}

final  class origenwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01HM2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1231OrigId ,
                                          GXSimpleCollection<String> AV44Origenwwds_2_tforigid_sels ,
                                          String A1284OrigNombre ,
                                          GXSimpleCollection<String> AV46Origenwwds_4_tforignombre_sels ,
                                          int AV44Origenwwds_2_tforigid_sels_size ,
                                          String AV43Origenwwds_1_tforigid ,
                                          int AV46Origenwwds_4_tforignombre_sels_size ,
                                          String AV45Origenwwds_3_tforignombre )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[2];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT DISTINCT NULL AS OrigNombre, OrigId FROM ( SELECT OrigNombre, OrigId FROM Origen" ;
      if ( ( AV44Origenwwds_2_tforigid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV43Origenwwds_1_tforigid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OrigId) like LOWER(?))");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( AV44Origenwwds_2_tforigid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV44Origenwwds_2_tforigid_sels, "OrigId IN (", ")")+")");
      }
      if ( ( AV46Origenwwds_4_tforignombre_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV45Origenwwds_3_tforignombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OrigNombre) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV46Origenwwds_4_tforignombre_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV46Origenwwds_4_tforignombre_sels, "OrigNombre IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY OrigId" ;
      scmdbuf += ") DistinctT" ;
      scmdbuf += " ORDER BY OrigId" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P01HM3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1231OrigId ,
                                          GXSimpleCollection<String> AV44Origenwwds_2_tforigid_sels ,
                                          String A1284OrigNombre ,
                                          GXSimpleCollection<String> AV46Origenwwds_4_tforignombre_sels ,
                                          int AV44Origenwwds_2_tforigid_sels_size ,
                                          String AV43Origenwwds_1_tforigid ,
                                          int AV46Origenwwds_4_tforignombre_sels_size ,
                                          String AV45Origenwwds_3_tforignombre )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[2];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT OrigNombre, OrigId FROM Origen" ;
      if ( ( AV44Origenwwds_2_tforigid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV43Origenwwds_1_tforigid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OrigId) like LOWER(?))");
      }
      else
      {
         GXv_int11[0] = (byte)(1) ;
      }
      if ( AV44Origenwwds_2_tforigid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV44Origenwwds_2_tforigid_sels, "OrigId IN (", ")")+")");
      }
      if ( ( AV46Origenwwds_4_tforignombre_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV45Origenwwds_3_tforignombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OrigNombre) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV46Origenwwds_4_tforignombre_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV46Origenwwds_4_tforignombre_sels, "OrigNombre IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY OrigNombre" ;
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
                  return conditional_P01HM2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] );
            case 1 :
                  return conditional_P01HM3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01HM2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01HM3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
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
                  stmt.setString(sIdx, (String)parms[2], 20);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 30);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[2], 20);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 30);
               }
               return;
      }
   }

}

