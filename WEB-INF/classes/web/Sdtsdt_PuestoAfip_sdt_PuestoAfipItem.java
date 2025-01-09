package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_PuestoAfip_sdt_PuestoAfipItem extends GxUserType
{
   public Sdtsdt_PuestoAfip_sdt_PuestoAfipItem( )
   {
      this(  new ModelContext(Sdtsdt_PuestoAfip_sdt_PuestoAfipItem.class));
   }

   public Sdtsdt_PuestoAfip_sdt_PuestoAfipItem( ModelContext context )
   {
      super( context, "Sdtsdt_PuestoAfip_sdt_PuestoAfipItem");
   }

   public Sdtsdt_PuestoAfip_sdt_PuestoAfipItem( int remoteHandle ,
                                                ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_PuestoAfip_sdt_PuestoAfipItem");
   }

   public Sdtsdt_PuestoAfip_sdt_PuestoAfipItem( StructSdtsdt_PuestoAfip_sdt_PuestoAfipItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PueAfipCod") )
            {
               gxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_Pueafipcod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PueAfipDes") )
            {
               gxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_Pueafipdes = oReader.getValue() ;
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
         sName = "sdt_PuestoAfip.sdt_PuestoAfipItem" ;
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
      oWriter.writeElement("PueAfipCod", gxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_Pueafipcod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PueAfipDes", gxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_Pueafipdes);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
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
      AddObjectProperty("PueAfipCod", gxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_Pueafipcod, false, false);
      AddObjectProperty("PueAfipDes", gxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_Pueafipdes, false, false);
   }

   public String getgxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_Pueafipcod( )
   {
      return gxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_Pueafipcod ;
   }

   public void setgxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_Pueafipcod( String value )
   {
      gxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_Pueafipcod = value ;
   }

   public String getgxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_Pueafipdes( )
   {
      return gxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_Pueafipdes ;
   }

   public void setgxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_Pueafipdes( String value )
   {
      gxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_N = (byte)(0) ;
      gxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_Pueafipdes = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_Pueafipcod = "" ;
      gxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_N = (byte)(1) ;
      gxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_Pueafipdes = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_N ;
   }

   public web.Sdtsdt_PuestoAfip_sdt_PuestoAfipItem Clone( )
   {
      return (web.Sdtsdt_PuestoAfip_sdt_PuestoAfipItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_PuestoAfip_sdt_PuestoAfipItem struct )
   {
      setgxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_Pueafipcod(struct.getPueafipcod());
      setgxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_Pueafipdes(struct.getPueafipdes());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_PuestoAfip_sdt_PuestoAfipItem getStruct( )
   {
      web.StructSdtsdt_PuestoAfip_sdt_PuestoAfipItem struct = new web.StructSdtsdt_PuestoAfip_sdt_PuestoAfipItem ();
      struct.setPueafipcod(getgxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_Pueafipcod());
      struct.setPueafipdes(getgxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_Pueafipdes());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_Pueafipcod ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_PuestoAfip_sdt_PuestoAfipItem_Pueafipdes ;
}

