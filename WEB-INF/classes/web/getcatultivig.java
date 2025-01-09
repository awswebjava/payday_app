package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getcatultivig extends GXProcedure
{
   public getcatultivig( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getcatultivig.class ), "" );
   }

   public getcatultivig( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           String aP2 ,
                           String aP3 ,
                           java.util.Date aP4 ,
                           java.util.Date aP5 ,
                           java.util.Date[] aP6 )
   {
      getcatultivig.this.aP7 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String aP3 ,
                        java.util.Date aP4 ,
                        java.util.Date aP5 ,
                        java.util.Date[] aP6 ,
                        byte[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String aP3 ,
                             java.util.Date aP4 ,
                             java.util.Date aP5 ,
                             java.util.Date[] aP6 ,
                             byte[] aP7 )
   {
      getcatultivig.this.AV8CliCod = aP0;
      getcatultivig.this.AV9CliPaiConve = aP1;
      getcatultivig.this.AV10CliConvenio = aP2;
      getcatultivig.this.AV11CatCodigo = aP3;
      getcatultivig.this.AV12parmCatVigencia = aP4;
      getcatultivig.this.AV13parmCatVigencia_comienzo = aP5;
      getcatultivig.this.aP6 = aP6;
      getcatultivig.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV18Pgmname, httpContext.getMessage( "cli ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))+httpContext.getMessage( " clipai ", "")+GXutil.trim( GXutil.str( AV9CliPaiConve, 4, 0))+httpContext.getMessage( " cliconve ", "")+AV10CliConvenio+httpContext.getMessage( " &parmCatVigencia ", "")+GXutil.trim( localUtil.dtoc( AV12parmCatVigencia, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &parmCatVigencia_comienzo ", "")+GXutil.trim( localUtil.dtoc( AV13parmCatVigencia_comienzo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &CatCodigo ", "")+GXutil.trim( AV11CatCodigo)) ;
      AV19GXLvl3 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV12parmCatVigencia ,
                                           A907CatVigencia ,
                                           AV13parmCatVigencia_comienzo ,
                                           Integer.valueOf(AV8CliCod) ,
                                           Short.valueOf(AV9CliPaiConve) ,
                                           AV10CliConvenio ,
                                           AV11CatCodigo ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           A1565CliConvenio ,
                                           A8CatCodigo } ,
                                           new int[]{
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.STRING
                                           }
      });
      /* Using cursor P01X72 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9CliPaiConve), AV10CliConvenio, AV11CatCodigo, AV12parmCatVigencia, AV13parmCatVigencia_comienzo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P01X72_A3CliCod[0] ;
         A1564CliPaiConve = P01X72_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01X72_A1565CliConvenio[0] ;
         A8CatCodigo = P01X72_A8CatCodigo[0] ;
         A907CatVigencia = P01X72_A907CatVigencia[0] ;
         A1914CatFrecAct = P01X72_A1914CatFrecAct[0] ;
         A1914CatFrecAct = P01X72_A1914CatFrecAct[0] ;
         AV19GXLvl3 = (byte)(1) ;
         AV14CatVigencia = A907CatVigencia ;
         AV15CatFrecAct = A1914CatFrecAct ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV18Pgmname, httpContext.getMessage( "emcinmetra ¿", "")+GXutil.trim( localUtil.dtoc( AV14CatVigencia, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV19GXLvl3 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV18Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = getcatultivig.this.AV14CatVigencia;
      this.aP7[0] = getcatultivig.this.AV15CatFrecAct;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14CatVigencia = GXutil.nullDate() ;
      AV18Pgmname = "" ;
      scmdbuf = "" ;
      A907CatVigencia = GXutil.nullDate() ;
      A1565CliConvenio = "" ;
      A8CatCodigo = "" ;
      P01X72_A3CliCod = new int[1] ;
      P01X72_A1564CliPaiConve = new short[1] ;
      P01X72_A1565CliConvenio = new String[] {""} ;
      P01X72_A8CatCodigo = new String[] {""} ;
      P01X72_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      P01X72_A1914CatFrecAct = new byte[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getcatultivig__default(),
         new Object[] {
             new Object[] {
            P01X72_A3CliCod, P01X72_A1564CliPaiConve, P01X72_A1565CliConvenio, P01X72_A8CatCodigo, P01X72_A907CatVigencia, P01X72_A1914CatFrecAct
            }
         }
      );
      AV18Pgmname = "getCatUltiVig" ;
      /* GeneXus formulas. */
      AV18Pgmname = "getCatUltiVig" ;
      Gx_err = (short)(0) ;
   }

   private byte AV15CatFrecAct ;
   private byte AV19GXLvl3 ;
   private byte A1914CatFrecAct ;
   private short AV9CliPaiConve ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV10CliConvenio ;
   private String AV11CatCodigo ;
   private String AV18Pgmname ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A8CatCodigo ;
   private java.util.Date AV12parmCatVigencia ;
   private java.util.Date AV13parmCatVigencia_comienzo ;
   private java.util.Date AV14CatVigencia ;
   private java.util.Date A907CatVigencia ;
   private byte[] aP7 ;
   private java.util.Date[] aP6 ;
   private IDataStoreProvider pr_default ;
   private int[] P01X72_A3CliCod ;
   private short[] P01X72_A1564CliPaiConve ;
   private String[] P01X72_A1565CliConvenio ;
   private String[] P01X72_A8CatCodigo ;
   private java.util.Date[] P01X72_A907CatVigencia ;
   private byte[] P01X72_A1914CatFrecAct ;
}

final  class getcatultivig__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01X72( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          java.util.Date AV12parmCatVigencia ,
                                          java.util.Date A907CatVigencia ,
                                          java.util.Date AV13parmCatVigencia_comienzo ,
                                          int AV8CliCod ,
                                          short AV9CliPaiConve ,
                                          String AV10CliConvenio ,
                                          String AV11CatCodigo ,
                                          int A3CliCod ,
                                          short A1564CliPaiConve ,
                                          String A1565CliConvenio ,
                                          String A8CatCodigo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[6];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT T1.CliCod, T1.CliPaiConve, T1.CliConvenio, T1.CatCodigo, T1.CatVigencia, T2.CatFrecAct FROM (Categoriavalores1 T1 INNER JOIN Categoria1 T2 ON T2.CliCod =" ;
      scmdbuf += " T1.CliCod AND T2.CliPaiConve = T1.CliPaiConve AND T2.CliConvenio = T1.CliConvenio AND T2.CatCodigo = T1.CatCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.CliPaiConve = ? and T1.CliConvenio = ( ?) and T1.CatCodigo = ( ?))");
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV12parmCatVigencia)) )
      {
         addWhere(sWhereString, "(T1.CatVigencia <= ?)");
      }
      else
      {
         GXv_int1[4] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV12parmCatVigencia)) )
      {
         addWhere(sWhereString, "(T1.CatVigencia >= ?)");
      }
      else
      {
         GXv_int1[5] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.CliPaiConve, T1.CliConvenio, T1.CatCodigo, T1.CatVigencia DESC" ;
      GXv_Object2[0] = scmdbuf ;
      GXv_Object2[1] = GXv_int1 ;
      return GXv_Object2 ;
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
                  return conditional_P01X72(context, remoteHandle, httpContext, (java.util.Date)dynConstraints[0] , (java.util.Date)dynConstraints[1] , (java.util.Date)dynConstraints[2] , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).shortValue() , (String)dynConstraints[9] , (String)dynConstraints[10] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01X72", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
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
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[8], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 40);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[10]);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[11]);
               }
               return;
      }
   }

}

