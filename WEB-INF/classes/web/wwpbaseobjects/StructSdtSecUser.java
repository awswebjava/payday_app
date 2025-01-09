package web.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtSecUser implements Cloneable, java.io.Serializable
{
   public StructSdtSecUser( )
   {
      this( -1, new ModelContext( StructSdtSecUser.class ));
   }

   public StructSdtSecUser( int remoteHandle ,
                            ModelContext context )
   {
      gxTv_SdtSecUser_Secusername = "" ;
      gxTv_SdtSecUser_Secuserpassword = "" ;
      gxTv_SdtSecUser_Secuserempnom = "" ;
      gxTv_SdtSecUser_Secuserpername = "" ;
      gxTv_SdtSecUser_Secuserperlastname = "" ;
      gxTv_SdtSecUser_Secusertipempl = "" ;
      gxTv_SdtSecUser_Rolnombre = "" ;
      gxTv_SdtSecUser_Secusersal = "" ;
      gxTv_SdtSecUser_Mode = "" ;
      gxTv_SdtSecUser_Secusername_Z = "" ;
      gxTv_SdtSecUser_Secuserpassword_Z = "" ;
      gxTv_SdtSecUser_Secuserempnom_Z = "" ;
      gxTv_SdtSecUser_Secuserpername_Z = "" ;
      gxTv_SdtSecUser_Secuserperlastname_Z = "" ;
      gxTv_SdtSecUser_Secusertipempl_Z = "" ;
      gxTv_SdtSecUser_Rolnombre_Z = "" ;
      gxTv_SdtSecUser_Secusersal_Z = "" ;
      gxTv_SdtSecUser_Clicod_N = (byte)(1) ;
      gxTv_SdtSecUser_Secuserpaicod_N = (byte)(1) ;
      gxTv_SdtSecUser_Rolid_N = (byte)(1) ;
      gxTv_SdtSecUser_Perfilid_N = (byte)(1) ;
      gxTv_SdtSecUser_Menuverid_N = (byte)(1) ;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   public short getSecuserid( )
   {
      return gxTv_SdtSecUser_Secuserid ;
   }

   public void setSecuserid( short value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secuserid = value ;
   }

   public String getSecusername( )
   {
      return gxTv_SdtSecUser_Secusername ;
   }

   public void setSecusername( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secusername = value ;
   }

   public String getSecuserpassword( )
   {
      return gxTv_SdtSecUser_Secuserpassword ;
   }

   public void setSecuserpassword( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secuserpassword = value ;
   }

   public int getClicod( )
   {
      return gxTv_SdtSecUser_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_SdtSecUser_Clicod_N = (byte)(0) ;
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Clicod = value ;
   }

   public String getSecuserempnom( )
   {
      return gxTv_SdtSecUser_Secuserempnom ;
   }

   public void setSecuserempnom( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secuserempnom = value ;
   }

   public boolean getSecusuactivo( )
   {
      return gxTv_SdtSecUser_Secusuactivo ;
   }

   public void setSecusuactivo( boolean value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secusuactivo = value ;
   }

   public String getSecuserpername( )
   {
      return gxTv_SdtSecUser_Secuserpername ;
   }

   public void setSecuserpername( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secuserpername = value ;
   }

   public String getSecuserperlastname( )
   {
      return gxTv_SdtSecUser_Secuserperlastname ;
   }

   public void setSecuserperlastname( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secuserperlastname = value ;
   }

   public long getSecuserempcuit( )
   {
      return gxTv_SdtSecUser_Secuserempcuit ;
   }

   public void setSecuserempcuit( long value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secuserempcuit = value ;
   }

   public String getSecusertipempl( )
   {
      return gxTv_SdtSecUser_Secusertipempl ;
   }

   public void setSecusertipempl( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secusertipempl = value ;
   }

   public short getSecuserpaicod( )
   {
      return gxTv_SdtSecUser_Secuserpaicod ;
   }

   public void setSecuserpaicod( short value )
   {
      gxTv_SdtSecUser_Secuserpaicod_N = (byte)(0) ;
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secuserpaicod = value ;
   }

   public byte getRolid( )
   {
      return gxTv_SdtSecUser_Rolid ;
   }

   public void setRolid( byte value )
   {
      gxTv_SdtSecUser_Rolid_N = (byte)(0) ;
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Rolid = value ;
   }

   public byte getPerfilid( )
   {
      return gxTv_SdtSecUser_Perfilid ;
   }

   public void setPerfilid( byte value )
   {
      gxTv_SdtSecUser_Perfilid_N = (byte)(0) ;
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Perfilid = value ;
   }

   public long getMenuverid( )
   {
      return gxTv_SdtSecUser_Menuverid ;
   }

   public void setMenuverid( long value )
   {
      gxTv_SdtSecUser_Menuverid_N = (byte)(0) ;
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Menuverid = value ;
   }

   public String getRolnombre( )
   {
      return gxTv_SdtSecUser_Rolnombre ;
   }

   public void setRolnombre( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Rolnombre = value ;
   }

   public String getSecusersal( )
   {
      return gxTv_SdtSecUser_Secusersal ;
   }

   public void setSecusersal( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secusersal = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtSecUser_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtSecUser_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Initialized = value ;
   }

   public short getSecuserid_Z( )
   {
      return gxTv_SdtSecUser_Secuserid_Z ;
   }

   public void setSecuserid_Z( short value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secuserid_Z = value ;
   }

   public String getSecusername_Z( )
   {
      return gxTv_SdtSecUser_Secusername_Z ;
   }

   public void setSecusername_Z( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secusername_Z = value ;
   }

   public String getSecuserpassword_Z( )
   {
      return gxTv_SdtSecUser_Secuserpassword_Z ;
   }

   public void setSecuserpassword_Z( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secuserpassword_Z = value ;
   }

   public int getClicod_Z( )
   {
      return gxTv_SdtSecUser_Clicod_Z ;
   }

   public void setClicod_Z( int value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Clicod_Z = value ;
   }

   public String getSecuserempnom_Z( )
   {
      return gxTv_SdtSecUser_Secuserempnom_Z ;
   }

   public void setSecuserempnom_Z( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secuserempnom_Z = value ;
   }

   public boolean getSecusuactivo_Z( )
   {
      return gxTv_SdtSecUser_Secusuactivo_Z ;
   }

   public void setSecusuactivo_Z( boolean value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secusuactivo_Z = value ;
   }

   public String getSecuserpername_Z( )
   {
      return gxTv_SdtSecUser_Secuserpername_Z ;
   }

   public void setSecuserpername_Z( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secuserpername_Z = value ;
   }

   public String getSecuserperlastname_Z( )
   {
      return gxTv_SdtSecUser_Secuserperlastname_Z ;
   }

   public void setSecuserperlastname_Z( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secuserperlastname_Z = value ;
   }

   public long getSecuserempcuit_Z( )
   {
      return gxTv_SdtSecUser_Secuserempcuit_Z ;
   }

   public void setSecuserempcuit_Z( long value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secuserempcuit_Z = value ;
   }

   public String getSecusertipempl_Z( )
   {
      return gxTv_SdtSecUser_Secusertipempl_Z ;
   }

   public void setSecusertipempl_Z( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secusertipempl_Z = value ;
   }

   public short getSecuserpaicod_Z( )
   {
      return gxTv_SdtSecUser_Secuserpaicod_Z ;
   }

   public void setSecuserpaicod_Z( short value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secuserpaicod_Z = value ;
   }

   public byte getRolid_Z( )
   {
      return gxTv_SdtSecUser_Rolid_Z ;
   }

   public void setRolid_Z( byte value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Rolid_Z = value ;
   }

   public byte getPerfilid_Z( )
   {
      return gxTv_SdtSecUser_Perfilid_Z ;
   }

   public void setPerfilid_Z( byte value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Perfilid_Z = value ;
   }

   public long getMenuverid_Z( )
   {
      return gxTv_SdtSecUser_Menuverid_Z ;
   }

   public void setMenuverid_Z( long value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Menuverid_Z = value ;
   }

   public String getRolnombre_Z( )
   {
      return gxTv_SdtSecUser_Rolnombre_Z ;
   }

   public void setRolnombre_Z( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Rolnombre_Z = value ;
   }

   public String getSecusersal_Z( )
   {
      return gxTv_SdtSecUser_Secusersal_Z ;
   }

   public void setSecusersal_Z( String value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secusersal_Z = value ;
   }

   public byte getClicod_N( )
   {
      return gxTv_SdtSecUser_Clicod_N ;
   }

   public void setClicod_N( byte value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Clicod_N = value ;
   }

   public byte getSecuserpaicod_N( )
   {
      return gxTv_SdtSecUser_Secuserpaicod_N ;
   }

   public void setSecuserpaicod_N( byte value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Secuserpaicod_N = value ;
   }

   public byte getRolid_N( )
   {
      return gxTv_SdtSecUser_Rolid_N ;
   }

   public void setRolid_N( byte value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Rolid_N = value ;
   }

   public byte getPerfilid_N( )
   {
      return gxTv_SdtSecUser_Perfilid_N ;
   }

   public void setPerfilid_N( byte value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Perfilid_N = value ;
   }

   public byte getMenuverid_N( )
   {
      return gxTv_SdtSecUser_Menuverid_N ;
   }

   public void setMenuverid_N( byte value )
   {
      gxTv_SdtSecUser_N = (byte)(0) ;
      gxTv_SdtSecUser_Menuverid_N = value ;
   }

   protected byte gxTv_SdtSecUser_Rolid ;
   protected byte gxTv_SdtSecUser_Perfilid ;
   protected byte gxTv_SdtSecUser_Rolid_Z ;
   protected byte gxTv_SdtSecUser_Perfilid_Z ;
   protected byte gxTv_SdtSecUser_Clicod_N ;
   protected byte gxTv_SdtSecUser_Secuserpaicod_N ;
   protected byte gxTv_SdtSecUser_Rolid_N ;
   protected byte gxTv_SdtSecUser_Perfilid_N ;
   protected byte gxTv_SdtSecUser_Menuverid_N ;
   private byte gxTv_SdtSecUser_N ;
   protected short gxTv_SdtSecUser_Secuserid ;
   protected short gxTv_SdtSecUser_Secuserpaicod ;
   protected short gxTv_SdtSecUser_Initialized ;
   protected short gxTv_SdtSecUser_Secuserid_Z ;
   protected short gxTv_SdtSecUser_Secuserpaicod_Z ;
   protected int gxTv_SdtSecUser_Clicod ;
   protected int gxTv_SdtSecUser_Clicod_Z ;
   protected long gxTv_SdtSecUser_Secuserempcuit ;
   protected long gxTv_SdtSecUser_Menuverid ;
   protected long gxTv_SdtSecUser_Secuserempcuit_Z ;
   protected long gxTv_SdtSecUser_Menuverid_Z ;
   protected String gxTv_SdtSecUser_Secusertipempl ;
   protected String gxTv_SdtSecUser_Mode ;
   protected String gxTv_SdtSecUser_Secusertipempl_Z ;
   protected boolean gxTv_SdtSecUser_Secusuactivo ;
   protected boolean gxTv_SdtSecUser_Secusuactivo_Z ;
   protected String gxTv_SdtSecUser_Secusername ;
   protected String gxTv_SdtSecUser_Secuserpassword ;
   protected String gxTv_SdtSecUser_Secuserempnom ;
   protected String gxTv_SdtSecUser_Secuserpername ;
   protected String gxTv_SdtSecUser_Secuserperlastname ;
   protected String gxTv_SdtSecUser_Rolnombre ;
   protected String gxTv_SdtSecUser_Secusersal ;
   protected String gxTv_SdtSecUser_Secusername_Z ;
   protected String gxTv_SdtSecUser_Secuserpassword_Z ;
   protected String gxTv_SdtSecUser_Secuserempnom_Z ;
   protected String gxTv_SdtSecUser_Secuserpername_Z ;
   protected String gxTv_SdtSecUser_Secuserperlastname_Z ;
   protected String gxTv_SdtSecUser_Rolnombre_Z ;
   protected String gxTv_SdtSecUser_Secusersal_Z ;
}

