package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class diaesferiado extends GXProcedure
{
   public diaesferiado( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( diaesferiado.class ), "" );
   }

   public diaesferiado( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( short aP0 ,
                              java.util.Date aP1 )
   {
      diaesferiado.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( short aP0 ,
                        java.util.Date aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( short aP0 ,
                             java.util.Date aP1 ,
                             boolean[] aP2 )
   {
      diaesferiado.this.AV12PaiCod = aP0;
      diaesferiado.this.AV11FerFecha = aP1;
      diaesferiado.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01CV2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV12PaiCod), AV11FerFecha});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1223FerId = P01CV2_A1223FerId[0] ;
         A1233FeriadoTipo = P01CV2_A1233FeriadoTipo[0] ;
         A1227FerFecha = P01CV2_A1227FerFecha[0] ;
         A46PaiCod = P01CV2_A46PaiCod[0] ;
         A1226FerAnio = P01CV2_A1226FerAnio[0] ;
         A1233FeriadoTipo = P01CV2_A1233FeriadoTipo[0] ;
         AV10es = true ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = diaesferiado.this.AV10es;
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
      P01CV2_A1223FerId = new String[] {""} ;
      P01CV2_A1233FeriadoTipo = new String[] {""} ;
      P01CV2_A1227FerFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P01CV2_A46PaiCod = new short[1] ;
      P01CV2_A1226FerAnio = new short[1] ;
      A1223FerId = "" ;
      A1233FeriadoTipo = "" ;
      A1227FerFecha = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.diaesferiado__default(),
         new Object[] {
             new Object[] {
            P01CV2_A1223FerId, P01CV2_A1233FeriadoTipo, P01CV2_A1227FerFecha, P01CV2_A46PaiCod, P01CV2_A1226FerAnio
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12PaiCod ;
   private short A46PaiCod ;
   private short A1226FerAnio ;
   private short Gx_err ;
   private String scmdbuf ;
   private String A1223FerId ;
   private String A1233FeriadoTipo ;
   private java.util.Date AV11FerFecha ;
   private java.util.Date A1227FerFecha ;
   private boolean AV10es ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01CV2_A1223FerId ;
   private String[] P01CV2_A1233FeriadoTipo ;
   private java.util.Date[] P01CV2_A1227FerFecha ;
   private short[] P01CV2_A46PaiCod ;
   private short[] P01CV2_A1226FerAnio ;
}

final  class diaesferiado__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01CV2", "SELECT T1.FerId, T2.FeriadoTipo, T1.FerFecha, T1.PaiCod, T1.FerAnio FROM (feriado_agenda T1 INNER JOIN feriado T2 ON T2.PaiCod = T1.PaiCod AND T2.FerId = T1.FerId) WHERE (T1.PaiCod = ?) AND (T2.FeriadoTipo <> ( 'nolaborable')) AND (T1.FerFecha = ?) ORDER BY T1.PaiCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setDate(2, (java.util.Date)parms[1]);
               return;
      }
   }

}

