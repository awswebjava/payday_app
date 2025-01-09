package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class existebasedecalculo extends GXProcedure
{
   public existebasedecalculo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( existebasedecalculo.class ), "" );
   }

   public existebasedecalculo( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              String aP2 ,
                              byte aP3 ,
                              String aP4 )
   {
      existebasedecalculo.this.aP5 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        byte aP3 ,
                        String aP4 ,
                        boolean[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             byte aP3 ,
                             String aP4 ,
                             boolean[] aP5 )
   {
      existebasedecalculo.this.AV12CliCod = aP0;
      existebasedecalculo.this.AV11CliPaiConve = aP1;
      existebasedecalculo.this.AV10CliConvenio = aP2;
      existebasedecalculo.this.AV9ConveBaseClaseLeg = aP3;
      existebasedecalculo.this.AV8ConveBaseTipo = aP4;
      existebasedecalculo.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01P62 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV11CliPaiConve), AV10CliConvenio, Byte.valueOf(AV9ConveBaseClaseLeg), AV8ConveBaseTipo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1455ConveBaseTipo = P01P62_A1455ConveBaseTipo[0] ;
         A1454ConveBaseClaseLeg = P01P62_A1454ConveBaseClaseLeg[0] ;
         A1565CliConvenio = P01P62_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01P62_A1564CliPaiConve[0] ;
         A3CliCod = P01P62_A3CliCod[0] ;
         A1456ConveBaseCod1 = P01P62_A1456ConveBaseCod1[0] ;
         A1457ConveBaseCod2 = P01P62_A1457ConveBaseCod2[0] ;
         AV13existe = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = existebasedecalculo.this.AV13existe;
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
      P01P62_A1455ConveBaseTipo = new String[] {""} ;
      P01P62_A1454ConveBaseClaseLeg = new byte[1] ;
      P01P62_A1565CliConvenio = new String[] {""} ;
      P01P62_A1564CliPaiConve = new short[1] ;
      P01P62_A3CliCod = new int[1] ;
      P01P62_A1456ConveBaseCod1 = new String[] {""} ;
      P01P62_A1457ConveBaseCod2 = new String[] {""} ;
      A1455ConveBaseTipo = "" ;
      A1565CliConvenio = "" ;
      A1456ConveBaseCod1 = "" ;
      A1457ConveBaseCod2 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.existebasedecalculo__default(),
         new Object[] {
             new Object[] {
            P01P62_A1455ConveBaseTipo, P01P62_A1454ConveBaseClaseLeg, P01P62_A1565CliConvenio, P01P62_A1564CliPaiConve, P01P62_A3CliCod, P01P62_A1456ConveBaseCod1, P01P62_A1457ConveBaseCod2
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV9ConveBaseClaseLeg ;
   private byte A1454ConveBaseClaseLeg ;
   private short AV11CliPaiConve ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int A3CliCod ;
   private String AV10CliConvenio ;
   private String AV8ConveBaseTipo ;
   private String scmdbuf ;
   private String A1455ConveBaseTipo ;
   private String A1565CliConvenio ;
   private String A1456ConveBaseCod1 ;
   private String A1457ConveBaseCod2 ;
   private boolean AV13existe ;
   private boolean[] aP5 ;
   private IDataStoreProvider pr_default ;
   private String[] P01P62_A1455ConveBaseTipo ;
   private byte[] P01P62_A1454ConveBaseClaseLeg ;
   private String[] P01P62_A1565CliConvenio ;
   private short[] P01P62_A1564CliPaiConve ;
   private int[] P01P62_A3CliCod ;
   private String[] P01P62_A1456ConveBaseCod1 ;
   private String[] P01P62_A1457ConveBaseCod2 ;
}

final  class existebasedecalculo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01P62", "SELECT ConveBaseTipo, ConveBaseClaseLeg, CliConvenio, CliPaiConve, CliCod, ConveBaseCod1, ConveBaseCod2 FROM Convenio_base_calculo WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConveBaseClaseLeg = ? and ConveBaseTipo = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, ConveBaseClaseLeg, ConveBaseTipo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
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
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setString(5, (String)parms[4], 20);
               return;
      }
   }

}

