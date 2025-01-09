package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class algunlegconconvenioexiste extends GXProcedure
{
   public algunlegconconvenioexiste( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( algunlegconconvenioexiste.class ), "" );
   }

   public algunlegconconvenioexiste( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 )
   {
      algunlegconconvenioexiste.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             boolean[] aP2 )
   {
      algunlegconconvenioexiste.this.AV10CliCod = aP0;
      algunlegconconvenioexiste.this.AV9EmpCod = aP1;
      algunlegconconvenioexiste.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P020T2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV9EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A937LegConveCodigo = P020T2_A937LegConveCodigo[0] ;
         n937LegConveCodigo = P020T2_n937LegConveCodigo[0] ;
         A1EmpCod = P020T2_A1EmpCod[0] ;
         A3CliCod = P020T2_A3CliCod[0] ;
         A6LegNumero = P020T2_A6LegNumero[0] ;
         AV8existe = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = algunlegconconvenioexiste.this.AV8existe;
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
      P020T2_A937LegConveCodigo = new String[] {""} ;
      P020T2_n937LegConveCodigo = new boolean[] {false} ;
      P020T2_A1EmpCod = new short[1] ;
      P020T2_A3CliCod = new int[1] ;
      P020T2_A6LegNumero = new int[1] ;
      A937LegConveCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.algunlegconconvenioexiste__default(),
         new Object[] {
             new Object[] {
            P020T2_A937LegConveCodigo, P020T2_n937LegConveCodigo, P020T2_A1EmpCod, P020T2_A3CliCod, P020T2_A6LegNumero
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private String scmdbuf ;
   private String A937LegConveCodigo ;
   private boolean AV8existe ;
   private boolean n937LegConveCodigo ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P020T2_A937LegConveCodigo ;
   private boolean[] P020T2_n937LegConveCodigo ;
   private short[] P020T2_A1EmpCod ;
   private int[] P020T2_A3CliCod ;
   private int[] P020T2_A6LegNumero ;
}

final  class algunlegconconvenioexiste__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P020T2", "SELECT LegConveCodigo, EmpCod, CliCod, LegNumero FROM Legajo WHERE (CliCod = ? and EmpCod = ?) AND (Not LegConveCodigo IS NULL) ORDER BY CliCod, EmpCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((int[]) buf[4])[0] = rslt.getInt(4);
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

