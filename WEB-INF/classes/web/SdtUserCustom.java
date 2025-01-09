package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtUserCustom extends GxSilentTrnSdt
{
   public SdtUserCustom( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtUserCustom.class));
   }

   public SdtUserCustom( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle, context, "SdtUserCustom");
      initialize( remoteHandle) ;
   }

   public SdtUserCustom( int remoteHandle ,
                         StructSdtUserCustom struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public void Load( String AV770UserId ,
                     String AV771UserCustomKey )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {AV770UserId,AV771UserCustomKey});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"UserId", String.class}, new Object[]{"UserCustomKey", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "UserCustom");
      metadata.set("BT", "UserCustom");
      metadata.set("PK", "[ \"UserId\",\"UserCustomKey\" ]");
      metadata.set("AllowInsert", "True");
      metadata.set("AllowUpdate", "True");
      metadata.set("AllowDelete", "True");
      return metadata ;
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "UserId") )
            {
               gxTv_SdtUserCustom_Userid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UserCustomKey") )
            {
               gxTv_SdtUserCustom_Usercustomkey = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UserCustomValue") )
            {
               gxTv_SdtUserCustom_Usercustomvalue = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtUserCustom_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtUserCustom_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UserId_Z") )
            {
               gxTv_SdtUserCustom_Userid_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UserCustomKey_Z") )
            {
               gxTv_SdtUserCustom_Usercustomkey_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "UserCustom" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "PayDay" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("UserId", gxTv_SdtUserCustom_Userid);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("UserCustomKey", gxTv_SdtUserCustom_Usercustomkey);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("UserCustomValue", gxTv_SdtUserCustom_Usercustomvalue);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtUserCustom_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtUserCustom_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("UserId_Z", gxTv_SdtUserCustom_Userid_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("UserCustomKey_Z", gxTv_SdtUserCustom_Usercustomkey_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("UserId", gxTv_SdtUserCustom_Userid, false, includeNonInitialized);
      AddObjectProperty("UserCustomKey", gxTv_SdtUserCustom_Usercustomkey, false, includeNonInitialized);
      AddObjectProperty("UserCustomValue", gxTv_SdtUserCustom_Usercustomvalue, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtUserCustom_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtUserCustom_Initialized, false, includeNonInitialized);
         AddObjectProperty("UserId_Z", gxTv_SdtUserCustom_Userid_Z, false, includeNonInitialized);
         AddObjectProperty("UserCustomKey_Z", gxTv_SdtUserCustom_Usercustomkey_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtUserCustom sdt )
   {
      if ( sdt.IsDirty("UserId") )
      {
         gxTv_SdtUserCustom_N = (byte)(0) ;
         gxTv_SdtUserCustom_Userid = sdt.getgxTv_SdtUserCustom_Userid() ;
      }
      if ( sdt.IsDirty("UserCustomKey") )
      {
         gxTv_SdtUserCustom_N = (byte)(0) ;
         gxTv_SdtUserCustom_Usercustomkey = sdt.getgxTv_SdtUserCustom_Usercustomkey() ;
      }
      if ( sdt.IsDirty("UserCustomValue") )
      {
         gxTv_SdtUserCustom_N = (byte)(0) ;
         gxTv_SdtUserCustom_Usercustomvalue = sdt.getgxTv_SdtUserCustom_Usercustomvalue() ;
      }
   }

   public String getgxTv_SdtUserCustom_Userid( )
   {
      return gxTv_SdtUserCustom_Userid ;
   }

   public void setgxTv_SdtUserCustom_Userid( String value )
   {
      gxTv_SdtUserCustom_N = (byte)(0) ;
      if ( GXutil.strcmp(gxTv_SdtUserCustom_Userid, value) != 0 )
      {
         gxTv_SdtUserCustom_Mode = "INS" ;
         this.setgxTv_SdtUserCustom_Userid_Z_SetNull( );
         this.setgxTv_SdtUserCustom_Usercustomkey_Z_SetNull( );
      }
      SetDirty("Userid");
      gxTv_SdtUserCustom_Userid = value ;
   }

   public String getgxTv_SdtUserCustom_Usercustomkey( )
   {
      return gxTv_SdtUserCustom_Usercustomkey ;
   }

   public void setgxTv_SdtUserCustom_Usercustomkey( String value )
   {
      gxTv_SdtUserCustom_N = (byte)(0) ;
      if ( GXutil.strcmp(gxTv_SdtUserCustom_Usercustomkey, value) != 0 )
      {
         gxTv_SdtUserCustom_Mode = "INS" ;
         this.setgxTv_SdtUserCustom_Userid_Z_SetNull( );
         this.setgxTv_SdtUserCustom_Usercustomkey_Z_SetNull( );
      }
      SetDirty("Usercustomkey");
      gxTv_SdtUserCustom_Usercustomkey = value ;
   }

   public String getgxTv_SdtUserCustom_Usercustomvalue( )
   {
      return gxTv_SdtUserCustom_Usercustomvalue ;
   }

   public void setgxTv_SdtUserCustom_Usercustomvalue( String value )
   {
      gxTv_SdtUserCustom_N = (byte)(0) ;
      SetDirty("Usercustomvalue");
      gxTv_SdtUserCustom_Usercustomvalue = value ;
   }

   public String getgxTv_SdtUserCustom_Mode( )
   {
      return gxTv_SdtUserCustom_Mode ;
   }

   public void setgxTv_SdtUserCustom_Mode( String value )
   {
      gxTv_SdtUserCustom_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtUserCustom_Mode = value ;
   }

   public void setgxTv_SdtUserCustom_Mode_SetNull( )
   {
      gxTv_SdtUserCustom_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtUserCustom_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtUserCustom_Initialized( )
   {
      return gxTv_SdtUserCustom_Initialized ;
   }

   public void setgxTv_SdtUserCustom_Initialized( short value )
   {
      gxTv_SdtUserCustom_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtUserCustom_Initialized = value ;
   }

   public void setgxTv_SdtUserCustom_Initialized_SetNull( )
   {
      gxTv_SdtUserCustom_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtUserCustom_Initialized_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtUserCustom_Userid_Z( )
   {
      return gxTv_SdtUserCustom_Userid_Z ;
   }

   public void setgxTv_SdtUserCustom_Userid_Z( String value )
   {
      gxTv_SdtUserCustom_N = (byte)(0) ;
      SetDirty("Userid_Z");
      gxTv_SdtUserCustom_Userid_Z = value ;
   }

   public void setgxTv_SdtUserCustom_Userid_Z_SetNull( )
   {
      gxTv_SdtUserCustom_Userid_Z = "" ;
      SetDirty("Userid_Z");
   }

   public boolean getgxTv_SdtUserCustom_Userid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtUserCustom_Usercustomkey_Z( )
   {
      return gxTv_SdtUserCustom_Usercustomkey_Z ;
   }

   public void setgxTv_SdtUserCustom_Usercustomkey_Z( String value )
   {
      gxTv_SdtUserCustom_N = (byte)(0) ;
      SetDirty("Usercustomkey_Z");
      gxTv_SdtUserCustom_Usercustomkey_Z = value ;
   }

   public void setgxTv_SdtUserCustom_Usercustomkey_Z_SetNull( )
   {
      gxTv_SdtUserCustom_Usercustomkey_Z = "" ;
      SetDirty("Usercustomkey_Z");
   }

   public boolean getgxTv_SdtUserCustom_Usercustomkey_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.usercustom_bc obj;
      obj = new web.usercustom_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtUserCustom_Userid = "" ;
      gxTv_SdtUserCustom_N = (byte)(1) ;
      gxTv_SdtUserCustom_Usercustomkey = "" ;
      gxTv_SdtUserCustom_Usercustomvalue = "" ;
      gxTv_SdtUserCustom_Mode = "" ;
      gxTv_SdtUserCustom_Userid_Z = "" ;
      gxTv_SdtUserCustom_Usercustomkey_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtUserCustom_N ;
   }

   public web.SdtUserCustom Clone( )
   {
      web.SdtUserCustom sdt;
      web.usercustom_bc obj;
      sdt = (web.SdtUserCustom)(clone()) ;
      obj = (web.usercustom_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtUserCustom struct )
   {
      setgxTv_SdtUserCustom_Userid(struct.getUserid());
      setgxTv_SdtUserCustom_Usercustomkey(struct.getUsercustomkey());
      setgxTv_SdtUserCustom_Usercustomvalue(struct.getUsercustomvalue());
      setgxTv_SdtUserCustom_Mode(struct.getMode());
      setgxTv_SdtUserCustom_Initialized(struct.getInitialized());
      setgxTv_SdtUserCustom_Userid_Z(struct.getUserid_Z());
      setgxTv_SdtUserCustom_Usercustomkey_Z(struct.getUsercustomkey_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtUserCustom getStruct( )
   {
      web.StructSdtUserCustom struct = new web.StructSdtUserCustom ();
      struct.setUserid(getgxTv_SdtUserCustom_Userid());
      struct.setUsercustomkey(getgxTv_SdtUserCustom_Usercustomkey());
      struct.setUsercustomvalue(getgxTv_SdtUserCustom_Usercustomvalue());
      struct.setMode(getgxTv_SdtUserCustom_Mode());
      struct.setInitialized(getgxTv_SdtUserCustom_Initialized());
      struct.setUserid_Z(getgxTv_SdtUserCustom_Userid_Z());
      struct.setUsercustomkey_Z(getgxTv_SdtUserCustom_Usercustomkey_Z());
      return struct ;
   }

   private byte gxTv_SdtUserCustom_N ;
   private short gxTv_SdtUserCustom_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtUserCustom_Mode ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtUserCustom_Usercustomvalue ;
   private String gxTv_SdtUserCustom_Userid ;
   private String gxTv_SdtUserCustom_Usercustomkey ;
   private String gxTv_SdtUserCustom_Userid_Z ;
   private String gxTv_SdtUserCustom_Usercustomkey_Z ;
}

