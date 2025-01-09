package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class new_zona extends GXProcedure
{
   public new_zona( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( new_zona.class ), "" );
   }

   public new_zona( int remoteHandle ,
                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( String aP0 ,
                        String aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String aP1 )
   {
      new_zona.this.AV10ZonDescrip = aP0;
      new_zona.this.AV8zoncod = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00IU2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         A342ZonDescrip = P00IU2_A342ZonDescrip[0] ;
         A20ZonCod = P00IU2_A20ZonCod[0] ;
         if ( ( GXutil.strSearch( A20ZonCod, AV8zoncod+" ", 1) > 0 ) && ( GXutil.strcmp(A342ZonDescrip, httpContext.getMessage( "Buenos Aires - Vicente Lopez", "")) != 0 ) )
         {
            AV9Z = (short)(AV9Z+1) ;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      /*
         INSERT RECORD ON TABLE Zona

      */
      if ( AV9Z > 0 )
      {
         A20ZonCod = GXutil.trim( AV8zoncod) + " " + GXutil.trim( GXutil.str( AV9Z, 4, 0)) ;
      }
      else
      {
         A20ZonCod = GXutil.trim( AV8zoncod) ;
      }
      A342ZonDescrip = GXutil.trim( AV10ZonDescrip) ;
      if ( ( GXutil.strSearch( GXutil.upper( AV10ZonDescrip), httpContext.getMessage( "RESTO DE LA PROVINCIA", ""), 1) != 0 ) || ( GXutil.strSearch( AV10ZonDescrip, "-", 1) == 0 ) )
      {
         A2223ZonLocEs = false ;
      }
      else
      {
         A2223ZonLocEs = true ;
      }
      GXv_char1[0] = AV12auxZonDescrip ;
      new web.sacaracentos2(remoteHandle, context).execute( AV10ZonDescrip, GXv_char1) ;
      new_zona.this.AV12auxZonDescrip = GXv_char1[0] ;
      A678ZonDescripSinAc = GXutil.upper( AV12auxZonDescrip) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "con mayusculas queda ", "")+A678ZonDescripSinAc) ;
      AV11collection = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV10ZonDescrip,"-")) ;
      if ( AV11collection.size() > 1 )
      {
         A589ZonProvincia = GXutil.trim( (String)AV11collection.elementAt(-1+1)) ;
      }
      else
      {
         A589ZonProvincia = GXutil.trim( AV10ZonDescrip) ;
      }
      A343ZonPorcReduc = DecimalUtil.doubleToDec(1) ;
      A2264zonAfipCod = AV8zoncod ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "zonAfipCod ", "")+A2264zonAfipCod) ;
      /* Using cursor P00IU3 */
      pr_default.execute(1, new Object[] {A20ZonCod, A342ZonDescrip, A589ZonProvincia, A343ZonPorcReduc, A678ZonDescripSinAc, Boolean.valueOf(A2223ZonLocEs), A2264zonAfipCod});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Zona");
      if ( (pr_default.getStatus(1) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      cleanup();
   }

   protected void cleanup( )
   {
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
      P00IU2_A342ZonDescrip = new String[] {""} ;
      P00IU2_A20ZonCod = new String[] {""} ;
      A342ZonDescrip = "" ;
      A20ZonCod = "" ;
      AV12auxZonDescrip = "" ;
      GXv_char1 = new String[1] ;
      A678ZonDescripSinAc = "" ;
      AV16Pgmname = "" ;
      AV11collection = new GXSimpleCollection<String>(String.class, "internal", "");
      A589ZonProvincia = "" ;
      A343ZonPorcReduc = DecimalUtil.ZERO ;
      A2264zonAfipCod = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.new_zona__default(),
         new Object[] {
             new Object[] {
            P00IU2_A342ZonDescrip, P00IU2_A20ZonCod
            }
            , new Object[] {
            }
         }
      );
      AV16Pgmname = "new_zona" ;
      /* GeneXus formulas. */
      AV16Pgmname = "new_zona" ;
      Gx_err = (short)(0) ;
   }

   private short AV9Z ;
   private short Gx_err ;
   private int GX_INS48 ;
   private java.math.BigDecimal A343ZonPorcReduc ;
   private String AV8zoncod ;
   private String scmdbuf ;
   private String A20ZonCod ;
   private String GXv_char1[] ;
   private String AV16Pgmname ;
   private String A2264zonAfipCod ;
   private String Gx_emsg ;
   private boolean A2223ZonLocEs ;
   private String AV10ZonDescrip ;
   private String A342ZonDescrip ;
   private String AV12auxZonDescrip ;
   private String A678ZonDescripSinAc ;
   private String A589ZonProvincia ;
   private IDataStoreProvider pr_default ;
   private String[] P00IU2_A342ZonDescrip ;
   private String[] P00IU2_A20ZonCod ;
   private GXSimpleCollection<String> AV11collection ;
}

final  class new_zona__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00IU2", "SELECT ZonDescrip, ZonCod FROM Zona ORDER BY ZonCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00IU3", "SAVEPOINT gxupdate;INSERT INTO Zona(ZonCod, ZonDescrip, ZonProvincia, ZonPorcReduc, ZonDescripSinAc, ZonLocEs, zonAfipCod, ZonPorcAumenDed) VALUES(?, ?, ?, ?, ?, ?, ?, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 1 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 2);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setString(7, (String)parms[6], 2);
               return;
      }
   }

}

