package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getseccion extends GXProcedure
{
   public getseccion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getseccion.class ), "" );
   }

   public getseccion( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String[] aP2 )
   {
      getseccion.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             boolean[] aP3 )
   {
      getseccion.this.AV11CliCod = aP0;
      getseccion.this.AV9SecCodigo = aP1;
      getseccion.this.aP2 = aP2;
      getseccion.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P009X2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), AV9SecCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A13SecCodigo = P009X2_A13SecCodigo[0] ;
         A3CliCod = P009X2_A3CliCod[0] ;
         A329SecDescrip = P009X2_A329SecDescrip[0] ;
         AV10SecDescrip = A329SecDescrip ;
         AV12existe = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getseccion.this.AV10SecDescrip;
      this.aP3[0] = getseccion.this.AV12existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10SecDescrip = "" ;
      scmdbuf = "" ;
      P009X2_A13SecCodigo = new String[] {""} ;
      P009X2_A3CliCod = new int[1] ;
      P009X2_A329SecDescrip = new String[] {""} ;
      A13SecCodigo = "" ;
      A329SecDescrip = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getseccion__default(),
         new Object[] {
             new Object[] {
            P009X2_A13SecCodigo, P009X2_A3CliCod, P009X2_A329SecDescrip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV11CliCod ;
   private int A3CliCod ;
   private String AV9SecCodigo ;
   private String scmdbuf ;
   private String A13SecCodigo ;
   private boolean AV12existe ;
   private String AV10SecDescrip ;
   private String A329SecDescrip ;
   private boolean[] aP3 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P009X2_A13SecCodigo ;
   private int[] P009X2_A3CliCod ;
   private String[] P009X2_A329SecDescrip ;
}

final  class getseccion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P009X2", "SELECT SecCodigo, CliCod, SecDescrip FROM Seccion WHERE CliCod = ? and SecCodigo = ( ?) ORDER BY CliCod, SecCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
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
               return;
      }
   }

}

