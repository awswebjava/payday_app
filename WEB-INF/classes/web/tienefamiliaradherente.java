package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class tienefamiliaradherente extends GXProcedure
{
   public tienefamiliaradherente( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tienefamiliaradherente.class ), "" );
   }

   public tienefamiliaradherente( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 )
   {
      tienefamiliaradherente.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             boolean[] aP3 )
   {
      tienefamiliaradherente.this.AV11CliCod = aP0;
      tienefamiliaradherente.this.AV10EmpCod = aP1;
      tienefamiliaradherente.this.AV9LegNumero = aP2;
      tienefamiliaradherente.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P019W2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV9LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A890FamAdherente = P019W2_A890FamAdherente[0] ;
         A6LegNumero = P019W2_A6LegNumero[0] ;
         A1EmpCod = P019W2_A1EmpCod[0] ;
         A3CliCod = P019W2_A3CliCod[0] ;
         A29LegOrden = P019W2_A29LegOrden[0] ;
         AV8tiene = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = tienefamiliaradherente.this.AV8tiene;
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
      P019W2_A890FamAdherente = new boolean[] {false} ;
      P019W2_A6LegNumero = new int[1] ;
      P019W2_A1EmpCod = new short[1] ;
      P019W2_A3CliCod = new int[1] ;
      P019W2_A29LegOrden = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.tienefamiliaradherente__default(),
         new Object[] {
             new Object[] {
            P019W2_A890FamAdherente, P019W2_A6LegNumero, P019W2_A1EmpCod, P019W2_A3CliCod, P019W2_A29LegOrden
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short A1EmpCod ;
   private short A29LegOrden ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV9LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String scmdbuf ;
   private boolean AV8tiene ;
   private boolean A890FamAdherente ;
   private boolean[] aP3 ;
   private IDataStoreProvider pr_default ;
   private boolean[] P019W2_A890FamAdherente ;
   private int[] P019W2_A6LegNumero ;
   private short[] P019W2_A1EmpCod ;
   private int[] P019W2_A3CliCod ;
   private short[] P019W2_A29LegOrden ;
}

final  class tienefamiliaradherente__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P019W2", "SELECT FamAdherente, LegNumero, EmpCod, CliCod, LegOrden FROM LegajoFamilia WHERE (CliCod = ? and EmpCod = ? and LegNumero = ?) AND (FamAdherente = TRUE) ORDER BY CliCod, EmpCod, LegNumero  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

