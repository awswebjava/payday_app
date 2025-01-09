package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getperiodosiguiente extends GXProcedure
{
   public getperiodosiguiente( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getperiodosiguiente.class ), "" );
   }

   public getperiodosiguiente( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            short[] aP2 )
   {
      getperiodosiguiente.this.aP3 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short[] aP2 ,
                        short[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short[] aP2 ,
                             short[] aP3 )
   {
      getperiodosiguiente.this.AV11CliCod = aP0;
      getperiodosiguiente.this.AV12EmpCod = aP1;
      getperiodosiguiente.this.AV8MesNro = aP2[0];
      this.aP2 = aP2;
      getperiodosiguiente.this.AV10anio = aP3[0];
      this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( (0==AV8MesNro) )
      {
         AV15GXLvl3 = (byte)(0) ;
         /* Using cursor P02142 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV12EmpCod)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A3CliCod = P02142_A3CliCod[0] ;
            A1EmpCod = P02142_A1EmpCod[0] ;
            A245LegFecIngreso = P02142_A245LegFecIngreso[0] ;
            A6LegNumero = P02142_A6LegNumero[0] ;
            AV15GXLvl3 = (byte)(1) ;
            AV10anio = (short)(GXutil.year( A245LegFecIngreso)) ;
            AV8MesNro = (short)(GXutil.month( A245LegFecIngreso)) ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( AV15GXLvl3 == 0 )
         {
            AV9hoy = GXutil.serverDate( context, remoteHandle, pr_default) ;
            AV10anio = (short)(GXutil.year( AV9hoy)) ;
            AV8MesNro = (short)(1) ;
         }
      }
      else
      {
         if ( AV8MesNro == 12 )
         {
            AV8MesNro = (short)(1) ;
            AV10anio = (short)(AV10anio+1) ;
         }
         else
         {
            AV8MesNro = (short)(AV8MesNro+1) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getperiodosiguiente.this.AV8MesNro;
      this.aP3[0] = getperiodosiguiente.this.AV10anio;
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
      P02142_A3CliCod = new int[1] ;
      P02142_A1EmpCod = new short[1] ;
      P02142_A245LegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      P02142_A6LegNumero = new int[1] ;
      A245LegFecIngreso = GXutil.nullDate() ;
      AV9hoy = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getperiodosiguiente__default(),
         new Object[] {
             new Object[] {
            P02142_A3CliCod, P02142_A1EmpCod, P02142_A245LegFecIngreso, P02142_A6LegNumero
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV15GXLvl3 ;
   private short AV12EmpCod ;
   private short AV8MesNro ;
   private short AV10anio ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private String scmdbuf ;
   private java.util.Date A245LegFecIngreso ;
   private java.util.Date AV9hoy ;
   private short[] aP3 ;
   private short[] aP2 ;
   private IDataStoreProvider pr_default ;
   private int[] P02142_A3CliCod ;
   private short[] P02142_A1EmpCod ;
   private java.util.Date[] P02142_A245LegFecIngreso ;
   private int[] P02142_A6LegNumero ;
}

final  class getperiodosiguiente__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02142", "SELECT CliCod, EmpCod, LegFecIngreso, LegNumero FROM Legajo WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod, LegFecIngreso  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
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

