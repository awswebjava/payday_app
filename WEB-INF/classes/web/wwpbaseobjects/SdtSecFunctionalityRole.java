package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSecFunctionalityRole extends GxSilentTrnSdt
{
   public SdtSecFunctionalityRole( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtSecFunctionalityRole.class));
   }

   public SdtSecFunctionalityRole( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle, context, "SdtSecFunctionalityRole");
      initialize( remoteHandle) ;
   }

   public SdtSecFunctionalityRole( int remoteHandle ,
                                   StructSdtSecFunctionalityRole struct )
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

   public void Load( long AV62SecFunctionalityId ,
                     short AV65SecRoleId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Long.valueOf(AV62SecFunctionalityId),Short.valueOf(AV65SecRoleId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"SecFunctionalityId", long.class}, new Object[]{"SecRoleId", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "WWPBaseObjects\\SecFunctionalityRole");
      metadata.set("BT", "SecFunctionalityRole");
      metadata.set("PK", "[ \"SecFunctionalityId\",\"SecRoleId\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"SecFunctionalityId\" ],\"FKMap\":[  ] },{ \"FK\":[ \"SecRoleId\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecFunctionalityId") )
            {
               gxTv_SdtSecFunctionalityRole_Secfunctionalityid = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecFunctionalityDescription") )
            {
               gxTv_SdtSecFunctionalityRole_Secfunctionalitydescription = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecRoleId") )
            {
               gxTv_SdtSecFunctionalityRole_Secroleid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtSecFunctionalityRole_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtSecFunctionalityRole_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecFunctionalityId_Z") )
            {
               gxTv_SdtSecFunctionalityRole_Secfunctionalityid_Z = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecFunctionalityDescription_Z") )
            {
               gxTv_SdtSecFunctionalityRole_Secfunctionalitydescription_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecRoleId_Z") )
            {
               gxTv_SdtSecFunctionalityRole_Secroleid_Z = (short)(getnumericvalue(oReader.getValue())) ;
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
         sName = "SecFunctionalityRole" ;
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
      oWriter.writeElement("SecFunctionalityId", GXutil.trim( GXutil.str( gxTv_SdtSecFunctionalityRole_Secfunctionalityid, 10, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SecFunctionalityDescription", gxTv_SdtSecFunctionalityRole_Secfunctionalitydescription);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SecRoleId", GXutil.trim( GXutil.str( gxTv_SdtSecFunctionalityRole_Secroleid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtSecFunctionalityRole_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtSecFunctionalityRole_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SecFunctionalityId_Z", GXutil.trim( GXutil.str( gxTv_SdtSecFunctionalityRole_Secfunctionalityid_Z, 10, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SecFunctionalityDescription_Z", gxTv_SdtSecFunctionalityRole_Secfunctionalitydescription_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SecRoleId_Z", GXutil.trim( GXutil.str( gxTv_SdtSecFunctionalityRole_Secroleid_Z, 4, 0)));
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
      AddObjectProperty("SecFunctionalityId", gxTv_SdtSecFunctionalityRole_Secfunctionalityid, false, includeNonInitialized);
      AddObjectProperty("SecFunctionalityDescription", gxTv_SdtSecFunctionalityRole_Secfunctionalitydescription, false, includeNonInitialized);
      AddObjectProperty("SecRoleId", gxTv_SdtSecFunctionalityRole_Secroleid, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtSecFunctionalityRole_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtSecFunctionalityRole_Initialized, false, includeNonInitialized);
         AddObjectProperty("SecFunctionalityId_Z", gxTv_SdtSecFunctionalityRole_Secfunctionalityid_Z, false, includeNonInitialized);
         AddObjectProperty("SecFunctionalityDescription_Z", gxTv_SdtSecFunctionalityRole_Secfunctionalitydescription_Z, false, includeNonInitialized);
         AddObjectProperty("SecRoleId_Z", gxTv_SdtSecFunctionalityRole_Secroleid_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.wwpbaseobjects.SdtSecFunctionalityRole sdt )
   {
      if ( sdt.IsDirty("SecFunctionalityId") )
      {
         gxTv_SdtSecFunctionalityRole_N = (byte)(0) ;
         gxTv_SdtSecFunctionalityRole_Secfunctionalityid = sdt.getgxTv_SdtSecFunctionalityRole_Secfunctionalityid() ;
      }
      if ( sdt.IsDirty("SecFunctionalityDescription") )
      {
         gxTv_SdtSecFunctionalityRole_N = (byte)(0) ;
         gxTv_SdtSecFunctionalityRole_Secfunctionalitydescription = sdt.getgxTv_SdtSecFunctionalityRole_Secfunctionalitydescription() ;
      }
      if ( sdt.IsDirty("SecRoleId") )
      {
         gxTv_SdtSecFunctionalityRole_N = (byte)(0) ;
         gxTv_SdtSecFunctionalityRole_Secroleid = sdt.getgxTv_SdtSecFunctionalityRole_Secroleid() ;
      }
   }

   public long getgxTv_SdtSecFunctionalityRole_Secfunctionalityid( )
   {
      return gxTv_SdtSecFunctionalityRole_Secfunctionalityid ;
   }

   public void setgxTv_SdtSecFunctionalityRole_Secfunctionalityid( long value )
   {
      gxTv_SdtSecFunctionalityRole_N = (byte)(0) ;
      if ( gxTv_SdtSecFunctionalityRole_Secfunctionalityid != value )
      {
         gxTv_SdtSecFunctionalityRole_Mode = "INS" ;
         this.setgxTv_SdtSecFunctionalityRole_Secfunctionalityid_Z_SetNull( );
         this.setgxTv_SdtSecFunctionalityRole_Secfunctionalitydescription_Z_SetNull( );
         this.setgxTv_SdtSecFunctionalityRole_Secroleid_Z_SetNull( );
      }
      SetDirty("Secfunctionalityid");
      gxTv_SdtSecFunctionalityRole_Secfunctionalityid = value ;
   }

   public String getgxTv_SdtSecFunctionalityRole_Secfunctionalitydescription( )
   {
      return gxTv_SdtSecFunctionalityRole_Secfunctionalitydescription ;
   }

   public void setgxTv_SdtSecFunctionalityRole_Secfunctionalitydescription( String value )
   {
      gxTv_SdtSecFunctionalityRole_N = (byte)(0) ;
      SetDirty("Secfunctionalitydescription");
      gxTv_SdtSecFunctionalityRole_Secfunctionalitydescription = value ;
   }

   public short getgxTv_SdtSecFunctionalityRole_Secroleid( )
   {
      return gxTv_SdtSecFunctionalityRole_Secroleid ;
   }

   public void setgxTv_SdtSecFunctionalityRole_Secroleid( short value )
   {
      gxTv_SdtSecFunctionalityRole_N = (byte)(0) ;
      if ( gxTv_SdtSecFunctionalityRole_Secroleid != value )
      {
         gxTv_SdtSecFunctionalityRole_Mode = "INS" ;
         this.setgxTv_SdtSecFunctionalityRole_Secfunctionalityid_Z_SetNull( );
         this.setgxTv_SdtSecFunctionalityRole_Secfunctionalitydescription_Z_SetNull( );
         this.setgxTv_SdtSecFunctionalityRole_Secroleid_Z_SetNull( );
      }
      SetDirty("Secroleid");
      gxTv_SdtSecFunctionalityRole_Secroleid = value ;
   }

   public String getgxTv_SdtSecFunctionalityRole_Mode( )
   {
      return gxTv_SdtSecFunctionalityRole_Mode ;
   }

   public void setgxTv_SdtSecFunctionalityRole_Mode( String value )
   {
      gxTv_SdtSecFunctionalityRole_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtSecFunctionalityRole_Mode = value ;
   }

   public void setgxTv_SdtSecFunctionalityRole_Mode_SetNull( )
   {
      gxTv_SdtSecFunctionalityRole_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtSecFunctionalityRole_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtSecFunctionalityRole_Initialized( )
   {
      return gxTv_SdtSecFunctionalityRole_Initialized ;
   }

   public void setgxTv_SdtSecFunctionalityRole_Initialized( short value )
   {
      gxTv_SdtSecFunctionalityRole_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtSecFunctionalityRole_Initialized = value ;
   }

   public void setgxTv_SdtSecFunctionalityRole_Initialized_SetNull( )
   {
      gxTv_SdtSecFunctionalityRole_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtSecFunctionalityRole_Initialized_IsNull( )
   {
      return false ;
   }

   public long getgxTv_SdtSecFunctionalityRole_Secfunctionalityid_Z( )
   {
      return gxTv_SdtSecFunctionalityRole_Secfunctionalityid_Z ;
   }

   public void setgxTv_SdtSecFunctionalityRole_Secfunctionalityid_Z( long value )
   {
      gxTv_SdtSecFunctionalityRole_N = (byte)(0) ;
      SetDirty("Secfunctionalityid_Z");
      gxTv_SdtSecFunctionalityRole_Secfunctionalityid_Z = value ;
   }

   public void setgxTv_SdtSecFunctionalityRole_Secfunctionalityid_Z_SetNull( )
   {
      gxTv_SdtSecFunctionalityRole_Secfunctionalityid_Z = 0 ;
      SetDirty("Secfunctionalityid_Z");
   }

   public boolean getgxTv_SdtSecFunctionalityRole_Secfunctionalityid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtSecFunctionalityRole_Secfunctionalitydescription_Z( )
   {
      return gxTv_SdtSecFunctionalityRole_Secfunctionalitydescription_Z ;
   }

   public void setgxTv_SdtSecFunctionalityRole_Secfunctionalitydescription_Z( String value )
   {
      gxTv_SdtSecFunctionalityRole_N = (byte)(0) ;
      SetDirty("Secfunctionalitydescription_Z");
      gxTv_SdtSecFunctionalityRole_Secfunctionalitydescription_Z = value ;
   }

   public void setgxTv_SdtSecFunctionalityRole_Secfunctionalitydescription_Z_SetNull( )
   {
      gxTv_SdtSecFunctionalityRole_Secfunctionalitydescription_Z = "" ;
      SetDirty("Secfunctionalitydescription_Z");
   }

   public boolean getgxTv_SdtSecFunctionalityRole_Secfunctionalitydescription_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtSecFunctionalityRole_Secroleid_Z( )
   {
      return gxTv_SdtSecFunctionalityRole_Secroleid_Z ;
   }

   public void setgxTv_SdtSecFunctionalityRole_Secroleid_Z( short value )
   {
      gxTv_SdtSecFunctionalityRole_N = (byte)(0) ;
      SetDirty("Secroleid_Z");
      gxTv_SdtSecFunctionalityRole_Secroleid_Z = value ;
   }

   public void setgxTv_SdtSecFunctionalityRole_Secroleid_Z_SetNull( )
   {
      gxTv_SdtSecFunctionalityRole_Secroleid_Z = (short)(0) ;
      SetDirty("Secroleid_Z");
   }

   public boolean getgxTv_SdtSecFunctionalityRole_Secroleid_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.wwpbaseobjects.secfunctionalityrole_bc obj;
      obj = new web.wwpbaseobjects.secfunctionalityrole_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtSecFunctionalityRole_N = (byte)(1) ;
      gxTv_SdtSecFunctionalityRole_Secfunctionalitydescription = "" ;
      gxTv_SdtSecFunctionalityRole_Mode = "" ;
      gxTv_SdtSecFunctionalityRole_Secfunctionalitydescription_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSecFunctionalityRole_N ;
   }

   public web.wwpbaseobjects.SdtSecFunctionalityRole Clone( )
   {
      web.wwpbaseobjects.SdtSecFunctionalityRole sdt;
      web.wwpbaseobjects.secfunctionalityrole_bc obj;
      sdt = (web.wwpbaseobjects.SdtSecFunctionalityRole)(clone()) ;
      obj = (web.wwpbaseobjects.secfunctionalityrole_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.wwpbaseobjects.StructSdtSecFunctionalityRole struct )
   {
      setgxTv_SdtSecFunctionalityRole_Secfunctionalityid(struct.getSecfunctionalityid());
      setgxTv_SdtSecFunctionalityRole_Secfunctionalitydescription(struct.getSecfunctionalitydescription());
      setgxTv_SdtSecFunctionalityRole_Secroleid(struct.getSecroleid());
      setgxTv_SdtSecFunctionalityRole_Mode(struct.getMode());
      setgxTv_SdtSecFunctionalityRole_Initialized(struct.getInitialized());
      setgxTv_SdtSecFunctionalityRole_Secfunctionalityid_Z(struct.getSecfunctionalityid_Z());
      setgxTv_SdtSecFunctionalityRole_Secfunctionalitydescription_Z(struct.getSecfunctionalitydescription_Z());
      setgxTv_SdtSecFunctionalityRole_Secroleid_Z(struct.getSecroleid_Z());
   }

   @SuppressWarnings("unchecked")
   public web.wwpbaseobjects.StructSdtSecFunctionalityRole getStruct( )
   {
      web.wwpbaseobjects.StructSdtSecFunctionalityRole struct = new web.wwpbaseobjects.StructSdtSecFunctionalityRole ();
      struct.setSecfunctionalityid(getgxTv_SdtSecFunctionalityRole_Secfunctionalityid());
      struct.setSecfunctionalitydescription(getgxTv_SdtSecFunctionalityRole_Secfunctionalitydescription());
      struct.setSecroleid(getgxTv_SdtSecFunctionalityRole_Secroleid());
      struct.setMode(getgxTv_SdtSecFunctionalityRole_Mode());
      struct.setInitialized(getgxTv_SdtSecFunctionalityRole_Initialized());
      struct.setSecfunctionalityid_Z(getgxTv_SdtSecFunctionalityRole_Secfunctionalityid_Z());
      struct.setSecfunctionalitydescription_Z(getgxTv_SdtSecFunctionalityRole_Secfunctionalitydescription_Z());
      struct.setSecroleid_Z(getgxTv_SdtSecFunctionalityRole_Secroleid_Z());
      return struct ;
   }

   private byte gxTv_SdtSecFunctionalityRole_N ;
   private short gxTv_SdtSecFunctionalityRole_Secroleid ;
   private short gxTv_SdtSecFunctionalityRole_Initialized ;
   private short gxTv_SdtSecFunctionalityRole_Secroleid_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private long gxTv_SdtSecFunctionalityRole_Secfunctionalityid ;
   private long gxTv_SdtSecFunctionalityRole_Secfunctionalityid_Z ;
   private String gxTv_SdtSecFunctionalityRole_Mode ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtSecFunctionalityRole_Secfunctionalitydescription ;
   private String gxTv_SdtSecFunctionalityRole_Secfunctionalitydescription_Z ;
}

