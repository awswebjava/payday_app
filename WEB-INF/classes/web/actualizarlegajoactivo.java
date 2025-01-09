package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class actualizarlegajoactivo extends GXProcedure
{
   public actualizarlegajoactivo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( actualizarlegajoactivo.class ), "" );
   }

   public actualizarlegajoactivo( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        byte aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             byte aP3 )
   {
      actualizarlegajoactivo.this.AV10CliCod = aP0;
      actualizarlegajoactivo.this.AV8EmpCod = aP1;
      actualizarlegajoactivo.this.AV9LegNumero = aP2;
      actualizarlegajoactivo.this.AV11LegEstado = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV14Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV10CliCod, 6, 0))+httpContext.getMessage( " &EmpCod ", "")+GXutil.trim( GXutil.str( AV8EmpCod, 4, 0))+httpContext.getMessage( " &LegNumero ", "")+GXutil.trim( GXutil.str( AV9LegNumero, 8, 0))) ;
      AV15GXLvl2 = (byte)(0) ;
      /* Using cursor P01O72 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P01O72_A6LegNumero[0] ;
         A1EmpCod = P01O72_A1EmpCod[0] ;
         A3CliCod = P01O72_A3CliCod[0] ;
         A1818LegEstado = P01O72_A1818LegEstado[0] ;
         AV15GXLvl2 = (byte)(1) ;
         A1818LegEstado = AV11LegEstado ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV14Pgmname, httpContext.getMessage( "asigna estado ", "")+GXutil.trim( GXutil.str( AV11LegEstado, 1, 0))) ;
         /* Using cursor P01O73 */
         pr_default.execute(1, new Object[] {Byte.valueOf(A1818LegEstado), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Legajo");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV15GXLvl2 == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV14Pgmname, httpContext.getMessage( "none", "")) ;
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
      AV14Pgmname = "" ;
      scmdbuf = "" ;
      P01O72_A6LegNumero = new int[1] ;
      P01O72_A1EmpCod = new short[1] ;
      P01O72_A3CliCod = new int[1] ;
      P01O72_A1818LegEstado = new byte[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.actualizarlegajoactivo__default(),
         new Object[] {
             new Object[] {
            P01O72_A6LegNumero, P01O72_A1EmpCod, P01O72_A3CliCod, P01O72_A1818LegEstado
            }
            , new Object[] {
            }
         }
      );
      AV14Pgmname = "ActualizarLegajoActivo" ;
      /* GeneXus formulas. */
      AV14Pgmname = "ActualizarLegajoActivo" ;
      Gx_err = (short)(0) ;
   }

   private byte AV11LegEstado ;
   private byte AV15GXLvl2 ;
   private byte A1818LegEstado ;
   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV9LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV14Pgmname ;
   private String scmdbuf ;
   private IDataStoreProvider pr_default ;
   private int[] P01O72_A6LegNumero ;
   private short[] P01O72_A1EmpCod ;
   private int[] P01O72_A3CliCod ;
   private byte[] P01O72_A1818LegEstado ;
}

final  class actualizarlegajoactivo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01O72", "SELECT LegNumero, EmpCod, CliCod, LegEstado FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero  FOR UPDATE OF Legajo",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01O73", "SAVEPOINT gxupdate;UPDATE Legajo SET LegEstado=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((byte[]) buf[3])[0] = rslt.getByte(4);
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
            case 1 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

