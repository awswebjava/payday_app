package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class existebasedecalcempresa extends GXProcedure
{
   public existebasedecalcempresa( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( existebasedecalcempresa.class ), "" );
   }

   public existebasedecalcempresa( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              byte aP2 ,
                              String aP3 )
   {
      existebasedecalcempresa.this.aP4 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        byte aP2 ,
                        String aP3 ,
                        boolean[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             byte aP2 ,
                             String aP3 ,
                             boolean[] aP4 )
   {
      existebasedecalcempresa.this.AV11CliCod = aP0;
      existebasedecalcempresa.this.AV10EmpCod = aP1;
      existebasedecalcempresa.this.AV8EmpBaseClaseLeg = aP2;
      existebasedecalcempresa.this.AV9EmpBaseTipo = aP3;
      existebasedecalcempresa.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01S02 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Byte.valueOf(AV8EmpBaseClaseLeg), AV9EmpBaseTipo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1429EmpBaseTipo = P01S02_A1429EmpBaseTipo[0] ;
         A1427EmpBaseClaseLeg = P01S02_A1427EmpBaseClaseLeg[0] ;
         A1EmpCod = P01S02_A1EmpCod[0] ;
         A3CliCod = P01S02_A3CliCod[0] ;
         A1430EmpBaseCod1 = P01S02_A1430EmpBaseCod1[0] ;
         A1431EmpBaseCod2 = P01S02_A1431EmpBaseCod2[0] ;
         AV12existe = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = existebasedecalcempresa.this.AV12existe;
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
      P01S02_A1429EmpBaseTipo = new String[] {""} ;
      P01S02_A1427EmpBaseClaseLeg = new byte[1] ;
      P01S02_A1EmpCod = new short[1] ;
      P01S02_A3CliCod = new int[1] ;
      P01S02_A1430EmpBaseCod1 = new String[] {""} ;
      P01S02_A1431EmpBaseCod2 = new String[] {""} ;
      A1429EmpBaseTipo = "" ;
      A1430EmpBaseCod1 = "" ;
      A1431EmpBaseCod2 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.existebasedecalcempresa__default(),
         new Object[] {
             new Object[] {
            P01S02_A1429EmpBaseTipo, P01S02_A1427EmpBaseClaseLeg, P01S02_A1EmpCod, P01S02_A3CliCod, P01S02_A1430EmpBaseCod1, P01S02_A1431EmpBaseCod2
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV8EmpBaseClaseLeg ;
   private byte A1427EmpBaseClaseLeg ;
   private short AV10EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int A3CliCod ;
   private String AV9EmpBaseTipo ;
   private String scmdbuf ;
   private String A1429EmpBaseTipo ;
   private String A1430EmpBaseCod1 ;
   private String A1431EmpBaseCod2 ;
   private boolean AV12existe ;
   private boolean[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01S02_A1429EmpBaseTipo ;
   private byte[] P01S02_A1427EmpBaseClaseLeg ;
   private short[] P01S02_A1EmpCod ;
   private int[] P01S02_A3CliCod ;
   private String[] P01S02_A1430EmpBaseCod1 ;
   private String[] P01S02_A1431EmpBaseCod2 ;
}

final  class existebasedecalcempresa__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01S02", "SELECT EmpBaseTipo, EmpBaseClaseLeg, EmpCod, CliCod, EmpBaseCod1, EmpBaseCod2 FROM Empresabase_calculo WHERE CliCod = ? and EmpCod = ? and EmpBaseClaseLeg = ? and EmpBaseTipo = ( ?) ORDER BY CliCod, EmpCod, EmpBaseClaseLeg, EmpBaseTipo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
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
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
      }
   }

}

