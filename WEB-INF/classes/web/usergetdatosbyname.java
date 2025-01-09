package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class usergetdatosbyname extends GXProcedure
{
   public usergetdatosbyname( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( usergetdatosbyname.class ), "" );
   }

   public usergetdatosbyname( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String[] aP1 ,
                             String[] aP2 )
   {
      usergetdatosbyname.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 ,
                        String[] aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 ,
                             String[] aP2 ,
                             String[] aP3 )
   {
      usergetdatosbyname.this.AV8SecUserName = aP0;
      usergetdatosbyname.this.aP1 = aP1;
      usergetdatosbyname.this.aP2 = aP2;
      usergetdatosbyname.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00C32 */
      pr_default.execute(0, new Object[] {AV8SecUserName});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1923RolId = P00C32_A1923RolId[0] ;
         n1923RolId = P00C32_n1923RolId[0] ;
         A68SecUserName = P00C32_A68SecUserName[0] ;
         A359SecUserPerName = P00C32_A359SecUserPerName[0] ;
         A360SecUserPerLastName = P00C32_A360SecUserPerLastName[0] ;
         A1924RolNombre = P00C32_A1924RolNombre[0] ;
         A67SecUserId = P00C32_A67SecUserId[0] ;
         A1924RolNombre = P00C32_A1924RolNombre[0] ;
         AV9SecUserPerName = A359SecUserPerName ;
         AV10SecUserPerLastName = A360SecUserPerLastName ;
         AV11RolNombre = A1924RolNombre ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = usergetdatosbyname.this.AV9SecUserPerName;
      this.aP2[0] = usergetdatosbyname.this.AV10SecUserPerLastName;
      this.aP3[0] = usergetdatosbyname.this.AV11RolNombre;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9SecUserPerName = "" ;
      AV10SecUserPerLastName = "" ;
      AV11RolNombre = "" ;
      scmdbuf = "" ;
      P00C32_A1923RolId = new byte[1] ;
      P00C32_n1923RolId = new boolean[] {false} ;
      P00C32_A68SecUserName = new String[] {""} ;
      P00C32_A359SecUserPerName = new String[] {""} ;
      P00C32_A360SecUserPerLastName = new String[] {""} ;
      P00C32_A1924RolNombre = new String[] {""} ;
      P00C32_A67SecUserId = new short[1] ;
      A68SecUserName = "" ;
      A359SecUserPerName = "" ;
      A360SecUserPerLastName = "" ;
      A1924RolNombre = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.usergetdatosbyname__default(),
         new Object[] {
             new Object[] {
            P00C32_A1923RolId, P00C32_n1923RolId, P00C32_A68SecUserName, P00C32_A359SecUserPerName, P00C32_A360SecUserPerLastName, P00C32_A1924RolNombre, P00C32_A67SecUserId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A1923RolId ;
   private short A67SecUserId ;
   private short Gx_err ;
   private String scmdbuf ;
   private boolean n1923RolId ;
   private String AV8SecUserName ;
   private String AV9SecUserPerName ;
   private String AV10SecUserPerLastName ;
   private String AV11RolNombre ;
   private String A68SecUserName ;
   private String A359SecUserPerName ;
   private String A360SecUserPerLastName ;
   private String A1924RolNombre ;
   private String[] aP3 ;
   private String[] aP1 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private byte[] P00C32_A1923RolId ;
   private boolean[] P00C32_n1923RolId ;
   private String[] P00C32_A68SecUserName ;
   private String[] P00C32_A359SecUserPerName ;
   private String[] P00C32_A360SecUserPerLastName ;
   private String[] P00C32_A1924RolNombre ;
   private short[] P00C32_A67SecUserId ;
}

final  class usergetdatosbyname__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00C32", "SELECT T1.RolId, T1.SecUserName, T1.SecUserPerName, T1.SecUserPerLastName, T2.RolNombre, T1.SecUserId FROM (SecUser T1 LEFT JOIN RolUsuario T2 ON T2.RolId = T1.RolId) WHERE T1.SecUserName = ( ?) ORDER BY T1.SecUserName  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((short[]) buf[6])[0] = rslt.getShort(6);
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
               stmt.setVarchar(1, (String)parms[0], 100);
               return;
      }
   }

}

