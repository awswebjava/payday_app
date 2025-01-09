package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getpuesto extends GXProcedure
{
   public getpuesto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getpuesto.class ), "" );
   }

   public getpuesto( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String aP2 )
   {
      getpuesto.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 )
   {
      getpuesto.this.AV11CliCod = aP0;
      getpuesto.this.AV10SecCodigo = aP1;
      getpuesto.this.AV9PuestoCodigo = aP2;
      getpuesto.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P020S2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), AV10SecCodigo, AV9PuestoCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1240PuestoCodigo = P020S2_A1240PuestoCodigo[0] ;
         A13SecCodigo = P020S2_A13SecCodigo[0] ;
         A3CliCod = P020S2_A3CliCod[0] ;
         A1241PuestoDescrip = P020S2_A1241PuestoDescrip[0] ;
         AV8PuestoDescrip = A1241PuestoDescrip ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getpuesto.this.AV8PuestoDescrip;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8PuestoDescrip = "" ;
      scmdbuf = "" ;
      P020S2_A1240PuestoCodigo = new String[] {""} ;
      P020S2_A13SecCodigo = new String[] {""} ;
      P020S2_A3CliCod = new int[1] ;
      P020S2_A1241PuestoDescrip = new String[] {""} ;
      A1240PuestoCodigo = "" ;
      A13SecCodigo = "" ;
      A1241PuestoDescrip = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getpuesto__default(),
         new Object[] {
             new Object[] {
            P020S2_A1240PuestoCodigo, P020S2_A13SecCodigo, P020S2_A3CliCod, P020S2_A1241PuestoDescrip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV11CliCod ;
   private int A3CliCod ;
   private String AV10SecCodigo ;
   private String AV9PuestoCodigo ;
   private String scmdbuf ;
   private String A1240PuestoCodigo ;
   private String A13SecCodigo ;
   private String AV8PuestoDescrip ;
   private String A1241PuestoDescrip ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P020S2_A1240PuestoCodigo ;
   private String[] P020S2_A13SecCodigo ;
   private int[] P020S2_A3CliCod ;
   private String[] P020S2_A1241PuestoDescrip ;
}

final  class getpuesto__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P020S2", "SELECT PuestoCodigo, SecCodigo, CliCod, PuestoDescrip FROM Puesto WHERE CliCod = ? and SecCodigo = ( ?) and PuestoCodigo = ( ?) ORDER BY CliCod, SecCodigo, PuestoCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
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

