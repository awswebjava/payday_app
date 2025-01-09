package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newconveniovacaciones extends GXProcedure
{
   public newconveniovacaciones( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newconveniovacaciones.class ), "" );
   }

   public newconveniovacaciones( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        java.util.Date aP3 ,
                        byte aP4 ,
                        byte aP5 ,
                        byte aP6 ,
                        int aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             java.util.Date aP3 ,
                             byte aP4 ,
                             byte aP5 ,
                             byte aP6 ,
                             int aP7 )
   {
      newconveniovacaciones.this.AV8CliCod = aP0;
      newconveniovacaciones.this.AV15CliPaiConve = aP1;
      newconveniovacaciones.this.AV14CliConvenio = aP2;
      newconveniovacaciones.this.AV13CliConveVig = aP3;
      newconveniovacaciones.this.AV12CliConveVacDesAnt = aP4;
      newconveniovacaciones.this.AV9CliConveVacHasAnt = aP5;
      newconveniovacaciones.this.AV11CliConveVacDias = aP6;
      newconveniovacaciones.this.AV10ConveVacRelSec = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE ClienteConvenio_ParticularidadesVacacion

      */
      A3CliCod = AV8CliCod ;
      A1564CliPaiConve = AV15CliPaiConve ;
      A1565CliConvenio = AV14CliConvenio ;
      A1575CliConveVig = AV13CliConveVig ;
      A1761CliConveVacDesAnt = AV12CliConveVacDesAnt ;
      A1762CliConveVacHasAnt = AV9CliConveVacHasAnt ;
      A1763CliConveVacDias = AV11CliConveVacDias ;
      A1902ConveVacRelSec = AV10ConveVacRelSec ;
      A2038ConveVacRelRef = "" ;
      A2039ConveVacOld = "" ;
      /* Using cursor P01TC2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Byte.valueOf(A1761CliConveVacDesAnt), Byte.valueOf(A1762CliConveVacHasAnt), Byte.valueOf(A1763CliConveVacDias), Integer.valueOf(A1902ConveVacRelSec), A2038ConveVacRelRef, A2039ConveVacOld});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("ClienteConvenio_ParticularidadesVacacion");
      if ( (pr_default.getStatus(0) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "newconveniovacaciones");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A1565CliConvenio = "" ;
      A1575CliConveVig = GXutil.nullDate() ;
      A2038ConveVacRelRef = "" ;
      A2039ConveVacOld = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newconveniovacaciones__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV12CliConveVacDesAnt ;
   private byte AV9CliConveVacHasAnt ;
   private byte AV11CliConveVacDias ;
   private byte A1761CliConveVacDesAnt ;
   private byte A1762CliConveVacHasAnt ;
   private byte A1763CliConveVacDias ;
   private short AV15CliPaiConve ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10ConveVacRelSec ;
   private int GX_INS239 ;
   private int A3CliCod ;
   private int A1902ConveVacRelSec ;
   private String AV14CliConvenio ;
   private String A1565CliConvenio ;
   private String Gx_emsg ;
   private java.util.Date AV13CliConveVig ;
   private java.util.Date A1575CliConveVig ;
   private String A2039ConveVacOld ;
   private String A2038ConveVacRelRef ;
   private IDataStoreProvider pr_default ;
}

final  class newconveniovacaciones__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01TC2", "SAVEPOINT gxupdate;INSERT INTO ClienteConvenio_ParticularidadesVacacion(CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveVacDesAnt, CliConveVacHasAnt, CliConveVacDias, ConveVacRelSec, ConveVacRelRef, ConveVacOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
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
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setByte(7, ((Number) parms[6]).byteValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setVarchar(9, (String)parms[8], 40, false);
               stmt.setNLongVarchar(10, (String)parms[9], false);
               return;
      }
   }

}

