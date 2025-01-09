package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class actualizaarchivosliq extends GXProcedure
{
   public actualizaarchivosliq( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( actualizaarchivosliq.class ), "" );
   }

   public actualizaarchivosliq( int remoteHandle ,
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
      actualizaarchivosliq.this.AV8CliCod = aP0;
      actualizaarchivosliq.this.AV9EmpCod = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, "1") ;
      /* Using cursor P012J2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A278LiqEstado = P012J2_A278LiqEstado[0] ;
         A1EmpCod = P012J2_A1EmpCod[0] ;
         A3CliCod = P012J2_A3CliCod[0] ;
         A31LiqNro = P012J2_A31LiqNro[0] ;
         GXv_char1[0] = "" ;
         new web.resetearecibos(remoteHandle, context).execute( A3CliCod, A1EmpCod, A31LiqNro, 0, GXv_char1) ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
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
      AV19Pgmname = "" ;
      scmdbuf = "" ;
      P012J2_A278LiqEstado = new byte[1] ;
      P012J2_A1EmpCod = new short[1] ;
      P012J2_A3CliCod = new int[1] ;
      P012J2_A31LiqNro = new int[1] ;
      GXv_char1 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.actualizaarchivosliq__default(),
         new Object[] {
             new Object[] {
            P012J2_A278LiqEstado, P012J2_A1EmpCod, P012J2_A3CliCod, P012J2_A31LiqNro
            }
         }
      );
      AV19Pgmname = "ActualizaArchivosLiq" ;
      /* GeneXus formulas. */
      AV19Pgmname = "ActualizaArchivosLiq" ;
      Gx_err = (short)(0) ;
   }

   private byte A278LiqEstado ;
   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private String AV19Pgmname ;
   private String scmdbuf ;
   private String GXv_char1[] ;
   private IDataStoreProvider pr_default ;
   private byte[] P012J2_A278LiqEstado ;
   private short[] P012J2_A1EmpCod ;
   private int[] P012J2_A3CliCod ;
   private int[] P012J2_A31LiqNro ;
}

final  class actualizaarchivosliq__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P012J2", "SELECT LiqEstado, EmpCod, CliCod, LiqNro FROM Liquidacion WHERE (CliCod = ? and EmpCod = ?) AND (LiqEstado <> 4) ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
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

