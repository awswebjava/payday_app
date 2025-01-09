package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class actualizarrecalculaendetalles extends GXProcedure
{
   public actualizarrecalculaendetalles( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( actualizarrecalculaendetalles.class ), "" );
   }

   public actualizarrecalculaendetalles( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        boolean aP3 ,
                        short aP4 ,
                        short aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             boolean aP3 ,
                             short aP4 ,
                             short aP5 )
   {
      actualizarrecalculaendetalles.this.AV11CliCod = aP0;
      actualizarrecalculaendetalles.this.AV8DConCodigo = aP1;
      actualizarrecalculaendetalles.this.AV9oldConRecalcular = aP2;
      actualizarrecalculaendetalles.this.AV10ConRecalcular = aP3;
      actualizarrecalculaendetalles.this.AV15oldAplIIGG = aP4;
      actualizarrecalculaendetalles.this.AV14AplIIGG = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ( AV9oldConRecalcular != AV10ConRecalcular ) || ( AV15oldAplIIGG != AV14AplIIGG ) )
      {
         /* Using cursor P00TP2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), AV8DConCodigo});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A394DConCodigo = P00TP2_A394DConCodigo[0] ;
            A3CliCod = P00TP2_A3CliCod[0] ;
            A763LiqDRecalculado = P00TP2_A763LiqDRecalculado[0] ;
            A1122DAplIIGG = P00TP2_A1122DAplIIGG[0] ;
            n1122DAplIIGG = P00TP2_n1122DAplIIGG[0] ;
            A1EmpCod = P00TP2_A1EmpCod[0] ;
            A31LiqNro = P00TP2_A31LiqNro[0] ;
            A6LegNumero = P00TP2_A6LegNumero[0] ;
            A81LiqDSecuencial = P00TP2_A81LiqDSecuencial[0] ;
            if ( AV9oldConRecalcular != AV10ConRecalcular )
            {
               if ( ! AV9oldConRecalcular && ( AV10ConRecalcular ) )
               {
                  A763LiqDRecalculado = (short)(0) ;
               }
               else
               {
                  if ( ( AV9oldConRecalcular ) && ! AV10ConRecalcular )
                  {
                     A763LiqDRecalculado = (short)(2) ;
                  }
               }
            }
            else
            {
               A1122DAplIIGG = AV14AplIIGG ;
               n1122DAplIIGG = false ;
            }
            /* Using cursor P00TP3 */
            pr_default.execute(1, new Object[] {Short.valueOf(A763LiqDRecalculado), Boolean.valueOf(n1122DAplIIGG), Short.valueOf(A1122DAplIIGG), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Integer.valueOf(A81LiqDSecuencial)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionDetalle");
            pr_default.readNext(0);
         }
         pr_default.close(0);
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "actualizarrecalculaendetalles");
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
      P00TP2_A394DConCodigo = new String[] {""} ;
      P00TP2_A3CliCod = new int[1] ;
      P00TP2_A763LiqDRecalculado = new short[1] ;
      P00TP2_A1122DAplIIGG = new short[1] ;
      P00TP2_n1122DAplIIGG = new boolean[] {false} ;
      P00TP2_A1EmpCod = new short[1] ;
      P00TP2_A31LiqNro = new int[1] ;
      P00TP2_A6LegNumero = new int[1] ;
      P00TP2_A81LiqDSecuencial = new int[1] ;
      A394DConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.actualizarrecalculaendetalles__default(),
         new Object[] {
             new Object[] {
            P00TP2_A394DConCodigo, P00TP2_A3CliCod, P00TP2_A763LiqDRecalculado, P00TP2_A1122DAplIIGG, P00TP2_n1122DAplIIGG, P00TP2_A1EmpCod, P00TP2_A31LiqNro, P00TP2_A6LegNumero, P00TP2_A81LiqDSecuencial
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV15oldAplIIGG ;
   private short AV14AplIIGG ;
   private short A763LiqDRecalculado ;
   private short A1122DAplIIGG ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int A81LiqDSecuencial ;
   private String AV8DConCodigo ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private boolean AV9oldConRecalcular ;
   private boolean AV10ConRecalcular ;
   private boolean n1122DAplIIGG ;
   private IDataStoreProvider pr_default ;
   private String[] P00TP2_A394DConCodigo ;
   private int[] P00TP2_A3CliCod ;
   private short[] P00TP2_A763LiqDRecalculado ;
   private short[] P00TP2_A1122DAplIIGG ;
   private boolean[] P00TP2_n1122DAplIIGG ;
   private short[] P00TP2_A1EmpCod ;
   private int[] P00TP2_A31LiqNro ;
   private int[] P00TP2_A6LegNumero ;
   private int[] P00TP2_A81LiqDSecuencial ;
}

final  class actualizarrecalculaendetalles__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00TP2", "SELECT DConCodigo, CliCod, LiqDRecalculado, DAplIIGG, EmpCod, LiqNro, LegNumero, LiqDSecuencial FROM LiquidacionDetalle WHERE (CliCod = ?) AND (DConCodigo = ( ?)) ORDER BY CliCod  FOR UPDATE OF LiquidacionDetalle",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00TP3", "SAVEPOINT gxupdate;UPDATE LiquidacionDetalle SET LiqDRecalculado=?, DAplIIGG=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? AND LiqDSecuencial = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((int[]) buf[7])[0] = rslt.getInt(7);
               ((int[]) buf[8])[0] = rslt.getInt(8);
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
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               stmt.setInt(3, ((Number) parms[3]).intValue());
               stmt.setShort(4, ((Number) parms[4]).shortValue());
               stmt.setInt(5, ((Number) parms[5]).intValue());
               stmt.setInt(6, ((Number) parms[6]).intValue());
               stmt.setInt(7, ((Number) parms[7]).intValue());
               return;
      }
   }

}

