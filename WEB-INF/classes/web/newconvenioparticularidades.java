package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newconvenioparticularidades extends GXProcedure
{
   public newconvenioparticularidades( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newconvenioparticularidades.class ), "" );
   }

   public newconvenioparticularidades( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        java.util.Date aP3 ,
                        boolean aP4 ,
                        short aP5 ,
                        byte aP6 ,
                        java.math.BigDecimal aP7 ,
                        String aP8 ,
                        boolean aP9 ,
                        byte aP10 ,
                        byte aP11 ,
                        int aP12 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             java.util.Date aP3 ,
                             boolean aP4 ,
                             short aP5 ,
                             byte aP6 ,
                             java.math.BigDecimal aP7 ,
                             String aP8 ,
                             boolean aP9 ,
                             byte aP10 ,
                             byte aP11 ,
                             int aP12 )
   {
      newconvenioparticularidades.this.AV20CliCod = aP0;
      newconvenioparticularidades.this.AV19CliPaiConve = aP1;
      newconvenioparticularidades.this.AV18CliConvenio = aP2;
      newconvenioparticularidades.this.AV17CliConveVig = aP3;
      newconvenioparticularidades.this.AV16ConveDefault = aP4;
      newconvenioparticularidades.this.AV15ConveInterDiasJor = aP5;
      newconvenioparticularidades.this.AV14ConveMinMesesVac = aP6;
      newconvenioparticularidades.this.AV13ConveMesHsPExt = aP7;
      newconvenioparticularidades.this.AV12ConveDiaHsPExt = aP8;
      newconvenioparticularidades.this.AV11ConveFondoCese = aP9;
      newconvenioparticularidades.this.AV10ConveGuarEdadMin = aP10;
      newconvenioparticularidades.this.AV9ConveGuarEdadMax = aP11;
      newconvenioparticularidades.this.AV8ConveRelSec = aP12;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE ClienteConvenio_Particularidades

      */
      A3CliCod = AV20CliCod ;
      A1564CliPaiConve = AV19CliPaiConve ;
      A1565CliConvenio = AV18CliConvenio ;
      A1575CliConveVig = AV17CliConveVig ;
      A905ConveDefault = AV16ConveDefault ;
      A1043ConveInterDiasJor = AV15ConveInterDiasJor ;
      A1046ConveMinMesesVac = AV14ConveMinMesesVac ;
      A1269ConveMesHsPExt = AV13ConveMesHsPExt ;
      A1270ConveDiaHsPExt = AV12ConveDiaHsPExt ;
      n1270ConveDiaHsPExt = false ;
      A1401ConveFondoCese = AV11ConveFondoCese ;
      A1627ConveGuarEdadMin = AV10ConveGuarEdadMin ;
      n1627ConveGuarEdadMin = false ;
      A1628ConveGuarEdadMax = AV9ConveGuarEdadMax ;
      n1628ConveGuarEdadMax = false ;
      A1897ConveRelSec = AV8ConveRelSec ;
      /* Using cursor P01TB2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Boolean.valueOf(A905ConveDefault), Short.valueOf(A1043ConveInterDiasJor), Byte.valueOf(A1046ConveMinMesesVac), A1269ConveMesHsPExt, Boolean.valueOf(n1270ConveDiaHsPExt), A1270ConveDiaHsPExt, Boolean.valueOf(A1401ConveFondoCese), Boolean.valueOf(n1627ConveGuarEdadMin), Byte.valueOf(A1627ConveGuarEdadMin), Boolean.valueOf(n1628ConveGuarEdadMax), Byte.valueOf(A1628ConveGuarEdadMax), Integer.valueOf(A1897ConveRelSec)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("ClienteConvenio_Particularidades");
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
      Application.commitDataStores(context, remoteHandle, pr_default, "newconvenioparticularidades");
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
      A1269ConveMesHsPExt = DecimalUtil.ZERO ;
      A1270ConveDiaHsPExt = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newconvenioparticularidades__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV14ConveMinMesesVac ;
   private byte AV10ConveGuarEdadMin ;
   private byte AV9ConveGuarEdadMax ;
   private byte A1046ConveMinMesesVac ;
   private byte A1627ConveGuarEdadMin ;
   private byte A1628ConveGuarEdadMax ;
   private short AV19CliPaiConve ;
   private short AV15ConveInterDiasJor ;
   private short A1564CliPaiConve ;
   private short A1043ConveInterDiasJor ;
   private short Gx_err ;
   private int AV20CliCod ;
   private int AV8ConveRelSec ;
   private int GX_INS204 ;
   private int A3CliCod ;
   private int A1897ConveRelSec ;
   private java.math.BigDecimal AV13ConveMesHsPExt ;
   private java.math.BigDecimal A1269ConveMesHsPExt ;
   private String AV18CliConvenio ;
   private String AV12ConveDiaHsPExt ;
   private String A1565CliConvenio ;
   private String A1270ConveDiaHsPExt ;
   private String Gx_emsg ;
   private java.util.Date AV17CliConveVig ;
   private java.util.Date A1575CliConveVig ;
   private boolean AV16ConveDefault ;
   private boolean AV11ConveFondoCese ;
   private boolean A905ConveDefault ;
   private boolean n1270ConveDiaHsPExt ;
   private boolean A1401ConveFondoCese ;
   private boolean n1627ConveGuarEdadMin ;
   private boolean n1628ConveGuarEdadMax ;
   private IDataStoreProvider pr_default ;
}

final  class newconvenioparticularidades__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01TB2", "SAVEPOINT gxupdate;INSERT INTO ClienteConvenio_Particularidades(CliCod, CliPaiConve, CliConvenio, CliConveVig, ConveDefault, ConveInterDiasJor, ConveMinMesesVac, ConveMesHsPExt, ConveDiaHsPExt, ConveFondoCese, ConveGuarEdadMin, ConveGuarEdadMax, ConveRelSec, ConveDiasAcuVac, ConveRelRef, ConvePartOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0, '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setByte(7, ((Number) parms[6]).byteValue());
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 1);
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(9, (String)parms[9], 20);
               }
               stmt.setBoolean(10, ((Boolean) parms[10]).booleanValue());
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(11, ((Number) parms[12]).byteValue());
               }
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(12, ((Number) parms[14]).byteValue());
               }
               stmt.setInt(13, ((Number) parms[15]).intValue());
               return;
      }
   }

}

