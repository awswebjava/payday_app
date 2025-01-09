package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getpuestoextras extends GXProcedure
{
   public getpuestoextras( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getpuestoextras.class ), "" );
   }

   public getpuestoextras( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String aP2 )
   {
      getpuestoextras.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             boolean[] aP3 )
   {
      getpuestoextras.this.AV8CliCod = aP0;
      getpuestoextras.this.AV13SecCodigo = aP1;
      getpuestoextras.this.AV14PuestoCodigo = aP2;
      getpuestoextras.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01CU2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV13SecCodigo, AV14PuestoCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1240PuestoCodigo = P01CU2_A1240PuestoCodigo[0] ;
         A13SecCodigo = P01CU2_A13SecCodigo[0] ;
         A3CliCod = P01CU2_A3CliCod[0] ;
         A1255PuestoHorasExt = P01CU2_A1255PuestoHorasExt[0] ;
         AV15PuestoHorasExt = A1255PuestoHorasExt ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getpuestoextras.this.AV15PuestoHorasExt;
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
      P01CU2_A1240PuestoCodigo = new String[] {""} ;
      P01CU2_A13SecCodigo = new String[] {""} ;
      P01CU2_A3CliCod = new int[1] ;
      P01CU2_A1255PuestoHorasExt = new boolean[] {false} ;
      A1240PuestoCodigo = "" ;
      A13SecCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getpuestoextras__default(),
         new Object[] {
             new Object[] {
            P01CU2_A1240PuestoCodigo, P01CU2_A13SecCodigo, P01CU2_A3CliCod, P01CU2_A1255PuestoHorasExt
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV13SecCodigo ;
   private String AV14PuestoCodigo ;
   private String scmdbuf ;
   private String A1240PuestoCodigo ;
   private String A13SecCodigo ;
   private boolean AV15PuestoHorasExt ;
   private boolean A1255PuestoHorasExt ;
   private boolean[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P01CU2_A1240PuestoCodigo ;
   private String[] P01CU2_A13SecCodigo ;
   private int[] P01CU2_A3CliCod ;
   private boolean[] P01CU2_A1255PuestoHorasExt ;
}

final  class getpuestoextras__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01CU2", "SELECT PuestoCodigo, SecCodigo, CliCod, PuestoHorasExt FROM Puesto WHERE CliCod = ? and SecCodigo = ( ?) and PuestoCodigo = ( ?) ORDER BY CliCod, SecCodigo, PuestoCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
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
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

