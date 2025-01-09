package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem extends GxUserType
{
   public Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem( )
   {
      this(  new ModelContext(Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem.class));
   }

   public Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem( ModelContext context )
   {
      super( context, "Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem");
   }

   public Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem( int remoteHandle ,
                                                                        ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem");
   }

   public Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem( StructSdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem struct )
   {
      this();
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitRevCodigo") )
            {
               gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevcodigo = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitRevDescrip") )
            {
               gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevdescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitRevEsBaja") )
            {
               gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevesbaja = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegSitRevDef") )
            {
               gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Megsitrevdef = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
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
         sName = "sdt_situacion_revista_afip.sdt_situacion_revista_afipItem" ;
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
      oWriter.writeElement("SitRevCodigo", GXutil.trim( GXutil.str( gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevcodigo, 3, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SitRevDescrip", gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevdescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SitRevEsBaja", GXutil.booltostr( gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevesbaja));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MegSitRevDef", GXutil.booltostr( gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Megsitrevdef));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
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
      AddObjectProperty("SitRevCodigo", gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevcodigo, false, false);
      AddObjectProperty("SitRevDescrip", gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevdescrip, false, false);
      AddObjectProperty("SitRevEsBaja", gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevesbaja, false, false);
      AddObjectProperty("MegSitRevDef", gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Megsitrevdef, false, false);
   }

   public short getgxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevcodigo( )
   {
      return gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevcodigo ;
   }

   public void setgxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevcodigo( short value )
   {
      gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevcodigo = value ;
   }

   public String getgxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevdescrip( )
   {
      return gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevdescrip ;
   }

   public void setgxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevdescrip( String value )
   {
      gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevdescrip = value ;
   }

   public boolean getgxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevesbaja( )
   {
      return gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevesbaja ;
   }

   public void setgxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevesbaja( boolean value )
   {
      gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevesbaja = value ;
   }

   public boolean getgxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Megsitrevdef( )
   {
      return gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Megsitrevdef ;
   }

   public void setgxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Megsitrevdef( boolean value )
   {
      gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Megsitrevdef = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_N = (byte)(1) ;
      gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevdescrip = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_N ;
   }

   public web.Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem Clone( )
   {
      return (web.Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem struct )
   {
      setgxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevcodigo(struct.getSitrevcodigo());
      setgxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevdescrip(struct.getSitrevdescrip());
      setgxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevesbaja(struct.getSitrevesbaja());
      setgxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Megsitrevdef(struct.getMegsitrevdef());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem getStruct( )
   {
      web.StructSdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem struct = new web.StructSdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem ();
      struct.setSitrevcodigo(getgxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevcodigo());
      struct.setSitrevdescrip(getgxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevdescrip());
      struct.setSitrevesbaja(getgxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevesbaja());
      struct.setMegsitrevdef(getgxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Megsitrevdef());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_N ;
   protected short gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevcodigo ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevesbaja ;
   protected boolean gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Megsitrevdef ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevdescrip ;
}

