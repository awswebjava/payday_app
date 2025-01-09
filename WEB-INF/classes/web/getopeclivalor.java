package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getopeclivalor extends GXProcedure
{
   public getopeclivalor( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getopeclivalor.class ), "" );
   }

   public getopeclivalor( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             java.util.Date aP2 ,
                             String aP3 ,
                             String[] aP4 )
   {
      getopeclivalor.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        java.util.Date aP2 ,
                        String aP3 ,
                        String[] aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             java.util.Date aP2 ,
                             String aP3 ,
                             String[] aP4 ,
                             String[] aP5 )
   {
      getopeclivalor.this.AV10CliCod = aP0;
      getopeclivalor.this.AV8OpeCliId = aP1;
      getopeclivalor.this.AV11OpeCliVig = aP2;
      getopeclivalor.this.AV12ProcesoLiquidacion = aP3;
      getopeclivalor.this.aP4 = aP4;
      getopeclivalor.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV21Pgmname, httpContext.getMessage( " &ProcesoLiquidacion ", "")+GXutil.trim( AV12ProcesoLiquidacion)+httpContext.getMessage( "&OpeCliId ", "")+GXutil.trim( AV8OpeCliId)) ;
      if ( GXutil.strcmp(AV12ProcesoLiquidacion, "Recalculo") == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV21Pgmname, httpContext.getMessage( "&OpeCliId ", "")+GXutil.trim( AV8OpeCliId)+httpContext.getMessage( " &OpeCliVig ", "")+GXutil.trim( localUtil.dtoc( AV11OpeCliVig, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
         AV22GXLvl4 = (byte)(0) ;
         /* Using cursor P00J32 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), AV8OpeCliId, AV11OpeCliVig});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A1146OpeCliVRetro = P00J32_A1146OpeCliVRetro[0] ;
            n1146OpeCliVRetro = P00J32_n1146OpeCliVRetro[0] ;
            A82OpeCliId = P00J32_A82OpeCliId[0] ;
            A3CliCod = P00J32_A3CliCod[0] ;
            A535OpeCliValor = P00J32_A535OpeCliValor[0] ;
            A754OpeCliVig = P00J32_A754OpeCliVig[0] ;
            AV22GXLvl4 = (byte)(1) ;
            AV9OpeCliValor = A535OpeCliValor ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV21Pgmname, httpContext.getMessage( "OpeCliValor ", "")+A535OpeCliValor) ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( AV22GXLvl4 == 0 )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV21Pgmname, httpContext.getMessage( "none retro", "")) ;
         }
      }
      if ( (GXutil.strcmp("", AV9OpeCliValor)==0) )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV21Pgmname, httpContext.getMessage( "busqueda normal ", "")+GXutil.trim( GXutil.str( AV10CliCod, 6, 0))) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV21Pgmname, httpContext.getMessage( "&OpeCliId ", "")+GXutil.trim( AV8OpeCliId)+httpContext.getMessage( " &OpeCliVig ", "")+GXutil.trim( localUtil.dtoc( AV11OpeCliVig, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
         AV23GXLvl21 = (byte)(0) ;
         /* Using cursor P00J33 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV10CliCod), AV8OpeCliId, AV11OpeCliVig});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A754OpeCliVig = P00J33_A754OpeCliVig[0] ;
            A82OpeCliId = P00J33_A82OpeCliId[0] ;
            A3CliCod = P00J33_A3CliCod[0] ;
            A535OpeCliValor = P00J33_A535OpeCliValor[0] ;
            AV23GXLvl21 = (byte)(1) ;
            AV9OpeCliValor = A535OpeCliValor ;
            AV14ult_OpeCliVig = A754OpeCliVig ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV21Pgmname, httpContext.getMessage( "&OpeCliValor ", "")+GXutil.trim( AV9OpeCliValor)+httpContext.getMessage( " OpeCliVig ", "")+GXutil.trim( localUtil.dtoc( A754OpeCliVig, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(1);
         }
         pr_default.close(1);
         if ( AV23GXLvl21 == 0 )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV21Pgmname, httpContext.getMessage( "none &CliCod ", "")+GXutil.trim( GXutil.str( AV10CliCod, 6, 0))+httpContext.getMessage( " &OpeCliId ", "")+AV8OpeCliId+httpContext.getMessage( " &OpeCliVig ", "")+localUtil.dtoc( AV11OpeCliVig, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) ;
         }
         GXt_boolean1 = AV13VarActObl ;
         GXv_boolean2[0] = GXt_boolean1 ;
         new web.getvaractobl(remoteHandle, context).execute( AV10CliCod, AV8OpeCliId, GXv_boolean2) ;
         getopeclivalor.this.GXt_boolean1 = GXv_boolean2[0] ;
         AV13VarActObl = GXt_boolean1 ;
         if ( AV13VarActObl )
         {
            GXv_boolean2[0] = AV15actualizadaEsta ;
            new web.variableactualizada(remoteHandle, context).execute( AV10CliCod, AV8OpeCliId, AV14ult_OpeCliVig, AV11OpeCliVig, GXv_boolean2) ;
            getopeclivalor.this.AV15actualizadaEsta = GXv_boolean2[0] ;
            if ( ! AV15actualizadaEsta )
            {
               GXv_char3[0] = AV16error ;
               new web.getcoderrprin(remoteHandle, context).execute( GXv_char3) ;
               getopeclivalor.this.AV16error = GXv_char3[0] ;
               GXv_char3[0] = AV17OpeCliDescrip ;
               new web.getopeclidescrip(remoteHandle, context).execute( AV10CliCod, AV8OpeCliId, GXv_char3) ;
               getopeclivalor.this.AV17OpeCliDescrip = GXv_char3[0] ;
               AV16error += httpContext.getMessage( "La variable ", "") + GXutil.trim( AV17OpeCliDescrip) + httpContext.getMessage( " no está actualizada al ", "") + GXutil.trim( localUtil.dtoc( AV11OpeCliVig, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getopeclivalor.this.AV9OpeCliValor;
      this.aP5[0] = getopeclivalor.this.AV16error;
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
      AV16error = "" ;
      AV21Pgmname = "" ;
      scmdbuf = "" ;
      P00J32_A1146OpeCliVRetro = new java.util.Date[] {GXutil.nullDate()} ;
      P00J32_n1146OpeCliVRetro = new boolean[] {false} ;
      P00J32_A82OpeCliId = new String[] {""} ;
      P00J32_A3CliCod = new int[1] ;
      P00J32_A535OpeCliValor = new String[] {""} ;
      P00J32_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      A1146OpeCliVRetro = GXutil.nullDate() ;
      A82OpeCliId = "" ;
      A535OpeCliValor = "" ;
      A754OpeCliVig = GXutil.nullDate() ;
      P00J33_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      P00J33_A82OpeCliId = new String[] {""} ;
      P00J33_A3CliCod = new int[1] ;
      P00J33_A535OpeCliValor = new String[] {""} ;
      AV14ult_OpeCliVig = GXutil.nullDate() ;
      GXv_boolean2 = new boolean[1] ;
      AV17OpeCliDescrip = "" ;
      GXv_char3 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getopeclivalor__default(),
         new Object[] {
             new Object[] {
            P00J32_A1146OpeCliVRetro, P00J32_n1146OpeCliVRetro, P00J32_A82OpeCliId, P00J32_A3CliCod, P00J32_A535OpeCliValor, P00J32_A754OpeCliVig
            }
            , new Object[] {
            P00J33_A754OpeCliVig, P00J33_A82OpeCliId, P00J33_A3CliCod, P00J33_A535OpeCliValor
            }
         }
      );
      AV21Pgmname = "getOpeCliValor" ;
      /* GeneXus formulas. */
      AV21Pgmname = "getOpeCliValor" ;
      Gx_err = (short)(0) ;
   }

   private byte AV22GXLvl4 ;
   private byte AV23GXLvl21 ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private String AV8OpeCliId ;
   private String AV12ProcesoLiquidacion ;
   private String AV21Pgmname ;
   private String scmdbuf ;
   private String A82OpeCliId ;
   private String GXv_char3[] ;
   private java.util.Date AV11OpeCliVig ;
   private java.util.Date A1146OpeCliVRetro ;
   private java.util.Date A754OpeCliVig ;
   private java.util.Date AV14ult_OpeCliVig ;
   private boolean n1146OpeCliVRetro ;
   private boolean AV13VarActObl ;
   private boolean GXt_boolean1 ;
   private boolean AV15actualizadaEsta ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private String AV9OpeCliValor ;
   private String A535OpeCliValor ;
   private String AV16error ;
   private String AV17OpeCliDescrip ;
   private String[] aP5 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P00J32_A1146OpeCliVRetro ;
   private boolean[] P00J32_n1146OpeCliVRetro ;
   private String[] P00J32_A82OpeCliId ;
   private int[] P00J32_A3CliCod ;
   private String[] P00J32_A535OpeCliValor ;
   private java.util.Date[] P00J32_A754OpeCliVig ;
   private java.util.Date[] P00J33_A754OpeCliVig ;
   private String[] P00J33_A82OpeCliId ;
   private int[] P00J33_A3CliCod ;
   private String[] P00J33_A535OpeCliValor ;
}

final  class getopeclivalor__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00J32", "SELECT OpeCliVRetro, OpeCliId, CliCod, OpeCliValor, OpeCliVig FROM variable_valores WHERE (CliCod = ? and OpeCliId = ( ?) and OpeCliVRetro <= ?) AND (Not (OpeCliVRetro = DATE '00010101')) ORDER BY CliCod, OpeCliId, OpeCliVRetro DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00J33", "SELECT OpeCliVig, OpeCliId, CliCod, OpeCliValor FROM variable_valores WHERE CliCod = ? and OpeCliId = ( ?) and OpeCliVig <= ? ORDER BY CliCod, OpeCliId, OpeCliVig DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 40);
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(4);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(5);
               return;
            case 1 :
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
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
      }
   }

}

