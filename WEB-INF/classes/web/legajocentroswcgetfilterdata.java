package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class legajocentroswcgetfilterdata extends GXProcedure
{
   public legajocentroswcgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajocentroswcgetfilterdata.class ), "" );
   }

   public legajocentroswcgetfilterdata( int remoteHandle ,
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
      legajocentroswcgetfilterdata.this.aP5 = new String[] {""};
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
      legajocentroswcgetfilterdata.this.AV20DDOName = aP0;
      legajocentroswcgetfilterdata.this.AV18SearchTxt = aP1;
      legajocentroswcgetfilterdata.this.AV19SearchTxtTo = aP2;
      legajocentroswcgetfilterdata.this.aP3 = aP3;
      legajocentroswcgetfilterdata.this.aP4 = aP4;
      legajocentroswcgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV23Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV26OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV28OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLegajo", GXv_boolean2) ;
      legajocentroswcgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV20DDOName), "DDO_CENDESCRIPCION") == 0 )
         {
            /* Execute user subroutine: 'LOADCENDESCRIPCIONOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV24OptionsJson = AV23Options.toJSonString(false) ;
      AV27OptionsDescJson = AV26OptionsDesc.toJSonString(false) ;
      AV29OptionIndexesJson = AV28OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV31Session.getValue("LegajoCentrosWCGridState"), "") == 0 )
      {
         AV33GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "LegajoCentrosWCGridState"), null, null);
      }
      else
      {
         AV33GridState.fromxml(AV31Session.getValue("LegajoCentrosWCGridState"), null, null);
      }
      AV41GXV1 = 1 ;
      while ( AV41GXV1 <= AV33GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV34GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV33GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV41GXV1));
         if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCENCODIGO") == 0 )
         {
            AV11TFCenCodigo = (short)(GXutil.lval( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFCenCodigo_To = (short)(GXutil.lval( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCENDESCRIPCION") == 0 )
         {
            AV14TFCenDescripcion = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCENDESCRIPCION_SEL") == 0 )
         {
            AV13TFCenDescripcion_SelsJson = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV15TFCenDescripcion_Sels.fromJSonString(AV13TFCenDescripcion_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCENPRC") == 0 )
         {
            AV16TFLegCenPrc = CommonUtil.decimalVal( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV17TFLegCenPrc_To = CommonUtil.decimalVal( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CLICOD") == 0 )
         {
            AV36CliCod = (int)(GXutil.lval( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&EMPCOD") == 0 )
         {
            AV37EmpCod = (short)(GXutil.lval( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&LEGNUMERO") == 0 )
         {
            AV38LegNumero = (int)(GXutil.lval( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         AV41GXV1 = (int)(AV41GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADCENDESCRIPCIONOPTIONS' Routine */
      returnInSub = false ;
      AV14TFCenDescripcion = AV18SearchTxt ;
      AV15TFCenDescripcion_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A483CenDescripcion ,
                                           AV15TFCenDescripcion_Sels ,
                                           Short.valueOf(AV11TFCenCodigo) ,
                                           Short.valueOf(AV12TFCenCodigo_To) ,
                                           Integer.valueOf(AV15TFCenDescripcion_Sels.size()) ,
                                           AV14TFCenDescripcion ,
                                           AV16TFLegCenPrc ,
                                           AV17TFLegCenPrc_To ,
                                           Short.valueOf(A77CenCodigo) ,
                                           A484LegCenPrc ,
                                           Integer.valueOf(AV36CliCod) ,
                                           Short.valueOf(AV37EmpCod) ,
                                           Integer.valueOf(AV38LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      lV14TFCenDescripcion = GXutil.concat( GXutil.rtrim( AV14TFCenDescripcion), "%", "") ;
      /* Using cursor P00H62 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV36CliCod), Short.valueOf(AV37EmpCod), Integer.valueOf(AV38LegNumero), Short.valueOf(AV11TFCenCodigo), Short.valueOf(AV12TFCenCodigo_To), lV14TFCenDescripcion, AV16TFLegCenPrc, AV17TFLegCenPrc_To});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brkH62 = false ;
         A77CenCodigo = P00H62_A77CenCodigo[0] ;
         A6LegNumero = P00H62_A6LegNumero[0] ;
         A1EmpCod = P00H62_A1EmpCod[0] ;
         A3CliCod = P00H62_A3CliCod[0] ;
         A484LegCenPrc = P00H62_A484LegCenPrc[0] ;
         A483CenDescripcion = P00H62_A483CenDescripcion[0] ;
         A483CenDescripcion = P00H62_A483CenDescripcion[0] ;
         AV30count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P00H62_A3CliCod[0] == A3CliCod ) && ( P00H62_A1EmpCod[0] == A1EmpCod ) && ( P00H62_A6LegNumero[0] == A6LegNumero ) && ( P00H62_A77CenCodigo[0] == A77CenCodigo ) )
         {
            brkH62 = false ;
            AV30count = (long)(AV30count+1) ;
            brkH62 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A483CenDescripcion)==0) )
         {
            AV22Option = A483CenDescripcion ;
            AV21InsertIndex = 1 ;
            while ( ( AV21InsertIndex <= AV23Options.size() ) && ( GXutil.strcmp((String)AV23Options.elementAt(-1+AV21InsertIndex), AV22Option) < 0 ) )
            {
               AV21InsertIndex = (int)(AV21InsertIndex+1) ;
            }
            AV23Options.add(AV22Option, AV21InsertIndex);
            AV28OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV30count), "Z,ZZZ,ZZZ,ZZ9")), AV21InsertIndex);
         }
         if ( AV23Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brkH62 )
         {
            brkH62 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = legajocentroswcgetfilterdata.this.AV24OptionsJson;
      this.aP4[0] = legajocentroswcgetfilterdata.this.AV27OptionsDescJson;
      this.aP5[0] = legajocentroswcgetfilterdata.this.AV29OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV24OptionsJson = "" ;
      AV27OptionsDescJson = "" ;
      AV29OptionIndexesJson = "" ;
      AV23Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV26OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV28OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV31Session = httpContext.getWebSession();
      AV33GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV34GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV14TFCenDescripcion = "" ;
      AV13TFCenDescripcion_SelsJson = "" ;
      AV15TFCenDescripcion_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV16TFLegCenPrc = DecimalUtil.ZERO ;
      AV17TFLegCenPrc_To = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      lV14TFCenDescripcion = "" ;
      A483CenDescripcion = "" ;
      A484LegCenPrc = DecimalUtil.ZERO ;
      P00H62_A77CenCodigo = new short[1] ;
      P00H62_A6LegNumero = new int[1] ;
      P00H62_A1EmpCod = new short[1] ;
      P00H62_A3CliCod = new int[1] ;
      P00H62_A484LegCenPrc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00H62_A483CenDescripcion = new String[] {""} ;
      AV22Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajocentroswcgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P00H62_A77CenCodigo, P00H62_A6LegNumero, P00H62_A1EmpCod, P00H62_A3CliCod, P00H62_A484LegCenPrc, P00H62_A483CenDescripcion
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11TFCenCodigo ;
   private short AV12TFCenCodigo_To ;
   private short AV37EmpCod ;
   private short A77CenCodigo ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV41GXV1 ;
   private int AV36CliCod ;
   private int AV38LegNumero ;
   private int AV15TFCenDescripcion_Sels_size ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int AV21InsertIndex ;
   private long AV30count ;
   private java.math.BigDecimal AV16TFLegCenPrc ;
   private java.math.BigDecimal AV17TFLegCenPrc_To ;
   private java.math.BigDecimal A484LegCenPrc ;
   private String scmdbuf ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brkH62 ;
   private String AV24OptionsJson ;
   private String AV27OptionsDescJson ;
   private String AV29OptionIndexesJson ;
   private String AV13TFCenDescripcion_SelsJson ;
   private String AV20DDOName ;
   private String AV18SearchTxt ;
   private String AV19SearchTxtTo ;
   private String AV14TFCenDescripcion ;
   private String lV14TFCenDescripcion ;
   private String A483CenDescripcion ;
   private String AV22Option ;
   private com.genexus.webpanels.WebSession AV31Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private short[] P00H62_A77CenCodigo ;
   private int[] P00H62_A6LegNumero ;
   private short[] P00H62_A1EmpCod ;
   private int[] P00H62_A3CliCod ;
   private java.math.BigDecimal[] P00H62_A484LegCenPrc ;
   private String[] P00H62_A483CenDescripcion ;
   private GXSimpleCollection<String> AV23Options ;
   private GXSimpleCollection<String> AV26OptionsDesc ;
   private GXSimpleCollection<String> AV28OptionIndexes ;
   private GXSimpleCollection<String> AV15TFCenDescripcion_Sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV33GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV34GridStateFilterValue ;
}

final  class legajocentroswcgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00H62( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A483CenDescripcion ,
                                          GXSimpleCollection<String> AV15TFCenDescripcion_Sels ,
                                          short AV11TFCenCodigo ,
                                          short AV12TFCenCodigo_To ,
                                          int AV15TFCenDescripcion_Sels_size ,
                                          String AV14TFCenDescripcion ,
                                          java.math.BigDecimal AV16TFLegCenPrc ,
                                          java.math.BigDecimal AV17TFLegCenPrc_To ,
                                          short A77CenCodigo ,
                                          java.math.BigDecimal A484LegCenPrc ,
                                          int AV36CliCod ,
                                          short AV37EmpCod ,
                                          int AV38LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[8];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T1.CenCodigo, T1.LegNumero, T1.EmpCod, T1.CliCod, T1.LegCenPrc, T2.CenDescripcion FROM (LegajoCC T1 INNER JOIN CentroDeCosto T2 ON T2.CliCod = T1.CliCod AND" ;
      scmdbuf += " T2.EmpCod = T1.EmpCod AND T2.CenCodigo = T1.CenCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ?)");
      if ( ! (0==AV11TFCenCodigo) )
      {
         addWhere(sWhereString, "(T1.CenCodigo >= ?)");
      }
      else
      {
         GXv_int4[3] = (byte)(1) ;
      }
      if ( ! (0==AV12TFCenCodigo_To) )
      {
         addWhere(sWhereString, "(T1.CenCodigo <= ?)");
      }
      else
      {
         GXv_int4[4] = (byte)(1) ;
      }
      if ( ( AV15TFCenDescripcion_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV14TFCenDescripcion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.CenDescripcion) like LOWER(?))");
      }
      else
      {
         GXv_int4[5] = (byte)(1) ;
      }
      if ( AV15TFCenDescripcion_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV15TFCenDescripcion_Sels, "T2.CenDescripcion IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV16TFLegCenPrc)==0) )
      {
         addWhere(sWhereString, "(T1.LegCenPrc >= ?)");
      }
      else
      {
         GXv_int4[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV17TFLegCenPrc_To)==0) )
      {
         addWhere(sWhereString, "(T1.LegCenPrc <= ?)");
      }
      else
      {
         GXv_int4[7] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.CenCodigo" ;
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
                  return conditional_P00H62(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , (java.math.BigDecimal)dynConstraints[6] , (java.math.BigDecimal)dynConstraints[7] , ((Number) dynConstraints[8]).shortValue() , (java.math.BigDecimal)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00H62", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
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
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[14], 2);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[15], 2);
               }
               return;
      }
   }

}

