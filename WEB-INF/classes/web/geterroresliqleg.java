package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class geterroresliqleg extends GXProcedure
{
   public geterroresliqleg( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( geterroresliqleg.class ), "" );
   }

   public geterroresliqleg( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              GXSimpleCollection<String>[] aP3 )
   {
      geterroresliqleg.this.aP4 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        GXSimpleCollection<String>[] aP3 ,
                        boolean[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             GXSimpleCollection<String>[] aP3 ,
                             boolean[] aP4 )
   {
      geterroresliqleg.this.AV11CliCod = aP0;
      geterroresliqleg.this.AV8EmpCod = aP1;
      geterroresliqleg.this.AV12LiqNro = aP2;
      geterroresliqleg.this.aP3 = aP3;
      geterroresliqleg.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02DR2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV12LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A891LiqLegError = P02DR2_A891LiqLegError[0] ;
         A31LiqNro = P02DR2_A31LiqNro[0] ;
         A1EmpCod = P02DR2_A1EmpCod[0] ;
         A3CliCod = P02DR2_A3CliCod[0] ;
         A6LegNumero = P02DR2_A6LegNumero[0] ;
         AV9hay = true ;
         AV10LiqLegError.add(A891LiqLegError, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = geterroresliqleg.this.AV10LiqLegError;
      this.aP4[0] = geterroresliqleg.this.AV9hay;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10LiqLegError = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      P02DR2_A891LiqLegError = new String[] {""} ;
      P02DR2_A31LiqNro = new int[1] ;
      P02DR2_A1EmpCod = new short[1] ;
      P02DR2_A3CliCod = new int[1] ;
      P02DR2_A6LegNumero = new int[1] ;
      A891LiqLegError = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.geterroresliqleg__default(),
         new Object[] {
             new Object[] {
            P02DR2_A891LiqLegError, P02DR2_A31LiqNro, P02DR2_A1EmpCod, P02DR2_A3CliCod, P02DR2_A6LegNumero
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV12LiqNro ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private String scmdbuf ;
   private boolean AV9hay ;
   private String A891LiqLegError ;
   private boolean[] aP4 ;
   private GXSimpleCollection<String>[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P02DR2_A891LiqLegError ;
   private int[] P02DR2_A31LiqNro ;
   private short[] P02DR2_A1EmpCod ;
   private int[] P02DR2_A3CliCod ;
   private int[] P02DR2_A6LegNumero ;
   private GXSimpleCollection<String> AV10LiqLegError ;
}

final  class geterroresliqleg__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02DR2", "SELECT LiqLegError, LiqNro, EmpCod, CliCod, LegNumero FROM LiquidacionLegajo WHERE (CliCod = ? and EmpCod = ? and LiqNro = ?) AND (Not (char_length(trim(trailing ' ' from LiqLegError))=0)) ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
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

