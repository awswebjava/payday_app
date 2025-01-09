package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getvacminmesesvac extends GXProcedure
{
   public getvacminmesesvac( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getvacminmesesvac.class ), "" );
   }

   public getvacminmesesvac( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           String aP2 ,
                           java.util.Date aP3 )
   {
      getvacminmesesvac.this.aP4 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        java.util.Date aP3 ,
                        byte[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             java.util.Date aP3 ,
                             byte[] aP4 )
   {
      getvacminmesesvac.this.AV13CliCod = aP0;
      getvacminmesesvac.this.AV8PaiCod = aP1;
      getvacminmesesvac.this.AV9ConveCodigo = aP2;
      getvacminmesesvac.this.AV12CliConveVig = aP3;
      getvacminmesesvac.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "&PaiCod", "")+GXutil.trim( GXutil.str( AV8PaiCod, 4, 0))+httpContext.getMessage( " &ConveCodigo ", "")+GXutil.trim( AV9ConveCodigo)) ;
      if ( ! (GXutil.strcmp("", AV9ConveCodigo)==0) )
      {
         /* Using cursor P029X2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV8PaiCod), AV9ConveCodigo, AV12CliConveVig});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A3CliCod = P029X2_A3CliCod[0] ;
            A1564CliPaiConve = P029X2_A1564CliPaiConve[0] ;
            A1565CliConvenio = P029X2_A1565CliConvenio[0] ;
            A1575CliConveVig = P029X2_A1575CliConveVig[0] ;
            A1046ConveMinMesesVac = P029X2_A1046ConveMinMesesVac[0] ;
            AV14ConveMinMesesVac = A1046ConveMinMesesVac ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(0);
         }
         pr_default.close(0);
      }
      else
      {
         /* Using cursor P029X3 */
         pr_default.execute(1, new Object[] {Short.valueOf(AV8PaiCod)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A46PaiCod = P029X3_A46PaiCod[0] ;
            A1764PaiMinMesesVac = P029X3_A1764PaiMinMesesVac[0] ;
            AV14ConveMinMesesVac = A1764PaiMinMesesVac ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getvacminmesesvac.this.AV14ConveMinMesesVac;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV17Pgmname = "" ;
      scmdbuf = "" ;
      P029X2_A3CliCod = new int[1] ;
      P029X2_A1564CliPaiConve = new short[1] ;
      P029X2_A1565CliConvenio = new String[] {""} ;
      P029X2_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      P029X2_A1046ConveMinMesesVac = new byte[1] ;
      A1565CliConvenio = "" ;
      A1575CliConveVig = GXutil.nullDate() ;
      P029X3_A46PaiCod = new short[1] ;
      P029X3_A1764PaiMinMesesVac = new byte[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getvacminmesesvac__default(),
         new Object[] {
             new Object[] {
            P029X2_A3CliCod, P029X2_A1564CliPaiConve, P029X2_A1565CliConvenio, P029X2_A1575CliConveVig, P029X2_A1046ConveMinMesesVac
            }
            , new Object[] {
            P029X3_A46PaiCod, P029X3_A1764PaiMinMesesVac
            }
         }
      );
      AV17Pgmname = "getVacMinMesesVac" ;
      /* GeneXus formulas. */
      AV17Pgmname = "getVacMinMesesVac" ;
      Gx_err = (short)(0) ;
   }

   private byte AV14ConveMinMesesVac ;
   private byte A1046ConveMinMesesVac ;
   private byte A1764PaiMinMesesVac ;
   private short AV8PaiCod ;
   private short A1564CliPaiConve ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int A3CliCod ;
   private String AV9ConveCodigo ;
   private String AV17Pgmname ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private java.util.Date AV12CliConveVig ;
   private java.util.Date A1575CliConveVig ;
   private byte[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P029X2_A3CliCod ;
   private short[] P029X2_A1564CliPaiConve ;
   private String[] P029X2_A1565CliConvenio ;
   private java.util.Date[] P029X2_A1575CliConveVig ;
   private byte[] P029X2_A1046ConveMinMesesVac ;
   private short[] P029X3_A46PaiCod ;
   private byte[] P029X3_A1764PaiMinMesesVac ;
}

final  class getvacminmesesvac__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P029X2", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveVig, ConveMinMesesVac FROM ClienteConvenio_Particularidades WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CliConveVig <= ? ORDER BY CliCod, CliPaiConve, CliConvenio, CliConveVig DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P029X3", "SELECT PaiCod, PaiMinMesesVac FROM Pais WHERE PaiCod = ? ORDER BY PaiCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
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
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

