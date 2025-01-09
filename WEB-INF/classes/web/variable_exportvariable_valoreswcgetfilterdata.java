package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class variable_exportvariable_valoreswcgetfilterdata extends GXProcedure
{
   public variable_exportvariable_valoreswcgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( variable_exportvariable_valoreswcgetfilterdata.class ), "" );
   }

   public variable_exportvariable_valoreswcgetfilterdata( int remoteHandle ,
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
      variable_exportvariable_valoreswcgetfilterdata.this.aP5 = new String[] {""};
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
      variable_exportvariable_valoreswcgetfilterdata.this.AV26DDOName = aP0;
      variable_exportvariable_valoreswcgetfilterdata.this.AV27SearchTxt = aP1;
      variable_exportvariable_valoreswcgetfilterdata.this.AV28SearchTxtTo = aP2;
      variable_exportvariable_valoreswcgetfilterdata.this.aP3 = aP3;
      variable_exportvariable_valoreswcgetfilterdata.this.aP4 = aP4;
      variable_exportvariable_valoreswcgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV16Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV18OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV19OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWvariable_valores", GXv_boolean2) ;
      variable_exportvariable_valoreswcgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(GXutil.upper( AV26DDOName), "DDO_OPECLIVRELREF") == 0 )
         {
            /* Execute user subroutine: 'LOADOPECLIVRELREFOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV29OptionsJson = AV16Options.toJSonString(false) ;
      AV30OptionsDescJson = AV18OptionsDesc.toJSonString(false) ;
      AV31OptionIndexesJson = AV19OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV21Session.getValue("Variable_exportvariable_valoresWCGridState"), "") == 0 )
      {
         AV23GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "Variable_exportvariable_valoresWCGridState"), null, null);
      }
      else
      {
         AV23GridState.fromxml(AV21Session.getValue("Variable_exportvariable_valoresWCGridState"), null, null);
      }
      AV40GXV1 = 1 ;
      while ( AV40GXV1 <= AV23GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV24GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV23GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV40GXV1));
         if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIVRELREF") == 0 )
         {
            AV36TFOpeCliVRelRef = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECLIVRELREF_SEL") == 0 )
         {
            AV35TFOpeCliVRelRef_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV37TFOpeCliVRelRef_Sels.fromJSonString(AV35TFOpeCliVRelRef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CLICOD") == 0 )
         {
            AV32CliCod = (int)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&OPECLIID") == 0 )
         {
            AV33OpeCliId = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV40GXV1 = (int)(AV40GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADOPECLIVRELREFOPTIONS' Routine */
      returnInSub = false ;
      AV36TFOpeCliVRelRef = AV27SearchTxt ;
      AV37TFOpeCliVRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A2010OpeCliVRelRef ,
                                           AV37TFOpeCliVRelRef_Sels ,
                                           Integer.valueOf(AV37TFOpeCliVRelRef_Sels.size()) ,
                                           AV36TFOpeCliVRelRef ,
                                           Integer.valueOf(AV32CliCod) ,
                                           AV33OpeCliId ,
                                           Integer.valueOf(A3CliCod) ,
                                           A82OpeCliId } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING
                                           }
      });
      lV36TFOpeCliVRelRef = GXutil.concat( GXutil.rtrim( AV36TFOpeCliVRelRef), "%", "") ;
      /* Using cursor P01UE2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV32CliCod), AV33OpeCliId, lV36TFOpeCliVRelRef});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1UE2 = false ;
         A3CliCod = P01UE2_A3CliCod[0] ;
         A82OpeCliId = P01UE2_A82OpeCliId[0] ;
         A2010OpeCliVRelRef = P01UE2_A2010OpeCliVRelRef[0] ;
         A754OpeCliVig = P01UE2_A754OpeCliVig[0] ;
         AV20count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P01UE2_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P01UE2_A82OpeCliId[0], A82OpeCliId) == 0 ) && ( GXutil.strcmp(P01UE2_A2010OpeCliVRelRef[0], A2010OpeCliVRelRef) == 0 ) )
         {
            brk1UE2 = false ;
            A754OpeCliVig = P01UE2_A754OpeCliVig[0] ;
            AV20count = (long)(AV20count+1) ;
            brk1UE2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A2010OpeCliVRelRef)==0) )
         {
            AV15Option = A2010OpeCliVRelRef ;
            AV16Options.add(AV15Option, 0);
            AV19OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV20count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV16Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1UE2 )
         {
            brk1UE2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = variable_exportvariable_valoreswcgetfilterdata.this.AV29OptionsJson;
      this.aP4[0] = variable_exportvariable_valoreswcgetfilterdata.this.AV30OptionsDescJson;
      this.aP5[0] = variable_exportvariable_valoreswcgetfilterdata.this.AV31OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV29OptionsJson = "" ;
      AV30OptionsDescJson = "" ;
      AV31OptionIndexesJson = "" ;
      AV16Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV18OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV19OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV21Session = httpContext.getWebSession();
      AV23GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV24GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV36TFOpeCliVRelRef = "" ;
      AV35TFOpeCliVRelRef_SelsJson = "" ;
      AV37TFOpeCliVRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV33OpeCliId = "" ;
      scmdbuf = "" ;
      lV36TFOpeCliVRelRef = "" ;
      A2010OpeCliVRelRef = "" ;
      A82OpeCliId = "" ;
      P01UE2_A3CliCod = new int[1] ;
      P01UE2_A82OpeCliId = new String[] {""} ;
      P01UE2_A2010OpeCliVRelRef = new String[] {""} ;
      P01UE2_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      A754OpeCliVig = GXutil.nullDate() ;
      AV15Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.variable_exportvariable_valoreswcgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01UE2_A3CliCod, P01UE2_A82OpeCliId, P01UE2_A2010OpeCliVRelRef, P01UE2_A754OpeCliVig
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV40GXV1 ;
   private int AV32CliCod ;
   private int AV37TFOpeCliVRelRef_Sels_size ;
   private int A3CliCod ;
   private long AV20count ;
   private String AV33OpeCliId ;
   private String scmdbuf ;
   private String A82OpeCliId ;
   private java.util.Date A754OpeCliVig ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk1UE2 ;
   private String AV29OptionsJson ;
   private String AV30OptionsDescJson ;
   private String AV31OptionIndexesJson ;
   private String AV35TFOpeCliVRelRef_SelsJson ;
   private String AV26DDOName ;
   private String AV27SearchTxt ;
   private String AV28SearchTxtTo ;
   private String AV36TFOpeCliVRelRef ;
   private String lV36TFOpeCliVRelRef ;
   private String A2010OpeCliVRelRef ;
   private String AV15Option ;
   private com.genexus.webpanels.WebSession AV21Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P01UE2_A3CliCod ;
   private String[] P01UE2_A82OpeCliId ;
   private String[] P01UE2_A2010OpeCliVRelRef ;
   private java.util.Date[] P01UE2_A754OpeCliVig ;
   private GXSimpleCollection<String> AV16Options ;
   private GXSimpleCollection<String> AV18OptionsDesc ;
   private GXSimpleCollection<String> AV19OptionIndexes ;
   private GXSimpleCollection<String> AV37TFOpeCliVRelRef_Sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV23GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV24GridStateFilterValue ;
}

final  class variable_exportvariable_valoreswcgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01UE2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2010OpeCliVRelRef ,
                                          GXSimpleCollection<String> AV37TFOpeCliVRelRef_Sels ,
                                          int AV37TFOpeCliVRelRef_Sels_size ,
                                          String AV36TFOpeCliVRelRef ,
                                          int AV32CliCod ,
                                          String AV33OpeCliId ,
                                          int A3CliCod ,
                                          String A82OpeCliId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[3];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT CliCod, OpeCliId, OpeCliVRelRef, OpeCliVig FROM variable_valores" ;
      addWhere(sWhereString, "(CliCod = ? and OpeCliId = ( ?))");
      if ( ( AV37TFOpeCliVRelRef_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV36TFOpeCliVRelRef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeCliVRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int4[2] = (byte)(1) ;
      }
      if ( AV37TFOpeCliVRelRef_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV37TFOpeCliVRelRef_Sels, "OpeCliVRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, OpeCliId, OpeCliVRelRef" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
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
                  return conditional_P01UE2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , (String)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01UE2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
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
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[4], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 40);
               }
               return;
      }
   }

}

