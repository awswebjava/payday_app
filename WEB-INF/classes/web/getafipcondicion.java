package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getafipcondicion extends GXProcedure
{
   public getafipcondicion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getafipcondicion.class ), "" );
   }

   public getafipcondicion( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            int aP2 )
   {
      getafipcondicion.this.aP3 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short[] aP3 )
   {
      getafipcondicion.this.AV8CliCod = aP0;
      getafipcondicion.this.AV11EmpCod = aP1;
      getafipcondicion.this.AV12LegNumero = aP2;
      getafipcondicion.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01CW2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV12LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P01CW2_A6LegNumero[0] ;
         A1EmpCod = P01CW2_A1EmpCod[0] ;
         A3CliCod = P01CW2_A3CliCod[0] ;
         A1016LegJubilado = P01CW2_A1016LegJubilado[0] ;
         A245LegFecIngreso = P01CW2_A245LegFecIngreso[0] ;
         A246LegFecNac = P01CW2_A246LegFecNac[0] ;
         if ( A1016LegJubilado )
         {
            AV9CondiCodigo = (short)(2) ;
         }
         else
         {
            GXt_dtime1 = GXutil.resetTime( A246LegFecNac );
            GXt_dtime2 = GXutil.resetTime( A245LegFecIngreso );
            AV10edad = (short)(GXutil.age( GXt_dtime1, GXt_dtime2)) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "&edad ", "")+GXutil.trim( GXutil.str( AV10edad, 4, 0))+GXutil.trim( localUtil.dtoc( A245LegFecIngreso, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " LegFecNac ", "")+GXutil.trim( localUtil.dtoc( A246LegFecNac, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
            if ( AV10edad >= 18 )
            {
               AV9CondiCodigo = (short)(1) ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, "1") ;
            }
            else
            {
               if ( GXutil.dateCompare(GXutil.resetTime(A246LegFecNac), GXutil.resetTime(new web.fecnacpredetimpor(remoteHandle, context).executeUdp( ))) || GXutil.dateCompare(GXutil.resetTime(A245LegFecIngreso), GXutil.resetTime(new web.fecingpredetimpor(remoteHandle, context).executeUdp( ))) )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  AV9CondiCodigo = (short)(1) ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "1b", "")) ;
               }
               else
               {
                  AV9CondiCodigo = (short)(3) ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, "3") ;
               }
            }
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getafipcondicion.this.AV9CondiCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P01CW2_A6LegNumero = new int[1] ;
      P01CW2_A1EmpCod = new short[1] ;
      P01CW2_A3CliCod = new int[1] ;
      P01CW2_A1016LegJubilado = new boolean[] {false} ;
      P01CW2_A245LegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      P01CW2_A246LegFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      A245LegFecIngreso = GXutil.nullDate() ;
      A246LegFecNac = GXutil.nullDate() ;
      GXt_dtime1 = GXutil.resetTime( GXutil.nullDate() );
      GXt_dtime2 = GXutil.resetTime( GXutil.nullDate() );
      AV16Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getafipcondicion__default(),
         new Object[] {
             new Object[] {
            P01CW2_A6LegNumero, P01CW2_A1EmpCod, P01CW2_A3CliCod, P01CW2_A1016LegJubilado, P01CW2_A245LegFecIngreso, P01CW2_A246LegFecNac
            }
         }
      );
      AV16Pgmname = "getAfipCondicion" ;
      /* GeneXus formulas. */
      AV16Pgmname = "getAfipCondicion" ;
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short AV9CondiCodigo ;
   private short A1EmpCod ;
   private short AV10edad ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV12LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String AV16Pgmname ;
   private java.util.Date GXt_dtime1 ;
   private java.util.Date GXt_dtime2 ;
   private java.util.Date A245LegFecIngreso ;
   private java.util.Date A246LegFecNac ;
   private boolean A1016LegJubilado ;
   private boolean Cond_result ;
   private short[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P01CW2_A6LegNumero ;
   private short[] P01CW2_A1EmpCod ;
   private int[] P01CW2_A3CliCod ;
   private boolean[] P01CW2_A1016LegJubilado ;
   private java.util.Date[] P01CW2_A245LegFecIngreso ;
   private java.util.Date[] P01CW2_A246LegFecNac ;
}

final  class getafipcondicion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01CW2", "SELECT LegNumero, EmpCod, CliCod, LegJubilado, LegFecIngreso, LegFecNac FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

