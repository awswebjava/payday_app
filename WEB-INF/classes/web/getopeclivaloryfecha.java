package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getopeclivaloryfecha extends GXProcedure
{
   public getopeclivaloryfecha( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getopeclivaloryfecha.class ), "" );
   }

   public getopeclivaloryfecha( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             java.util.Date aP2 )
   {
      getopeclivaloryfecha.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        java.util.Date aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             java.util.Date aP2 ,
                             String[] aP3 )
   {
      getopeclivaloryfecha.this.AV10CliCod = aP0;
      getopeclivaloryfecha.this.AV8OpeCliId = aP1;
      getopeclivaloryfecha.this.AV15parm_OpeCliVig = aP2;
      getopeclivaloryfecha.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_int1[0] = AV17VarFrecAct ;
      new web.getvarfrectact(remoteHandle, context).execute( AV10CliCod, AV8OpeCliId, GXv_int1) ;
      getopeclivaloryfecha.this.AV17VarFrecAct = GXv_int1[0] ;
      GXv_boolean2[0] = AV18VarActObl ;
      new web.getvaractobl(remoteHandle, context).execute( AV10CliCod, AV8OpeCliId, GXv_boolean2) ;
      getopeclivaloryfecha.this.AV18VarActObl = GXv_boolean2[0] ;
      GXv_boolean2[0] = AV19OpeCliAliEs ;
      new web.getopeclialies(remoteHandle, context).execute( AV10CliCod, AV8OpeCliId, GXv_boolean2) ;
      getopeclivaloryfecha.this.AV19OpeCliAliEs = GXv_boolean2[0] ;
      if ( ( AV17VarFrecAct == 0 ) && ! AV19OpeCliAliEs )
      {
         AV14ultimoTexto = httpContext.getMessage( "(variable en desuso)", "") ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      if ( GXutil.dateCompare(GXutil.resetTime(AV15parm_OpeCliVig), GXutil.resetTime(localUtil.ymdtod( 1900, 1, 1))) )
      {
         AV11OpeCliVig = GXutil.nullDate() ;
      }
      else
      {
         AV11OpeCliVig = AV15parm_OpeCliVig ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "busqueda normal &OpeCliVig ", "")+GXutil.trim( localUtil.dtoc( AV11OpeCliVig, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &parm_OpeCliVig ", "")+GXutil.trim( localUtil.dtoc( AV15parm_OpeCliVig, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      AV23GXLvl16 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV11OpeCliVig ,
                                           A754OpeCliVig ,
                                           Integer.valueOf(AV10CliCod) ,
                                           AV8OpeCliId ,
                                           Integer.valueOf(A3CliCod) ,
                                           A82OpeCliId } ,
                                           new int[]{
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING
                                           }
      });
      /* Using cursor P01PU2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), AV8OpeCliId, AV11OpeCliVig});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A754OpeCliVig = P01PU2_A754OpeCliVig[0] ;
         A82OpeCliId = P01PU2_A82OpeCliId[0] ;
         A3CliCod = P01PU2_A3CliCod[0] ;
         A535OpeCliValor = P01PU2_A535OpeCliValor[0] ;
         AV23GXLvl16 = (byte)(1) ;
         AV9OpeCliValor = A535OpeCliValor ;
         AV13ult_OpeCliVig = A754OpeCliVig ;
         if ( GXutil.len( A535OpeCliValor) <= 20 )
         {
            AV14ultimoTexto = httpContext.getMessage( "<b>", "") + GXutil.trim( A535OpeCliValor) + httpContext.getMessage( "</b> del ", "") + GXutil.trim( localUtil.dtoc( A754OpeCliVig, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) ;
         }
         else
         {
            AV14ultimoTexto = httpContext.getMessage( "<b>", "") + GXutil.trim( localUtil.dtoc( A754OpeCliVig, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) + httpContext.getMessage( "</b>", "") ;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "&OpeCliValor ", "")+GXutil.trim( AV9OpeCliValor)+httpContext.getMessage( " OpeCliVig ", "")+GXutil.trim( localUtil.dtoc( A754OpeCliVig, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV23GXLvl16 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "none &CliCod ", "")+GXutil.trim( GXutil.str( AV10CliCod, 6, 0))+httpContext.getMessage( " &OpeCliId ", "")+AV8OpeCliId+httpContext.getMessage( " &OpeCliVig ", "")+localUtil.dtoc( AV11OpeCliVig, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) ;
      }
      GXv_boolean2[0] = AV16actualizadaEsta ;
      new web.variableactualizada(remoteHandle, context).execute( AV10CliCod, AV8OpeCliId, AV13ult_OpeCliVig, GXutil.serverDate( context, remoteHandle, pr_default), GXv_boolean2) ;
      getopeclivaloryfecha.this.AV16actualizadaEsta = GXv_boolean2[0] ;
      if ( AV16actualizadaEsta )
      {
         AV14ultimoTexto = httpContext.getMessage( "<span style=\"color: green;background-color: yellow;\">", "") + AV14ultimoTexto + httpContext.getMessage( "</span>", "") ;
      }
      else
      {
         if ( AV18VarActObl )
         {
            AV14ultimoTexto = httpContext.getMessage( "<span style=\"color: red;\">", "") + AV14ultimoTexto + httpContext.getMessage( "</span>", "") ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getopeclivaloryfecha.this.AV14ultimoTexto;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14ultimoTexto = "" ;
      GXv_int1 = new byte[1] ;
      AV11OpeCliVig = GXutil.nullDate() ;
      AV22Pgmname = "" ;
      scmdbuf = "" ;
      A754OpeCliVig = GXutil.nullDate() ;
      A82OpeCliId = "" ;
      P01PU2_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      P01PU2_A82OpeCliId = new String[] {""} ;
      P01PU2_A3CliCod = new int[1] ;
      P01PU2_A535OpeCliValor = new String[] {""} ;
      A535OpeCliValor = "" ;
      AV9OpeCliValor = "" ;
      AV13ult_OpeCliVig = GXutil.nullDate() ;
      GXv_boolean2 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getopeclivaloryfecha__default(),
         new Object[] {
             new Object[] {
            P01PU2_A754OpeCliVig, P01PU2_A82OpeCliId, P01PU2_A3CliCod, P01PU2_A535OpeCliValor
            }
         }
      );
      AV22Pgmname = "getOpeCliValorYFecha" ;
      /* GeneXus formulas. */
      AV22Pgmname = "getOpeCliValorYFecha" ;
      Gx_err = (short)(0) ;
   }

   private byte AV17VarFrecAct ;
   private byte GXv_int1[] ;
   private byte AV23GXLvl16 ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private String AV8OpeCliId ;
   private String AV22Pgmname ;
   private String scmdbuf ;
   private String A82OpeCliId ;
   private java.util.Date AV15parm_OpeCliVig ;
   private java.util.Date AV11OpeCliVig ;
   private java.util.Date A754OpeCliVig ;
   private java.util.Date AV13ult_OpeCliVig ;
   private boolean AV18VarActObl ;
   private boolean AV19OpeCliAliEs ;
   private boolean returnInSub ;
   private boolean AV16actualizadaEsta ;
   private boolean GXv_boolean2[] ;
   private String A535OpeCliValor ;
   private String AV9OpeCliValor ;
   private String AV14ultimoTexto ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P01PU2_A754OpeCliVig ;
   private String[] P01PU2_A82OpeCliId ;
   private int[] P01PU2_A3CliCod ;
   private String[] P01PU2_A535OpeCliValor ;
}

final  class getopeclivaloryfecha__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01PU2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          java.util.Date AV11OpeCliVig ,
                                          java.util.Date A754OpeCliVig ,
                                          int AV10CliCod ,
                                          String AV8OpeCliId ,
                                          int A3CliCod ,
                                          String A82OpeCliId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int3 = new byte[3];
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT OpeCliVig, OpeCliId, CliCod, OpeCliValor FROM variable_valores" ;
      addWhere(sWhereString, "(CliCod = ? and OpeCliId = ( ?))");
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV11OpeCliVig)) )
      {
         addWhere(sWhereString, "(OpeCliVig <= ?)");
      }
      else
      {
         GXv_int3[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, OpeCliId, OpeCliVig DESC" ;
      GXv_Object4[0] = scmdbuf ;
      GXv_Object4[1] = GXv_int3 ;
      return GXv_Object4 ;
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
                  return conditional_P01PU2(context, remoteHandle, httpContext, (java.util.Date)dynConstraints[0] , (java.util.Date)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , (String)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01PU2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

