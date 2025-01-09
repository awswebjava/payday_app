package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconvemanejafondocese extends GXProcedure
{
   public getconvemanejafondocese( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconvemanejafondocese.class ), "" );
   }

   public getconvemanejafondocese( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              short aP3 ,
                              java.util.Date aP4 ,
                              String aP5 )
   {
      getconvemanejafondocese.this.aP6 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        boolean[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             boolean[] aP6 )
   {
      getconvemanejafondocese.this.AV13CliCod = aP0;
      getconvemanejafondocese.this.AV15EmpCod = aP1;
      getconvemanejafondocese.this.AV14LegNumero = aP2;
      getconvemanejafondocese.this.AV10PaiCod = aP3;
      getconvemanejafondocese.this.AV12LiqPeriodo = aP4;
      getconvemanejafondocese.this.AV9ConveCodigo = aP5;
      getconvemanejafondocese.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_int1[0] = AV11CliConveVer ;
      new web.getversiondelegajo(remoteHandle, context).execute( AV13CliCod, AV15EmpCod, AV14LegNumero, GXv_int1) ;
      getconvemanejafondocese.this.AV11CliConveVer = GXv_int1[0] ;
      /* Using cursor P01CX2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliConveVer), Short.valueOf(AV10PaiCod), AV9ConveCodigo, AV12LiqPeriodo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P01CX2_A3CliCod[0] ;
         A1564CliPaiConve = P01CX2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01CX2_A1565CliConvenio[0] ;
         A1575CliConveVig = P01CX2_A1575CliConveVig[0] ;
         A1401ConveFondoCese = P01CX2_A1401ConveFondoCese[0] ;
         AV8ConveFondoCese = A1401ConveFondoCese ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = getconvemanejafondocese.this.AV8ConveFondoCese;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_int1 = new int[1] ;
      scmdbuf = "" ;
      P01CX2_A3CliCod = new int[1] ;
      P01CX2_A1564CliPaiConve = new short[1] ;
      P01CX2_A1565CliConvenio = new String[] {""} ;
      P01CX2_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      P01CX2_A1401ConveFondoCese = new boolean[] {false} ;
      A1565CliConvenio = "" ;
      A1575CliConveVig = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getconvemanejafondocese__default(),
         new Object[] {
             new Object[] {
            P01CX2_A3CliCod, P01CX2_A1564CliPaiConve, P01CX2_A1565CliConvenio, P01CX2_A1575CliConveVig, P01CX2_A1401ConveFondoCese
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV15EmpCod ;
   private short AV10PaiCod ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV14LegNumero ;
   private int AV11CliConveVer ;
   private int GXv_int1[] ;
   private int A3CliCod ;
   private String AV9ConveCodigo ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private java.util.Date AV12LiqPeriodo ;
   private java.util.Date A1575CliConveVig ;
   private boolean AV8ConveFondoCese ;
   private boolean A1401ConveFondoCese ;
   private boolean[] aP6 ;
   private IDataStoreProvider pr_default ;
   private int[] P01CX2_A3CliCod ;
   private short[] P01CX2_A1564CliPaiConve ;
   private String[] P01CX2_A1565CliConvenio ;
   private java.util.Date[] P01CX2_A1575CliConveVig ;
   private boolean[] P01CX2_A1401ConveFondoCese ;
}

final  class getconvemanejafondocese__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01CX2", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveVig, ConveFondoCese FROM ClienteConvenio_Particularidades WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CliConveVig <= ? ORDER BY CliCod, CliPaiConve, CliConvenio, CliConveVig DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
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
      }
   }

}

