package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class recalcular_permanencias extends GXProcedure
{
   public recalcular_permanencias( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( recalcular_permanencias.class ), "" );
   }

   public recalcular_permanencias( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 )
   {
      recalcular_permanencias.this.AV8clicod = aP0;
      recalcular_permanencias.this.AV13empcod = aP1;
      recalcular_permanencias.this.AV9legnumero = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02932 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8clicod), Short.valueOf(AV13empcod), Integer.valueOf(AV9legnumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P02932_A6LegNumero[0] ;
         A1EmpCod = P02932_A1EmpCod[0] ;
         A3CliCod = P02932_A3CliCod[0] ;
         A2254LegHisFecEgr = P02932_A2254LegHisFecEgr[0] ;
         A2253LegHisFecIng = P02932_A2253LegHisFecIng[0] ;
         AV10LegHisFecIng.add(A2253LegHisFecIng, 0);
         AV14LegHisFecEgr.add(A2254LegHisFecEgr, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV11i = (short)(1) ;
      while ( AV11i <= AV10LegHisFecIng.size() )
      {
         if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime((java.util.Date)AV14LegHisFecEgr.elementAt(-1+AV11i))) && ( AV11i < AV10LegHisFecIng.size() ) )
         {
            AV15calcularAntiguedad = false ;
         }
         else
         {
            AV15calcularAntiguedad = true ;
         }
         new web.new_legajo_permanencia(remoteHandle, context).execute( AV8clicod, AV13empcod, AV9legnumero, (java.util.Date)AV10LegHisFecIng.elementAt(-1+AV11i), (java.util.Date)AV14LegHisFecEgr.elementAt(-1+AV11i), AV12vaciaFecha, "", false, httpContext.getMessage( "recalculo", ""), AV15calcularAntiguedad) ;
         AV11i = (short)(AV11i+1) ;
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
      scmdbuf = "" ;
      P02932_A6LegNumero = new int[1] ;
      P02932_A1EmpCod = new short[1] ;
      P02932_A3CliCod = new int[1] ;
      P02932_A2254LegHisFecEgr = new java.util.Date[] {GXutil.nullDate()} ;
      P02932_A2253LegHisFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      A2254LegHisFecEgr = GXutil.nullDate() ;
      A2253LegHisFecIng = GXutil.nullDate() ;
      AV10LegHisFecIng = new GXSimpleCollection<java.util.Date>(java.util.Date.class, "internal", "");
      AV14LegHisFecEgr = new GXSimpleCollection<java.util.Date>(java.util.Date.class, "internal", "");
      AV12vaciaFecha = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.recalcular_permanencias__default(),
         new Object[] {
             new Object[] {
            P02932_A6LegNumero, P02932_A1EmpCod, P02932_A3CliCod, P02932_A2254LegHisFecEgr, P02932_A2253LegHisFecIng
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV13empcod ;
   private short A1EmpCod ;
   private short AV11i ;
   private short Gx_err ;
   private int AV8clicod ;
   private int AV9legnumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String scmdbuf ;
   private java.util.Date A2254LegHisFecEgr ;
   private java.util.Date A2253LegHisFecIng ;
   private java.util.Date AV12vaciaFecha ;
   private boolean AV15calcularAntiguedad ;
   private IDataStoreProvider pr_default ;
   private int[] P02932_A6LegNumero ;
   private short[] P02932_A1EmpCod ;
   private int[] P02932_A3CliCod ;
   private java.util.Date[] P02932_A2254LegHisFecEgr ;
   private java.util.Date[] P02932_A2253LegHisFecIng ;
   private GXSimpleCollection<java.util.Date> AV10LegHisFecIng ;
   private GXSimpleCollection<java.util.Date> AV14LegHisFecEgr ;
}

final  class recalcular_permanencias__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02932", "SELECT LegNumero, EmpCod, CliCod, LegHisFecEgr, LegHisFecIng FROM legajo_permanencia WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero, LegHisFecIng ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
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

