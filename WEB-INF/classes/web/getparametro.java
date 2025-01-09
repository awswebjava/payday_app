package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getparametro extends GXProcedure
{
   public getparametro( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getparametro.class ), "" );
   }

   public getparametro( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 )
   {
      getparametro.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      getparametro.this.AV11CliCod = aP0;
      getparametro.this.AV8ParmCod = aP1;
      getparametro.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV13key = GXutil.trim( AV16Pgmname) + "_" + GXutil.trim( GXutil.str( AV11CliCod, 6, 0)) + "_" + GXutil.trim( AV8ParmCod) ;
      GXv_char1[0] = AV9ParmValue ;
      new web.obtenerdesesion(remoteHandle, context).execute( AV13key, GXv_char1) ;
      getparametro.this.AV9ParmValue = GXv_char1[0] ;
      if ( (GXutil.strcmp("", AV9ParmValue)==0) )
      {
         AV17GXLvl11 = (byte)(0) ;
         /* Using cursor P00512 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), AV8ParmCod});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A61ParmCod = P00512_A61ParmCod[0] ;
            A3CliCod = P00512_A3CliCod[0] ;
            A316ParmValue = P00512_A316ParmValue[0] ;
            AV17GXLvl11 = (byte)(1) ;
            AV9ParmValue = A316ParmValue ;
            new web.setearensesion(remoteHandle, context).execute( AV13key, GXutil.trim( AV9ParmValue)) ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         if ( AV17GXLvl11 == 0 )
         {
            if ( ! (GXutil.strcmp("", AV8ParmCod)==0) )
            {
               GXv_char1[0] = AV10Default ;
               new web.defaultparametros(remoteHandle, context).execute( AV11CliCod, AV8ParmCod, false, "", GXv_char1) ;
               getparametro.this.AV10Default = GXv_char1[0] ;
               if ( ! (GXutil.strcmp("", AV10Default)==0) )
               {
                  AV9ParmValue = AV10Default ;
                  new web.setearensesion(remoteHandle, context).execute( AV13key, GXutil.trim( AV9ParmValue)) ;
               }
            }
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getparametro.this.AV9ParmValue;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9ParmValue = "" ;
      AV13key = "" ;
      AV16Pgmname = "" ;
      scmdbuf = "" ;
      P00512_A61ParmCod = new String[] {""} ;
      P00512_A3CliCod = new int[1] ;
      P00512_A316ParmValue = new String[] {""} ;
      A61ParmCod = "" ;
      A316ParmValue = "" ;
      AV10Default = "" ;
      GXv_char1 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getparametro__default(),
         new Object[] {
             new Object[] {
            P00512_A61ParmCod, P00512_A3CliCod, P00512_A316ParmValue
            }
         }
      );
      AV16Pgmname = "getParametro" ;
      /* GeneXus formulas. */
      AV16Pgmname = "getParametro" ;
      Gx_err = (short)(0) ;
   }

   private byte AV17GXLvl11 ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int A3CliCod ;
   private String AV8ParmCod ;
   private String AV16Pgmname ;
   private String scmdbuf ;
   private String A61ParmCod ;
   private String GXv_char1[] ;
   private String A316ParmValue ;
   private String AV9ParmValue ;
   private String AV13key ;
   private String AV10Default ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P00512_A61ParmCod ;
   private int[] P00512_A3CliCod ;
   private String[] P00512_A316ParmValue ;
}

final  class getparametro__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00512", "SELECT ParmCod, CliCod, ParmValue FROM Param WHERE CliCod = ? and ParmCod = ( ?) ORDER BY CliCod, ParmCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 30);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
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

