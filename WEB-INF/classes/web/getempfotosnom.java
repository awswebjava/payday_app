package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getempfotosnom extends GXProcedure
{
   public getempfotosnom( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getempfotosnom.class ), "" );
   }

   public getempfotosnom( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             String[] aP2 )
   {
      getempfotosnom.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String[] aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String[] aP2 ,
                             String[] aP3 )
   {
      getempfotosnom.this.AV9CliCod = aP0;
      getempfotosnom.this.AV8EmpCod = aP1;
      getempfotosnom.this.aP2 = aP2;
      getempfotosnom.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02462 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV8EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P02462_A1EmpCod[0] ;
         A3CliCod = P02462_A3CliCod[0] ;
         A956EmpLogoNom = P02462_A956EmpLogoNom[0] ;
         n956EmpLogoNom = P02462_n956EmpLogoNom[0] ;
         A959EmpFirmaNom = P02462_A959EmpFirmaNom[0] ;
         n959EmpFirmaNom = P02462_n959EmpFirmaNom[0] ;
         AV10EmpLogoNom = A956EmpLogoNom ;
         AV11EmpFirmaNom = A959EmpFirmaNom ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getempfotosnom.this.AV10EmpLogoNom;
      this.aP3[0] = getempfotosnom.this.AV11EmpFirmaNom;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10EmpLogoNom = "" ;
      AV11EmpFirmaNom = "" ;
      scmdbuf = "" ;
      P02462_A1EmpCod = new short[1] ;
      P02462_A3CliCod = new int[1] ;
      P02462_A956EmpLogoNom = new String[] {""} ;
      P02462_n956EmpLogoNom = new boolean[] {false} ;
      P02462_A959EmpFirmaNom = new String[] {""} ;
      P02462_n959EmpFirmaNom = new boolean[] {false} ;
      A956EmpLogoNom = "" ;
      A959EmpFirmaNom = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getempfotosnom__default(),
         new Object[] {
             new Object[] {
            P02462_A1EmpCod, P02462_A3CliCod, P02462_A956EmpLogoNom, P02462_n956EmpLogoNom, P02462_A959EmpFirmaNom, P02462_n959EmpFirmaNom
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private String scmdbuf ;
   private boolean n956EmpLogoNom ;
   private boolean n959EmpFirmaNom ;
   private String AV10EmpLogoNom ;
   private String AV11EmpFirmaNom ;
   private String A956EmpLogoNom ;
   private String A959EmpFirmaNom ;
   private String[] aP3 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P02462_A1EmpCod ;
   private int[] P02462_A3CliCod ;
   private String[] P02462_A956EmpLogoNom ;
   private boolean[] P02462_n956EmpLogoNom ;
   private String[] P02462_A959EmpFirmaNom ;
   private boolean[] P02462_n959EmpFirmaNom ;
}

final  class getempfotosnom__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02462", "SELECT EmpCod, CliCod, EmpLogoNom, EmpFirmaNom FROM Empresa WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
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

