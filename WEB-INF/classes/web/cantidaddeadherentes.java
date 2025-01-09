package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class cantidaddeadherentes extends GXProcedure
{
   public cantidaddeadherentes( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cantidaddeadherentes.class ), "" );
   }

   public cantidaddeadherentes( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            int aP2 )
   {
      cantidaddeadherentes.this.aP3 = new short[] {0};
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
      cantidaddeadherentes.this.AV8CliCod = aP0;
      cantidaddeadherentes.this.AV9EmpCod = aP1;
      cantidaddeadherentes.this.AV10LegNumero = aP2;
      cantidaddeadherentes.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized group. */
      /* Using cursor P00XH2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero)});
      cV11cantidad = P00XH2_AV11cantidad[0] ;
      pr_default.close(0);
      AV11cantidad = (short)(AV11cantidad+cV11cantidad*1) ;
      /* End optimized group. */
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = cantidaddeadherentes.this.AV11cantidad;
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
      P00XH2_AV11cantidad = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.cantidaddeadherentes__default(),
         new Object[] {
             new Object[] {
            P00XH2_AV11cantidad
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short AV11cantidad ;
   private short cV11cantidad ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LegNumero ;
   private String scmdbuf ;
   private short[] aP3 ;
   private IDataStoreProvider pr_default ;
   private short[] P00XH2_AV11cantidad ;
}

final  class cantidaddeadherentes__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00XH2", "SELECT COUNT(*) FROM LegajoFamilia WHERE (CliCod = ? and EmpCod = ? and LegNumero = ?) AND (FamAdherente = TRUE) ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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

