package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class inipermanencias extends GXProcedure
{
   public inipermanencias( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( inipermanencias.class ), "" );
   }

   public inipermanencias( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             short aP1 )
   {
      inipermanencias.this.AV8clicod = aP0;
      inipermanencias.this.AV9empcod = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.delete_legajo_permanencia(remoteHandle, context).execute( AV8clicod, AV9empcod, 0, AV11vaciaFecha) ;
      /* Using cursor P02CE2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8clicod), Short.valueOf(AV9empcod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P02CE2_A1EmpCod[0] ;
         A3CliCod = P02CE2_A3CliCod[0] ;
         A6LegNumero = P02CE2_A6LegNumero[0] ;
         A245LegFecIngreso = P02CE2_A245LegFecIngreso[0] ;
         A244LegFecEgreso = P02CE2_A244LegFecEgreso[0] ;
         n244LegFecEgreso = P02CE2_n244LegFecEgreso[0] ;
         A1583LegMegCodigo = P02CE2_A1583LegMegCodigo[0] ;
         n1583LegMegCodigo = P02CE2_n1583LegMegCodigo[0] ;
         AV13LegNumero.add((int)(A6LegNumero), 0);
         AV14LegFecIngreso.add(A245LegFecIngreso, 0);
         AV15LegFecEgreso.add(A244LegFecEgreso, 0);
         AV16LegMegCodigo.add(A1583LegMegCodigo, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV12i = (short)(1) ;
      while ( AV12i <= AV13LegNumero.size() )
      {
         new web.new_legajo_permanencia(remoteHandle, context).execute( AV8clicod, AV9empcod, ((Number) AV13LegNumero.elementAt(-1+AV12i)).intValue(), (java.util.Date)AV14LegFecIngreso.elementAt(-1+AV12i), (java.util.Date)AV15LegFecEgreso.elementAt(-1+AV12i), AV10vaciaDate, (String)AV16LegMegCodigo.elementAt(-1+AV12i), true, "", true) ;
         AV12i = (short)(AV12i+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11vaciaFecha = GXutil.nullDate() ;
      scmdbuf = "" ;
      P02CE2_A1EmpCod = new short[1] ;
      P02CE2_A3CliCod = new int[1] ;
      P02CE2_A6LegNumero = new int[1] ;
      P02CE2_A245LegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      P02CE2_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      P02CE2_n244LegFecEgreso = new boolean[] {false} ;
      P02CE2_A1583LegMegCodigo = new String[] {""} ;
      P02CE2_n1583LegMegCodigo = new boolean[] {false} ;
      A245LegFecIngreso = GXutil.nullDate() ;
      A244LegFecEgreso = GXutil.nullDate() ;
      A1583LegMegCodigo = "" ;
      AV13LegNumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV14LegFecIngreso = new GXSimpleCollection<java.util.Date>(java.util.Date.class, "internal", "");
      AV15LegFecEgreso = new GXSimpleCollection<java.util.Date>(java.util.Date.class, "internal", "");
      AV16LegMegCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV10vaciaDate = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.inipermanencias__default(),
         new Object[] {
             new Object[] {
            P02CE2_A1EmpCod, P02CE2_A3CliCod, P02CE2_A6LegNumero, P02CE2_A245LegFecIngreso, P02CE2_A244LegFecEgreso, P02CE2_n244LegFecEgreso, P02CE2_A1583LegMegCodigo, P02CE2_n1583LegMegCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9empcod ;
   private short A1EmpCod ;
   private short AV12i ;
   private short Gx_err ;
   private int AV8clicod ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private String scmdbuf ;
   private String A1583LegMegCodigo ;
   private java.util.Date AV11vaciaFecha ;
   private java.util.Date A245LegFecIngreso ;
   private java.util.Date A244LegFecEgreso ;
   private java.util.Date AV10vaciaDate ;
   private boolean n244LegFecEgreso ;
   private boolean n1583LegMegCodigo ;
   private GXSimpleCollection<Integer> AV13LegNumero ;
   private IDataStoreProvider pr_default ;
   private short[] P02CE2_A1EmpCod ;
   private int[] P02CE2_A3CliCod ;
   private int[] P02CE2_A6LegNumero ;
   private java.util.Date[] P02CE2_A245LegFecIngreso ;
   private java.util.Date[] P02CE2_A244LegFecEgreso ;
   private boolean[] P02CE2_n244LegFecEgreso ;
   private String[] P02CE2_A1583LegMegCodigo ;
   private boolean[] P02CE2_n1583LegMegCodigo ;
   private GXSimpleCollection<String> AV16LegMegCodigo ;
   private GXSimpleCollection<java.util.Date> AV14LegFecIngreso ;
   private GXSimpleCollection<java.util.Date> AV15LegFecEgreso ;
}

final  class inipermanencias__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02CE2", "SELECT EmpCod, CliCod, LegNumero, LegFecIngreso, LegFecEgreso, LegMegCodigo FROM Legajo WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
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
               return;
      }
   }

}

