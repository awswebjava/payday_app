package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getopecliultivaloryfecha extends GXProcedure
{
   public getopecliultivaloryfecha( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getopecliultivaloryfecha.class ), "" );
   }

   public getopecliultivaloryfecha( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 ,
                                     String aP1 ,
                                     java.util.Date aP2 ,
                                     String[] aP3 )
   {
      getopecliultivaloryfecha.this.aP4 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        java.util.Date aP2 ,
                        String[] aP3 ,
                        java.util.Date[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             java.util.Date aP2 ,
                             String[] aP3 ,
                             java.util.Date[] aP4 )
   {
      getopecliultivaloryfecha.this.AV10CliCod = aP0;
      getopecliultivaloryfecha.this.AV8OpeCliId = aP1;
      getopecliultivaloryfecha.this.AV15parm_OpeCliVig = aP2;
      getopecliultivaloryfecha.this.aP3 = aP3;
      getopecliultivaloryfecha.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV18GXLvl3 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV15parm_OpeCliVig ,
                                           A754OpeCliVig ,
                                           Integer.valueOf(AV10CliCod) ,
                                           AV8OpeCliId ,
                                           Integer.valueOf(A3CliCod) ,
                                           A82OpeCliId } ,
                                           new int[]{
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING
                                           }
      });
      /* Using cursor P01TK2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), AV8OpeCliId, AV15parm_OpeCliVig});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A754OpeCliVig = P01TK2_A754OpeCliVig[0] ;
         A82OpeCliId = P01TK2_A82OpeCliId[0] ;
         A3CliCod = P01TK2_A3CliCod[0] ;
         A535OpeCliValor = P01TK2_A535OpeCliValor[0] ;
         AV18GXLvl3 = (byte)(1) ;
         AV9OpeCliValor = A535OpeCliValor ;
         AV11OpeCliVig = A754OpeCliVig ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV18GXLvl3 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "none &CliCod ", "")+GXutil.trim( GXutil.str( AV10CliCod, 6, 0))+httpContext.getMessage( " &OpeCliId ", "")+AV8OpeCliId+httpContext.getMessage( " &&parm_OpeCliVig ", "")+localUtil.dtoc( AV15parm_OpeCliVig, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")+httpContext.getMessage( " vig ", "")+localUtil.dtoc( AV11OpeCliVig, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getopecliultivaloryfecha.this.AV9OpeCliValor;
      this.aP4[0] = getopecliultivaloryfecha.this.AV11OpeCliVig;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9OpeCliValor = "" ;
      AV11OpeCliVig = GXutil.nullDate() ;
      scmdbuf = "" ;
      A754OpeCliVig = GXutil.nullDate() ;
      A82OpeCliId = "" ;
      P01TK2_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      P01TK2_A82OpeCliId = new String[] {""} ;
      P01TK2_A3CliCod = new int[1] ;
      P01TK2_A535OpeCliValor = new String[] {""} ;
      A535OpeCliValor = "" ;
      AV19Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getopecliultivaloryfecha__default(),
         new Object[] {
             new Object[] {
            P01TK2_A754OpeCliVig, P01TK2_A82OpeCliId, P01TK2_A3CliCod, P01TK2_A535OpeCliValor
            }
         }
      );
      AV19Pgmname = "getOpeCliUltiValorYFecha" ;
      /* GeneXus formulas. */
      AV19Pgmname = "getOpeCliUltiValorYFecha" ;
      Gx_err = (short)(0) ;
   }

   private byte AV18GXLvl3 ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private String AV8OpeCliId ;
   private String scmdbuf ;
   private String A82OpeCliId ;
   private String AV19Pgmname ;
   private java.util.Date AV15parm_OpeCliVig ;
   private java.util.Date AV11OpeCliVig ;
   private java.util.Date A754OpeCliVig ;
   private String AV9OpeCliValor ;
   private String A535OpeCliValor ;
   private java.util.Date[] aP4 ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P01TK2_A754OpeCliVig ;
   private String[] P01TK2_A82OpeCliId ;
   private int[] P01TK2_A3CliCod ;
   private String[] P01TK2_A535OpeCliValor ;
}

final  class getopecliultivaloryfecha__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01TK2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          java.util.Date AV15parm_OpeCliVig ,
                                          java.util.Date A754OpeCliVig ,
                                          int AV10CliCod ,
                                          String AV8OpeCliId ,
                                          int A3CliCod ,
                                          String A82OpeCliId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[3];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT OpeCliVig, OpeCliId, CliCod, OpeCliValor FROM variable_valores" ;
      addWhere(sWhereString, "(CliCod = ? and OpeCliId = ( ?))");
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV15parm_OpeCliVig)) )
      {
         addWhere(sWhereString, "(OpeCliVig <= ?)");
      }
      else
      {
         GXv_int1[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, OpeCliId, OpeCliVig DESC" ;
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
                  return conditional_P01TK2(context, remoteHandle, httpContext, (java.util.Date)dynConstraints[0] , (java.util.Date)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , (String)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01TK2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
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
                  stmt.setDate(sIdx, (java.util.Date)parms[5]);
               }
               return;
      }
   }

}

