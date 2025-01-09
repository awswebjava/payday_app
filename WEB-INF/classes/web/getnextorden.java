package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getnextorden extends GXProcedure
{
   public getnextorden( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getnextorden.class ), "" );
   }

   public getnextorden( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( short aP0 ,
                            int aP1 )
   {
      getnextorden.this.aP2 = new short[] {0};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( short aP0 ,
                        int aP1 ,
                        short[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( short aP0 ,
                             int aP1 ,
                             short[] aP2 )
   {
      getnextorden.this.AV8EmpCod = aP0;
      getnextorden.this.AV9LegNumero = aP1;
      getnextorden.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV11CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      getnextorden.this.GXt_int1 = GXv_int2[0] ;
      AV11CliCod = GXt_int1 ;
      /* Using cursor P000R2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P000R2_A3CliCod[0] ;
         A1EmpCod = P000R2_A1EmpCod[0] ;
         A6LegNumero = P000R2_A6LegNumero[0] ;
         A25AgeOrden = P000R2_A25AgeOrden[0] ;
         AV10AgeOrden = A25AgeOrden ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV10AgeOrden = (short)(AV10AgeOrden+1) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getnextorden.this.AV10AgeOrden;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_int2 = new int[1] ;
      scmdbuf = "" ;
      P000R2_A3CliCod = new int[1] ;
      P000R2_A1EmpCod = new short[1] ;
      P000R2_A6LegNumero = new int[1] ;
      P000R2_A25AgeOrden = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getnextorden__default(),
         new Object[] {
             new Object[] {
            P000R2_A3CliCod, P000R2_A1EmpCod, P000R2_A6LegNumero, P000R2_A25AgeOrden
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short AV10AgeOrden ;
   private short A1EmpCod ;
   private short A25AgeOrden ;
   private short Gx_err ;
   private int AV9LegNumero ;
   private int AV11CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private String scmdbuf ;
   private short[] aP2 ;
   private IDataStoreProvider pr_default ;
   private int[] P000R2_A3CliCod ;
   private short[] P000R2_A1EmpCod ;
   private int[] P000R2_A6LegNumero ;
   private short[] P000R2_A25AgeOrden ;
}

final  class getnextorden__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P000R2", "SELECT CliCod, EmpCod, LegNumero, AgeOrden FROM AgendaNovedades WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero, AgeOrden DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[3])[0] = rslt.getShort(4);
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

