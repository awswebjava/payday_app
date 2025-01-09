package web ;
import com.genexus.*;

public final  class StructSdtsdt_control_parametros_sdt_control_parametrosItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_control_parametros_sdt_control_parametrosItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_control_parametros_sdt_control_parametrosItem.class ));
   }

   public StructSdtsdt_control_parametros_sdt_control_parametrosItem( int remoteHandle ,
                                                                      ModelContext context )
   {
      gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calparpalabra = "" ;
      gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calparvallista = "" ;
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

   public String getCalparpalabra( )
   {
      return gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calparpalabra ;
   }

   public void setCalparpalabra( String value )
   {
      gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calparpalabra = value ;
   }

   public byte getCalpargrp( )
   {
      return gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calpargrp ;
   }

   public void setCalpargrp( byte value )
   {
      gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calpargrp = value ;
   }

   public String getCalparvallista( )
   {
      return gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calparvallista ;
   }

   public void setCalparvallista( String value )
   {
      gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calparvallista = value ;
   }

   protected byte gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calpargrp ;
   protected byte gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_N ;
   protected String gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calparpalabra ;
   protected String gxTv_Sdtsdt_control_parametros_sdt_control_parametrosItem_Calparvallista ;
}

